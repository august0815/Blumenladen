
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.mario.blumenladen;

//~--- non-JDK imports --------------------------------------------------------

/**
 *
 * @author mario
 */
import com.mario.blumenladen.kunde.Kunde;
import com.mario.blumenladen.waren.Artikel;

//~--- JDK imports ------------------------------------------------------------

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class description
 *
 *
 * @version        Enter version here..., 14/06/25
 * @author         Enter your name here...
 */
public class Kassenanwendung {
    private static final String artikeldatei         = "artikelliste.txt";
    private static final String rechnungsnummerdatei = "rechnungsnummer.txt";
    private BufferedReader      br;
    private Map<Long, Artikel>  artikeldaten;

    Kassenanwendung() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * TODO
     */
    public void ausfuehren() {
        try {
            initialisiereRechnungsnummer();
        } catch (InitException e) {
            System.err.println("Fehler bei der Initialisierung der Rechnungsnummer:");
            System.err.println(e.getMessage());
        }

        // starteKassenmenu();
        try {
            speichereRechnungsnummer();
        } catch (InitException e) {
            System.err.println("Fehler beim Abspeichern der Rechnungsnummer:");
            System.err.println(e.getMessage());
        }
    }

    /**
     *
     * @throws InitException
     */
    public Map<Long, Artikel> leseArtikelEin(Connection con) throws InitException {
        try {
            Statement stmt;
            ResultSet rs;
            Artikel   a = null;

            this.artikeldaten = new HashMap<Long, Artikel>();
            stmt              = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT * FROM artikel";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                a = erzeugeArtikel(rs);
                artikeldaten.put(a.getArtikelnr(), a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Kassenanwendung.class.getName()).log(Level.SEVERE, null, ex);
        }

        return artikeldaten;
    }

    public Map<Long, Artikel> getArtikeldaten() {
        return artikeldaten;
    }

