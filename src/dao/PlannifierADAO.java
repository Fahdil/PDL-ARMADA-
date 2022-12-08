
package dao;
import model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import gui.*;
 public class PlannifierADAO  extends ConnectionDAO {
   
	
	public PlannifierADAO() {
		super();
		}
			//bateau
	/**
	 * Permet Modifier toutes les informations propre a une bateau  dans la table des bateau 
	 * @param mail du participant 
	 * @param delegation d'un participant de type  bateau
	 */
	public int updatebat (Plaisancier  plaisancier) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			     
				ps = con.prepareStatement("UPDATE Plaisancier set arriver=?, depart=? where idpla=? ");
				ps.setString(1, plaisancier.getDateAriver());
				ps.setString(2, plaisancier.getDateDepart());
				ps.setInt(3, plaisancier.getId());
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant existe déjà. Ajout impossible !");
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
	
}
