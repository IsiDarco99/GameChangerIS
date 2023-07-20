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

@WebServlet("/Inserisci-Categoria")
public class InserisciCategoria extends HttpServlet {
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
		int pegi =  (int) request.getAttribute("pegi");
		String sviluppatore = request.getParameter("sviluppatore");
		String genere = request.getParameter("genere");
		
		
		amministratoreDao.insertVideogame(pegi, sviluppatore, genere);
		
		
		
		
		
		
		
		
		
		doGet(request, response);
	}

}
