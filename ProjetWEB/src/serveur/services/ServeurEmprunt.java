package serveur.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServeurEmprunt implements Runnable{
	
	@SuppressWarnings("unused")
	private final int PORT_RESERVATION = 2600;
	
	private Socket clientCoteServeur;
	public ServeurEmprunt(Socket client)
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
			out.println("Bienvenue sur le serveur de Rafael");
			
			String s  ="";
			
			while(!s.equalsIgnoreCase("FIN"))
			{
				out.println("Veuillez Saisir um mot ");
				if(!s.equalsIgnoreCase("Fin"))
				{
					s = in.readLine();
					StringBuilder sb= new StringBuilder(s);
					System.out.print("Client : " +sb.reverse());
				}
			}
			System.err.println("Client deconnecte");
			out.println("Deconexion du serveur reussi");
			out.close();
			in.close();
			clientCoteServeur.close();
		}catch(IOException e){e.printStackTrace();}
	}
}
