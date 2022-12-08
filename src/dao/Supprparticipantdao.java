 package dao;
import java.sql.*;
import java.util.ArrayList;
import model.*;
import gui.*;

/**
* Classe d'acces aux donnees contenues dans la table supplier
*
* @author ESIGELEC - TIC Department
* @version 2.0
* */
public class Supprparticipantdao extends ConnectionDAO {

	
public Supprparticipantdao() {
super();
}
/**
 * Permet de supprimer un participant dans la table toutes les tables.
 * Le mode est auto-commit par defaut : chaque suppression est validee
 * 
 * @param mail du participant a supprimer 
 * @return retourne le nombre de lignes supprimees dans la table
 */
public int delete(String mail) {
	Connection con = null;
	PreparedStatement ps = null;
	int returnValue = 0;

	// connexion a la base de donnees
	try {

		// tentative de connexion
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		// preparation de l'instruction SQL, le ? represente la valeur de l'ID
		// a communiquer dans la suppression.
		// le getter permet de recuperer la valeur de l'ID du fournisseur
		for(int i=0;i<=6;i++) {
			 if(i==0) {
				 ps = con.prepareStatement("DELETE FROM entreprise WHERE mailen = ?");
					ps.setString(1, mail);
			 }
			 
			 if(i==1) {
				 ps = con.prepareStatement("DELETE FROM delegation WHERE mailde = ?");
					ps.setString(1, mail);
			 }
			 
			 if(i==2) {
				 ps = con.prepareStatement("DELETE FROM familles WHERE mailfa = ?");
					ps.setString(1, mail);
			 }
			 
			 if(i==3) {
				 ps = con.prepareStatement("DELETE FROM plaisancier WHERE mailpl = ?");
					ps.setString(1, mail);
			 }
			 
			 if(i==4) {
				 ps = con.prepareStatement("DELETE FROM personnemoral WHERE mail = ?");
					ps.setString(1, mail);
			 }
			 
			 if(i==5) {
				 ps = con.prepareStatement("DELETE FROM commercants WHERE mailco = ?");
					ps.setString(1, mail);
			 }
			 
			 if(i==6) {
				 ps = con.prepareStatement("DELETE FROM participant WHERE mail = ?");
					ps.setString(1, mail);
			 }
			// Execution de la requete
				returnValue = ps.executeUpdate();
			 
			
		}
		

	} catch (Exception e) {
		if (e.getMessage().contains("ORA-02292"))
			System.out.println("Ce fournisseur possede des articles, suppression impossible !"
					         + " Supprimer d'abord ses articles ou utiiser la méthode de suppression avec articles.");
		else
			e.printStackTrace();
	} finally {
		// fermeture du preparedStatement et de la connexion
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (Exception ignore) {
		}
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception ignore) {
		}
	}
	return returnValue;
}

 //modifier 

}