package cn.gamechanger.model.dao;

import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.User;

public class CarrelloDao {
	private Connection con;
	private static final Logger logger = Logger.getLogger(DbCon.class.getName());
	
	public CarrelloDao(Connection con) {
		this.con = con;
	}
	
}
