/**
 * 
 */
package com.jds.architecture.service.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Statement;
import javax.sql.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jds.apps.beans.SkillsInformation;
import com.jds.architecture.service.dbaccess.DBAccess;
import com.jds.architecture.service.dbaccess.DBAccessException;

/**
 * @author Ivars Lacis
 *
 */
public class SkillDAOTest
{
	private static SkillDAO dao;
	static Connection conn;
	static String dbDriver, dbUrl, dbUser, dbPassword;

	@BeforeClass
	public static void onlyOnce()
	{
		dbDriver = "oracle.jdbc.driver.OracleDriver";
		dbUrl = "jdbc:oracle:oci:@localhost:1521:XE";
		dbUser = "hruser";
		dbPassword = "hruser";
		try
		{
			dao = new SkillDAO(dbDriver, dbUrl, dbUser, dbPassword);
		}
		catch (Exception e)
		{
			
		}
		
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}
	@Before
	public void setUp() throws Exception
	{
		dao.reconnect();
		conn = dao.getConnection();
	}
	@After
	public void tearDown() throws Exception
	{
		dao.reconnect();
		Connection conn = dao.getConnection();
		Statement stmt = conn.createStatement();
		stmt.close();
		conn.close();
	}
//create()
	//test: normal flow - OK
	@Test
	public final void testCreate()
	{
		SkillsInformation si = new SkillsInformation();
		
		si.setSkillId("122");
		si.setCategoryId("011");
		si.setSkillName("test skill 23.07");
		si.setSkillDescription("sodienas datums");
		
		try
		{
			dao.create(conn, si);
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}
	//test: error flow - OK
	@Test
	public final void testCreateNullObject()
	{
		try
		{
			dao.create(conn, null);
			fail("k");
		}
		catch (DAOException e)
		{
			return;
		}
		catch (Exception e)
		{
			fail("k");
		}
	}
	@Test
	public final void testCreateNotInstanceOfSkillsInformationObject()
	{
		try
		{
			dao.create(conn, "Ivars");
			fail("k");
		}
		catch (DAOException e)
		{
			return;
		}
		catch (Exception e)
		{
			fail("k");
		}
	}@Test
	public final void testCreateNullConnection()
	{
		SkillsInformation si = new SkillsInformation();
		
		si.setSkillId("122");
		si.setCategoryId("011");
		si.setSkillName("test skill 23.07");
		si.setSkillDescription("sodienas datums");
		
		try
		{
			dao.create(null, si);
			fail("k");
		}
		catch (DAOException e)
		{
			return;
		}
		catch (Exception e)
		{
			fail("k");
		}
	}
	public final void testCreateNullConnectionNullObject()
	{
		try
		{
			dao.create(null, null);
			fail("k");
		}
		catch (DAOException e)
		{
			return;
		}
		catch (Exception e)
		{
			fail("k");
		}
	}
	@Test
	public final void testCreateIfObjectAlreadyExist()
	{
		SkillsInformation si = new SkillsInformation();
		
		si.setSkillId("789");
		si.setCategoryId("1001");
		si.setSkillName("Adobe Photoshop");
		si.setSkillDescription("VER 8");
		
		try
		{
			dao.create(null, si);
			fail("izpildija");
		}
		catch (DAOException e)
		{
			return;
		}
		catch (Exception e)
		{
			fail("kads cits iznemums");
		}
	}
//find()
	//test: normal flow - OK
	@Test
	public final void testFind()
	{
		SkillsInformation si = new SkillsInformation();
		RowSet rs;

		si.setSkillName("Java");
		
		try
		{
			rs = dao.find(si);
			if (rs.next())
			{
				assertEquals("J2SDK1.5", rs.getString("description"));
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
	@Test
	public final void testFindAdvanced()
	{
		SkillsInformation si = new SkillsInformation();
		RowSet rs;

		si.setSkillName("C++");
		si.setSkillDescription("VER 6");
		
		try
		{
			rs = dao.find(si);
			if (rs.next())
			{
				assertEquals("C++", rs.getString("name"));
				assertEquals("456", rs.getString("id"));
			}
			else
			{
				fail("err: find advanced");
			}
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}
	//test: error flow - OK
	@Test
	public final void testFindError()
	{
		RowSet rs;
		
		try
		{
			rs = dao.find(null);
			fail("err: find error");
		}
		catch (DAOException e)
		{
			return;
		}
	}
//findByAll
	//test: normal flow - OK
	@Test
	public final void testFindByAll()
	{
		try
		{
			SkillDAO dao = new SkillDAO();
			RowSet rs = dao.findByAll();
			
			while (rs.next())
			{
				System.out.println(rs.getString("name"));
			}
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}
//findByPK()
	//test: normal flow - OK
	@Test
	public final void testFindByPK()
	{
		SkillsInformation tmp;
		try
		{
			tmp = (SkillsInformation)dao.findByPK("789");
			assertEquals(tmp.getSkillName(), "Adobe Photoshop");
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}
	//test: error flow - OK
	@Test
	public final void testFindByPKNullObject()
	{
		try
		{
			dao.findByPK(null);
			fail("izpildija");
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
	public final void testFindByPKNotExistingObject()
	{
		SkillsInformation tmp;
		try
		{
			tmp = (SkillsInformation)dao.findByPK("000");
			assertEquals(null, tmp);
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
//remove()
	//test: normal flow - OK
	@Test
	public final void testRemove()
	{
		String id = "122";
		try
		{
			boolean b = dao.remove(conn, id);
			assertEquals(true, b);
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}
	//test: error flow - OK
	@Test
	public final void testRemoveNullObject()
	{
		try
		{
			dao.remove(conn, null);
			fail("izpildija");
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
	public final void testRemoveNotInstanceOfString()
	{
		int id = 122;
		try
		{
			dao.remove(conn, id);
			fail("k");
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
	public final void testRemoveNullConnection()
	{
		String id = "122";
		try
		{
			dao.remove(null, id);
			fail("k");
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
	public final void testRemoveNullConnectionNullObject()
	{
		try
		{
			dao.remove(null, null);
			fail("izpildija");
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
//update()
	//test: normal flow - OK
	@Test
	public final void testUpdate()
	{
		SkillsInformation siOld = new SkillsInformation();
		SkillsInformation siNew = new SkillsInformation();
		
		siOld.setSkillId("789");
		siOld.setCategoryId("1001");
		siOld.setSkillName("Adobe Photoshop");
		siOld.setSkillDescription("VER 8");
		
		siNew.setSkillId("789");
		siNew.setCategoryId("1001");
		siNew.setSkillName("Adobe Photoshop");
		siNew.setSkillDescription("VER 8");
		
		try
		{
			boolean b = dao.update(conn, siNew, siOld);
			assertEquals(true, b);
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}
	//test: error flow - OK
	@Test
	public final void testUpdateNullConnection()
	{
		SkillsInformation siOld = new SkillsInformation();
		SkillsInformation siNew = new SkillsInformation();
		
		siOld.setSkillId("789");
		siOld.setCategoryId("1001");
		siOld.setSkillName("Adobe Photoshop");
		siOld.setSkillDescription("VER 8");
		
		siNew.setSkillId("789");
		siNew.setCategoryId("1001");
		siNew.setSkillName("Adobe Photoshop");
		siNew.setSkillDescription("VER 8");
		
		try
		{
			dao.update(null, siNew, siOld);
			fail("err: testUpdateNullConnection");
		}
		catch (DAOException e)
		{
			return;
		}
	}
	@Test
	public final void testUpdateNullSiNew()
	{
		SkillsInformation siOld = new SkillsInformation();
		SkillsInformation siNew = new SkillsInformation();
		
		siOld.setSkillId("789");
		siOld.setCategoryId("1001");
		siOld.setSkillName("Adobe Photoshop");
		siOld.setSkillDescription("VER 8");
		
		siNew.setSkillId("789");
		siNew.setCategoryId("1001");
		siNew.setSkillName("Adobe Photoshop");
		siNew.setSkillDescription("VER 8");
		
		try
		{
			dao.update(conn, null, siOld);
			fail("err: testUpdateNullSiNew");
		}
		catch (DAOException e)
		{
			return;
		}
	}
	@Test
	public final void testUpdateNullSiOld()
	{
		SkillsInformation siOld = new SkillsInformation();
		SkillsInformation siNew = new SkillsInformation();
		
		siOld.setSkillId("789");
		siOld.setCategoryId("1001");
		siOld.setSkillName("Adobe Photoshop");
		siOld.setSkillDescription("VER 8");
		
		siNew.setSkillId("789");
		siNew.setCategoryId("1001");
		siNew.setSkillName("Adobe Photoshop");
		siNew.setSkillDescription("VER 8");
		
		try
		{
			dao.update(conn, siNew, null);
			fail("err: testUpdateNullSiOld");
		}
		catch (DAOException e)
		{
			return;
		}
	}
	@Test
	public final void testUpdateNotInstanceOfSkillsInformation1()
	{
		SkillsInformation siOld = new SkillsInformation();
		SkillsInformation siNew = new SkillsInformation();
		
		siOld.setSkillId("789");
		siOld.setCategoryId("1001");
		siOld.setSkillName("Adobe Photoshop");
		siOld.setSkillDescription("VER 8");
		
		siNew.setSkillId("789");
		siNew.setCategoryId("1001");
		siNew.setSkillName("Adobe Photoshop");
		siNew.setSkillDescription("VER 8");
		
		try
		{
			dao.update(null, "Ivars", siOld);
			fail("err: testUpdateNotInstanceOfSkillsInformation1");
		}
		catch (DAOException e)
		{
			return;
		}
	}
	public final void testUpdateNotInstanceOfSkillsInformation2()
	{
		SkillsInformation siOld = new SkillsInformation();
		SkillsInformation siNew = new SkillsInformation();
		
		siOld.setSkillId("789");
		siOld.setCategoryId("1001");
		siOld.setSkillName("Adobe Photoshop");
		siOld.setSkillDescription("VER 8");
		
		siNew.setSkillId("789");
		siNew.setCategoryId("1001");
		siNew.setSkillName("Adobe Photoshop");
		siNew.setSkillDescription("VER 8");
		
		try
		{
			dao.update(null, siNew, "Ivars");
			fail("err: testUpdateNotInstanceOfSkillsInformation1");
		}
		catch (DAOException e)
		{
			return;
		}
	}
}

