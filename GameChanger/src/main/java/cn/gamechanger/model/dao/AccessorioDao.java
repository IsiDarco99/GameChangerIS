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
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	        String query = "SELECT * FROM prodotto JOIN accessorio ON prodotto.codice = accessorio.codice";
	        pst = this.con.prepareStatement(query);
	        rs = pst.executeQuery();

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
	    } finally {
	        // Chiusura delle risorse nel blocco "finally"
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        if (pst != null) {
	            try {
	                pst.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return accessori;
	}

	

	
	public List<Accessorio> getAccessorioByPrezzo(int min, int max) {
	    List<Accessorio> accessori = new ArrayList<Accessorio>();
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	        String query = "SELECT * FROM prodotto JOIN accessorio ON prodotto.codice = accessorio.codice WHERE prezzo >= ? AND prezzo <= ?";
	        pst = this.con.prepareStatement(query);
	        pst.setInt(1, min);
	        pst.setInt(2, max);
	        rs = pst.executeQuery();

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
	    } finally {
	        // Chiusura delle risorse nel blocco "finally"
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        if (pst != null) {
	            try {
	                pst.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return accessori;
	}

	

	public void insertAccessorio(int codice, String tipo) {
	    PreparedStatement statement = null;
	    
	    try {
	        String query = "INSERT INTO accessorio (codice, tipo) VALUES (?, ?)";
	        statement = this.con.prepareStatement(query);
	        
	        statement.setInt(1, codice);
	        statement.setString(2, tipo);
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // Chiusura della risorsa nel blocco "finally"
	        if (statement != null) {
	            try {
	                statement.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

	
	public void deleteAccessorio(String codice) {
	    PreparedStatement statement = null;

	    try {
	        String query = "DELETE FROM accessorio WHERE codice = ?";
	        statement = this.con.prepareStatement(query);
	        statement.setString(1, codice);
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // Chiusura della risorsa nel blocco "finally"
	        if (statement != null) {
	            try {
	                statement.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}


	public void updateAccessorio(int codice, String tipo) {
	    try {
	        String query = "UPDATE accessorio SET tipo = ? WHERE codice = ?";
	        
	        PreparedStatement statement = this.con.prepareStatement(query);
	        statement.setString(1, tipo);
	        statement.setInt(2, codice);
	        
	        statement.executeUpdate();
	        statement.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    }
	}

	
}

