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
public class Ananas implements Fruit{
    private double price;
    private String country;
	
    public Ananas() //throws Exception
    {
        this.price=2.0;
        this.country="Bresil";
    }
    
    public Ananas(double price, String country) //throws Exception
    {
	if(price < 0){
            this.price = -price;  //ou = 0
            this.country=country;
            //ou throw new Exception();
            //ou gestion avec JML
	}
        else if(country.equals("")){
            this.price=price;
            this.country="Bresil";  //Bresil par défaut
        }  
	else
        {
            this.price=price;
            this.country=country;
        }
    }
    
    public double getPrice(){
	return price;
    }
    public String getCountry(){
	return country;
    }

    @Override
    public String toString(){
        return "Ananas";
    }
    
    @Override
    public boolean equals(Object o){
        if(o != null && o instanceof Ananas){
            Ananas or = (Ananas) o;
            return (price == or.price && country.equals(or.country));
        }
        return false;
    }

    public boolean isSeedless() {
        return true;
    }
    
}
