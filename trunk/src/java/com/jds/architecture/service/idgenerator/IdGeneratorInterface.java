/*
 * Created on Feb 9, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.service.idgenerator;

/**
 * <p>
 * IdGeneratorInterface is an interface of IdGenerator classes.
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  02/2004 initial draft c.b.balajadia
  * @since 1.1
 */
public interface IdGeneratorInterface {

	public long getNextId() throws IdGeneratorException;
}
