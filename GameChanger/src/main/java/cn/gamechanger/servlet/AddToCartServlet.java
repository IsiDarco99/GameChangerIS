package cn.gamechanger.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.gamechanger.model.*;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/aggiungi-prodotto")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			ArrayList<Carrello> listaCarrello = new ArrayList<>();
			
			Carrello cm = new Carrello();
			cm.setQuantitàProdotto(1);
			
			HttpSession session = request.getSession();
			ArrayList<Carrello> lista_carrello = (ArrayList<Carrello>) session.getAttribute("lista-carrello");
			
			if(lista_carrello == null) {
				listaCarrello.add(cm);
				session.setAttribute("lista-carrello", listaCarrello);
				out.println("session created and added to the list");
			}
		}
		
	}

}
