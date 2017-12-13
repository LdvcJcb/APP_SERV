package doc;

import serveur.Abonne;
import serveur.Document;
import serveur.PasLibreException;

public class Livre implements Document{
	private int num;
	private Abonne abonne = null;
	private boolean reserve = false;
	private boolean disponible = true;
	
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
		if(!reserve){
			reserve = true;
			abonne = ab;
		}
		else
			throw new PasLibreException();
	}

	@Override
	public void emprunter(Abonne ab) throws PasLibreException {
		if((disponible && !reserve) || (disponible && reserve && abonne == ab)) {
			disponible = false;
			abonne = ab;
		}
		else
			throw new PasLibreException();
	}

	@Override
	public void retour() {
		disponible = true;
		reserve = false;
		abonne = null;
	}

}
