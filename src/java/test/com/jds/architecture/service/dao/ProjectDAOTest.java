
package test.com.jds.architecture.service.dao;

import static org.junit.Assert.*;

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
//import com.mysql.jdbc.ResultSet;

/**
 * 
 * @author Vytautas Streimikis
 */

public class ProjectDAOTest {
	
	private DataAccessObjectInterface dao;
	private static Connector conn;
	//private ProjectInfo project; 
	
	public ProjectInfo createObject(String cnt){
		ProjectInfo item1 = new ProjectInfo();
		item1.setProjectId(cnt);
		item1.setProjectName("testproject"+cnt);
		item1.setClient("testclient"+cnt);
		item1.setDescription("testdescription"+cnt);
		Calendar car = Calendar.getInstance();
		car.set(2006,9,Integer.parseInt(cnt));
		java.sql.Date date = new java.sql.Date(car.getTimeInMillis());
		item1.setStartDate(date);
		car.set(2006,10,Integer.parseInt(cnt));
		date = new java.sql.Date(car.getTimeInMillis());
		item1.setEndDate(date);
		return item1;
		
	}
	
	
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
	
	
	@After
	public void tearDown() throws SQLException, DAOException {
		conn.reconnect();
		conn.clearAll();
		conn.close();	
	}

	@Test
	public void testCreate() throws DAOException, SQLException {
		
		ProjectInfo item1 = createObject("1");
		dao.create(conn.getConnection(), item1);
		Statement sql_stmt = conn.getConnection().createStatement();
		java.sql.ResultSet rset = sql_stmt.executeQuery("SELECT id from project");
		rset.next();
		assertEquals("1", rset.getString("id"));
		rset.close(); 
		sql_stmt.close();
				
	}
	
	@Test
	public void testfindbyPK() throws DAOException, SQLException {
		
		ProjectInfo item1 = createObject("1");
		conn.createProject(1);
		ProjectInfo item2= (ProjectInfo)dao.findByPK("1");
		assertEquals(item1.getProjectId(), item2.getProjectId());
		
					
	}
	
	@Test
	public void testfind() throws DAOException, SQLException {
		
		ProjectInfo item1 = createObject("1");
		conn.createProject(1);
		RowSet rs = dao.find(item1);
		int  i=0;
		while (rs.next()){i++;}
		assertEquals(1, i);
				
	}
	
	@Test
	public void testupdate() throws DAOException, SQLException {
		
		ProjectInfo item1 = createObject("1");
		ProjectInfo item2 = createObject("2");
		conn.createProject(1);
		dao.update(conn.getConnection(),item2,item1);
		conn.reconnect();
		Statement sql_stmt = conn.getConnection().createStatement();
		java.sql.ResultSet rset = sql_stmt.executeQuery("SELECT id from project");
		rset.next();
		assertEquals("2", rset.getString("id"));
		rset.close(); 
		sql_stmt.close();
				
	}
	
	@Test
	public void testremove() throws DAOException, SQLException {
		
		conn.createProject(1);
		dao.remove(conn.getConnection(),"1");
		conn.reconnect();
		Statement sql_stmt = conn.getConnection().createStatement();
		java.sql.ResultSet rset = sql_stmt.executeQuery("SELECT id from project");
		if (rset.next()) fail("failed");
		rset.close(); 
		sql_stmt.close();
				
	}
	
	@Test
	public void findbyall() throws DAOException, SQLException {
		
		conn.createProject(2);
		RowSet rs = dao.findByAll();
		int  i=0;
		while (rs.next()){i++;}
		assertEquals(2, i);
				
	}
}

/**
 * 
 * Connection class
 *
 */

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
    
	public void clearAll() {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM project");
			stmt.close();
		} catch (Exception ex) {
		}
	}
	
	public void createProject(int cnt) {
		try {
			Statement stmt = conn.createStatement();
			for (int i=0; i<cnt; i++)
			stmt.executeUpdate("INSERT INTO project (id, name, description," +
		    " startdate, enddate, clientname)" +
		    " VALUES ( "+ (i+1) +" , 'testproject"+(i+1)+"' , 'testdescription"+(i+1)+"' ,  to_date('2006-10-0"+(i+1)+"','YYYY-MM-DD'), " +
		    " to_date('2006-11-0"+(i+1)+"','YYYY-MM-DD') , 'testclient"+(i+1)+"' )");
			stmt.close();
		} catch (Exception ex) {
		}
	}
	
	

		
}

