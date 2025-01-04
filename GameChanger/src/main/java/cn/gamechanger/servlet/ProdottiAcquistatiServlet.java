package cn.gamechanger.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.bean.*;
import cn.gamechanger.connection.DbCon;
import cn.gamechanger.dao.*;

@WebServlet("/prodotti-acquistati")
public class ProdottiAcquistatiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProdottiAcquistatiServlet() {
        super();
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("userSession");

        try {
            OrdineDao ordineDAO = new OrdineDao(DbCon.getConnection());
            Map<Ordine, List<ProdottoOrdine>> ordiniEProdotti = ordineDAO.getOrdiniUtente(username);
            request.setAttribute("ordiniEProdotti", ordiniEProdotti);
            request.getRequestDispatcher("prodottiAcquistati.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}


