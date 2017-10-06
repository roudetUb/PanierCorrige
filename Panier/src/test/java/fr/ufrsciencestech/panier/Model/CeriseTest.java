/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public class CeriseTest {
    Cerise c1, c2, c3;
    
    @Before
    public void setUp() throws Exception {
        c1 = new Cerise("France");
	c2 = new Cerise("Italie");
	c3 = new Cerise("Allemagne");
    }

    /**
     * Test of getPrice method, of class Cerise.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        
        Cerise instance = new Cerise();
        double expResult = 1.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getCountry method, of class Cerise.
     */
    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        
        Cerise instance = new Cerise();
        String expResult = "France";
        String result = instance.getCountry();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Cerise.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        Cerise instance = new Cerise();
        String expResult = "Cerise";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Cerise.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
 
        //test avec une cerise null
        Cerise cnull = null;
        assertFalse(c1.equals(cnull));
        
        //test de 2 cerises equivalentes
        assertTrue(c1.equals(new Cerise()));
        
        //test de 2 cerises non equivalentes : origine differente
        assertFalse(c1.equals(new Cerise("Espagne")));
    }

    /**
     * Test of isSeedless method, of class Cerise.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        
        Fruit instanceavecpepins = new Cerise();
        boolean expResult1 = false;
        boolean result1 = instanceavecpepins.isSeedless();
        assertTrue(expResult1 == result1);
    }
    
}
