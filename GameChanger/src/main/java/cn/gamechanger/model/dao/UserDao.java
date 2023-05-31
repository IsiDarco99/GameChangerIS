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
	
	public UserDao() {
		super();
	}
	
	public User userLogin(String email, String password) {
		User user = null;
		
		try {
			query = "select * from users where email=? and password=?";
			
			pst = this.con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			
			if(rs.next()){
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setNome(rs.getString("nome"));
				user.setCognome(rs.getString("cognome"));
				user.setDataNascita(rs.getString("data_nascita"));
				user.setCodFiscale(rs.getString("codfiscale"));
				user.setNumProdAcquist(rs.getString("num_prodotti_acq"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		
		return user;
	}
}
