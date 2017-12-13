package metier;

import client.Abonne;
import client.Document;

public class Livre implements Document{
	private int num;
	private boolean reserve = false;
	
	@SuppressWarnings("unused")
	private String nom;
	@SuppressWarnings("unused")
	private String auteur;
		
	public Livre(int num, String nom, String auteur) {
		this.num = num;
		this.nom = nom;
		this.auteur = auteur;
	}

	@Override
	public int numero() {
		return this.num;
	}

	@Override
	public void reserver(Abonne ab) throws PasLibreException {
		if(!reserve)
			reserve = true;
	}

	@Override
	public void emprunter(Abonne ab) throws PasLibreException {
		
	}

	@Override
	public void retour() {
		
	}

}
