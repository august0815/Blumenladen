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
