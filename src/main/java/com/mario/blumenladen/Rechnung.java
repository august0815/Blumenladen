
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

    void gebeAus() {
        double netto  = betrag * (1 - rabatt);
        double brutto = netto * (1 + mehrwertsteuer);

        System.out.println("An:");
        System.out.println(rechnungsempfänger.name);
        System.out.println(rechnungsempfänger.anschrift);
        System.out.println("Netto : ");
        System.out.println(netto);
        System.out.println("MwSt: ");
        System.out.println(mehrwertsteuer);
        System.out.println("Brutto: ");
        System.out.println(brutto);
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

    double liefereRabatt() {
        return rabatt;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
