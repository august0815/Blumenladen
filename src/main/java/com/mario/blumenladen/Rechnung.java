
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.mario.blumenladen;

//~--- non-JDK imports --------------------------------------------------------

import com.mario.blumenladen.kunde.Kunde;
import com.mario.blumenladen.kunde.PremiumKunde;

/**
 *
 * @author mario
 */
public class Rechnung {
    final static int    Max_Posten                  = 100;
    private static int  naechsteRechnungsnummer     = 1000;
    static final double STANDART_MEHRWERTSTEUERSATZ = 0.19;
    Rechnungsposten[]   posten                      = new Rechnungsposten[Rechnung.Max_Posten];
    int                 postenAnzahl                = 0;
    private double      betrag                      = 200;
    double              rabatt;
    Kunde               rechnungsempfänger;
    final int           rechnungsnummer;

    /**
     * Constructs ...
     * erzeugt einen neue Rechnung fur den Kunden
     *
     * @param empf ist der Rechnungsempfänger
     */
    public Rechnung(Kunde empf) {
        this.rechnungsempfänger = empf;
        this.rechnungsnummer    = Rechnung.berechneNaechsteRechnungsnummer();
    }

    static int berechneNaechsteRechnungsnummer() {
        return Rechnung.naechsteRechnungsnummer++;
    }

    /**
     *
     * @return
     */
    public int getRechnungsnummer() {
        return rechnungsnummer;
    }

    /**
     *
     * @return
     */
    public Kunde getRechnungsempfänger() {
        return rechnungsempfänger;
    }

    public void setRechnungsempfänger(PremiumKunde rechnungsempfänger) {
        this.rechnungsempfänger = rechnungsempfänger;
    }

    /**
     *
     * @return
     */
    public double getRabatt() {
        return rabatt;
    }

    void gebeAus() {
        System.out.println("An:");
        System.out.println(this.rechnungsempfänger.getName());

        // System.out.println(this.rechnungsempfänger.adresse);
        System.out.print("Rechnungsnummer: ");
        System.out.println(getRechnungsnummer());
        System.out.print("Netto : ");
        System.out.println(berechneNettopreis());
        System.out.print("MwSt: ");
        System.out.println(berechneMehrwertsteuer());
        System.out.print("Brutto: ");
        System.out.println(berechneBruttopreis());
    }

    void setRabatt(final double neuerRabatt) throws UngueltigeRabattAusnahme {
        if ((neuerRabatt < 0) || (neuerRabatt > 1)) {
            throw new UngueltigeRabattAusnahme(neuerRabatt);
        }

        rabatt = neuerRabatt;

        // TODO Fehlerausgabe
    }

    void fuegePostenHinzu(final Rechnungsposten posten) {
        if (postenAnzahl >= Rechnung.Max_Posten) {
            System.out.print("Zuviele Posten ");

            return;
        }

        this.posten[postenAnzahl] = posten;
        this.postenAnzahl++;
    }

    double berechneNettopreis() {
        double summe = 0;

        for (int i = 0; i < this.postenAnzahl; i++) {
            Rechnungsposten rp = this.posten[i];

            summe += rp.berechneGesamtbetrag();
        }

        return summe * (1 - this.getRabatt());
    }

    double berechneBruttopreis() {
        return berechneNettopreis() + berechneMehrwertsteuer();
    }

    double berechneMehrwertsteuer() {
        double summe = 0;

        for (int i = 0; i < this.postenAnzahl; i++) {
            Rechnungsposten rp = this.posten[i];

            summe += rp.berechneGesamtbetrag() * rp.getArtikel().getMehrwertsteuer();
        }

        return summe * (1 - this.getRabatt());
    }

    void aendereRechnungsempfaengetr(PremiumKunde neuerEmpfaenger) {
        this.rechnungsempfänger = neuerEmpfaenger;
    }

    public void legeBetragFest(int i) {}

    public int bestimmeRabatt() {
        if (rechnungsempfänger.getIstPremiumkunde()) {
            if (betrag >= 200) {
                return 10;
            } else {
                return 5;
            }
        } else {
            if (betrag >= 100) {
                return 5;
            } else {
                return 0;
            }
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
