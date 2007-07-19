/**
 * 
 */
package com.jds.architecture.service.dao;

import static org.junit.Assert.*;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import javax.sql.RowSet;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jds.apps.beans.AccentureDetails;

/**
 * @author training
 * 
 */
public class EmpAccentureDetailsDAOTest {

	final boolean SHORT = false;
	final boolean FULL = true;

	private DataAccessObjectInterface empAccDao;
	private static Connector connector;

	@BeforeClass
	public static void onlyOnce() {

		connector = new Connector("oracle.jdbc.driver.OracleDriver",
				"jdbc:oracle:thin:@127.0.0.1:1521:XE", "hrsuser", "hrspassword");

	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		try {
			empAccDao = (EmpAccentureDetailsDAO) DAOFactory.getFactory()
					.getDAOInstance(DAOConstants.DAO_EMPACC);

		} catch (Exception x) {
			System.err.println("error1: " + x.getMessage());
		}

		connector.reconnect();
		// preparation for each of the test-cases
		// e.g. fill database with appropriate data
		connector.createEmployees();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		// clean the data that may be left from the tescases.
		connector.reconnect();
		connector.clearAll();
		connector.close();
	}

	/**
	 * Test method for
	 * {@link com.jds.architecture.service.dao.EmpAccentureDetailscon#create(java.sql.Connection, java.lang.Object)}.
	 */
	@Test
	public void testCreate() {
		// create 1 legal employee (with all data correcly filled in)
		// check, if it exists (findAll or similar).
		// execute "assertEquals" to check, if you found the same stuff
		// that was inserted.

		addEmpDetails();

		try {
			RowSet r = empAccDao.findByAll();
			if (r == null)
				fail("findByAll returned null");

			String test = rsContents(r, SHORT);
			assertEquals("@:em000:@:em1:@:em2:", test);

			return;
		} catch (Exception x) {
			System.err.println("error1: " + x.getMessage());
			x.printStackTrace();
		}
		fail("exception..");
	}

	@Test
	public void testCreateUnsuccessful() {
		// try to create an employee with invalid parameters.
		try {

			empAccDao.create(connector.getConnection(), null);

		} catch (DAOException daoex) {
			try {
				AccentureDetails correctObject = new AccentureDetails();

				correctObject.setEmployeeNo("10");
				correctObject.setEnterpriseId("tratata");
				correctObject.setEnterpriseAddress("em000");
				correctObject.setLevel("");
				correctObject.setLMU("LMU");
				correctObject.setStatus("");
				correctObject.setDateHired(new java.sql.Date(2001, 1, 1));
				correctObject.setGMU("GMU");
				correctObject.setWorkGroup("");
				correctObject.setSpecialty("");
				correctObject.setServiceLine("");

				empAccDao.create(null, correctObject);
			} catch (DAOException daoex2) {
				return;
			} catch (Exception ex) {
				fail("exception is wrong2");
			}
		} catch (Exception ex) {
			fail("exception is wrong1");
		}
		fail("wrong behavior!");
	}

