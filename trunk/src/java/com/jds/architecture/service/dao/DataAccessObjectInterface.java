/*
 * Created on Dec 3, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.architecture.service.dao;


import java.sql.Connection;

import javax.sql.RowSet;


/**
 * <p>
 * DataAccessObjectInterface is an interface for all data access object classes
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  11/2004 initial draft c.b.balajadia
  * @since 1.1
 */
public interface DataAccessObjectInterface {
	
	
	public void create(Connection conn, Object obj) throws DAOException;
	public boolean remove(Connection conn, Object obj) throws DAOException;
	public Object findByPK(Object obj) throws DAOException ;
	public RowSet findByAll()	throws DAOException ;
	public RowSet find(Object obj)	throws DAOException ;
	public boolean update(Connection conn, Object obj1, Object obj2)throws DAOException;
}
