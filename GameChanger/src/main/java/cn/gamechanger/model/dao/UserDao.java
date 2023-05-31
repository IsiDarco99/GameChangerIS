package cn.gamechanger.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.gamechanger.model.User;

public class UserDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public UserDao(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String email, String password) {
		User user = null;
		
		try {
			query = "select * from utente where username=? and password=?";
			
			pst = this.con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			
			if(rs.next()){
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setEmailPers(rs.getString("email_pers"));
				user.setEmailPaypal(rs.getString("email_paypal"));
				user.setNumTel(rs.getInt(0));
				user.setIndirizzo(rs.getString("indirizzo"));
				user.setPassword(rs.getString("password"));
				user.setNome(rs.getString("nome"));
				user.setCognome(rs.getString("cognome"));
				user.setDataNascita(rs.getString("data_nascita"));
				user.setCodFiscale(rs.getString("codfiscale"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		
		return user;
	}
}
