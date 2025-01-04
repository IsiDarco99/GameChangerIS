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

@WebServlet("/verifica-username")
public class VerificaUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

@Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("nuovousername");
    boolean isValid = false;
try {
	UserDao userDao = new UserDao(DbCon.getConnection());
	isValid = userDao.checkUsername(username);
} catch (Exception e) {
	e.printStackTrace();
}
    response.setContentType("application/json");
    PrintWriter out = response.getWriter();
    out.println("{ \"valid\": " + isValid + " }");
  }
}

