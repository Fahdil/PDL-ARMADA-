/**
 * 
 */
package model;

/**
 * @author NeO MARKET
 *
 */
public class FamilleAcc {
	
	/** 
	 * reference de la famille
	 */
	private int idFa;		
	/**
	 * nom famille
	 */
	private String nomFa;		
	/**
	 * addresse
	 */
	private String addresse;
	/**
	 * nombre de place 
	 */
	private int nbplace;
	
	public FamilleAcc(int idFa, String nomFa, String addresse, int nbplace) {
		super();
		this.idFa = idFa;
		this.nomFa = nomFa;
		this.addresse = addresse;
		this.nbplace = nbplace;
	}

	public int getIdFa() {
		return idFa;
	}

	public void setIdFa(int idFa) {
		this.idFa = idFa;
	}

	public String getNomFa() {
		return nomFa;
	}

	public void setNomFa(String nomFa) {
		this.nomFa = nomFa;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public int getNbplace() {
		return nbplace;
	}

	public void setNbplace(int nbplace) {
		this.nbplace = nbplace;
	}
   
	
	 
	
	

}
