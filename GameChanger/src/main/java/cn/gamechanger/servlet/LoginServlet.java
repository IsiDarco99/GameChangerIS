package cn.gamechanger.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import cn.gamechanger.model.User;
import cn.gamechanger.model.dao.UserDao;

import cn.gamechanger.connection.DbCon;

@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.sendRedirect("login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    try (PrintWriter out = response.getWriter()) {
	        String email = request.getParameter("login-username");
	        String password = request.getParameter("login-password");

	        try {
	            UserDao udao = new UserDao(DbCon.getConnection());
	            User user = udao.userLogin(email, password);

	            if (user != null) {
	                // Creazione del cookie di sessione per l'utente
	                Cookie sessionCookie = new Cookie("userSession", user.getUsername());
	                sessionCookie.setMaxAge(60 * 60 * 24);
	                response.addCookie(sessionCookie);

	                out.print("user login");
	            } else {
	                out.print("user login failed");
	            }

	            Cookie[] cookies = request.getCookies();
	            if (cookies != null) {
	                for (Cookie cookie : cookies) {
	                    System.out.println("Cookie Name: " + cookie.getName());
	                    System.out.println("Cookie Value: " + cookie.getValue());
	                }
	            }
	        } catch (ClassNotFoundException cnfe) {
	            cnfe.printStackTrace();
	        } catch (SQLException sqle) {
	            sqle.printStackTrace();
	        }

	        out.print(email + password);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}
