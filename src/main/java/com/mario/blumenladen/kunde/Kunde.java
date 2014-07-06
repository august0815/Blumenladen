/*
 * Copyright (C) 2014 mario.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
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
    String  anschrift;

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
        this.anschrift = anschrift;
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

    public String getAnschrift() {
        return anschrift;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
