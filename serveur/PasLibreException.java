package serveur;

public class PasLibreException extends Exception {

	private static final long serialVersionUID = 1L;

	public PasLibreException(){
		System.err.println("Le livre que vous désirez n'est pas disponible !");
	}  
}
