/**
 * 
 */
package model;

/**
 * @author NeO MARKET
 *
 */
public class Plaisancier {

	/** 
	 * reference du id
	 */
	private int id;		
	/** 
	 * emplacement
	 */
	private String emplacement;		
	/**
	 * nom bateau
	 */
	private String nombt;		
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
	 * datefabricaion
	 */
	private String datefabricaion;
	/**
	 * taille bateau
	 */
	private double taille;
	
	public Plaisancier(int id ,String emplacement, String nombt, String pavillon, String dateAriver, String dateDepart,
			String datefabricaion, double taille) {
		super();
		this.id = id;
		this.emplacement = emplacement;
		this.nombt = nombt;
		this.pavillon = pavillon;
		this.dateAriver = dateAriver;
		this.dateDepart = dateDepart;
		this.datefabricaion = datefabricaion;
		this.taille = taille;
	}
	
	public String getEmplacement() {
		return emplacement;
	}
	public String getNombt() {
		return nombt;
	}
	public void setNombt(String nombt) {
		this.nombt = nombt;
	}
	public String getPavillon() {
		return pavillon;
	}
	public void setPavillon(String pavillon) {
		this.pavillon = pavillon;
	}
	public String getDateAriver() {
		return dateAriver;
	}
	public void setDateAriver(String dateAriver) {
		this.dateAriver = dateAriver;
	}
	public String getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}
	public String getDatefabricaion() {
		return datefabricaion;
	}
	
	public int getId() {
		return id;
	}
	
	public double getTaille() {
		return taille;
	}
	public void setTaille(double taille) {
		this.taille = taille;
	}
	
	@Override
	public String toString() {
		return " " + nombt +   ",  Taille:  " + taille +  " m,  Emplacement: "+emplacement+  ", pavillon: "+pavillon+"";
	}

}
