/**
 * 
 */
package com.jds.architecture.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;


import com.jds.apps.beans.EmployeeInfo;
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
 * SkillDAO is data access object class for Skill table
 * </p> 
 * 
 * @author Ivars Lacis
 *
 */
public class SkillDAO implements DataAccessObjectInterface
{
	
	private DBAccess dbAccess = null;
	private static Logger log = (Logger) ServiceFactory.getInstance().getService(LoggerService.class);

	StatementGenerator stmtGen = null;

	/**
	 * Constructor
	 * initializes variables
	 * @throws DAOException
	 * @throws DBAccessException
	 */
	public SkillDAO() throws DAOException, DBAccessException
	{
		log.info("initializing SkillDAO");
		dbAccess = DBAccess.getDBAccess();
		stmtGen =  StatementGeneratorFactory.getGenerator().getStmtGenerator(DAOConstants.GEN_EMP);
	}

	/* (non-Javadoc)
	 * @see com.jds.architecture.service.dao.DataAccessObjectInterface#create(java.sql.Connection, java.lang.Object)
	 */
	/**
	 * Creates or insert new record to the table
	 *@param Connection - database connection
	 *@param Object  - must be an instance of SkillInformation, contains object for insert
	 */
	public void create(Connection conn, Object obj) throws DAOException
	{
		if (!(obj instanceof SkillsInformation))
			throw new DAOException ("invalid.object.skilldao", null, DAOException.ERROR, true);
		
		String sqlstmt = DAOConstants.SKILL_CREATE;
		SkillsInformation skill = (SkillsInformation) obj;
		
		if (skill.getSkillId() == null)
			throw new DAOException ("invalid.object.skilldao", null, DAOException.ERROR, true);
		
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

	/* (non-Javadoc)
	 * @see com.jds.architecture.service.dao.DataAccessObjectInterface#find(java.lang.Object)
	 */
	public RowSet find(Object obj) throws DAOException {
		// TODO
		return null;
	}

	/* (non-Javadoc)
	 * @see com.jds.architecture.service.dao.DataAccessObjectInterface#findByAll()
	 */
	public RowSet findByAll() throws DAOException {
		// TODO 
		return null;
	}

	/* (non-Javadoc)
	 * @see com.jds.architecture.service.dao.DataAccessObjectInterface#findByPK(java.lang.Object)
	 */
	/**
	 * Finds a record by PrimaryKey from the table
	 * @return Object -  String
	 * @param Object  -  String instance, primary key of the record
	 */
	public Object findByPK(Object obj) throws DAOException {
		String sqlStmt = DAOConstants.SKILL_FIND_BYPK;
		SkillsInformation skillReturn = null;

		if (!(obj instanceof String) || obj == null)
			throw new DAOException ("invalid.object.skilldao", null, DAOException.ERROR, true);
					
		String pk = (String) obj;				
		Connection conn = null;

		try
		{
			log.debug("finding pk SkillsInformation entry");
			conn = dbAccess.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);
			stmt.setString(1, pk);
			ResultSet rs = stmt.executeQuery();
				
			if (rs.next())
				skillReturn = SkillsAssembler.getInfo(rs);
			rs.close();
			log.debug("found by pk SkillsInformation entry");
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
			catch (DBAccessException e1) 
			{
			}
		}
		return skillReturn;
	}

	/* (non-Javadoc)
	 * @see com.jds.architecture.service.dao.DataAccessObjectInterface#remove(java.sql.Connection, java.lang.Object)
	 */
	public boolean remove(Connection conn, Object obj) throws DAOException {
		// TODO
		return false;
	}

	/* (non-Javadoc)
	 * @see com.jds.architecture.service.dao.DataAccessObjectInterface#update(java.sql.Connection, java.lang.Object, java.lang.Object)
	 */
	public boolean update(Connection conn, Object obj1, Object obj2) throws DAOException {
		// TODO
		return false;
	}

}
