
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
