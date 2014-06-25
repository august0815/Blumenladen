
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
public class Pflegemittel extends Zubehoer implements BegrenztHaltbar {
    private Datum haltbarkeitsDatum;

    /**
     *
     * @return
     */
    @Override
    public Datum getHaltbarkeit() {
        return this.haltbarkeitsDatum;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
