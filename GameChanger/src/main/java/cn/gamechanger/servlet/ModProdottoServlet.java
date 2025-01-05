package cn.gamechanger.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.bean.User;
import cn.gamechanger.connection.DbCon;
import cn.gamechanger.dao.ProdottoDao;
import cn.gamechanger.dao.UserDao;

@WebServlet("/modifica-prodotto2")
public class ModProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModProdottoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codiceStr = (String) request.getParameter("codice");
		int codice = Integer.parseInt(codiceStr);
		
		try {
			String nome = (String) request.getParameter("nomeprodotto");
			String marca = (String) request.getParameter("marca");
			String prezzoStr = (String) request.getParameter("prezzo");
			float prezzo = Float.parseFloat(prezzoStr);
			String data = (String) request.getParameter("data");
			String descrizione = (String) request.getParameter("descrizioneprodotto");
			String categoria = (String) request.getParameter("categoria");
			
			System.out.println("Categoria " + categoria);

			ProdottoDao prodottoDao = new ProdottoDao(DbCon.getConnection());
			prodottoDao.updateProdotto(codice, prezzo, nome, marca, descrizione, data, categoria);
			
			request.getRequestDispatcher("prodottoModificato.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}
