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

@WebServlet("/mostra-prodotto")
public class MostraProdottoSingoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MostraProdottoSingoloServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try {
    	    int codice = Integer.parseInt(request.getParameter("codice"));
    	    String categoria = null;

    	    VideogameDao vd = new VideogameDao(DbCon.getConnection());
    	    Videogame videogame = vd.getVideogameByCodice(codice);

    	    ComputerDao cpd = new ComputerDao(DbCon.getConnection());
    	    Computer computer = cpd.getComputerByCodice(codice);

    	    ConsoleDao csd = new ConsoleDao(DbCon.getConnection());
    	    Console console = csd.getConsoleByCodice(codice);

    	    AccessorioDao ad = new AccessorioDao(DbCon.getConnection());
    	    Accessorio accessorio = ad.getAccessorioByCodice(codice);

    	    if (videogame != null) {
    	        categoria = "videogame";
    	    } else if (computer != null) {
    	        categoria = "computer";
    	    } else if (console != null) {
    	        categoria = "console";
    	    } else if (accessorio != null) {
    	        categoria = "accessorio";
    	    }

    	    if (categoria != null) {
    	        if (categoria.equals("videogame")) {
    	            Videogame prodotto = videogame;
    	            String redirectURL = "/paginaprodotto.jsp";
    	            request.setAttribute("prodotto", prodotto);
    	            request.setAttribute("categoria", categoria);
    	            request.getRequestDispatcher(redirectURL).forward(request, response);
    	        } else if (categoria.equals("computer")) {
    	        	Computer prodotto = computer;
    	            String redirectURL = "/paginaprodotto.jsp";
    	            request.setAttribute("prodotto", prodotto);
    	            request.setAttribute("categoria", categoria);
    	            request.getRequestDispatcher(redirectURL).forward(request, response);
    	        } else if (categoria.equals("accessorio")) {
    	        	Accessorio prodotto = accessorio;
    	            String redirectURL = "/paginaprodotto.jsp";
    	            request.setAttribute("prodotto", prodotto);
    	            request.setAttribute("categoria", categoria);
    	            request.getRequestDispatcher(redirectURL).forward(request, response);
    	        } else if (categoria.equals("console")) {
    	        	Console prodotto = console;
    	            String redirectURL = "/paginaprodotto.jsp";
    	            request.setAttribute("prodotto", prodotto);
    	            request.setAttribute("categoria", categoria);
    	            request.getRequestDispatcher(redirectURL).forward(request, response);
    	        }
    	    }
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
