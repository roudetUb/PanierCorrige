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
public class FraiseTest {
    Fraise f1, f2, f3;
    
    @Before
    public void setUp() throws Exception {
        f1 = new Fraise("France");
	f2 = new Fraise("Italie");
	f3 = new Fraise("Allemagne");
    }

    /**
     * Test of getPrice method, of class Fraise.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        
        Fraise instance = new Fraise();
        double expResult = 1.5;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getCountry method, of class Fraise.
     */
    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        
        Fraise instance = new Fraise();
        String expResult = "France";
        String result = instance.getCountry();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Fraise.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        Fraise instance = new Fraise();
        String expResult = "Fraise";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Fraise.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        
        //test avec une Fraise null
        Fraise cnull = null;
        assertFalse(f1.equals(cnull));
        
        //test de 2 cerises equivalentes
        assertTrue(f1.equals(new Fraise()));
        
        //test de 2 cerises non equivalentes : origine differente
        assertFalse(f1.equals(new Fraise("Espagne")));
    }

    /**
     * Test of isSeedless method, of class Fraise.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        
        Fraise instance = new Fraise();
        boolean expResult = true;
        boolean result = instance.isSeedless();
        assertEquals(expResult, result);
    }
    
}
