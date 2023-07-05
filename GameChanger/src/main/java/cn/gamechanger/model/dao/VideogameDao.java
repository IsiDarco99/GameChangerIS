package cn.gamechanger.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Accessorio;
import cn.gamechanger.model.Videogame;

public class VideogameDao {
	private Connection con;
	private static final Logger logger = Logger.getLogger(DbCon.class.getName());
	public VideogameDao(Connection con) {
		this.con = con;
	}
	
	public List<Videogame> getAllVideogame(){
		List<Videogame> videogames = new ArrayList<Videogame>();
		
		try {
			String query = "SELECT * FROM prodotto JOIN videogame ON prodotto.codice = videogame.codice";
			PreparedStatement pst = this.con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Videogame row = new Videogame();
				row.setCodice(rs.getInt("codice"));
				row.setNome(rs.getString("nome"));
				row.setPrezzo(rs.getFloat("prezzo"));
				row.setMarca(rs.getString("marca"));
				row.setDescrizione(rs.getString("descrizione"));
				row.setDataUscita(rs.getDate("data_usc"));
				row.setPegi(rs.getString("pegi"));
				row.setSviluppatore(rs.getString("sviluppatore"));
				row.setGenere(rs.getString("genere"));
				
				videogames.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return videogames;
	}
	
	public Videogame getVideogameByCodice(int codice){
		Videogame videogame = null;
		
		try {
			String query = "SELECT * FROM prodotto JOIN videogame ON prodotto.codice = videogame.codice WHERE videogame.codice = ?";
			PreparedStatement pst = this.con.prepareStatement(query);
			pst.setInt(1, codice);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				videogame = new Videogame();
				videogame.setCodice(rs.getInt("codice"));
				videogame.setNome(rs.getString("nome"));
				videogame.setPrezzo(rs.getFloat("prezzo"));
				videogame.setMarca(rs.getString("marca"));
				videogame.setDescrizione(rs.getString("descrizione"));
				videogame.setDataUscita(rs.getDate("data_usc"));
				videogame.setPegi(rs.getString("pegi"));
				videogame.setSviluppatore(rs.getString("sviluppatore"));
				videogame.setGenere(rs.getString("genere"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return videogame;
	}
	
	public List<Videogame> getVideogameByPrezzo(int min, int max) {
	    List<Videogame> videogame = new ArrayList<Videogame>();
	    
	    try {
	        String query = "SELECT * FROM prodotto JOIN videogame ON prodotto.codice = videogame.codice WHERE prezzo >= ? AND prezzo <= ?";
	        PreparedStatement pst = this.con.prepareStatement(query);
	        pst.setInt(1, min);
	        pst.setInt(2, max);
	        ResultSet rs = pst.executeQuery();
	        while (rs.next()) {
	        	Videogame row = new Videogame();
	        	row.setCodice(rs.getInt("codice"));
	        	row.setNome(rs.getString("nome"));
	        	row.setPrezzo(rs.getFloat("prezzo"));
	        	row.setMarca(rs.getString("marca"));
	        	row.setDescrizione(rs.getString("descrizione"));
	        	row.setDataUscita(rs.getDate("data_usc"));
	        	row.setPegi(rs.getString("pegi"));
	        	row.setSviluppatore(rs.getString("sviluppatore"));
	        	row.setGenere(rs.getString("genere"));
	        	
	        	videogame.add(row);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return videogame;
	}
	
}
