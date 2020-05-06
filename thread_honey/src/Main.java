
public class Main {

	public static void main(String[] args) {
		
		Ruche ruche = new Ruche(0, "Ruche");
		
		new Ours(0, "Ours", ruche).start();
		
		for(int i = 0; i < 10 ; i++) {
			new Abeille(i, "Abeille" + i, ruche).start();
		}
		
	}

}
