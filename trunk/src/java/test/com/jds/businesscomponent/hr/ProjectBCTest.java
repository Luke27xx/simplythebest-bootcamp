package test.com.jds.businesscomponent.hr;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.sql.RowSet;

import org.junit.*;

import com.jds.apps.beans.ProjectInfo;
import com.jds.architecture.exceptions.HRSLogicalException;
import com.jds.architecture.exceptions.HRSSystemException;
import com.jds.architecture.service.dao.DAOConstants;
import com.jds.architecture.service.dao.DAOException;
import com.jds.architecture.service.dao.DAOFactory;
import com.jds.architecture.service.dao.DataAccessObjectInterface;
import com.jds.architecture.service.dao.ProjectDAO;
import com.jds.businesscomponent.hr.ProjectBC;


/**
 * 
 * @author Vytautas Streimikis
 *
 */
public class ProjectBCTest {

	private ProjectBC projBC;
	private static ConnectorBC conn;
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
		conn = new ConnectorBC("oracle.jdbc.driver.OracleDriver",
				"jdbc:oracle:thin:@localhost:1521:XE", "hruser", "hruser");		
			
	
	}

	
	@Before
	public void setUp() throws DAOException, HRSSystemException {
		
		projBC = new ProjectBC();
		conn.reconnect();
	}
	
	
	@After
	public void tearDown() throws SQLException, DAOException {
		conn.reconnect();
		conn.clearAll();
		conn.close();	
	}

	@Test
	public void testCreateProject() throws DAOException, SQLException, HRSSystemException, HRSLogicalException {
		
		ProjectInfo item1 = createObject("1");
		projBC.createProject(item1);
		Statement sql_stmt = conn.getConnection().createStatement();
		java.sql.ResultSet rset = sql_stmt.executeQuery("SELECT name from project");
		rset.next();
		assertEquals("testproject1", rset.getString("name"));
		rset.close(); 
		sql_stmt.close();
				
	}
	
	@Test
	public void testSearchProject() throws DAOException, SQLException, HRSSystemException, HRSLogicalException {
		
		ProjectInfo item1 = createObject("1");
		conn.createProject(1);
		ProjectInfo item2= (ProjectInfo)projBC.searchProject("1");
		assertEquals(item1.getProjectId(), item2.getProjectId());
		
					
	}
	
	@Test
	public void testSearchReferenceData() throws DAOException, SQLException, HRSSystemException, HRSLogicalException {
		
		ProjectInfo item1 = createObject("1");
		conn.createProject(1);
		Collection rs = projBC.searchReferenceData(item1, "approved");
		assertEquals(1, rs.size());
				
	}
	
	@Test
	public void testSearchApprovedProjects() throws DAOException, SQLException, HRSSystemException, HRSLogicalException {
		
		ProjectInfo item1 = createObject("1");
		conn.createProject(1);
		Collection rs = projBC.searchApprovedProjects(item1);
		assertEquals(1, rs.size());
				
	}
	
	@Test
	public void testUpdateProject() throws DAOException, SQLException, HRSLogicalException, HRSSystemException {
		
		ProjectInfo item1 = createObject("2");
		item1.setProjectId("1");
		conn.createProject(1);
		projBC.updateProject(item1);
		conn.reconnect();
		Statement sql_stmt = conn.getConnection().createStatement();
		java.sql.ResultSet rset = sql_stmt.executeQuery("SELECT name from project");
		rset.next();
		assertEquals("testproject2", rset.getString("name"));
		rset.close(); 
		sql_stmt.close();
				
	}
	
	
}

/**
 * 
 * Connection class
 *
 */

class ConnectorBC {
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

	public ConnectorBC(String dbDriver, String dbUrl, String dbUser,
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
