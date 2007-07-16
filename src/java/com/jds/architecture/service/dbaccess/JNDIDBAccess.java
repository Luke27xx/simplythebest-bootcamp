/*
 * Created on Dec 9, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.architecture.service.dbaccess;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;

import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.logging.LoggerService;
import com.jds.architecture.properties.PropertiesMonitorService;



/**
 * <p>
 * JNDIDBAccess is an class DBAccess connection using JNDI lookup.
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  01/2004 initial draft c.b.balajadia
 * @since 1.1
 */
public class JNDIDBAccess implements DBAccessInterface {

	private static String JAVA_URL = "java:/comp/env/";
	private static String JDBC_URL = "jdbc/HRDB";
	private static String USERNAME = "hruser";
	private static String PASSWORD = "hruser";
	private static String URL = JAVA_URL + JDBC_URL;
	private static Logger log = (Logger)ServiceFactory.getInstance()
	.getService(LoggerService.class);
	private static PropertiesMonitorService pm = (PropertiesMonitorService)ServiceFactory.getInstance()
	.getService(PropertiesMonitorService.class);
	private Connection conn = null;
	private DataSource ds = null;
	
	/**
	 * Constructor
	 * @throws DBAccessException
	 */
	protected JNDIDBAccess() throws DBAccessException {
		dbConnect();
	}
	
	/**
	 * Returns null since connection does not use direct DataSource access
	 */
	public ConnectionPoolDataSource getDataSource () throws DBAccessException {
		return null;
	}

	/**
	 * gets connection from the database
	 * @return Connection - database connection 
	 */
	public Connection getConnection() throws DBAccessException {
		try{
			conn = ds.getConnection(USERNAME, PASSWORD);
		} catch (SQLException e) {
			throw new DBAccessException ("dbaccess.jndi.connection.exception",e.getCause(),
				DBAccessException.ERROR, true);
		}
		return conn;
	}

	/**
	 * Not yet implemented in HRS 2.0
	 */
	public void reconnect() throws DBAccessException {
		dbConnect();	
	}


	/**
	 * retrieves database constants from dbaccess property files 
	 * and lookups for the database resource
	 */
	public void dbConnect() throws DBAccessException {
		try{
			log.info("initializing JNDIDBAccess connection");
			if (pm.getProperty("dbaccess", "java.url.variable")!= null)
				JAVA_URL = pm.getProperty("dbaccess", "java.url.variable");
			if (pm.getProperty("dbaccess", "jdbc.url")!= null)
				JDBC_URL = pm.getProperty("dbaccess", "jdbc.url");
			if (pm.getProperty("dbaccess", "jdbc.username")!= null)
				USERNAME = pm.getProperty("dbaccess", "jdbc.username");
			if (pm.getProperty("dbaccess", "jdbc.password")!= null)
				PASSWORD = pm.getProperty("dbaccess", "jdbc.password");			
			
			Context initContext = new InitialContext();
			ds = (DataSource)initContext.lookup(URL);
			log.info("initialized JNDIDBAccess connection:" + URL);
		} catch (NamingException e) {
			throw new DBAccessException ("dbaccess.naming.exception",e.getCause(),
				DBAccessException.ERROR, true);
		} catch (Exception e) {
			throw new DBAccessException ("dbaccess.jndi.connection.exception",e.getCause(),
				DBAccessException.ERROR, true);
		}
	}
	
	
}
