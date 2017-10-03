/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

/**
 *
 * @author celine
 */
public class Banane implements Fruit{
    private String country;
    private final double price = 0.50;
    
    public Banane() 
    {
        this.country="France";
    }
    
    public Banane(String country) 
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
        return "Banane de " + country;
    }
    
    @Override
    public boolean equals(Object o){
        if(o != null && o instanceof Banane){
            Banane or = (Banane) o;
            return (country.equals(or.country));
        }
        return false;
    }

    public boolean isSeedless() {
        return true;
    }
    
}
