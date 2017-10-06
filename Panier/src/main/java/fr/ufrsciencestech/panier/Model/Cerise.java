/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Model;

/**
 *
 * @author celine
 */
public class Cerise implements Fruit{
    private String country;
    private final double price = 1.0;
    
    public Cerise() 
    {
        this.country="France";
    }
    
    public Cerise(String country) 
    {
        this.country=country;
    }
    
    public double getPrice(){
	return price;
    }
    public String getCountry(){
	return country;
    }

    @Override
    public String toString(){
        return "Cerise";
    }
    
    @Override
    public boolean equals(Object o){
        if(o != null && o instanceof Cerise){
            Cerise or = (Cerise) o;
            return (country.equals(or.country));
        }
        return false;
    }

    public boolean isSeedless() {
        return false;
    }
    
    
}
