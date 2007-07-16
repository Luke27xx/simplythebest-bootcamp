/*
 * Created on Dec 10, 2004
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
 * @author last modified by: $Author: r.c.delos.santos ${date}
 * @version $Revision: 1.1 $ $Date: 2005/02/24 05:30:40 $
 * 
 */
public abstract class AbstractSearchListItemForm extends AbstractForm {

	private String project;

	/**
	 * @return Returns the skill.
	 */
	public String getProject() {
		return project;
	}
    
	/**
	 * @param skill The skill to set.
	 */
	public void setProject(String project) {
		this.project = project;
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
	public void setStartDate(String startDay) {
		this.startDate = startDay;
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
	public void setEndDate(String endDay) {
		this.endDate = endDay;
	}
}
