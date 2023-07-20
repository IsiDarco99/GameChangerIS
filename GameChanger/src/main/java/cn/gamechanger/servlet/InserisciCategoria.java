package cn.gamechanger.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.collections.CaseInsensitiveKeyMap;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Prodotto;
import cn.gamechanger.model.User;
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
		String categoria = (String) request.getParameter("categoria");
		VideogameDao vDao;
		AccessorioDao aDao;
		ConsoleDao cnDao;
		ComputerDao cmDao;
		ProdottoDao pDao = null;
		int codice = 0;
		
        switch (categoria) {
        case "videogame":
        	String pegi = request.getParameter("pegi");
    		String sviluppatore = request.getParameter("sviluppatore");
    		String genere = request.getParameter("genere");
    		
    		try {
    			pDao = new ProdottoDao(DbCon.getConnection());
    			Prodotto ultimoProdotto = pDao.getUltimoProdotto();
    			codice = ultimoProdotto.getCodice();
    			vDao = new VideogameDao(DbCon.getConnection());
    			vDao.insertVideogame(codice, pegi, sviluppatore, genere);
    			response.sendRedirect("uploadImmagini.jsp");
    		} catch (ClassNotFoundException | SQLException e) {
    			e.printStackTrace();
    		}
    		break;
    		
        case "accessori":
        	String tipo = request.getParameter("tipo");
    		
    		try {
    			pDao = new ProdottoDao(DbCon.getConnection());
    			Prodotto ultimoProdotto = pDao.getUltimoProdotto();
    			codice = ultimoProdotto.getCodice();
    			aDao = new AccessorioDao(DbCon.getConnection());
    			aDao.insertAccessorio(codice, tipo);
    			response.sendRedirect("uploadImmagini.jsp");
    		} catch (ClassNotFoundException | SQLException e) {
    			e.printStackTrace();
    		}
    		break;
    		
        case "console":
        	String gen = request.getParameter("generazione");
    		
    		try {
    			pDao = new ProdottoDao(DbCon.getConnection());
    			Prodotto ultimoProdotto = pDao.getUltimoProdotto();
    			codice = ultimoProdotto.getCodice();
    			cnDao = new ConsoleDao(DbCon.getConnection());
    			cnDao.insertConsole(codice, gen);
    			response.sendRedirect("uploadImmagini.jsp");
    		} catch (ClassNotFoundException | SQLException e) {
    			e.printStackTrace();
    		}
    		break;
        
        
        case "computer":
        		String casa = request.getParameter("casa");
        		String ufficio = request.getParameter("ufficio");
        		String gaming = request.getParameter("gaming");
        		
        		if (casa == null){
        			casa = "n";
        		} else {
        			casa = "y";
        		}
        		if (ufficio != null){
        			ufficio = "n";
        		} else {
        			ufficio = "y";
        		}
        		if (gaming != null){
        			gaming = "n";
        		} else {
        			gaming = "y";
        		}
    		try {
    			pDao = new ProdottoDao(DbCon.getConnection());
    			Prodotto ultimoProdotto = pDao.getUltimoProdotto();
    			codice = ultimoProdotto.getCodice();
    			cmDao = new ComputerDao(DbCon.getConnection());
    			cmDao.insertComputer(codice, casa, ufficio, gaming);
    			response.sendRedirect("uploadImmagini.jsp");
    		} catch (ClassNotFoundException | SQLException e) {
    			e.printStackTrace();
    		}
    		break;
		
        }
		
	}

}
