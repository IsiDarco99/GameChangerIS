package cn.gamechanger.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Carrello;
import cn.gamechanger.model.Ordine;
import cn.gamechanger.model.dao.CarrelloDao;
import cn.gamechanger.model.dao.OrdineDao;


@WebServlet("/Checkout-5")
public class Checkout5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Checkout5Servlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username = (String) request.getSession().getAttribute("userSession");
	    String statoOrd = "Ordine confermato, in attesa di spedizione";
	    LocalDate dataOrd = LocalDate.now();
	    String dataOrdStringa = dataOrd.toString();
	    
	    try {
	        CarrelloDao cd = new CarrelloDao(DbCon.getConnection());
	        List<Carrello> prodotti = cd.getCarrelloByUsername(username);
	        
	        OrdineDao ordineDao = new OrdineDao(DbCon.getConnection());
            Ordine ordine = new Ordine();
            ordine.setUsername(username);
            ordine.setStato_ord(statoOrd);
            ordine.setDataOrd(dataOrdStringa);
            ordineDao.aggiungiOrdine(ordine, prodotti);
            
            cd.cancellaCarrello(username);
	        
	        request.getRequestDispatcher("checkout4.jsp").forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}