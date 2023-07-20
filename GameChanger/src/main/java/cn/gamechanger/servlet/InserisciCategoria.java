package cn.gamechanger.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Prodotto;
import cn.gamechanger.model.dao.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Inserisci-Categoria")
public class InserisciCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pegiStr = request.getParameter("pegi");
	    int pegi = Integer.parseInt(pegiStr);
	    int codice = 0;
		String sviluppatore = request.getParameter("sviluppatore");
		String genere = request.getParameter("genere");
		
		VideogameDao vDao;
		ProdottoDao pDao = null;
		try {
			pDao = new ProdottoDao(DbCon.getConnection());
			Prodotto ultimoProdotto = new Prodotto();
			ultimoProdotto = pDao.getUltimoProdotto();
			codice = ultimoProdotto.getCodice();
			vDao = new VideogameDao(DbCon.getConnection());
			vDao.insertVideogame(codice, pegi, sviluppatore, genere);
			response.sendRedirect("uploadImmagini.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
