package serveur;

import java.io.IOException;
import java.net.ServerSocket;

import serveur.services.Emprunt;

public class Serveur implements Runnable {
	private ServerSocket listen_socket;
	private int portServ;
	
	private  Bibliotheque bibliotheque;
	
	Serveur(int port, Bibliotheque biblio) throws IOException {
		listen_socket = new ServerSocket(port);
		bibliotheque = biblio;
	}

	public void run() {
		try {
			while(true){
				switch(portServ) {
				case 2500:
					new Emprunt(listen_socket.accept(),bibliotheque).lancer();
					break;
				
				case 2600:
					new Reservation(listen_socket.accept(),bibliotheque).lancer();
					break;
					
				case 2700:
					new Retour(listen_socket.accept(),bibliotheque).lancer();
					break;
					
				default:
					System.err.println("Port inconnu -> Pas de service associé.");
					break;
				}
			}
		}
		catch (IOException e) { 
			try {this.listen_socket.close();} catch (IOException e1) {}
			System.err.println("Pb sur le port d'écoute :"+e);
		}
	}

	protected void finalize() throws Throwable {
		try {this.listen_socket.close();} catch (IOException e1) {}
	}
}
}		
