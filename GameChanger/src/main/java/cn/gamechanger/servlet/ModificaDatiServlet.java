package cn.gamechanger.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.dao.UserDao;

@WebServlet("/modifica-dati")
public class ModificaDatiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModificaDatiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cap = 0;
		String username = (String) request.getSession().getAttribute("userSession");
		String nuovousername = (String) request.getAttribute("nuovousername");
		String password = (String) request.getAttribute("nuovapassword");
		String immagine = (String) request.getAttribute("immagine");
		String mail = (String) request.getAttribute("nuovamail");
		String paypal = (String) request.getAttribute("nuovamailpaypal");
		String numero = (String) request.getAttribute("nuovonum");
		String stato = (String) request.getAttribute("nuovoStato");
		String indirizzo = (String) request.getAttribute("nuovaVia");
		String citta = (String) request.getAttribute("nuovaCitta");
		Integer capAttr = (Integer) request.getAttribute("nuovoCAP");
		cap = (capAttr != null) ? capAttr.intValue() : 0;
		
		UserDao userDao = null;
		try {
			if (nuovousername != null) {
				userDao = new UserDao(DbCon.getConnection());
				userDao.updateUsername(username, nuovousername);
				System.out.println(username);
				request.getRequestDispatcher("profilo.jsp").forward(request, response);
			} else if (password != null) {
				userDao = new UserDao(DbCon.getConnection());
				userDao.updateUsername(username, password);
				request.getRequestDispatcher("profilo.jsp").forward(request, response);
			} else if (immagine != null) {
				userDao = new UserDao(DbCon.getConnection());
				userDao.updateImmagine(username, immagine);;
				request.getRequestDispatcher("profilo.jsp").forward(request, response);
			} else if (mail != null) {
				userDao = new UserDao(DbCon.getConnection());
				userDao.updateEmail(username, mail);;
				request.getRequestDispatcher("profilo.jsp").forward(request, response);
			} else if (paypal != null) {
				userDao = new UserDao(DbCon.getConnection());
				userDao.updatePaypal(username, paypal);;
				request.getRequestDispatcher("profilo.jsp").forward(request, response);
			} else if (numero != null) {
				userDao = new UserDao(DbCon.getConnection());
				userDao.updateNumero(username, numero);;
				request.getRequestDispatcher("profilo.jsp").forward(request, response);
			} else if (indirizzo != null) {
				userDao = new UserDao(DbCon.getConnection());
				userDao.updateIndirizzo(username, indirizzo, stato, citta, cap);;
				request.getRequestDispatcher("profilo.jsp").forward(request, response);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
