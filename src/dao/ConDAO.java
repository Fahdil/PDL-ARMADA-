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
		public class ConDAO extends ConnectionDAO {
			
			/**
			* variable static permetant de recuperer l'identifiant de la personne qui se connecte pour l'utiliser afin d'effectuer d'autres opérations
			*
			*/ 
			private static String daomail;
			/**
			* variable static permetant de recuperer le profil de la personne qui se connecte pour l'utiliser afin d'effectuer d'autres opérations
			*
			*/ 
			private static String daoprofil;
		/**
		* Constructor
		*
		*/ 
		public ConDAO() { 
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
		public String Pouravoirlemail(Connexionmodel connexionmodel) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String returnValue = null;
			
			
			// connexion a la base de donnees
			try {
			
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT profil FROM personnemoral WHERE MAIL = ?");
			ps.setString(1, connexionmodel.getMailcon());
			
			daomail=connexionmodel.getMailcon();
			System.out.println(daomail);
			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
			returnValue = rs.getString("profil");
			daoprofil= rs.getString("profil");
			}
			} catch (Exception ee) {
			ee.printStackTrace();
			} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
			if (rs != null) {
			rs.close();
			}
			} catch (Exception ignore) {
			}
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
		
		//permet de savoir si l'inscription est valider ou pas
		/**
		 * Permet de valider l'inscription d'un participant
		 * Le mode est auto-commit par defaut : chaque insertion est validee
		 * @return retourne le nombre de lignes ajoutees dans la table
		 */
		public String valider() {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String returnValue = null;
			
			
			// connexion a la base de donnees
			try {
			
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT valider FROM participant WHERE MAIL = ?");
			ps.setString(1,daomail);
			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
					if (rs.next()) {
					  returnValue = rs.getString("valider");
					}
			} catch (Exception ee) {
			ee.printStackTrace();
			} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
			if (rs != null) {
			rs.close();
			}
			} catch (Exception ignore) {
			}
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
		
		/**
		* Permet de recuperer un participant qui se connecte a partir de son mail et de son mot de passe
		*
		* @param reference le mail et le mot de passe du participant a recuperer
		* @return le participant trouve;
		* null si aucun participant ne correspond a cette reference
		*/
		public Connexionmodel get(String mail, String motdp) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connexionmodel returnValue = null;
		
		
		// connexion a la base de donnees
		try {
		
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		ps = con.prepareStatement("SELECT * FROM PARTICIPANT WHERE MAIL = ? AND MOTDP = ?");
		ps.setString(1, mail);
		ps.setString(2, motdp);
		 
		// on execute la requete
		// rs contient un pointeur situe juste avant la premiere ligne retournee
		rs = ps.executeQuery();
		// passe a la premiere (et unique) ligne retournee
		if (rs.next()) {
		returnValue = new Connexionmodel (rs.getString("mail"),
		      rs.getString("motdp"), rs.getString("valider"));
		  
		}
		} catch (Exception ee) {
		ee.printStackTrace();
		} finally {
		// fermeture du ResultSet, du PreparedStatement et de la Connexion
		try {
		if (rs != null) {
		rs.close();
		}
		} catch (Exception ignore) {
		}
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
		
		
		/**
		* Permet d'inserer une fiche dans la table personne moral pour un mail bien presis
		*
		* @param fiche un objet de type Fichemodel
		* @return le participant trouve;
		* null si aucun fournisseur ne correspond a cette reference
		*/
		public int InsererFiche (Fichemodel fiche) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int returnValue = 0;
		
		
		// connexion a la base de donnees
		try {
		
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		ps = con.prepareStatement("UPDATE  personnemoral set fiche=?  WHERE MAIL = ? ");
		ps.setString(1, fiche.getFiche());
		ps.setString(2, daomail);// utilisatin du mais recuperer a partir de la connexion pour indiquer le lieu ou il y aura l'insersion
		// on execute la requete
		// rs contient un pointeur situe juste avant la premiere ligne retournee
		rs = ps.executeQuery();
		// passe a la premiere (et unique) ligne retournee
		if (rs.next()) {
		returnValue =0;
		  
		}
		} catch (Exception ee) {
		ee.printStackTrace();
		} finally {
		// fermeture du ResultSet, du PreparedStatement et de la Connexion
		try {
		if (rs != null) {
		rs.close();
		}
		} catch (Exception ignore) {
		}
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
		
		/**
		* Permet de recuperer tous les ¨PARTICIPANTS   dans la table PARTICIPANT
		*
		* @return une ArrayList de type participant dans model
		*/
		public ArrayList<Connexionmodel> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Connexionmodel> returnValue = new ArrayList<Connexionmodel>();
		
		// connexion a la base de donnees
		try {
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		ps = con.prepareStatement("SELECT * FROM PARTICIPANT ");
		
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
		
		//PERMET DE RECUPERER UN PARTICIPANT A PARTIR DE SON MAIL
		/**
		 * Permet retourner toutes les informations propre a un participant dans la table des participants
		 * Le mode est auto-commit par defaut : chaque insertion est validee
		 * 
		 * @param mail du participant qui se connecte 
		 * @return un objet de type personneMoral dans model 
		 */
		
		public Personmoral affiche(String mail) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Personmoral returnValue=null ;
			System.out.println(daomail);
			// connexion a la base de donnees
			try {
                    
				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM personnemoral WHERE mail= ?");
				ps.setString(1, daomail);
				
				// on execute la requete
				// rs contient un pointeur situe juste avant la premiere ligne retournee
				rs = ps.executeQuery();
	            if (rs.next()) {				
					returnValue = new Personmoral (rs.getInt("idpm"),
										       rs.getString("nom"),
										       rs.getString("prenom"),
										       rs.getString(String.valueOf("datenaissance")),
										       rs.getString("profil"),
										       rs.getBinaryStream("fiche"),
										       rs.getString("mail"),
										       rs.getString("vip"));
					 daoprofil=rs.getString("profil");
				//we must change the type of fiche into BinaryStream in order to get the type bolb from bdd 
				
			     }
	
			} catch (Exception ee) {
				ee.printStackTrace();
			} finally {
				// fermeture du ResultSet, du PreparedStatement et de la Connexion
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (Exception ignore) {
				}
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
			//System.out.println(returnValue);
			return returnValue ;
			
		}
		       
		
		/// pour tous les affichages d'un type de profil, on utilise la valeur contenue dans la variable profil ; variable recupere quant un utilisateur se connecte 
   //commercant
		/**
		 * Permet retourner toutes les informations propre a un commerçant dans la table des commercants
		 * 
		 * @param mail du participant qui se connecte 
		 * @return un objet de type commeçant : model 
		 */
		public Commercant affichevoirplusco(String mail) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Commercant  returnValue=null ;
	
			// connexion a la base de donnees
			try {
				con = DriverManager.getConnection(URL, LOGIN, PASS);
					ps = con.prepareStatement("SELECT * FROM commercants WHERE mailco= ?");
					ps.setString(1, daomail);
					
					// on execute la requete
					// rs contient un pointeur situe juste avant la premiere ligne retournee
					rs = ps.executeQuery();
		            if (rs.next()) {				
						returnValue = new Commercant (rs.getInt("idcom"),
											       rs.getString("activit"),
											       rs.getString("stand") );
											     
					             }
			
			} catch (Exception ee) {
				ee.printStackTrace();
			} finally {
				// fermeture du ResultSet, du PreparedStatement et de la Connexion
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (Exception ignore) {
				}
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
			//System.out.println(returnValue);
		    return returnValue ;
			
		}
		/**
		 * Permet retourner toutes les informations propre a un Bateau  dans la table des bateau
		 * @param mail du participant qui se connecte 
		 * @return un objet de type bateau dans model 
		 */

		public Plaisancier affichevoirpluspl(String mail) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Plaisancier returnValue=null ;
	
			// connexion a la base de donnees
			try {
				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM plaisancier WHERE mailpl= ?");
				ps.setString(1, daomail);
				// car ou profil est entreprise
					// on execute la requete
					// rs contient un pointeur situe juste avant la premiere ligne retournee
					rs = ps.executeQuery();
		            if (rs.next()) {				
						returnValue = new Plaisancier (rs.getInt("idpla"),
								                   rs.getString("emplacement"),
											       rs.getString("nombt"),
											       rs.getString("pavillon"),
											       rs.getString("arriver"),
											       rs.getString("depart"),
											       rs.getString("datefabrication"),
											       rs.getDouble("taille")
											       );
											     
					             }
			} catch (Exception ee) {
				ee.printStackTrace();
			} finally {
				// fermeture du ResultSet, du PreparedStatement et de la Connexion
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (Exception ignore) {
				}
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
			//System.out.println(returnValue);
		    return returnValue ;
			
		}
		
		//entreprise
		/**
		 * Permet retourner toutes les informations propre a une Entreprise dans la table des Entreprise
		 * @param mail du participant qui se connecte 
		 * @return un objet de type Entreprise : model 
		 */
		public Entreprise affichevoirplusen(String mail) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Entreprise returnValue=null ;
	
			// connexion a la base de donnees
			try {
				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM entreprise WHERE mailen= ?");
				ps.setString(1, daomail);
				// car ou profil est entreprise
				
				// on execute la requete
				// rs contient un pointeur situe juste avant la premiere ligne retournee
				rs = ps.executeQuery();
	            if (rs.next()) {				
					returnValue = new Entreprise (rs.getString("nomentreprise"),
										       rs.getString("immatriculation"))  ;
				             }
					
			
			} catch (Exception ee) {
				ee.printStackTrace();
			} finally {
				// fermeture du ResultSet, du PreparedStatement et de la Connexion
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (Exception ignore) {
				}
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
			//System.out.println(returnValue);
		    return returnValue ;
			
		}
		
		//delegation
		/**
		 * Permet retourner toutes les informations propre a une delegation dans la table des delegation
		 * @param mail du participant qui se connecte 
		 * @return un objet de type delegation : model 
		 */
		public Delegation affichevoirplusde(String mail) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Delegation returnValue=null ;
	
			// connexion a la base de donnees
			try {
				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM delegation WHERE mailde= ?");
				ps.setString(1, daomail);
				// car ou profil est entreprise
					// on execute la requete
					// rs contient un pointeur situe juste avant la premiere ligne retournee
					rs = ps.executeQuery();
		            if (rs.next()) {				
						returnValue = new Delegation (rs.getInt("iddel"),
											       rs.getString("pays"),
											       rs.getInt("nombredepersonne"));
											     
					             }
			} catch (Exception ee) {
				ee.printStackTrace();
			} finally {
				// fermeture du ResultSet, du PreparedStatement et de la Connexion
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (Exception ignore) {
				}
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
			//System.out.println(returnValue);
		    return returnValue ;
			
		}

		//Familles d'accueil 
		/**
		 * Permet retourner toutes les informations propre a une Familles d'accueil  dans la table des Familles d'accueil 
		 * @param mail du participant qui se connecte 
		 * @return un objet de type Familles d'accueil  : model 
		 */
		
		public FamilleAcc affichevoirplusfa(String mail) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			FamilleAcc returnValue=null ;
	
			// connexion a la base de donnees
			try {
				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM familles WHERE mailfa= ?");
				ps.setString(1, daomail);
				// car ou profil est entreprise
					// on execute la requete
					// rs contient un pointeur situe juste avant la premiere ligne retournee
					rs = ps.executeQuery();
		            if (rs.next()) {				
						returnValue = new FamilleAcc (rs.getInt("idfam"),
											       rs.getString("nomfamilles"),
											       rs.getString("adress"),
											       rs.getInt("nombredeplace"));
											     
					             }
			} catch (Exception ee) {
				ee.printStackTrace();
			} finally {
				// fermeture du ResultSet, du PreparedStatement et de la Connexion
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (Exception ignore) {
				}
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
			//System.out.println(returnValue);
		    return returnValue ;
			
		}

		/// UPDATE dans cette section se retrouve les fonfions utiliser par un utilisateur pour effectuer des changemens sur son profil
		      //familles
		/**
		 * Permet Modifier toutes les informations propre a une Familles d'accueil  dans la table des Familles d'accueil 
		 * @param mail du participant qui se connecte 
		 * @return la modification effectuer dans la table Familles d'accueil 
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
	
		// delegation
		/**
		 * Permet Modifier toutes les informations propre a une delegation  dans la table des delegation 
		 * @param mail du participant qui se connecte 
		 * @return la modification effectuer dans la table delegation 
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
		
		//bateau
		/**
		 * Permet Modifier toutes les informations propre a une bateau  dans la table des bateau 
		 * @param mail du participant qui se connecte 
		 * @return la modification effectuer dans la table bateau 
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
		
		//commercant
		/**
		 * Permet Modifier toutes les informations propre a une commercant  dans la table des commercant 
		 * @param mail du participant qui se connecte 
		 * @return la modification effectuer dans la table commercant 
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
		
		// entreprise
		/**
		 * Permet Modifier toutes les informations propre a une entreprise  dans la table des entreprise 
		 * @param mail du participant qui se connecte 
		 * @return la modification effectuer dans la table entreprise 
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
		
		
}
