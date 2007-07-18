/*
 * Created on Dec 3, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
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
import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.logging.LoggerService;
import com.jds.architecture.service.dao.assembler.EmployeeAssembler;
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
 * @author c.b.balajadia 
 * @version  11/2004 initial draft c.b.balajadia
  * @since 1.1
 */
public class EmployeeDAO implements DataAccessObjectInterface {

	private DBAccess dbAccess;
	
	private static Logger log = (Logger) ServiceFactory.getInstance()
	.getService(LoggerService.class);
	
	StatementGenerator stmtGen = null;
	

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
	// need to test!
	public boolean remove(Connection conn, Object object) throws DAOException {
		
		if (!(object instanceof EmployeeInfo))
			throw new DAOException ("invalid.object.empdao",
					null, DAOException.ERROR, true);
		
		
		String sqlstmt = DAOConstants.EMPSQL_DELETE;
		EmployeeInfo employee = (EmployeeInfo) object;
		
		if(employee.equals(null))
			throw new DAOException ("invalid.object.empdao",
					null, DAOException.ERROR, true);
	
		log.debug("removing EmployeeInfo entry");
		try{
			
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			EmployeeAssembler.getPreparedStatement(employee, stmt);
			stmt.executeUpdate();
			log.debug("removing EmployeeInfo entry");
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
			} catch (DBAccessException e){
				throw new DAOException (e.getMessageKey(),
					e, DAOException.ERROR, true);				
			} catch (SQLException e) {
				throw new DAOException ("sql.findpk.exception.empdao",
				e, DAOException.ERROR, true);
			} finally {
				try {
					dbAccess.closeConnection(conn);
				} catch (DBAccessException e1) {

				}
			}

		return employeeReturn;
	
	}


	/**
	 * Finds all records that matches the criteria
	 * @param Object -  instance of EmployeeInfo used as search criteria
	 * @return RowSet - rowset of found records
	 */
	// need to test!
	public RowSet find(Object object) throws DAOException {
		
		String sqlStmt = DAOConstants.EMPSQL_FIND_MAIN;
		EmployeeInfo employeeReturn = null;

		if (!(object instanceof String))
			throw new DAOException ("invalid.object.empdao",
					null, DAOException.ERROR, true);
					
		String checkedFields = (String) object;				
		Connection conn = null;

			try{
				log.debug("finding EmployeeInfo entry by specified fields");
				conn = dbAccess.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlStmt);
				
				stmt.setString(1,checkedFields);
				ResultSet rs = stmt.executeQuery();
				
				if (rs.next()) {
					employeeReturn = EmployeeAssembler.getInfo(rs);
				}
				
				rs.close();
				log.debug("found EmployeeInfo entry by specified fields");
			} catch (DBAccessException e){
				throw new DAOException (e.getMessageKey(),
					e, DAOException.ERROR, true);				
			} catch (SQLException e) {
				throw new DAOException ("sql.findpk.exception.empdao",
				e, DAOException.ERROR, true);
			} finally {
				try {
					dbAccess.closeConnection(conn);
				} catch (DBAccessException e1) {

				}
			}

	return (RowSet)employeeReturn;
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
        
		Connection conn = null;

		try{
			log.debug("finding EmployeeInfo entry by specified fields");
			conn = dbAccess.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				employeeReturn = EmployeeAssembler.getInfo(rs);
			}
			
			rs.close();
			log.debug("found EmployeeInfo entry by specified fields");
		} catch (DBAccessException e){
			throw new DAOException (e.getMessageKey(),
				e, DAOException.ERROR, true);				
		} catch (SQLException e) {
			throw new DAOException ("sql.findpk.exception.empdao",
			e, DAOException.ERROR, true);
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {

			}
		}
		return (RowSet)employeeReturn;
		
    }

}
