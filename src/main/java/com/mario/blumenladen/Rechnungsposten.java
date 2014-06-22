
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

    public int getAnzahl() {
        return anzahl;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

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
