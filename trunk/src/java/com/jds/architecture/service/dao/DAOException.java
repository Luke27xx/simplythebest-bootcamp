/*
 * Created on Dec 13, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.architecture.service.dao;


import java.sql.SQLException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.jds.architecture.PropertiesMonitor;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.properties.PropertiesMonitorService;

/**
 * Creates a wrapper class for lower level SQLExceptions and Throwables
 * 
 * @author Catherine Balajadia
 * 
 */
public class DAOException extends Exception {

	private Logger logger = Logger.getLogger(DAOException.class);
	private String messageKey;
	private boolean isLogical = false;

	public static final int ALL;
	public static final int DEBUG;
	public static final int ERROR;
	public static final int FATAL;
	public static final int INFO;
	public static final int OFF;
	public static final int WARN;
	
	static{
		ALL = Level.ALL.toInt();
		DEBUG = Level.DEBUG.toInt();
		ERROR = Level.ERROR.toInt();
		FATAL = Level.FATAL.toInt();
		INFO = Level.INFO.toInt();
		OFF = Level.OFF.toInt();
		WARN = Level.WARN.toInt();
	}
		
	ServiceFactory sf = ServiceFactory.getInstance();
	PropertiesMonitor pm = (PropertiesMonitor) sf.getService(PropertiesMonitorService.class);
	
	private final static int ORA00001  = 1 ;//unique constraint (string.string) violated
	private final static int ORA00018  = 18 ;//maximum number of sessions exceeded
	private final static int ORA00022 = 22 ;//invalid session ID; access denied
	private final static int ORA00028 = 28 ;//your session has been killed
	private final static int ORA00060 = 60 ;//deadlock detected while waiting for resource
	private final static int ORA00100 = 100 ;//no data found
	private final static int ORA00107 = 107 ;//failed to connect to ORACLE listener process


	/**
	 * Creates a DAOExeption that wraps a throwable object
	 * 
	 * @param messageKey the message property key
	 * @param cause the cause of this exception
	 * @param severity the severity
	 * @param isLogged true if the exception is to be logged, false otherwise
	 */
	public DAOException(String messageKey, 
		Throwable cause, int severity, boolean isLogged){
		//messagKey is temporary
		super(messageKey, cause);
		this.messageKey = messageKey;
		if(isLogged){
			logger = Logger.getLogger(getClass());
			logger.log(getClass().toString(), Level.toLevel(severity), 
			messageKey, cause);
		}
	}
	
	
	/**
	 * Creates a DAOExeption that wraps an SQLEXception object
	 * 
	 * @param messageKey the message property key
	 * @param cause the cause of this exception
	 * @param severity the severity
	 * @param isLogged true if the exception is to be logged, false otherwise
	 */
	public DAOException(String messageKey, 
		SQLException sql, int severity, boolean isLogged){
		String key = messageKey;
		int level = severity;
		if (sql != null) {
			switch(sql.getErrorCode()) {
				case ORA00001:
					key = "sql.ORA00001";
					level = ERROR;
					this.isLogical = true;
					break;
				case ORA00018:
					key = "sql.ORA00018";
					level = ERROR;
					break;
				case ORA00022:
					key = "sql.ORA00022";
					level = ERROR;
					this.isLogical = true;
					break;
				case ORA00028:
					key = "sql.ORA00028";
					level = ERROR;
					break;
				case ORA00060:
					key = "sql.ORA00060";
					level = ERROR;
					break;				
				case ORA00100:
					key = "sql.ORA00100";
					level = ERROR;
					this.isLogical = true;
					break;
				case ORA00107:
					key = "sql.ORA00107";
					level = ERROR;
					break;
				default:
					break;
			};
		}
		this.messageKey = key;
		if(isLogged){
            Throwable cause = sql == null ? null : sql.getCause();
			logger = Logger.getLogger(getClass());
			logger.log(getClass().toString(), Level.toLevel(level), 
			messageKey, cause);
		}
		
	}

	/**
	 * Creates a DAOException wrapper with logging disabled
	 * @param messageKey
	 * @param cause
	 */
	public DAOException(String messageKey, Throwable cause){
		this(messageKey, cause, DAOException.OFF, false);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return pm.getProperty("dao", messageKey);
	}
	
	/**
	 * Returns the message property key
	 * 
	 * @return the message property key
	 */
	public String getMessageKey() {
		return this.messageKey;
	}
	
	/**
	 * Returns the logger assosociated with this exception
	 * 
	 * @return the logger
	 */
	public Logger getLogger(){
		return logger;
	}
	
	/**
	 * Returns if this is a logical or a system exception
	 * 
	 * @return true if the exception is logical, false otherwise
	 */
	public boolean isLogical() {
		return isLogical;
	}


}
