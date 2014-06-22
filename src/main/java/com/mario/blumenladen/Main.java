
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
    public static void main(String[] args) {
        Kunde    k = new Kunde("Anton Meier", "TEERTAL 8, \n9999 Nirgendwo");
        Rechnung r = new Rechnung(1);

        r.rechnungsempfänger = k;
        r.betrag             = 5000;
        r.rabatt             = 0.10;
        r.mehrwertsteuer     = 0.19;
        r.gebeAus();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
