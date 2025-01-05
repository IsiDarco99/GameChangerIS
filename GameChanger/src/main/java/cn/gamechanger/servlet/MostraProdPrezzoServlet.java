package cn.gamechanger.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.bean.*;
import cn.gamechanger.connection.DbCon;
import cn.gamechanger.dao.*;

@WebServlet("/filtra-prezzo")
public class MostraProdPrezzoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MostraProdPrezzoServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try {
    		int min = 0;
            int max = 9999;
            
            String minParam = request.getParameter("min");
            String maxParam = request.getParameter("max");

            if (minParam != null && !minParam.isEmpty()) {
                min = Integer.parseInt(minParam);
            }
            if (maxParam != null && !maxParam.isEmpty()) {
                max = Integer.parseInt(maxParam);
            }
    	    String categoria = request.getParameter("categoria");

    	    if (categoria.equals("videogiochi")) {
    	    	ProdottoDao pd = new ProdottoDao(DbCon.getConnection());
                List<Prodotto> prodotti = pd.getVideogameByPrezzo(min, max);
                String redirectURL = "/sfogliaProdotti.jsp?categoria=" + categoria;
                request.setAttribute("prodotti", prodotti);
                request.getRequestDispatcher(redirectURL).forward(request, response);
            } else if (categoria.equals("computer")) {
            	ProdottoDao pd = new ProdottoDao(DbCon.getConnection());
                List<Prodotto> prodotti = pd.getComputerByPrezzo(min, max);
                String redirectURL = "/sfogliaProdotti.jsp?categoria=" + categoria;
                request.setAttribute("prodotti", prodotti);
                request.getRequestDispatcher(redirectURL).forward(request, response);
            } else if (categoria.equals("accessori")) {
            	ProdottoDao pd = new ProdottoDao(DbCon.getConnection());
                List<Prodotto> prodotti = pd.getAccessorioByPrezzo(min, max);
                String redirectURL = "/sfogliaProdotti.jsp?categoria=" + categoria;
                request.setAttribute("prodotti", prodotti);
                request.getRequestDispatcher(redirectURL).forward(request, response);
            } else if (categoria.equals("console")) {
            	ProdottoDao pd = new ProdottoDao(DbCon.getConnection());
                List<Prodotto> prodotti = pd.getConsoleByPrezzo(min, max);
                String redirectURL = "/sfogliaProdotti.jsp?categoria=" + categoria;
                request.setAttribute("prodotti", prodotti);
                request.getRequestDispatcher(redirectURL).forward(request, response);
            }
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