	/**
	 * Test method for
	 * {@link com.jds.architecture.service.dao.EmpAccentureDetailscon#remove(java.sql.Connection, java.lang.Object)}.
	 */
	@Test
	public void testRemove() {
		addEmpDetails();

		try {
			RowSet rs = empAccDao.findByAll();

			String test = rsContents(rs, SHORT);
			boolean testResult = test.contains("@:em000:")
					&& test.contains("@:em1:") && test.contains("@:em2:");

			assertEquals(true, testResult);

			empAccDao.remove(connector.getConnection(), "10");

			rs = empAccDao.findByAll();

			test = rsContents(rs, SHORT);
			assertEquals("@:em1:@:em2:", test);

			empAccDao.remove(connector.getConnection(), "1");
			empAccDao.remove(connector.getConnection(), "2");

			rs = empAccDao.findByAll();

			test = rsContents(rs, SHORT);
			assertEquals("", test);

			return;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		fail("exception..");
	}

	public void addEmpDetails() {
		AccentureDetails correctObject = new AccentureDetails();

		try {
			correctObject.setEmployeeNo("1");
			correctObject.setEnterpriseId("tratata");
			correctObject.setEnterpriseAddress("em1");
			correctObject.setLevel("");
			correctObject.setLMU("LMU");
			correctObject.setStatus("");
			correctObject.setDateHired(new java.sql.Date(2001, 1, 1));
			correctObject.setGMU("GMU");
			correctObject.setWorkGroup("");
			correctObject.setSpecialty("");
			correctObject.setServiceLine("");

			empAccDao.create(connector.getConnection(), correctObject);

			correctObject.setEmployeeNo("2");
			correctObject.setEnterpriseId("tratata");
			correctObject.setEnterpriseAddress("em2");
			correctObject.setLevel("");
			correctObject.setLMU("LMU");
			correctObject.setStatus("");
			correctObject.setDateHired(new java.sql.Date(1989, 2, 4));
			correctObject.setGMU("GMU");
			correctObject.setWorkGroup("");
			correctObject.setSpecialty("");
			correctObject.setServiceLine("");

			empAccDao.create(connector.getConnection(), correctObject);

			correctObject.setEmployeeNo("10");
			correctObject.setEnterpriseId("tratata");
			correctObject.setEnterpriseAddress("em000");
			correctObject.setLevel("");
			correctObject.setLMU("LMU");
			correctObject.setStatus("");
			correctObject.setDateHired(new java.sql.Date(2001, 1, 1));
			correctObject.setGMU("GMU");
			correctObject.setWorkGroup("");
			correctObject.setSpecialty("");
			correctObject.setServiceLine("");

			empAccDao.create(connector.getConnection(), correctObject);

		} catch (Exception x) {
			System.err.println("error_adding_empdetails: " + x.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.jds.architecture.service.dao.EmpAccentureDetailscon#findByPK(java.lang.Object)}.
	 */
	@Test
	public void testFindByPK() {
		addEmpDetails();

		try {
			Object findPK = "10";
			Object o = empAccDao.findByPK(findPK);

			if (o == null)
				fail("findByPK returned null");

			assertEquals(((AccentureDetails) o).getEnterpriseAddress(), "em000");

			return;
		} catch (Exception x) {
			System.err.println("error12: " + x.getMessage());
			x.printStackTrace();
		}
		fail("exception in findByPK");
	}

	/**
	 * Test method for
	 * {@link com.jds.architecture.service.dao.EmpAccentureDetailscon#find(java.lang.Object)}.
	 */
	@Test
	public void testFind() {
		addEmpDetails();

		AccentureDetails findObject = new AccentureDetails();

		findObject.setEmployeeNo("2");
		findObject.setEnterpriseAddress("em2");
		findObject.setLevel("");
		findObject.setLMU("LMU");

		try {

			RowSet rs = empAccDao.find(findObject);

			String test = rsContents(rs, SHORT);
			assertEquals("@:em2:", test);

			findObject = new AccentureDetails();

			findObject.setLevel("");
			findObject.setDateHired(new java.sql.Date(2001, 1, 1));

			rs = empAccDao.find(findObject);

			test = rsContents(rs, SHORT);
			assertEquals("@:em000:@:em1:", test);

			return;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("something is wrong..");
			fail("wrong!");
		}

		fail("exception..");
	}

	private String rsContents(RowSet rs, boolean full) {

		StringBuffer res = new StringBuffer("");

		try {
			while (rs.next()) {
				res.append("@:");
				res.append(rs.getObject("emailadd"));
				res.append(":");
				if (full) {
					res.append(rs.getObject("LMU"));
					res.append(":");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return res.toString();
	}

	/**
	 * Test method for
	 * {@link com.jds.architecture.service.dao.EmpAccentureDetailscon#update(java.sql.Connection, java.lang.Object, java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		addEmpDetails();

		AccentureDetails where = new AccentureDetails();
		where.setLMU("LMU");

		AccentureDetails set = new AccentureDetails();
		set.setLMU("brr");

		try {
			empAccDao.update(connector.getConnection(), set, where);

			RowSet rs = empAccDao.findByAll();

			String test = rsContents(rs, FULL);
			assertEquals("@:em000:brr:@:em1:brr:@:em2:brr:", test);

			where = new AccentureDetails();
			where.setEnterpriseAddress("em2");

			set.setEnterpriseAddress("xx2");

			empAccDao.update(connector.getConnection(), set, where);
			rs = empAccDao.findByAll();

			test = rsContents(rs, FULL);
			assertEquals("@:em000:brr:@:em1:brr:@:xx2:brr:", test);

			return;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		fail("exception..");
	}

	/**
	 * Test method for
	 * {@link com.jds.architecture.service.dao.EmpAccentureDetailscon#findByAll()}.
	 */
	@Test
	public void testFindByAll() {
		addEmpDetails();

		try {
			RowSet rs = empAccDao.findByAll();

			String test = rsContents(rs, FULL);
			assertEquals("@:em000:LMU:@:em1:LMU:@:em2:LMU:", test);

			return;
		} catch (Exception ex) {
		}

		fail("bad!");
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

	public void clearAll() {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM empaccenturedetail");
			stmt.close();
		} catch (Exception ex) {
		}
	}

	public void createEmployees() {
		try {
			// Clear tables
			PreparedStatement clearStatement = conn
					.prepareStatement("DELETE FROM empaccenturedetail");
			clearStatement.executeUpdate();
			clearStatement = conn.prepareStatement("DELETE FROM employee");
			clearStatement.executeUpdate();

			// Fill employee table
			PreparedStatement pstmt = conn
					.prepareStatement("INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, "1"); // primary
			pstmt.setString(2, "AA"); // unique
			pstmt.setString(3, "BA"); // unique
			pstmt.setString(4, "CA"); // unique
			pstmt.setDate(5, new java.sql.Date(Calendar.getInstance()
					.getTimeInMillis()));
			pstmt.setString(6, "");
			pstmt.setString(7, "M");
			pstmt.setString(8, "");
			pstmt.setString(9, "");
			pstmt.setString(10, "");
			pstmt.setString(11, "");
			pstmt.setString(12, "");
			pstmt.setString(13, "");
			pstmt.setString(14, "hello, world!");
			pstmt.setString(15, "");
			pstmt.setString(16, "");
			pstmt.setString(17, "");
			pstmt.setString(18, "");
			pstmt.setString(19, "Stoljar");
			pstmt.setString(20, "");
			pstmt.executeUpdate();

			pstmt.setString(1, "2"); // primary
			pstmt.setString(2, "AB"); // unique
			pstmt.setString(3, "BB"); // unique
			pstmt.setString(4, "CB"); // unique
			pstmt.setDate(5, new java.sql.Date(Calendar.getInstance()
					.getTimeInMillis()));
			pstmt.setString(6, "");
			pstmt.setString(7, "M");
			pstmt.setString(8, "");
			pstmt.setString(9, "");
			pstmt.setString(10, "");
			pstmt.setString(11, "");
			pstmt.setString(12, "");
			pstmt.setString(13, "");
			pstmt.setString(14, "hello, world!");
			pstmt.setString(15, "");
			pstmt.setString(16, "");
			pstmt.setString(17, "");
			pstmt.setString(18, "");
			pstmt.setString(19, "Stoljar");
			pstmt.setString(20, "");
			pstmt.executeUpdate();

			pstmt.setString(1, "3"); // primary
			pstmt.setString(2, "A"); // unique
			pstmt.setString(3, "B"); // unique
			pstmt.setString(4, "C"); // unique
			pstmt.setDate(5, new java.sql.Date(Calendar.getInstance()
					.getTimeInMillis()));
			pstmt.setString(6, "");
			pstmt.setString(7, "M");
			pstmt.setString(8, "");
			pstmt.setString(9, "");
			pstmt.setString(10, "");
			pstmt.setString(11, "");
			pstmt.setString(12, "");
			pstmt.setString(13, "");
			pstmt.setString(14, "hello, world!");
			pstmt.setString(15, "");
			pstmt.setString(16, "");
			pstmt.setString(17, "");
			pstmt.setString(18, "");
			pstmt.setString(19, "Stoljar");
			pstmt.setString(20, "");
			pstmt.executeUpdate();

			pstmt.setString(1, "10"); // primary
			pstmt.setString(2, "Axx"); // unique
			pstmt.setString(3, "Bxx"); // unique
			pstmt.setString(4, "Cxx"); // unique
			pstmt.setDate(5, new java.sql.Date(Calendar.getInstance()
					.getTimeInMillis()));
			pstmt.setString(6, "");
			pstmt.setString(7, "M");
			pstmt.setString(8, "");
			pstmt.setString(9, "");
			pstmt.setString(10, "");
			pstmt.setString(11, "");
			pstmt.setString(12, "");
			pstmt.setString(13, "");
			pstmt.setString(14, "hello, world!");
			pstmt.setString(15, "");
			pstmt.setString(16, "");
			pstmt.setString(17, "");
			pstmt.setString(18, "");
			pstmt.setString(19, "Stoljar");
			pstmt.setString(20, "");
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.err.println("error3: " + e.getMessage());
			throw new RuntimeException("Could not initialize UrlDAO", e);
		}
	}
}
