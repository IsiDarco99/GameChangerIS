package cn.gamechanger.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.Carrello;
import cn.gamechanger.model.User;
import cn.gamechanger.model.dao.CarrelloDao;
import cn.gamechanger.model.dao.UserDao;


@WebServlet("/Checkout4-Servlet")
public class Checkout4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
    public void init() throws ServletException {
        super.init();
    }
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String username = (String) request.getSession().getAttribute("userSession");
    	
        	try {
        		
        		CarrelloDao cd = new CarrelloDao(DbCon.getConnection());
    			List<Carrello> prodotti = cd.getCarrelloByUsername(username);
    			  request.setAttribute("prodotti", prodotti);
                
    		
                
                UserDao userDao = new UserDao(DbCon.getConnection());
                User user = userDao.getUserProfile(username);
                request.setAttribute("user", user);
                request.getRequestDispatcher("checkout3.jsp").forward(request, response);
                
        	} catch (Exception e) {
    			e.getStackTrace();
    		}
        }
    }

