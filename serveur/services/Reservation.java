package serveur.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import serveur.Bibliotheque;

public class Reservation implements Runnable
{
	private Socket client;
	public Reservation(Socket client)
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
			out.println("Bienvenue sur le serveur de reservation");
			
			String s  ="";
			
			while(!s.equalsIgnoreCase("La curee"))
			{
				out.println("Veuillez saisir le nom du livre a reserver? ");
				s = in.readLine();
			}
			
			/*
			  Mettre ici le code de reservation du livre
			*/
			
			System.err.println("Client deconnecte!");
			out.println("fin");
			out.close();
			in.close();
			client.close();
		}catch(IOException e){e.printStackTrace();}
	}
	
	protected void finalize() throws Throwable{
		client.close();
	}
}