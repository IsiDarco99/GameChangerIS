package cn.gamechanger.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.*;
import cn.gamechanger.model.dao.*;

@WebServlet("/filtra-prezzo")
public class MostraProdottiPrezzoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MostraProdottiPrezzoServlet() {
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

    	    if(categoria.equals("allProdotti")) {
            	ProdottoDao pd = new ProdottoDao(DbCon.getConnection());
                List<Prodotto> prodotti = pd.getProdottoByPrezzo(min, max);
                String redirectURL = "/sfogliaProdotti.jsp?categoria=" + categoria;
                request.setAttribute("prodotti", prodotti);
                request.getRequestDispatcher(redirectURL).forward(request, response);
            } else if (categoria.equals("videogiochi")) {
            	VideogameDao vd = new VideogameDao(DbCon.getConnection());
            	List<Videogame> prodotti = (List<Videogame>) vd.getVideogameByPrezzo(min, max);
            	String redirectURL = "/sfogliaProdotti.jsp?categoria=" + categoria;
                request.setAttribute("prodotti", prodotti);
                request.getRequestDispatcher(redirectURL).forward(request, response);
            } else if (categoria.equals("computer")) {
            	ComputerDao cpd = new ComputerDao(DbCon.getConnection());
            	List<Computer> prodotti = (List<Computer>) cpd.getComputerByPrezzo(min, max);
            	String redirectURL = "/sfogliaProdotti.jsp?categoria=" + categoria;
                request.setAttribute("prodotti", prodotti);
                request.getRequestDispatcher(redirectURL).forward(request, response);
            } else if (categoria.equals("accessori")) {
            	AccessorioDao ad = new AccessorioDao(DbCon.getConnection());
            	List<Accessorio> prodotti = (List<Accessorio>) ad.getAccessorioByPrezzo(min, max);
            	String redirectURL = "/sfogliaProdotti.jsp?categoria=" + categoria;
                request.setAttribute("prodotti", prodotti);
                request.getRequestDispatcher(redirectURL).forward(request, response);
            } else if (categoria.equals("console")) {
            	ConsoleDao csd = new ConsoleDao(DbCon.getConnection());
            	List<Console> prodotti = csd.getConsoleByPrezzo(min, max);
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
