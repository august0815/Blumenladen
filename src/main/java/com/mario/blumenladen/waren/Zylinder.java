
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
public class Zylinder extends Topf {

    /**
     * Constructs ...
     *
     *
     * @param artikelnr
     * @param preis
     * @param h
     * @param o
     * @param u
     */
    public Zylinder(long artikelnr, double preis, double h, double o, double u) {
        super(artikelnr, preis, h, o, u);
    }

    @Override
    public double berechneVolumen() {
        throw new UnsupportedOperationException("Not supported yet.");    // To change body of generated methods, choose Tools | Templates.
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
