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


@WebServlet("/modifica-profilo")
public class ModificaProfiloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ModificaProfiloServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String categoria = (String) request.getParameter("valore");
            UserDao userDao = new UserDao(DbCon.getConnection());
            String username = (String) request.getSession().getAttribute("userSession");
            User user = userDao.getUserProfile(username);
            switch (categoria) {
            case "username":
            	request.setAttribute("modifica", categoria);
            	request.setAttribute("user", user);
                request.getRequestDispatcher("modifica.jsp").forward(request, response);
                break;
            case "password":
            	request.setAttribute("modifica", categoria);
            	request.setAttribute("user", user);
                request.getRequestDispatcher("modifica.jsp").forward(request, response);
                break;
            case "immagine":
            	request.setAttribute("modifica", categoria);
            	request.setAttribute("user", user);
                request.getRequestDispatcher("modifica.jsp").forward(request, response);
                break;
            case "mail":
            	request.setAttribute("modifica", categoria);
            	request.setAttribute("user", user);
                request.getRequestDispatcher("modifica.jsp").forward(request, response);
                break;
            case "paypal":
            	request.setAttribute("modifica", categoria);
            	request.setAttribute("user", user);
                request.getRequestDispatcher("modifica.jsp").forward(request, response);
                break;
            case "data":
            	request.setAttribute("modifica", categoria);
            	request.setAttribute("user", user);
                request.getRequestDispatcher("modifica.jsp").forward(request, response);
                break;
            case "codfisc":
            	request.setAttribute("modifica", categoria);
            	request.setAttribute("user", user);
                request.getRequestDispatcher("modifica.jsp").forward(request, response);
                break;
            case "numero":
            	request.setAttribute("modifica", categoria);
            	request.setAttribute("user", user);
                request.getRequestDispatcher("modifica.jsp").forward(request, response);
                break;
            case "indirizzo":
            	request.setAttribute("modifica", categoria);
            	request.setAttribute("user", user);
                request.getRequestDispatcher("modifica.jsp").forward(request, response);
                break;
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	}

}
