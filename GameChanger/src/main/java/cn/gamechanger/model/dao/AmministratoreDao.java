package cn.gamechanger.model.dao;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import cn.gamechanger.model.*;
import cn.gamechanger.connection.DbCon;
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
}