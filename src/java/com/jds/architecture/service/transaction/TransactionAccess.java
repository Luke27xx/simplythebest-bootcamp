/*
 * Created on Jan 25, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.service.transaction;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;

import com.jds.architecture.PropertiesMonitor;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.properties.PropertiesMonitorService;

/**
 * <p>
 * TransactionAccess is class that facilitates transaction handling.
 * Not yet implemented in HRS 2.0
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  12/2004 initial draft - c.b.balajadia
 * @since 1.1
 */
public class TransactionAccess {
	
	ServiceFactory sf = ServiceFactory.getInstance();
	private PropertiesMonitor pm = (PropertiesMonitor) sf.getService(PropertiesMonitorService.class);

	private static String TRANSACTION_URL = "java:comp/UserTransaction";
	static Logger log = Logger.getLogger(TransactionAccess.class);
	private static TransactionAccess trAccess = null;
	private static UserTransaction utx = null;
	
	private TransactionAccess() throws TransactionException {
		log.info("initilizing transaction manager");
		try {
			if (pm.getProperty("dbaccess", "transaction.url") == null)
				TRANSACTION_URL = pm.getProperty("dbaccess", "transaction.url");
			Context ctx = new InitialContext();
			utx = (UserTransaction) ctx.lookup(TRANSACTION_URL);
		} catch (NamingException e) {
			throw new TransactionException ("transaction.naming.exception",e.getCause(),
					TransactionException.ERROR, true);			
		} catch (Exception e) {	
			throw new TransactionException ("transaction.naming.exception",e.getCause(),
					TransactionException.ERROR, true);
		}
	}
	
	protected static TransactionAccess getTransactionAccess() 
		throws TransactionException {
		
		if (trAccess == null)
			new TransactionAccess();
		return trAccess;
	}
	
	
	protected void begin() throws TransactionException {
		try {
			utx.begin();
		} catch (NotSupportedException e) {
			e.printStackTrace();
			throw new TransactionException
				("transaction.notsupported.exception",e.getCause(),
				TransactionException.ERROR, true);
		} catch (SystemException e) {
			e.printStackTrace();
			throw new TransactionException
			("transaction.system.exception",e.getCause(),
			TransactionException.ERROR, true);
		}

		
	}
	
	protected void commit() throws TransactionException {
		try {
			utx.commit();
		} catch (SecurityException e) {
			throw new TransactionException
			("transaction.security.exception",e.getCause(),
			TransactionException.ERROR, true);
		} catch (IllegalStateException e) {
			throw new TransactionException
			("transaction.illegal.state.exception",e.getCause(),
			TransactionException.ERROR, true);
		} catch (RollbackException e) {
			throw new TransactionException
			("transaction.rollback.exception",e.getCause(),
			TransactionException.ERROR, true);
		} catch (HeuristicMixedException e) {
			throw new TransactionException
			("transaction.heuristic.exception",e.getCause(),
			TransactionException.ERROR, true);
		} catch (HeuristicRollbackException e) {
			throw new TransactionException
			("transaction.heuristic.rollback.exception",e.getCause(),
			TransactionException.ERROR, true);
		} catch (SystemException e) {
			throw new TransactionException
			("transaction.system.exception",e.getCause(),
			TransactionException.ERROR, true);
		}
	}
	
	protected void setRollbackOnly() throws TransactionException{
		try {
			utx.setRollbackOnly();
		} catch (IllegalStateException e) {
			throw new TransactionException
			("transaction.illegal.state.exception",e.getCause(),
			TransactionException.ERROR, true);
		} catch (SecurityException e) {
			throw new TransactionException
			("transaction.security.exception",e.getCause(),
			TransactionException.ERROR, true);
		} catch (SystemException e) {
			throw new TransactionException
			("transaction.system.exception",e.getCause(),
			TransactionException.ERROR, true);
		}
	}
	
	protected void rollback() throws TransactionException{
		try {
			utx.setRollbackOnly();
		} catch (IllegalStateException e) {
			throw new TransactionException
			("transaction.illegal.state.exception",e.getCause(),
			TransactionException.ERROR, true);
		} catch (SecurityException e) {
			throw new TransactionException
			("transaction.security.exception",e.getCause(),
			TransactionException.ERROR, true);
		} catch (SystemException e) {
			throw new TransactionException
			("transaction.system.exception",e.getCause(),
			TransactionException.ERROR, true);
		}
	}
	

}