package dao;
import model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import gui.*;
   
public class Attribution extends ConnectionDAO {
	

	 public Attribution() { 
			super();
			}
		/*
		 * permet de modifier le stand des commmercants a partir de son id 
		 * @param id
		 */
		
		//commercant
		public int updatecom (String stand, int id) {
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
				     
					ps = con.prepareStatement("UPDATE commercants set stand=? where idcom=? ");
					ps.setString(1, stand);
					ps.setInt(2, id);
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
		
		// pour attribuer un emplacement
		/*
		 * permet de modifier l'emplacement  des bateaux  a partir de son id 
		 * @param id
		 * 
		 * @return
		 */
		public int updatemplacement (String emplacement, int id) {
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
				     
					ps = con.prepareStatement("UPDATE Plaisancier set emplacement=?	 where idpla=? ");
					ps.setString(1,emplacement);
					ps.setInt(2, id);
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

