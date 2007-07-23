package com.jds.architecture.service.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//import ats_jp.activity.jdbc_sample.Bookmark;
//import ats_jp.activity.jdbc_sample.DAOException;

import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.logging.LoggerService;
import com.jds.architecture.service.dao.DAOConstants;

import com.jds.apps.beans.AccentureDetails;
import com.jds.apps.beans.EmployeeInfo;
import com.jds.apps.beans.ProjectInfo;
import com.jds.architecture.service.dao.assembler.AccentureDetailsAssembler;
import com.jds.architecture.service.dao.assembler.EmployeeAssembler;
import com.jds.architecture.service.dao.assembler.ProjectAssembler;
import com.jds.architecture.service.dao.stmtgenerator.StatementGenProject;
import com.jds.architecture.service.dao.stmtgenerator.StatementGenerator;
import com.jds.architecture.service.dao.stmtgenerator.StatementGeneratorFactory;
import com.jds.architecture.service.dbaccess.DBAccess;
import com.jds.architecture.service.dbaccess.DBAccessException;
import com.sun.rowset.CachedRowSetImpl;


/**
 * 
 * @author Vytatas Streimikis and Jelena Sokolova
 *
 */
public class ProjectDAO  implements DataAccessObjectInterface {

	private DBAccess dbAccess = null;
	private static Logger log = (Logger) ServiceFactory.getInstance()
	.getService(LoggerService.class);

	StatementGenerator stmtGen = null;
	

	/**
	 * Constructor
	 * initializes variables
	 * @throws DAOException
	 * @throws DBAccessException
	 */
	protected ProjectDAO() throws DAOException, DBAccessException {
		log.info("initializing ProjectDAO");
		dbAccess = DBAccess.getDBAccess();
		stmtGen =  StatementGeneratorFactory.
			getGenerator().getStmtGenerator(DAOConstants.GEN_PROJ);


	}
	
	//TODO Lena
	/**
	 * Creates or insert new record to the table
	 *@param Connection - database connection
	 *@param Object  - must be an instance of ProjectInfo,contains object for insert
	 */
	public void create(Connection conn, Object object) 
		throws DAOException {

		if (!(object instanceof ProjectInfo))
			throw new DAOException ("invalid.object.projdao",
					null, DAOException.ERROR, true);
			
		
		String sqlstmt = DAOConstants.PROJ_CREATE;
		ProjectInfo project = (ProjectInfo) object;

		if(project.getProjectId() == null)
			throw new DAOException ("invalid.object.projdao",
					null, DAOException.ERROR, true);
			
			
		log.debug("creating ProjectInfo entry");
		try{
			if (conn == null || conn.isClosed())
				conn = dbAccess.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			ProjectAssembler.getPreparedStatement(project, stmt);
			stmt.executeUpdate();
			log.debug("created ProjectInfo entry");
		
		} catch (SQLException e) {
			throw new DAOException ("sql.create.exception.projdao",
			e, DAOException.ERROR, true);
		} catch (Exception e) {
			throw new DAOException ("create.exception.projdao",
			e.getCause(),  DAOException.ERROR, true);
 
		} 
	}
	
