/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

import java.util.Observable;
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
        p.addObserver(vuec);
    }

    /**
     * Test of update method, of class VueConsole.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test
    public void testUpdate() throws PanierPleinException {
        System.out.println("update");
 
        assertEquals(vuec.getTrace(), "Contenance initiale : " + 0);
        
        p.add();
        assertEquals(vuec.getTrace(), "Nouvelle contenance : " + 1);
        
        p.add();
        assertEquals(vuec.getTrace(), "Nouvelle contenance : " + 2);
    }
    
}
