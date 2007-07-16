/*
 * Created on Dec 9, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.exceptions;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author Eugene Lozada
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class HRSException extends Throwable {

	private String messageKey;
	private Logger logger;


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
	 * Creates a new HRSException
	 *  
	 * @param messageKey key for the message properties file
	 * @param cause the cause of this exception
	 * @param severity severity level used by the logger
	 * @param isLogged set to <code>true</code> if the logger is active, <code>false</code> otherwise
	 */
	public HRSException(String messageKey, Throwable cause, int severity, boolean isLogged){
		super(cause);
		this.messageKey = messageKey;
		if(isLogged){
			logger = Logger.getLogger(getClass());
			logger.log(getClass().toString(), Level.toLevel(severity), messageKey, cause);
		}
	}
	
	/**
	 * Creates a new HRSException with logging disabled. 
	 * 
	 * @param messageKey
	 * @param cause
	 */
	public HRSException(String messageKey, Throwable cause){
		this(messageKey, cause, HRSException.OFF, false);
	}

	/**
	 * Creates a new HRSException with logging disabled and no wrapped <code>Throwable</code> cause
	 * 
	 * @param messageKey
	 */
	public HRSException(String messageKey){
		this(messageKey, null, HRSException.OFF, false);
	}
	
	
	/**
	 * Returns the message key of this HRSException
	 * 
	 * @return the message key
	 */
	public String getMessageKey() {
		return messageKey;
	}
	
	/**
	 * Returns a reference to the logger used by the HRSException
	 * 
	 * @return the logger
	 */
	public Logger getLogger(){
		return logger;
	}
	

}
