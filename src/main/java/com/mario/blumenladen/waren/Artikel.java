
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.mario.blumenladen.waren;

/**
 *
 * @author mario
 */
public class Artikel {
    private double mehrwertsteuer = 0.19;
    private long   artikelnr;
    private String beschreibung;
    private double preis;

    /**
     * Constructs ...
     *
     *
     * @param artikelnr
     * @param preis
     */
    public Artikel(long artikelnr, double preis) {
        this.artikelnr = artikelnr;
        this.preis     = preis;
    }

    /**
     * Constructs ...
     *
     *
     * @param artikelnr
     * @param preis
     * @param beschreibung
     * @param mwst
     */
    public Artikel(long artikelnr, String beschreibung, double preis, double mwst) {
        this.artikelnr    = artikelnr;
        this.beschreibung = beschreibung;
        this.preis        = preis;
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
     * @param preis
     */
    public void setPreis(double preis) {
        this.preis = preis;
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
     * @return
     */
    public String getBeschreibung() {
        return beschreibung;
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
     * @param artikelnr
     */
    public void setArtikelnr(long artikelnr) {
        this.artikelnr = artikelnr;
    }

    /**
     *
     * @param mehrwertsteuer
     */
    public void setMehrwertsteuer(double mehrwertsteuer) {
        if (mehrwertsteuer < 0) {
            throw new IllegalArgumentException("MwST<0 " + mehrwertsteuer);
        }

        this.mehrwertsteuer = mehrwertsteuer;
    }

    /**
     *
     * @return
     */
    public double getMehrwertsteuer() {
        return mehrwertsteuer;
    }

    /**
     * TODO
     *
     */
    public void getInformation() {
        System.out.println("Artikel ");
        System.out.println(this.getBeschreibung());
        System.out.println("NR: ");
        System.out.println(this.getArtikelnr());
        System.out.println("Preis ");
        System.out.println(this.getPreis());
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
