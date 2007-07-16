/*
 * Created on Dec 10, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.exceptions;

/**
 * This class represents nonfatal exceptions that occur within HRS 
 * 
 * @author Eugene Lozada
 *
 * 
 */
public class HRSLogicalException extends HRSException {

	/**
	 * Creates a new HRSLogicalException  with logging disabled 
	 * 
	 * @param messageKey the message key
	 * @param cause the cause of this exception
	 */
	public HRSLogicalException(String messageKey, Throwable cause){
		super(messageKey, cause, HRSException.OFF, false);
	}
	
	/**
	 * Creates a new HRSLogicalException with logging disabled and no <code>Throwable</code> cause
	 * 
	 * @param messageKey the message key
	 */
	public HRSLogicalException(String messageKey){
		super(messageKey, null, HRSException.OFF, false);
	}

}
