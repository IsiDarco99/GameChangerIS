package cn.gamechanger.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Prodotto;
import cn.gamechanger.model.User;
import cn.gamechanger.model.dao.*;

@WebServlet("/elimina-servlet")
public class EliminaProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EliminaProdottoServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codice = request.getParameter("codice");
		Boolean b = false;
		
		ProdottoDao pDao;
		try {
			pDao = new ProdottoDao(DbCon.getConnection());
			b = pDao.deleteProdotto(codice);
			
			if (b) {
				response.sendRedirect("uploadImmagini.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
