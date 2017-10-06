/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Model.PanierVideException;
import fr.ufrsciencestech.panier.Model.PanierPleinException;
import fr.ufrsciencestech.panier.Controler.ControleurSimple;
import fr.ufrsciencestech.panier.Controler.Controleur;
import fr.ufrsciencestech.panier.Model.Panier;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author celine
 */
public class VueGraphiqueSimpleTest {
    VueGraphiqueSimple vueg;
    ControleurSimple c1;
    Controleur c2;
    Panier p;
    ActionEvent einc, edec;
    
    public VueGraphiqueSimpleTest() {
    }
    
    @Before
    public void setUp() {
        vueg = new VueGraphiqueSimple();
        p = new Panier(2);
        c1 = new ControleurSimple();
        c2 = new ControleurSimple();
        c1.setPanier(p);
        c1.setVue(vueg);
        
        einc = new ActionEvent(vueg.getInc(), 0, "inc");
        edec = new ActionEvent(vueg.getDec(), 1, "dec");
    }

    /**
     * Test of update method, of class VueGraphiqueSimple.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     * @throws fr.ufrsciencestech.panier.Model.PanierVideException
     */
    @Ignore  //ignore pour fonctionner dans Jenkins
    public void testUpdate() throws PanierPleinException, PanierVideException {
        System.out.println("update");
        
        assertEquals(vueg.getAffiche().getText(), "0");
        p.add();
        assertEquals(vueg.getAffiche().getText(), "0");
        p.remove();
        assertTrue(p.estVide());
        
        //si on ajoute la vue comme observateur du panier, elle se met à jour correctement
        p.addObserver(vueg);
        p.add();
        assertEquals(vueg.getAffiche().getText(), "1");
        p.add();
        assertEquals(vueg.getAffiche().getText(), "2");
    }

    /**
     * Test of addControleur method, of class VueGraphiqueSimple.
     */
    @Ignore
    public void testAddControleur() {
        System.out.println("addControleur");
        
        //impossible à tester avec JUnit
    }

    /**
     * Test of getValeur method, of class VueGraphiqueSimple.
     */
    @Ignore  //ignore pour fonctionner dans Jenkins
    public void testGetValeur() {
        System.out.println("getValeur");

        //bouton +
        int expResult = 1;
        int result = vueg.getValeur(einc);
        assertEquals(expResult, result);

        //bouton -
        int expResult2 = -1;
        int result2 = vueg.getValeur(edec);
        assertEquals(expResult2, result2);
        
        //autre action
        ActionEvent e = new ActionEvent(new JButton(), 2, "");
        int expResult3 = 0;
        int result3 = vueg.getValeur(e);
        assertEquals(expResult3, result3);
    }
    
}
