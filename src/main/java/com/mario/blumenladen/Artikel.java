
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
public class Artikel {
    long   artikelnr;
    String beschreibung;
    double preis;

    /**
     * Constructs ...
     *
     */
    public Artikel() {}

    /**
     * Constructs ...
     *
     *
     * @param artikelnr
     * @param beschreibung
     * @param preis
     */
    public Artikel(long artikelnr, String beschreibung, double preis) {
        this.artikelnr    = artikelnr;
        this.beschreibung = beschreibung;
        this.preis        = preis;
    }

    public long getArtikelnr() {
        return artikelnr;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public double getPreis() {
        return preis;
    }

    public void setArtikelnr(long artikelnr) {
        this.artikelnr = artikelnr;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    @Override
    public String toString() {
        return super.toString();    // To change body of generated methods, choose Tools | Templates.
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
