package cn.gamechanger.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Accessorio;

public class AccessorioDao {
	private Connection con;
	private static final Logger logger = Logger.getLogger(DbCon.class.getName());
	public AccessorioDao(Connection con) {
		this.con = con;
	}
	
	public List<Accessorio> getAllAccessori(){
		List<Accessorio> accessori = new ArrayList<Accessorio>();
		
		try {
			String query = "SELECT * FROM prodotto JOIN accessorio ON prodotto.codice = accessorio.codice";
			PreparedStatement pst = this.con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Accessorio row = new Accessorio();
				row.setCodice(rs.getInt("codice"));
				row.setNome(rs.getString("nome"));
				row.setPrezzo(rs.getFloat("prezzo"));
				row.setMarca(rs.getString("marca"));
				row.setDescrizione(rs.getString("descrizione"));
				row.setDataUscita(rs.getDate("data_usc"));
				row.setTipo(rs.getString("tipo"));
				
				accessori.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return accessori;
	}
	
	public Accessorio getAccessorioByCodice(int codice){
		Accessorio accessorio = null;
		
		try {
			String query = "SELECT * FROM prodotto JOIN accessorio ON prodotto.codice = accessorio.codice WHERE accessorio.codice = ?";
			PreparedStatement pst = this.con.prepareStatement(query);
			pst.setInt(1, codice);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				accessorio = new Accessorio();
				accessorio.setCodice(rs.getInt("codice"));
				accessorio.setNome(rs.getString("nome"));
				accessorio.setPrezzo(rs.getFloat("prezzo"));
				accessorio.setMarca(rs.getString("marca"));
				accessorio.setDescrizione(rs.getString("descrizione"));
				accessorio.setDataUscita(rs.getDate("data_usc"));
				accessorio.setTipo(rs.getString("tipo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return accessorio;
	}
	
	public List<Accessorio> getAccessorioByPrezzo(int min, int max) {
	    List<Accessorio> accessori = new ArrayList<Accessorio>();    
	    try {
	        String query = "SELECT * FROM prodotto JOIN accessorio ON prodotto.codice = accessorio.codice WHERE prezzo >= ? AND prezzo <= ?";
	        PreparedStatement pst = this.con.prepareStatement(query);
	        pst.setInt(1, min);
	        pst.setInt(2, max);
	        ResultSet rs = pst.executeQuery();
	        while (rs.next()) {
	        	Accessorio row = new Accessorio();
	        	row.setCodice(rs.getInt("codice"));
	        	row.setNome(rs.getString("nome"));
	        	row.setPrezzo(rs.getFloat("prezzo"));
	        	row.setMarca(rs.getString("marca"));
	        	row.setDescrizione(rs.getString("descrizione"));
	        	row.setDataUscita(rs.getDate("data_usc"));
	        	row.setTipo(rs.getString("tipo"));
	        	
	        	accessori.add(row);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return accessori;
	}
	
	public void insertAccessorio(int codice, String tipo ) {
		  try {
			  String query = "INSERT INTO accessorio (codice, tipo) VALUES (?, ?)";
			  
			  PreparedStatement statement = this.con.prepareStatement(query);			  
			  statement.setInt(1, codice);
			  statement.setString(2, tipo);
			  statement.executeUpdate();
	          statement.close();
			  
			
			
		  }	
		  catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		 
		}
	
}
