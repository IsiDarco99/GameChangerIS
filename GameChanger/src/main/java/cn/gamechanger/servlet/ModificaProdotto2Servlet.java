package cn.gamechanger.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.User;
import cn.gamechanger.model.dao.AccessorioDao;
import cn.gamechanger.model.dao.ComputerDao;
import cn.gamechanger.model.dao.ConsoleDao;
import cn.gamechanger.model.dao.ProdottoDao;
import cn.gamechanger.model.dao.UserDao;
import cn.gamechanger.model.dao.VideogameDao;

@WebServlet("/modifica-prodotto2")
public class ModificaProdotto2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificaProdotto2Servlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String categoria = (String) request.getParameter("categoria");
		String codiceStr = (String) request.getParameter("codice");
		int codice = Integer.parseInt(codiceStr);

		if (categoria.equals("videogame")) {
			try {
				String nome = (String) request.getParameter("nome");
				String marca = (String) request.getParameter("marca");
				String prezzoStr = (String) request.getParameter("prezzo");
				float prezzo = Float.parseFloat(prezzoStr);
				String data = (String) request.getParameter("data");
				String descrizione = (String) request.getParameter("descrizioneprodotto");
				String pegi = (String) request.getParameter("pegi");
				String sviluppatore = (String) request.getParameter("sviluppatore");
				String genere = (String) request.getParameter("genere");

				ProdottoDao prodottoDao = new ProdottoDao(DbCon.getConnection());
				prodottoDao.updateProdotto(codice, prezzo, nome, marca, descrizione, data);

				VideogameDao videogameDao = new VideogameDao(DbCon.getConnection());
				videogameDao.updateVideogame(codice, pegi, sviluppatore, genere);
				request.getRequestDispatcher("prodottoModificato.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (categoria.equals("accessorio")) {
			try {
				String nome = (String) request.getParameter("nome");
				String marca = (String) request.getParameter("marca");
				String prezzoStr = (String) request.getParameter("prezzo");
				float prezzo = Float.parseFloat(prezzoStr);
				String data = (String) request.getParameter("data");
				String descrizione = (String) request.getParameter("descrizioneprodotto");
				String tipo = (String)request.getParameter("tipo"); 

				ProdottoDao prodottoDao = new ProdottoDao(DbCon.getConnection());
				prodottoDao.updateProdotto(codice, prezzo, nome, marca, descrizione, data);

				AccessorioDao accessorioDao = new AccessorioDao(DbCon.getConnection());
				accessorioDao.updateAccessorio(codice, tipo);
				request.getRequestDispatcher("prodottoModificato.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (categoria.equals("computer")) {
			try {
				String nome = (String) request.getParameter("nome");
				String marca = (String) request.getParameter("marca");
				String prezzoStr = (String) request.getParameter("prezzo");
				float prezzo = Float.parseFloat(prezzoStr);
				String data = (String) request.getParameter("data");
				String descrizione = (String) request.getParameter("descrizioneprodotto");
				
				String casa = "n";
		        String ufficio = "n";
		        String gaming = "n";

		        if (request.getParameter("casa") != null) {
		            casa = "y";
		        }
		        if (request.getParameter("ufficio") != null) {
		            ufficio = "y";
		        }
		        if (request.getParameter("gaming") != null) {
		            gaming = "y";
		        }

				ProdottoDao prodottoDao = new ProdottoDao(DbCon.getConnection());
				prodottoDao.updateProdotto(codice, prezzo, nome, marca, descrizione, data);

				ComputerDao computerDao = new ComputerDao(DbCon.getConnection());
				computerDao.updateComputer(codice, casa, ufficio, gaming);
				request.getRequestDispatcher("prodottoModificato.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (categoria.equals("console")) {
			try {
				String nome = (String) request.getParameter("nome");
				String marca = (String) request.getParameter("marca");
				String prezzoStr = (String) request.getParameter("prezzo");
				float prezzo = Float.parseFloat(prezzoStr);
				String data = (String) request.getParameter("data");
				String descrizione = (String) request.getParameter("descrizioneprodotto");
				String generazione = (String)request.getParameter("gen"); 

				ProdottoDao prodottoDao = new ProdottoDao(DbCon.getConnection());
				prodottoDao.updateProdotto(codice, prezzo, nome, marca, descrizione, data);

				ConsoleDao consoleDao = new ConsoleDao(DbCon.getConnection());
				consoleDao.updateConsole(codice, generazione);
				request.getRequestDispatcher("prodottoModificato.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
