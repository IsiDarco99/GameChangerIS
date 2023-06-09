package cn.gamechanger.model.dao;

import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.User;

public class CarrelloDao {
    private Connection con;
    private static final Logger logger = Logger.getLogger(DbCon.class.getName());

    public CarrelloDao(Connection con) {
        this.con = con;
    }

    public void stampaProdottiCarrello(String username) {
        try {
            String query = "SELECT * FROM carrello WHERE username = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                // Qui puoi effettuare l'operazione desiderata con il prodotto, ad esempio stamparlo nella console
                System.out.println("Prodotto nel carrello: " + productId);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
        	e.printStackTrace();
	        logger.info(e.getMessage());
        }
    }
}
