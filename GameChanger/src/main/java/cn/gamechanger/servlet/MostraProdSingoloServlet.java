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

@WebServlet("/mostra-prodotto")
public class MostraProdSingoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MostraProdSingoloServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try {
    	    int codice = Integer.parseInt(request.getParameter("codice"));
    	    String categoria = null;
    	    
    	    ProdottoDao pd = new ProdottoDao(DbCon.getConnection());
    	    Prodotto prodotto = pd.getProdottoByCodice(codice);
            String redirectURL = "/paginaProdotto.jsp";
            request.setAttribute("prodotto", prodotto);
            request.getRequestDispatcher(redirectURL).forward(request, response);
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
