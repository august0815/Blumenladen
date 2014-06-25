
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.mario.blumenladen;

import com.mario.blumenladen.kunde.Kunde;
import com.mario.blumenladen.kunde.PremiumKunde;

/**
 *
 * @author mario
 */
public class Rechnung {
    final static int    Max_Posten                  = 100;
    private static int  naechsteRechnungsnummer     = 1000;
    static final double STANDART_MEHRWERTSTEUERSATZ = 0.19;
    Rechnungsposten[]   posten                      = new Rechnungsposten[Rechnung.Max_Posten];
    int                 postenAnzahl                = 0;
    double              rabatt;
    PremiumKunde        rechnungsempfänger;
    final int           rechnungsnummer;

    /**
     * Constructs ...
     *
     *
     * @param empf
     */
    public Rechnung(PremiumKunde empf) {
        this.rechnungsempfänger = empf;
        this.rechnungsnummer    = Rechnung.berechneNaechsteRechnungsnummer();
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
        System.out.println("An:");
        System.out.println(this.rechnungsempfänger.getName());
        System.out.println(this.rechnungsempfänger.adresse);
        System.out.print("Rechnungsnummer: ");
        System.out.println(getRechnungsnummer());
        System.out.print("Netto : ");
        System.out.println(berechneNettopreis());
        System.out.print("MwSt: ");
        System.out.println(berechneMehrwertsteuer());
        System.out.print("Brutto: ");
        System.out.println(berechneBruttopreis());
    }

    void legeRabattFest(final double neuerRabatt) {
        if ((rabatt > 0) & (rabatt < 0.5)) {
            rabatt = neuerRabatt;
        }

        // TODO Fehlerausgabe
    }

    void fuegePostenHinzu(final Rechnungsposten posten) {
        if (postenAnzahl >= Rechnung.Max_Posten) {
            System.out.print("Zuviele Posten ");

            return;
        }

        this.posten[postenAnzahl] = posten;
        this.postenAnzahl++;
    }

    double berechneNettopreis() {
        double summe = 0;

        for (int i = 0; i < this.postenAnzahl; i++) {
            Rechnungsposten rp = this.posten[i];

            summe += rp.berechneGesamtbetrag();
        }

        return summe * (1 - this.getRabatt());
    }

    double berechneBruttopreis() {
        return berechneNettopreis() + berechneMehrwertsteuer();
    }

    double berechneMehrwertsteuer() {
        double summe = 0;

        for (int i = 0; i < this.postenAnzahl; i++) {
            Rechnungsposten rp = this.posten[i];

            summe += rp.berechneGesamtbetrag() * rp.getArtikel().getMehrwertsteuer();
        }

        return summe * (1 - this.getRabatt());
    }

    void aendereRechnungsempfaengetr(PremiumKunde neuerEmpfaenger) {
        this.rechnungsempfänger = neuerEmpfaenger;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
