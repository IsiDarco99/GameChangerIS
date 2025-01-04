package cn.gamechanger.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.bean.User;
import cn.gamechanger.connection.DbCon;
import cn.gamechanger.dao.UserDao;

@WebServlet("/verifica-password")
public class VerificaPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

@Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Recupera la vecchia password fornita dall'utente
    String inputPassword = request.getParameter("password");
    String oldPassword = "";
try {
	UserDao userDao = new UserDao(DbCon.getConnection());
    String username = (String) request.getSession().getAttribute("userSession");
    User user = userDao.getUserProfile(username);
    oldPassword = user.getPassword();
} catch (Exception e) {
	e.printStackTrace();
}
     boolean isValid = inputPassword.equals(oldPassword);
    
    // Restituisci la risposta come JSON
    response.setContentType("application/json");
    PrintWriter out = response.getWriter();
    out.println("{ \"valid\": " + isValid + " }");
  }
}
