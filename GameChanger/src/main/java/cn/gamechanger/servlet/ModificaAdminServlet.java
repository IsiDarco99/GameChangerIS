package cn.gamechanger.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Amministratore;
import cn.gamechanger.model.dao.AmministratoreDao;

/**
 * Servlet implementation class ModificaAdminServlet
 */
@WebServlet("/modifica-admin")
public class ModificaAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ModificaAdminServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String categoria = (String) request.getParameter("valore");
			AmministratoreDao AmministratoreDao = new AmministratoreDao(DbCon.getConnection());
            int id = (int) request.getSession().getAttribute("adminSession");
            Amministratore admin = AmministratoreDao.getAdmin(id);
            
            switch (categoria) {
            case "nomeamm":
            	request.setAttribute("modifica", categoria);
            	request.setAttribute("admin", admin);
                request.getRequestDispatcher("modifica.jsp").forward(request, response);
                break;
            case "password":
            	request.setAttribute("modifica", categoria);
            	request.setAttribute("admin", admin);
                request.getRequestDispatcher("modifica.jsp").forward(request, response);
                break;
            case "immagine":
            	request.setAttribute("modifica", categoria);
            	request.setAttribute("admin", admin);
                request.getRequestDispatcher("modifica.jsp").forward(request, response);
                break;
            case "mail":
            	request.setAttribute("modifica", categoria);
            	request.setAttribute("admin", admin);
                request.getRequestDispatcher("modifica.jsp").forward(request, response);
                break;
            case "numero":
            	request.setAttribute("modifica", categoria);
            	request.setAttribute("admin", admin);
                request.getRequestDispatcher("modifica.jsp").forward(request, response);
                break;
            case "indirizzo":
            	request.setAttribute("modifica", categoria);
            	request.setAttribute("admin", admin);
                request.getRequestDispatcher("modifica.jsp").forward(request, response);
                break;
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	}
	}


