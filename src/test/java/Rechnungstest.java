//~--- non-JDK imports --------------------------------------------------------

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
import com.mario.blumenladen.Rechnung;
import com.mario.blumenladen.kunde.Kunde;
import com.mario.blumenladen.kunde.PremiumKunde;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author mario
 */
public class Rechnungstest extends junit.framework.TestCase {
    Rechnung r;
    Rechnung rPremium;

    /**
     * Constructs ...
     *
     */
    public Rechnungstest() {}

    /**
     * TODO
     */
    public void setUp() {
        Kunde        k  = new Kunde("Anna Meier");
        PremiumKunde pk = new PremiumKunde("Ina Kunze");

        r        = new Rechnung(k);
        rPremium = new Rechnung(pk);
    }

    /**
     * TODO
     */
    public void testeRabattBeiNeuerRechnung() {
        assertEquals("Rabatt bei 0 Euro und normaler Kundin " + "fehlerhaft.", 0, r.bestimmeRabatt());
    }

    /**
     * TODO
     */
    public void testeRabattBeiNeuerRechnungPremium() {
        assertEquals("Rabatt bei 0 Euro und Premiunmkundin " + "fehlerhaft.", 5, rPremium.bestimmeRabatt());
    }

    /**
     * TODO
     */
    @AfterClass
    public static void tearDownClass() {}

    /**
     * TODO
     */
    @After
    @Override
    public void tearDown() {}

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}


//~ Formatted by Jindent --- http://www.jindent.com
