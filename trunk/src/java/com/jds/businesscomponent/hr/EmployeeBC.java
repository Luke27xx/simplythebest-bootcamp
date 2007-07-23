/*
 * Created on Feb 14, 2005
 * 
 * JAVA Development School
 * Copyright 2005 Accenture
 *
 */
package com.jds.businesscomponent.hr;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.RowSet;


import com.jds.apps.Constants;
import com.jds.apps.beans.AccentureDetails;
import com.jds.apps.beans.EmployeeInfo;
import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.exceptions.HRSLogicalException;
import com.jds.architecture.exceptions.HRSSystemException;
import com.jds.architecture.logging.LoggerService;
import com.jds.architecture.service.dao.DAOConstants;
import com.jds.architecture.service.dao.DAOException;
import com.jds.architecture.service.dao.DAOFactory;
import com.jds.architecture.service.dao.DataAccessObjectInterface;
import com.jds.architecture.service.dao.EmpAccentureDetailsDAO;

import com.jds.architecture.service.dao.EmployeeDAO;
import com.jds.architecture.service.dao.assembler.EmployeeAssembler;
import com.jds.architecture.service.dbaccess.DBAccess;
import com.jds.architecture.service.dbaccess.DBAccessException;
import com.jds.architecture.service.idgenerator.EmployeeIdGenerator;
import com.jds.architecture.service.idgenerator.IdGeneratorException;


/**
 * EmployeeBC is a class that serves as an HR module business functions
 * @author Vadim Kuznecov , Ilja Taran
 * @author last modified by: $Author: c.b.balajadia $
 * @version 2.0
 */
public class EmployeeBC {

	private Constants cons;
	private DataAccessObjectInterface empDao = null; 
	private DataAccessObjectInterface empAccDao = null;
	private DBAccess dbAccess = null;
	
