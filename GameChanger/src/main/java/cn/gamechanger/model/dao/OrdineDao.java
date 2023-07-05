package cn.gamechanger.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import cn.gamechanger.connection.DbCon;

public class OrdineDao {
	private Connection con;
	private static final Logger logger = Logger.getLogger(DbCon.class.getName());
	public OrdineDao(Connection con) {
		this.con = con;
	}
	
	
}
