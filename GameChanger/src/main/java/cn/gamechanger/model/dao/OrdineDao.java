package cn.gamechanger.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Carrello;
import cn.gamechanger.model.Ordine;


public class OrdineDao {
	
	private Connection con;
	private static final Logger logger = Logger.getLogger(DbCon.class.getName());
	public OrdineDao(Connection con) {
		this.con = con;
		
	}
	public void aggiungiOrdine(Ordine ordine, List<Carrello> prodottiOrdine) throws SQLException {
        String queryOrdine = "INSERT INTO ordine (username, stato_ord, data_ord) VALUES (?, ?, ?)";
        String queryProdottoOrdine = "INSERT INTO prodotto_ordine (id_ordine, codice, quant_prod, prezzo) VALUES (?, ?, ?, ?)";

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
                stmtProdottoOrdine.setInt(3, prodottoOrdine.getQuantitàProdotto());
                stmtProdottoOrdine.setFloat(4, prodottoOrdine.getPrezzo());

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
}