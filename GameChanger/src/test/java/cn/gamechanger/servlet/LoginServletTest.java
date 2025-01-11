package cn.gamechanger.servlet;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import cn.gamechanger.bean.User;
import cn.gamechanger.connection.DbCon;
import cn.gamechanger.dao.UserDao;
import cn.gamechanger.servlet.LoginServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;


public class LoginServletTest {

	private LoginServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter responseWriter;

    @Before
    public void setUp() throws Exception {
        // Creiamo un'istanza della servlet da testare
        servlet = new LoginServlet();

        // Mockiamo la request e la response
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);

        // Mockiamo la sessione
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);

        // Mockiamo il RequestDispatcher
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        // Prepariamo un writer per catturare l'output della response
        responseWriter = new StringWriter();
        when(response.getWriter()).thenReturn(new PrintWriter(responseWriter));
    }


    
    @Test
    public void TC_LOG_1() throws Exception {
    	Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
    	User user = new User();
		user.setUsername("testUserLogin");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		dao.registerUser(user);
		
        when(request.getParameter("login-username")).thenReturn("UsernameSbagliato");
        when(request.getParameter("login-password")).thenReturn("passwordTest123");

        servlet.doPost(request, response);

        verify(response, never()).sendRedirect("homepage.jsp");
    }
    
    @Test
    public void TC_LOG_2() throws Exception {
    	Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
    	User user = new User();
		user.setUsername("testUserPassword");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		dao.registerUser(user);
		
        when(request.getParameter("login-username")).thenReturn("testUserPassword");
        when(request.getParameter("login-password")).thenReturn("PasswordSbagliata");

        servlet.doPost(request, response);

        verify(response, never()).sendRedirect("homepage.jsp");
    }
    
    @Test
    public void TC_LOG_3() throws Exception {
    	Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
    	User user = new User();
		user.setUsername("testUserCorretto");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		dao.registerUser(user);
		
        when(request.getParameter("login-username")).thenReturn("testUserCorretto");
        when(request.getParameter("login-password")).thenReturn("passwordTest123");

        servlet.doPost(request, response);

        verify(response).sendRedirect("homepage.jsp");
    }

}
