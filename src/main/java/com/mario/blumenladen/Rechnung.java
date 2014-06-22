
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.mario.blumenladen;

/**
 *
 * @author mario
 */
public class Rechnung {
    private static int naechsteRechnungsnummer = 1000;
    double             betrag                  = 0;
    double             mehrwertsteuer;
    double             rabatt;
    Kunde              rechnungsempfänger;
    final int          rechnungsnummer;

    /**
     * Constructs ...
     *
     *
     *
     */
    public Rechnung() {
        this(0.19);
    }

    /**
     * Constructs ...
     *
     *
     *
     * @param mwst
     */
    public Rechnung(double mwst) {
        this.rechnungsnummer = Rechnung.naechsteRechnungsnummer;
        Rechnung.naechsteRechnungsnummer++;
        this.mehrwertsteuer = mwst;
    }

    public int getRechnungsnummer() {
        return rechnungsnummer;
    }

    public double getMehrwertsteuer() {
        return mehrwertsteuer;
    }

    public Kunde getRechnungsempfänger() {
        return rechnungsempfänger;
    }

    public double getRabatt() {
        return rabatt;
    }

    public double getBetrag() {
        return betrag;
    }

    void gebeAus() {
        double netto  = betrag * (1 - rabatt);
        double brutto = netto * (1 + mehrwertsteuer);

        System.out.println("An:");
        System.out.println(this.rechnungsempfänger.getName());
        System.out.println(this.rechnungsempfänger.getAnschrift());
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

    void legeMehwertsteuerFest(double neueMwSt) {
        mehrwertsteuer = neueMwSt;
    }

    void fuegePostenHinzu(Rechnungsposten posten) {
        betrag += posten.berechneGesamtbetrag();
    }

    double berechneNettopreis() {
        return getBetrag() * (1 - getRabatt());
    }

    double berechneBruttopreis() {
        return berechneNettopreis() + berechneMehrwertsteuer();
    }

    double berechneMehrwertsteuer() {
        return getBetrag() * (1 - getRabatt()) * (getMehrwertsteuer());
    }

    void aendereRechnungsempfaengetr(Kunde neuerEmpfaenger) {
        this.rechnungsempfänger = neuerEmpfaenger;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
