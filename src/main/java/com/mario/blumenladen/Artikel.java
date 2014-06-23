
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
     *
     * @param artikelnr
     * @param preis
     */
    public Artikel(long artikelnr, double preis) {
        this(artikelnr, "", preis);
    }

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

    /**
     *
     * @return
     */
    public long getArtikelnr() {
        return artikelnr;
    }

    /**
     *
     * @return
     */
    public String getBeschreibung() {
        return beschreibung;
    }

    /**
     *
     * @return
     */
    public double getPreis() {
        return preis;
    }

    /**
     *
     * @param artikelnr
     */
    public void setArtikelnr(long artikelnr) {
        this.artikelnr = artikelnr;
    }

    /**
     *
     * @param beschreibung
     */
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    /**
     *
     * @param preis
     */
    public void setPreis(double preis) {
        this.preis = preis;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString();    // To change body of generated methods, choose Tools | Templates.
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
