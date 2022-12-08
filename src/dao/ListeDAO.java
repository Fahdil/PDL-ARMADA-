	 package dao;
		 import java.sql.*;
		 import java.util.ArrayList;
		 import model.*;
		 import gui.*;

public class ListeDAO extends ConnectionDAO {
		/**
		* Constructor
		*
		*/
			private static String daomail;
			private static String daoprofil;
			
		public ListeDAO() {
		super();
		} 
		
	
		/**
		* Permet de recuperer tous les ¨PARTICIPANTS   dans la table PARTICIPANT
		*
		* @return une ArrayList de fournisseur
		*/
		public ArrayList<Commercant> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Commercant> returnValue = new ArrayList<Commercant>();
		
		// connexion a la base de donnees
		try {
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		ps = con.prepareStatement("SELECT * FROM commercants ");
		
		// on execute la requete
		rs = ps.executeQuery();
		// on parcourt les lignes du resultat
		while (rs.next()) {
		returnValue.add(new Commercant(rs.getInt("idcom"),
		                    rs.getString("activit"), rs.getString("stand") ));
		 
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
		
		
		/**
		* Permet de recuperer la  personnennes moral corespondant au mail passer en parametre
		*
		* @return une ArrayList de personne moral corespondant a un participant dons l'inscription n'est pas encore valider 
		*/
		
		public ArrayList<Personmoral> getListpersonreMoral(String mail) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<Personmoral> returnValue = new ArrayList<Personmoral>();
			
			// connexion a la base de donnees
			try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM personnemoral WHERE mail = ? order by idpm  ");
			ps.setString(1,mail);
			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
			returnValue.add(new Personmoral(rs.getInt("idpm"),  rs.getString("nom"), rs.getString("prenom"),
					 rs.getString("datenaissance"), rs.getString("profil"), rs.getBinaryStream("fiche"), rs.getString("mail"),
					 rs.getString("vip")));
			 
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
		
		/**
		* Permet de recuperer tous les ¨PARTICIPANTS   dans la table PARTICIPANT qui non pas leurs inscriptions valide
		*
		* @return une ArrayList de participants dont l'inscription n'est pas encore valider 
		*/
		public ArrayList<Connexionmodel> getListparticipantNonValider() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Connexionmodel> returnValue = new ArrayList<Connexionmodel>();
		
		// connexion a la base de donnees
		try {
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		ps = con.prepareStatement("SELECT * FROM PARTICIPANT where valider =? ");
		ps.setString(1,"non");
		// on execute la requete
		rs = ps.executeQuery();
		// on parcourt les lignes du resultat
		while (rs.next()) {
		returnValue.add(new Connexionmodel(rs.getString("mail"),
		                    rs.getString("motdp"), rs.getString("valider") ));
		 
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
		
		
		/**
		* Permet de recuperer tous les ¨Bateau   dans la table Bateau
		*
		* @return une ArrayList de participants dont le profil est Bateau
		*/
		public ArrayList<Plaisancier> getListBateau() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Plaisancier> returnValue = new ArrayList<Plaisancier>();
		
		// connexion a la base de donnees
		try {
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		ps = con.prepareStatement("SELECT * FROM plaisancier ");
		// on execute la requete
		rs = ps.executeQuery();
		// on parcourt les lignes du resultat
		while (rs.next()) {
		returnValue.add(new Plaisancier(rs.getInt("idpla"),
                            rs.getString("emplacement"),
		                    rs.getString("nombt"), 
		                    rs.getString("pavillon"), 
		                    rs.getString("arriver"), 
		                    rs.getString("depart"), 
		                    rs.getString("idpla"), 
		                    rs.getDouble("taille") ));
		 
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
		
		/**
		* Permet de valider une inscription
		*
		* @return  
		*/
				public int validerInscription (String  mail) {
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
						
							ps = con.prepareStatement("UPDATE participant set valider=? where mail=? ");
							ps.setString(1, "oui");
							ps.setString(2, mail);
						
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

