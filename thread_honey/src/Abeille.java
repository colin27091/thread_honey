import java.util.Random;

public class Abeille extends Thread {
	
	private JAbeille jabeille;
	private int poids;
	private Ruche ruche;
	
	public Abeille(int num, String nom, Ruche ruche) {
		
		this.ruche = ruche;
		this.jabeille = new JAbeille(num, nom);
		
	}
	
	public void run() {
		
		while(true) {

			poids = 0;
			jabeille.setChargement(poids);
			jabeille.setEtat("Je butine");
			
			Random rand = new Random();
			
			int r = rand.nextInt(6) + 10;
			for(int i = 0; i < r; i++) {
				poids ++;
				jabeille.setChargement(poids);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
			while(ruche.estOccup�e()) {
				try {
					jabeille.setEtat("J'attends à l'entrée de la ruche");
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				
			}
			
			synchronized(ruche) {
					jabeille.setEtat("Je me repose dans la ruche");
					ruche.entreRuche();
					ruche.ajoutPoid(poids);
					poids = 0;
					jabeille.setChargement(poids);
				}
			
			
			r = rand.nextInt(3)+1;
			try {
				Thread.sleep(r*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized(ruche) {
				ruche.quitteRuche();
			}
			
			
			
		}
		
	}

}
