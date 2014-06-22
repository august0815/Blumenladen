
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
    double betrag = 0;
    double mehrwertsteuer;
    double rabatt;
    Kunde  rechnungsempfänger;

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
        System.out.println("Netto : ");
        System.out.println(berechneNettopreis());
        System.out.println("MwSt: ");
        System.out.println(berechneMehrwertsteuer());
        System.out.println("Brutto: ");
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

    void legePostenHinzu(int anzahl, double einzelpreis) {
        betrag += anzahl + einzelpreis;
    }

    double berechneNettopreis() {
        return getBetrag() * (1 - getRabatt());
    }

    double berechneBruttopreis() {
        return berechneNettopreis() * (1 + getMehrwertsteuer());
    }

    double berechneMehrwertsteuer() {
        return getBetrag() * (1 - getRabatt()) * (getMehrwertsteuer());
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
