/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author celine
 */
public class VueConsole implements Observer{

    public VueConsole(){
        System.out.println("Contenance initiale : " + 0);
    }
    public void update(Observable o, Object arg) {
        System.out.println("Nouvelle contenance : " + ((Integer) arg).toString());
    }
    
}
