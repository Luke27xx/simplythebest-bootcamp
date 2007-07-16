/*
 * Created on Feb 24, 2005
 * 
 * JAVA Development School
 * Copyright 2005 Accenture
 * 
 * 
 *
 */
package com.jds.businesscomponent.stub;

import com.jds.apps.beans.EmployeeInfo;
import com.jds.architecture.exceptions.HRSLogicalException;
import com.jds.architecture.exceptions.HRSSystemException;


/**
 * @author r.c.delos.santos Feb 24, 2005
 * @author last modified by: $Author: r.c.delos.santos $ 
 * @version $Revision: 1.1 $ $Date: 2005/02/24 06:59:54 $
 * 
 */
public class UserManager {

	
	/**
	 * Constructor 
	 * Gets instance of employee dao at employee accenture dao
	 * @throws HRSSystemException
	 */
	public UserManager() throws HRSSystemException {
	    int testValue = 0;
	    
	    if (testValue == 1) {
	        throw new HRSSystemException("user manager stub", new Exception());
	    }
	}
	
	/**
	 * Retrieves employee details from database
	 * @param enterpriseid - user login
	 * @return EmployeeInfo
	 * @throws HRSSystemException
	 * @throws HRSLogicalException
	 */
	public EmployeeInfo getEmployeeUserDetail(String enterpriseid) 
		throws HRSSystemException, HRSLogicalException {
		
	    int testValue = 0;
	    
	    if (testValue == 1) {
	        throw new HRSSystemException("user manager stub", new Exception());
	    }

	    if (testValue == 2) {
	        throw new HRSLogicalException("user manager stub");
	    }

	    EmployeeInfo data = new EmployeeInfo();
		data.setLastName("delos Santos");
		data.setFirstName("Rommel");
		data.setMiddleName("Chua");
		data.setEmpNo("100064010");
		
		return data;
	}
	

}
