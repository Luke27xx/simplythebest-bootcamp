/**
 * 
 */
package test.com.jds.architecture.service.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jds.apps.beans.ProjectInfo;
import com.jds.architecture.service.dao.DAOException;
import com.jds.architecture.service.dao.ProjectDAO;

public class ProjectDAOTest {
	
	private static ProjectDAO dao;
	
	//private static final String PROPFILE_NAME =  "mysql.properties";
	//private static final String PROPFILE_NAME =  "oracle.properties";
	
	@BeforeClass
	public static void onlyOnce() {
				
		String dbDriver = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String dbUser = "hruser";
		String dbPassword = "hruser";		
		dao = new ProjectDAO(dbDriver, dbUrl, dbUser, dbPassword);
	}

	
	@Before
	public void setUp() throws DAOException {
		dao.reconnect();
	}
	
	
	/**
	 * Deletes everything
	 * @throws DAOException 
	 * @throws DAOException 
	 */
	@After
	public void tearDown() throws SQLException, DAOException {
		dao.reconnect();
		Connection conn = dao.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("DELETE FROM project");		
		stmt.close();
		conn.close();		
	}

	@Test
	public void testCreate() throws DAOException {
		Connection conn = dao.getConnection();
		ProjectInfo item1 = new ProjectInfo();
		item1.setProjectId("1");
		item1.setProjectName("testproject");
		item1.setClient("testclient");
		item1.setDescription("testdescription");
		java.sql.Date date = new java.sql.Date(511651651);
		item1.setStartDate(date);
		item1.setEndDate(date);
		dao.create(conn, item1);
				
	}
	
	@Test
	public void testfindbyPK() throws DAOException {
		ProjectInfo item1 = new ProjectInfo();
		item1.setProjectId("1");
		dao.findByPK(item1);
				
	}
	
	
}
