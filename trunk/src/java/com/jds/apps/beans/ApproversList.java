/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 13, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.beans;

/**
 * 
 *
 * @author r.c.delos.santos
 * @author last modified by: $Author: r.c.delos.santos ${date}
 * @version $Revision: 1.1 $ $Date: 2005/02/24 05:30:38 $
 * 
 */
public class ApproversList extends AbstractReferenceData {

    private String details; 
    /**
     * @return Returns the details.
     */
    public String getDetails() {
        return details;
    }
    /**
     * @param details The details to set.
     */
    public void setDetails(String details) {
        this.details = details;
    }
    private String id;
    /**
     * @return Returns the id.
     */
    public String getId() {
        return id;
    }
    /**
     * @param id The id to set.
     */
    public void setId(String id) {
        this.id = id;
    }
    private String status;
    /**
     * @return Returns the status.
     */
    public String getStatus() {
        return status;
    }
    /**
     * @param status The status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }
    private String tableName;
    /**
     * @return Returns the tableName.
     */
    public String getTableName() {
        return tableName;
    }
    /**
     * @param tableName The tableName to set.
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    private String type;
    /**
     * @return Returns the type.
     */
    public String getType() {
        return type;
    }
    /**
     * @param type The type to set.
     */
    public void setType(String type) {
        this.type = type;
    }
}
