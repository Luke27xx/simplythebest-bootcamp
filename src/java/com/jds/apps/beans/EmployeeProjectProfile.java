/*
 * Created on Nov 22, 2004
 *
 * r.c.delos.santos
 * 
 */
package com.jds.apps.beans;

import java.util.Date;

/**
 * @author r.c.delos.santos
 * 
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class EmployeeProjectProfile {

	/**
	 *  
	 * @uml.property name="projectInfo"
	 * @uml.associationEnd inverse="employeeProjectProfile:accenture.manila.hr.exercise.ProjectInfo" multiplicity="(0 1)"
	 */
	private String  empno;


    /**
     *  
     * @uml.property name="projectInfo"
     * @uml.associationEnd inverse="employeeProjectProfile:accenture.manila.hr.exercise.ProjectInfo" multiplicity="(0 1)"
     */
    private ProjectInfo info;



    /**
     *  
     * @uml.property name="projectInfo"
     */
    public ProjectInfo getProjectInfo() {
        return info;
    }

    /**
     *  
     * @uml.property name="projectInfo"
     */
    public void setProjectInfo(ProjectInfo info) {
        this.info = info;
    }

    /**
     *  
     * @uml.property name="role" multiplicity="(0 1)"
     */
    private String role;

    /**
     *  
     * @uml.property name="role"
     */
    public String getRole() {
        return role;
    }

    /**
     *  
     * @uml.property name="role"
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     *  
     * @uml.property name="description" multiplicity="(0 1)"
     */
    private String description;

    /**
     *  
     * @uml.property name="description"
     */
    public String getDescription() {
        return description;
    }

    /**
     *  
     * @uml.property name="description"
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *  
     * @uml.property name="rollinDate" multiplicity="(0 1)"
     */
    private Date rollinDate;

    /**
     *  
     * @uml.property name="rollinDate"
     */
    public Date getRollinDate() {
        return rollinDate;
    }

    /**
     *  
     * @uml.property name="rollinDate"
     */
    public void setRollinDate(Date date) {
        this.rollinDate = date;
    }

    /**
     *  
     * @uml.property name="rolloffDate" multiplicity="(0 1)"
     */
    private Date rolloffDate;

    /**
     *  
     * @uml.property name="rolloffDate"
     */
    public Date getRolloffDate() {
        return rolloffDate;
    }

    /**
     *  
     * @uml.property name="rolloffDate"
     */
    public void setRolloffDate(Date rolloffDate) {
        this.rolloffDate = rolloffDate;
    }

	/**
	 * @return
	 */
	public String getEmpno() {
		return empno;
	}

	/**
	 * @param string
	 */
	public void setEmpno(String string) {
		empno = string;
	}

}
