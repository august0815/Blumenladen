//~--- non-JDK imports --------------------------------------------------------

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
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
