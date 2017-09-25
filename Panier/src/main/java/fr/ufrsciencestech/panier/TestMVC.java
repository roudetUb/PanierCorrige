/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

import javax.swing.JFrame;

/**
 *
 * @author celine
 */
public class TestMVC {
    public TestMVC(){
        Panier p = new Panier(4);
        VueGraphiqueSimple vueg = new VueGraphiqueSimple();
        VueConsole vuec = new VueConsole();
        Controleur controleur = new Controleur();
        controleur.setPanier(p);
        controleur.setVue(vueg);
        p.addObserver(vueg);
        p.addObserver(vuec);
        vueg.addControleur(controleur);
        vueg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vueg.pack();
        vueg.setVisible(true);
                
    }
    public static void main(String[] args){
        new TestMVC();
    }
    
}
