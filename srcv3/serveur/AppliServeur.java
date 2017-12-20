package serveur;
import java.io.IOException;
import java.util.ArrayList;

import doc.Livre;
/*
 *  La classe Application que contient le main 
 *  ne sert que à lancer le Server à partir d'une porte
 */
public class AppliServeur
{
	static int PORT = 5000;
	public static void main(String[] args)
	{
			Bibliotheque.ajout();
		try
		{
			new Thread(new Serveur(2600)).start();
			System.out.println("Serveur Emprunt lance sur le port " + 2600);
			
			new Thread(new Serveur(2500)).start();
			System.out.println("Serveur Reservation lance sur le port " + 2500);
			
			new Thread(new Serveur(2700)).start();
			System.out.println("Serveur Retour lance sur le port " + 2700);
		}catch(IOException e){System.out.println("Impossible de se connecter");}	
	}
}
