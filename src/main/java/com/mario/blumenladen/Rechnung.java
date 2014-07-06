
/*
 * Copyright (C) 2014 mario.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.mario.blumenladen;

//~--- non-JDK imports --------------------------------------------------------

import com.mario.blumenladen.kunde.Kunde;
import com.mario.blumenladen.kunde.PremiumKunde;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.text.DecimalFormat;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mario
 */
public class Rechnung {
    private static int    naechsteRechnungsnummer     = 1000;
    static final double   STANDART_MEHRWERTSTEUERSATZ = 0.19;
    List<Rechnungsposten> posten                      = new LinkedList<>();
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

    /**
     *
     * @param rechnungsempfänger
     */
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

    String gebeAus() {
        String s = "";

        s += ("Rechnung Nr. " + this.rechnungsnummer + "\n");
        s += ("An:" + "\n");
        s += (this.getRechnungsempfänger().getName() + "\n");

        if (this.getRechnungsempfänger().getIstPremiumkunde()) {
            s += (this.getRechnungsempfänger().getAnschrift() + "\n\n");
        }

        s += ("Artikel:" + "\n");

        for (Rechnungsposten rp : posten) {
            s += (rp.getAnzahl() + " x Nr. " + rp.getArtikel().getArtikelnr());
            s += (" " + rp.getArtikel().getBeschreibung() + "\n");
        }

        s += ("Netto: " + new DecimalFormat("#.## €").format(this.berechneNettopreis()) + "\n");
        s += ("MwSt: " + new DecimalFormat("#.## €").format(this.berechneMehrwertsteuer()) + "\n");
        s += ("Brutto: " + new DecimalFormat("#.## €").format(this.berechneBruttopreis()) + "\n");

        return s;
    }

    private void gebeAus(PrintWriter pw) {
        pw.println("Rechnung Nr. " + this.rechnungsnummer);
        pw.println("An:");
        pw.println(this.getRechnungsempfänger().getName());

        if (this.getRechnungsempfänger().getIstPremiumkunde()) {
            pw.println(this.getRechnungsempfänger().getAnschrift() + "\n\n");
        }

        pw.println("Artikel:");

        for (Rechnungsposten rp : posten) {
            pw.print(rp.getAnzahl() + " x Nr. " + rp.getArtikel().getArtikelnr());
            pw.println(" " + rp.getArtikel().getBeschreibung());
        }

        pw.println("Netto: " + new DecimalFormat("#.## €").format(this.berechneNettopreis()));
        pw.println("MwSt: " + new DecimalFormat("#.## €").format(this.berechneMehrwertsteuer()));
        pw.println("Brutto: " + new DecimalFormat("#.## €").format(this.berechneBruttopreis()));
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

        System.out.println("Set Rabatt " + rabatt);
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

    /**
     *
     * @param i
     */
    public void legeBetragFest(int i) {}

    /**
     *
     * @return
     */
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

    /**
     *
     * @return
     */
    public int bestimmeBetragInCent() {
        return 0;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
