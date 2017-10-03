/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author celine
 */
public class ControleurListe implements Controleur{
    private Panier p;
    private VueGraphiqueListe vg;
    
    public void actionPerformed(ActionEvent e){
        if(vg.getValeur(e) == 1)
            try {
                p.add((Fruit)vg.getListeAdd().getSelectedItem());
        } catch (PanierPleinException ex) {
            //JOptionPane.showMessageDialog(null, "Panier plein", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else
            try {
                p.remove();
        } catch (PanierVideException ex) {
            //JOptionPane.showMessageDialog(null, "Panier vide", "Erreur", JOptionPane.ERROR_MESSAGE) ;
        }
    }
    
    public void setPanier(Panier p){
        this.p = p;
    }
    
    public void setVue(VueGraphique vg){
        this.vg = (VueGraphiqueListe) vg;
    }
    
}
