
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.mario.blumenladen.kunde;

/**
 *
 * @author mario
 */
public class PremiumKunde extends Kunde {
    int kundenNr;

    /** Field description */
    public String adresse;

    /**
     * Constructs ...
     * erzeugt einen neuen PremiumKunden mit gegebenem Namen
     *
     * @param name
     */
    public PremiumKunde(String name) {
        super(name);
        setIstPremiumkunde(true);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
