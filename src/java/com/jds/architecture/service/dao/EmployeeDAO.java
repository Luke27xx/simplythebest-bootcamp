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

//import com.jds.apps.beans.AccentureDetails;
import com.jds.apps.beans.EmployeeInfo;
//import com.jds.apps.beans.ProjectInfo;
//import com.jds.architecture.service.dao.assembler.AccentureDetailsAssembler;
import com.jds.architecture.service.dao.assembler.EmployeeAssembler;
import com.jds.architecture.service.dao.assembler.ProjectAssembler;
import com.jds.architecture.service.dao.stmtgenerator.StatementGenEmployee;
import com.jds.architecture.service.dao.stmtgenerator.StatementGenerator;
import com.jds.architecture.service.dao.stmtgenerator.StatementGeneratorFactory;
import com.jds.architecture.service.dbaccess.DBAccess;
import com.jds.architecture.service.dbaccess.DBAccessException;
import com.sun.rowset.CachedRowSetImpl;



/**
 * <p>
 * EmployeeDAO is data access object class for Employee table
 * </p> 
 * 
 *  							
 * @author Vadim Kuznecov , Ilja Taran
 * @version  11/2004 initial draft c.b.balajadia
  * @since 1.1
 */
public class EmployeeDAO implements DataAccessObjectInterface {


	
	private static Logger log = (Logger) ServiceFactory.getInstance()
	.getService(LoggerService.class);
	
	StatementGenerator stmtGen = null;
	

		protected Connection conn;
		private DBAccess dbAccess;


	/**
	 * Constructor
	 * initializes variables
	 * @throws DAOException
	 * @throws DBAccessException
	 */

	protected EmployeeDAO() throws DAOException, DBAccessException {
		
		log.info("initializing EmployeeDAO");
		dbAccess = DBAccess.getDBAccess();
		stmtGen =  StatementGeneratorFactory.
			getGenerator().getStmtGenerator(DAOConstants.GEN_EMP);
	

	}	

	
	/**
	 * Creates or insert new record to the table
	 *@param Connection - database connection
	 *@param Object  - must be an instance of EmployeeInfo,contains object for insert
	 */
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
			if (conn == null || conn.isClosed()) 
				conn = dbAccess.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			EmployeeAssembler.getPreparedStatement(employee, stmt);
			
