
public class Ruche {
	
	private int num;
	private String nom;
	private int poids;
	private boolean occupe;
	private JRuche jruche;
	
	
	public Ruche(int num, String nom) {
		
		this.num = num;
		this.nom = nom;
		this.poids = 0;
		this.occupe = false;
		this.jruche = new JRuche(num, nom);
		
		
	}
	
	public void ajoutPoid(int poids) {
		this.poids = this.poids+poids;
		jruche.setMiel(this.poids);
	}
	
	public boolean estOccupée() {
		return this.occupe;
	}
	
	public void quitteRuche() {
		this.occupe = false;
		jruche.setEtat("Vide");
		
	}
	
	public void entreRuche() {
		this.occupe = true;
		jruche.setEtat("OccupÃ©e");
		
	}
	
	public void passageOurs() {
		this.poids = Math.round(this.poids/2);
		jruche.setMiel(this.poids);
	}
	

}
