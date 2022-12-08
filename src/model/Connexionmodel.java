
/**
 * 
 */
package model;
import gui.*;
import java.util.*;
import dao.*;

/**
 * @author NeO MARKET
 *
 */
public class Connexionmodel {
	Personmoral Personmoral;

	private String mail;
	private String motdp;
	private String valider;
	
	/**
	 * @param mail
	 * @param motdp
	 */
	
	
	public Connexionmodel(String mail, String motdp, String valider) {
		super();
		this.mail = mail;
		this.motdp = motdp;
		this.valider=valider;
	}
	public String getMailcon() {
		return mail;
	}
	public String getMdpcon() {
		return motdp;
	}
	
	public String getValider() {
		return valider;
	}

	
            public boolean comparaison (ArrayList <Connexionmodel> list) {
            	int comp=0; 
            	for (int compteur=0; compteur<list.size();compteur++) {
            		if((list.get(compteur).getMailcon().equals(mail) && list.get(compteur).getMdpcon().equals(motdp) )==true && list.get(compteur).getValider().equals("oui") ) {
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
		return "PARTICIPANT [ ref : " + mail + ", " + motdp + "]";
	}
   	
	

}
	
