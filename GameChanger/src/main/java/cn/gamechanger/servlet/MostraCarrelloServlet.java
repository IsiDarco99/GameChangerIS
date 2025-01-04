package cn.gamechanger.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.gamechanger.bean.Carrello;
import cn.gamechanger.connection.DbCon;
import cn.gamechanger.dao.CarrelloDao;

@WebServlet("/mostra-carrello")
public class MostraCarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MostraCarrelloServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("userSession");
		try {
			CarrelloDao cd = new CarrelloDao(DbCon.getConnection());
			List<Carrello> prodotti = cd.getCarrelloByUsername(username);
			String redirectURL = "/carrello.jsp";
            request.setAttribute("prodotti", prodotti);
            request.getRequestDispatcher(redirectURL).forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
