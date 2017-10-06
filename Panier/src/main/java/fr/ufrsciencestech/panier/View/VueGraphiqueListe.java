/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Controler.Controleur;
import fr.ufrsciencestech.panier.Model.Fruit;
import fr.ufrsciencestech.panier.Model.Panier;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author celine
 */
public class VueGraphiqueListe extends JFrame implements VueGraphique, Observer {
    private JButton inc;
    private JButton dec;
    private JComboBox<Fruit> listeAdd;
    private JTextArea affichenb;

    public JButton getInc() {
        return inc;
    }
    public void setInc(JButton inc) {
        this.inc = inc;
    }
    public JButton getDec() {
        return dec;
    }
    public void setDec(JButton dec) {
        this.dec = dec;
    }
    public JTextArea getAffiche() {
        return affichenb;
    }
    public void setAffiche(JTextArea affiche) {
        this.affichenb = affiche;
    }

    public JComboBox<Fruit> getListeAdd() {
        return listeAdd;
    }
    public void setListeAdd(JComboBox<Fruit> listeAdd) {
        this.listeAdd = listeAdd;
    }
    
    public void addListeAdd(Fruit f){
        listeAdd.addItem(f);
        affichenb.setText(affichenb.getText() + "0 " + f + " a " + f.getPrice() + " euros\n" );
    }

    public VueGraphiqueListe(){
        super("Panier");
        inc = new JButton("+");
        dec = new JButton("-");
        affichenb = new JTextArea("Panier de 0 fruits\n");
        
        listeAdd = new JComboBox<Fruit>();
        JPanel panelN = new JPanel();
	panelN.setLayout(new FlowLayout());
        panelN.add(inc);
        panelN.add(listeAdd);
        add(panelN, BorderLayout.NORTH);

        add(dec, BorderLayout.SOUTH);
        add(affichenb, BorderLayout.CENTER);
    }

    public void update(Observable m, Object o) {
        Panier p = (Panier) o;
        getAffiche().setText("Panier de " + ((Integer)p.getFruits().size()).toString() + " fruits : " + p.getPrice() + " euros\n");
        for(int i = 0 ; i < listeAdd.getItemCount() ; i++)
        {
            Fruit f = (Fruit) listeAdd.getItemAt(i);
            int nb = p.nbFruits(f);
            affichenb.setText(affichenb.getText() + nb + " " + listeAdd.getItemAt(i) + " a " + listeAdd.getItemAt(i).getPrice() + " euros\n" );
        }
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
