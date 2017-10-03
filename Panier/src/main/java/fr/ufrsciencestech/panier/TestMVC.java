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
        
        //test avec controleur et vue simples
        Panier p = new Panier(4);
        VueConsole vuec = new VueConsole();
        p.addObserver(vuec);
        
        VueGraphiqueSimple vueg = new VueGraphiqueSimple();
        Controleur cs = new ControleurSimple();
        cs.setPanier(p);
        cs.setVue(vueg);
        p.addObserver(vueg);
        vueg.addControleur(cs);
        //afficher la vue courante
        vueg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vueg.pack();
        vueg.setVisible(true);
        
        
        //test avec controleur et vue listes
        Fruit o = (Fruit)new Orange();
        Fruit b = (Fruit)new Banane();
        Fruit c = (Fruit)new Cerise();
        VueGraphiqueListe vuel = new VueGraphiqueListe();
        vuel.addListeAdd(o);
        vuel.addListeAdd(b);
        vuel.addListeAdd(c);
        
        Controleur cl = new ControleurListe();
        cl.setPanier(p);
        cl.setVue(vuel);
        p.addObserver(vuel);
        vuel.addControleur(cl);
        //afficher la vue courante
        vuel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vuel.pack();
        vuel.setVisible(true);
        
                
    }
    public static void main(String[] args){
        new TestMVC();
    }
    
}
