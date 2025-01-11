package cn.gamechanger.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import cn.gamechanger.bean.Amministratore;
import cn.gamechanger.connection.DbCon;

public class AmministratoreDaoTest {

	@Test
	public void adminLoginTest() throws Exception{
		Connection con = DbCon.getConnection();
		AmministratoreDao dao = new AmministratoreDao(con);
		Amministratore admin = dao.adminLogin("amministratore1@example.com", "password1");

		assertNotNull(admin);
	}

	@Test
	public void getAdmin() throws Exception{
		Connection con = DbCon.getConnection();
		AmministratoreDao dao = new AmministratoreDao(con);
		
		Amministratore admin = dao.getAdmin(1);
		assertEquals(1, admin.getIdAmministratore());
	}

}
