package serveur;

import java.io.IOException;


public class AppliServeur {

	private final static int PORT_EMPRUNT = 2500;
	private final static int PORT_RESERVATION= 2600;
	private final static int PORT_RETOUR = 2700;
	
	public static void main(String[] args) {
		Bibliotheque bibliotheque = new Bibliotheque();
		
		try {
			new Thread(new Serveur(PORT_EMPRUNT, bibliotheque)).start();
			System.out.println("Serveur emprunt lancé sur le port " + PORT_EMPRUNT);
			
			new Thread(new Serveur(PORT_RESERVATION, bibliotheque)).start();
			System.out.println("Serveur emprunt lancé sur le port " + PORT_RESERVATION);
			
			new Thread(new Serveur(PORT_RETOUR, bibliotheque)).start();
			System.out.println("Serveur emprunt lancé sur le port " + PORT_RETOUR);
			
		} catch (IOException e) {
				System.err.println("Pb lors de la création du serveur : " +  e);			
		}
	}
}
