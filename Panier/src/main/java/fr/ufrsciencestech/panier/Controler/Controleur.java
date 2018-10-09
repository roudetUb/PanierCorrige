/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Controler;

import fr.ufrsciencestech.panier.Model.Panier;
import fr.ufrsciencestech.panier.View.VueGraphique;
import java.awt.event.ActionListener;
/**
 *
 * @author celine
 */
public interface Controleur extends ActionListener{
    public void setPanier(Panier p);
    //public void setVue(VueGraphique vg);
}
