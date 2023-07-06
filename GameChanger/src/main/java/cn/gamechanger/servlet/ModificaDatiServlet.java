package cn.gamechanger.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.User;
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
		String nuovousername = (String) request.getParameter("nuovousername");
		String nuovapassword = (String) request.getParameter("nuovapassword");
		String vecchiapassword = (String) request.getParameter("vecchiapassword");
		String immagine = (String) request.getParameter("valore");
		String mail = (String) request.getParameter("nuovamail");
		String paypal = (String) request.getParameter("nuovamailpaypal");
		String numero = (String) request.getParameter("nuovonum");
		String stato = (String) request.getParameter("nuovoStato");
		String indirizzo = (String) request.getParameter("nuovaVia");
		String citta = (String) request.getParameter("nuovaCitta");
		Integer capAttr = (Integer) request.getAttribute("nuovoCAP");
		cap = (capAttr != null) ? capAttr.intValue() : 0;
		System.out.println(immagine);
		
		UserDao userDao = null;
		try {
			if (nuovousername != null) {
				userDao = new UserDao(DbCon.getConnection());
				userDao.updateUsername(username, nuovousername);
				User user = userDao.getUserProfile(nuovousername);
	            request.setAttribute("user", user);
	            HttpSession session = request.getSession();
	            session.setAttribute("userSession", user.getUsername());
	            request.getRequestDispatcher("profilo.jsp").forward(request, response);
			} else if (nuovapassword != null) {
				userDao = new UserDao(DbCon.getConnection());
				User user = userDao.getUserProfile(username);
				if (!vecchiapassword.equals(user.getPassword())){
					
				} else {
				userDao.updatePassword(username, nuovapassword);
				}
	            request.setAttribute("user", user);
				request.getRequestDispatcher("profilo.jsp").forward(request, response);
			} else if (immagine != null) {
				userDao = new UserDao(DbCon.getConnection());
				switch (immagine) {
				case "mario":
					userDao.updateImmagine(username, "1");
					User user = userDao.getUserProfile(username);
		            request.setAttribute("user", user);
					request.getRequestDispatcher("profilo.jsp").forward(request, response);
					break;
				case "peach":
					userDao.updateImmagine(username, "2");
					User user1 = userDao.getUserProfile(username);
		            request.setAttribute("user", user1);
					request.getRequestDispatcher("profilo.jsp").forward(request, response);
					break;
				case "hunter":
					userDao.updateImmagine(username, "3");
					User user2 = userDao.getUserProfile(username);
		            request.setAttribute("user", user2);
					request.getRequestDispatcher("profilo.jsp").forward(request, response);
					break;
				case "kratos":
					userDao.updateImmagine(username, "4");
					User user3 = userDao.getUserProfile(username);
		            request.setAttribute("user", user3);
					request.getRequestDispatcher("profilo.jsp").forward(request, response);
					break;
				case "cody":
					userDao.updateImmagine(username, "5");
					User user4 = userDao.getUserProfile(username);
		            request.setAttribute("user", user4);
					request.getRequestDispatcher("profilo.jsp").forward(request, response);
					break;
				case "may":
					userDao.updateImmagine(username, "6");
					User user5 = userDao.getUserProfile(username);
		            request.setAttribute("user", user5);
					request.getRequestDispatcher("profilo.jsp").forward(request, response);
					break;
				case "link":
					userDao.updateImmagine(username, "7");
					User user6 = userDao.getUserProfile(username);
		            request.setAttribute("user", user6);
					request.getRequestDispatcher("profilo.jsp").forward(request, response);
					break;
				case "zoro":
					userDao.updateImmagine(username, "8");
					User user7 = userDao.getUserProfile(username);
		            request.setAttribute("user", user7);
					request.getRequestDispatcher("profilo.jsp").forward(request, response);
					break;
				}
				
				

			} else if (mail != null) {
				userDao = new UserDao(DbCon.getConnection());
				userDao.updateEmail(username, mail);;
				User user = userDao.getUserProfile(username);
	            request.setAttribute("user", user);
				request.getRequestDispatcher("profilo.jsp").forward(request, response);
			} else if (paypal != null) {
				userDao = new UserDao(DbCon.getConnection());
				userDao.updatePaypal(username, paypal);;
				User user = userDao.getUserProfile(username);
	            request.setAttribute("user", user);
				request.getRequestDispatcher("profilo.jsp").forward(request, response);
			} else if (numero != null) {
				userDao = new UserDao(DbCon.getConnection());
				userDao.updateNumero(username, numero);;
				User user = userDao.getUserProfile(username);
	            request.setAttribute("user", user);
				request.getRequestDispatcher("profilo.jsp").forward(request, response);
			} else if (indirizzo != null) {
				userDao = new UserDao(DbCon.getConnection());
				userDao.updateIndirizzo(username, indirizzo, stato, citta, cap);
				User user = userDao.getUserProfile(username);
	            request.setAttribute("user", user);
				request.getRequestDispatcher("profilo.jsp").forward(request, response);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
