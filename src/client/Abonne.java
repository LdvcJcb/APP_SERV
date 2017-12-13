package client;

public class Abonne {

	private int num;
	private String nom;
	
	public Abonne(int num, String nom) {
		this.num = num;
		this.nom = nom;
	}

	public int getNum() {
		return num;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Abonne [num=" + num + ", nom=" + nom + "]";
	}

}
