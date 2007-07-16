/*
 * Created on Dec 13, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.architecture.service.dbaccess;

import org.apache.log4j.Level;

import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.properties.PropertiesMonitorService;

/**
 * <p>
 * DBAccessException is an exception class for DBAccess package.
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  12/2004 initial draft - c.b.balajadia
 * @since 1.1
 */
public class DBAccessException extends Exception {

	private static Logger logger = (Logger)ServiceFactory.getInstance()
	.getService(DBAccessException.class);
	private static PropertiesMonitorService pm = (PropertiesMonitorService)ServiceFactory.getInstance()
.	getService(PropertiesMonitorService.class);

	private String messageKey;
	

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
	
	/**
	 * DBAccessException contructor
	 * @param messageKey - error message key
	 * @param cause - cause of exception from throwable
	 * @param severity - error severity, DEBUG, ERROR, FATAL, INFO, WARN
	 * @param isLogged - true if logged in
	 */
	public DBAccessException(String messageKey, 
		Throwable cause, int severity, boolean isLogged){
		//messagKey is temporary
		super(messageKey, cause);
		this.messageKey = messageKey;
		if(isLogged){
			//logger = Logger.getLogger(getClass());
			//logger.log(getClass().toString(), Level.toLevel(severity), messageKey, cause);
		}
	}

	/**
	 * DBAccessException constructor
	 * @param messageKey - error message key
	 * @param cause - cause of exception from throwable
	 */
	public DBAccessException(String messageKey, Throwable cause){
		this(messageKey, cause, DBAccessException.OFF, false);
	}
	
	/**
	 * gets the message key of the error
	 * @return String - message key
	 */
	public String getMessageKey() {
		return this.messageKey;
	}
	
	/**
	 * gets the message value from property file
	 * @return String error message
	 */
	public String getMessage() {
		return pm.getProperty("dbacess", messageKey);
	}
	
	private Logger getLogger(){
		return logger;
	}
}
