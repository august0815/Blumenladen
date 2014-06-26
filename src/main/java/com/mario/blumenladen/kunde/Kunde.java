
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.mario.blumenladen.kunde;

//~--- non-JDK imports --------------------------------------------------------

import com.mario.blumenladen.Person;

/**
 * Class description
 *
 *
 * @version        Enter version here..., 14/06/22
 * @author         Enter your name here...
 */
public class Kunde extends Person {
    boolean istPremiumkunde;

    /**
     * Constructs ...
     * erzeugt einen neuen Kunden mit gegebenem Namen
     *
     * @param name des Kunden
     */
    public Kunde(String name) {
        super(name);
    }

    /**
     * Constructs ...
     *
     *
     * @param name
     * @param anschrift
     */
    public Kunde(String name, String anschrift) {
        super(name);
    }

    /**
     *
     * @return
     */
    public boolean getIstPremiumkunde() {
        return istPremiumkunde;
    }

    /**
     *
     * @param istPremiumkunde
     */
    public void setIstPremiumkunde(boolean istPremiumkunde) {
        this.istPremiumkunde = istPremiumkunde;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
