/*
 * Created on Feb 7, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.jds.architecture.service.dao.assembler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.RowSet;

import com.jds.apps.beans.EmployeeInfo;
import com.jds.architecture.service.dao.DAOConstants;


/**
 * @author c.b.balajadia
 * @since HRS 2.0
 * @version 02/2005 -  initial draft
 * EmployeeAssembler is a class used in populating prepared statement
 * and in retrieving employee vo from result set.
 */
public class EmployeeAssembler {

	/**
	 * Populates prepared statement using details of value object
	 * @param employee Employee value object
	 * @param stmt prepared statement from data access object
	 * @throws SQLException 
	 */
	public static void  getPreparedStatement(EmployeeInfo employee, 
			PreparedStatement stmt) throws SQLException {
		stmt.setString(1, employee.getEmpNo());
		stmt.setString(2, employee.getFirstName());
		stmt.setString(3, employee.getLastName());
		stmt.setString(4, employee.getMiddleName());
		stmt.setDate(5, new java.sql.Date(employee.getDob().getTime()));			
		stmt.setInt(6, employee.getAge());
		stmt.setString(7, new Character(employee.getGender()).toString());	
		stmt.setString(8, employee.getCivilStatus());
		stmt.setString(9, employee.getCitizenship());
		stmt.setString(10, employee.getSssNo());
		stmt.setString(11, employee.getTinNo());
		stmt.setString(12, employee.getMobilePhoneNo());
		stmt.setString(13, employee.getHomePhoneNo());
		stmt.setString(14, employee.getStreet1());
		stmt.setString(15, employee.getStreet2());
		stmt.setString(16, employee.getCity());
		stmt.setString(17, employee.getState());
		stmt.setString(18, employee.getCountry());
		stmt.setString(19, employee.getEducationalAttainment());
		stmt.setString(20, employee.getRecognitions());
	}
	
	/**
	 * Creates populated EmployeeInfo vo from the Row set 
	 * @param rs Row Set 
	 * @return EmployeeInfo
	 * @throws SQLException
	 */
	public static EmployeeInfo getInfo(ResultSet rs) throws SQLException   {
		EmployeeInfo employeeReturn  = new EmployeeInfo();
		employeeReturn.setEmpNo(rs.getString("empno"));
		employeeReturn.setFirstName(rs.getString("firstname"));
		employeeReturn.setLastName(rs.getString("lastname"));
		employeeReturn.setMiddleName(rs.getString("middlename"));
		employeeReturn.setDob(new java.util.Date(((java.sql.Timestamp)rs.getObject("dateofbirth")).getTime()));
		employeeReturn.setAge(rs.getInt("age"));		
		employeeReturn.setGender(rs.getString("gender").toCharArray()[0]);
		employeeReturn.setCivilStatus(rs.getString("civilstatus"));
		employeeReturn.setCitizenship(rs.getString("citizenship"));
		employeeReturn.setSssNo(rs.getString("sssno"));
		employeeReturn.setTinNo(rs.getString("tinno"));
		employeeReturn.setMobilePhoneNo(rs.getString("mobileno"));
		employeeReturn.setHomePhoneNo(rs.getString("homeno"));
		employeeReturn.setStreet1(rs.getString("stadd1"));
		employeeReturn.setStreet2(rs.getString("stadd2"));
		employeeReturn.setCity(rs.getString("city"));
		employeeReturn.setState(rs.getString("province"));
		employeeReturn.setCountry(rs.getString("country"));
		employeeReturn.setEducationalAttainment(rs.getString("educattainment"));
		employeeReturn.setRecognitions(rs.getString("recognition"));
		return employeeReturn;
	}
	
	/**
	 * Creates populated EmployeeInfo vo from the Result set 
	 * @param rs Result Set 
	 * @return EmployeeInfo
	 * @throws SQLException
	 */
	public static EmployeeInfo getInfo(RowSet rs) throws SQLException{
		EmployeeInfo employeeReturn  = new EmployeeInfo();
		employeeReturn.setEmpNo(rs.getString("empno"));
		employeeReturn.setFirstName(rs.getString("firstname"));
		employeeReturn.setLastName(rs.getString("lastname"));
		employeeReturn.setMiddleName(rs.getString("middlename"));
		employeeReturn.setDob(new java.util.Date(((java.sql.Timestamp)rs.getObject("dateofbirth")).getTime()));
		employeeReturn.setAge(rs.getInt("age"));		
		employeeReturn.setGender(rs.getString("gender").toCharArray()[0]);
		employeeReturn.setCivilStatus(rs.getString("civilstatus"));
		employeeReturn.setCitizenship(rs.getString("citizenship"));
		employeeReturn.setSssNo(rs.getString("sssno"));
		employeeReturn.setTinNo(rs.getString("tinno"));
		employeeReturn.setMobilePhoneNo(rs.getString("mobileno"));
		employeeReturn.setHomePhoneNo(rs.getString("homeno"));
		employeeReturn.setStreet1(rs.getString("stadd1"));
		employeeReturn.setStreet2(rs.getString("stadd2"));
		employeeReturn.setCity(rs.getString("city"));
		employeeReturn.setState(rs.getString("province"));
		employeeReturn.setCountry(rs.getString("country"));
		employeeReturn.setEducationalAttainment(rs.getString("educattainment"));
		employeeReturn.setRecognitions(rs.getString("recognition"));
		return employeeReturn;
	}
	
	
	public static void toEmptyStringAllNull(EmployeeInfo obj) {
		if(obj.getCivilStatus() == null) obj.setCivilStatus(DAOConstants.STR_SPACE);
		if(obj.getCity() == null) obj.setCity(DAOConstants.STR_SPACE);
		if(obj.getCitizenship() == null) obj.setCitizenship(DAOConstants.STR_SPACE);
		if(obj.getRecognitions() == null) obj.setRecognitions(DAOConstants.STR_SPACE);
		if(obj.getAge() <= 0) obj.setAge(0);
		if(obj.getTinNo() == null) obj.setTinNo(DAOConstants.STR_SPACE);
		if(obj.getStreet2() == null) obj.setStreet2(DAOConstants.STR_SPACE);		    
		if(obj.getHomePhoneNo() == null) obj.setHomePhoneNo(DAOConstants.STR_SPACE);
		if(obj.getMobilePhoneNo() == null) obj.setMobilePhoneNo(DAOConstants.STR_SPACE);
		if(obj.getState() == null) obj.setState(DAOConstants.STR_SPACE);
		if(obj.getCountry() == null) obj.setCountry(DAOConstants.STR_SPACE);
	}
	
	
	
}
