package cn.gamechanger.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Carrello;
import cn.gamechanger.model.Ordine;
import cn.gamechanger.model.ProdottoOrdine;


public class OrdineDao {
	
	private Connection con;
	private static final Logger logger = Logger.getLogger(DbCon.class.getName());
	public OrdineDao(Connection con) {
		this.con = con;
		
	}
	public void aggiungiOrdine(Ordine ordine, List<Carrello> prodottiOrdine) throws SQLException {
        String queryOrdine = "INSERT INTO ordine (username, stato_ord, data_ord) VALUES (?, ?, ?)";
        String queryProdottoOrdine = "INSERT INTO prodotto_ordine (id_ordine, codice, nome, quant_prod, prezzo) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmtOrdine = con.prepareStatement(queryOrdine, PreparedStatement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtProdottoOrdine = con.prepareStatement(queryProdottoOrdine)) {

        	con.setAutoCommit(false);

            stmtOrdine.setString(1, ordine.getUsername());
            stmtOrdine.setString(2, ordine.getStato_ord());
            stmtOrdine.setString(3, ordine.getDataOrd());

            stmtOrdine.executeUpdate();

            int idOrdine;
            try (ResultSet generatedKeys = stmtOrdine.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idOrdine = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Failed to retrieve auto-generated key for order insertion.");
                }
            }

            for (Carrello prodottoOrdine : prodottiOrdine) {
                stmtProdottoOrdine.setInt(1, idOrdine);
                stmtProdottoOrdine.setInt(2, prodottoOrdine.getIdProdotto());
                stmtProdottoOrdine.setString(3, prodottoOrdine.getNomeProdotto());
                stmtProdottoOrdine.setInt(4, prodottoOrdine.getQuantitàProdotto());
                stmtProdottoOrdine.setFloat(5, prodottoOrdine.getPrezzo());

                stmtProdottoOrdine.addBatch();
            }

            stmtProdottoOrdine.executeBatch();
            con.commit();
        } catch (SQLException e) {
        	con.rollback();
            throw e;
        } finally {
        	con.setAutoCommit(true);
        }
    }
	
	public Map<Ordine, List<ProdottoOrdine>> getOrdiniUtente(String username) throws SQLException {
	    Map<Ordine, List<ProdottoOrdine>> ordiniEProdotti = new LinkedHashMap<>();

	    String query = "SELECT * FROM ordine o " +
	                   "JOIN prodotto_ordine po ON o.id_ordine = po.id_ordine " +
	                   "WHERE o.username = ? " +
	                   "ORDER BY o.id_ordine";

	    try (PreparedStatement stmt = con.prepareStatement(query)) {
	        stmt.setString(1, username);

	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                int idOrdine = rs.getInt("id_ordine");
	                String statoOrd = rs.getString("stato_ord");
	                String dataOrd = rs.getString("data_ord");

	                int codiceProdotto = rs.getInt("codice");
	                int quantitaProdotto = rs.getInt("quant_prod");
	                float prezzoProdotto = rs.getFloat("prezzo");
	                String nomeProdotto = rs.getString("nome");

	                Ordine ordine = new Ordine(idOrdine, username, statoOrd, dataOrd);
	                ProdottoOrdine prodottoOrdine = new ProdottoOrdine(idOrdine, codiceProdotto, nomeProdotto, prezzoProdotto, quantitaProdotto);

	                // Aggiungi il prodotto all'ordine corrispondente nella mappa
	                List<ProdottoOrdine> prodottiOrdine = ordiniEProdotti.get(ordine);
	                if (prodottiOrdine == null) {
	                    prodottiOrdine = new ArrayList<>();
	                    ordiniEProdotti.put(ordine, prodottiOrdine);
	                }
	                prodottiOrdine.add(prodottoOrdine);
	            }
	        }
	    }
	    return ordiniEProdotti;
	}

}