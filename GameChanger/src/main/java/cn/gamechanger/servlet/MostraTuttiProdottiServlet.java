package cn.gamechanger.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.*;
import cn.gamechanger.model.dao.*;

@WebServlet("/mostra-tutti-prodotti")
public class MostraTuttiProdottiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String categoria = request.getParameter("categoria");
            
            if(categoria.equals("allProdotti")) {
            	ProdottoDao pd = new ProdottoDao(DbCon.getConnection());
                List<Prodotto> prodotti = pd.getAllProdotto();
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

}
