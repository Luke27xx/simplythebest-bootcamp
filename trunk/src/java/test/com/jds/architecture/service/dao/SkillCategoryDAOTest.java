package test.com.jds.architecture.service.dao;

//import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

import com.jds.apps.beans.SkillCategory;
import com.jds.architecture.service.dao.DAOException;
import com.jds.architecture.service.dao.SkillCategoryDAO;

public class SkillCategoryDAOTest extends TestCase{

	private SkillCategoryDAO data[];
	private static SkillCategoryDAO cat;
	
	@BeforeClass
	public static void onlyOnce() {
				
		String dbDriver = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String dbUser = "hruser";
		String dbPassword = "hruser";		
		cat = new SkillCategoryDAO(dbDriver, dbUrl, dbUser, dbPassword);
	}
	
	@Before
	public void setUp() throws DAOException {
		cat.reconnect();
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
		Connection conn = cat.getConnection();
		SkillCategory skill = new SkillCategory();
		skill.setCategoryId("1");
		skill.setCategoryName("name");
		skill.setCategoryDescription("description");
		cat.create(conn, skill);
		
		
		}
	
	@Test
	public void find(){
		
	}
	
	@Test 
	public void findByAll() {
		
	}
	
	@Test
	public void findByPK() {
		
	}
	
	@Test
	public void remove() {
		
	}
	
	@Test
	public void update() {


	}
}
