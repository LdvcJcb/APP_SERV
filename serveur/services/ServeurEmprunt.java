package serveur.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServeurEmprunt implements Runnable{
	private final Socket client;
	public ServeurEmprunt(Socket s){
		this.client = s;
	}
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
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
	protected void finalize() throws Throwable{
		client.close();
	}
	public void lancer() {
		new Thread(this).start();
	}

}