	//TODO Lena
	/**
	 * Removes a record from the table
	 * @param Connection -  database connection
	 * @param Object - must be an instance of String ,  primary key of the object
	 */
	public boolean remove(Connection conn, Object object) throws DAOException {
           	    
		String sqlStmt = DAOConstants.PROJ_DELETE;
		
		
		if (!(object instanceof String))
			throw new DAOException ("invalid.object.projdao",
					null, DAOException.ERROR, true);
					
		String pk = (String) object;
		
		log.debug("deleting ProjectInfo entry");
		try{
			if (conn == null || conn.isClosed())
				conn = dbAccess.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);
			stmt.setString(1,pk);
			stmt.execute();
			log.debug("deleted ProjectInfo entry");
		} catch (SQLException e) {
			throw new DAOException ("sql.delete.exception.projdao",
			e, DAOException.ERROR, true);
		} catch (Exception e) {
			throw new DAOException ("delete.exception.projdao",
			e.getCause(),  DAOException.ERROR, true);
 
		} 
		return true;
    }
	

	//TODO Lena
	/**
	 * Finds a record from the table
	 * @return Object -  String
	 * @param Object  -  String instance, primary key of the record
	 */
	public Object findByPK(Object object) throws DAOException {
		String sqlStmt = DAOConstants.PROJ_FIND_BYPK;
		ProjectInfo projectReturn = null;

		if (!(object instanceof String))
			throw new DAOException ("invalid.object.projdao",
					null, DAOException.ERROR, true);
					
		String pk = (String) object;				
		Connection conn = null;

			try{
				log.debug("finding pk ProjectInfo entry");
				conn = dbAccess.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlStmt);
				stmt.setString(1, pk);
				ResultSet rs = stmt.executeQuery();
				
				if (rs.next()) {
					projectReturn = ProjectAssembler.getInfo(rs);
				}
				
				rs.close();
				log.debug("found by pk ProjectInfo entry");
			} catch (DBAccessException e) {
				throw new DAOException(e.getMessageKey(), e, DAOException.ERROR,
						true);
			} catch (SQLException e) {
				throw new DAOException("sql.findpk.exception.projdao", e,
						DAOException.ERROR, true);
			}

			catch (Exception ex) {
				System.err.println("error3: " + ex.getMessage());
			} finally {
				try {
					dbAccess.closeConnection(conn);
				} catch (DBAccessException e1) {
				}
			}
			
		return projectReturn;	
	}


	//TODO Vytas
	/**
	 * Finds all records that matches the criteria
	 * @param Object -  instance of ProjectInfo used as search criteria
	 * @return RowSet - rowset of found records
	 */
	

	
	public RowSet find(Object object) throws DAOException {
		
		if (!(object instanceof ProjectInfo))
			throw new DAOException ("invalid.object.projdao",
					null, DAOException.ERROR, true);
			
		
		String sqlstmt = DAOConstants.PROJ_FIND_MAIN;
		//ProjectInfo project = (ProjectInfo) object;
		StatementGenerator stmGen = StatementGeneratorFactory.getGenerator().getStmtGenerator(StatementGenProject.class.getSimpleName());
		
		String sqlWhere=null; 
		try {
			sqlWhere = stmGen.transformStmt(object, DAOConstants.STMT_TYPE_WHERE ); 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		Connection conn = null;

			try{
				log.debug("finding ProjectInfo entry by specified fields");
				conn = dbAccess.getConnection();
				
				sqlstmt = sqlstmt.replaceFirst("@", sqlWhere);

				PreparedStatement stmt = conn.prepareStatement(sqlstmt);

				ResultSet rs = stmt.executeQuery();
								
				CachedRowSet crset = new CachedRowSetImpl();
			    crset.populate(rs);
				
								
				rs.close();
				log.debug("found ProjectInfo entry by specified fields");
				return crset;
				
							
			} catch (DBAccessException e) {
				throw new DAOException(e.getMessageKey(), e, DAOException.ERROR,
						true);
			} catch (SQLException e) {
				System.err.println("error_sql: " + e.getMessage());
				throw new DAOException("sql.findmain.exception.projdao",
						e, DAOException.ERROR, true);
			} finally {
				try {
					dbAccess.closeConnection(conn);
				} catch (DBAccessException e1) {

				}
			}
             
	}


	//TODO Vytas
	/**
	 * @param Connection -
	 *            database connection
	 * @param objSet -
	 *            instance of ProjectInfo, set the new values of a
	 *            particular record
	 * @param objWhere-
	 *            instance of ProjectInfo, used as update criteria
	 * @return boolean - true if record is updated
	 */
	public boolean update(Connection conn, Object objSet, Object objWhere)
			throws DAOException {

		String sqlStmt = DAOConstants.PROJ_UPDATE_MAIN;
		
		StatementGenerator stmGen = StatementGeneratorFactory.getGenerator().getStmtGenerator(StatementGenProject.class.getSimpleName());
		String sqlSet=null;
		String sqlWhere=null; 
		try {
			sqlSet = stmGen.transformStmt(objSet, DAOConstants.STMT_TYPE_SET );
			sqlWhere = stmGen.transformStmt(objWhere, DAOConstants.STMT_TYPE_WHERE ); 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if (!(objSet instanceof ProjectInfo)
				|| !(objWhere instanceof ProjectInfo))
			throw new DAOException("invalid.object.projdao", null,
					DAOException.ERROR, true);

		try {
			log.debug("updating ProjectInfo entry");

			if (conn == null || conn.isClosed())
				conn = dbAccess.getConnection();

			RowSet rset = find(objWhere);
			if (!rset.next())
				return false;
			else {

				
					
				if (sqlWhere.equals(""))
					return true;

				sqlStmt = sqlStmt.replaceFirst("@", sqlSet).replaceFirst("@",
						sqlWhere);

				PreparedStatement stmt = conn.prepareStatement(sqlStmt);

				ResultSet rs = stmt.executeQuery();
					rs.close();
				
			}
			log.debug("updated ProjectInfo entry");
			return true;
		} catch (DBAccessException dbaex) {
			throw new DAOException(dbaex.getMessageKey(), dbaex,
					DAOException.ERROR, true);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("sql.update.exception.projdao",
					e, DAOException.ERROR, true);
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {
		}
	  }

	}

	//TODO Vytas
	public RowSet findByAll() throws DAOException {
		String sqlStmt = DAOConstants.PROJ_FIND_ALL;

		Connection conn = null;
		RowSet returnRowSet = null;

		try {
			log.debug("finding all ProjectInfo entries");
			conn = dbAccess.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);

			ResultSet rs = stmt.executeQuery();

			CachedRowSet crs = new CachedRowSetImpl();
			crs.populate(rs);
			returnRowSet = (RowSet) crs;
			rs.close();

			log.debug("found all ProjectInfo entries");
		} catch (DBAccessException e) {
			throw new DAOException(e.getMessageKey(), e, DAOException.ERROR,
					true);
		} catch (SQLException e) {
			throw new DAOException("sql.findall.exception.projdao",
					e, DAOException.ERROR, true);
		} catch (Exception x) {
			System.err.println("error2: " + x.getMessage());
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {

			} catch (Exception ex) {

			}
		}

		return returnRowSet;
	}

	
	

}
