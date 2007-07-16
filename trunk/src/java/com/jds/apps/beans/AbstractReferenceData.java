/*
 * Created on Nov 24, 2004
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

public abstract class AbstractReferenceData {

    /**
     *  
     * @uml.property name="name" multiplicity="(0 1)"
     */
    private String name;

    /**
     *  
     * @uml.property name="name"
     */
    public String getName() {
        return name;
    }

    /**
     *  
     * @uml.property name="name"
     */
	public void setName(String name) {
        this.name = name;
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
     * @uml.property name="status" multiplicity="(0 1)"
     */
    private String status;

    /**
     *  
     * @uml.property name="status"
     */
    public String getStatus() {
        return status;
    }

    /**
     *  
     * @uml.property name="status"
     */
    public void setStatus(String status) {
        this.status = status;
    }

	private String id;
	
	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param string
	 */
	public void setId(String string) {
		id = string;
	}

}
