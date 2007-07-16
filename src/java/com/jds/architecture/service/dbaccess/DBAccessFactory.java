/*
 * Created on Dec 9, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.architecture.service.dbaccess;

import java.util.HashMap;

import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.logging.LoggerService;

/**
 * <p>
 * DBAccessFactory is a class that instantiates DBAccessType classes.
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  11/2004 initial draft c.b.balajadia
 * @since 1.1
 */
public class DBAccessFactory {
	private HashMap hDBAccess = new HashMap();
	private static DBAccessFactory factory = null;
	private static Logger log = (Logger)ServiceFactory.getInstance()
	.getService(LoggerService.class);
	
	/**
	 * static class in getting the DBAccessFactory instance
	 * @return DBAccessFactory - instance of db acess factory class
	 * @throws Exception
	 */
	public static DBAccessFactory getFactory() throws Exception {
		if (factory == null) {
			factory = new DBAccessFactory();
			log.info("DBAccessFactory initialized");
		}
		return factory;
	}
	
	/**
	 * Instantiates dbaccess classes upon request and stores instance in hashmap.
	 * @param className - dbaccess class name requested
	 * @return DBAccessInterface - interface for all db access object
	 * @throws DBAccessException
	 */	
	public DBAccessInterface getDAOInstance(String className)
			throws DBAccessException
		{
			DBAccessInterface dbAccess = (DBAccessInterface)hDBAccess.get(className);
		
			if(dbAccess == null)
			{
				try
				{
					log.info("Loading db access instance:" + className);
					Class dbClass = Class.forName(
						"com.jds.architecture.service.dbaccess."+ className);
				
					if(!(com.jds.architecture.service.dbaccess.DBAccessInterface.class).
							isAssignableFrom(dbClass)) {
							throw new DBAccessException 
								("dbaccess.improper.interface.exception",
								null, DBAccessException.ERROR, true);
						}
				
					dbAccess = (DBAccessInterface)dbClass.newInstance();
					hDBAccess.put(className, dbAccess);
				} catch(InstantiationException ie){
					throw new DBAccessException ("dbaccess.instantiate.factory.instantiate.exception",
						ie.getCause(), DBAccessException.ERROR, true);
				} catch(IllegalAccessException le)	{
					throw new DBAccessException ("dbaccess.illegal.factory.instantiate.exception",
						le.getCause(), DBAccessException.ERROR, true);
				} catch(ClassNotFoundException cne) {
					throw new DBAccessException ("dbaccess.classnotfound.factory.instantiate.exception",
						cne.getCause(), DBAccessException.ERROR, true);
				} catch(Exception ce) {
					throw new DBAccessException ("dbaccess.factory.instantiate.exception",
						ce.getCause(), DBAccessException.ERROR, true);
				}
			} 
		
			return dbAccess;
	}
}
