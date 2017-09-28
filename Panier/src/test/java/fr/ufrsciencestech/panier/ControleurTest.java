/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author celine
 */
public class ControleurTest {
    Controleur c1, c2;
    Panier p;
    VueGraphiqueSimple vueg;
    ActionEvent einc;
    ActionEvent edec;

            
    public ControleurTest() {
    }
    
    @Before
    public void setUp() {
        c1 = new Controleur();
        c2 = new Controleur();
        p = new Panier(2);
        vueg = new VueGraphiqueSimple(); 
        c1.setPanier(p);
        c1.setVue(vueg);
        
        edec = new ActionEvent(vueg.getDec(), 1, "dec");
        einc = new ActionEvent(vueg.getInc(), 0, "inc");
    }

    /**
     * Test of actionPerformed method, of class Controleur.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");

        assertTrue(p.estVide());
        c1.actionPerformed(einc);
        assertTrue(p.getSize()==1);

        c1.actionPerformed(edec);
        assertTrue(p.estVide());
    }
    
    /**
     * Test of actionPerformed method, of class Controleur.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test
    public void testActionPerformedPlein() throws PanierPleinException {
        System.out.println("actionPerformedPlein");
        
        p.add();
        p.add();
        assertTrue(p.getSize() == 2);
        c1.actionPerformed(einc);
        assertTrue(p.getSize() == 2);
    }
    
    /**
     * Test of actionPerformed method, of class Controleur.
     */
    @Test
    public void testActionPerformedVide() {
        System.out.println("actionPerformedVide");

        assertTrue(p.estVide());
        c1.actionPerformed(edec);
        assertTrue(p.estVide());
    }

    /**
     * Test of setPanier method, of class Controleur.
     */
    @Ignore
    public void testSetPanier() {
        System.out.println("setPanier");
        
        c1.setPanier(p);
    }

    /**
     * Test of setVue method, of class Controleur.
     */
    @Ignore
    public void testSetVue() {
        System.out.println("setVue");

        c1.setVue(vueg);
    }
    
}
