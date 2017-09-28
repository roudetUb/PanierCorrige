/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

import java.awt.event.ActionEvent;
import java.util.Observable;
import javax.swing.JButton;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public class VueGraphiqueSimpleTest {
    VueGraphiqueSimple vueg;
    Controleur c1, c2;
    Panier p;
    
    public VueGraphiqueSimpleTest() {
    }
    
    @Before
    public void setUp() {
        vueg = new VueGraphiqueSimple();
        p = new Panier(2);
        p.addObserver(vueg);
        c1 = new Controleur();
        c2 = new Controleur();
        c1.setPanier(p);
        c1.setVue(vueg);
    }

    /**
     * Test of update method, of class VueGraphiqueSimple.
     */
    @Test
    public void testUpdate() throws PanierPleinException {
        System.out.println("update");
        
        assertEquals(vueg.getAffiche().getText(), "0");
        
        p.add();
        assertEquals(vueg.getAffiche().getText(), "1");
        
        p.add();
        assertEquals(vueg.getAffiche().getText(), "2");
    }

    /**
     * Test of addControleur method, of class VueGraphiqueSimple.
     */
    @Test
    public void testAddControleur() {
        System.out.println("addControleur");
        
        vueg.addControleur(c1);
        //ne pourrait se tester que si on pouvait tester l'appui sur un bouton : cf. Selenium
    }

    /**
     * Test of getValeur method, of class VueGraphiqueSimple.
     */
    @Test
    public void testGetValeur() {
        System.out.println("getValeur");

        ActionEvent einc = new ActionEvent(vueg.getInc(), 0, "inc");
        int expResult = 1;
        int result = vueg.getValeur(einc);
        assertEquals(expResult, result);

        ActionEvent edec = new ActionEvent(vueg.getDec(), 1, "dec");
        int expResult2 = -1;
        int result2 = vueg.getValeur(edec);
        assertEquals(expResult2, result2);
    }
    
}
