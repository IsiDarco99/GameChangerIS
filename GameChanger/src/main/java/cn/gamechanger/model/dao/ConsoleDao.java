package cn.gamechanger.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Console;

public class ConsoleDao {
	private Connection con;
	private static final Logger logger = Logger.getLogger(DbCon.class.getName());
	public ConsoleDao(Connection con) {
		this.con = con;
	}
	
	public List<Console> getAllConsole(){
		List<Console> console = new ArrayList<Console>();
		
		try {
			String query = "SELECT * FROM prodotto JOIN console ON prodotto.codice = console.codice";
			PreparedStatement pst = this.con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Console row = new Console();
				row.setCodice(rs.getInt("codice"));
				row.setNome(rs.getString("nome"));
				row.setPrezzo(rs.getFloat("prezzo"));
				row.setMarca(rs.getString("marca"));
				row.setDescrizione(rs.getString("descrizione"));
				row.setDataUscita(rs.getDate("data_usc"));
				row.setGenerazione(rs.getInt(8));
				
				console.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return console;
	}
	
	public Console getConsoleByCodice(int codice){
		Console console = null;
		
		try {
			String query = "SELECT * FROM prodotto JOIN console ON prodotto.codice = console.codice WHERE console.codice = ?";
			PreparedStatement pst = this.con.prepareStatement(query);
			pst.setInt(1, codice);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				console = new Console();
				console.setCodice(rs.getInt("codice"));
				console.setNome(rs.getString("nome"));
				console.setPrezzo(rs.getFloat("prezzo"));
				console.setMarca(rs.getString("marca"));
				console.setDescrizione(rs.getString("descrizione"));
				console.setDataUscita(rs.getDate("data_usc"));
				console.setGenerazione(rs.getInt(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return console;
	}
	
	public List<Console> getConsoleByPrezzo(int min, int max) {
		List<Console> console = new ArrayList<Console>();
	    
	    try {
	        String query = "SELECT * FROM prodotto JOIN console ON prodotto.codice = console.codice WHERE prezzo >= ? AND prezzo <= ?";
	        PreparedStatement pst = this.con.prepareStatement(query);
	        pst.setInt(1, min);
	        pst.setInt(2, max);
	        ResultSet rs = pst.executeQuery();
	        while (rs.next()) {
	        	Console row = new Console();
				row.setCodice(rs.getInt("codice"));
				row.setNome(rs.getString("nome"));
				row.setPrezzo(rs.getFloat("prezzo"));
				row.setMarca(rs.getString("marca"));
				row.setDescrizione(rs.getString("descrizione"));
				row.setDataUscita(rs.getDate("data_usc"));
				row.setGenerazione(rs.getInt(8));
				
				console.add(row);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return console;
	}
	
	public void insertConsole(int codice, String generazione) {
	    PreparedStatement statement = null;

	    try {
	        String query = "INSERT INTO console (codice, generazione) VALUES (?, ?)";

	        statement = this.con.prepareStatement(query);
	        statement.setInt(1, codice);
	        statement.setString(2, generazione);
	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    } finally {
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            logger.info(e.getMessage());
	        }
	    }
	}

	
	public void deleteConsole(String codice) {
	    PreparedStatement statement = null;

	    try {
	        String query = "DELETE FROM console WHERE codice = ?";
	        statement = this.con.prepareStatement(query);
	        statement.setString(1, codice);
	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    } finally {
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            logger.info(e.getMessage());
	        }
	    }
	}

	
	public void updateConsole(int codice, String generazione) {
	    PreparedStatement statement = null;

	    try {
	        String query = "UPDATE console SET generazione = ? WHERE codice = ?";
	        statement = this.con.prepareStatement(query);
	        statement.setString(1, generazione);
	        statement.setInt(2, codice);
	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    } finally {
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            logger.info(e.getMessage());
	        }
	    }
	}


}
