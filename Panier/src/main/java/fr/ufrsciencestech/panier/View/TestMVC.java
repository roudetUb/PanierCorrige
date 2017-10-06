/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Controler.ControleurSimple;
import fr.ufrsciencestech.panier.Controler.Controleur;
import fr.ufrsciencestech.panier.Controler.ControleurListe;
import fr.ufrsciencestech.panier.Model.Ananas;
import fr.ufrsciencestech.panier.Model.Banane;
import fr.ufrsciencestech.panier.Model.Panier;
import fr.ufrsciencestech.panier.Model.Fruit;
import fr.ufrsciencestech.panier.Model.Orange;
import fr.ufrsciencestech.panier.Model.Cerise;
import fr.ufrsciencestech.panier.Model.Fraise;
import fr.ufrsciencestech.panier.Model.Jus;
import fr.ufrsciencestech.panier.Model.Macedoine;
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
        VueGraphiqueListe vuel = new VueGraphiqueListe();
        Fruit o = (Fruit)new Orange();
        vuel.addListeAdd(o);
        Fruit b = (Fruit)new Banane();
        vuel.addListeAdd(b);
        Fruit c = (Fruit)new Cerise();
        vuel.addListeAdd(c);
        
        Fruit ban = (Fruit)new Macedoine(new Banane());
        vuel.addListeAdd(ban);
        
        Fruit ile = (Fruit)new Macedoine(new Banane());
        Ananas a1 = new Ananas();
        ((Macedoine)ile).add(a1);
        vuel.addListeAdd(ile);
        
        Fruit rouge = (Fruit)new Macedoine(new Cerise());
        Fraise f1 = new Fraise();
        ((Macedoine)rouge).add(f1);
        vuel.addListeAdd(rouge);
  
        Fruit jo1 = (Fruit)new Jus(new Orange());
        vuel.addListeAdd(jo1);
        Fruit jmr = (Fruit)new Jus(rouge);
        vuel.addListeAdd(jmr);
        
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
