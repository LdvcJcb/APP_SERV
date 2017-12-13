package serveur;

import java.util.ArrayList;

public class Bibliotheque {
	private ArrayList<Abonne> listeAbo = new ArrayList<Abonne>();
	private ArrayList<Document> listeDoc = new ArrayList<Document>();
	private String nomBibli;
	
	
	public ArrayList<Abonne> getListeAbo() {
		return listeAbo;
	}
	public void setListeAbo(ArrayList<Abonne> listeAbo) {
		this.listeAbo = listeAbo;
	}
	public ArrayList<Document> getListeDoc() {
		return listeDoc;
	}
	public void setListeDoc(ArrayList<Document> listeDoc) {
		this.listeDoc = listeDoc;
	}
	public String getNomBibli() {
		return nomBibli;
	}
	public void setNomBibli(String nomBibli) {
		this.nomBibli = nomBibli;
	}
}
