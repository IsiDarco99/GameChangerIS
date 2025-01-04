package cn.gamechanger.dao;

import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.gamechanger.bean.User;
import cn.gamechanger.connection.DbCon;

public class UserDao {
	private Connection con;
	private static final Logger logger = Logger.getLogger(DbCon.class.getName());
	
	public UserDao(Connection con) {
		this.con = con;
	}
	
	 public User userLogin(String username, String password) {
	        User user = null;

	        try {
	            String query = "select * from utente where username=? and password=?";

	            try (PreparedStatement pst = this.con.prepareStatement(query)) {
	                pst.setString(1, username);
	                pst.setString(2, password);

	                try (ResultSet rs = pst.executeQuery()) {
	                    if (rs.next()) {
	                        user = new User();
	                        user.setUsername(rs.getString("username"));
	                        user.setEmailPers(rs.getString("email_pers"));
	                        user.setEmailPaypal(rs.getString("email_paypal"));
	                        user.setNumTel(rs.getInt(4));
	                        user.setIndirizzo(rs.getString("indirizzo"));
	                        user.setStato(rs.getString("stato"));
	                        user.setCitta(rs.getString("citta"));
	                        user.setCod_postale(rs.getInt(8));
	                        user.setPassword(rs.getString("password"));
	                        user.setNome(rs.getString("nome"));
	                        user.setCognome(rs.getString("cognome"));
	                        user.setDataNascita(rs.getString("data_nascita"));
	                        user.setCodFiscale(rs.getString("codfiscale"));
	                        user.setImmagine(rs.getInt(14));
	                    }
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            logger.info(e.getMessage());
	        }

	        return user;
	    }
	
	 public boolean registerUser(User user) {
		    try {
		        String query = "INSERT INTO utente (username, email_pers, password, nome, cognome, data_nascita) VALUES (?, ?, ?, ?, ?, ?)";

		        try (PreparedStatement pst = this.con.prepareStatement(query)) {
		            pst.setString(1, user.getUsername());
		            pst.setString(2, user.getEmailPers());
		            pst.setString(3, user.getPassword());
		            pst.setString(4, user.getNome());
		            pst.setString(5, user.getCognome());
		            pst.setString(6, user.getDataNascita());

		            int rowsAffected = pst.executeUpdate();

		            return rowsAffected > 0;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		        return false;
		    }
		}

	
	 public User getUserProfile(String username) {
		    User user = null;
		    String query = "select * from utente where username=?";

		    try (PreparedStatement pst = this.con.prepareStatement(query)) {
		        pst.setString(1, username);
		        try (ResultSet rs = pst.executeQuery()) {
		            if (rs.next()) {
		                user = new User();
		                user.setUsername(rs.getString("username"));
		                user.setEmailPers(rs.getString("email_pers"));
		                user.setEmailPaypal(rs.getString("email_paypal"));
		                user.setNumTel(rs.getInt(4));
		                user.setIndirizzo(rs.getString("indirizzo"));
		                user.setStato(rs.getString("stato"));
		                user.setCitta(rs.getString("citta"));
		                user.setCod_postale(rs.getInt(8));
		                user.setPassword(rs.getString("password"));
		                user.setNome(rs.getString("nome"));
		                user.setCognome(rs.getString("cognome"));
		                user.setDataNascita(rs.getString("data_nascita"));
		                user.setCodFiscale(rs.getString("codfiscale"));
		                user.setImmagine(rs.getInt(14));
		            }
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }

		    return user;
		}

	 public void updateUser(User user) {
		    String query = "UPDATE utente SET indirizzo = ?, citta = ?, stato = ?, cod_postale = ? WHERE username = ?";

		    try (PreparedStatement pst = this.con.prepareStatement(query)) {
		        pst.setString(1, user.getIndirizzo());
		        pst.setString(2, user.getCitta());
		        pst.setString(3, user.getStato());
		        pst.setInt(4, user.getCod_postale());
		        pst.setString(5, user.getUsername());

		        pst.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}

	
	 public void updateUserPayPal(User user) {
		    String query = "UPDATE utente SET email_paypal = ? WHERE username = ?";

		    try (PreparedStatement pst = this.con.prepareStatement(query)) {
		        pst.setString(1, user.getEmailPaypal());
		        pst.setString(2, user.getUsername());

		        pst.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}

	
	 public void updateUsername(String vecchioUsername, String nuovoUsername) {
		    String query = "UPDATE utente SET username = ? WHERE username = ?";

		    try (PreparedStatement pst = this.con.prepareStatement(query)) {
		        pst.setString(1, nuovoUsername);
		        pst.setString(2, vecchioUsername);

		        pst.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}

	
	 public boolean checkUsername(String nuovoUsername) {
		    String checkQuery = "SELECT COUNT(*) FROM utente WHERE username = ?";
		    try (PreparedStatement checkStatement = this.con.prepareStatement(checkQuery)) {
		        checkStatement.setString(1, nuovoUsername);
		        try (ResultSet resultSet = checkStatement.executeQuery()) {
		            if (resultSet.next()) {
		                int count = resultSet.getInt(1);
		                return count == 0;
		            }
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		    return true;
		}

	
	 public void updatePassword(String username, String nuovaPassword) {
		    String query = "UPDATE utente SET password = ? WHERE username = ?";

		    try (PreparedStatement pst = this.con.prepareStatement(query)) {
		        pst.setString(1, nuovaPassword);
		        pst.setString(2, username);

		        pst.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}

	
	 public void updateImmagine(String username, String nuovaImmagine) {
		    String query = "UPDATE utente SET immagine = ? WHERE username = ?";

		    try (PreparedStatement pst = this.con.prepareStatement(query)) {
		        pst.setString(1, nuovaImmagine);
		        pst.setString(2, username);

		        pst.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}

	
	 public void updateEmail(String username, String nuovaEmail) {
		    String query = "UPDATE utente SET email_pers = ? WHERE username = ?";

		    try (PreparedStatement pst = this.con.prepareStatement(query)) {
		        pst.setString(1, nuovaEmail);
		        pst.setString(2, username);

		        pst.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}

	
	 public void updatePaypal(String username, String nuovaPaypal) {
		    String query = "UPDATE utente SET email_paypal = ? WHERE username = ?";

		    try (PreparedStatement pst = this.con.prepareStatement(query)) {
		        pst.setString(1, nuovaPaypal);
		        pst.setString(2, username);

		        pst.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}

	
	 public void updateDataNascita(String username, String nuovaDataNascita) {
		    String query = "UPDATE utente SET data_nascita = ? WHERE username = ?";

		    try (PreparedStatement pst = this.con.prepareStatement(query)) {
		        pst.setString(1, nuovaDataNascita);
		        pst.setString(2, username);

		        pst.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}

	
	 public void updateNome(String username, String nuovoNome) {
		    String query = "UPDATE utente SET nome = ? WHERE username = ?";

		    try (PreparedStatement pst = this.con.prepareStatement(query)) {
		        pst.setString(1, nuovoNome);
		        pst.setString(2, username);

		        pst.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}


	 public void updateCognome(String username, String nuovoCognome) {
		    String query = "UPDATE utente SET cognome = ? WHERE username = ?";

		    try (PreparedStatement pst = this.con.prepareStatement(query)) {
		        pst.setString(1, nuovoCognome);
		        pst.setString(2, username);

		        pst.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}
	 
	 public void updateNumero(String username, String nuovoNumero) {
		    String query = "UPDATE utente SET num_tel = ? WHERE username = ?";

		    try (PreparedStatement pst = this.con.prepareStatement(query)) {
		        pst.setString(1, nuovoNumero);
		        pst.setString(2, username);

		        pst.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}

	
	 public void updateIndirizzo(String username, String indirizzo, String stato, String citta, int codPostale) {
		    String query = "UPDATE utente SET indirizzo = ?, citta = ?, stato = ?, cod_postale = ? WHERE username = ?";

		    try (PreparedStatement pst = this.con.prepareStatement(query)) {
		        pst.setString(1, indirizzo);
		        pst.setString(2, stato);
		        pst.setString(3, citta);
		        pst.setInt(4, codPostale);
		        pst.setString(5, username);

		        pst.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}

	
	 public void updateCodiceFiscale(String username, String nuovoCodiceFiscale) {
		    String query = "UPDATE utente SET codfiscale = ? WHERE username = ?";

		    try (PreparedStatement pst = this.con.prepareStatement(query)) {
		        pst.setString(1, nuovoCodiceFiscale);
		        pst.setString(2, username);

		        pst.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		}



	 public User getCheckoutUser(String username) {
		    User user = null;

		    try {
		        String query = "SELECT * FROM utente WHERE username=?";
		        try (PreparedStatement pst = this.con.prepareStatement(query)) {
		            pst.setString(1, username);
		            try (ResultSet rs = pst.executeQuery()) {
		                if (rs.next()) {
		                    user = new User();
		                    user.setNome(rs.getString("nome"));
		                    user.setCognome(rs.getString("cognome"));
		                    user.setIndirizzo(rs.getString("indirizzo"));
		                    user.setStato(rs.getString("stato"));
		                    user.setCitta(rs.getString("citta"));
		                    user.setCod_postale(rs.getInt(8));
		                    user.setNumTel(rs.getInt(4));
		                    user.setEmailPaypal(rs.getString("email_paypal"));
		                }
		            }
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        logger.info(e.getMessage());
		    }
		    return user;
		}

}
    