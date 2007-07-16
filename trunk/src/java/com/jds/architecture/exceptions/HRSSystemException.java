/*
 * Created on Dec 9, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.exceptions;
import org.apache.log4j.Level;


/**
 * @author Eugene Lozada
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class HRSSystemException extends HRSException {

	
	/**
	 * Creates a new HRSSystemException
	 * 
	 * @param messageKey the message key
	 * @param cause the cause of this exception
	 */
	public HRSSystemException(String messageKey, Throwable cause){
		super(messageKey, cause, Level.ERROR.toInt(), true);	
	}
}
