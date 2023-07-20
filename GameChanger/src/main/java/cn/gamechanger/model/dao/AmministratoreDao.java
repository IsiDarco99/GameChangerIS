package cn.gamechanger.model.dao;


import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import cn.gamechanger.model.*;
import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Amministratore;
public class AmministratoreDao {
	private Connection con;
	private static final Logger logger = Logger.getLogger(DbCon.class.getName());
	
	public AmministratoreDao(Connection con) {
		this.con = con;
	}
	
	public Amministratore adminLogin(String email, String password) {
		Amministratore admin = null;
		
		try {
			String query = "select * from amministratore where email=? and password=?";
			
			PreparedStatement pst = this.con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				admin = new Amministratore();
				admin.setIdAmministratore(rs.getInt(1));
				admin.setEmail(rs.getString("email"));
				admin.setPassword(rs.getString("password"));
				admin.setNome(rs.getString("nome"));
				admin.setCognome(rs.getString("cognome"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		
		return admin;
	}
	
	public Amministratore getAdmin(int id) {
		Amministratore admin = null;
		
		try {
			String query = "select * from amministratore where id_amministratore=?";
			
			PreparedStatement pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				admin = new Amministratore();
				admin.setIdAmministratore(rs.getInt(1));
				admin.setEmail(rs.getString("email"));
				admin.setPassword(rs.getString("password"));
				admin.setNome(rs.getString("nome"));
				admin.setCognome(rs.getString("cognome"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		
		return admin;
	}
	
	public void updatePassword(int id, String nuovaPassword) {
	    try {
	        String query = "UPDATE utente SET password = ? WHERE username = ?";

	        PreparedStatement pst = this.con.prepareStatement(query);
	        pst.setString(1, nuovaPassword);
	        pst.setInt(2, id);
	        
	        pst.executeUpdate();
	        pst.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    }
	}
	
	public void updateNome(int id, String nuovoNome) {
	    try {
	        String query = "UPDATE utente SET nome = ? WHERE username = ?";

	        PreparedStatement pst = this.con.prepareStatement(query);
	        pst.setString(1, nuovoNome);
	        pst.setInt(2, id);

	        pst.executeUpdate();
	        pst.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    }
	}

	public void updateCognome(int id, String nuovoCognome) {
	    try {
	        String query = "UPDATE utente SET cognome = ? WHERE username = ?";

	        PreparedStatement pst = this.con.prepareStatement(query);
	        pst.setString(1, nuovoCognome);
	        pst.setInt(2, id);

	        pst.executeUpdate();
	        pst.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    }
	}
	public void insertProdotto(int codice, float prezzo, String nome, String marca, String descrizione, String data_usc) {
	  try {
		  String query = "INSERT INTO prodotto (codice, prezzo, nome, marca, descrizione, data_usc) VALUES (?, ?, ?, ?, ?, ?)";
		  
		  PreparedStatement statement = this.con.prepareStatement(query);
		  statement.setInt(1, codice);
		  statement.setFloat(2, prezzo);
		  statement.setString(3, nome);
		  statement.setString(4, marca);
		  statement.setString(5, descrizione);
		  statement.setString(6,  data_usc);
	  
		  statement.executeUpdate();
          statement.close();
		  
		
		
	  }	
	  catch (Exception e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    }
	}
}

   
