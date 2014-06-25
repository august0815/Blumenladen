
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.mario.blumenladen;

//~--- non-JDK imports --------------------------------------------------------

import com.mario.blumenladen.kunde.Kunde;
import com.mario.blumenladen.kunde.PremiumKunde;
import com.mario.blumenladen.waren.Artikel;

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
        String       anschrift = "TEERTAL 8, \n9999 Nirgendwo";
        PremiumKunde k;
        Angestellte  an = new Angestellte("Hugo Egon");

        k         = new PremiumKunde("Anton Meier");
        k.adresse = anschrift;

        Rechnung          r = new Rechnung(k);
        Artikel           a, b, c;
        Rechnungsposten[] rp = new Rechnungsposten[10];

        a = new Artikel(1001, 5, "Blume");
        b = new Artikel(1002, 10, "Topf");
        c = new Artikel(1003, 20, "Erde");
        r.fuegePostenHinzu(new Rechnungsposten(10, a));
        r.fuegePostenHinzu(new Rechnungsposten(20, b));
        r.fuegePostenHinzu(new Rechnungsposten(30, c));
        r.rechnungsempfänger = k;
        r.rabatt             = 0.10;

        // r.mehrwertsteuer     = 0.19;
        System.out.println("Es bediente Sie  : " + an.getName());
        r.gebeAus();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
