package model;

import java.util.ArrayList;

public class Inscription {
		
	/**
	 * activite
	 */
	private String activite;	
	/**
	 * vip
	 */
	private String vip;	
	/**
	 * emplacement
	 */
	private String emplacement;
	/**
	 * stand
	 */
	private String stand;		
	/**
	 * nom famille
	 */
	private String nomFamille;
	/**
	 * addresse
	 */
	private String addresse;
	/**
	 * nombre de place 
	 */
	private String nbplace;
	/**
	 * email
	 */
	private String email;		
	/**
	 * motdep
	 */
	private String motdep;
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
	 * nom bateau
	 */
	private String nombateau;		
	/**
	 * pavillon
	 */
	private String pavillon;
	/**
	 * dateAriver
	 */
	private String dateAriver;		
	/**
	 * date Depart
	 */
	private String dateDepart;
	/**
	 * taille bateau
	 */
	private double taille;
	/**
	 * pays
	 */
	private String pays;		
	/**
	 * nom entreprise
	 */
	private String nomentreprise;	
	/**
	 * nombre de persone
	 */
	private String nbpersonne;
	/**
	 * immatriculation
	 */
	private String immatriculation;
	
	/**
	 * @param activite
	 * @param emplacement
	 * @param stand
	 * @param nomFamille
	 * @param addresse
	 * @param nbplace
	 * @param email
	 * @param motdep
	 * @param nom
	 * @param prenom
	 * @param date_nais
	 * @param profil
	 * @param nombateau
	 * @param pavillon
	 * @param dateAriver
	 * @param dateDepart
	 * @param taille
	 * @param pays
	 * @param nomentreprise
	 * @param nbpersonne
	 * @param immatriculation
	 */
	/*public Inscription(String activite, String emplacement, String stand, String nomFamille, String addresse,
			String nbplace, String email, String motdep, String nom, String prenom, String date_nais, String profil,
			String nombateau, String pavillon, String dateAriver, String dateDepart, double taille, String pays,
			String nomentreprise, String nbpersonne, String immatriculation) {
		super();
		this.activite = activite;
		this.emplacement = emplacement;
		this.stand = stand;
		this.nomFamille = nomFamille;
		this.addresse = addresse;
		this.nbplace = nbplace;
		this.email = email;
		this.motdep = motdep;
		this.nom = nom;
		this.prenom = prenom;
		this.date_nais = date_nais;
		this.profil = profil;
		this.nombateau = nombateau;
		this.pavillon = pavillon;
		this.dateAriver = dateAriver;
		this.dateDepart = dateDepart;
		this.taille = taille;
		this.pays = pays;
		this.nomentreprise = nomentreprise;
		this.nbpersonne = nbpersonne;
		this.immatriculation = immatriculation;
	}*/
	
	
	public Inscription(String email, String motdep, String nom, String prenom, String date_nais, String profil,String vip) {
super();
this.email = email;
this.motdep = motdep;
this.nom = nom;
this.prenom = prenom;
this.date_nais = date_nais;
this.profil = profil;
this.vip=vip;

}
	public String getActivite() {
		return activite;
	}
	public String getEmplacement() {
		return emplacement;
	}
	public String getStand() {
		return stand;
	}
	public String getNomFamille() {
		return nomFamille;
	}
	public String getAddresse() {
		return addresse;
	}
	public String getNbplace() {
		return nbplace;
	}
	public String getEmail() {
		return email;
	}
	public String getMotdep() {
		return motdep;
	}
	public String getNom() {
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
	public String getNombateau() {
		return nombateau;
	}
	public String getPavillon() {
		return pavillon;
	}
	public String getDateAriver() {
		return dateAriver;
	}
	public String getDateDepart() {
		return dateDepart;
	}
	public double getTaille() {
		return taille;
	}
	public String getPays() {
		return pays;
	}
	public String getNomentreprise() {
		return nomentreprise;
	}
	public String getNbpersonne() {
		return nbpersonne;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public String getVip() {
		return vip;
	}
	
	public boolean comparaison (ArrayList <Connexionmodel> list) {
    	int comp=0; 
    	for (int compteur=0; compteur<list.size();compteur++) {
    		if((list.get(compteur).getMailcon().equals(email)  )==true  ) {
    			comp ++; 
    		}	
    	}
    	
    	if(comp > 0) {
    		return true;
    		}
		else
			return false;
    }
	
	@Override
	public String toString() {
		return " mail:" + email + ", " + nom+ ", " + prenom+ "";
	}
	
}
