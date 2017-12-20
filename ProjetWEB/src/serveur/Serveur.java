package serveur;
import java.io.*;
import java.net.*;
import java.util.*;

import serveur.services.ServeurEmprunt;
import serveur.services.ServeurReservation;
import serveur.services.ServeurRetour;

/**
* @author LUFUNDISU Tandu Rafael   F2
*/
public class Serveur implements Runnable
{
	private ServerSocket serverSocket;
	private int port;
	
	public Serveur( int port) throws IOException
	{
		this.port =port;
		this.serverSocket = new ServerSocket(this.port);
		
	}
	
	@Override
	public void run()
	{	
		try
		{
			Socket toClient = this.serverSocket.accept(); // connection du client dans le serveur reussi
			
			System.out.println("Un client est arrive" );
			
			switch (port)
			{
				case 2700:
					new Thread(new ServeurRetour(toClient, new Bibliotheque())).start(); // Debut du servie
				break;
				
				case 2500:
					new Thread(new ServeurReservation(toClient, new Bibliotheque())).start(); // Debut du servie
				break;
				
				case 2600:
				//	new Thread(new ServeurEmprunt(toClient, new Bibliotheque())).start(); // Debut du servie
				break;
				default: System.out.println("port inconnu");
					break;
			}
			
		
		} catch (IOException e){e.printStackTrace();}
		
	}	
}