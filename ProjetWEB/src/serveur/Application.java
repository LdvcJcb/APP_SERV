package serveur;
import java.io.IOException;
/*
 *  La classe Application que contient le main 
 *  ne sert que à lancer le Server à partir d'une porte
 */
public class Application
{
	 static int PORT = 5000;
	public static void main(String[] args)
	{
		try
		{
			new Thread(new Serveur(2600)).start();
			System.out.println("Serveur emprunt lancé sur le port " + 2600);
			
			new Thread(new Serveur(2500)).start();
			System.out.println("Serveur Reservation lancé sur le port " + 2500);
			
			new Thread(new Serveur(2700)).start();
			System.out.println("Serveur Retour lancé sur le port " + 2700);
		}catch(IOException e){System.out.println("Impossible de se Connecter");}	
	}
}
