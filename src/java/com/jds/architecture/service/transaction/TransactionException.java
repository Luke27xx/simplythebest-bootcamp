/*
 * Created on Jan 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.service.transaction;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


import com.jds.architecture.PropertiesMonitor;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.properties.PropertiesMonitorService;
import com.jds.architecture.service.dbaccess.DBAccessException;

/**
 * <p>
 * TransactionException is an exception class for TransactionAccess.
 * Not yet implemented in HRS 2.0
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  12/2004 initial draft - c.b.balajadia
 * @since 1.1
 */
public class TransactionException extends Exception {

	private String messageKey;
	Logger logger = Logger.getLogger(TransactionException.class);

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
	private PropertiesMonitor pm = (PropertiesMonitor) sf.getService(PropertiesMonitorService.class);	

	public TransactionException(String messageKey, 
		Throwable cause, int severity, boolean isLogged){
		//messagKey is temporary
		super(messageKey, cause);
		this.messageKey = messageKey;
		if(isLogged){
			logger = Logger.getLogger(getClass());
			logger.log(getClass().toString(), Level.toLevel(severity), messageKey, cause);
		}
	}

	public TransactionException(String messageKey, Throwable cause){
		this(messageKey, cause, DBAccessException.OFF, false);
	}
	
	public String getMessageKey() {
		return this.messageKey;
	}
	
	public String getMessage() {
		return pm.getProperty("traccess", messageKey);
	}
	
	public Logger getLogger(){
		return logger;
	}
}
