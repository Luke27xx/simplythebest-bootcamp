package com.jds.architecture.service.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jds.apps.beans.SkillsInformation;
import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.logging.LoggerService;
import com.jds.architecture.service.dao.assembler.SkillsAssembler;
import com.jds.architecture.service.dao.stmtgenerator.StatementGenerator;
import com.jds.architecture.service.dao.stmtgenerator.StatementGeneratorFactory;
import com.jds.architecture.service.dbaccess.DBAccess;
import com.jds.architecture.service.dbaccess.DBAccessException;
import com.sun.rowset.CachedRowSetImpl;

/**
 * <p>
 * Data Access class that provides basic functionality (insert, update, remove, find) for Skill data table.
 * </p> 
 * 
 * @author Ivars Lacis
 *
 */
public class SkillDAO implements DataAccessObjectInterface
{
//variables
	private DBAccess dbAccess = null;
	private static Logger log = (Logger) ServiceFactory.getInstance().getService(LoggerService.class);
	StatementGenerator stmtGen = null;

//variables for test performing
	protected String dbDriver;
	protected String dbUrl;
	protected String dbUser;
	protected String dbPassword;
	protected Connection conn;
	
//methods for test performing
	public SkillDAO(String dbDriver, String dbUrl, String dbUser, String dbPassword)
	{
		this.dbDriver = dbDriver;
		this.dbUrl = dbUrl;
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
	}
	public void reconnect() throws DAOException {
		try
		{
			if (conn == null || conn.isClosed())
			{
				Class.forName(dbDriver);
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			}
		}
		catch (Exception e)
		{
			log.error("Could not initialize UrlDAO", e);
			throw new DAOException("Could not initialize UrlDAO", e);
		}
	}
	public void close() throws DAOException
	{
		if (conn != null)
		{
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				log.error("Could not close connection", e);
				throw new DAOException("Could not close connection", e);
			}
			conn = null;
		}
	}
	public Connection getConnection() {
		return conn;
	}
	
