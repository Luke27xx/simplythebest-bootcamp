/*
 * Created on Dec 3, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
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

import java.sql.*;
import javax.sql.*; 
import javax.naming.*;
import javax.ejb.*;
 

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.logging.LoggerService;
import com.jds.architecture.service.dao.DAOConstants;

import com.jds.apps.beans.EmployeeInfo;
import com.jds.apps.beans.ProjectInfo;
import com.jds.architecture.service.dao.assembler.EmployeeAssembler;
import com.jds.architecture.service.dao.assembler.ProjectAssembler;
import com.jds.architecture.service.dao.stmtgenerator.StatementGenerator;
import com.jds.architecture.service.dbaccess.DBAccess;
import com.jds.architecture.service.dbaccess.DBAccessException;
import com.sun.rowset.CachedRowSetImpl;



/**
 * <p>
 * EmployeeDAO is data access object class for Employee table
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  11/2004 initial draft c.b.balajadia
  * @since 1.1
 */
public class EmployeeDAO implements DataAccessObjectInterface {

//	private DBAccess dbAccess;
	
//	private static Logger log = (Logger) ServiceFactory.getInstance()
//	.getService(LoggerService.class);
	
//	StatementGenerator stmtGen = null;
	

//	public class EmployeeDAO  implements DataAccessObjectInterface {

		protected String dbDriver;

		protected String dbUrl;

		protected String dbUser;

		protected String dbPassword;

		protected Connection conn;

		private Log log = LogFactory.getLog(ProjectDAO.class);
		private DBAccess dbAccess;

		/**
		 * Constructor
		 * initializes variables
		 * @throws DAOException
		 * @throws DBAccessException
		 */
		public EmployeeDAO(String dbDriver, String dbUrl, String dbUser,
				String dbPassword) throws DAOException, DBAccessException {
			
			this.dbDriver = dbDriver;
			this.dbUrl = dbUrl;
			this.dbUser = dbUser;
			this.dbPassword = dbPassword;

		//	log.info("initializing EmployeeDAO");
		//	dbAccess = DBAccess.getDBAccess();
		//	stmtGen =  StatementGeneratorFactory.
		//		getGenerator().getStmtGenerator(DAOConstants.GEN_EMP);
		
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
	 * Constructor
	 * initializes variables
	 * @throws DAOException
	 * @throws DBAccessException
	 */
	
/*	protected EmployeeDAO() throws DAOException, DBAccessException {
		
		log.info("initializing EmployeeDAO");
		dbAccess = DBAccess.getDBAccess();
		stmtGen =  StatementGeneratorFactory.
			getGenerator().getStmtGenerator(DAOConstants.GEN_EMP);
	

	}	
*/
	/**
	 * Creates or insert new record to the table
	 *@param Connection - database connection
	 *@param Object  - must be an instance of EmployeeInfo,contains object for insert
	 */
		//tested
	public void create(Connection conn, Object object) 
		throws DAOException {

		if (!(object instanceof EmployeeInfo))
			throw new DAOException ("invalid.object.empdao",
					null, DAOException.ERROR, true);
			
		
		String sqlstmt = DAOConstants.EMPSQL_CREATE;
		EmployeeInfo employee = (EmployeeInfo) object;

		if(employee.getEmpNo() == null)
			throw new DAOException ("invalid.object.empdao",
					null, DAOException.ERROR, true);
			
			
		log.debug("creating EmployeeInfo entry");
		try{
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			EmployeeAssembler.getPreparedStatement(employee, stmt);
			stmt.executeUpdate();
			log.debug("created EmployeeInfo entry");
		} catch (SQLException e) {
			throw new DAOException ("sql.create.exception.empdao",
			e, DAOException.ERROR, true);
		} catch (Exception e) {
			throw new DAOException ("create.exception.empdao",
			e.getCause(),  DAOException.ERROR, true);
 
		} 
	}
		
	/**
	 * Removes a record from the table
	 * @param Connection -  database connection
	 * @param Object - must be an instance of String ,  primary key of the object
	 */
	// tested!
	public boolean remove(Connection conn, Object object) throws DAOException {
		
		if (!(object instanceof String))
			throw new DAOException ("invalid.object.empdao",
					null, DAOException.ERROR, true);
	
		String sqlstmt = DAOConstants.EMPSQL_DELETE;
		String pk = (String)object;		
	
		log.debug("removing EmployeeInfo entry by pk");
		try{
			
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);

			stmt.setString(1, pk);
			stmt.executeUpdate();
			
		log.debug("removing EmployeeInfo entry by pk");
		} catch (SQLException e) {
			throw new DAOException ("sql.create.exception.empdao",
			e, DAOException.ERROR, true);
		} catch (Exception e) {
			throw new DAOException ("create.exception.empdao",
			e.getCause(),  DAOException.ERROR, true);
		} 

	return true;
    }

