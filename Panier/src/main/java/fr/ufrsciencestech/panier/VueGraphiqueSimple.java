/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author celine
 */
public class VueGraphiqueSimple extends JFrame implements VueGraphique, Observer {
    private JButton inc;
    private JButton dec;
    private JLabel affiche;
    
    public VueGraphiqueSimple(){
        super("Panier");
        inc = new JButton("+");
        dec = new JButton("-");
        affiche = new JLabel("0", JLabel.CENTER);
        add(inc, BorderLayout.NORTH);
        add(dec, BorderLayout.SOUTH);
        add(affiche, BorderLayout.CENTER);
    }

    public void update(Observable m, Object o) {
        Integer nboranges = (Integer) o;
        affiche.setText(nboranges.toString());
    }

    public void addControleur(Controleur c) {
        inc.addActionListener(c);
        dec.addActionListener(c);
    }
    
    public int getValeur(ActionEvent e){
        JButton b = (JButton) e.getSource();
        return (b==inc) ? 1 : -1;
    }
    
}