	private static Logger log = (Logger) ServiceFactory.getInstance()
	.getService(LoggerService.class);
	
	
	/**
	 * Constructor initializes data access objects
	 */
	public EmployeeBC () throws HRSSystemException {
	
		log.info("entered EmployeeBC constructor");
	
		   try {
			   empDao = (EmployeeDAO)DAOFactory.getFactory()
				 .getDAOInstance(DAOConstants.DAO_EMP);

			   
			   empAccDao = (EmpAccentureDetailsDAO)DAOFactory.getFactory()
				.getDAOInstance(DAOConstants.DAO_EMPACC);
				
			   dbAccess = DBAccess.getDBAccess();
				cons = new Constants();
						
		   } catch (DBAccessException e) {
		   		throw new HRSSystemException ("intialize.dbaccess.exception",e.getCause());	
		   } catch (DAOException e) {
		   		e.printStackTrace();
		   		throw new HRSSystemException ("intialize.dao.exception",e.getCause());					
		   } catch (Exception e) {
		   		e.printStackTrace();
		   		throw new HRSSystemException ("intialize.employee.bc.exception",e.getCause());
		   } 
		 
		 log.info("exited EmployeeBC constructor");
	
	}

	
	/**
	 * Create employee information by HRManager
	 * @param info  EmployeeInfo
	 * @throws HRSLogicalException when info, date of birth and accenture details is null 
	 * @throws HRSSystemException when system exception occurred (e.g. Failed database connection)
	 * @throws SQLException 
	 */
	public void createEmployee(EmployeeInfo info) 
		throws HRSSystemException, HRSLogicalException, SQLException {
		
		log.info("entered createEmployee method");
		
		long id = 0;
		
		if (info  == null) throw new HRSLogicalException ("invalid.input.exception");
		
		if (info.getDob() == null)
			throw new HRSLogicalException ("dob.required.exception");
		
		if (info.getAccentureDetails() == null)
			throw new HRSLogicalException ("accenture.details.required.exception");
		
		Connection conn = null;					
		
		try {					
		   conn = dbAccess.getConnection();
		   id = EmployeeIdGenerator.getInstance().getNextId();
		   info.setEmpNo(String.valueOf(id));
		   empDao.create(conn, info);
		   RowSet set = empDao.find(info);
		  
		   if ( conn == null || conn.isClosed()) {
			   conn = dbAccess.getConnection();
		   }
		   AccentureDetails details = info.getAccentureDetails();
		   details.setEmployeeNo(info.getEmpNo());
		   empAccDao.create(conn, details); 
		   dbAccess.commitConnection(conn);
		} catch (IdGeneratorException e) {
			try {
				dbAccess.rollbackConnection(conn);
			} catch (DBAccessException e1) {}
			throw new HRSSystemException (e.getMessageKey(),e.getCause());			   
		} catch (DBAccessException e) {
			try {
				dbAccess.rollbackConnection(conn);
			} catch (DBAccessException e1) {}
			throw new HRSSystemException (e.getMessageKey(),e.getCause());			   
		} catch (DAOException e) {
			try {
				dbAccess.rollbackConnection(conn);
			} catch (DBAccessException e1) {}
			if (e.isLogical()) throw new HRSLogicalException (e.getMessageKey()+".employee");
			else throw new HRSSystemException (e.getMessageKey(),e.getCause());
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {}  
		}	
		
		log.info("exited createEmployee method");
	
	}
    
	
    /**
     * Searches employee by primary key which is the employee no. by HRManager
     * @param empno String
     * @return EmployeeInfo object of searched Employee with Accenture Details as a default and 
     * with all the employee related objects as an option
     * @throws HRSLogicalException when employee no. is null
     * @throws HRSSystemException when system exception occurred (e.g. Failed database connection)
     * 
     */
    public EmployeeInfo searchEmployee(String empNo)
        throws HRSSystemException, HRSLogicalException { 
        
        log.info("entered searchEmployee method");
            
        if (empNo == null) 
         throw new HRSLogicalException ("id.required.exception");

        EmployeeInfo empData = null;
        AccentureDetails accData = null;
        Object tempAccData = null;
    
        try{
            empData = (EmployeeInfo) empDao.findByPK(empNo);
            
            if (empData == null) 
                throw new HRSLogicalException ("employee.no.record.exception");
            
            
            tempAccData = empAccDao.findByPK(empNo);
                
            if (tempAccData == null) 
                throw new HRSLogicalException ("accenture.details.no.record.exception");
                
            accData = (AccentureDetails)tempAccData;
            empData.setAccentureDetails(accData);      
                        
        } catch (DAOException e) {
            throw new HRSSystemException (e.getMessageKey(),e.getCause());
        } catch (Exception e) {
            throw new HRSSystemException ("business.component.exception",e.getCause());
        }       
        
        log.info("exited searchEmployee method");
        
        return empData;            
    }
    
    
	/**
	 * searches emplyees in employee and AccentrueEmployee tables using 
	 * info criteria , if criteria is null then return all employess and Accentrue employees
	 * else find emplyees by criteria and retrives information from employe
	 * table and from Accenture table (by EmpNo) as Collection
	 * @param info -input search criteria
	 * @return - list of employees
	 * @throws DAOException
	 * @throws SQLException
	 */
	public Collection  searchEmployees(EmployeeInfo info ) throws DAOException, SQLException{
	
		String pkSearch;
		List<EmployeeInfo> employeeInfoList = new ArrayList<EmployeeInfo>();
		AccentureDetails accDet = new AccentureDetails();
		EmployeeInfo employeeInfo = new EmployeeInfo();
		
		if ( info == null ) {
			RowSet rsAll = empDao.findByAll();
			
			while ( rsAll.next() ) {
				
				   pkSearch =	EmployeeAssembler.getInfo(rsAll).getEmpNo();
				   accDet = (AccentureDetails)empAccDao.findByPK(pkSearch);
				   employeeInfo = EmployeeAssembler.getInfo(rsAll);
				   employeeInfo.setAccentureDetails(accDet);
				   employeeInfoList.add(employeeInfo);
				}
				return employeeInfoList;	
		}

		RowSet rs = empDao.find(info);
		
		while ( rs.next() ) {
		   pkSearch =	EmployeeAssembler.getInfo(rs).getEmpNo();
		   accDet = (AccentureDetails)empAccDao.findByPK(pkSearch);
		   employeeInfo = EmployeeAssembler.getInfo(rs);
		   employeeInfo.setAccentureDetails(accDet);
		   employeeInfoList.add(employeeInfo);
		}
		return employeeInfoList;
	}
				
}

