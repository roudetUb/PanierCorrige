/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Model;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author roudet
 */
public class OrangeTest {
    Orange o1, o2, o3;
    
    @Before
    public void setUp() throws Exception {
        o1 = new Orange(0.50, "France");
	o2 = new Orange(0.60, "Espagne");
	o3 = new Orange(0.70, "USA");
    }
    
    @After
    public void tearDown() throws Exception {

    }

    /**
     * Test of getPrice method, of class Orange.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        
        //prix positif
        Orange instance = new Orange();
        double expResult = 0.5;
        double result = instance.getPrice();
        assertTrue(expResult == result);
        
        //prix négatif
        Orange orneg = new Orange(-0.5, "France");
        double expResult2 = 0.5;
        double result2 = orneg.getPrice();
        assertTrue(expResult2 == result2);
    }

    /**
     * Test of getCountry method, of class Orange.
     */
    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        
        //String non vide
        Orange instance = o1;
        String expResult = "France";
        String result = instance.getCountry();
        assertEquals(expResult, result);
        
        //String vide
        Orange instance2 = new Orange(0.3, "");
        String expResult2 = "France";
        String result2 = instance2.getCountry();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of toString method, of class Orange.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        //String non vide
        Orange instance = new Orange();
        String expResult = "Orange";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isSeedless method, of class Orange.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");

        Fruit instanceavecpepins = new Orange();
        boolean expResult1 = false;
        boolean result1 = instanceavecpepins.isSeedless();
        assertTrue(expResult1 == result1);
    }
    
    /**
     * Test of equals method, of class Orange.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        
        //test avec une Orange null
        Orange onull = null;
        assertFalse(o1.equals(onull));
        
        //test de 2 oranges equivalentes
        assertTrue(o1.equals(new Orange()));
        
        //test de 2 oranges non equivalentes : prix different
        assertFalse(o1.equals(new Orange(1.0, "France")));
        
        //test de 2 oranges non equivalentes : origine differente
        assertFalse(o1.equals(new Orange(0.50, "Italie")));
        
        //les 2
        assertFalse(o1.equals(o2));
    }
    
}
