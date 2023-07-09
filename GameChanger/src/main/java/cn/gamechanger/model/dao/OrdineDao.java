package cn.gamechanger.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.logging.Logger;

import cn.gamechanger.connection.DbCon;

import cn.gamechanger.model.Ordine;


public class OrdineDao {
	
	private Connection con;
	private static final Logger logger = Logger.getLogger(DbCon.class.getName());
	public OrdineDao(Connection con) {
		this.con = con;
		
	}
	public Ordine salvaOrdine(String username, int codice, int quant_prod, float prezzo, String stato_ord, int data_ord) {
     Ordine ordine = null;
		
        try {
            
            String query = "INSERT INTO ordine (username, codice, quant_prod, prezzo, stato_ord, data_ord) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = this.con.prepareStatement(query);
            statement.setString(1, username);
            statement.setInt(2, codice);
            statement.setInt(3, quant_prod);
            statement.setFloat(4, prezzo);
            statement.setString(5, stato_ord);
            statement.setInt(6, data_ord);
            statement.executeUpdate();
            statement.close();
        } 
        
        catch (SQLException e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }
		return ordine;
        
    }
}