package cn.gamechanger.model.dao;


import java.util.ArrayList;
import java.util.List;
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
	
	public void updatePassword(int id, String nuovaPassword) {
	    try {
	        String query = "UPDATE utente SET password = ? WHERE username = ?";

	        PreparedStatement pst = this.con.prepareStatement(query);
	        pst.setString(1, nuovaPassword);
	        pst.setInt(2, id);
	        
	        pst.executeUpdate();
	        pst.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    }
	}
<<<<<<< HEAD
	
	public void updateNome(int id, String nuovoNome) {
	    try {
	        String query = "UPDATE utente SET nome = ? WHERE username = ?";

	        PreparedStatement pst = this.con.prepareStatement(query);
	        pst.setString(1, nuovoNome);
	        pst.setInt(2, id);

	        pst.executeUpdate();
	        pst.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    }
	}

	public void updateCognome(int id, String nuovoCognome) {
	    try {
	        String query = "UPDATE utente SET cognome = ? WHERE username = ?";

	        PreparedStatement pst = this.con.prepareStatement(query);
	        pst.setString(1, nuovoCognome);
	        pst.setInt(2, id);

	        pst.executeUpdate();
	        pst.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    }
	}
	public void insertProdotto(int codice, float prezzo, String nome, String marca, String descrizione, String data_usc) {
=======
	public void insertProdotto(float prezzo, String nome, String marca, String descrizione, String data_usc) {
>>>>>>> branch 'master' of https://github.com/IsiDarco99/GameChangerRep
	  try {
		  String query = "INSERT INTO prodotto (prezzo, nome, marca, descrizione, data_usc) VALUES (?, ?, ?, ?, ?)";
		  
		  PreparedStatement statement = this.con.prepareStatement(query);
		  
		  statement.setFloat(1, prezzo);
		  statement.setString(2, nome);
		  statement.setString(3, marca);
		  statement.setString(4, descrizione);
		  statement.setString(5,  data_usc);
	  
		  statement.executeUpdate();
          statement.close();
		  
		
		
	  }	
	  catch (Exception e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    }
	}
	public void updateProdotto(int codice, float prezzo, String nome, String marca, String descrizione, String data_usc) {
	    try {
	        String query = "UPDATE prodotto SET prezzo = ?, nome = ?, marca = ?, descrizione = ?, data_usc = ? WHERE codice = ?";
	        
	        PreparedStatement statement = this.con.prepareStatement(query);
	        statement.setFloat(1, prezzo);
	        statement.setString(2, nome);
	        statement.setString(3, marca);
	        statement.setString(4, descrizione);
	        statement.setString(5, data_usc);
	        statement.setInt(6, codice);
	        
	        statement.executeUpdate();
	        statement.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    }
	    
	}
	
	public void deleteProdotto(int codice) {
	    try {
	        String query = "DELETE FROM prodotto WHERE codice = ?";
	        
	        PreparedStatement statement = this.con.prepareStatement(query);
	        statement.setInt(1, codice);
	        
	        statement.executeUpdate();
	        statement.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    }
	}

	public List<Prodotto> selezionaProdotto(){
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		
		try {
			String query = "SELECT * FROM prodotto";
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
	
	public void insertVideogame(int pegi, String sviluppatore, String genere) {
		  try {
			  String query = "INSERT INTO videogame (pegi, sviluppatore, genere) VALUES (?, ?, ?)";
			  
			  PreparedStatement statement = this.con.prepareStatement(query);			
			  statement.setInt(1, pegi);
			  statement.setString(2, sviluppatore);
			  statement.setString(3, genere);
			  
		  
			  statement.executeUpdate();
	          statement.close();
			  
			
			
		  }	
		  catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}
	
	public void insertAccessorio(String tipo ) {
		  try {
			  String query = "INSERT INTO accessorio (tipo) VALUES (?)";
			  
			  PreparedStatement statement = this.con.prepareStatement(query);			  
			  statement.setString(1, tipo);
			  
					  
			  statement.executeUpdate();
	          statement.close();
			  
			
			
		  }	
		  catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}
	public void insertComputer(String casa, String ufficio, String gaming) {
		  try {
			  String query = "INSERT INTO computer (casa, ufficio, gaming) VALUES (?, ?, ?)";
			  
			  PreparedStatement statement = this.con.prepareStatement(query);
			  statement.setString(1, casa);
			  statement.setString(2, ufficio);
			  statement.setString(3, gaming);
			  
		  
			  statement.executeUpdate();
	          statement.close();
			  
			
			
		  }	
		  catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}
	public void insertConsole(int generazione) {
		  try {
			  String query = "INSERT INTO console (pegi, sviluppatore, genre) VALUES (?)";
			  
			  PreparedStatement statement = this.con.prepareStatement(query);
			  statement.setInt(2, generazione);
			
		  
			  statement.executeUpdate();
	          statement.close();
			  
			
			
		  }	
		  catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}
}

   
