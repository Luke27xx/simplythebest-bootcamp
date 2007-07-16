/*
 * Created on Dec 9, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.architecture.service.dbaccess;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.ConnectionPoolDataSource;
import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.logging.LoggerService;
import com.jds.architecture.properties.PropertiesMonitorService;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;

/**
 * <p>
 * OracleDBAccess is an class DBAccess connection using JNDI lookup.
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  01/2004 initial draft c.b.balajadia
 * @since 1.1
 */
public class OracleDBAccess implements DBAccessInterface {

	private static String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String USER_ID = "cathy";
	private static String PASSWORD = "cathy";
	private static Logger log = (Logger)ServiceFactory.getInstance()
	.getService(LoggerService.class);
	private static PropertiesMonitorService pm = (PropertiesMonitorService)ServiceFactory.getInstance()
	.getService(PropertiesMonitorService.class);
	private OracleConnectionPoolDataSource ds = null;
	
	/**
	 * Constructor
	 * @throws DBAccessException
	 */
	protected OracleDBAccess() throws DBAccessException {	
		dbConnect();
	}

	/**
	 * gets ConnectionPoolDataSource from the database
	 * @return ConnectionPoolDataSource - pooled datasource 
	 */
	public ConnectionPoolDataSource getDataSource () throws DBAccessException {
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
	 * Not yet implemented in HRS 2.0
	 */
	public void reconnect() throws DBAccessException {
		dbConnect();
	}

	/**
	 * retrieves database constants from dbaccess property files 
	 * and connects to database via OracleDriver
	 */
	public void dbConnect() throws DBAccessException {
		try{
			log.info("initializing OracleDBAccess connection");
			if (pm.getProperty("dbaccess", "oracle.jdbc.url") != null)
				JDBC_URL = pm.getProperty("dbaccess", "oracle.jdbc.url");
			if (pm.getProperty("dbaccess", "oracle.jdbc.user.id")!= null)
				USER_ID = pm.getProperty("dbaccess", "oracle.jdbc.user.id");
			if (pm.getProperty("dbaccess", "oracle.jdbc.password")!= null)
				PASSWORD = pm.getProperty("dbaccess", "oracle.jdbc.password");
			ds = new OracleConnectionPoolDataSource();
			ds.setURL(JDBC_URL);
			ds.setUser(USER_ID);
			ds.setPassword(PASSWORD);
			log.info("initialized OracleDBAccess connection:" + JDBC_URL );
			
		} catch (SQLException e) {
			throw new DBAccessException ("dbaccess.sql.connection.exception",e.getCause(),
				DBAccessException.ERROR, true);
		
		} catch (Exception e) {
			throw new DBAccessException ("dbaccess.oracle.connection.exception",e.getCause(),
				DBAccessException.ERROR, true);

		}
		
	}

}
