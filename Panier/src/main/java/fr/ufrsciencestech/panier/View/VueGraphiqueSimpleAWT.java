/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Controler.Controleur;
import fr.ufrsciencestech.panier.Model.Panier;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 *
 * @author celine
 */
public class VueGraphiqueSimpleAWT extends Frame implements VueGraphique, Observer{
    private Button inc;
    private Button dec;
    private Label affiche;
    /**
     * @return the inc
     */
    public Button getInc() {
        return inc;
    }
    /**
     * @param inc the inc to set
     */
    public void setInc(Button inc) {
        this.inc = inc;
    }

    /**
     * @return the dec
     */
    public Button getDec() {
        return dec;
    }
    /**
     * @param dec the dec to set
     */
    public void setDec(Button dec) {
        this.dec = dec;
    }

    /**
     * @return the affiche
     */
    public Label getAffiche() {
        return affiche;
    }
    /**
     * @param affiche the affiche to set
     */
    public void setAffiche(Label affiche) {
        this.affiche = affiche;
    }

    public VueGraphiqueSimpleAWT(){
        super("Panier");
        inc = new Button("+");
        dec = new Button("-");
        affiche = new Label("0", Label.CENTER);
        add(inc, BorderLayout.NORTH);
        add(dec, BorderLayout.SOUTH);
        add(affiche, BorderLayout.CENTER);
        
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        this.pack();
        this.setVisible(true);
        
        /* Use setName() so AssertJ Swing can find these components easily */
        inc.setName("Plus");
        dec.setName("Minus");
        affiche.setName("Affichage");
    }

    public void update(Observable m, Object o) {
        Panier p = (Panier) m;
        getAffiche().setText(((Integer)p.getFruits().size()).toString());
    }

    public void addControleur(Controleur c) {
        getInc().addActionListener(c);
        getDec().addActionListener(c);
    }
    
    public int getValeur(ActionEvent e){
        Button b = (Button) e.getSource();
        //if(b != getInc() && b != getDec()) //pas d'autre bouton ici
        //    return 0;  //autre evenement que l'appui sur l'un des 2 boutons
        return (b==getInc()) ? 1 : -1;
    }
}
