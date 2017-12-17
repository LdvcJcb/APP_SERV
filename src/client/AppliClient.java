package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class AppliClient {
		private static int PORT=1000;
		private static final int PORT_RES = 2500;
		private static final int PORT_EMP = 2600;
		private static final int PORT_RET = 2700;
		private final static String HOST = "localhost"; 
	
	public static void main(String[] args) {
		Socket socket = null;		
		try {
			switch(PORT){
			case 2500: 
				socket = new Socket(HOST, PORT_RES);
				break;
			case 2600: 
				socket = new Socket(HOST, PORT_EMP);
				break;
			case 2700: 
				socket = new Socket(HOST, PORT_RET);
				break;
			 default:
                 System.out.println("Numéro de port inconnu, veuillez réessayez !");
                 break;
			}
			
			BufferedReader sin = new BufferedReader (new InputStreamReader(socket.getInputStream ( )));
			PrintWriter sout = new PrintWriter (socket.getOutputStream ( ), true);

			BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));			
			System.out.println("Vous êtes connecté au serveur " + socket.getInetAddress() + ":"+ socket.getPort());
			
			String line;
			
			System.out.println("Quelle opération voulez-vous effectuer ?");
			System.out.print("->");
			
			line = clavier.readLine();
			sout.println(line);
			
			line = sin.readLine();
			
			System.out.println(line);
			socket.close();
		}
		catch (IOException e) { System.err.println(e); 
		try { if (socket != null) socket.close(); } 
		catch (IOException e2) { ; }		
	}
}
}
