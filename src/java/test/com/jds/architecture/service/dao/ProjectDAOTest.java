/**
 * 
 */
package test.com.jds.architecture.service.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.RowSet;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jds.apps.beans.ProjectInfo;
import com.jds.architecture.service.dao.DAOConstants;
import com.jds.architecture.service.dao.DAOException;
import com.jds.architecture.service.dao.DAOFactory;
import com.jds.architecture.service.dao.DataAccessObjectInterface;
import com.jds.architecture.service.dao.EmpAccentureDetailsDAO;
import com.jds.architecture.service.dao.ProjectDAO;

public class ProjectDAOTest {
	
	private DataAccessObjectInterface dao;
	private static Connector conn;
	
	@BeforeClass
	public static void onlyOnce() {
		conn = new Connector("oracle.jdbc.driver.OracleDriver",
				"jdbc:oracle:thin:@localhost:1521:XE", "hruser", "hruser");		
		
	}

	
	@Before
	public void setUp() throws DAOException {
		try {
			dao = (ProjectDAO) DAOFactory.getFactory()
					.getDAOInstance(DAOConstants.DAO_PROJ);

		} catch (Exception x) {
			System.err.println("error1: " + x.getMessage());
		}

		conn.reconnect();
	}
	
	
	/**
	 * Deletes everything
	 * @throws DAOException 
	 * @throws DAOException 
	 */
	@After
	public void tearDown() throws SQLException, DAOException {
		conn.reconnect();
		conn.close();	
	}

	@Test
	public void testCreate() throws DAOException {
		
		ProjectInfo item1 = new ProjectInfo();
		item1.setProjectId("1");
		item1.setProjectName("testproject");
		item1.setClient("testclient");
		item1.setDescription("testdescription");
		
		java.sql.Date date = new java.sql.Date(1000L*60*60*24);
		item1.setStartDate(date);
		item1.setEndDate(date);
		dao.create(conn.getConnection(), item1);
				
	}
	
	@Test
	public void testfindbyPK() throws DAOException {
		dao.findByPK("1");
				
	}
	
	@Test
	public void testfind() throws DAOException, SQLException {
		
		ProjectInfo item1 = new ProjectInfo();
		item1.setProjectId("1");
		item1.setProjectName("testproject");
		item1.setClient("testclient");
		item1.setDescription("testdescription");
		
		item1.setStartDate(null);
		item1.setEndDate(null);
		RowSet rs = dao.find(item1);
		int  i=0;
		while (rs.next())
		{
			i++;
		}
		assertEquals(1, i);
				
	}
	
	@Test
	public void testupdate() throws DAOException {
		ProjectInfo item1 = new ProjectInfo();
		item1.setProjectName("testproject1");
		item1.setClient("testclient1");
		item1.setDescription("testdescription1");
		
		ProjectInfo item2 = new ProjectInfo();
		item2.setProjectId("1");
		
		dao.update(conn.getConnection(),item1,item2);
				
	}
	
	@Test
	public void testremove() throws DAOException {
		dao.remove(conn.getConnection(),"1");
				
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

