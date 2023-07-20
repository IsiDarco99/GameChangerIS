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


@WebServlet("/Modifica-Admin")
public class ModificaDatiAmministratoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ModificaDatiAmministratoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cap = 0;
		Integer idAdmin = (Integer) request.getSession().getAttribute("idAdmin");
		String username = (String) request.getSession().getAttribute("userSession");
		String nuovousername = (String) request.getParameter("nuovousername");
		String nuovoNome = (String) request.getParameter("nuovonome");
        String nuovoCognome = (String) request.getParameter("nuovocognome");
		String nuovapassword = (String) request.getParameter("nuovapassword");
		String mail = (String) request.getParameter("emailpers");
		
		
		AmministratoreDao adminDao = null;
		try {
			if (nuovapassword != null) {
				adminDao = new AmministratoreDao(DbCon.getConnection());
				Amministratore admin = adminDao.getAdmin(idAdmin);
				adminDao.updatePassword(idAdmin, nuovapassword);
	            request.setAttribute("admin", admin);
				request.getRequestDispatcher("paginaamministratore.jsp").forward(request, response);
			} 
			   else if (mail != null) {
				userDao = new UserDao(DbCon.getConnection());
				userDao.updateEmail(username, mail);;
				User user = userDao.getUserProfile(username);
	            request.setAttribute("user", user);
				request.getRequestDispatcher("profilo.jsp").forward(request, response);
				
			} else if (nuovoNome != null) {
				adminDao = new AmministratoreDao(DbCon.getConnection());
				nuovoNome = Character.toUpperCase(nuovoNome.charAt(0)) + nuovoNome.substring(1);
			    nuovoCognome = Character.toUpperCase(nuovoCognome.charAt(0)) + nuovoCognome.substring(1);
			    adminDao.updateNome(idAdmin, nuovoNome);
			    adminDao.updateCognome(idAdmin, nuovoCognome);
				Amministratore admin = adminDao.getAdmin(idAdmin);
	            request.setAttribute("admin", admin);
				request.getRequestDispatcher("paginaaministratore.jsp").forward(request, response);
			}  else if (codFisc != null) {
                userDao = new UserDao(DbCon.getConnection());
                userDao.updateCodiceFiscale(username, codFisc);
                User user = userDao.getUserProfile(username);
                request.setAttribute("user", user);
                request.getRequestDispatcher("profilo.jsp").forward(request, response);
			}   else if (request.getParameter("nuovadata") != null) {
                userDao = new UserDao(DbCon.getConnection());
                String nuovaDataNascita = request.getParameter("nuovadata");
                userDao.updateDataNascita(username, nuovaDataNascita);
                User user = userDao.getUserProfile(username);
                request.setAttribute("user", user);
                request.getRequestDispatcher("profilo.jsp").forward(request, response);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

	}

}
