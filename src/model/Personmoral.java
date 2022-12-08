/**
 * 
 */
package model;
import java.io.InputStream;
import java.util.ArrayList;

import dao.*;
import gui.*;
/**
 * @author NeO MARKET
 *
 */
public class Personmoral {
	
	/** 
	 * reference du de la personne moral
	 */
	private int idpm;		
	/**
	 * nom
	 */
	private String nom;		
	/**
	 * prenom
	 */
	private String prenom;
	/**
	 * datedenaissance
	 */
	private String date_nais;		
	/**
	 * profil
	 */
	private String profil;
	/**
	 * fiche descriptif
	 */
	private InputStream fiche;
	/**
	 * mail
	 */
	private String mail;
	
	/**
	 * vip
	 */
	private String vip;
	
	public Personmoral(int idpm, String nom, String prenom, String date_nais, String profil, InputStream fiche, String mail,String vip) {
		super();
		this.idpm = idpm;
		this.nom = nom;
		this.prenom = prenom;
		this.date_nais = date_nais;
		this.profil = profil;
		this.fiche = fiche;
		this.mail = mail;
		this.vip = vip;
	}

	public int getIdpm() {
		return idpm;
	}

	public  String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getDate_nais() {
		return date_nais;
	}

	public String getProfil() {
		return profil;
	}

	public InputStream getFiche() {
		return fiche;
	}

	public String getMail() {
		return mail;
	}
	public String getVip() {
		return vip;
	}

	/* public boolean comparaison (ArrayList <Connexionmodel> list) {
     	int comp=0; int j=0;
     	for (int compteur=0; compteur<list.size();compteur++) {
     		if((list.get(compteur).getMailcon().equals(mail)==true)) {
     			comp ++; j=compteur;
     		}	
     	}
     	
     	if(comp > 0) {
     	//	Personmoral personmoralf = new Personmoral(1,"f","u","12/12/12","g","y",list.get(j).getMailcon());
     		return true;
     		}
 		else
 			return false;
     }
     */
	
	@Override
	public String toString() {
		return " [ Ref : " + idpm +   ",  Nom:  " + nom +   " ,  Prenom: "+prenom+  ", Profil: "+profil+", Date de naissance:"+date_nais+"]";
	}
	
	

}
