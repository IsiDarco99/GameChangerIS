package cn.gamechanger.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.gamechanger.bean.Carrello;
import cn.gamechanger.bean.Ordine;
import cn.gamechanger.bean.ProdottoOrdine;
import cn.gamechanger.connection.DbCon;

public class OrdineDaoTest {

	@Test
	public void aggiungiOrdineTest() throws Exception {
		Connection con = DbCon.getConnection();
		OrdineDao dao = new OrdineDao(con);

		Ordine ordine = new Ordine(10, "user10", "In lavorazione", "2023-01-06");
		ProdottoOrdine prodOrd = new ProdottoOrdine(1, 3, "Prova", 19, 1);
		List<Carrello> carrelli = new ArrayList<>();
		carrelli.add(new Carrello(1, "user10", prodOrd.getCodice(), prodOrd.getQuantita(), prodOrd.getNome(),
				prodOrd.getPrezzo()));

		dao.aggiungiOrdine(ordine, carrelli);

		Map<Ordine, List<ProdottoOrdine>> ordiniEProdotti = dao.getAllOrdini();

		boolean ordineTrovato = false;
		for (Map.Entry<Ordine, List<ProdottoOrdine>> entry : ordiniEProdotti.entrySet()) {
			Ordine ordineInMap = entry.getKey();
			List<ProdottoOrdine> prodottiOrdineInMap = entry.getValue();

			if (ordineInMap.getUsername().equals(ordine.getUsername())
					&& ordineInMap.getStato_ord().equals(ordine.getStato_ord())
					&& ordineInMap.getDataOrd().equals(ordine.getDataOrd())) {
				ordineTrovato = true;
				break;
			}

			for (ProdottoOrdine prodottoInMap : prodottiOrdineInMap) {
				if (prodottoInMap.getCodice() == prodOrd.getCodice()
						&& prodottoInMap.getNome().equals(prodOrd.getNome())
						&& prodottoInMap.getPrezzo() == prodOrd.getPrezzo()
						&& prodottoInMap.getQuantita() == prodOrd.getQuantita()) {
					ordineTrovato = true;
					break;
				}
			}
		}
		assertTrue(ordineTrovato);
	}

	@Test
	public void getOrdiniUtenteTest() throws Exception {
		Connection con = DbCon.getConnection();
		OrdineDao dao = new OrdineDao(con);

		Ordine ordine = new Ordine(10, "user11", "In lavorazione", "2023-01-06");
		ProdottoOrdine prodOrd = new ProdottoOrdine(1, 3, "Prova", 19, 1);
		List<Carrello> carrelli = new ArrayList<>();
		carrelli.add(new Carrello(1, "user11", prodOrd.getCodice(), prodOrd.getQuantita(), prodOrd.getNome(),
				prodOrd.getPrezzo()));

		dao.aggiungiOrdine(ordine, carrelli);

		boolean ordineTrovato = false;
		Map<Ordine, List<ProdottoOrdine>> ordiniEProdotti = dao.getOrdiniUtente("user11");
		for (Map.Entry<Ordine, List<ProdottoOrdine>> entry : ordiniEProdotti.entrySet()) {
			Ordine ordineInMap = entry.getKey();

			if (ordineInMap.getUsername().equals(ordine.getUsername())) {
				ordineTrovato = true;
				break;
			}
		}
		assertTrue(ordineTrovato);
	}

	@Test
	public void getAllOrdiniTest() throws Exception {
		Connection con = DbCon.getConnection();
		OrdineDao dao = new OrdineDao(con);

		Map<Ordine, List<ProdottoOrdine>> ordiniEProdotti = dao.getAllOrdini();

		boolean ordineTrovato = false;
		for (Map.Entry<Ordine, List<ProdottoOrdine>> entry : ordiniEProdotti.entrySet()) {
			Ordine ordineInMap = entry.getKey();

			if (ordineInMap != null) {
				ordineTrovato = true;
			}
		}
		assertTrue(ordineTrovato);
	}

	@Test
	public void getOrdiniByDateRangeTest() throws Exception {
		Connection con = DbCon.getConnection();
		OrdineDao dao = new OrdineDao(con);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate before = LocalDate.parse("2010-01-01", formatter);
		LocalDate after = LocalDate.parse("2010-12-31", formatter);

		Ordine ordine = new Ordine(10, "user12", "In lavorazione", "2010-01-06");
		ProdottoOrdine prodOrd = new ProdottoOrdine(1, 3, "Prova", 19, 1);
		List<Carrello> carrelli = new ArrayList<>();
		carrelli.add(new Carrello(1, "user12", prodOrd.getCodice(), prodOrd.getQuantita(), prodOrd.getNome(),
				prodOrd.getPrezzo()));

		dao.aggiungiOrdine(ordine, carrelli);

		boolean ordineTrovato = false;
		Map<Ordine, List<ProdottoOrdine>> ordiniEProdotti = dao.getOrdiniUtente("user12");
		for (Map.Entry<Ordine, List<ProdottoOrdine>> entry : ordiniEProdotti.entrySet()) {
			Ordine ordineInMap = entry.getKey();
			LocalDate now = LocalDate.parse(ordineInMap.getDataOrd(), formatter);

			if (before.isBefore(now) && after.isAfter(now)) {
				ordineTrovato = true;
				break;
			}
		}
		assertTrue(ordineTrovato);
	}

}
