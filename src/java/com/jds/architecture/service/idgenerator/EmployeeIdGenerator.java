/*
 * Created on Feb 9, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.service.idgenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.service.dbaccess.DBAccess;
import com.jds.architecture.service.dbaccess.DBAccessException;
import com.jds.architecture.service.transaction.TransactionException;

/**
 * <p>
 * EmployeeIdGenerator is a IdGenerator class for Employee.
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  02/2004 initial draft c.b.balajadia
  * @since 1.1
 */
public class EmployeeIdGenerator implements IdGeneratorInterface{

	private static EmployeeIdGenerator  idGen = null;
	private String genID = "select seq_employee.nextval from dual";
	private Statement stmt = null;
	private Connection conn = null;
	private ResultSet rs = null;
	private Logger logger = (Logger) ServiceFactory.getInstance()
	.getService(EmployeeIdGenerator.class);
	
	private EmployeeIdGenerator() {}
	
	/**
	 * Gets the instance of this class
	 * @return EmployeeIdGenerator
	 */
	public static EmployeeIdGenerator getInstance(){
		if (idGen == null) {
			idGen = new EmployeeIdGenerator();
		}
		return idGen;
	}
	
	/**
	 * Gets the next id for Employee table
	 * @return long -  generated id
	 */
	public long getNextId() throws IdGeneratorException {
		long id = 0;
		try {
			conn =  DBAccess.getDBAccess().getConnection();
		} catch (DBAccessException e) {
			logger.error("database connection error in id generator");
			throw new IdGeneratorException
			("connection.acquire.exception",e.getCause(),
			TransactionException.ERROR, true);
		}
		try {
			stmt = conn.createStatement();
		      rs = stmt.executeQuery(genID);
		      rs.next();
		      id = rs.getLong(1);
		      rs.close();
		      stmt.close();
		} catch (SQLException e) {
			throw new IdGeneratorException
			("id.generation.exception",e.getCause(),
					TransactionException.ERROR, true);
		} finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	    return id;

		
	}
}
