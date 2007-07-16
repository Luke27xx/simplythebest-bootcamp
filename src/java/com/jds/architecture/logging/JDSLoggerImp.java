/*
 * Created on Jan 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.logging;

import com.jds.architecture.Implementor;

/**
 * @author Roan W G Nicolas <roan.w.g.nicolas@accenture.com>
 *
 */
public class JDSLoggerImp extends Implementor implements LoggerImp {

	public void init(String name) {
	    System.out.println("HRS Logger Initialized " + name);
	}
    
    public void info(String msg) {		
		System.out.println("HRS INFO: " + msg);		
	}
    public void info(String msg, Throwable t) {		
		System.out.println("HRS INFO: " + msg + " Error: " + t);		
	}    
    
	public void warn(String msg) {		
		System.out.println("HRS WARN: " + msg);		
	}
    public void warn(String msg, Throwable t) {		
		System.out.println("HRS WARN: " + msg + " Error: " + t);		
	}  
    
	public void debug(String msg) {		
		System.out.println("HRS DEBUG: " + msg);		
	}
    public void debug(String msg, Throwable t) {		
		System.out.println("HRS DEBUG: " + msg + " Error: " + t);		
	}  	
	
	public void error(String msg) {		
		System.out.println("HRS ERROR: " + msg);		
	}
    public void error(String msg, Throwable t) {		
		System.out.println("HRS ERROR: " + msg + " Error: " + t);		
	}  		
	
	public void fatal(String msg) {		
		System.out.println("HRS FATAL: " + msg);		
	}
    public void fatal(String msg, Throwable t) {		
		System.out.println("HRS FATAL: " + msg + " Error: " + t);		
	} 	
}
