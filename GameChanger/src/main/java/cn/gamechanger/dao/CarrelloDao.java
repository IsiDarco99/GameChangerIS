package cn.gamechanger.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.gamechanger.bean.*;
import cn.gamechanger.connection.DbCon;

public class CarrelloDao {
    private Connection con;
    private static final Logger logger = Logger.getLogger(DbCon.class.getName());

    public CarrelloDao(Connection con) {
        this.con = con;
    }
    
    public List<Carrello> getCarrelloByUsername(String username) {
        List<Carrello> carrelloList = new ArrayList<Carrello>();

        try {
        	String query = "SELECT * FROM carrello AS c JOIN prodotto AS p ON c.codice = p.codice WHERE username = ?";
			PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
            rs = pst.executeQuery();

            while (rs.next()) {
            	int id_carrello = rs.getInt("id_carrello");
                int idProdotto = rs.getInt("codice");
                int quantitàProdotto = rs.getInt("quant_prod");
                String nomeProdotto = rs.getString("nome");
                float prezzo = rs.getFloat("prezzo");
                Carrello carrello = new Carrello(id_carrello, username, idProdotto, quantitàProdotto, nomeProdotto, prezzo);
                carrelloList.add(carrello);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carrelloList;
    }
    
    public void aggiungiProdottoAlCarrello(String username, int codiceProdotto, int quantita) {
        boolean exist = false;
        PreparedStatement pst = null;

        try {
            String query = "SELECT * FROM carrello AS c WHERE username = ? AND codice = ?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, username);
            pst.setInt(2, codiceProdotto);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                exist = true;
            }

            if (!exist) {
                query = "INSERT INTO carrello (username, codice, quant_prod) VALUES (?, ?, ?)";
                PreparedStatement statement = this.con.prepareStatement(query);
                statement.setString(1, username);
                statement.setInt(2, codiceProdotto);
                statement.setInt(3, quantita);
                statement.executeUpdate();
                statement.close();
            } else {
                query = "UPDATE carrello SET quant_prod = quant_prod + ? WHERE codice = ? AND username = ?";
                PreparedStatement statement = this.con.prepareStatement(query);
                statement.setInt(1, quantita);
                statement.setInt(2, codiceProdotto);
                statement.setString(3, username);
                statement.executeUpdate();
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                logger.info(e.getMessage());
            }
        }
    }

    
    public void cambiaQuantitaProdotto(String username, int codiceProdotto, int nuovaQuantita) {
        PreparedStatement statement = null;

        try {
            String query = "UPDATE carrello SET quant_prod = ? WHERE codice = ? AND username = ?";
            statement = this.con.prepareStatement(query);
            statement.setInt(1, nuovaQuantita);
            statement.setInt(2, codiceProdotto);
            statement.setString(3, username);
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

    
    public void rimuoviProdottoDalCarrello(String username, int codiceProdotto) {
        PreparedStatement statement = null;

        try {
            String query = "DELETE FROM carrello WHERE username = ? AND codice = ?";
            statement = this.con.prepareStatement(query);
            statement.setString(1, username);
            statement.setInt(2, codiceProdotto);
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

    
    public void cancellaCarrello(String username) {
        PreparedStatement statement = null;

        try {
            String query = "DELETE FROM carrello WHERE username = ?";
            statement = this.con.prepareStatement(query);
            statement.setString(1, username);
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
