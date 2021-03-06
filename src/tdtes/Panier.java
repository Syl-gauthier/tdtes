package tdtes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Panier {
	private ArrayList<Orange> listOrange;
	private int tailleLimit;
	
	public Panier(List<Orange> listOrange, int tailleLimit) {
		if (listOrange.size() > tailleLimit) throw new RuntimeException("Too many oranges");
		this.listOrange = new ArrayList<Orange>(listOrange);
		this.tailleLimit = tailleLimit;
	}
	
	public boolean estPlein() {
		return this.listOrange.size() == this.tailleLimit;
	}
	
	public boolean estVide() {
		return this.listOrange.size() == 0;
	}
	
	public void ajoute(Orange o) {
		if(this.estPlein()) throw new RuntimeException("Le panier est plein");
		this.listOrange.add(o);
	}
	
	public void retire() {
		if(this.estVide()) throw new RuntimeException("Le panier est vide");
		this.listOrange.remove(this.listOrange.size()-1);
	}
	
	public double getPrix() {
		double prix = 0;
		Iterator<Orange> iter = this.listOrange.iterator();
		while(iter.hasNext()) {
			Orange o = iter.next();
			prix += o.getPrix();
		}
		return prix;
	}
	
	public String toString() {
		String str = String.format("Panier (%d):\n", this.tailleLimit);
		Iterator<Orange> iter = this.listOrange.iterator();
		while(iter.hasNext()) {
			Orange o = iter.next();
			str += "\t" + o.toString() + "\n";
		}
		return str;
	}
	
	public void boycotteOrigine(String origine) {
		for(int i = 0; i<this.listOrange.size(); i++) {
			Orange o = this.listOrange.get(i);
			if (o.getOrigine().equals(origine)) {
				this.listOrange.remove(o);
			}
		}
	} 
	
	public boolean equals(Panier p) {
		if (this.tailleLimit != p.tailleLimit) return false;
		if (this.listOrange.size() != p.listOrange.size()) return false;
		for(int i = 0; i<this.listOrange.size(); i++) {
			if (! this.listOrange.get(i).equals(p.listOrange.get(i))) return false;
		}
		return true;
	}
	
}
