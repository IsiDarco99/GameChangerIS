package cn.gamechanger.model.dao;

import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.User;

public class UserDao {
	private Connection con;
	private static final Logger logger = Logger.getLogger(DbCon.class.getName());
	
	public UserDao(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String username, String password) {
		User user = null;
		
		try {
			String query = "select * from utente where username=? and password=?";
			
			PreparedStatement pst = this.con.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setEmailPers(rs.getString("email_pers"));
				user.setEmailPaypal(rs.getString("email_paypal"));
				user.setNumTel(rs.getInt(4));
				user.setIndirizzo(rs.getString("indirizzo"));
				user.setStato(rs.getString("stato"));
				user.setCitta(rs.getString("citta"));
				user.setCod_postale(rs.getInt(8));
				user.setPassword(rs.getString("password"));
				user.setNome(rs.getString("nome"));
				user.setCognome(rs.getString("cognome"));
				user.setDataNascita(rs.getString("data_nascita"));
				user.setCodFiscale(rs.getString("codfiscale"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		
		return user;
	}
	
	public boolean registerUser(User user) {
	    try {
	        String query = "INSERT INTO utente (username, email_pers, password, nome, cognome, data_nascita) VALUES (?, ?, ?, ?, ?, ?)";

	        PreparedStatement pst = this.con.prepareStatement(query);
	        pst.setString(1, user.getUsername());
	        pst.setString(2, user.getEmailPers());
	        pst.setString(3, user.getPassword());
	        pst.setString(4, user.getNome());
	        pst.setString(5, user.getCognome());
	        pst.setString(6, user.getDataNascita());

	        int rowsAffected = pst.executeUpdate();

	        return rowsAffected > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	        return false;
	    }
	}
	
	public User getUserProfile(String username) {
User user = null;
		
		try {
			String query = "select * from utente where username=?";
			
			PreparedStatement pst = this.con.prepareStatement(query);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setEmailPers(rs.getString("email_pers"));
				user.setEmailPaypal(rs.getString("email_paypal"));
				user.setNumTel(rs.getInt(4));
				user.setIndirizzo(rs.getString("indirizzo"));
				user.setStato(rs.getString("stato"));
				user.setCitta(rs.getString("citta"));
				user.setCod_postale(rs.getInt(8));
				user.setPassword(rs.getString("password"));
				user.setNome(rs.getString("nome"));
				user.setCognome(rs.getString("cognome"));
				user.setDataNascita(rs.getString("data_nascita"));
				user.setCodFiscale(rs.getString("codfiscale"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		
		return user;
	}
	
	public void updateUser(User user) {
	    try {
	        String query = "UPDATE utente SET indirizzo = ?, citta = ?, stato = ?, cod_postale = ? WHERE username = ?";

	        PreparedStatement pst = this.con.prepareStatement(query);
	        pst.setString(1, user.getIndirizzo());
	        pst.setString(2, user.getCitta());
	        pst.setString(3, user.getStato());
	        pst.setInt(4, user.getCod_postale());
	        pst.setString(5, user.getUsername());
	        
	        pst.executeUpdate();
	        pst.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    }
	}
	
	public void updateUserPayPal(User user) {
	    try {
	        String query = "UPDATE utente SET email_paypal = ? WHERE username = ?";

	        PreparedStatement pst = this.con.prepareStatement(query);
	        pst.setString(1, user.getEmailPaypal());
	        pst.setString(2, user.getUsername());
	        
	        pst.executeUpdate();
	        pst.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    }
	}
	public User getCheckoutUser(String username) {
		User user = null;
		
		try {
			String query = "select * from utente where username=?";
			
			PreparedStatement pst = this.con.prepareStatement(query);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
		
			if(rs.next()){
				user = new User();
				user.setNome(rs.getString("nome"));
				user.setCognome(rs.getString("cognome"));
				user.setIndirizzo(rs.getString("indirizzo"));
				user.setStato(rs.getString("stato"));
				user.setCitta(rs.getString("citta"));
				user.setCod_postale(rs.getInt(8));
				user.setNumTel(rs.getInt(4));
				user.setEmailPaypal(rs.getString("email_paypal"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
	}
		return user;
	}
}
    