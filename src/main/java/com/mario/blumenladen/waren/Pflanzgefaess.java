
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.mario.blumenladen.waren;

/**
 *
 * @author mario
 */
public abstract class Pflanzgefaess extends Artikel {
    private int    farbcode;
    private double hoehe;

    /**
     * Constructs ...
     *
     *
     * @param artikelnr
     * @param preis
     */
    public Pflanzgefaess(long artikelnr, double preis) {
        super(artikelnr, preis);
    }

    /**
     *
     * @return
     */
    public abstract double berechneVolumen();
}


//~ Formatted by Jindent --- http://www.jindent.com
