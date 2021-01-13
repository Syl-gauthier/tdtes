package tdtes;

public class Orange {
	private double prix;
	private String origine;
	
	public double getPrix() {
		return this.prix;
	} 
	
	public String getOrigine() {
		return this.origine;
	}

	public Orange(double prix, String origine) {
		super();
		if (prix < 0 ) throw new ArithmeticException("Prix n�gatif");
		this.prix = prix;
		this.origine = origine;
	}
	
	public String toString() {
		return String.format("Orange: %s / %.2f", this.origine, this.prix);
	}
	
	public boolean equals(Object o) {
		if (o == this) return true;
		if (o.getClass() != this.getClass()) return false;
		Orange orange = (Orange)o;
		return this.prix == orange.prix && this.origine.equals(orange.origine);
	}
}