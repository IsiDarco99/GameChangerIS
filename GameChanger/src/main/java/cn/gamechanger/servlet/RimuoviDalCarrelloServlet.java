package cn.gamechanger.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.gamechanger.bean.Carrello;
import cn.gamechanger.connection.DbCon;
import cn.gamechanger.dao.CarrelloDao;

@WebServlet("/rimuovi-prodotto")
public class RimuoviDalCarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarrelloDao carrelloDao;

	@Override
	public void init() throws ServletException {
		super.init();
		carrelloDao = new CarrelloDao(null);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("userSession");
		int codiceProdotto = Integer.parseInt(request.getParameter("codice"));

		try {
			CarrelloDao cdao = new CarrelloDao(DbCon.getConnection());
			cdao.rimuoviProdottoDalCarrello(username, codiceProdotto);
			CarrelloDao cd = new CarrelloDao(DbCon.getConnection());
			List<Carrello> prodotti = cd.getCarrelloByUsername(username);
			String redirectURL = "/carrello.jsp";
            request.setAttribute("prodotti", prodotti);
            request.getRequestDispatcher(redirectURL).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
