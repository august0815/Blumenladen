
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

    void legeRabattFest(double neuerRabatt) {

        // TODO
    }

    void legeMehwertsteuerFest(double neueMwSt) {

        // TODO
    }

    void legePostenHinzu(int anzahl, double einzelpreis) {

        // TODO
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
