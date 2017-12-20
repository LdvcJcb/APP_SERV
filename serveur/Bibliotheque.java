package serveur;

import java.util.ArrayList;

public class Bibliotheque {
	private static ArrayList<Abonne> listeAbo = new ArrayList<Abonne>();
	private static ArrayList<Document> listeDoc = new ArrayList<Document>();
	private static String nomBibli;
	
	public Bibliotheque(String nomBibli, ArrayList<Abonne> listeAbo, ArrayList<Document> listeDoc){
		Bibliotheque.nomBibli = nomBibli;
		Bibliotheque.listeAbo = listeAbo;
		Bibliotheque.listeDoc = listeDoc;
	}
	
	public static ArrayList<Abonne> getListeAbo() {
		return listeAbo;
	}

	public static ArrayList<Document> getListeDoc() {
		return listeDoc;
	}

	public static String getNomBibli() {
		return nomBibli;
	}
	
}
