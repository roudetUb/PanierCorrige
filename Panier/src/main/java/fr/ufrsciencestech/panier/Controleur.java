/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

import java.awt.event.ActionListener;
/**
 *
 * @author celine
 */
public interface Controleur extends ActionListener{
    public void setPanier(Panier p);
    public void setVue(VueGraphique vg);
}
