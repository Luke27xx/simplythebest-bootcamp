package java.com.jds.architecture.service.dao;

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
import java.com.jds.architecture.service.dao.DAOConstants;

import java.com.jds.apps.beans.EmployeeInfo;
import java.com.jds.apps.beans.ProjectInfo;
import java.com.jds.architecture.service.dao.assembler.EmployeeAssembler;
import java.com.jds.architecture.service.dao.assembler.ProjectAssembler;
import java.com.jds.architecture.service.dbaccess.DBAccess;
import java.com.jds.architecture.service.dbaccess.DBAccessException;

public class ProjectDAO  implements DataAccessObjectInterface {

	protected String dbDriver;

	protected String dbUrl;

	protected String dbUser;

	protected String dbPassword;

	protected Connection conn;

	private Log log = LogFactory.getLog(ProjectDAO.class);
	private DBAccess dbAccess;

	/**
	 * In a more realistic example connections are obtained from a connection
	 * pool
	 */
	public ProjectDAO(String dbDriver, String dbUrl, String dbUser,
			String dbPassword) {
		this.dbDriver = dbDriver;
		this.dbUrl = dbUrl;
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
	}

	/**
	 * Make sure that connection is open for this DAO object
	 * @throws DAOException 
	 */
	public void reconnect() throws DAOException {
		try {
			if (conn == null || conn.isClosed()) {
				Class.forName(dbDriver);
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			}
		} catch (Exception e) {
			log.error("Could not initialize UrlDAO", e);
			throw new DAOException("Could not initialize UrlDAO", e);
		}

	}

