package cn.gamechanger.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;
import cn.gamechanger.bean.Carrello;
import cn.gamechanger.connection.DbCon;

public class CarrelloDaoTest {

	@Test
	public void aggiungiProdottoAlCarrelloTest() throws Exception{
		Connection con = DbCon.getConnection();
		CarrelloDao dao = new CarrelloDao(con);
		dao.aggiungiProdottoAlCarrello("user1", 1, 1);
	    List<Carrello> carrello = dao.getCarrelloByUsername("user1"); 
	    
	    boolean prodottoTrovato = false;
	    for (Carrello car : carrello) {
	        if (car.getIdProdotto() == 1) {
	            prodottoTrovato = true;
	            break;
	        }
	    }
	    assertTrue(prodottoTrovato);
	}
	
	@Test
	public void getCarrelloByUsernameTest() throws Exception{
		Connection con = DbCon.getConnection();
		CarrelloDao dao = new CarrelloDao(con);
		dao.aggiungiProdottoAlCarrello("user2", 1, 1);
		
		List<Carrello> carrelloList = dao.getCarrelloByUsername("user2");
	    assertEquals("user2", carrelloList.get(0).getUsername());
	}
	
	@Test
	public void cambiaQuantitaProdottoTest() throws Exception{
		Connection con = DbCon.getConnection();
		CarrelloDao dao = new CarrelloDao(con);
		dao.aggiungiProdottoAlCarrello("user3", 1, 1);
		dao.cambiaQuantitaProdotto("user3", 1, 2);
		
		List<Carrello> carrelloList = dao.getCarrelloByUsername("user3");
	    assertEquals(2, carrelloList.get(0).getQuantitàProdotto());
	}
	
	@Test
	public void rimuoviProdottoDalCarrelloTest() throws Exception{
		Connection con = DbCon.getConnection();
		CarrelloDao dao = new CarrelloDao(con);
		dao.aggiungiProdottoAlCarrello("user4", 1, 1);
		dao.aggiungiProdottoAlCarrello("user4", 2, 1);
		dao.rimuoviProdottoDalCarrello("user4", 1);
		List<Carrello> carrello = dao.getCarrelloByUsername("user4"); 
		
		boolean prodottoNonTrovato = true;
	    for (Carrello car : carrello) {
	        if (car.getIdProdotto() == 1) {
	            prodottoNonTrovato = false;
	            break;
	        }
	    }
	    assertTrue(prodottoNonTrovato);
	}
	
	@Test
	public void cancellaCarrelloTest() throws Exception{
		Connection con = DbCon.getConnection();
		CarrelloDao dao = new CarrelloDao(con);
		dao.aggiungiProdottoAlCarrello("user5", 1, 1);
		dao.cancellaCarrello("user5");
		
		List<Carrello> carrelloList = dao.getCarrelloByUsername("user5");
		boolean carrelloCancellato = false;
		if (carrelloList.isEmpty()) {
			carrelloCancellato = true;
		}
		
		assertTrue(carrelloCancellato);
	}

}
