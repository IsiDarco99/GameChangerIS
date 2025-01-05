package cn.gamechanger.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.bean.*;
import cn.gamechanger.connection.DbCon;
import cn.gamechanger.dao.*;

@WebServlet("/checkout-1")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public CheckoutServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String step = request.getParameter("step");
		switch (step) {
		case "1":
			try {
				UserDao userDao = new UserDao(DbCon.getConnection());
				String username = (String) request.getSession().getAttribute("userSession");
				User user = userDao.getUserProfile(username);
				request.setAttribute("user", user);
				request.getRequestDispatcher("checkout.jsp").forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "2":
			try {
				String checkboxValue = request.getParameter("salva-dati");
				boolean isChecked = "on".equals(checkboxValue);

				UserDao userDao = null;
				userDao = new UserDao(DbCon.getConnection());
				String username = (String) request.getSession().getAttribute("userSession");
				User user = userDao.getUserProfile(username);
				request.setAttribute("user", user);

				if (isChecked) {
					String indirizzo = request.getParameter("address");
					String citta = request.getParameter("city");
					String stato = request.getParameter("state");
					int codicePostale = Integer.parseInt(request.getParameter("zip"));

					user.setIndirizzo(indirizzo);
					user.setCitta(citta);
					user.setStato(stato);
					user.setCod_postale(codicePostale);

					userDao.updateUser(user);
					request.getRequestDispatcher("checkout2.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("checkout2.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "3":
			try {
				String username = (String) request.getSession().getAttribute("userSession");
				String checkboxValue = request.getParameter("salva-dati");
				boolean isChecked = "on".equals(checkboxValue);
				CarrelloDao cd = new CarrelloDao(DbCon.getConnection());
				List<Carrello> prodotti = cd.getCarrelloByUsername(username);
				request.setAttribute("prodotti", prodotti);

				UserDao userDao = new UserDao(DbCon.getConnection());
				User user = userDao.getUserProfile(username);
				request.setAttribute("user", user);
				if (isChecked) {
					String emailPaypalString = request.getParameter("emailPayPal");

					user.setEmailPaypal(emailPaypalString);

					userDao.updateUserPayPal(user);;
					request.getRequestDispatcher("checkout3.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("checkout3.jsp").forward(request, response);
				}                
			} catch (Exception e) {
				e.getStackTrace();
			}
			break;
		case "4":
			try {
				String username = (String) request.getSession().getAttribute("userSession");
				String statoOrd = "Ordine confermato, in attesa di spedizione";
				LocalDate dataOrd = LocalDate.now();
				String dataOrdStringa = dataOrd.toString();
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
}

