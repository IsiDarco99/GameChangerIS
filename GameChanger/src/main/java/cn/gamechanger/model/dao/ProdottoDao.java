package cn.gamechanger.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.jsp.tagext.TryCatchFinally;

import com.mysql.cj.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Prodotto;


public class ProdottoDao {
	private Connection con;
	private static final Logger logger = Logger.getLogger(DbCon.class.getName());
	public ProdottoDao(Connection con) {
		this.con = con;
	}
	
	public List<Prodotto> getAllProdotto(){
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		
		try {
			String query = "select * from prodotto";
			PreparedStatement pst = this.con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Prodotto row = new Prodotto();
				row.setCodice(rs.getInt("codice"));
				row.setNome(rs.getString("nome"));
				row.setPrezzo(rs.getFloat("prezzo"));
				row.setMarca(rs.getString("marca"));
				row.setDescrizione(rs.getString("descrizione"));
				row.setDataUscita(rs.getDate("data_usc"));
				
				prodotti.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prodotti;
	}
	
	public Prodotto getProdottoByCodice(int codice) {
	    Prodotto prodotto = null;
	    
	    try {
	        String query = "SELECT * FROM prodotto WHERE codice = ?";
	        PreparedStatement pst = this.con.prepareStatement(query);
	        pst.setInt(1, codice);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            prodotto = new Prodotto();
	            prodotto.setCodice(rs.getInt("codice"));
	            prodotto.setNome(rs.getString("nome"));
	            prodotto.setPrezzo(rs.getFloat("prezzo"));
	            prodotto.setMarca(rs.getString("marca"));
	            prodotto.setDescrizione(rs.getString("descrizione"));
	            prodotto.setDataUscita(rs.getDate("data_usc"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return prodotto;
	}
	/*
	public Prodotto getProdottoByPrezzo(int min, int max) {
	    Prodotto prodotto = null;
	    
	    try {
	        String query = "SELECT * FROM prodotto WHERE codice = ?";
	        PreparedStatement pst = this.con.prepareStatement(query);
	        pst.setInt(1, codice);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            prodotto = new Prodotto();
	            prodotto.setCodice(rs.getInt("codice"));
	            prodotto.setNome(rs.getString("nome"));
	            prodotto.setPrezzo(rs.getFloat("prezzo"));
	            prodotto.setMarca(rs.getString("marca"));
	            prodotto.setDescrizione(rs.getString("descrizione"));
	            prodotto.setDataUscita(rs.getDate("data_usc"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return prodotto;
	}*/


}