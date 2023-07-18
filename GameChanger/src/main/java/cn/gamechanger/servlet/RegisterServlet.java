package cn.gamechanger.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.model.User;
import cn.gamechanger.model.dao.UserDao;

import cn.gamechanger.connection.DbCon;

@WebServlet("/user-register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
		    response.sendRedirect("register.jsp");
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
		}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    try (PrintWriter out = response.getWriter()){
	        String username = request.getParameter("nuovousername");
	        String emailPers = request.getParameter("emailPers");
	        String password = request.getParameter("password");
	        String nome = request.getParameter("nome");
	        String cognome = request.getParameter("cognome");
	        String dataNascita = request.getParameter("datanascita");
	        
	       
	        User user = new User(username, emailPers, "", 0, "", "", "", 0, password, nome, cognome, dataNascita, "", 0);

	        try {
	            UserDao udao = new UserDao(DbCon.getConnection());
	            boolean registrationSuccess = udao.registerUser(user);

	            if (registrationSuccess) {
	            	response.sendRedirect("login.jsp");
	            } else {
	                out.print("Errore durante la registrazione");
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}
