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

public class ProjectInfo extends AbstractReferenceData {

    /**
     *  
     * @uml.property name="client" multiplicity="(0 1)"
     */
    private String client;

    /**
     *  
     * @uml.property name="client"
     */
    public String getClient() {
        return client;
    }

    /**
     *  
     * @uml.property name="client"
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     *  
     * @uml.property name="startDate" multiplicity="(0 1)"
     */
    private Date date;

    /**
     *  
     * @uml.property name="startDate"
     */
    public Date getStartDate() {
        return date;
    }

    /**
     *  
     * @uml.property name="startDate"
     */
    public void setStartDate(Date date) {
        this.date = date;
    }

    /**
     *  
     * @uml.property name="endDate" multiplicity="(0 1)"
     */
    private Date endDate;

    /**
     *  
     * @uml.property name="endDate"
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     *  
     * @uml.property name="endDate"
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProjectName() {
        return getName();
    }

    public void setProjectName(String name) {
        setName(name);
    }

    public String getProjectDescrition() {
        return getDescription();
    }

    public void setProjectDescription(String desc) {
        setDescription(desc);
    }

	/**
	 * @return
	 */
	public String getProjectId() {
		return getId();
	}

	/**
	 * @param string
	 */
	public void setProjectId(String id) {
		setId(id);
	}

}
