
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
public class Topf extends Pflanzgefaess {
    private double durchmesserOben;
    private double durchmesserUnten;
    private double hoehe;

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
    public Topf(long artikelnr, double preis, double h, double o, double u) {
        super(artikelnr, preis);
        this.hoehe            = h;
        this.durchmesserOben  = o;
        this.durchmesserUnten = u;
    }

    @Override
    public double berechneVolumen() {
        throw new UnsupportedOperationException("Not supported yet.");    // To change body of generated methods, choose Tools | Templates.
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
