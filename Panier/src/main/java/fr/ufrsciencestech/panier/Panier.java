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
    private ArrayList<Orange> oranges;
    private int cont_max;   //nb maximum d'oranges que peut contenir le panier
	
    public Panier(int max){
	cont_max = max;
	oranges = new ArrayList<Orange>(max);  //panier vide
    }
    public double getPrice(){
	double total=0;
	for(int i = 0 ; i < oranges.size() ; i++)
            total += oranges.get(i).getPrice();
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
        return oranges.size();
    }
    public int getContMax(){
	return cont_max;
    }
    public Orange getOranges(int i){
	return oranges.get(i);
    }
    public boolean estVide(){
        return oranges.isEmpty();
    }
    public boolean estPlein(){
        return oranges.size() == cont_max;
    }
    
    public void add() throws PanierPleinException{
        if(!estPlein()){
            Orange o;
            if(!estVide())
                o = oranges.get(oranges.size()-1);
            else
                o = new Orange(0.50, "France");
            oranges.add(o);
            setChanged();
            notifyObservers(oranges.size());
        }
        else {
            throw new PanierPleinException();
        }
    }
	
    public void add(Orange o) throws PanierPleinException{
        if(o == null)
            return;
        if(!estPlein()){
            oranges.add(o);
        }
        else 
            throw new PanierPleinException();
    }
        
    public void remove() throws PanierVideException{
        if(!estVide()){
            oranges.remove(oranges.size()-1);
            setChanged();
            notifyObservers(oranges.size());
        }
        else 
        {
            throw new PanierVideException();
        }
    }
	
    public void boycottOrigin(String country){
	int i = 0;					//A
	while(i < oranges.size()){			//B
            if(oranges.get(i).getCountry().equals(country)) //C
		oranges.remove(i);			//D
            else								 
		i++ ;					//E
        }
    }  
        
    @Override
    public String toString(){
        String tmp = "[";
        int i = 0;
        while(i < getSize()-1){
            tmp += oranges.get(i).toString();
            tmp += ", ";
            i++;
        }
        if(estVide())
            tmp += "]";
        else
            tmp += oranges.get(oranges.size()-1).toString() + "]";
        return tmp;
    }
        
    public boolean equals(Object o){ //equivalent si c'est dans le même ordre
        if(o == null)
            return this == null;

        boolean result = false;
        if(o instanceof Panier){
            Panier p = (Panier) o;
            if(p.getSize() == this.getSize())
            {
                int i=0;
                while(i < p.getSize())
                {					 
                    if( p.oranges.get(i).getPrice() != this.oranges.get(i).getPrice() ||
                        !p.oranges.get(i).getCountry().equals(this.oranges.get(i).getCountry()) )
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
    
    public static void main (String[] args){
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
        
    }
}
