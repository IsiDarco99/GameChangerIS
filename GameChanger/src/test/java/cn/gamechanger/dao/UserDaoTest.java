package cn.gamechanger.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import cn.gamechanger.bean.User;
import cn.gamechanger.connection.DbCon;

public class UserDaoTest {

	@Test
	public void registerUserTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testUserRegistra");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		boolean userRegistrato = dao.registerUser(user);
		
		assertTrue(userRegistrato);
	}
	
	@Test
	public void userLoginTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testUserLogin");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);
		User loginUser = dao.userLogin("testUserLogin", "passwordTest123");
		
		boolean userTrovato = false;
		if (loginUser.getUsername().equalsIgnoreCase("testuserlogin")) {
			userTrovato = true;
		}
		
		assertTrue(userTrovato);
	}
	
	@Test
	public void getUserProfileTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testUserGetProfile");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);
		User getUser = dao.getUserProfile("testUserGetProfile");
		
		boolean userTrovato = false;
		if (getUser.getUsername().equalsIgnoreCase("testUserGetProfile")) {
			userTrovato = true;
		}
		
		assertTrue(userTrovato);
	}
	
	@Test
	public void updateUserTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testUserUpdate");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);
		
		user.setIndirizzo("Indirizzo Updated");
		user.setCitta("Citta Updated");
		user.setStato("Stato Updated");
		user.setCod_postale(99999);
		
		dao.updateUser(user);
		
		boolean userUpdate = false;
		User loginUser = dao.userLogin("testUserUpdate", "passwordTest123");
		if (loginUser.getIndirizzo().equalsIgnoreCase("Indirizzo Updated")) {
			userUpdate = true;
		}
		
		assertTrue(userUpdate);
	}
	
	@Test
	public void updateUserPaypalTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testUserUpdatePaypal");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);
		
		user.setEmailPaypal("EmailPaypalUpdated");
		
		dao.updateUserPayPal(user);
		
		boolean userUpdate = false;
		User loginUser = dao.userLogin("testUserUpdatePaypal", "passwordTest123");
		if (loginUser.getEmailPaypal().equalsIgnoreCase("EmailPaypalUpdated")) {
			userUpdate = true;
		}
		
		assertTrue(userUpdate);
	}
	
	@Test
	public void updateUsernameTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testUsernameUpdate");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);
		
		dao.updateUsername("testUsernameUpdate", "nuovoUsername");
		
		boolean userUpdate = false;
		User loginUser = dao.userLogin("nuovoUsername", "passwordTest123");
		if (loginUser != null) {
			userUpdate = true;
		}
		
		assertTrue(userUpdate);
	}
	
	@Test
	public void checkUsernameTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testCheckUsername");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);
		
		boolean userFound = false;
		if (dao.checkUsername("testCheckUsername")) {
			userFound = true;
		}
		
		assertFalse(userFound);
	}
	
	@Test
	public void updatePasswordTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testUpdatePassword");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);		
		dao.updatePassword("testUpdatePassword", "nuovaPassword");
		
		boolean userUpdate = false;
		User loginUser = dao.userLogin("testUpdatePassword", "nuovaPassword");
		if (loginUser != null) {
			userUpdate = true;
		}
		
		assertTrue(userUpdate);
	}
	
	@Test
	public void updateImmagineTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testUpdateImmagine");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);		
		dao.updateImmagine("testUpdateImmagine", "2");
		
		boolean userUpdate = false;
		User loginUser = dao.userLogin("testUpdateImmagine", "passwordTest123");
		if ((String.valueOf(loginUser.getImmagine()).equalsIgnoreCase("2"))) {
			userUpdate = true;
		}
		
		assertTrue(userUpdate);
	}
	
	@Test
	public void updateEmailTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testUpdateEmail");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);		
		dao.updateEmail("testUpdateEmail", "test.user@nuovamail.com");
		
		boolean userUpdate = false;
		User loginUser = dao.userLogin("testUpdateEmail", "passwordTest123");
		if (loginUser.getEmailPers().equals("test.user@nuovamail.com")) {
			userUpdate = true;
		}
		
		assertTrue(userUpdate);
	}
	
	@Test
	public void updatePaypalTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testUpdatePaypal");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);		
		dao.updatePaypal("testUpdatePaypal", "paypal.user@nuovamail.com");
		
		boolean userUpdate = false;
		User loginUser = dao.userLogin("testUpdatePaypal", "passwordTest123");
		if (loginUser.getEmailPaypal().equals("paypal.user@nuovamail.com")) {
			userUpdate = true;
		}
		
		assertTrue(userUpdate);
	}
	
	@Test
	public void updateDataNascitaTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testUpdateDataNascita");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);		
		dao.updateDataNascita("testUpdateDataNascita", "2020-01-01");
		
		boolean userUpdate = false;
		User loginUser = dao.userLogin("testUpdateDataNascita", "passwordTest123");
		if (loginUser.getDataNascita().equals("2020-01-01")) {
			userUpdate = true;
		}
		
		assertTrue(userUpdate);
	}
	
	@Test
	public void updateNomeTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testUpdateNome");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);		
		dao.updateNome("testUpdateNome", "NomeProva");
		
		boolean userUpdate = false;
		User loginUser = dao.userLogin("testUpdateNome", "passwordTest123");
		if (loginUser.getNome().equals("NomeProva")) {
			userUpdate = true;
		}
		
		assertTrue(userUpdate);
	}
	
	@Test
	public void updateCognomeTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testUpdateCognome");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);
		dao.updateCognome("testUpdateCognome", "CognomeProva");
		
		boolean userUpdate = false;
		User loginUser = dao.userLogin("testUpdateCognome", "passwordTest123");
		if (loginUser.getCognome().equals("CognomeProva")) {
			userUpdate = true;
		}
		
		assertTrue(userUpdate);
	}
	
	@Test
	public void updateNumeroTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testUpdateNumero");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);
		dao.updateNumero("testUpdateNumero", "1111111111");
		
		boolean userUpdate = false;
		User loginUser = dao.userLogin("testUpdateNumero", "passwordTest123");
		if ((String.valueOf(loginUser.getNumTel()).equalsIgnoreCase("1111111111"))) {
			userUpdate = true;
		}
		
		assertTrue(userUpdate);
	}
	
	@Test
	public void updateIndirizzoTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testUpdateIndirizzo");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);
		dao.updateIndirizzo("testUpdateIndirizzo", "IndirizzoProva", "StatoProva", "CittaProva", 11111);
		
		boolean userUpdate = false;
		User loginUser = dao.userLogin("testUpdateIndirizzo", "passwordTest123");
		if (loginUser.getIndirizzo().equals("IndirizzoProva")) {
			userUpdate = true;
		}
		
		assertTrue(userUpdate);
	}
	
	@Test
	public void updateCodiceFiscaleTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testUpdateCodFisc");
		user.setEmailPers("test.user@example.com");
		user.setEmailPaypal("paypal.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);
		dao.updateCodiceFiscale("testUpdateCodFisc", "PROVAC90E15H501X");
		
		boolean userUpdate = false;
		User loginUser = dao.userLogin("testUpdateCodFisc", "passwordTest123");
		if (loginUser.getCodFiscale().equals("PROVAC90E15H501X")) {
			userUpdate = true;
		}
		
		assertTrue(userUpdate);
	}
	
	@Test
	public void getCheckoutUserTest() throws Exception {
		Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
		
		User user = new User();
		user.setUsername("testCheckoutUser");
		user.setEmailPers("test.user@example.com");
		user.setEmailPaypal("paypal.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		
		dao.registerUser(user);
		dao.getCheckoutUser("testCheckoutUser");
		
		boolean userTrovato = false;
		User loginUser = dao.userLogin("testCheckoutUser", "passwordTest123");
		if (loginUser != null) {
			userTrovato = true;
		}
		
		assertTrue(userTrovato);
	}

}
