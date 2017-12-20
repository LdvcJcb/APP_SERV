package serveur;

import java.util.ArrayList;

import doc.Livre;

public class Bibliotheque {
	private static ArrayList<Abonne> abo = new ArrayList<Abonne>();
	private static ArrayList<Document> doc = new ArrayList<Document>();
	private final static String nomBibli = "Balthazar";
	
	public static void ajout() {
		Abonne ab1 = new Abonne(1, "Patrick");
		Abonne ab2 = new Abonne(2, "Michel");
		Abonne ab3 = new Abonne(3, "Mohammed");
		abo.add(ab1); abo.add(ab2); abo.add(ab3);
		
		Document doc1 = new Livre(100, "La curee", "Zola");
		Document doc2 = new Livre(200, "Le seigneur des anneaux", "J.R.Tolkien");
		Document doc3 = new Livre(300, "Tchoupi", "Pitchoune");
		doc.add(doc1); doc.add(doc2); doc.add(doc3);
	}
	
	public static ArrayList<Abonne> getListeAbo() {
		return abo;
	}

	public static ArrayList<Document> getListeDoc() {
		return doc;
	}

	public static String getNomBibli() {
		return nomBibli;
	}
	
}
