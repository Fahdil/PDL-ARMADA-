/**
 * 
 */
package model;

/**
 * @author NeO MARKET
 *
 */
public class Organisateur {
	private String nom;
	private String prenom;
	private String mail;
	private String mot_de_passe;
	/**
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @param mot_de_passe
	 */
	public Organisateur(String nom, String prenom, String mail, String mot_de_passe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mot_de_passe = mot_de_passe;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return the mot_de_passe
	 */
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	/**
	 * @param mot_de_passe the mot_de_passe to set
	 */
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}



}
