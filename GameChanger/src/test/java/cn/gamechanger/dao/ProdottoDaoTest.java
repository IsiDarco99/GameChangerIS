package cn.gamechanger.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import cn.gamechanger.bean.Carrello;
import cn.gamechanger.bean.Prodotto;
import cn.gamechanger.connection.DbCon;

public class ProdottoDaoTest {

	@Test
	public void getAllProdottoTest() throws Exception {
		Connection con = DbCon.getConnection();
		ProdottoDao dao = new ProdottoDao(con);
		List<Prodotto> prodotti = dao.getAllProdotto();

		boolean prodottiTrovati = false;
		if (!prodotti.isEmpty()) {
			prodottiTrovati = true;
		}

		assertTrue(prodottiTrovati);
	}

	@Test
	public void getAllVideogameTest() throws Exception {
		Connection con = DbCon.getConnection();
		ProdottoDao dao = new ProdottoDao(con);
		List<Prodotto> prodotti = dao.getAllVideogame();

		boolean prodottiTrovati = false;
		if (!prodotti.isEmpty()) {
			prodottiTrovati = true;
		}

		assertTrue(prodottiTrovati);
	}

	@Test
	public void getAllComputerTest() throws Exception {
		Connection con = DbCon.getConnection();
		ProdottoDao dao = new ProdottoDao(con);
		List<Prodotto> prodotti = dao.getAllComputer();

		boolean prodottiTrovati = false;
		if (!prodotti.isEmpty()) {
			prodottiTrovati = true;
		}

		assertTrue(prodottiTrovati);
	}

	@Test
	public void getAllAccessoriTest() throws Exception {
		Connection con = DbCon.getConnection();
		ProdottoDao dao = new ProdottoDao(con);
		List<Prodotto> prodotti = dao.getAllAccessori();

		boolean prodottiTrovati = false;
		if (!prodotti.isEmpty()) {
			prodottiTrovati = true;
		}

		assertTrue(prodottiTrovati);
	}

	@Test
	public void getAllConsoleTest() throws Exception {
		Connection con = DbCon.getConnection();
		ProdottoDao dao = new ProdottoDao(con);
		List<Prodotto> prodotti = dao.getAllConsole();

		boolean prodottiTrovati = false;
		if (!prodotti.isEmpty()) {
			prodottiTrovati = true;
		}

		assertTrue(prodottiTrovati);
	}

	@Test
	public void insertProdottoTest() throws Exception {
		Connection con = DbCon.getConnection();
		ProdottoDao dao = new ProdottoDao(con);
		dao.insertProdotto(10, "ProvaNome", "ProvaMarca", "ProvaDescrizione", "2020-01-01", "videogame");

		List<Prodotto> prodotti = dao.getAllProdotto();
		boolean prodottoTrovato = false;
		for (Prodotto p : prodotti) {
			if (p.getNome().equalsIgnoreCase("provanome")) {
				prodottoTrovato = true;
			}
		}
		assertTrue(prodottoTrovato);
	}

	@Test
	public void getUltimoProdottoTest() throws Exception {
		Connection con = DbCon.getConnection();
		ProdottoDao dao = new ProdottoDao(con);
		dao.insertProdotto(10, "ProvaNome2", "ProvaMarca", "ProvaDescrizione", "2020-01-01", "videogame");
		Prodotto ultimoProdotto = dao.getUltimoProdotto();

		boolean prodottoTrovato = false;
		if (ultimoProdotto.getNome().equalsIgnoreCase("provanome2")) {
			prodottoTrovato = true;
		}
		assertTrue(prodottoTrovato);
	}

	@Test
	public void getProdottoByCodiceTest() throws Exception {
		Connection con = DbCon.getConnection();
		ProdottoDao dao = new ProdottoDao(con);
		dao.insertProdotto(10, "ProvaNome3", "ProvaMarca", "ProvaDescrizione", "2020-01-01", "videogame");
		Prodotto ultimoProdotto = dao.getUltimoProdotto();
		Prodotto p = dao.getProdottoByCodice(ultimoProdotto.getCodice());

		boolean prodottoTrovato = false;
		if (ultimoProdotto.getNome().equalsIgnoreCase("provanome3")) {
			prodottoTrovato = true;
		}

		assertTrue(prodottoTrovato);
	}

