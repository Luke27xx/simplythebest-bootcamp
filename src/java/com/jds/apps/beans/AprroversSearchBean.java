/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 15, 2004
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
 * @author last modified by: $Author: r.c.delos.santos $
 * @version $Revision: 1.1 $ $Date: 2005/02/24 05:30:38 $
 * 
 */
public class AprroversSearchBean extends AbstractReferenceData {

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
}