    private Artikel erzeugeArtikel(ResultSet rs) {
        long   nummer       = 0;
        double preis        = 0;
        double mwst         = 0.19;
        String beschreibung = "";

        try {
            nummer       = rs.getInt("NUMMER");
            preis        = Double.parseDouble(rs.getString("PREIS"));
            beschreibung = rs.getString("BESCHREIBUNG");
        } catch (SQLException ex) {
            Logger.getLogger(Kassenanwendung.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new Artikel(nummer, beschreibung, preis, mwst);
    }

    public void initialisiereRechnungsnummer() throws InitException {
        File f      = new File(rechnungsnummerdatei);
        int  nummer = -1;

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));

            try {
                String zeile = br.readLine();

                nummer = Integer.parseInt(zeile);
                Rechnung.setNaechsteRechnungsnummer(nummer);
            } finally {
                br.close();
            }
        } catch (FileNotFoundException e) {
            throw new InitException("Die Datei mit der naechsten Rechnungsnummer "
                                    + "konnte nicht gefunden werde. Standardnummer wird verwendet");
        } catch (IOException e) {
            throw new InitException("Fehler beim Lesen der Datei mit der naechsten "
                                    + "Rechnungsnummer. Standardnummer wird verwendet.");
        } catch (NumberFormatException e) {
            throw new InitException("Die Datei mit der naechsten Rechnungsnummer "
                                    + "weist ungueltigen Inhalt auf. Standardnummer wird verwendet.");
        }
    }

    public void speichereRechnungsnummer() throws InitException {
        File f = new File(rechnungsnummerdatei);

        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                throw new InitException("Die Datei mit der naechsten Rechnungsnummer "
                                        + "konnte nicht gefunden werde. Standardnummer wird verwendet");
            }
        }

        try {
            PrintWriter pw = new PrintWriter(f);

            pw.println(Rechnung.berechneNaechsteRechnungsnummer());
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            throw new InitException("In die Datei für die naechsten Rechnungsnummer konnte " + "gefunden werden.");
        }
    }

    private void starteKassenmenu() {

        // zeigeKassenmenu();
        try {
            String eingabe = br.readLine();

            while ((br != null) &&!"2".equals(eingabe.trim())) {
                if ("1".equals(eingabe.trim())) {
                    erzeugeNeueRechnung();
                } else {
                    System.out.println("Ungueltige Eingabe! Waehlen Sie erneut.");
                }

                zeigeKassenmenu();
                eingabe = br.readLine();
            }

            System.out.println("Auf Wiedersehen!");
        } catch (IOException e) {
            System.err.println("Es gibt Probleme mit der Ein- und Ausgabe. "
                               + "Das Programm muss deshalb beendet werden.");
        }
    }

    private void zeigeKassenmenu() {

        // setAusgabe("TEST");
        System.out.println("1 - Neue Rechnung");
        System.out.println("2 - Beenden");
    }

    private void erzeugeNeueRechnung() {
        Kunde empfaenger;

        try {
            empfaenger = erzeugeNeuenKunden();
        } catch (CreationException e) {
            System.err.println("Fehler bei der Erzeugung eines neuen Kunden.");
            System.err.println(e.getMessage());
            System.err.println("Die Rechnungserstellung wird abgebrochen");

            return;
        }

        Rechnung r = new Rechnung(empfaenger);
        String   eingabe;

        try {
            rechnungspostenHinzufuegen(r);
            r.gebeAus();
        } catch (CreationException e) {
            System.err.println("Fehler beim Hinzufügen der Rechnungsposten");
            System.err.println(e.getMessage());
            System.err.println("Die Rechnungserstellung wird abgebrochen.");
        }

        System.out.println("Wollen Sie die Rechnung speichern? (ja/nein)");

        while (true) {
            try {
                eingabe = br.readLine();
            } catch (IOException e) {
                System.err.println("Fehler bei der Ein- und Ausgabe. Rechnung " + "kann nicht gespeichert werden");

                return;
            }

            if ("ja".equals(eingabe)) {
                r.speichern();

                break;
            } else if (!"nein".equals(eingabe)) {
                System.out.println("Bitte antworten Sie mit ja oder nein.");
            }
        }
    }

    private void erzeugeNeueRechnung1() {
        Kunde empfaenger;

        try {
            empfaenger = erzeugeNeuenKunden();
        } catch (CreationException e) {
            System.err.println("Fehler bei der Erzeugung eines neuen Kunden.");
            System.err.println(e.getMessage());
            System.err.println("Die Rechnungserstellung wird abgebrochen");

            return;
        }

        Rechnung r = new Rechnung(empfaenger);
        String   eingabe;

        try {
            rechnungspostenHinzufuegen(r);
            r.gebeAus();
        } catch (CreationException e) {
            System.err.println("Fehler beim Hinzufügen der Rechnungsposten");
            System.err.println(e.getMessage());
            System.err.println("Die Rechnungserstellung wird abgebrochen.");
        }

        System.out.println("Wollen Sie die Rechnung speichern? (ja/nein)");

        while (true) {
            try {
                eingabe = br.readLine();
            } catch (IOException e) {
                System.err.println("Fehler bei der Ein- und Ausgabe. Rechnung " + "kann nicht gespeichert werden");

                return;
            }

            if ("ja".equals(eingabe)) {
                r.speichern();

                break;
            } else if (!"nein".equals(eingabe)) {
                System.out.println("Bitte antworten Sie mit ja oder nein.");
            }
        }
    }

    private void rechnungspostenHinzufuegen(Rechnung r) throws CreationException {
        String eingabe;

        while (true) {
            System.out.println("Geben Sie nun die Artikelnummer des naechsten Artikels an "
                               + "oder ENDE um die Rechnungserstellung abzuschliessen:");

            try {
                eingabe = br.readLine();
            } catch (IOException e) {
                throw new CreationException("Fehler bei der Ein- und Ausgabe.");
            }

            if ((eingabe == null) || "ENDE".equals(eingabe.trim())) {
                break;
            }

            int artikelnummer;

            try {
                artikelnummer = Integer.parseInt(eingabe);
            } catch (NumberFormatException e) {
                System.err.println("Ungueltige Eingabe");

                continue;
            }

            Artikel a = erfrageArtikel(artikelnummer);

            if (a == null) {
                System.out.println("Der Artikel mit der Nummer " + artikelnummer + " konnte nicht gefunden werden.");

                continue;
            }

            int anzahl;

            while (true) {
                System.out.println("Geben Sie nun die Anzahl fuer diesen Artikel an, "
                                   + "ABR um diesen Rechnungsposten nicht hinzuzufuegen:");

                try {
                    eingabe = br.readLine();
                } catch (IOException e) {
                    throw new CreationException("Fehler bei der Ein- und Ausgabe.");
                }

                if ((eingabe == null) || "ABR".equals(eingabe.trim())) {
                    break;
                }

                try {
                    anzahl = Integer.parseInt(eingabe);
                    r.fuegePostenHinzu(new Rechnungsposten(anzahl, a));

                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Ungueltige Eingabe");

                    continue;
                }
            }
        }
    }

    private Artikel erfrageArtikel(long artikelnummer) {
        return this.artikeldaten.get(artikelnummer);
    }

    private Kunde erzeugeNeuenKunden() throws CreationException {
        try {
            System.out.println("Geben Sie bitte den Namen des Kunden ein:");

            String name = br.readLine();

            System.out.println("Geben Sie bitte die Anschrift des Kunden ein:");

            String anschrift = br.readLine();

            return new Kunde(name, anschrift);
        } catch (IOException e) {
            throw new CreationException("Es gibt Probleme mit der Ein- und Ausgabe.");
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
