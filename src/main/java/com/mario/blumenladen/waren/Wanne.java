
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.mario.blumenladen.waren;

/**
 * Class description
 *
 *
 * @version        Enter version here..., 14/06/25
 * @author         Enter your name here...    
 */
public class Wanne extends Pflanzgefaess {

    /**
     * Constructs ...
     *
     *
     * @param artikelnr
     * @param preis
     */
    public Wanne(long artikelnr, double preis) {
        super(artikelnr, preis);
    }

    @Override
    public double berechneVolumen() {
        throw new UnsupportedOperationException("Not supported yet.");    // To change body of generated methods, choose Tools | Templates.
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
