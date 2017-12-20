package serveur.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import doc.Livre;
import serveur.Abonne;
import serveur.Bibliotheque;
import serveur.Document;
import serveur.PasLibreException;

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
			
			int numAb = Integer.parseInt(in.readLine());
			String s  ="";
			while(true)
			{
				out.println("Veuillez saisir le nom du livre a reserver? ");
				s = in.readLine();

				try{
					Document doc = trouveDoc(s);
					try {
						reserv(doc, numAb);
						out.println("Document reserve avec succes!");
					} catch (PasLibreException e) {
						out.println("Erreur lors de la reservation");
					}
				} catch (Exception e){
					out.println("Document non trouvé");
					break;
				}
				
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
	
	private Document trouveDoc(String s) throws Exception{	
		for (Document doc : Bibliotheque.getListeDoc()) {
			if(((Livre) doc).getNom().equals(s)) {
				return doc;
			}
		}
		throw new Exception();
	}
	
	private void reserv(Document doc, int numAb) throws PasLibreException {
		Abonne abo = null;
		try{
			for (Abonne ab : Bibliotheque.getListeAbo()) {
				if(ab.getNum() == numAb)
					abo = ab;
			}
		} catch (Exception e) {
			System.err.println("L'abonne n'existe pas.");
		}
			doc.reserver(abo);
	}
	
	protected void finalize() throws Throwable{
		client.close();
	}
}