package cn.gamechanger.servlet;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import cn.gamechanger.bean.User;
import cn.gamechanger.connection.DbCon;
import cn.gamechanger.dao.UserDao;
import cn.gamechanger.servlet.RegistraProfiloServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;

public class RegistraProfiloServletTest {

	private RegistraProfiloServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter responseWriter;

    @Before
    public void setUp() throws Exception {
        // Creiamo un'istanza della servlet da testare
        servlet = new RegistraProfiloServlet();

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
    public void TC_REG_1() throws Exception {	
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("nuovousername")).thenReturn("testuser");
        when(request.getParameter("emailPers")).thenReturn("FormatoMailSbagliato");
        when(request.getParameter("password")).thenReturn("Password123");
        when(request.getParameter("ripetipassword")).thenReturn("Password123");
        when(request.getParameter("nome")).thenReturn("Mario");
        when(request.getParameter("cognome")).thenReturn("Rossi");
        when(request.getParameter("datanascita")).thenReturn("1990-01-01");
        when(request.getParameter("privacy")).thenReturn("on");
        when(request.getParameter("terms")).thenReturn("on"); 

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Formato email non valido."));

        verify(response, never()).sendRedirect("login.jsp");
    }
    
    @Test
    public void TC_REG_2() throws Exception {
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("nuovousername")).thenReturn("testuser");
        when(request.getParameter("emailPers")).thenReturn("testuser@example.com");
        when(request.getParameter("password")).thenReturn("pcorta");
        when(request.getParameter("ripetipassword")).thenReturn("pcorta");
        when(request.getParameter("nome")).thenReturn("Mario");
        when(request.getParameter("cognome")).thenReturn("Rossi");
        when(request.getParameter("datanascita")).thenReturn("1990-01-01");
        when(request.getParameter("privacy")).thenReturn("on");
        when(request.getParameter("terms")).thenReturn("on"); 

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("La password deve contenere almeno 8 caratteri."));

        verify(response, never()).sendRedirect("login.jsp");
    }
    
    @Test
    public void TC_REG_3() throws Exception {
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("nuovousername")).thenReturn("testuser");
        when(request.getParameter("emailPers")).thenReturn("testuser@example.com");
        when(request.getParameter("password")).thenReturn("password&%$/");
        when(request.getParameter("ripetipassword")).thenReturn("password&%$/");
        when(request.getParameter("nome")).thenReturn("Mario");
        when(request.getParameter("cognome")).thenReturn("Rossi");
        when(request.getParameter("datanascita")).thenReturn("1990-01-01");
        when(request.getParameter("privacy")).thenReturn("on");
        when(request.getParameter("terms")).thenReturn("on"); 

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Sono consentiti solo caratteri alfanumerici."));

        verify(response, never()).sendRedirect("login.jsp");
    }
    
    @Test
    public void TC_REG_4() throws Exception {
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("nuovousername")).thenReturn("testuser");
        when(request.getParameter("emailPers")).thenReturn("testuser@example.com");
        when(request.getParameter("password")).thenReturn("Password123");
        when(request.getParameter("ripetipassword")).thenReturn("Password124");
        when(request.getParameter("nome")).thenReturn("Mario");
        when(request.getParameter("cognome")).thenReturn("Rossi");
        when(request.getParameter("datanascita")).thenReturn("1990-01-01");
        when(request.getParameter("privacy")).thenReturn("on");
        when(request.getParameter("terms")).thenReturn("on"); 

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Le password non corrispondono."));

        verify(response, never()).sendRedirect("login.jsp");
    }
    
    @Test
    public void TC_REG_5() throws Exception {
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("nuovousername")).thenReturn("testUserMaggioreDi25Caratteri");
        when(request.getParameter("emailPers")).thenReturn("testuser@example.com");
        when(request.getParameter("password")).thenReturn("Password123");
        when(request.getParameter("ripetipassword")).thenReturn("Password123");
        when(request.getParameter("nome")).thenReturn("Mario");
        when(request.getParameter("cognome")).thenReturn("Rossi");
        when(request.getParameter("datanascita")).thenReturn("1990-01-01");
        when(request.getParameter("privacy")).thenReturn("on");
        when(request.getParameter("terms")).thenReturn("on"); 

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Inserire un massimo di 22 caratteri."));

        verify(response, never()).sendRedirect("login.jsp");
    }
    
    @Test
    public void TC_REG_6() throws Exception {
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("nuovousername")).thenReturn("testuser&%$/");
        when(request.getParameter("emailPers")).thenReturn("testuser@example.com");
        when(request.getParameter("password")).thenReturn("Password123");
        when(request.getParameter("ripetipassword")).thenReturn("Password123");
        when(request.getParameter("nome")).thenReturn("Mario");
        when(request.getParameter("cognome")).thenReturn("Rossi");
        when(request.getParameter("datanascita")).thenReturn("1990-01-01");
        when(request.getParameter("privacy")).thenReturn("on");
        when(request.getParameter("terms")).thenReturn("on"); 

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Sono consentiti solo caratteri alfanumerici."));

        verify(response, never()).sendRedirect("login.jsp");
    }
    
    @Test
    public void TC_REG_7() throws Exception {
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
    	Connection con = DbCon.getConnection();
		UserDao dao = new UserDao(con);
    	User user = new User();
		user.setUsername("testUserEsistente");
		user.setEmailPers("test.user@example.com");
		user.setPassword("passwordTest123");
		user.setNome("Mario");
		user.setCognome("Rossi");
		user.setDataNascita("1990-05-15");
		dao.registerUser(user);
        
        when(request.getParameter("nuovousername")).thenReturn("testUserEsistente");
        when(request.getParameter("emailPers")).thenReturn("testuser@example.com");
        when(request.getParameter("password")).thenReturn("Password123");
        when(request.getParameter("ripetipassword")).thenReturn("Password123");
        when(request.getParameter("nome")).thenReturn("Mario");
        when(request.getParameter("cognome")).thenReturn("Rossi");
        when(request.getParameter("datanascita")).thenReturn("1990-01-01");
        when(request.getParameter("privacy")).thenReturn("on");
        when(request.getParameter("terms")).thenReturn("on"); 

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Username presente nel database."));

        verify(response, never()).sendRedirect("login.jsp");
    }
    
    @Test
    public void TC_REG_8() throws Exception {
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("nuovousername")).thenReturn("testuser");
        when(request.getParameter("emailPers")).thenReturn("testuser@example.com");
        when(request.getParameter("password")).thenReturn("Password123");
        when(request.getParameter("ripetipassword")).thenReturn("Password123");
        when(request.getParameter("nome")).thenReturn("MarioNomeTroppoLungoTestExample");
        when(request.getParameter("cognome")).thenReturn("Rossi");
        when(request.getParameter("datanascita")).thenReturn("1990-01-01");
        when(request.getParameter("privacy")).thenReturn("on");
        when(request.getParameter("terms")).thenReturn("on"); 

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Il nome deve contenere al massimo 30 caratteri."));

        verify(response, never()).sendRedirect("login.jsp");
    }
    
    @Test
    public void TC_REG_9() throws Exception {
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("nuovousername")).thenReturn("testuser");
        when(request.getParameter("emailPers")).thenReturn("testuser@example.com");
        when(request.getParameter("password")).thenReturn("Password123");
        when(request.getParameter("ripetipassword")).thenReturn("Password123");
        when(request.getParameter("nome")).thenReturn("Mario&%$/");
        when(request.getParameter("cognome")).thenReturn("Rossi");
        when(request.getParameter("datanascita")).thenReturn("1990-01-01");
        when(request.getParameter("privacy")).thenReturn("on");
        when(request.getParameter("terms")).thenReturn("on"); 

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Il nome può contenere solo caratteri da A-Z e caratteri accentati."));

        verify(response, never()).sendRedirect("login.jsp");
    }
    
    @Test
    public void TC_REG_10() throws Exception {
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("nuovousername")).thenReturn("testuser");
        when(request.getParameter("emailPers")).thenReturn("testuser@example.com");
        when(request.getParameter("password")).thenReturn("Password123");
        when(request.getParameter("ripetipassword")).thenReturn("Password123");
        when(request.getParameter("nome")).thenReturn("Mario");
        when(request.getParameter("cognome")).thenReturn("RossiCognomeTroppoLungoTestExample");
        when(request.getParameter("datanascita")).thenReturn("1990-01-01");
        when(request.getParameter("privacy")).thenReturn("on");
        when(request.getParameter("terms")).thenReturn("on"); 

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Il cognome deve contenere al massimo 30 caratteri."));

        verify(response, never()).sendRedirect("login.jsp");
    }
    
    @Test
    public void TC_REG_11() throws Exception {
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("nuovousername")).thenReturn("testuser");
        when(request.getParameter("emailPers")).thenReturn("testuser@example.com");
        when(request.getParameter("password")).thenReturn("Password123");
        when(request.getParameter("ripetipassword")).thenReturn("Password123");
        when(request.getParameter("nome")).thenReturn("Mario");
        when(request.getParameter("cognome")).thenReturn("Rossi&%$/");
        when(request.getParameter("datanascita")).thenReturn("1990-01-01");
        when(request.getParameter("privacy")).thenReturn("on");
        when(request.getParameter("terms")).thenReturn("on"); 

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Il cognome può contenere solo caratteri da A-Z e caratteri accentati."));

        verify(response, never()).sendRedirect("login.jsp");
    }
    
    @Test
    public void TC_REG_12() throws Exception {
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("nuovousername")).thenReturn("testuser");
        when(request.getParameter("emailPers")).thenReturn("testuser@example.com");
        when(request.getParameter("password")).thenReturn("Password123");
        when(request.getParameter("ripetipassword")).thenReturn("Password123");
        when(request.getParameter("nome")).thenReturn("Mario");
        when(request.getParameter("cognome")).thenReturn("Rossi");
        when(request.getParameter("datanascita")).thenReturn("01-01-1999");
        when(request.getParameter("privacy")).thenReturn("on");
        when(request.getParameter("terms")).thenReturn("on"); 

        servlet.doPost(request, response);
        
        assertTrue(stringWriter.toString().contains("Inserisci una data di nascita nel formato corretto (YYYY-MM-DD)."));

        verify(response, never()).sendRedirect("login.jsp");
    }
    
    @Test
    public void TC_REG_13() throws Exception {
    	StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        when(request.getParameter("nuovousername")).thenReturn("testuser");
        when(request.getParameter("emailPers")).thenReturn("testuser@example.com");
        when(request.getParameter("password")).thenReturn("Password123");
        when(request.getParameter("ripetipassword")).thenReturn("Password123");
        when(request.getParameter("nome")).thenReturn("Mario");
        when(request.getParameter("cognome")).thenReturn("Rossi");
        when(request.getParameter("datanascita")).thenReturn("1999-01-01");
        when(request.getParameter("privacy")).thenReturn(null);
        when(request.getParameter("terms")).thenReturn(null); 

        servlet.doPost(request, response);
        assertTrue(stringWriter.toString().contains("Devi accettare la privacy e i termini e condizioni per registrarti."));

        verify(response, never()).sendRedirect("login.jsp");
    }
    
    @Test
    public void TC_REG_14() throws Exception {        
        when(request.getParameter("nuovousername")).thenReturn("testuser");
        when(request.getParameter("emailPers")).thenReturn("testuser@example.com");
        when(request.getParameter("password")).thenReturn("Password123");
        when(request.getParameter("ripetipassword")).thenReturn("Password123");
        when(request.getParameter("nome")).thenReturn("Mario");
        when(request.getParameter("cognome")).thenReturn("Rossi");
        when(request.getParameter("datanascita")).thenReturn("1999-01-01");
        when(request.getParameter("privacy")).thenReturn("on");
        when(request.getParameter("terms")).thenReturn("on"); 

        servlet.doPost(request, response);

        verify(response).sendRedirect("login.jsp");
    }



}
