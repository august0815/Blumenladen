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



//~--- non-JDK imports --------------------------------------------------------

import com.mario.blumenladen.Rechnung;
import com.mario.blumenladen.kunde.Kunde;

/**
 * Class description
 *
 *
 * @version        Enter version here..., 14/06/25
 * @author         Enter your name here...
 */
public class EinfacherRechnungstest {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Kunde    k = new Kunde("Anna Meier");
        Rechnung r = new Rechnung(k);

        r.legeBetragFest(120);

        int rabatt = r.bestimmeRabatt();

        if (rabatt != 5) {
            System.out.println("Der Rabatt bei einer Rechnung " + "von 120 Euro wird falsch berechnet!");
            System.out.println("Der Rabatt sollte 5 Prozent " + "betragen, betraegt aber: " + rabatt);
        }

        // ...
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