			stmt.executeUpdate();
			stmt.close();
			log.debug("created EmployeeInfo entry");
		} catch (SQLException e) {
			throw new DAOException ("sql.create.exception.empdao",
			e, DAOException.ERROR, true);
		} catch (Exception e) {
			throw new DAOException ("create.exception.empdao",
			e.getCause(),  DAOException.ERROR, true);
		} finally {
			try {
				dbAccess.closeConnection(conn);
		} catch (DBAccessException e) {
			e.printStackTrace();
			}
		 }
	}
		
	
	/**
	 * Removes a record from the table
	 * @param Connection -  database connection
	 * @param Object - must be an instance of String ,  primary key of the object
	 */
	public boolean remove(Connection conn, Object object) throws DAOException {
		
		if (!(object instanceof String))
			throw new DAOException ("invalid.object.empdao",
					null, DAOException.ERROR, true);
	
		String sqlstmt = DAOConstants.EMPSQL_DELETE;
		String pk = (String)object;		
	
		log.debug("removing EmployeeInfo entry by pk");
		try{
			if (conn == null || conn.isClosed()) 
				conn = dbAccess.getConnection();
			
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
		}  finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (Exception e1) {
				e1.printStackTrace();
				
			}
		}

	return true;
    }

	
	/**
	 * Finds a record from the table
	 * @return Object -  String
	 * @param Object  -  String instance, primary key of the record
	 */
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
				conn = dbAccess.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlStmt);
				stmt.setString(1, pk);
				ResultSet rs = stmt.executeQuery();
				
				if (rs.next()) {
					employeeReturn = EmployeeAssembler.getInfo(rs);
				}
				
				rs.close();
				log.debug("found by pk EmployeeInfo entry");

			
			} catch (SQLException e) {
				throw new DAOException ("sql.findpk.exception.empdao",
				e, DAOException.ERROR, true);
			} catch (DBAccessException e) {
				e.printStackTrace();
			}

			finally {
					try {
						dbAccess.closeConnection(conn);
					} catch (DBAccessException e) {
						e.printStackTrace();
					}
				}
	return employeeReturn;
	}


	/**
	 * Finds all records that matches the criteria
	 * @param Object -  instance of EmployeeInfo used as search criteria
	 * @return RowSet - rowset of found records
	 */
	public RowSet find(Object object) throws DAOException {
		
		String sqlStmt = "SELECT * FROM employee WHERE ";
			
		EmployeeInfo employeeReturn = null;
		Connection conn = null;
		String checkedFirstName;
		String checkedLastName;

		if (!(object instanceof EmployeeInfo))
			throw new DAOException ("invalid.object.empdao",
					null, DAOException.ERROR, true);
			
			EmployeeInfo searchCriteria = new EmployeeInfo();
			searchCriteria = (EmployeeInfo)object;

		if ( searchCriteria.getFirstName() != null  ) {
				
			sqlStmt += "firstname LIKE " + "'" + searchCriteria.getFirstName() + "'";
					if ( searchCriteria.getLastName() != null )	
						sqlStmt += "and " + "lastname LIKE " + "'" + searchCriteria.getLastName() + "'";
		
		} else if (searchCriteria.getLastName() != null  )
			sqlStmt += "lastname LIKE " + "'" +  searchCriteria.getLastName() + "'";
		
		
			log.debug("finding EmployeeInfo entry by specified fields");
			try {
				CachedRowSet crs = new CachedRowSetImpl();	
				conn = dbAccess.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlStmt);
		
				crs.populate(rs);
				
				rs.close();
			return crs;
			}
			catch (DBAccessException e){
				throw new DAOException (e.getMessageKey(),
					e, DAOException.ERROR, true);				
					} 
			catch (SQLException e) {
				throw new DAOException ("sql.find.exception.empdao",
				e, DAOException.ERROR, true);
			}
			finally {
				try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {
				 	e1.printStackTrace();
					}
			}
	}

	/**
	 * @param Connectin - database connection
	 * @param ObjectSet - instance of EmployeeInfo, set the new values of a particular record
	 * @param objWher- instance of EmployeeInfo, used as update criteria
	 * @return boolean - true if record is updated
	 */
	public boolean update(Connection conn, Object objSet, Object objWhere) 
		throws DAOException{
	
		String sqlStmt = DAOConstants.EMPSQL_UPDATE;
		StatementGenEmployee temp = new StatementGenEmployee();
		
		if (!(objSet instanceof EmployeeInfo)
				|| !(objWhere instanceof EmployeeInfo))
			throw new DAOException("invalid.object.accdao", null,
					DAOException.ERROR, true);

		try {
			RowSet rset = find(objWhere);

			if (conn == null || conn.isClosed()) 
				conn = dbAccess.getConnection();
			
			String setField = temp.transformStmt(objSet, 1);
			String whereField = temp.transformStmt(objWhere, 2);
			

				sqlStmt = sqlStmt.replaceFirst("@", setField);
				sqlStmt = sqlStmt.replaceFirst("@", whereField);
				
					
				PreparedStatement stmt = conn.prepareStatement(sqlStmt);
						
				ResultSet rs = stmt.executeQuery();
				rs.close();

		log.debug("updated AccentureDetails entry");
		return true;
		
		} catch (SQLException e1) {
			e1.printStackTrace(); 
			
		} catch (DBAccessException e){
				throw new DAOException (e.getMessageKey(),
					e, DAOException.ERROR, true);				
		} catch ( Exception e2) {
			 e2.printStackTrace();
		}
		
		finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {

			}
		}

	return false;	
	}

	
	/**
	 * Finds all entries from employee table
	 */
    public RowSet findByAll() throws DAOException {
        
		String sqlStmt = DAOConstants.EMPSQL_FIND_ALL;
		Connection conn = null;
		
		log.debug("finding EmployeeInfo ");
		try{
			 conn = dbAccess.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);
			
			ResultSet rs = stmt.executeQuery();
	
			CachedRowSet crset = new CachedRowSetImpl();	
			crset.populate(rs);
			rs.close();
		return crset;
		} catch (DBAccessException e){
			throw new DAOException (e.getMessageKey(),
				e, DAOException.ERROR, true);				
				}
		 catch (SQLException e) {
			throw new DAOException ("sql.findall.exception.empdao",
			e, DAOException.ERROR, true);
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {
				
			}
		}
    }

    

    
}


	
