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
    private int cont_max;
    private int index_last;
	
	public Panier(int max){
		cont_max = max;
		oranges = new ArrayList<Orange>(max);
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
	
	public void add(Orange o) throws PanierPleinException{
            if(o == null)
                return;
            if(oranges.size() < cont_max){
                oranges.add(o);
                setChanged();
                notifyObservers(oranges.size());
            }
            else 
                throw new PanierPleinException();
	}
        
        public void remove() throws PanierVideException{
            if(oranges.size() > 0){
                oranges.remove(index_last);
                setChanged();
                notifyObservers(oranges.size());
            }
            else 
                throw new PanierVideException();
	}
	
	public void boycottOrigin(String country){
		int i = 0;								 //A
		while(i < oranges.size()){					 //B
			if(oranges.get(i).getCountry().equals(country)) //C
				oranges.remove(i);				 //D
			else								 
				i++ ;							 //E
		}
	}  
        
    @Override
    public String toString(){
        String tmp = "[";
        int i = 0;
        while(i < oranges.size()-1){
            tmp += oranges.get(i).toString();
            tmp += ", ";
            i++;
        }
        tmp += oranges.get(oranges.size()-1).toString() + "]";
        return tmp;
    }
        
    public boolean equals(Object o){ //equivalent si c'est dans le même ordre
        if(o == null)
        {
            return this == null;
        }
        boolean result = false;
        
        if(o instanceof Panier){
            Panier p = (Panier) o;
            int i=0;
            while(i < p.oranges.size()){					 
		if( p.oranges.get(i).getPrice() != this.oranges.get(i).getPrice() ||
                    !p.oranges.get(i).getCountry().equals(this.oranges.get(i).getCountry()) )
			break;				
                i++ ;							 
            }
            if(i == p.oranges.size())
                result = true;
        }
        return result;
    }
}
