package fr.ufrsciencestech.panier.View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import fr.ufrsciencestech.panier.Model.*;
import fr.ufrsciencestech.panier.Controler.*;
import javax.swing.JFrame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author celine
 */
public class TestMVC {
    private VueGraphique vueg;
    
    public static void main(String[] args){
        
        //test avec controleur et vue simples
        Panier p = new Panier(4);
        VueConsole vuec = new VueConsole();
        p.addObserver(vuec);
        
        //SpringIoC
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	    
        //VueGraphiqueSimple vueg = new VueGraphiqueSimple();
        //VueGraphiqueSimpleAWT vueg = new VueGraphiqueSimpleAWT();
        TestMVC test = (TestMVC)context.getBean("MVC");
        
        //Controleur cs = new ControleurSimple();
        Controleur cs = (Controleur)context.getBean("Controleur");
        cs.setPanier(p);
        cs.setVue(test.vueg);
        p.addObserver(test.vueg);
        test.vueg.addControleur(cs);
        //afficher la vue courante
        //vueg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //test.vueg.pack();
        //test.vueg.setVisible(true);
        
        
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
        Jus jf1 = new Jus(new Fraise());
        ((Macedoine)rouge).add(jf1);
        vuel.addListeAdd(rouge);
  
        Fruit jo1 = (Fruit)new Jus(new Orange());
        vuel.addListeAdd(jo1);
        Fruit jmi = (Fruit)new Jus(ile);
        vuel.addListeAdd(jmi);
        
        Controleur cl = new ControleurListe();
        cl.setPanier(p);
        cl.setVue(vuel);
        p.addObserver(vuel);
        vuel.addControleur(cl);
        //afficher la vue courante
        vuel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vuel.pack();
        //vuel.setVisible(true);
    }

    /**
     * @return the vueg
     */
    public VueGraphique getVueg() {
        return vueg;
    }

    /**
     * @param vueg the vueg to set
     */
    public void setVueg(VueGraphique vueg) {
        this.vueg = vueg;
    }
    
    
}
