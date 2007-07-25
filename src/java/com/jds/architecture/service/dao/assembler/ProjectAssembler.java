package com.jds.architecture.service.dao.assembler;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.sql.RowSet;

import com.jds.apps.beans.EmployeeInfo;
import com.jds.apps.beans.ProjectInfo;
import com.jds.architecture.service.dao.DAOConstants;

public class ProjectAssembler {

	/**
	 * Populates prepared statement using details of value object
	 * @param project Project value object
	 * @param stmt prepared statement from data access object
	 * @throws SQLException 
	 */
	public static void  getPreparedStatement(ProjectInfo project, 
		PreparedStatement stmt) throws SQLException {
		stmt.setString(1, project.getProjectId() );
		stmt.setString(2, project.getProjectName() );
		stmt.setString(3, project.getProjectDescrition() );
		stmt.setDate(4, new java.sql.Date(project.getStartDate().getTime() ) );
		stmt.setDate(5, new java.sql.Date(project.getEndDate().getTime() ) );
		stmt.setString(6, project.getClient() );
		//stmt.setString(7, project.getStatus() );
		
			
	}
	
	/**
	 * Creates populated ProjectInfo vo from the Row set 
	 * @param rs Row Set 
	 * @return ProjectInfo
	 * @throws SQLException
	 */
	public static ProjectInfo getInfo(ResultSet rs) throws SQLException   {
		ProjectInfo projectReturn  = new ProjectInfo();
		projectReturn.setProjectId(rs.getString("id") );
		projectReturn.setProjectName(rs.getString("name") ); 
		projectReturn.setProjectDescription(rs.getString("description") );
		projectReturn.setStartDate(new java.util.Date(((java.sql.Timestamp)rs.getObject("startDate")).getTime()));
		projectReturn.setEndDate(new java.util.Date(((java.sql.Timestamp)rs.getObject("endDate")).getTime()));
		projectReturn.setClient(rs.getString("clientname") );
		projectReturn.setStatus(rs.getString("status") );
		return projectReturn;
	}
	
	public static ProjectInfo getInfo(RowSet rs) throws SQLException   {
		ProjectInfo projectReturn  = new ProjectInfo();
		projectReturn.setProjectId(rs.getString("id") );
		projectReturn.setProjectName(rs.getString("name") ); 
		projectReturn.setProjectDescription(rs.getString("description") );
		projectReturn.setStartDate(new java.util.Date(((java.sql.Timestamp)rs.getObject("startDate")).getTime()));
		projectReturn.setEndDate(new java.util.Date(((java.sql.Timestamp)rs.getObject("endDate")).getTime()));
		projectReturn.setClient(rs.getString("clientname") );
		projectReturn.setStatus(rs.getString("status") );
		return projectReturn;
	}
	

		public static void toEmptyStringAllNull(ProjectInfo obj) {
		if(obj.getProjectDescrition() == null) obj.setProjectDescription(DAOConstants.STR_SPACE);
		
	
	}
}
