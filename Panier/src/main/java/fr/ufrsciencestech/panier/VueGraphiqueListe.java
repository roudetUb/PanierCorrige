/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author celine
 */
public class VueGraphiqueListe extends JFrame implements VueGraphique, Observer {
    private JButton inc;
    private JButton dec;
    private JComboBox<Fruit> listeAdd;
    private JLabel affiche;
    /**
     * @return the inc
     */
    public JButton getInc() {
        return inc;
    }

    /**
     * @param inc the inc to set
     */
    public void setInc(JButton inc) {
        this.inc = inc;
    }

    /**
     * @return the dec
     */
    public JButton getDec() {
        return dec;
    }

    /**
     * @param dec the dec to set
     */
    public void setDec(JButton dec) {
        this.dec = dec;
    }

    /**
     * @return the affiche
     */
    public JLabel getAffiche() {
        return affiche;
    }

    /**
     * @param affiche the affiche to set
     */
    public void setAffiche(JLabel affiche) {
        this.affiche = affiche;
    }
    
    /**
     * @return the listeAdd
     */
    public JComboBox<Fruit> getListeAdd() {
        return listeAdd;
    }

    /**
     * @param listeAdd the listeAdd to set
     */
    public void setListeAdd(JComboBox<Fruit> listeAdd) {
        this.listeAdd = listeAdd;
    }
    
    public void addListeAdd(Fruit f){
        listeAdd.addItem(f);
    }

    public VueGraphiqueListe(){
        super("Panier");
        inc = new JButton("+");
        dec = new JButton("-");
        affiche = new JLabel("0", JLabel.CENTER);
        
        listeAdd = new JComboBox<Fruit>();
        JPanel panelN = new JPanel();
	panelN.setLayout(new FlowLayout());
        panelN.add(inc);
        panelN.add(listeAdd);
        add(panelN, BorderLayout.NORTH);

        add(dec, BorderLayout.SOUTH);
        add(affiche, BorderLayout.CENTER);
    }

    public void update(Observable m, Object o) {
        Integer nbfruits = (Integer) o;
        getAffiche().setText(nbfruits.toString());
    }

    public void addControleur(Controleur c) {
        getInc().addActionListener(c);
        getDec().addActionListener(c);
    }
    
   public int getValeur(ActionEvent e){
        JButton b = (JButton) e.getSource();
        if(b != getInc() && b != getDec()) 
            return 0;  //autre evenement que l'appui sur l'un des 2 boutons
        return (b==getInc()) ? 1 : -1;
    }
    
}
