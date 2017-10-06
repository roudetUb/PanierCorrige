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
public class AnanasTest {
    Ananas a1, a2, a3;
    
    @Before
    public void setUp() throws Exception {
        a1 = new Ananas(2.0, "Bresil");
	a2 = new Ananas(2.5, "Cameroun");
	a3 = new Ananas(3.0, "Uruguay");
    }

    /**
     * Test of getPrice method, of class Ananas.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        
        Ananas instance = new Ananas();
        double expResult = 2.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getCountry method, of class Ananas.
     */
    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        
        Ananas instance = new Ananas();
        String expResult = "Bresil";
        String result = instance.getCountry();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Ananas.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        Ananas instance = new Ananas();
        String expResult = "Ananas";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Ananas.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        
        //test avec un Ananas null
        Ananas onull = null;
        assertFalse(a1.equals(onull));
        
        //test de 2 Ananas equivalents
        assertTrue(a1.equals(new Ananas()));
        
        //test de 2 Ananas non equivalents : prix different
        assertFalse(a1.equals(new Ananas(1.0, "Bresil")));
        
        //test de 2 Ananas non equivalents : origine differente
        assertFalse(a1.equals(new Ananas(2.0, "Uruguay")));
        
        //les 2
        assertFalse(a1.equals(a2));
    }

    /**
     * Test of isSeedless method, of class Ananas.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        
        Ananas instance = new Ananas();
        boolean expResult = true;
        boolean result = instance.isSeedless();
        assertEquals(expResult, result);
    }
    
}
