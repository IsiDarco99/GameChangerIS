package cn.gamechanger.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.User;
import cn.gamechanger.model.dao.UserDao;

@WebServlet("/checkout-2")
public class Checkout2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Checkout2Servlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkboxValue = request.getParameter("salva-dati");
		boolean isChecked = "on".equals(checkboxValue);
		
		UserDao userDao = null;
		
		try {
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
	            request.getRequestDispatcher("Checkout2.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("Checkout2.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
