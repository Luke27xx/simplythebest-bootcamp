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

public class SkillCategoryDAOTest {

	//private DataAccessObjectInterface catDao = null;
	private static SkillCategoryDAO cat;
	//private static Connector conn;
	private static Connection con;
	
	static String dbDriver;
	static String dbUrl;
	static String dbUser;
	static String dbPassword;

	@BeforeClass
	public static void onlyOnce() {
		dbDriver = "oracle.jdbc.driver.OracleDriver";
		dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		dbUser = "hruser";
		dbPassword = "hruser";
		
		try
		{
			cat = new SkillCategoryDAO(dbDriver, dbUrl, dbUser, dbPassword);
		}
		catch (Exception e)
		{
			
		}
		

		//conn = new Connector("oracle.jdbc.driver.OracleDriver",
				//"jdbc:oracle:thin:@localhost:1521:XE", "hruser", "hruser");
	}

	@Before
	public void setUp() throws DAOException {
		
		cat.reconnect();
		con = cat.getConnection();
	}

	@After
	public void tearDown() throws SQLException, DAOException {
		cat.reconnect();
		Connection conn = cat.getConnection();
		Statement stmt = conn.createStatement();
		stmt.close();
		conn.close();

	}

	@Test
	public void create() throws DAOException, SQLException {
		
		SkillCategory skill = new SkillCategory();
		skill.setCategoryId("2");
		skill.setCategoryName("name2");
		skill.setCategoryDescription("description2");
	
		try
		{
			cat.create(con, skill);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			fail(ex.toString());
		}

	}
	
	@Test
	public void createNullObject() throws DAOException, SQLException {
		
		SkillCategory skill = new SkillCategory();
		skill.setCategoryId("2");
		skill.setCategoryName("name2");
		skill.setCategoryDescription("description2");
	
		try
		{
			cat.create(con, null);
		}
		catch (DAOException e)
		{
			return;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			fail(ex.toString());
		}

	}
	
	@Test
	public void createNullConn() throws DAOException, SQLException {
		
		SkillCategory skill = new SkillCategory();
		skill.setCategoryId("2");
		skill.setCategoryName("name2");
		skill.setCategoryDescription("description2");
	
		try
		{
			cat.create(null, skill);
		}
		catch (DAOException e)
		{
			return;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			fail(ex.toString());
		}

	}
	
	@Test
	public void createNullObjectNullCon() throws DAOException, SQLException {
		
		SkillCategory skill = new SkillCategory();
		skill.setCategoryId("2");
		skill.setCategoryName("name2");
		skill.setCategoryDescription("description2");
	
		try
		{
			cat.create(null, null);
		}
		catch (DAOException e)
		{
			return;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			fail(ex.toString());
		}

	}

	@Test
	public void find() throws DAOException, SQLException {
		
		SkillCategory obj = new SkillCategory();
		RowSet rs;

		obj.setCategoryId("2");
		obj.setCategoryName("name2");
		obj.setCategoryDescription("description2");

		try {
			cat.find(obj);
			
		} catch (Exception ex) {
			fail(ex.toString());
		}

		try {
			rs = cat.find(obj);
			if (rs.next())
			{
				assertEquals("description2", rs.getString("description"));
			}
			else
			{
				fail("err: find");
			}
			
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
		}
	
	/**
	 * Tests object, which is not in the table.
	 * @throws DAOException
	 * @throws SQLException
	 */
	@Test 
	public void find1() throws DAOException, SQLException {
		
		SkillCategory obj = new SkillCategory();
		RowSet rs;

		obj.setCategoryId("000");
		//obj.setCategoryName("name1");
		//obj.setCategoryDescription("desc1");
		
		try {
			rs = cat.find(obj);
			if (rs.next())
			{
				fail("1");
			}
			else
			{
			return;
			}
			
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
}
		
	
	@Test
	public void findByAll() throws DAOException, SQLException {
		//create();
		//RowSet rs = cat.findByAll();
		//int i = 0;
		//while (rs.next()) {
		//	i++;
		//}
		//assertEquals(1, i);
		try {
			cat.findByAll();
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
		
	}

	@Test
	public void findByPK() throws Exception {

		SkillCategory obj;
		
		try {
			
			obj = (SkillCategory) cat.findByPK("125");
			
		} catch (Exception x) {
		x.printStackTrace();
		fail(x.toString());
		}
	}
	
	@Test
	public void findByPKNullId() throws Exception {

		SkillCategory obj;
		
		try {
			
			obj = (SkillCategory) cat.findByPK("000");
			
		} catch (Exception x) {
		x.printStackTrace();
		fail(x.toString());
		}
	}

	@Test
	public void remove() throws DAOException {
		try
		{
			cat.remove(con, "2");
		}
		
		catch (Exception e)
		{
			fail(e.toString());
		}
	}
	
	@Test
	public void removeNullObj() throws DAOException {
		try
		{
			cat.remove(con, null);
		}
		catch (DAOException e)
		{
			return;
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}
		
	@Test
	public void removeNullCon() throws DAOException {
		try
		{
			cat.remove(null, "2");
		}
		catch (DAOException e)
		{
			return;
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}	

	@Test
	public void removeNullObjNullCon() throws DAOException {
		try
		{
			cat.remove(null, null);
		}
		catch (DAOException e)
		{
			return;
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}	
	
	@Test
	public void update() throws DAOException {
		SkillCategory skill = new SkillCategory();
		skill.setCategoryId("2");
		//skill.setCategoryName("name2");
		//skill.setCategoryDescription("description2");

		SkillCategory skill1 = new SkillCategory();
		//skill1.setCategoryId("2");
		skill1.setCategoryName("name1");
		skill1.setCategoryDescription("desc1");

		try{ 
		
		if (cat.update(con, skill, skill1)) {
			
			}
		}
		
		catch (Exception e){
			fail(e.toString());
		}
		
	}

}

class Connector {
	protected String dbDriver;
	protected String dbUrl;
	protected String dbUser;
	protected String dbPassword;
	protected Connection conn;

	

	public void clearAll() {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE");
			stmt.close();
		} catch (Exception ex) {
		}

	}
	
	public void setDbDriver(String dbDriver) {
		//this.dbDriver = dbDriver;
	}

	public void setDbPassword(String dbPassword) {
		//this.dbPassword = dbPassword;
	}

	public void setDbUrl(String dbUrl) {
		//this.dbUrl = dbUrl;
	}

	public void setDbUser(String dbUser) {
		//this.dbUser = dbUser;
	}
}
