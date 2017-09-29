/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

/**
 *
 * @author roudet
 */
public class Orange {
    private double price;
    private String country;
	
    public Orange() //throws Exception
    {
        this.price=0.5;
        this.country="France";
    }
    
    public Orange(double price, String country) //throws Exception
    {
	if(price < 0){
            this.price = -price;  //ou = 0
            this.country=country;
            //ou throw new Exception();
            //ou gestion avec JML
	}
        else if(country.equals("")){
            this.price=price;
            this.country="France";  //France par défaut
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

    public String toString(){
        return "Orange de " + country;
    }
    
    @Override
    public boolean equals(Object o){
        if(o != null){
            Orange or = (Orange) o;
            return (price == or.price && country.equals(or.country));
        }
        return false;
    }
}
