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
