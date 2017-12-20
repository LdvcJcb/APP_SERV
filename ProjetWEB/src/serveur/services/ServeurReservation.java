package serveur.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import serveur.Bibliotheque;

public class ServeurReservation implements Runnable
{
	private Socket clientCoteServeur;
	public ServeurReservation(Socket client, Bibliotheque bibliotheque)
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
			out.println("Bienvenue sur le serveur de Reservation");
			
			String s  ="";
			
			while(!s.equalsIgnoreCase("La curee"))
			{
				out.println("Veuillez saisir le nom du livre a reserver? ");
				s = in.readLine();
			}
			
			/*
			  Mettre ici le code de reservation du livre
			*/
			
			System.err.println("Client deconnecte");
			out.println("fin");
			out.close();
			in.close();
			clientCoteServeur.close();
		}catch(IOException e){e.printStackTrace();}
	}
}