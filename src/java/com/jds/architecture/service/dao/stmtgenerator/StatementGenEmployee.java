/*
 * Created on Jan 11, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.architecture.service.dao.stmtgenerator;

import org.apache.log4j.Logger;

import com.jds.apps.beans.EmployeeInfo;
import com.jds.architecture.service.dao.DAOConstants;
import com.jds.architecture.service.dao.assembler.EmployeeAssembler;
import com.jds.architecture.utilities.CalendarToString;
import com.jds.architecture.utilities.Transformer;


/**
 * StatementGenEmployee is a class that generates SQL statements for EmployeeInfo
 * Statement Generator DAO functions
 * @author c.b.balajadia
 * @author last modified by: $Author: c.b.balajadia $
 * @version 11/2005 initial draft
 * 			02/18/2005 - created JavaDocs
 * 					   
 * @since HRS 2.0
 *
 */
public class StatementGenEmployee extends StatementGenerator {

	Logger log = Logger.getLogger(StatementGenEmployee.class);
		
	/**
	 * transformStmt creates an extension for SQL statements
	 * @param Object object 
	 * @param int stmtType  
	 * @throws Exception throws exception when unexpected error occurs
	 */
	public String transformStmt(Object object, int stmtType) throws Exception {
		StringBuffer strBuffer = new StringBuffer();
		String strTemp = null;
		String strConstant =  DAOConstants.STR_AND;
		boolean isSet = false;
		EmployeeInfo obj = (EmployeeInfo)object;
        
		if (stmtType == DAOConstants.STMT_TYPE_SET) {
			strConstant = DAOConstants.CHAR_COMMA;
			isSet = true;
			EmployeeAssembler.toEmptyStringAllNull(obj);
		}
         
        
		if(obj.getEmpNo() != null) {			
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_EMPNO, 
					obj.getEmpNo(), strConstant));				
			
		} 
		
		
        
		if(obj.getFirstName() != null) {  
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_FNAME, 
					obj.getFirstName(), strConstant));	
			log.debug("firstname:" + strBuffer.toString());			
			
		} 
        
		if(obj.getLastName() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_LNAME, 
					obj.getLastName(), strConstant));				
			
		} 
		
		
		if(obj.getMiddleName() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_MNAME, 
					obj.getMiddleName(), strConstant));				
			
		} 
		
		if(obj.getCivilStatus() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_CSTATUS, 
					obj.getCivilStatus(), strConstant));				
			
		} 
		
		if(obj.getCity() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_CITY, 
					obj.getCity(), strConstant));				
			
		} 
		
		if(obj.getCitizenship() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_CITIZEN, 
					obj.getCitizenship(), strConstant));						
		}
		
		if(obj.getRecognitions() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_RECOG, 
					obj.getRecognitions(), strConstant));						
			
		}  
		
		if(obj.getEducationalAttainment() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_EDUC, 
					obj.getEducationalAttainment(), strConstant));						
			
		}  
		
		if(obj.getGender() != '\u0000') {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_GENDER, 
				Character.toString(obj.getGender()), strConstant));									 
		}  

		if(obj.getAge() > 0) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_AGE, 
				String.valueOf(obj.getAge()), strConstant));						
		} 
		
		if(obj.getDob() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_DOB, 
					(String)Transformer.transform(new CalendarToString(), obj.getDob())
					, strConstant));
		}
		
		if(obj.getSssNo() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_SSSNO, 
				String.valueOf(obj.getSssNo()), strConstant));						
		}
		
		if(obj.getTinNo() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_TINNO, 
				String.valueOf(obj.getTinNo()), strConstant));						
		}
		
		if(obj.getStreet1() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_STADD1, 
				String.valueOf(obj.getStreet1()), strConstant));						
		}
		
		if(obj.getStreet2() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_STADD2, 
				String.valueOf(obj.getStreet2()), strConstant));						
		}
				    
				    
		if(obj.getHomePhoneNo() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_HOMENO, 
				String.valueOf(obj.getHomePhoneNo()), strConstant));						
		}
		
		if(obj.getMobilePhoneNo() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_MOBILENO, 
				String.valueOf(obj.getMobilePhoneNo()), strConstant));						
		}
		
		if(obj.getState() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_PROVINCE, 
				String.valueOf(obj.getState()), strConstant));						
		}
		
		if(obj.getCountry() != null) {
			strBuffer.append(getColumnValue(isSet, DAOConstants.COL_COUNTRY, 
				String.valueOf(obj.getCountry()), strConstant));						
		}
		
		if ( strBuffer.toString().length() > 0) {
			if (stmtType == DAOConstants.STMT_TYPE_SET) { 
				strTemp = strBuffer.toString().substring(0,
				strBuffer.toString().length()-1);
			} else {
				strTemp = strBuffer.toString().substring(0, 
				strBuffer.toString().lastIndexOf(DAOConstants.STR_AND));
			}
		}

		log.debug("transform strTemp:" + strTemp);
		return strTemp;
	}

}
