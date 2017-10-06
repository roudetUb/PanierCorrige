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
public class Fraise implements Fruit{
    private String country;
    private final double price = 1.5;
    
    public Fraise() 
    {
        this.country="France";
    }
    
    public Fraise(String country) 
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
        return "Fraise";
    }
    
    @Override
    public boolean equals(Object o){
        if(o != null && o instanceof Fraise){
            Fraise or = (Fraise) o;
            return (country.equals(or.country));
        }
        return false;
    }

    public boolean isSeedless() {
        return true;
    }
    
    
    
}
