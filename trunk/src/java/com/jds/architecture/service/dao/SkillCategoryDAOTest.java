package com.jds.architecture.service.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jds.apps.beans.ProjectInfo;
import com.jds.apps.beans.SkillCategory;

public class SkillCategoryDAOTest{

	final boolean SHORT = false;
	final boolean FULL = true;
	private DataAccessObjectInterface ScatDao;
	
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

		} catch (Exception x) {
			System.err.println("error1: " + x.getMessage());
		}

		conn.reconnect();
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
	public void create() throws DAOException {
		//Connection conn = cat.getConnection();
		SkillCategory skill = new SkillCategory();
		skill.setCategoryId("1");
		skill.setCategoryName("name");
		skill.setCategoryDescription("description");
		cat.create(conn.getConnection(), skill);
		
		/*if (skill == null){
			throw new DAOException ("invalid.object.catdao", null);
		}*/
		
		
		}
	
	@Test
	public void find() throws DAOException{
		create();

		SkillCategory obj = new SkillCategory();

		obj.setCategoryId("2");
		obj.setCategoryName("name1");
		obj.setCategoryDescription("desc1");
		

		try {

			RowSet rs = ScatDao.find(obj);

			String test = rsContents(rs, SHORT);
			assertEquals("", test);

			obj = new SkillCategory();

			obj.setCategoryId("2");
			obj.setCategoryName("name1");
			obj.setCategoryDescription("desc1");

			rs = ScatDao.find(obj);

			test = rsContents(rs, SHORT);
			assertEquals("1", test);
			assertEquals("name", test);
			assertEquals("desc", test);

			return;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("something is wrong..");
			fail("wrong!");
		}

		fail("exception..");
	}
	
	private String rsContents(RowSet rs, boolean short2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test 
	public void findByAll() throws DAOException {
		create();

		try {
			RowSet rs = ScatDao.findByAll();

			String test = rsContents(rs, FULL);
			assertEquals("1", test);
			assertEquals("name", test);
			assertEquals("desc", test);

			return;
		} catch (Exception ex) {
		}

		fail("Not good!");
	
	}
	
	@Test
	public void findByPK() throws Exception {
		
			create();
		
		try {
			Object findPK = "1";
			Object obj = ScatDao.findByPK(findPK);

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
		//cat.reconnect();
		//Connection conn = cat.getConnection();
		//cat.remove(conn,"1");
		cat.remove(conn.getConnection(),"1");
	}
	
	@Test
	public void update() throws DAOException {
		SkillCategory skill = new SkillCategory();
		//skill.setCategoryId(id)("id1");
		skill.setCategoryName("name1");
		skill.setCategoryDescription("desc1");
		
		SkillCategory skill1 = new SkillCategory();
		skill1.setCategoryId("1");
		
		cat.update(conn.getConnection(),skill,skill1);
		}
}
