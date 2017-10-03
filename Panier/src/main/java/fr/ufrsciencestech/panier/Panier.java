/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;
import java.util.*;
/**
 *
 * @author roudet
 */
public class Panier extends Observable {
    private ArrayList<Fruit> fruits;
    private int cont_max;   //nb maximum d'oranges que peut contenir le panier
	
    public Panier(int max){
	cont_max = max;
	fruits = new ArrayList<Fruit>(max);  //panier vide
    }
    
    public double getPrice(){
	double total=0;
	for(int i = 0 ; i < fruits.size() ; i++)
            total += fruits.get(i).getPrice();
	return total;
		
	//ou :
	/*double total=0;
	Iterator<Orange> it = oranges.iterator();
	while(it.hasNext()){ 
            Orange curr = it.next();
            total += curr.getPrice();
	}
	return total;*/
    }
    
    public int getSize(){
        return fruits.size();
    }
    
    public int getContMax(){
	return cont_max;
    }
    
    public Fruit getFruits(int i){
        if(i >= 0 && i < fruits.size())
            return fruits.get(i);
        else
            return null;
    }
    
    public boolean estVide(){
        return fruits.isEmpty();
    }
    
    public boolean estPlein(){
        return fruits.size() == cont_max;
    }
    
    public void add() throws PanierPleinException{
        if(!estPlein()){
            Fruit o;
            if(!estVide())
                o = fruits.get(fruits.size()-1);
            else
                o = new Orange();
            fruits.add(o);
            setChanged();
            notifyObservers(fruits.size());
        }
        else {
            throw new PanierPleinException();
        }
    }
	
    public void add(Fruit o) throws PanierPleinException{
        if(o == null)
            return;
        if(!estPlein()){
            fruits.add(o);
            setChanged();
            notifyObservers(fruits.size());
        }
        else 
            throw new PanierPleinException();
    }
        
    public void remove() throws PanierVideException{
        if(!estVide()){
            fruits.remove(fruits.size()-1);
            setChanged();
            notifyObservers(fruits.size());
        }
        else 
        {
            throw new PanierVideException();
        }
    }
	
    public void boycottOrigin(String country){
	int i = 0;					//A
	while(i < fruits.size()){			//B
            if(fruits.get(i).getCountry().equals(country)) //C
		fruits.remove(i);			//D
            else								 
		i++ ;					//E
        }
    }  
        
    @Override
    public String toString(){
        String tmp = "[";
        int i = 0;
        while(i < getSize()-1){
            tmp += fruits.get(i).toString();
            tmp += ", ";
            i++;
        }
        if(estVide())
            tmp += "]";
        else
            tmp += fruits.get(fruits.size()-1).toString() + "]";
        return tmp;
    }
        
    @Override
    public boolean equals(Object o){ //equivalent si c'est dans le même ordre
        if(o == null)
            return false;

        boolean result = false;
        if(o instanceof Panier){
            Panier p = (Panier) o;
            if(p.getSize() == this.getSize())
            {
                int i=0;
                while(i < p.getSize())
                {					 
                    if( p.fruits.get(i).getPrice() != this.fruits.get(i).getPrice() ||
                        !p.fruits.get(i).getCountry().equals(this.fruits.get(i).getCountry()) )
                            break;				
                    i++ ;	
                }
                if(i == p.getSize()) //toutes les oranges parcourues sont les mêmes
                    result = true;
            }
            else //les 2 paniers n'ont pas le même nb d'oranges
                result = false;
        }
        return result;
    }
    
    public int nbFruits(Fruit f){
        int cpt = 0;
        int i = 0;					
	while(i < fruits.size()){	
            if(fruits.get(i).getClass().equals(f.getClass())) 
		cpt++;									 
            i++ ;					
        }
        return cpt;
    }
    
    /*public static void main (String[] args){
        Orange o1 = new Orange(0.50,"France");
        Orange o2 = new Orange(0.60,"Italie");
        Orange o3 = new Orange(0.40,"Espagne");
        Panier p2 = new Panier(2);
        Panier p3 = new Panier(3);
        Panier p4 = new Panier(4);
        
        try {
            p2.add(o1);
            p2.add(o2);
            System.out.println(p2);
            System.out.println("taille du panier de contenance max=2 apres 2 ajouts : " + p2.getSize());
            p2.add(o3);
            
        } catch (PanierPleinException ex) {
            System.out.println("EX : taille du panier de contenance max=2 apres un 3eme ajout : " + p2.getSize());
            System.out.println(p2);
        }
        
        try {
            p2.remove();
            System.out.println("taille du panier de contenance max=2 apres un retrait : " + p2.getSize());
            System.out.println(p2);
            p3.remove();
            
        } catch (PanierVideException ex) {
            System.out.println("EX : taille du panier de contenance max=3 vide apres un retrait : " + p3.getSize());
            System.out.println(p3);
        }
        
        //tests de equals
        try {
            p2.add(o2);
            System.out.println(p2);
            p4.add(o1);
            p4.add(o2);
            System.out.println(p4);
            System.out.println("p2 et p4 sont-ils egaux ? " + p2.equals(p4));
            
        } catch (PanierPleinException ex) {
            
        }
        
    }*/
}
