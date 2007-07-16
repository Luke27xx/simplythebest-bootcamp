/*
 * Created on Feb 1, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.logging;

import org.apache.log4j.Logger;
import com.jds.architecture.Implementor;

/**
 * @author Roan W G Nicolas <roan.w.g.nicolas@accenture.com>
 *
 */
public class Log4JLoggerImp extends Implementor implements LoggerImp {

    
    //delegate logger
    private Logger log;
    
    public Log4JLoggerImp() {
        init(this.getClass().getName());
    }
       
    public void init(String name) {
        log = Logger.getLogger(name);
    }
        
    public void info(String msg) {        
        log.info(msg);
    }

    public void info(String msg, Throwable t) {        
        log.info(msg, t);
    }    
    
    /* (non-Javadoc)
     * @see com.jds.architecture.logging.LoggerImp#warn(java.lang.String)
     */
    public void warn(String msg) {
        log.warn(msg);
    }

    public void warn(String msg, Throwable t) {
        log.warn(msg, t);
    }    
    
    /* (non-Javadoc)
     * @see com.jds.architecture.logging.LoggerImp#debug(java.lang.String)
     */
    public void debug(String msg) {
        log.debug(msg);
    }

    public void debug(String msg, Throwable t) {
        log.debug(msg, t);
    }    
    
    /* (non-Javadoc)
     * @see com.jds.architecture.logging.LoggerImp#error(java.lang.String)
     */
    public void error(String msg) {
        log.error(msg);
    }

    public void error(String msg, Throwable t) {
        log.error(msg, t);
    }    
    
    /* (non-Javadoc)
     * @see com.jds.architecture.logging.LoggerImp#fatal(java.lang.String)
     */
    public void fatal(String msg) {
        log.fatal(msg);
    }

    public void fatal(String msg, Throwable t) {
        log.fatal(msg, t);
    }    
}
