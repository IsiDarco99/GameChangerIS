package cn.gamechanger.servlet;

import java.io.IOException;
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
	    
	    try {
	        CarrelloDao cd = new CarrelloDao(DbCon.getConnection());
	        List<Carrello> prodotti = cd.getCarrelloByUsername(username);
	        request.setAttribute("prodotti", prodotti);
	        
	        float prezzo = Float.parseFloat(request.getParameter("prezzo"));
	        int codice = Integer.parseInt(request.getParameter("codice"));
	        int quant_prod = Integer.parseInt(request.getParameter("quantita"));
	        String stato_ord = "confermato";
	        int data_ord = 0;
	        
	        OrdineDao od = new OrdineDao(DbCon.getConnection());
	        Ordine ordine = od.salvaOrdine(username, codice, quant_prod, prezzo, stato_ord, data_ord);
	        
	        request.setAttribute("ordine", ordine);
	        request.getRequestDispatcher("checkout3.jsp").forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}