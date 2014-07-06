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
package com.mario.blumenladen;

//~--- non-JDK imports --------------------------------------------------------

import com.mario.blumenladen.waren.Artikel;

/**
 *
 * @author mario
 */
public class Rechnungsposten {
    int     anzahl;
    Artikel artikel;

    /**
     * Constructs ...
     *
     */
    public Rechnungsposten() {}

    /**
     * Constructs ...
     *
     *
     * @param anzahl
     * @param artikel
     */
    public Rechnungsposten(int anzahl, Artikel artikel) {
        this.anzahl  = anzahl;
        this.artikel = artikel;
    }

    /**
     *
     * @return
     */
    public int getAnzahl() {
        return anzahl;
    }

    /**
     *
     * @return
     */
    public Artikel getArtikel() {
        return artikel;
    }

    /**
     *
     * @param anzahl
     */
    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    /**
     *
     * @param artikel
     */
    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    void legeAnzahlFest(int neueAnzahl) {
        this.anzahl = neueAnzahl;
    }

    void legeArtikelFest(Artikel neuerArtikel) {
        this.artikel = neuerArtikel;
    }

    double berechneGesamtbetrag() {
        return getAnzahl() * this.getArtikel().getPreis();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