	/**
	 * Free any resources
	 * @throws DAOException 
	 */
	public void close() throws DAOException {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				log.error("Could not close connection", e);
				throw new DAOException("Could not close connection", e);
			}
			conn = null;
		}
	}

	public Connection getConnection() {
		return conn;
	}

	/**
	 * Creates or insert new record to the table
	 *@param Connection - database connection
	 *@param Object  - must be an instance of EmployeeInfo,contains object for insert
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
			
			
		log.debug("creating EmployeeInfo entry");
		try{
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			ProjectAssembler.getPreparedStatement(project, stmt);
			stmt.executeUpdate();
			log.debug("created EmployeeInfo entry");
		} catch (SQLException e) {
			throw new DAOException ("sql.create.exception.projdao",
			e, DAOException.ERROR, true);
		} catch (Exception e) {
			throw new DAOException ("create.exception.projdao",
			e.getCause(),  DAOException.ERROR, true);
 
		} 
	}
	
	
	/**
	 * Removes a record from the table
	 * @param Connection -  database connection
	 * @param Object - must be an instance of String ,  primary key of the object
	 */
	public boolean remove(Connection conn, Object object) throws DAOException {

				
		if (!(object instanceof ProjectInfo))
			throw new DAOException ("invalid.object.projdao",
					null, DAOException.ERROR, true);
		
		
		String sqlstmt = DAOConstants.PROJ_DELETE;
		ProjectInfo project = (ProjectInfo) object;
		
		if(project.equals(null))
			throw new DAOException ("invalid.object.projdao",
					null, DAOException.ERROR, true);
	
		log.debug("removing ProjectInfo entry");
		try{
			
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			ProjectAssembler.getPreparedStatement(project, stmt);
			stmt.executeUpdate();
			log.debug("removing ProjectInfo entry");
		} catch (SQLException e) {
			throw new DAOException ("sql.create.exception.projdao",
			e, DAOException.ERROR, true);
		} catch (Exception e) {
			throw new DAOException ("create.exception.projdao",
			e.getCause(),  DAOException.ERROR, true);
 
		} 
    return true;		
    }

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
				log.debug("finding pk EmployeeInfo entry");
				conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlStmt);
				stmt.setString(1, pk);
				ResultSet rs = stmt.executeQuery();
				
				if (rs.next()) {
					projectReturn = ProjectAssembler.getInfo(rs);
				}
				
				rs.close();
				log.debug("found by pk EmployeeInfo entry");
			} catch (SQLException e) {
				throw new DAOException ("sql.findpk.exception.projdao",
				e, DAOException.ERROR, true);
			} finally {
				
					close();
				}
			
		return projectReturn;	
	}


	/**
	 * Finds all records that matches the criteria
	 * @param Object -  instance of EmployeeInfo used as search criteria
	 * @return RowSet - rowset of found records
	 */
	public RowSet find(Object object) throws DAOException {

		String sqlStmt = DAOConstants.PROJ_FIND_MAIN;
		ProjectInfo projectReturn = null;

		if (!(object instanceof String))
			throw new DAOException ("invalid.object.projdao",
					null, DAOException.ERROR, true);
					
		String checkedFields = (String) object;				
		Connection conn = null;

			try{
				log.debug("finding ProjectInfo entry by specified fields");
				conn = dbAccess.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlStmt);
				
				stmt.setString(1,checkedFields);
				ResultSet rs = stmt.executeQuery();
				
				if (rs.next()) {
					projectReturn = ProjectAssembler.getInfo(rs);
				}
				
				rs.close();
				log.debug("found ProjectInfo entry by specified fields");
			} catch (DBAccessException e){
				throw new DAOException (e.getMessageKey(),
					e, DAOException.ERROR, true);				
			} catch (SQLException e) {
				throw new DAOException ("sql.findpk.exception.projdao",
				e, DAOException.ERROR, true);
			} finally {
				try {
					dbAccess.closeConnection(conn);
				} catch (DBAccessException e1) {

				}
			}

	return (RowSet)projectReturn;
	}



	/**
	 * @param Connectin - database connection
	 * @param ObjectSet - instance of EmployeeInfo, set the new values of a particular record
	 * @param objWher- instance of EmployeeInfo, used as update criteria
	 * @return boolean - true if record is updated
	 */
	public boolean update(Connection conn, Object objSet, Object objWhere) 
		throws DAOException{
	
		if (!(objSet instanceof ProjectInfo && objWhere instanceof ProjectInfo))
			throw new DAOException ("invalid.object.projdao",
					null, DAOException.ERROR, true);
		
		
		String sqlstmt = DAOConstants.EMPSQL_UPDATE;
		ProjectInfo project = (ProjectInfo) objWhere;
		ProjectInfo projectChanges = (ProjectInfo)objSet;
		
		if(project.equals(null))
			throw new DAOException ("invalid.object.projdao",
					null, DAOException.ERROR, true);
	
		log.debug("updating ProjectInfo entry");
		try{
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			
			ProjectAssembler.getPreparedStatement(project, stmt);
			stmt.executeUpdate();
			ProjectAssembler.getPreparedStatement(projectChanges, stmt);
			stmt.executeUpdate();
			
			log.debug("created EmployeeInfo entry");
		} catch (SQLException e) {
			throw new DAOException ("sql.create.exception.projdao",
			e, DAOException.ERROR, true);
		} catch (Exception e) {
			throw new DAOException ("create.exception.projdao",
			e.getCause(),  DAOException.ERROR, true);
 
		}
	
			
	    
        return false;
		
	}

    public RowSet findByAll() throws DAOException {
        
    	String sqlStmt = DAOConstants.PROJ_FIND_ALL;
		ProjectInfo projectReturn = null;
        
		Connection conn = null;

		try{
			log.debug("finding EmployeeInfo entry by specified fields");
			conn = dbAccess.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				projectReturn = ProjectAssembler.getInfo(rs);
			}
			
			rs.close();
			log.debug("found EmployeeInfo entry by specified fields");
		} catch (DBAccessException e){
			throw new DAOException (e.getMessageKey(),
				e, DAOException.ERROR, true);				
		} catch (SQLException e) {
			throw new DAOException ("sql.findpk.exception.projdao",
			e, DAOException.ERROR, true);
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {

			}
		}
		return (RowSet)projectReturn;
		
    }

	
	

}
