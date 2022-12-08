
package dao;
import java.sql.*;
import java.util.ArrayList;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table supplier
 * 
 * @author ESIGELEC - TIC Department
 * @version 2.0
 * */
public class InscriptionDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */

	private static String daomail; //permet de recuperer le mail 
	private static String daoprofil;
	private static int iddao;
	public InscriptionDAO() {
		super();
	}

	/**
	 * Permet d'ajouter les informations d'un participant dans la table participant quand la personne s'inscrit
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param objet de type Inscrition 
	 * @return retourne le nombre de lignes ajoutees dans la table participant
	 */

	// addparticipant
	public int addpar (Inscription inscription) {
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
			ps = con.prepareStatement("INSERT INTO participant ( idpart, mail, motdp,valider) VALUES (participant_seq.nextval,?, ?,'non')");
			ps.setString(1, inscription.getEmail());
			ps.setString(2, inscription.getMotdep());

			daomail=inscription.getEmail();
			daoprofil=inscription.getProfil();
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

	// add entreprise
	/**
	 * Permet d'ajouter les informations d' entreprise dans la table entreprise quand la personne s'inscrit avecle profil entreprise
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param objet de type Entreprise 
	 * @return retourne le nombre de lignes ajoutees dans la table entreprise
	 */
	public int addent (Inscription inscription) {
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
			//entreprise
			ps = con.prepareStatement("INSERT INTO entreprise (ident, nomentreprise, immatriculation) VALUES (entreprise_seq.nextval, ?, ?)");
			ps.setString(1, inscription.getNomentreprise());
			ps.setString(2, inscription.getImmatriculation());
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant n'existe déjà. Ajout impossible !");
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


	// add personne moral 
	/**
	 * Permet d'ajouter les informations de la personne moral dans la table personne moral quand la personne s'inscrit 
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param objet de type Entreprise 
	 * @return retourne le nombre de lignes ajoutees dans la table entreprise
	 */

	public int addpm (Inscription inscription) {
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
			//personne moral

			ps = con.prepareStatement("INSERT INTO personnemoral (idpm, nom, prenom, datenaissance, profil, fiche,  mail,vip) VALUES (personnemoral_seq.nextval, ?, ?, ?,?,?,?,?)");
			ps.setString(1, inscription.getNom());
			ps.setString(2, inscription.getPrenom());
			ps.setString(3, inscription.getDate_nais());
			ps.setString(4, inscription.getProfil());
			ps.setString(5, null);
			ps.setString(6, inscription.getEmail());
			ps.setString(7, inscription.getVip());
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

	// complete automa	tiquement lesinformations du profil
	/**
	 * Permet d'ajouter les informations dans la table profil qui sera choisit de maniere automatique 
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param objet de type Entreprise 
	 * @return retourne le nombre de lignes ajoutees dans la table correspondant au profil choisit
	 */
	public int complete (Inscription inscription) {
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

			//plaisancier
			if(inscription.getProfil()=="Bateau") {
				ps = con.prepareStatement("INSERT INTO plaisancier (idPla,arriver,depart,pavillon,taille,datefabrication,m pl,nombt,emplacement) VALUES ((SELECT Max(idpm) from personnemoral),'12/12/12', '12/12/12', 'black', 15.23, '12/12/12',?,'aucun','aucun')");
				ps.setString(1, inscription.getEmail());
				//	System.out.println("jhhjh"+daomail);
			}
			//commercants
			else if(inscription.getProfil()=="Commerçant") {
				ps = con.prepareStatement("INSERT INTO commercants (idcom,activit,stand,mailco) VALUES ((SELECT Max(idpm) from personnemoral) ,'aucun','aucun' ,?)");
				ps.setString(1, inscription.getEmail());
				//	System.out.println("jhhjh "+daomail);
			}
			//entreprise
			else if(inscription.getProfil()=="Entreprise") {
				ps = con.prepareStatement("INSERT INTO entreprise (ident,nomentreprise, immatriculation, mailen) VALUES ((SELECT Max(idpm) from personnemoral),'nom de entreprise', 'aze125', ?)");
				ps.setString(1, inscription.getEmail());
				System.out.println("jhhjh "+daomail);
				//famille
			}
			else if(inscription.getProfil()=="Famille d'acceuil") {
				ps = con.prepareStatement("INSERT INTO familles (idfam, nomfamilles, adress, nombredeplace, mailfa ) VALUES ((SELECT Max(idpm) from personnemoral),'ancun','aucun',0 ,?)");
				ps.setString(1, inscription.getEmail());
			}
			else if(inscription.getProfil()=="Delegation") {
				//delegatio
				ps = con.prepareStatement("INSERT INTO delegation (iddel,Pays ,nombredepersonne , mailde) VALUES ((SELECT Max(idpm) from personnemoral),'pays', 15,?)");
				ps.setString(1, inscription.getEmail());
			}


			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant n'existe déjà. Ajout impossible !");
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

	// update Entreprise pour inscription
	/**
	 * Permet de modifier les informations d'entreprise dans la table entreprise (a une ligne précise) quand la personne s'inscrit avec le profil entreprise pour lui attribuier ces vrais informations
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param objet de type Entreprise 
	 * @return retourne le nombre de lignes ajoutees dans la table entreprise
	 */

	public int updateent (Entreprise  entreprise) {
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
			//personne moral

			ps = con.prepareStatement("UPDATE entreprise set nomentreprise=?, immatriculation=? where mailen=? ");
			ps.setString(1, entreprise.getNom());
			ps.setString(2, entreprise.getImmatriculation());
			ps.setString(3, daomail);
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

	// update commerçant
	/**
	 * Permet de modifier les informations commerçant dans la table commerçant(a une ligne précise) quand la personne s'inscrit avec le profil commerçant pour lui attribuier ces vrais informations
	 * @param objet de type commerçant 
	 * @return retourne le nombre de lignes ajoutees dans la table commerçant
	 */
	public int updatecom (Commercant  commercant) {
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

			ps = con.prepareStatement("UPDATE commercants set activit=?, stand=? where mailco=? ");
			ps.setString(1, commercant.getActivite());
			ps.setString(2, commercant.getStand());
			ps.setString(3, daomail);
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

	//Plaisancier
	/**
	 * Permet de modifier les informations Plaisancier dans la table commerçant(a une ligne précise) quand la personne s'inscrit avec le profil Plaisancier pour lui attribuier ces vrais informations
	 * @param objet de type Plaisancier 
	 * @return retourne le nombre de modifier dans la table Plaisancier
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

			ps = con.prepareStatement("UPDATE Plaisancier set nombt=?, pavillon=?, taille=? where mailpl=? ");
			ps.setString(1, plaisancier.getNombt());
			ps.setString(2, plaisancier.getPavillon());
			ps.setDouble(3, plaisancier.getTaille());
			ps.setString(4, daomail);
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

	//Famille 
	/**
	 * Permet de modifier les informations Famille dans la table Famille(a une ligne précise) quand la personne s'inscrit avec le profil Famille pour lui attribuier ces vrais informations
	 * @param objet de type Famille 
	 * @return retourne le nombre de modifier dans la table Famille
	 */
	public int updatfam (FamilleAcc  familleacc) {
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

			ps = con.prepareStatement("UPDATE familles set nomfamilles=?, adress=?, nombredeplace=? where mailfa=? ");
			ps.setString(1, familleacc.getNomFa());
			ps.setString(2, familleacc.getAddresse());
			ps.setInt(3, familleacc.getNbplace());
			ps.setString(4, daomail);
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

	// deleguation
	/**
	 * Permet de modifier les informations deleguation dans la table deleguation(a une ligne précise) quand la personne s'inscrit avec le profil deleguation pour lui attribuier ces vrais informations
	 * @param objet de type deleguation 
	 * @return retourne le nombre de modifier dans la table deleguation
	 */
	public int updatdel (Delegation  delegation) {
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

			ps = con.prepareStatement("UPDATE delegation set pays=?, nombredepersonne=? where mailde=? ");
			ps.setString(1, delegation.getPays());
			ps.setInt(2, delegation.getNbpersonne());
			ps.setString(3, daomail);
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




	// delect personne moral et part durant insription si utilisateur fait retour
	public int delectpmdurantinscription () {
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
			//personne moral
			ps = con.prepareStatement("DELETE FROM personnemoral WHERE  idpm= (SELECT Max(idpm) from personnemoral)");

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant n'existe déjà. Ajout impossible !");
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



	// delect part durant insription si utilisateur fait retour
	public int delectpartdurantinscription () {
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
			//personne moral
			ps = con.prepareStatement("DELETE FROM participant WHERE  idpart= (SELECT Max(idpart) from participant)");

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant n'existe déjà. Ajout impossible !");
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
          /*
           * 
           */
	public ArrayList<Inscription> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Inscription> returnValue = new ArrayList<Inscription>();
		
		// connexion a la base de donnees
		try {
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		ps = con.prepareStatement("SELECT * FROM Personnemoral ");
		
		// on execute la requete
		rs = ps.executeQuery();
		// on parcourt les lignes du resultat
		while (rs.next()) {
		returnValue.add(new Inscription(rs.getString("mail"),
		                    rs.getString("mail"), 
		                    rs.getString("nom"), 
		                    rs.getString("prenom"), 
		                    rs.getString("mail"), 
		                    rs.getString("mail"), 
		                    rs.getString("mail") ));
		 
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
}