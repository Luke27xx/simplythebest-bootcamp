/*
 * Created on Jan 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.logging;

import com.jds.architecture.*;


/**
 * @author Roan W G Nicolas <roan.w.g.nicolas@accenture.com>
 *
 */
public class LoggerService extends Service implements Logger{

    protected static final String LOG4J_PLUGIN_CLASS_NAME = "com.jds.architecture.logging.Log4JLoggerImp";
    protected static final String LOG4J_DETECTOR_CLASS_NAME = "org.apache.log4j.Logger";    
    
    protected static Class pluginClass;  
	protected transient LoggerImp loggerDelegate;
	private String name; 
	
	/** 
	* Creates new Logger the given logger name.
	*
	* @param name    the logger name.
	*/
	protected LoggerService(String name) {
		this.name = name;  
	}
	
	public LoggerService() {
	    
	}
	
	public void setImplementor(Implementor plugin) {
	    this.loggerDelegate = (LoggerImp)plugin; 
	}
	
	public void init(Class className) {
	    this.loggerDelegate.init(className.getName());
	}
	
	/**
	* Return the name of this logger.
	*
	* @return The name of this logger.
	*/
	public String getName() {
		return name;
	}
	   
	public LoggerImp getLoggerImp () {
		return this.loggerDelegate;
	}
	
	
	/** 
	* Create a Logger instance given the logger name.
	*
	* @param name    the logger name
	*/
	public static LoggerService getLoggerService(String name) {
	    return new LoggerService(name);
	}
	
	/** 
	* Create a Logger instance given the logger class. This simply
	* calls create(className.getName()).
	*
	* @param className    the Class whose name will be used as the logger name
	*/
	public static LoggerService getLoggerService(Class className) {
	    return new LoggerService(className.getName());
	}	
	
	

	
	/** 
	* Issue a log msg with a level of INFO.
	* Invokes log.log(Level.INFO, message);
	*/
	public void info(String message) {
	    loggerDelegate.info(message);
	}	
	public void info(String message, Throwable t) {
	    loggerDelegate.info(message,t);
	}
	
	/** 
	* Issue a log msg with a level of WARN.
	* Invokes log.log(Level.WARN, message);
	*/
	public void warn(String message) {
	    loggerDelegate.warn(message);
	}
	public void warn(String message, Throwable t) {
	    loggerDelegate.warn(message,t);
	}	
	
	/** 
	* Issue a log msg with a level of DEBUG.
	* Invokes log.log(Level.DEBUG, message);
	*/
	public void debug(String message) {
	    loggerDelegate.debug(message);
	}
	public void debug(String message, Throwable t) {
	    loggerDelegate.debug(message,t);
	}	
	
	/** 
	* Issue a log msg with a level of ERROR.
	* Invokes log.log(Level.ERROR, message);
	*/
	public void error(String message) {
	    loggerDelegate.error(message);
	}
	public void error(String message, Throwable t) {
	    loggerDelegate.error(message,t);
	}		
	
	/** 
	* Issue a log msg with a level of FATAL.
	* Invokes log.log(Level.FATAL, message);
	*/
	public void fatal(String message) {
	    loggerDelegate.fatal(message);
	}
	public void fatal(String message, Throwable t) {
	    loggerDelegate.fatal(message, t);
	}		
}
