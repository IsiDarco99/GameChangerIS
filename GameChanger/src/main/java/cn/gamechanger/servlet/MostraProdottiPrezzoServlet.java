package cn.gamechanger.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Accessorio;
import cn.gamechanger.model.Computer;
import cn.gamechanger.model.Console;
import cn.gamechanger.model.Prodotto;
import cn.gamechanger.model.Videogame;
import cn.gamechanger.model.dao.AccessorioDao;
import cn.gamechanger.model.dao.ComputerDao;
import cn.gamechanger.model.dao.ConsoleDao;
import cn.gamechanger.model.dao.ProdottoDao;
import cn.gamechanger.model.dao.VideogameDao;

@WebServlet("/filtra-prezzo")
public class MostraProdottiPrezzoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MostraProdottiPrezzoServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try {
    	    int min = Integer.parseInt(request.getParameter("min"));
    	    int max = Integer.parseInt(request.getParameter("max"));
    	    String categoria = request.getParameter("categoria");

    	    if(categoria.equals("allProdotti")) {
            	ProdottoDao pd = new ProdottoDao(DbCon.getConnection());
                List<Prodotto> prodotti = (List<Prodotto>) pd.getProdottoByPrezzo(min, max);
                String redirectURL = "/sfogliaProdotti.jsp?categoria=" + categoria;
                request.setAttribute("prodotti", prodotti);
                request.getRequestDispatcher(redirectURL).forward(request, response);
            } else if (categoria.equals("videogiochi")) {
            	VideogameDao vd = new VideogameDao(DbCon.getConnection());
            	List<Videogame> prodotti = vd.getAllVideogame();
            	String redirectURL = "/sfogliaProdotti.jsp?categoria=" + categoria;
                request.setAttribute("prodotti", prodotti);
                request.getRequestDispatcher(redirectURL).forward(request, response);
            } else if (categoria.equals("computer")) {
            	ComputerDao cpd = new ComputerDao(DbCon.getConnection());
            	List<Computer> prodotti = cpd.getAllComputer();
            	String redirectURL = "/sfogliaProdotti.jsp?categoria=" + categoria;
                request.setAttribute("prodotti", prodotti);
                request.getRequestDispatcher(redirectURL).forward(request, response);
            } else if (categoria.equals("accessori")) {
            	AccessorioDao ad = new AccessorioDao(DbCon.getConnection());
            	List<Accessorio> prodotti = ad.getAllAccessori();
            	String redirectURL = "/sfogliaProdotti.jsp?categoria=" + categoria;
                request.setAttribute("prodotti", prodotti);
                request.getRequestDispatcher(redirectURL).forward(request, response);
            } else if (categoria.equals("console")) {
            	ConsoleDao csd = new ConsoleDao(DbCon.getConnection());
            	List<Console> prodotti = csd.getAllConsole();
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
