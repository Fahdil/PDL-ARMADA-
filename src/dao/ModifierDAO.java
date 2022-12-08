package dao;
import model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import gui.*;
public class ModifierDAO extends ConnectionDAO {
   
	
	public ModifierDAO() {
		super();
		}
		/**
		 * Permet de modifier le statut d'un participant vip ou non.
		 * Le mode est auto-commit par defaut : chaque suppression est validee
		 * @param valeurvip 
		 * @param mail 
		 * @return retourne le nombre de lignes modifier dans la table personne moral
		 */
		public int vip(String mail, String valeurvip) {
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
			
					
						 ps = con.prepareStatement("UPDATE personnemoral set vip=? WHERE mail = ?");
							ps.setString(1, valeurvip);
							ps.setString(2, mail);
					 
					// Execution de la requete
						returnValue = ps.executeUpdate();
					 

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
		
		/**
		 * Permet d'afficher les informations de  de la personne moral a modifier
		 * @param mail 
		 * @return une personne moral
		 */		
		public Personmoral affiche(String mail) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Personmoral returnValue=null ;
			// connexion a la base de donnees
			try {
                    
				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM personnemoral WHERE mail= ?");
				ps.setString(1, mail);
				
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
		
   //commercant
		/**
		 * Permet d'afficher les commercant du commercant a modifier
		 * @param mail 
		 * @return une commercant
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
					ps.setString(1, mail);
					
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

           // Plaisancier
		/**
		 * Permet d'afficher les information  du Plaisancier a modifier
		 * @param mail 
		 * @return un Plaisancier
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
				ps.setString(1, mail);
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
		 * Permet d'afficher les informations de l'entreprise a modifier
		 * @param mail 
		 * @return une entreprise
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
				ps.setString(1, mail);
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
		 * Permet d'afficher les informations de delegation a modifier
		 * @param mail 
		 * @return une delegation
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
				ps.setString(1, mail);
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
           //familles
		/**
		 * Permet d'afficher les informations de familles a modifier
		 * @param mail 
		 * @return une famille d'accueil
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
				ps.setString(1, mail);
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
		
		/// UPDATE
	      //familles
		/**
		 * Permet Modifier toutes les informations propre a une entreprise  dans la table des familles 
		 * @param mail du participant 
		 * @param familleacc d'un participant de type  familleacc
		 */
	public int updatfam (FamilleAcc  familleacc, String mail) {
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
				ps.setString(4, mail);
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
	 * Permet Modifier toutes les informations propre a une entreprise  dans la table des delegation 
	 * @param mail du participant 
	 * @param delegation d'un participant de type  delegation
	 */
	public int updatdel (Delegation  delegation, String mail) {
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
				ps.setString(3,mail);
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
	 * @param mail du participant 
	 * @param delegation d'un participant de type  bateau
	 */
	public int updatebat (Plaisancier  plaisancier, String mail) {
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
				ps.setString(4, mail);
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
	 * @param mail du participant 
	 * @param commercant d'un participant de type  bateau
	 */
	public int updatecom (Commercant  commercant, String mail) {
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
				ps.setString(3, mail);
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
	 * @param mail du participant 
	 * @param commercant d'un participant de type  entreprise
	 */
	public int updateent (Entreprise  entreprise, String mail) {
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
				ps.setString(3, mail);
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
