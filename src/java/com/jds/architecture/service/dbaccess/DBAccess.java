/*
 * Created on Dec 5, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.architecture.service.dbaccess;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;
import com.jds.architecture.*;
import com.jds.architecture.logging.LoggerService;
import com.jds.architecture.properties.PropertiesMonitorService;
import com.jds.architecture.service.dao.DAOConstants;
import com.jds.architecture.service.listener.DBAccessListener;
//import accenture.manila.architecture.service.listener.DBAccessDefaultTask;

/**
 * <p>
 * DBAccess is a class that provides database connection and connection transaction.
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  11/2004 initial draft c.b.balajadia
 * @version  12/2004 added facility for OracleOCIDBAccess connection and set OracleOCIDBAccess as default - c.b.balajadia
 * @version  02/2005 prepared dbaccess for listener - c.b.balajadia
 * @since 1.1
 */
public class DBAccess {

	private static DBAccess db = null;
	private DBAccessInterface dbAccess = null;
	private PooledConnection pConn = null;
	protected String CONN_TYPE = "OracleOCIDBAccess";
	private static Logger log = (Logger)ServiceFactory.getInstance()
		.getService(LoggerService.class);
	private static PropertiesMonitorService pm = (PropertiesMonitorService)ServiceFactory.getInstance()
	.getService(PropertiesMonitorService.class);

	private boolean isResourceBased = false;
	private DBAccessListener listener = null;
	private Connection conn = null;
			
	public static DBAccess getDBAccess() throws DBAccessException {
		if (db == null) {
			db = new DBAccess();
			if (pm.getProperty("dbaccess",
			 "jdbc.connection.type") != null)
				db.CONN_TYPE = pm.getProperty("dbaccess",
					"jdbc.connection.type");
			log.info("initializing DBAccess connection " + db.CONN_TYPE);
			db.initializeConnection(db.CONN_TYPE);
			//db.setListener(new DBAccessListener());
		}
		return db;
		
	}
	
	/**
	 * This method is not yet implemented.
	 * Prepared for tables in multiple database 
	 * @param newDatabase -  database connection type
	 * @throws DBAccessException -  throw error when failed reinitialize connection
	 */
	//public void changeDatabase(String newDatabase) throws DBAccessException{
	//	db.CONN_TYPE = newDatabase;
	//	db.initializeConnection(db.CONN_TYPE);
	//}
	
	/**
	 * Returns database connection type
	 * @return String - databae connection type
	 */
	public String getConnectionType(){
		return this.CONN_TYPE;
	}
	
	/**
	 * Initializes databse connection
	 * @param connType -  database connection type
	 * @throws DBAccessException - thrown when failed to connect to database
	 */
	private void initializeConnection (String connType) throws DBAccessException {
		try{
			dbAccess = DBAccessFactory.getFactory().
				getDAOInstance(connType);
			
			if (connType.equalsIgnoreCase(DAOConstants.CONN_JNDI))
				isResourceBased = true;
			
		} catch(Exception e) {
			throw new DBAccessException ("dbaccess.initialize.exception",
				e.getCause(), DBAccessException.ERROR, true);
		}
		
		
	}
	
	/**
	 * Not yet implemented
	 * Sets the database listener that will be used
	 * @param listener
	 * @throws DBAccessException
	 */
	public void setListener(DBAccessListener listener) throws DBAccessException {
		this.listener = listener;
	}
	
	/**
	 * Acquires database connection
	 * @return Connection -  database connection
	 * @throws DBAccessException
	 */	
	public Connection getConnection() throws DBAccessException {
		
		connectDB();
		
		// prepard for db access listener
		//try{
		//	connectDB();
		//} catch (Exception e) {
		//  listener.executeTask(new DBAccessDefaultTask());	
		//}
		return conn;
	}

	/**
	 * sychronized method in getting java.sql.Connection from the Database.
	 * @throws DBAccessException
	 */
	public synchronized void connectDB() throws DBAccessException {
		try{
			ConnectionPoolDataSource ds = dbAccess.getDataSource();
			if (ds != null) {			
				pConn = ds.getPooledConnection();
				conn = pConn.getConnection();
			} else {
				if (dbAccess == null) log.info("null dbAccess ");
				conn = dbAccess.getConnection();
			}
			if(!isResourceBased) conn.setAutoCommit(false);
			log.info("returning connection instance");	 
		} catch(Exception e) {
			log.warn("Unable to connect to database server");
			throw new DBAccessException ("dbaccess.getconnection.sql.exception",
					e.getCause(), DBAccessException.ERROR, true);

		}
	}
	
	/**
	 * closes database connection
	 * @param conn - Connection
	 * @throws DBAccessException
	 */
	public void closeConnection(Connection conn) throws DBAccessException {
		try{
			if (conn != null) {
				conn.close();
				log.info("closing connection instance");
			}
		} catch (SQLException e){
			throw new DBAccessException ("close.connection.exception",
				e.getCause(), DBAccessException.ERROR, true);
			
		}
	}
	
	/**
	 * rolls back database connection
	 * @param conn - Connection
	 * @throws DBAccessException
	 */
	public void rollbackConnection(Connection conn) throws DBAccessException {
		try{
			if (conn != null) {
				conn.rollback();
				log.info("rollback connection instance");
			}
		} catch (SQLException e){
			throw new DBAccessException ("rollback.exception",
				e.getCause(), DBAccessException.ERROR, true);
			
		}
	}
	
	/**
	 * commits connection
	 * @param conn - Connection
	 * @throws DBAccessException
	 */
	public void commitConnection(Connection conn) throws DBAccessException {
		try{
			conn.commit();
			log.info("rollback connection instance");	 
		} catch (SQLException e){
			throw new DBAccessException ("rollback.exception",
				e.getCause(), DBAccessException.ERROR, true);
			
		}
	}
	
	 
}
