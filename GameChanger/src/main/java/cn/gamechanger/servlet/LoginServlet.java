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

@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()){
			String email = request.getParameter("login-username");
			String password = request.getParameter("login-password");
			
			try {
			    // Codice che potrebbe generare un'eccezione specifica
			    UserDao udao = new UserDao(DbCon.getConnection());
			    User user = udao.userLogin(email, password);
			    
			    if (user != null) {
			        out.print("user login");
			    } else {
			        out.print("user login failed");
			    }
			} catch (ClassNotFoundException cnfe) {
			    cnfe.printStackTrace();
			} catch (SQLException sqle) {
			    sqle.printStackTrace();
			}
			
			
			out.print(email+password);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
