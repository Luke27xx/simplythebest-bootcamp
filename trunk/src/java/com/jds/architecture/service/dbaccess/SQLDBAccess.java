/*
 * Created on Dec 26, 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.jds.architecture.service.dbaccess;

import java.sql.Connection;

import javax.sql.ConnectionPoolDataSource;

import net.sourceforge.jtds.jdbcx.JtdsDataSource;

import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.logging.LoggerService;
import com.jds.architecture.properties.PropertiesMonitorService;

/**
 * <p>
 * SQLDBAccess is an class DBAccess connection to SQLServer.
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  01/2004 initial draft c.b.balajadia
 * @since 1.1
 */
public class SQLDBAccess implements DBAccessInterface {
	private static Logger log = (Logger)ServiceFactory.getInstance()
	.getService(LoggerService.class);
	private static PropertiesMonitorService pm = (PropertiesMonitorService)ServiceFactory.getInstance()
	.getService(PropertiesMonitorService.class);
	
	private String databaseDriver = "net.sourceforge.jtds.jdbc.Driver";
	private String databaseUser = "sa";
	private String databasePassword = "sa";
	private String databaseHost = "localhost";
	private String databaseName = "hr_user";
	private int databaseType = 1;
	private int databasePort = 1433;
	private JtdsDataSource ds = null;
	
	/**
	 * constructor
	 * @throws DBAccessException
	 */
	protected SQLDBAccess() throws DBAccessException {	
		dbConnect();
	}

												 
	/**
	 * gets ConnectionPoolDataSource from the database
	 * @return ConnectionPoolDataSource - pooled datasource 
	 */
	public ConnectionPoolDataSource getDataSource() throws DBAccessException {
		return ds;		
	}



	/**
	 * Returns null since connection does not use direct DataSource access
	 */
	public Connection getConnection() throws DBAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * not yet implemented
	 */
	public void reconnect() throws DBAccessException {
		dbConnect();
	}


	/**
	 * retrieves database constants from dbaccess property files 
	 * and connects to database SQLServer
	 */
	public void dbConnect() throws DBAccessException {

		try{
			log.info("initializing SQLDBAccess connection");
			if (pm.getProperty("dbaccess", "sql.jdbc.driver")!= null)
				databaseDriver = pm.getProperty("dbaccess", "sql.jdbc.driver");
			if (pm.getProperty("dbaccess", "sql.jdbc.user")!= null)
				databaseUser = pm.getProperty("dbaccess", "sql.jdbc.user");
			if (pm.getProperty("dbaccess", "sql.jdbc.password")!= null)
				databasePassword = pm.getProperty("dbaccess", "sql.jdbc.password");
			if (pm.getProperty("dbaccess", "sql.jdbc.host")!= null)
				databaseHost = pm.getProperty("dbaccess", "sql.jdbc.host");
			if (pm.getProperty("dbaccess", "sql.jdbc.database")!= null)
				databaseName = pm.getProperty("dbaccess", "sql.jdbc.database");
			
			if (pm.getProperty("dbaccess", "sql.jdbc.servertype") != null)
				databaseType = Integer.parseInt(pm.getProperty("dbaccess", "sql.jdbc.servertype"));
			
			if (pm.getProperty("dbaccess", "sql.jdbc.port") != null)
				databasePort = Integer.parseInt(pm.getProperty("dbaccess", "sql.jdbc.port"));
			
			ds = new JtdsDataSource();
			ds.setUser(databaseUser);
			ds.setPassword(databasePassword);
			ds.setDatabaseName(databaseName);
			ds.setServerName(databaseHost);
			ds.setServerType(databaseType);
			ds.setPortNumber(databasePort);
			
			log.info("returning SQLDBAccess data source:" );
		} catch (Exception e) {			
			e.printStackTrace();
			throw new DBAccessException ("dbaccess.oracle.connection.exception",e.getCause(),
				DBAccessException.ERROR, true);

		}
		
	}

}
