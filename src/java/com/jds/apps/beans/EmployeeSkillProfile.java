/*
 * Created on Nov 22, 2004
 *
 * r.c.delos.santos
 * 
 */
package com.jds.apps.beans;

/**
 * @author r.c.delos.santos
 * 
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class EmployeeSkillProfile {

	private int yrsOfExperience;
	private int levelOfInterest;
	private int yearLastUsed;
	
    /**
     *  
     * @uml.property name="proficiency" multiplicity="(0 1)"
     */
    private int proficiency;

    /**
     *  
     * @uml.property name="proficiency"
     */
    public int getProficiency() {
        return proficiency;
    }

    /**
     *  
     * @uml.property name="proficiency"
     */
    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }

    /**
     *  
     * @uml.property name="skillsInformation"
     * @uml.associationEnd inverse="employeeSkillProfile:accenture.manila.hr.apps.SkillsInformation" multiplicity="(0 1)"
     */
    private SkillsInformation skillsInformation;

    /**
     *  
     * @uml.property name="skillsInformation"
     */
    public SkillsInformation getSkillsInformation() {
        return skillsInformation;
    }

    /**
     *  
     * @uml.property name="skillsInformation"
     */
    public void setSkillsInformation(SkillsInformation information) {
        this.skillsInformation = information;
    }

	private String employeeId;
	
	/**
	 * @return
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param string
	 */
	public void setEmployeeId(String string) {
		employeeId = string;
	}
	
	private String details;

	/**
	 * @return
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param string
	 */
	public void setDetails(String string) {
		details = string;
	}
	
	/**
	 * @return
	 */
	public int getLevelOfInterest() {
		return levelOfInterest;
	}

	/**
	 * @return
	 */
	public int getYearLastUsed() {
		return yearLastUsed;
	}

	/**
	 * @return
	 */
	public int getYrsOfExperience() {
		return yrsOfExperience;
	}

	/**
	 * @param i
	 */
	public void setLevelOfInterest(int i) {
		levelOfInterest = i;
	}

	/**
	 * @param i
	 */
	public void setYearLastUsed(int i) {
		yearLastUsed = i;
	}

	/**
	 * @param i
	 */
	public void setYrsOfExperience(int i) {
		yrsOfExperience = i;
	}

}
