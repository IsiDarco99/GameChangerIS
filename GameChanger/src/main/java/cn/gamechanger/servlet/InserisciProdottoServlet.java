package cn.gamechanger.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.dao.AmministratoreDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Inserisci-Prodotto")
public class InserisciProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	    private AmministratoreDao amministratoreDao;

	    public void init() throws ServletException {
	        // Inizializza il DAO all'interno del metodo init()
	        try {
				amministratoreDao = new AmministratoreDao(DbCon.getConnection());
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
	    }
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoria = request.getParameter("categoria");
        float prezzo = Float.parseFloat(request.getParameter("prezzoprodotto"));
        String nome = request.getParameter("nomeprodotto");
        String marca = request.getParameter("marcaprodotto");
        String descrizione = request.getParameter("descrizioneprodotto");
        String dataUscita = request.getParameter("data_usc");

        // Chiama il metodo DAO per inserire il prodotto nel database
        amministratoreDao.insertProdotto(prezzo, nome, marca, descrizione, dataUscita);
		doGet(request, response);
		
		switch (categoria) {
        case "videogame":
            response.sendRedirect("modificacategoria.jsp?categoria=videogame");
            break;
        case "accessori":
            response.sendRedirect("modificacategoria.jsp?categoria=accessori");
            break;
        case "console":
            response.sendRedirect("modificacategoria.jsp?categoria=console");
            break;
        case "computer":
            response.sendRedirect("modificacategoria.jsp?categoria=computer");
            break;
        default:
            // Categoria non valida, gestisci l'errore o reindirizza altrove
            break;
    }
	}

	
}
