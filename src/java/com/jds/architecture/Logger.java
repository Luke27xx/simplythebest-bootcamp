package com.jds.architecture;

/**
 * Logger Interface used to log messages for a specific system or application component.
 * 
 * @author Roan W. G. Nicolas <roan.w.g.nicolas@accenture.com>
 * @see LoggerService, LoggerImp
 */
public interface Logger {
	
	/**
	 * Log a message with INFO level.
	 * 
	 * @param message information to be logged.
	 * 
	 */    
    public void info(String message);

	/**
	 * Log a message with INFO level with associated Throwable information.
	 * 
	 * @param message information to be logged.
	 * 
	 */      
	public void info(String message, Throwable t);
	
	/**
	 * Log a message with WARN level.
	 * 
	 * @param message information to be logged.
	 * 
	 */  	
	public void warn(String message);
	
	/**
	 * Log a message with WARN level with associated Throwable information.
	 * 
	 * @param message information to be logged.
	 * @param t Throwable associated with log message.
	 * 
	 */  	
	public void warn(String message, Throwable t);
	
	/**
	 * Log a message with DEBUG level.
	 * 
	 * @param message information to be logged.
	 * 
	 */  	
	public void debug(String message);
	
	/**
	 * Log a message with DEBUG level with associated Throwable information.
	 * 
	 * @param message information to be logged.
	 * @param t Throwable associated with log message.
	 * 
	 */  	
	public void debug(String message, Throwable t);
	
	/**
	 * Log a message with ERROR level.
	 * 
	 * @param message information to be logged.
	 * 
	 */  
	public void error(String message);

	/**
	 * Log a message with ERROR level with associated Throwable information.
	 * 
	 * @param message information to be logged.
	 * @param t Throwable associated with log message.
	 * 
	 */  	
	public void error(String message, Throwable t);

	/**
	 * Log a message with FATAL level.
	 * 
	 * @param message information to be logged.
	 * 
	 */  
	public void fatal(String message);
	
	/**
	 * Log a message with FATAL level with associated Throwable information.
	 * 
	 * @param message information to be logged.
	 * @param t Throwable associated with log message.
	 * 
	 */  	
	public void fatal(String message, Throwable t);
	
	/**
	 * Initialize the Class name to be logged.
	 * 
	 * @param name name of the class to be logged.
	 * 
	 */  
	public void init(Class name);
	
}
