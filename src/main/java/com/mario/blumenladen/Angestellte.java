
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
public class Angestellte extends Person {
    String anschrift;
    double gegalt;
    long   sozialversicherungsnr;

    /**
     * Constructs ...
     *
     *
     * @param name
     */
    public Angestellte(String name) {
        super(name);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return super.getName();    // To change body of generated methods, choose Tools | Templates.
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
