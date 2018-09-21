/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Model.PanierVideException;
import fr.ufrsciencestech.panier.Model.PanierPleinException;
import fr.ufrsciencestech.panier.Controler.ControleurSimple;
import fr.ufrsciencestech.panier.Model.Panier;
import java.awt.event.ActionEvent;
//import java.util.concurrent.Callable;  //pour AssertJ Swing
import javax.swing.JButton;
import javax.swing.JLabel;
//import org.assertj.swing.edt.GuiActionRunner;  //pour AssertJ Swing
//import org.assertj.swing.fixture.FrameFixture;  //pour AssertJ Swing
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author celine
 */
public class VueGraphiqueSimpleTest {
    static VueGraphiqueSimple vueg;
    private ControleurSimple c1;
    //private Controleur c2;
    private Panier p;
    private ActionEvent einc, edec;
    //private FrameFixture window;  //pour AssertJ Swing

    @Before
    public void setUp() {
        vueg = new VueGraphiqueSimple();
        /*vueg = GuiActionRunner.execute(new Callable<VueGraphiqueSimple>() {  //pour AssertJ Swing
		public VueGraphiqueSimple call() throws Exception {
			return new VueGraphiqueSimple();
		}
	});*/
        p = new Panier(2);
        c1 = new ControleurSimple();
        //c2 = new ControleurSimple();
        c1.setPanier(p);
        c1.setVue(vueg);
        p.addObserver(vueg);
        vueg.addControleur(c1);
        //einc = new ActionEvent(vueg.getInc(), 0, "inc");
        //edec = new ActionEvent(vueg.getDec(), 1, "dec");
        
        //window = new FrameFixture(vueg);  //pour AssertJ Swing
        //window.show(); // shows the frame to test  //pour AssertJ Swing
    }


    /**
     * Test of update method, of class VueGraphiqueSimple.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     * @throws fr.ufrsciencestech.panier.Model.PanierVideException
     */
    @Test  //ignore pour fonctionner dans Jenkins
    public void testUpdate() throws PanierPleinException, PanierVideException {
        System.out.println("update");
        /*assertEquals(vueg.getAffiche().getText(), "0");
        p.add();
        assertEquals(vueg.getAffiche().getText(), "0");
        p.remove();
        assertTrue(p.estVide());*/
        
        //si on ajoute la vue comme observateur du panier, elle se met à jour correctement
        //p.addObserver(vueg);
        p.add();
        assertEquals(vueg.getAffiche().getText(), "1");
        p.add();
        assertEquals(vueg.getAffiche().getText(), "2");
    }

    /**
     * Test of addControleur method, of class VueGraphiqueSimple.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        plus.doClick();
        assertEquals(res.getText(), "1");
        plus.doClick();
        assertEquals(res.getText(), "2");
    }
    
    //https://www.javaworld.com/article/2073056/swing-gui-programming/automate-gui-tests-for-swing-applications.html
    @Test
    public void testRemoveOk() {
        System.out.println("remove");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        final JButton minus = (JButton)TestUtils.getChildNamed(vueg, "Minus");
        assertNotNull(minus);
        plus.doClick();
        assertEquals(res.getText(), "1");
        minus.doClick();
        assertEquals(res.getText(), "0");
    }
    
    @Test
    public void testRemoveZero() {
        System.out.println("remove");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton minus = (JButton)TestUtils.getChildNamed(vueg, "Minus");
        assertNotNull(minus);
        minus.doClick();
        assertEquals(res.getText(), "0");
    }
    
    @Ignore
    public void testAddAssertJ() {  //ne marche pas !
        System.out.println("add");
        //window.button("Plus").click();
        //window.label("Affichage").requireText("1");
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
