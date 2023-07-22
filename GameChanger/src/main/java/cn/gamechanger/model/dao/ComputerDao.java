package cn.gamechanger.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Accessorio;
import cn.gamechanger.model.Computer;

public class ComputerDao {
	private Connection con;
	private static final Logger logger = Logger.getLogger(DbCon.class.getName());
	public ComputerDao(Connection con) {
		this.con = con;
	}
	
	public List<Computer> getAllComputer(){
		List<Computer> computers = new ArrayList<Computer>();
		
		try {
			String query = "SELECT * FROM prodotto JOIN computer ON prodotto.codice = computer.codice";
			PreparedStatement pst = this.con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Computer row = new Computer();
				row.setCodice(rs.getInt("codice"));
				row.setNome(rs.getString("nome"));
				row.setPrezzo(rs.getFloat("prezzo"));
				row.setMarca(rs.getString("marca"));
				row.setDescrizione(rs.getString("descrizione"));
				row.setDataUscita(rs.getDate("data_usc"));
				row.setCasa(rs.getString("casa"));
				row.setUfficio(rs.getString("ufficio"));
				row.setGaming(rs.getString("gaming"));
				
				computers.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return computers;
	}
	
	public Computer getComputerByCodice(int codice){
		Computer computer = null;
		
		try {
			String query = "SELECT * FROM prodotto JOIN computer ON prodotto.codice = computer.codice WHERE computer.codice = ?";
			PreparedStatement pst = this.con.prepareStatement(query);
			pst.setInt(1, codice);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				computer = new Computer();
				computer.setCodice(rs.getInt("codice"));
				computer.setNome(rs.getString("nome"));
				computer.setPrezzo(rs.getFloat("prezzo"));
				computer.setMarca(rs.getString("marca"));
				computer.setDescrizione(rs.getString("descrizione"));
				computer.setDataUscita(rs.getDate("data_usc"));
				computer.setCasa(rs.getString("casa"));
				computer.setUfficio(rs.getString("ufficio"));
				computer.setGaming(rs.getString("gaming"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return computer;
	}
	
	public List<Computer> getComputerByPrezzo(int min, int max) {
	    List<Computer> computer = new ArrayList<>();
	    
	    try {
	        String query = "SELECT * FROM prodotto JOIN computer ON prodotto.codice = computer.codice WHERE prezzo >= ? AND prezzo <= ?";
	        PreparedStatement pst = this.con.prepareStatement(query);
	        pst.setInt(1, min);
	        pst.setInt(2, max);
	        ResultSet rs = pst.executeQuery();
	        while (rs.next()) {
	        	Computer row = new Computer();
	        	row.setCodice(rs.getInt("codice"));
	        	row.setNome(rs.getString("nome"));
	        	row.setPrezzo(rs.getFloat("prezzo"));
	        	row.setMarca(rs.getString("marca"));
	        	row.setDescrizione(rs.getString("descrizione"));
	        	row.setDataUscita(rs.getDate("data_usc"));
	        	row.setCasa(rs.getString("casa"));
	        	row.setUfficio(rs.getString("ufficio"));
	        	row.setGaming(rs.getString("gaming"));
	        	
	        	computer.add(row);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return computer;
	}
	
	public void insertComputer(int codice, String casa, String ufficio, String gaming) {
		  try {
			  String query = "INSERT INTO computer (codice, casa, ufficio, gaming) VALUES (?, ?, ?, ?)";
			  
			  PreparedStatement statement = this.con.prepareStatement(query);
			  statement.setInt(1, codice);
			  statement.setString(2, casa);
			  statement.setString(3, ufficio);
			  statement.setString(4, gaming);
			  
		  
			  statement.executeUpdate();
	          statement.close();
			  
			
			
		  }	
		  catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}
	
	public void deleteComputer(String codice) {
	    try {
	        String query = "DELETE FROM computer WHERE codice = ?";
	        
	        PreparedStatement statement = this.con.prepareStatement(query);
	        statement.setString(1, codice);
	        
	        statement.executeUpdate();
	        statement.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    }
	    
	}
	
	public void updateComputer(int codice, String casa, String ufficio, String gaming) {
	    try {
	        String query = "UPDATE computer SET casa = ?, ufficio = ?, gaming = ? WHERE codice = ?";
	        
	        PreparedStatement statement = this.con.prepareStatement(query);
	        statement.setString(1, casa);
	        statement.setString(2, ufficio);
	        statement.setString(3, gaming);
	        statement.setInt(4, codice);
	        
	        statement.executeUpdate();
	        statement.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    }
	}

	
}
