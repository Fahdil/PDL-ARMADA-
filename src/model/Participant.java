package model;

public class Participant {
	
	/** 
	 * reference du participant
	 */
	//private int idpart;		
	/**
	 * email
	 */
	private String email;		
	/**
	 * motdep
	 */
	private String motdep;
	
	public Participant(int idpart, String email, String motdep) {
		super();
	//	this.idpart = idpart;
		this.email = email;
		this.motdep = motdep;
	}

	/*public int getIdpart() {
		return idpart;
	}

	public void setIdpart(int idpart) {
		this.idpart = idpart;
	}*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotdep() {
		return motdep;
	}

	public void setMotdep(String motdep) {
		this.motdep = motdep;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Participant [ref :  " + email
				+ ", " + motdep+ "]";
	}
	

}
