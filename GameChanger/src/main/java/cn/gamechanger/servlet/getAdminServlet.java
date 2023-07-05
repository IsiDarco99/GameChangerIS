package cn.gamechanger.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Amministratore;
import cn.gamechanger.model.dao.AmministratoreDao;

@WebServlet("/get-admin")
public class getAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getAdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AmministratoreDao adminDao = new AmministratoreDao(DbCon.getConnection());
			int id = (int) request.getSession().getAttribute("adminSession");
			Amministratore admin = adminDao.getAdmin(id);
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("paginaamministratore.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
