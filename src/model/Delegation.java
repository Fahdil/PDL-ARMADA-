/**
 * 
 */
package model;

/**
 * @author NeO MARKET
 *
 */
public class Delegation {
	/** 
	 * reference de la delegation
	 */
	private int idDel;		
	/**
	 * pays
	 */
	private String pays;		
	/**
	 * nombre de persone
	 */
	private int nbpersonne;
	public Delegation(int idDel, String pays, int nbpersonne) {
		super();
		this.idDel = idDel;
		this.pays = pays;
		this.nbpersonne = nbpersonne;
	}
	public int getIdDel() {
		return idDel;
	}
	public void setIdDel(int idDel) {
		this.idDel = idDel;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public int getNbpersonne() {
		return nbpersonne;
	}
	public void setNbpersonne(int nbpersonne) {
		this.nbpersonne = nbpersonne;
	}
	
	

}