//methods
	/**
	 * Default constructor.
	 * Initializes attributes that will be used by the class.
	 * 
	 * @throws DAOException
	 * @throws DBAccessException
	 */
	public SkillDAO() throws DAOException, DBAccessException
	{
		log.info("initializing SkillDAO");
		dbAccess = DBAccess.getDBAccess();
		stmtGen =  StatementGeneratorFactory.getGenerator().getStmtGenerator(DAOConstants.GEN_SKILL);
	}
	/**
	 * Method inserts new record in Skill table.
	 * 
	 *@param Connection - database connection
	 *@param Object - must be an instance of SkillInformation, contains object for insert
	 *@throws DAOException
	 */
	//tested
	public void create(Connection conn, Object obj) throws DAOException
	{
		if (!(obj instanceof SkillsInformation))
			throw new DAOException("invalid.object.skilldao", null, DAOException.ERROR, true);
		
		String sqlstmt = DAOConstants.SKILL_CREATE;
		SkillsInformation skill = (SkillsInformation) obj;
		
		if (skill.getSkillId() == null)
			throw new DAOException("invalid.object.skilldao", null, DAOException.ERROR, true);
		
		log.debug("creating SkillsInformation entry");
		
		try
		{
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			SkillsAssembler.getPreparedStatement(skill, stmt);
			stmt.executeUpdate();
			log.debug("created SkillsInformation entry");
		}
		catch (SQLException e)
		{
			throw new DAOException ("sql.create.exception.skilldao", e, DAOException.ERROR, true);
		}
		catch (Exception e)
		{
			throw new DAOException ("create.exception.skildao", e.getCause(),  DAOException.ERROR, true);
		}
			
	}
	/**
	 * Method finds corresponding record in Skill table
	 * according to search criteria passed.
	 * 
	 * @param Object - must be instance of SkillsInformation class
	 * @throws DAOException
	 */
	//still needs testing
	public RowSet find(Object obj) throws DAOException
	{
		String sqlStmt = DAOConstants.SKILL_FIND_MAIN;
		SkillsInformation skillReturn = null;

		if (!(obj instanceof String))
			throw new DAOException("invalid.object.skilldao", null, DAOException.ERROR, true);
					
		String checkedFields = (String)obj;
		Connection conn = null;
		
		try
		{
			log.debug("finding SkillsInformation entry by specified fields");
			
			conn = dbAccess.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);
				
			stmt.setString(1, checkedFields);
			ResultSet rs = stmt.executeQuery();
				
			if (rs.next())
			{
				skillReturn = SkillsAssembler.getInfo(rs);
			}
				
			rs.close();
			
			log.debug("found SkillsInformation entry by specified fields");
		}
		catch (DBAccessException e)
		{
			throw new DAOException(e.getMessageKey(), e, DAOException.ERROR, true);				
		}
		catch (SQLException e)
		{
			throw new DAOException("sql.find.exception.skilldao", e, DAOException.ERROR, true);
		}
		finally
		{
			try
			{
				dbAccess.closeConnection(conn);
			}
			catch (DBAccessException e)
			{

			}
		}

		return (RowSet)skillReturn;
	}
	/**
	 * Method returns all records from Skill table.
	 * 
	 * @throws DAOException
	 * @return RowSet - all records in Skill table
	 */
	//still needs testing
	public RowSet findByAll() throws DAOException
	{
		String sqlStmt = DAOConstants.SKILL_FIND_ALL;
		RowSet skillsReturn = null;
        
		Connection conn = null;

		try
		{
			log.debug("finding all SkillsInformation entrys");
			
			conn = dbAccess.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);
			ResultSet rs = stmt.executeQuery();

			CachedRowSet tmp = new CachedRowSetImpl();
			tmp.populate(rs);
			
			stmt.close();
			rs.close();
			
			skillsReturn = (RowSet)tmp;
			
			log.debug("found all SkillsInformation entrys");
		}
		catch (DBAccessException e)
		{
			throw new DAOException(e.getMessageKey(), e, DAOException.ERROR, true);				
		}
		catch (SQLException e)
		{
			throw new DAOException("sql.findpk.exception.skildao", e, DAOException.ERROR, true);
		}
		finally
		{
			try
			{
				dbAccess.closeConnection(conn);
			}
			catch (DBAccessException e)
			{
			}
		}
		
		return (RowSet)skillsReturn;
	}
	/**
	 * Finds a record by PrimaryKey from Skill table
	 * 
	 * @param Object  -  String instance, primary key of record
	 * @throws DAOException
	 * @return Object - instance of SkillsInformations class
	 * 
	 */
	//still needs testing
	public Object findByPK(Object obj) throws DAOException
	{
		String sqlStmt = DAOConstants.SKILL_FIND_BYPK;
		SkillsInformation skillReturn = null;

		if (!(obj instanceof String) || obj == null)
			throw new DAOException("invalid.object.skilldao", null, DAOException.ERROR, true);
					
		String pk = (String)obj;				
		Connection conn = null;

		try
		{
			log.debug("finding SkillsInformation entry by PK");
			
			conn = dbAccess.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);
			stmt.setString(1, pk);
			ResultSet rs = stmt.executeQuery();
				
			if (rs.next())
				skillReturn = SkillsAssembler.getInfo(rs);
			rs.close();
			log.debug("found SkillsInformation entry by PK");
		}
		catch (DBAccessException e)
		{
			throw new DAOException (e.getMessageKey(), e, DAOException.ERROR, true);				
		}
		catch (SQLException e)
		{
			throw new DAOException ("sql.findpk.exception.skilldao", e, DAOException.ERROR, true);
		}
		finally
		{
			try
			{
				dbAccess.closeConnection(conn);
			}
			catch (DBAccessException e)
			{
			}
		}
		return skillReturn;
	}
	/**
	 * Method removes corresponding record from Skill table.
	 * 
	 * @param Connection
	 * @param Object - instance of SkillsInformation class to remove from Skill table
	 * @throws DAOException
	 * @return boolean - true if successfully removed
	 */
	//still needs testing
	public boolean remove(Connection conn, Object obj) throws DAOException
	{
		if (!(obj instanceof SkillsInformation))
			throw new DAOException("invalid.object.skilldao", null, DAOException.ERROR, true);
		
		String sqlstmt = DAOConstants.SKILL_DELETE;
		SkillsInformation skill = (SkillsInformation)obj;
		
		if(skill.equals(null))
			throw new DAOException("invalid.object.skilldao", null, DAOException.ERROR, true);
	
		log.debug("removing ProjectInfo entry");
		
		try
		{	
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			SkillsAssembler.getPreparedStatement(skill, stmt);
			stmt.executeUpdate();
			
			log.debug("removing SkillsInformation entry");
		}
		catch (SQLException e)
		{
			throw new DAOException("sql.remove.exception.skilldao", e, DAOException.ERROR, true);
		}
		catch (Exception e)
		{
			throw new DAOException("remove.exception.skilldao", e.getCause(),  DAOException.ERROR, true);
 
		} 
		return true;
	}
	/**
	 * Method updates corresponding record in Skill table.
	 * 
	 * @param Connection
	 * @param Object - instance of SkillsInformation class to update
	 * @param Object - instance of SkillsInformation class to update
	 * @throws DAOException
	 * @return boolean - true if successfully updated
	 */
	//still needs testing
	public boolean update(Connection conn, Object objNew, Object objOld) throws DAOException
	{
		if (!(objNew instanceof SkillsInformation) && !(objOld instanceof SkillsInformation))
			throw new DAOException("invalid.object.skilldao", null, DAOException.ERROR, true);
		
		String sqlstmt = DAOConstants.SKILL_UPDATE_MAIN;
		
		SkillsInformation skillNew = (SkillsInformation)objNew;
		SkillsInformation skillOld = (SkillsInformation)objOld;
		
		if(skillOld.getSkillId() == null)
			throw new DAOException("invalid.object.projdao", null, DAOException.ERROR, true);
	
		log.debug("updating SkillsInformation entry");
		
		try
		{
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			
			SkillsAssembler.getPreparedStatement(skillOld, stmt);
			stmt.executeUpdate();
			SkillsAssembler.getPreparedStatement(skillNew, stmt);
			stmt.executeUpdate();
			
			log.debug("updated Skill entry");
		}
		catch (SQLException e)
		{
			throw new DAOException("sql.update.exception.skilldao", e, DAOException.ERROR, true);
		}
		catch (Exception e)
		{
			throw new DAOException("update.exception.skilldao", e.getCause(),  DAOException.ERROR, true);
		}
		
        return true;
	}
}
