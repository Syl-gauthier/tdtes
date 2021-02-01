package tdtes;
//test
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
		if (prix < 0 ) throw new ArithmeticException("Prix négatif");
		this.prix = prix;
		this.origine = origine;
	}
	
	public String toString() {
		return String.format("Orange: %s / %.2f", this.origine, this.prix);
	}
	
	public boolean equals(Orange o) {
		return this.prix == o.prix && this.origine.equals(o.origine);
	}
}
