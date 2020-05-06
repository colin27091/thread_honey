
public class Ours extends Thread {
	
	private JOurs jours;
	private Ruche ruche;
	
	public Ours(int num, String nom, Ruche ruche) {
		
		this.ruche = ruche;
		jours = new JOurs(num, nom);
		
	}
	
	public void run() {
		
		while(true) {
			
			try {
				Thread.sleep(40000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(ruche.estOccup�e()) {
				try {
					jours.setEtat("J'attends à l'entrée...");
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}	
			}
			
			synchronized(ruche) {
				ruche.passageOurs();
				ruche.entreRuche();
				jours.setEtat("Je prends le miel");
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized(ruche) {
				ruche.quitteRuche();
				jours.setEtat("Je dors");
				
			}
			
		}
		
	}

}
