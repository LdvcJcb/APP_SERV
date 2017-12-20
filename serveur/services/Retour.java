package serveur.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import serveur.Bibliotheque;

public class Retour implements Runnable
{
	private Socket client;
	public Retour(Socket client)
	{
		this.client = client;
	}
	
	@Override
	public void run()
	{
		try
		{
			PrintWriter out   = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out.println("Bienvenue sur le serveur de retour.");
			
			String s  ="";
			
			while(!s.equalsIgnoreCase("Oui"))
			{
				out.println("Voulez vous retourner le Livre ? (Oui/Non) \n");
				if(!s.equalsIgnoreCase("Oui"))
				{
					s = in.readLine();
				}
			}
			/*
			  Mettre ici le code de retour du livre
			*/
			System.err.println("Client deconnecte!");
			out.println("Le livre a bien ete retourne.");
			out.close();
			in.close();
			client.close();
		}catch(IOException e){e.printStackTrace();}
	}
	
	protected void finalize() throws Throwable{
		client.close();
	}
}