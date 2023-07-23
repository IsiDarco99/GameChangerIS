package cn.gamechanger.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Prodotto;


public class ProdottoDao {
	private Connection con;
	private static final Logger logger = Logger.getLogger(DbCon.class.getName());
	public ProdottoDao(Connection con) {
		this.con = con;
	}
	
	public List<Prodotto> getAllProdotto() {
	    List<Prodotto> prodotti = new ArrayList<Prodotto>();
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	        String query = "SELECT * FROM prodotto";
	        pst = this.con.prepareStatement(query);
	        rs = pst.executeQuery();

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
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pst != null) {
	                pst.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return prodotti;
	}

	
	public Prodotto getProdottoByCodice(int codice) {
	    Prodotto prodotto = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	        String query = "SELECT * FROM prodotto WHERE codice = ?";
	        pst = this.con.prepareStatement(query);
	        pst.setInt(1, codice);
	        rs = pst.executeQuery();

	        if (rs.next()) {
	            prodotto = new Prodotto();
	            prodotto.setCodice(rs.getInt("codice"));
	            prodotto.setNome(rs.getString("nome"));
	            prodotto.setPrezzo(rs.getFloat("prezzo"));
	            prodotto.setMarca(rs.getString("marca"));
	            prodotto.setDescrizione(rs.getString("descrizione"));
	            prodotto.setDataUscita(rs.getDate("data_usc"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pst != null) {
	                pst.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return prodotto;
	}

	
	public List<Prodotto> getProdottoByPrezzo(int min, int max) {
	    List<Prodotto> prodotti = new ArrayList<Prodotto>();
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	        String query = "SELECT * FROM prodotto WHERE prezzo >= ? AND prezzo <= ?";
	        pst = this.con.prepareStatement(query);
	        pst.setInt(1, min);
	        pst.setInt(2, max);
	        rs = pst.executeQuery();

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
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pst != null) {
	                pst.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return prodotti;
	}

	
	public void insertProdotto(float prezzo, String nome, String marca, String descrizione, String data_usc) {
	    PreparedStatement statement = null;

	    try {
	        String query = "INSERT INTO prodotto (prezzo, nome, marca, descrizione, data_usc) VALUES (?, ?, ?, ?, ?)";

	        statement = this.con.prepareStatement(query);
	        statement.setFloat(1, prezzo);
	        statement.setString(2, nome);
	        statement.setString(3, marca);
	        statement.setString(4, descrizione);
	        statement.setString(5, data_usc);

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

	
	public void updateProdotto(int codice, float prezzo, String nome, String marca, String descrizione, String data_usc) {
	    PreparedStatement statement = null;

	    try {
	        String query = "UPDATE prodotto SET prezzo = ?, nome = ?, marca = ?, descrizione = ?, data_usc = ? WHERE codice = ?";
	        statement = this.con.prepareStatement(query);
	        statement.setFloat(1, prezzo);
	        statement.setString(2, nome);
	        statement.setString(3, marca);
	        statement.setString(4, descrizione);
	        statement.setString(5, data_usc);
	        statement.setInt(6, codice);
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

		
	public boolean deleteProdotto(String codice) {
	    PreparedStatement statement = null;

	    try {
	        String query = "DELETE FROM prodotto WHERE codice = ?";
	        statement = this.con.prepareStatement(query);
	        statement.setString(1, codice);

	        int i = statement.executeUpdate();
	        return i > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	        return false;
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

		
	public Prodotto getUltimoProdotto() {
	    Prodotto prodotto = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        String query = "SELECT * FROM prodotto WHERE codice = (SELECT MAX(codice) FROM prodotto)";
	        statement = this.con.prepareStatement(query);
	        resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            int codice = resultSet.getInt("codice");
	            float prezzo = resultSet.getFloat("prezzo");
	            String nome = resultSet.getString("nome");
	            String marca = resultSet.getString("marca");
	            String descrizione = resultSet.getString("descrizione");
	            Date data_usc = resultSet.getDate("data_usc");

	            prodotto = new Prodotto(codice, prezzo, nome, marca, descrizione, data_usc);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            logger.info(e.getMessage());
	        }
	    }

	    return prodotto;
	}

		
	public boolean controllaEsistenza(String codice) {
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        String query = "SELECT * FROM prodotto WHERE codice = ?";
	        statement = this.con.prepareStatement(query);
	        statement.setString(1, codice);

	        resultSet = statement.executeQuery();
	        boolean exists = resultSet.next();

	        return exists;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        logger.info(e.getMessage());
	        return false;
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
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