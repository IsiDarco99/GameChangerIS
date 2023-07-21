package cn.gamechanger.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Prodotto;
import cn.gamechanger.model.User;
import cn.gamechanger.model.dao.*;

@WebServlet("/elimina-prodotto")
public class EliminaProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EliminaProdottoServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codice = request.getParameter("codice");
		Boolean b = false;
		
		ProdottoDao prodottoDao;
		VideogameDao videogameDao;
		ComputerDao computerDao;
		ConsoleDao consoleDao;
		AccessorioDao accessorioDao;
		try {
			prodottoDao = new ProdottoDao(DbCon.getConnection());
			b = prodottoDao.deleteProdotto(codice);
			
			if (Boolean.TRUE.equals(b)) {
				videogameDao = new VideogameDao(DbCon.getConnection());
				videogameDao.deleteVideogame(codice);
				
				computerDao = new ComputerDao(DbCon.getConnection());
				computerDao.deleteComputer(codice);
				
				consoleDao = new ConsoleDao(DbCon.getConnection());
				consoleDao.deleteConsole(codice);
				
				accessorioDao = new AccessorioDao(DbCon.getConnection());
				accessorioDao.deleteAccessorio(codice);
				
				response.sendRedirect("prodottoCancellato.jsp");
			} else {
				request.setAttribute("errore", "Il prodotto non esiste nel catalogo");
				response.sendRedirect("operazioniamministratore.jsp?modifica=elimina");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
