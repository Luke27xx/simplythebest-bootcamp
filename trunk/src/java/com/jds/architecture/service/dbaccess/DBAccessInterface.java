/*
 * Created on Dec 9, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.architecture.service.dbaccess;

//import javax.sql.ConnectionPoolDataSource;
import java.sql.Connection;

import javax.sql.ConnectionPoolDataSource;


/**
 * <p>
 * DBAccessInterface is an interface for all DBAccess connection type classes.
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  11/2004 initial draft c.b.balajadia
 * @since 1.1
 */
public interface DBAccessInterface {
	public ConnectionPoolDataSource getDataSource () throws DBAccessException ;
	//public PooledConnection getDataSource () throws DBAccessException ;
	public Connection getConnection() throws DBAccessException;
	public void reconnect()throws DBAccessException;
	public void dbConnect()throws DBAccessException;
	
}
