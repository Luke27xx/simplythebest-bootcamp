package com.jds.architecture.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	//test: normal flow - OK; error flow - OK
	public void create(Connection conn, Object obj) throws DAOException
	{
		if (!(obj instanceof SkillsInformation) || obj == null || !(conn instanceof Connection) || conn == null)
			throw new DAOException("invalid.object.skilldao", null, DAOException.ERROR, true);
		
		String sqlstmt = DAOConstants.SKILL_CREATE;
		SkillsInformation skill = (SkillsInformation) obj;
		
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
			throw new DAOException("sql.create.exception.skilldao", e, DAOException.ERROR, true);
		}
		catch (Exception e)
		{
			throw new DAOException("create.exception.skildao", e.getCause(),  DAOException.ERROR, true);
		}
	}
	/**
	 * Method finds corresponding record in Skill table
	 * according to search criteria passed.
	 * 
	 * @param Object - must be instance of SkillsInformation class
	 * @throws DAOException
	 */
	// test: normal flow - OK; error flow - TODO needs test
	public RowSet find(Object obj) throws DAOException
	{
		String sqlStmt = DAOConstants.SKILL_FIND_MAIN;
		String sqlFieldsToFind = null;
		Connection conn = null;
		CachedRowSet tmp = null;
		
		if (!(obj instanceof SkillsInformation))
			throw new DAOException("invalid.object.skilldao", null, DAOException.ERROR, true);

		try
		{
			sqlFieldsToFind = stmtGen.transformStmt(obj, DAOConstants.STMT_TYPE_WHERE);
		}
		catch (Exception e)
		{
			throw new DAOException(e.getMessage(), e, DAOException.ERROR, true);
		}
		
		try
		{
			log.debug("finding SkillsInformation entry by specified fields");
			
			conn = dbAccess.getConnection();
			
			sqlStmt = sqlStmt.replaceFirst("@", sqlFieldsToFind);
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);

			ResultSet rs = stmt.executeQuery();
			tmp= new CachedRowSetImpl();
			
			tmp.populate(rs);
			
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
				throw new DAOException(e.getMessageKey(), e, DAOException.ERROR, true);
			}
		}

		return (RowSet)tmp;
	}
	/**
	 * Method returns all records from Skill table.
	 * 
	 * @throws DAOException
	 * @return RowSet - all records in Skill table
	 */
	//test: normal flow - OK; error flow - OK
	public RowSet findByAll() throws DAOException
	{
		String sqlStmt = DAOConstants.SKILL_FIND_ALL;
		Connection conn = null;
		CachedRowSet tmp;
		try
		{
			log.debug("finding all SkillsInformation entrys");
			
			conn = dbAccess.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);
			ResultSet rs = stmt.executeQuery();

			tmp = new CachedRowSetImpl();
			tmp.populate(rs);
			
			stmt.close();
			rs.close();
			
			log.debug("found all SkillsInformation entrys");
		}
		catch (DBAccessException e)
		{
			throw new DAOException(e.getMessageKey(), e, DAOException.ERROR, true);				
		}
		catch (SQLException e)
		{
			throw new DAOException("sql.findall.exception.skildao", e, DAOException.ERROR, true);
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
		
		return (RowSet)tmp;
	}
	/**
	 * Finds a record by PrimaryKey from Skill table
	 * 
	 * @param Object  -  String instance, primary key of record
	 * @throws DAOException
	 * @return Object - instance of SkillsInformations class
	 * 
	 */
	//test: normal flow - OK, error flow - OK
	public Object findByPK(Object obj) throws DAOException
	{
		String sqlStmt = DAOConstants.SKILL_FIND_BYPK;
		SkillsInformation skillReturn = null;

		if (!(obj instanceof String) || obj == null)
			throw new DAOException("invalid.object.skilldao", null, DAOException.ERROR, true);
					
		String pkToFind = (String)obj;				
		Connection conn = null;

		try
		{
			log.debug("finding SkillsInformation entry by PK");
			
			conn = dbAccess.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);
			stmt.setString(1, pkToFind);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next())
			{
				skillReturn = SkillsAssembler.getInfo(rs);
			}
			
			stmt.close();
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
	//test: normal flow - OK; error flow - OK
	public boolean remove(Connection conn, Object obj) throws DAOException
	{
		if (!(obj instanceof String) || obj == null)
			throw new DAOException("invalid.object.skilldao", null, DAOException.ERROR, true);
		
		String sqlstmt = DAOConstants.SKILL_DELETE;
		String skillToRemove = (String)obj;
	
		log.debug("removing ProjectInfo entry");
		
		try
		{	
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			stmt.setString(1, skillToRemove);
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
	//test: normal flow - OK; error flow - OK
	public boolean update(Connection conn, Object objNew, Object objOld) throws DAOException
	{
		if (!(objNew instanceof SkillsInformation) && !(objOld instanceof SkillsInformation))
			throw new DAOException("invalid.object.skilldao", null, DAOException.ERROR, true);
		
		String sqlstmt = DAOConstants.SKILL_UPDATE_MAIN;

		String sqlNew = null;
		String sqlOld = null;
		
		try
		{
			sqlNew = stmtGen.transformStmt(objNew, DAOConstants.STMT_TYPE_SET);
			sqlOld = stmtGen.transformStmt(objOld, DAOConstants.STMT_TYPE_WHERE);
		}
		catch (Exception e)
		{
			throw new DAOException("update.exception.skilldao", e.getCause(),  DAOException.ERROR, true);
		}
		
		try
		{
			log.debug("updating SkillsInformation entry");
			
			sqlstmt = sqlstmt.replaceFirst("@", sqlNew).replaceFirst("@", sqlOld);

			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			ResultSet rs = stmt.executeQuery();
				
			rs.close();
			
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
