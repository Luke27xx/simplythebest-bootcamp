/*
 * Created on Dec 28, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.architecture.service.dbaccess;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.ConnectionPoolDataSource;
import oracle.jdbc.pool.OracleOCIConnectionPool;

import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.logging.LoggerService;
import com.jds.architecture.properties.PropertiesMonitorService;


/**
 * <p>
 * OracleDBAccess is an class DBAccess connection using OCI.
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  01/2004 initial draft c.b.balajadia
 * @since 1.1
 */
public class OracleOCIDBAccess  implements DBAccessInterface {

	private static String JDBC_URL = "jdbc:oracle:oci:@ORCL";
	private static String USER_ID = "hruser";
	private static String PASSWORD = "hruser";
	private static Logger log = (Logger)ServiceFactory.getInstance()
	.getService(LoggerService.class);
	private static PropertiesMonitorService pm = (PropertiesMonitorService)ServiceFactory.getInstance()
	.getService(PropertiesMonitorService.class);
	OracleOCIConnectionPool cpool = null;
	
	/**
	 * constructor
	 * @throws DBAccessException
	 */
	protected OracleOCIDBAccess() throws DBAccessException {
		dbConnect();
	}

	/**
	 * retrieves database constants from dbaccess property files 
	 * and connect to database using oracle client interface
	 */
	public void dbConnect() throws DBAccessException {
		try{
			log.info("initializing OracleOCIDBAccess connection");
			if(pm.getProperty("dbaccess", "oracle.jdbc.url") != null)
				JDBC_URL = pm.getProperty("dbaccess", "oracle.jdbc.url");
			if(pm.getProperty("dbaccess", "oracle.jdbc.user.id") != null)
				USER_ID = pm.getProperty("dbaccess", "oracle.jdbc.user.id");
			if(pm.getProperty("dbaccess", "oracle.jdbc.password") != null)
				PASSWORD = pm.getProperty("dbaccess", "oracle.jdbc.password");
			cpool = new OracleOCIConnectionPool();
			cpool.setURL(JDBC_URL);
			cpool.setUser(USER_ID);
			cpool.setPassword(PASSWORD);
			log.info("initialized OracleOCIDBAccess connection:" + JDBC_URL );
		} catch (SQLException e) {
			throw new DBAccessException ("dbaccess.sql.connection.exception",e.getCause(),
				DBAccessException.ERROR, true);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBAccessException ("dbaccess.oracle.connection.exception",e.getCause(),
				DBAccessException.ERROR, true);

		}
	
	}

	/**
	 * Returns null since this class uses database connection via oci
	 */
	public ConnectionPoolDataSource getDataSource() throws DBAccessException {
		return null;
	}

	/**
	 * Returns database connection from oci connection pool
	 * @return Connection -  database connection
	 */
	public Connection getConnection() throws DBAccessException {
		
		Connection conn = null;
		
		try{
			conn = cpool.getConnection();
		} catch(SQLException e) {
			throw new DBAccessException ("dbaccess.getconnection.sql.exception",
			e.getCause(), DBAccessException.ERROR, true);
		}

		return conn;
	}

	/**
	 * not yet implement in HRS 2.0
	 */
	public void reconnect() throws DBAccessException {
		dbConnect();
	}



}
