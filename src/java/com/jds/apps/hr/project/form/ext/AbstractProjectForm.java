/*
 * Created on Dec 11, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.apps.hr.project.form.ext;

import com.jds.architecture.abstraction.AbstractForm;

/**
 * 
 *
 * @author ma.j.a.valiente
 * @author last modified by: $Author: eugene.p.lozada ${date}
 * @version $Revision: 1.2 $ $Date: 2005/03/07 08:15:25 $
 * 
 */
public abstract class AbstractProjectForm extends AbstractForm {
	private String project;
	/**
	 * @return Returns the project.
	 */
	public String getProject() {
		return project;
	}
    
	/**
	 * @param description The description to set.
	 */
	public void setProject(String project) {
	    if( project != null ){
	        project = project.trim();
	    }
		this.project = project;
	}

	private String description;

	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}
    
	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
	    if( description != null ){
	        description = description.trim();
	    }
		this.description = description;
	}
	
	private String projectId;

	/**
	 * @return Returns the description.
	 */
	public String getProjectId() {
		return projectId;
	}
    
	/**
	 * @param description The description to set.
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	private String client;

	/**
	 * @return Returns the client.
	 */
	public String getClient() {
		return client;
	}
    
	/**
	 * @param client The client to set.
	 */
	public void setClient(String client) {
	    if( client != null ){
	        client = client.trim();
	    }
		this.client = client;
	}

	private String startDay;

	/**
	 * @return Returns the start date day of the project.
	 */
	public String getStartDay() {
		return startDay;
	}
    
	/**
	 * @param startDay The start date day to set.
	 */
	public void setStartDay(String startDay) {
	    if( startDay != null ){
	        startDay = startDay.trim();
	    }
		this.startDay = startDay;
	}

	private String startMonth;

	/**
	 * @return Returns the start date month of the project.
	 */
	public String getStartMonth() {
		return startMonth;
	}
    
	/**
	 * @param startMonth The start date month to set.
	 */
	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	private String startYear;

	/**
	 * @return Returns the start date year of the project.
	 */
	public String getStartYear() {
		return startYear;
	}
    
	/**
	 * @param startYear The start date year to set.
	 */
	public void setStartYear(String startYear) {
	    if( startYear != null ){
	    	startYear = startYear.trim();
	    }
		this.startYear = startYear;
	}

	private String endDay;

	/**
	 * @return Returns the end date of the project.
	 */
	public String getEndDay() {
		return endDay;
	}
    
	/**
	 * @param endDate The end date to set.
	 */
	public void setEndDay(String endDay) {
	    if( endDay != null ){
	        endDay = endDay.trim();
	    }
		this.endDay = endDay;
	}
	private String endMonth;

	/**
	 * @return Returns the end date month of the project.
	 */
	public String getEndMonth() {
		return endMonth;
	}
    
	/**
	 * @param endMonth The end date month to set.
	 */
	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}

	private String endYear;

	/**
	 * @return Returns the end date year of the project.
	 */
	public String getEndYear() {
		return endYear;
	}
    
	/**
	 * @param endYear The end date year to set.
	 */
	public void setEndYear(String endYear) {
	    if( endYear != null ){
	    	endYear = endYear.trim();
	    }
		this.endYear = endYear;
	}

	private String startDate;

	/**
	 * @return Returns the start date of the project.
	 */
	public String getStartDate() {
		return startDate;
	}
    
	/**
	 * @param startDate The start date to set.
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	private String endDate;

	/**
	 * @return Returns the end date of the project.
	 */
	public String getEndDate() {
		return endDate;
	}
    
	/**
	 * @param endDate The end date to set.
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
