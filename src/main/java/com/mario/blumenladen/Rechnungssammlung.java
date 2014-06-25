
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.mario.blumenladen;

//~--- non-JDK imports --------------------------------------------------------

import com.mario.blumenladen.kunde.Kunde;

/**
 *
 * @author mario
 */
public class Rechnungssammlung {
    private Rechnung[] rechnungen;

    int bestimmeGesamtbetragAllerRechnungenVon(Kunde k) {

        // wenn kein Kunde oder keine Rechnungen vorhanden
        if ((k == null) || (rechnungen == null)) {
            return 0;
        }

        int betrag = 0;

        // alle Rechnungen betrachten
        for (Rechnung r : rechnungen) {

            // wenn gesuchter Kunde
            if (r.getRechnungsempfänger() == k) {

                // Betrag dazuaddieren
                betrag += r.bestimmeBetragInCent();
            }
        }

        return betrag;
    }

    Rechnung findeTeuersteRechnung() {

        // wenn keine Rechnungen vorhanden
        if (rechnungen == null) {
            return null;
        }

        Rechnung max = null;

        // alle Rechnungen betrachten
        for (Rechnung r : rechnungen) {

            // wenn noch kein Maximum gefunden
            // oder aktuelle Rechnung teurer
            if ((max == null) || (max.bestimmeBetragInCent() < r.bestimmeBetragInCent())) {

                // Maximum anpassen
                max = r;
            }
        }

        return max;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
