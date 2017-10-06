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
public class BananeTest {
    Banane b1, b2, b3;
    
    @Before
    public void setUp() throws Exception {
        b1 = new Banane("France");
	b2 = new Banane("Colombie");
	b3 = new Banane("Cote Ivoire");
    }

    /**
     * Test of getPrice method, of class Banane.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        
        Banane instance = new Banane();
        double expResult = 0.50;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getCountry method, of class Banane.
     */
    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        
        Banane instance = new Banane();
        String expResult = "France";
        String result = instance.getCountry();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Banane.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        Banane instance = new Banane();
        String expResult = "Banane";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Banane.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        
        //test avec une banane null
        Banane bnull = null;
        assertFalse(b1.equals(bnull));
        
        //test de 2 bananes equivalentes
        assertTrue(b1.equals(new Banane()));
        
        //test de 2 bananes non equivalentes : origine differente
        assertFalse(b1.equals(new Banane("Cameroun")));
    }

    /**
     * Test of isSeedless method, of class Banane.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
       
        Fruit instancesspepins = new Banane();
        boolean expResult2 = true;
        boolean result2 = instancesspepins.isSeedless();
        assertTrue(expResult2 == result2);
    }
    
}