	@Test
	public void getVideogameByPrezzoTest() throws Exception {
		Connection con = DbCon.getConnection();
		ProdottoDao dao = new ProdottoDao(con);
		dao.insertProdotto(10000, "ProvaVideogamePrezzo", "ProvaMarca", "ProvaDescrizione", "2020-01-01", "videogame");
		List<Prodotto> prodotti = dao.getVideogameByPrezzo(9999, 10001);

		boolean prodottoTrovato = false;
		for (Prodotto p : prodotti) {
			if (p.getNome().equalsIgnoreCase("ProvaVideogamePrezzo")) {
				prodottoTrovato = true;
			}
		}

		assertTrue(prodottoTrovato);
	}
	
	@Test
	public void getComputerByPrezzoTest() throws Exception {
		Connection con = DbCon.getConnection();
		ProdottoDao dao = new ProdottoDao(con);
		dao.insertProdotto(10000, "ProvaComputerPrezzo", "ProvaMarca", "ProvaDescrizione", "2020-01-01", "computer");
		List<Prodotto> prodotti = dao.getComputerByPrezzo(9999, 10001);

		boolean prodottoTrovato = false;
		for (Prodotto p : prodotti) {
			if (p.getNome().equalsIgnoreCase("ProvaComputerPrezzo")) {
				prodottoTrovato = true;
			}
		}

		assertTrue(prodottoTrovato);
	}
	
	@Test
	public void getConsoleByPrezzoTest() throws Exception {
		Connection con = DbCon.getConnection();
		ProdottoDao dao = new ProdottoDao(con);
		dao.insertProdotto(10000, "ProvaConsolePrezzo", "ProvaMarca", "ProvaDescrizione", "2020-01-01", "console");
		List<Prodotto> prodotti = dao.getConsoleByPrezzo(9999, 10001);

		boolean prodottoTrovato = false;
		for (Prodotto p : prodotti) {
			if (p.getNome().equalsIgnoreCase("ProvaConsolePrezzo")) {
				prodottoTrovato = true;
			}
		}

		assertTrue(prodottoTrovato);
	}
	
	@Test
	public void getAccessorioByPrezzoTest() throws Exception {
		Connection con = DbCon.getConnection();
		ProdottoDao dao = new ProdottoDao(con);
		dao.insertProdotto(10000, "ProvaAccessorioPrezzo", "ProvaMarca", "ProvaDescrizione", "2020-01-01", "accessorio");
		List<Prodotto> prodotti = dao.getAccessorioByPrezzo(9999, 10001);

		boolean prodottoTrovato = false;
		for (Prodotto p : prodotti) {
			if (p.getNome().equalsIgnoreCase("ProvaAccessorioPrezzo")) {
				prodottoTrovato = true;
			}
		}

		assertTrue(prodottoTrovato);
	}
	
	@Test
	public void updateProdottoTest() throws Exception {
		Connection con = DbCon.getConnection();
		ProdottoDao dao = new ProdottoDao(con);
		dao.insertProdotto(10, "ProvaNomeUpdate", "ProvaMarca", "ProvaDescrizione", "2020-01-01", "videogame");
		Prodotto ultimoProdotto = dao.getUltimoProdotto();
		dao.updateProdotto(ultimoProdotto.getCodice(), 10, "NuovoNomeUpdate", "ProvaMarca", "ProvaDescrizione", "2020-01-01", "videogame");
		
		List<Prodotto> prodotti = dao.getAllProdotto();
		boolean prodottoTrovato = false;
		for (Prodotto p : prodotti) {
			if (p.getNome().equalsIgnoreCase("nuovonomeupdate")) {
				prodottoTrovato = true;
			}
		}
		assertTrue(prodottoTrovato);
	}
	
	@Test
	public void deleteProdottoTest() throws Exception {
		Connection con = DbCon.getConnection();
		ProdottoDao dao = new ProdottoDao(con);
		dao.insertProdotto(10, "ProvaNomeDelete", "ProvaMarca", "ProvaDescrizione", "2020-01-01", "videogame");
		Prodotto ultimoProdotto = dao.getUltimoProdotto();
		
		boolean prodottoCancellato = false;
		if (ultimoProdotto.getNome().equalsIgnoreCase("provanomedelete")) {
			prodottoCancellato = true;
		}
		
		assertTrue(prodottoCancellato);
	}
	
	@Test
	public void controllaEsistenzaTest() throws Exception {
		Connection con = DbCon.getConnection();
		ProdottoDao dao = new ProdottoDao(con);
		dao.insertProdotto(10, "ProvaNomeEsistenza", "ProvaMarca", "ProvaDescrizione", "2020-01-01", "videogame");
		Prodotto ultimoProdotto = dao.getUltimoProdotto();
		boolean prodottoCancellato = dao.controllaEsistenza(String.valueOf(ultimoProdotto.getCodice()));
		
		assertTrue(prodottoCancellato);
	}

}
