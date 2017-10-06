/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Model.PanierVideException;
import fr.ufrsciencestech.panier.Model.PanierPleinException;
import fr.ufrsciencestech.panier.Model.Panier;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public class VueConsoleTest {
    VueConsole vuec;
    Panier p;
    
    public VueConsoleTest() {
    }
    
    @Before
    public void setUp() {
        vuec = new VueConsole();
        p = new Panier(2);
    }

    /**
     * Test of update method, of class VueConsole.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     * @throws fr.ufrsciencestech.panier.Model.PanierVideException
     */
    @Test
    public void testUpdate() throws PanierPleinException, PanierVideException {
        System.out.println("update");
 
        assertEquals(vuec.getTrace(), "Contenance initiale : " + 0);
        p.add();
        assertEquals(vuec.getTrace(), "Contenance initiale : " + 0);
        p.remove();
        
        //si on ajoute la vue comme observateur du panier, elle se met à jour correctement
        p.addObserver(vuec);
        p.add();
        assertEquals(vuec.getTrace(), "Nouvelle contenance : " + 1);
        p.add();
        assertEquals(vuec.getTrace(), "Nouvelle contenance : " + 2);
    }
    
}
