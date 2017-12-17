package serveur.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import serveur.Bibliotheque;
import serveur.IService;


public class Emprunt implements Runnable, IService{
	private final Socket client;
	@SuppressWarnings("unused")
	private final Bibliotheque bib;
	
	public Emprunt(Socket s, Bibliotheque bibli){
		this.client = s;
		this.bib = bibli;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			@SuppressWarnings("unused")
			PrintWriter out = new PrintWriter(client.getOutputStream( ),true);
			String line = in.readLine();
			System.out.println("Reçu "+line);
//			String invLine = new String (new StringBuffer(line).reverse());
//			out.println(invLine);
		} 
		catch(IOException e) {
			
		try{
			client.close();
		}
		catch(IOException e2)
		{}
			e.printStackTrace();
		}
			
	}
	public void finalize() throws Throwable{
		client.close();
	}
	public void lancer() {
		new Thread(this).start();
	}

}
