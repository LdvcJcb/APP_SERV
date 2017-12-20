package serveur.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import serveur.Bibliotheque;

public class ServeurRetour implements Runnable
{
	private Socket clientCoteServeur;
	public ServeurRetour(Socket client, Bibliotheque bibliotheque)
	{
		this.clientCoteServeur = client;
	}
	
	@Override
	public void run()
	{
		try
		{
			PrintWriter out   = new PrintWriter(clientCoteServeur.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientCoteServeur.getInputStream()));
			out.println("Bienvenue sur le serveur de Retour");
			
			String s  ="";
			
			while(!s.equalsIgnoreCase("Oui"))
			{
				out.println("Voulez vous retourner le Livre ? \n Oui ou Non");
				if(!s.equalsIgnoreCase("Oui"))
				{
					s = in.readLine();
				}
			}
			/*
			  Mettre ici le code de retour du livre
			*/
			System.err.println("Client deconnecte");
			out.println("Le livre a bien ete retourne");
			out.close();
			in.close();
			clientCoteServeur.close();
		}catch(IOException e){e.printStackTrace();}
	}
}