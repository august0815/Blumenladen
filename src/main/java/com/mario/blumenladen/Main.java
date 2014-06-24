
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
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Kunde             k = new Kunde("Anton Meier", "TEERTAL 8, \n9999 Nirgendwo");
        Rechnung          r = new Rechnung(k);
        Artikel           a, b, c;
        Rechnungsposten[] rp = new Rechnungsposten[10];

        a = new Artikel(1001, "Blume", 5, 0.19);
        b = new Artikel(1002, "Topf", 10, 0.19);
        c = new Artikel(1003, "Erde", 15, 0.19);
        r.fuegePostenHinzu(new Rechnungsposten(10, a));
        r.fuegePostenHinzu(new Rechnungsposten(20, b));
        r.fuegePostenHinzu(new Rechnungsposten(30, c));
        r.rechnungsempfänger = k;
        r.rabatt             = 0.10;

        // r.mehrwertsteuer     = 0.19;
        r.gebeAus();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
