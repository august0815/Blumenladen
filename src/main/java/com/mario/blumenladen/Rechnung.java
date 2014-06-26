
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.mario.blumenladen;

//~--- non-JDK imports --------------------------------------------------------

import com.mario.blumenladen.kunde.Kunde;
import com.mario.blumenladen.kunde.PremiumKunde;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mario
 */
public class Rechnung {
    private static int    naechsteRechnungsnummer     = 1000;
    static final double   STANDART_MEHRWERTSTEUERSATZ = 0.19;
    List<Rechnungsposten> posten                      = new LinkedList<Rechnungsposten>();
    int                   postenAnzahl                = 0;
    private double        betrag                      = 200;
    double                rabatt;
    Kunde                 rechnungsempfänger;
    final int             rechnungsnummer;

    /**
     * Constructs ...
     * erzeugt einen neue Rechnung fur den Kunden
     *
     * @param empf ist der Rechnungsempfänger
     */
    public Rechnung(Kunde empf) {
        this.rechnungsempfänger = empf;
        this.rechnungsnummer    = Rechnung.berechneNaechsteRechnungsnummer();
    }

    static void setNaechsteRechnungsnummer(int nummer) {
        naechsteRechnungsnummer = nummer;
    }

    static int berechneNaechsteRechnungsnummer() {
        return Rechnung.naechsteRechnungsnummer++;
    }

    /**
     *
     * @return
     */
    public int getRechnungsnummer() {
        return rechnungsnummer;
    }

    /**
     *
     * @return
     */
    public Kunde getRechnungsempfänger() {
        return rechnungsempfänger;
    }

    public void setRechnungsempfänger(PremiumKunde rechnungsempfänger) {
        this.rechnungsempfänger = rechnungsempfänger;
    }

    /**
     *
     * @return
     */
    public double getRabatt() {
        return rabatt;
    }

    void gebeAus() {
        gebeAus(new PrintWriter(System.out));
    }

    private void gebeAus(PrintWriter pw) {
        pw.println("Rechnung Nr. " + this.rechnungsnummer);
        pw.println("An:");
        pw.println(this.getRechnungsempfänger().getName());

        // pw.println(this.getRechnungsempfänger().
        // getAnschrift());
        pw.println("Artikel:");

        for (Rechnungsposten rp : posten) {
            pw.print(rp.getAnzahl() + " x Nr. " + rp.getArtikel().getArtikelnr());
            pw.println(" " + rp.getArtikel().getBeschreibung());
        }

        pw.println("Netto: " + this.berechneNettopreis());
        pw.println("MwSt: " + this.berechneMehrwertsteuer());
        pw.println("Brutto: " + this.berechneBruttopreis());
        pw.flush();
    }

    void speichern() {
        File f = new File(rechnungsnummer + ".txt");

        if (f.exists()) {
            System.out.println("Rechnungsdatei existiert schon, Rechnung wird deshalb nicht gespeichert.");
        }

        PrintWriter pw;

        try {
            pw = new PrintWriter(f);
            gebeAus(pw);
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Rechnungsdatei konnte nicht gefunden werden, Rechnung wird deshalb nicht gespeichert.");
        }
    }

    void setRabatt(final double neuerRabatt) throws UngueltigeRabattAusnahme {
        if ((neuerRabatt < 0) || (neuerRabatt > 1)) {
            throw new UngueltigeRabattAusnahme(neuerRabatt);
        }

        rabatt = neuerRabatt;

        // TODO Fehlerausgabe
    }

    void fuegePostenHinzu(final Rechnungsposten rp) {
        this.posten.add(rp);
    }

    double berechneNettopreis() {
        double summe = 0;

        for (Rechnungsposten rp : posten) {
            summe += rp.berechneGesamtbetrag();
        }

        return summe * (1 - this.getRabatt());
    }

    double berechneBruttopreis() {
        return berechneNettopreis() + berechneMehrwertsteuer();
    }

    double berechneMehrwertsteuer() {
        double summe = 0;

        for (Rechnungsposten rp : posten) {
            summe += rp.berechneGesamtbetrag() * rp.getArtikel().getMehrwertsteuer();
        }

        return summe * (1 - this.getRabatt());
    }

    void aendereRechnungsempfaengetr(PremiumKunde neuerEmpfaenger) {
        this.rechnungsempfänger = neuerEmpfaenger;
    }

    public void legeBetragFest(int i) {}

    public int bestimmeRabatt() {
        if (rechnungsempfänger.getIstPremiumkunde()) {
            if (betrag >= 200) {
                return 10;
            } else {
                return 5;
            }
        } else {
            if (betrag >= 100) {
                return 5;
            } else {
                return 0;
            }
        }
    }

    public int bestimmeBetragInCent() {
        return 0;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
