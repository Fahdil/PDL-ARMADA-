 /**
 * 
 */
package model;

/**
 * @author NeO MARKET
 *
 */
public class Commercant {
	/** 
	 * reference du commercant
	 */
	private int idcom;		
	/**
	 * activite
	 */
	private String activite;		
	/**
	 * emplacement
	 */
	private String emplacement;
	/**
	 * stand
	 */
	private String stand;
	
	public Commercant(int idcom, String activite, String stand) {
		super();
		this.idcom = idcom;
		this.activite = activite;
		this.emplacement = emplacement;
		this.stand = stand;
	}
	

	public int getIdcom() {
		return idcom;
	}

	public void setIdcom(int idcom) {
		this.idcom = idcom;
	}

	public String getActivite() {
		return activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement; 
	}

	public String getStand() {
		return stand;
	}

	public void setStand(String stand) {
		this.stand = stand;
	}

	@Override
	public String toString() {
		return "Activité:  " + activite +   " ,  Stand: "+stand+ "";
	}
			


		
			

}
