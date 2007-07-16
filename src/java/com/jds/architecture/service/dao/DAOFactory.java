/*
 * Created on Dec 4, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.architecture.service.dao;

import java.util.HashMap;

import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.logging.LoggerService;

/**
 * <p>
 * DAOFactory is a class that instantiates Data access object classes.
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  11/2004 initial draft c.b.balajadia
 * @since 1.1
 */
public class DAOFactory {
	
	private HashMap hDAOs = new HashMap();
	private static DAOFactory factory = null;
	private static Logger log = (Logger) ServiceFactory.getInstance()
	.getService(LoggerService.class);

	
	/**
	 * static class in getting the DAOFactory instance
	 * @return DBAccessFactory - instance of dao factory class
	 * @throws Exception
	 */
	public static DAOFactory getFactory() throws Exception {
		if (factory == null) {
			factory = new DAOFactory();
			log.info("initilizing dao factory");
		}
		return factory;
	}
	
	/**
	 * Instantiates dao classes upon request and stores instance in hashmap.
	 * @param className - dao class name requested
	 * @return DataAccessObjectInterface - interface for all dao object
	 * @throws DAOException
	 */		
	public DataAccessObjectInterface getDAOInstance(String className)
			throws DAOException
		{
			DataAccessObjectInterface dao = (DataAccessObjectInterface)hDAOs.get(className);
		
			if(dao == null)
			{
				try
				{
					log.info("Loading dao instance:" + className);
					Class daoClass = Class.forName(
						"com.jds.architecture.service.dao."+ className);
				
					if(!(com.jds.architecture.service.dao
							.DataAccessObjectInterface.class).
						isAssignableFrom(daoClass)) {
							throw new DAOException 
								("dao.improper.interface.exception",
								null, DAOException.ERROR, true);
					}
					
					dao = (DataAccessObjectInterface)daoClass.newInstance();
					hDAOs.put(className, dao);
				} catch(InstantiationException ie){
					throw new DAOException ("dao.instantiate.factory.instantiate.exception",
						ie.getCause(), DAOException.ERROR, true);
				} catch(IllegalAccessException le)	{
					throw new DAOException ("dao.illegal.factory.instantiate.exception",
						le.getCause(), DAOException.ERROR, true);
				} catch(ClassNotFoundException cne) {
					throw new DAOException ("dao.classnotfound.factory.instantiate.exception",
						cne.getCause(), DAOException.ERROR, true);
				} catch(Exception ce) {
					throw new DAOException ("dao.factory.instantiate.exception",
						ce.getCause(), DAOException.ERROR, true);
				}
			} 
		
			return dao;
	}
	
}
