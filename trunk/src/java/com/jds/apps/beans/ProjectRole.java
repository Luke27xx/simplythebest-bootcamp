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

public class ProjectRole {

    /**
     *  
     * @uml.property name="rollinDate" multiplicity="(0 1)"
     */
    private Date date;

    /**
     *  
     * @uml.property name="rollinDate"
     */
    public Date getRollinDate() {
        return date;
    }

    /**
     *  
     * @uml.property name="rollinDate"
     */
    public void setRollinDate(Date date) {
        this.date = date;
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
     * @uml.property name="task" multiplicity="(0 1)"
     */
    private String task;

    /**
     *  
     * @uml.property name="task"
     */
    public String getTask() {
        return task;
    }

    /**
     *  
     * @uml.property name="task"
     */
    public void setTask(String task) {
        this.task = task;
    }

}
