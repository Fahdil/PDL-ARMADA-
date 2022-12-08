package model;
import gui.*;
import dao.*;
public class Entreprise /*extends Inscription*/{

	/**
	 * immatriculation
	 */
	private String immatriculation;		
	/**
	 * nom
	 */
	private String nom;
	
	//@Override
	public Entreprise( String immatriculation, String nom) {
		super();
		this.immatriculation = immatriculation;
		this.nom = nom;
	}

	public String getImmatriculation() {
		return immatriculation;
	}


	public String getNom() {
		return nom;
	}

	
	

	

}
