
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.mario.blumenladen;

/**
 * Class description
 *
 *
 * @version        Enter version here..., 14/06/22
 * @author         Enter your name here...
 */
public class Kunde {
    String name;
    String anschrift;

    /**
     * Constructs ...
     *
     *
     * @param name
     * @param anschrift
     */
    public Kunde(String name, String anschrift) {
        this.name      = name;
        this.anschrift = anschrift;
    }

    void setName(final String neuerName) {
        this.name = neuerName;
    }

    /**
     *
     * @return
     */
    public String getAnschrift() {
        return anschrift;
    }

    /**
     *
     * @param anschrift
     */
    public void setAnschrift(String anschrift) {
        this.anschrift = anschrift;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
