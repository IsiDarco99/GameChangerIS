package cn.gamechanger.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.*;
import cn.gamechanger.model.dao.*;

@WebServlet("/checkout-1")
public class Checkout1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Checkout1Servlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDao userDao = new UserDao(DbCon.getConnection());
            String username = (String) request.getSession().getAttribute("userSession");
            User user = userDao.getUserProfile(username);
            request.setAttribute("user", user);
            request.getRequestDispatcher("Checkout.jsp").forward(request, response);
            return;
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
	}

