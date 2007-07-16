/*
 * Created on Jan 11, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.architecture.service.dao.stmtgenerator;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.jds.architecture.service.dao.DAOException;


/**
 * <p>
 * StatementGeneratorFactory is a class that instantiates statement generator classes.
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  11/2004 initial draft c.b.balajadia
 * @since 1.1
 */
public class StatementGeneratorFactory {
	private HashMap hDAOs = new HashMap();
	private static StatementGeneratorFactory factory = null;
	static Logger log = Logger.getLogger(StatementGeneratorFactory.class);
	
	private StatementGeneratorFactory(){}
	
	/**
	 * getGenerator creates an new StatementGeneratorFactory()
	 */
	public static StatementGeneratorFactory getGenerator() {
		if (factory == null) {
			factory = new StatementGeneratorFactory();
			log.info("initilizing dao factory");
		}
		return factory;
	}
	
	/**
	 * getStmtGenerator creates a StatementGenerator from a specified class name
	 * @param String className 
	 * @throws DAOException throws DAOException when unexpected error occurs
	 * @return the value to which this map maps the specified key, or
	 * 			if null, loads an instance of a Class object forName in the className
	 */ 
	public StatementGenerator getStmtGenerator(String className)
			throws DAOException	{
			StatementGenerator generator = (StatementGenerator)hDAOs.get(className);
		
			if(generator == null)
			{
				try
				{
					log.info("Loading dao instance:" + className);
					Class genClass = Class.forName(
						"com.jds.architecture.service.dao.stmtgenerator."+ className);
				
					if(!(com.jds.architecture.service.dao.stmtgenerator.StatementGenerator.class).
						isAssignableFrom(genClass)) {
							throw new DAOException 
								("dao.improper.interface.exception",
								null, DAOException.ERROR, true);
					}
					
					generator = (StatementGenerator)genClass.newInstance();
					hDAOs.put(className, generator);
				} catch(InstantiationException ie){
					throw new DAOException ("generator.instantiate.factory.instantiate.exception",
						ie.getCause(), DAOException.ERROR, true);
				} catch(IllegalAccessException le)	{
					throw new DAOException ("generator.illegal.factory.instantiate.exception",
						le.getCause(), DAOException.ERROR, true);
				} catch(ClassNotFoundException cne) {
					throw new DAOException ("generator.classnotfound.factory.instantiate.exception",
						cne.getCause(), DAOException.ERROR, true);
				} catch(Exception ce) {
					throw new DAOException ("generator.factory.instantiate.exception",
						ce.getCause(), DAOException.ERROR, true);
				}
			} 
			return generator;
	}


	
}
