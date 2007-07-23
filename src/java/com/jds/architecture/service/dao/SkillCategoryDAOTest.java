package com.jds.architecture.service.dao;

/**
 * @authors Liga Jeca & Gita Balode
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import com.jds.apps.beans.SkillCategory;

public class SkillCategoryDAOTest{

	private DataAccessObjectInterface catDao = null;
	private static SkillCategoryDAO cat;
	private static Connector conn;
	
	@BeforeClass
	public static void onlyOnce() {
				
		conn = new Connector("oracle.jdbc.driver.OracleDriver",
				"jdbc:oracle:thin:@localhost:1521:XE", "hruser", "hruser");		
	}
	
	@Before
	public void setUp() throws DAOException {
		try {
			cat = (SkillCategoryDAO) DAOFactory.getFactory()
			.getDAOInstance(DAOConstants.DAO_SKILLCAT);

		} 
		catch (Exception x) {
	    System.err.println("error1: " + x.getMessage());
		}

		conn.reconnect();
}
	
	
	@After
	public void tearDown() throws SQLException, DAOException {
		conn.reconnect();	
		Connection conn = cat.getConnection();
		Statement stmt = conn.createStatement();
		stmt.close();
		((Connector) conn).clearAll();
		conn.close();	
		
	}
	
	
	@Test
	public void create() throws DAOException, SQLException {
		Connection conn = cat.getConnection();
		SkillCategory skill = new SkillCategory();
		skill.setCategoryId("1");
		skill.setCategoryName("name");
		skill.setCategoryDescription("description");
		cat.create(((Statement) conn).getConnection(), skill);
		
		Statement sql_stmt = ((Statement) conn).getConnection().createStatement();
		java.sql.ResultSet rset = sql_stmt.executeQuery("SELECT id");
		rset.next();
		assertEquals("1", rset.getString("id"));
		rset.close(); 
		sql_stmt.close();
		
		if (skill == null){
			throw new DAOException ("invalid.object.catdao", null);
			}
		
		}
	
	@Test
	public void find() throws DAOException, SQLException{
		create();

		SkillCategory obj = new SkillCategory();

		obj.setCategoryId("2");
		obj.setCategoryName("name1");
		obj.setCategoryDescription("desc1");
		

		try {
			assertEquals("1", 2);
			assertEquals("name", "name1" );
			assertEquals("desc", "desc1");

			return;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("everything is wrong");
			fail("wrong!");
		}

		fail("exception..");
	}
	
	

	@Test 
	public void findByAll() throws DAOException, SQLException {
		create();
		RowSet rs = cat.findByAll();
		int  i=0;
		while (rs.next()){i++;}
		assertEquals(1, i);
			
	}
	
	@Test
	public void findByPK() throws Exception {
		
			create();
		
		try {
			Object findPK = "1";
			Object obj = catDao.findByPK(findPK);

			if (obj == null)
				fail("findByPK returned null");

			assertEquals(((SkillCategory) obj).getCategoryName(),
					"name");

			return;
		} catch (Exception x) {
			System.err.println("error12: " + x.getMessage());
			x.printStackTrace();
		}
		fail("exception in findByPK");
		
	}
	
	

	@Test
	public void remove() throws DAOException {
		SkillCategory skill = new SkillCategory();
		skill.setCategoryId("1");
		skill.setCategoryName("name");
		skill.setCategoryDescription("description");
		cat.remove(conn.getConnection(),"1");
		
	}
	
	@Test
	public void update() throws DAOException {
		SkillCategory skill = new SkillCategory();
		skill.setCategoryId("id1");
		skill.setCategoryName("name1");
		skill.setCategoryDescription("desc1");
		
		SkillCategory skill1 = new SkillCategory();
		skill1.setCategoryId("1");
		
		cat.update(conn.getConnection(),skill,skill1);
		}
	
	
}

class Connector {
	protected String dbDriver;
	protected String dbUrl;
	protected String dbUser;
	protected String dbPassword;
	protected Connection conn;

	public void reconnect() {
		try {
			if (conn == null || conn.isClosed()) {
				Class.forName(dbDriver);
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			}
		} catch (Exception e) {
			System.err.println("error2: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("Could not initialize UrlDAO", e);
		}

	}

	public void clearAll() {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE");
			stmt.close();
		} catch (Exception ex) {
		}
		
	}

	public Connector(String dbDriver, String dbUrl, String dbUser,
			String dbPassword) {
		this.dbDriver = dbDriver;
		this.dbUrl = dbUrl;
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
	}

	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException("Could not close connection", e);
			}
			conn = null;
		}
	}

	public Connection getConnection() {
		return conn;
	}

	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
}

