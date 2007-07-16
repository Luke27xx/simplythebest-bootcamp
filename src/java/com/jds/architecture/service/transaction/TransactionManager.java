/*
 * Created on Jan 25, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.service.transaction;

import java.sql.Connection;

import org.apache.log4j.Logger;


import com.jds.architecture.PropertiesMonitor;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.properties.PropertiesMonitorService;
import com.jds.architecture.service.dao.DAOConstants;
import com.jds.architecture.service.dbaccess.DBAccess;
import com.jds.architecture.service.dbaccess.DBAccessException;

/**
 * @author JDSSvr
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TransactionManager {
	
	ServiceFactory sf = ServiceFactory.getInstance();
	private PropertiesMonitor pm = (PropertiesMonitor) sf.getService(PropertiesMonitorService.class);	

	private static Logger log = Logger.getLogger(TransactionManager.class);
	private static TransactionAccess trAccess = null;
	private DBAccess db = null;
	private static boolean isResourceBased = false;
	
	private TransactionManager() throws TransactionException {
		log.info("initilizing transaction manager");

		try {
			trAccess = TransactionAccess.getTransactionAccess();
		} catch (TransactionException e) {
			//TODO
			e.printStackTrace();
		} 

		try {
			db = DBAccess.getDBAccess();
		} catch (DBAccessException e) {
			//TODO
			e.printStackTrace();
		} 
		
		if (db.getConnectionType().
				equalsIgnoreCase(DAOConstants.CONN_JNDI)) {
			isResourceBased = true;
		}
	}
	
	public void begin() throws TransactionException {
		try {
			trAccess.begin();
		} catch (TransactionException e) {
			e.printStackTrace();
			throw new TransactionException
				("transaction.notsupported.exception",e.getCause(),
				TransactionException.ERROR, true);
		}

		
	}
	
	public void commit(Connection conn) throws TransactionException, DBAccessException {
		try {
			trAccess.commit();
			if (!isResourceBased) dbCommit(conn);
		} catch (TransactionException e) {
			e.printStackTrace();
			throw new TransactionException
				("transaction.notsupported.exception",e.getCause(),
				TransactionException.ERROR, true);
		}

	}
	
	public void setRollbackOnly() throws TransactionException{
		try {
			trAccess.setRollbackOnly();
		} catch (TransactionException e) {
			e.printStackTrace();
			throw new TransactionException
				("transaction.notsupported.exception",e.getCause(),
				TransactionException.ERROR, true);
		}

	}
	
	public void rollback(Connection conn) throws TransactionException, DBAccessException{
		try {
			trAccess.setRollbackOnly();
			if (!isResourceBased) dbRollback(conn);
		} catch (TransactionException e) {
			e.printStackTrace();
			throw new TransactionException
				("transaction.notsupported.exception",e.getCause(),
				TransactionException.ERROR, true);
		}

	}
	
	private void dbCommit(Connection conn) throws DBAccessException {
		db.commitConnection(conn);
	}
	
	private void dbRollback(Connection conn) throws DBAccessException {
		db.rollbackConnection(conn);

	}
	

}