	/**
	 * Finds a record from the table
	 * @return Object -  String
	 * @param Object  -  String instance, primary key of the record
	 */
	//tested
	public Object findByPK(Object object) throws DAOException {
		
		String sqlStmt = DAOConstants.EMPSQL_FIND_BYPK;
		EmployeeInfo employeeReturn = null;

		if (!(object instanceof String))
			throw new DAOException ("invalid.object.empdao",
					null, DAOException.ERROR, true);
					
		String pk = (String) object;				
		Connection conn = null;

			try{
				log.debug("finding pk EmployeeInfo entry");
				//conn = dbAccess.getConnection();
				conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlStmt);
				stmt.setString(1, pk);
				ResultSet rs = stmt.executeQuery();
				
				if (rs.next()) {
					employeeReturn = EmployeeAssembler.getInfo(rs);
				}
				
				rs.close();
				log.debug("found by pk EmployeeInfo entry");
			//} catch (DBAccessException e){
			//	throw new DAOException (e.getMessageKey(),
			//		e, DAOException.ERROR, true);				
			} catch (SQLException e) {
				throw new DAOException ("sql.findpk.exception.empdao",
				e, DAOException.ERROR, true);
			} 
			//finally {
			//	try {
			//		dbAccess.closeConnection(conn);
					close();
			//	} catch (DBAccessException e1) {
			//
			//	}
			//}

		return employeeReturn;
	
	}


	/**
	 * Finds all records that matches the criteria
	 * @param Object -  instance of EmployeeInfo used as search criteria
	 * @return RowSet - rowset of found records
	 */
	// need to test!
	public RowSet find(Object object) throws DAOException {
		
		String sqlStmt = "SELECT * FROM employee WHERE ";
			//DAOConstants.EMPSQL_FIND_MAIN;
		
		EmployeeInfo employeeReturn = null;
		Connection conn = null;
		String checkedFirstName;
		String checkedLastName;

		//String checkedFields = "";
		
		if (!(object instanceof EmployeeInfo))
			throw new DAOException ("invalid.object.empdao",
					null, DAOException.ERROR, true);
			
			EmployeeInfo searchCriteria = new EmployeeInfo();
			searchCriteria = (EmployeeInfo)object;

		if ( searchCriteria.getFirstName() != null) {
				
			sqlStmt += "firstname = " + "'" + searchCriteria.getFirstName() + "'";
					if ( searchCriteria.getLastName() != null)	
						sqlStmt += "and " + "lastname = " + "'" + searchCriteria.getLastName() + "'";
		
		} else if (searchCriteria.getLastName() != null)
			sqlStmt += "lastname = " + "'" +  searchCriteria.getLastName() + "'";
		
		
			log.debug("finding EmployeeInfo entry by specified fields");
			try {
				CachedRowSet crs = new CachedRowSetImpl();	
				conn = getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlStmt);
		
				crs.populate(rs);
				
				rs.close();
			return crs;
			}
			//catch (DBAccessException e){
			//	throw new DAOException (e.getMessageKey(),
			//		e, DAOException.ERROR, true);				
			//		} 
			catch (SQLException e) {
				throw new DAOException ("sql.find.exception.empdao",
				e, DAOException.ERROR, true);
			}
			finally {
				close();
			}
					//	try {
			//		dbAccess.closeConnection(conn);
			//	} catch (DBAccessException e1) {

			//		}
			//	}
	}



	/**
	 * @param Connectin - database connection
	 * @param ObjectSet - instance of EmployeeInfo, set the new values of a particular record
	 * @param objWher- instance of EmployeeInfo, used as update criteria
	 * @return boolean - true if record is updated
	 */
	public boolean update(Connection conn, Object objSet, Object objWhere) 
		throws DAOException{
	
		if (!(objSet instanceof EmployeeInfo && objWhere instanceof EmployeeInfo))
			throw new DAOException ("invalid.object.empdao",
					null, DAOException.ERROR, true);
		
		
		String sqlstmt = DAOConstants.EMPSQL_UPDATE;
		EmployeeInfo employee = (EmployeeInfo) objWhere;
		EmployeeInfo employeeChanges = (EmployeeInfo)objSet;
		
		if(employee.equals(null))
			throw new DAOException ("invalid.object.empdao",
					null, DAOException.ERROR, true);
	
		log.debug("updating EmployeeInfo entry");
		try{
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			
			EmployeeAssembler.getPreparedStatement(employee, stmt);
			stmt.executeUpdate();
			EmployeeAssembler.getPreparedStatement(employeeChanges, stmt);
			stmt.executeUpdate();
			
			log.debug("created EmployeeInfo entry");
		} catch (SQLException e) {
			throw new DAOException ("sql.create.exception.empdao",
			e, DAOException.ERROR, true);
		} catch (Exception e) {
			throw new DAOException ("create.exception.empdao",
			e.getCause(),  DAOException.ERROR, true);
 
		}
	
			
	    
        return false;
		
	}

	//need to test!
    public RowSet findByAll() throws DAOException {
        
		String sqlStmt = DAOConstants.EMPSQL_FIND_ALL;
		EmployeeInfo employeeReturn = null;
		CachedRowSet crset;
		Connection conn = null;

		try{
			log.debug("finding EmployeeInfo ");
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);
			
			ResultSet rs = stmt.executeQuery();
			
			
			if (rs.next()) {
				employeeReturn = EmployeeAssembler.getInfo(rs);
			
				
			}
			crset.populate(rs);
			rs.close();
			log.debug("found EmployeeInfo entry by specified fields");
		} catch (SQLException e) {
			throw new DAOException ("sql.findpk.exception.empdao",
			e, DAOException.ERROR, true);
		} finally {
			close();
		}
		return (RowSet)employeeReturn;
		
    }

}

	
