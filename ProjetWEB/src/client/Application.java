package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
/*
 * Côté Client cette classe permet d'afficher le message du serveur,
 *  répondre au message et l'envoyer le message
 */
public class Application
{
	public static void main(String[] args) throws IOException
	{
        Scanner scan = new Scanner(System.in);
        int portNumber =0;
        
        System.out.println("Veillez Saisir votre numero abonne");
        int numero = scan.nextInt();
        System.out.println("Client numero " + numero + " Voulez faire votre choix ");
        System.out.println("Reserver    : 1\nEmprunter :2\nRetourner :3");
        
        
        int choixPort;
        do{
        	 choixPort= scan.nextInt();
        	 switch (choixPort)
        	 {
	        	 case 1: portNumber = 2500 ; break;
	        	 case 2: portNumber = 2600 ; break;
	        	 case 3: portNumber = 2700 ; break;
	        	 default:choixPort=0; System.out.println("Veillez saisir 1 ou 2 ou 3");break;
        	 }
        	 
        } while(choixPort==0);
       
        Socket clientCoteClient = null;
        try
        {   
        	clientCoteClient = new Socket("localHost",portNumber); // connextion au serveur avec le port
            System.out.println("Connexion au serveur réussi");
           
            // permmetre l'envoie de messages au serveur
            PrintWriter    out   = new PrintWriter(clientCoteClient.getOutputStream(), true);
            // permettre de lire l'information envoye par le serveur
            BufferedReader in    = new BufferedReader(new InputStreamReader(clientCoteClient.getInputStream()));
            String m1 = in.readLine(); 		// recuperer le msg envoye par le serveur
            System.out.println(m1 + "AAAAAAAAA");    		// afficher  le msg envoye par le serveur
            String s  = "";
            
            while(!s.equalsIgnoreCase("FIN"))
            {	
            	if(!s.equalsIgnoreCase("FIN"))
            	{
            		 System.out.println("Serveur : " + s);    // afficher  le msg envoye par le serveur
                     m1 =scan.nextLine();                     // je saisie une réponse
                     out.println(m1);		                  // j'envois une réponse au serveur  
                     s = in.readLine();            
            	}
            	                // recuperer le msg envoye par le serveur
            }
            System.out.println( "Demande de deconnexion en cours");
            System.err.println(in.readLine());
            out.close();                    // FERMETURE DE L'ENVOYER DE MESSAGE AU SERVEUR
            in.close();                     // FERMETURE DU RECEPTEUR DE MESSAGE AU SERVEUR
            clientCoteClient.close();       // FERMETURE DU RECEPTEUR DE MESSAGE AU SERVEUR        
        }  catch (IOException e){e.printStackTrace();}
	}
}