
package dao;
import java.sql.*;
import java.util.ArrayList;
import model.*;
import gui.*;

/**
 * Classe d'acces aux donnees contenues dans les tables entreprises, delegation, bateau, plaisancier, pour povoir faire de modifications commandées pars le participant
 *
 * @author ESIGELEC - TIC Department
 * @version 2.0
 * */
public class OrganisateurDAO extends ConnectionDAO {

	/**
	 * Constructor
	 *
	 */ 
	public OrganisateurDAO() { 
		super();
	}
	// C'EST JUSTE UNE METHODE POUR AVOIR LE MAIL et le profil en return 
	/**
	 * Permet retourner la valeur du mail utiliser pour se connecter
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param Connexionmodel le fournisseur a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */


	/**
	 * Permet de recuperer tous les ¨PARTICIPANTS   dans la table PARTICIPANT
	 *
	 * @return une ArrayList de type participant dans model
	 */
	public ArrayList<Connexionmodel> getListor() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Connexionmodel> returnValue = new ArrayList<Connexionmodel>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM organisateurr ");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new Connexionmodel(rs.getString("mailor"),
						rs.getString("mdpor"),"oui" ));

			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	
	public int add (Organisateur organisateur) {
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
			//participant
			ps = con.prepareStatement("INSERT INTO organisateurr ( mailor, mdpor,nom,prenom) VALUES (?,?,?,?)");
			ps.setString(1, organisateur.getMail());
			ps.setString(2, organisateur.getMot_de_passe());
			ps.setString(3, organisateur.getNom());
			ps.setString(4, organisateur.getPrenom());
			
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

