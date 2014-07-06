
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
 *
 * @author mario
 */
public class Pflanze extends Artikel {
    private double lagertemperatur;

    /**
     * Constructs ...
     *
     *
     * @param artikelnr
     * @param preis
     * @param lagertemp
     */
    public Pflanze(long artikelnr, double preis, double lagertemp) {
        super(artikelnr, preis);
        this.lagertemperatur = lagertemp;
    }

    /**
     * Constructs ...
     *
     *
     * @param artikelnr
     * @param preis
     * @param beschreibung
     * @param lagertemperatur
     */
    public Pflanze(long artikelnr, double preis, String beschreibung, double lagertemperatur) {
        super(artikelnr, beschreibung, preis, 0.19);
        this.lagertemperatur = lagertemperatur;
    }

    /**
     *
     * @param lagertemperatur
     */
    public void setLagertemperatur(double lagertemperatur) {
        this.lagertemperatur = lagertemperatur;
    }

    /**
     *
     * @return
     */
    public double getLagertemperatur() {
        return lagertemperatur;
    }

    @Override
    public void getInformation() {
        super.getInformation();
        System.out.println("Lagertemperatur ");
        System.out.println(this.getLagertemperatur());
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
