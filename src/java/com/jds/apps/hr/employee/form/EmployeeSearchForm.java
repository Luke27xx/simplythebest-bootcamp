/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 3, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.employee.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.jds.apps.hr.employee.form.ext.AbstractEmployeeSearchFrom;
import com.jds.architecture.utilities.ObjectIsNull;
import com.jds.architecture.utilities.StringIsEmpty;
import com.jds.architecture.utilities.StringIsValid;
import com.jds.architecture.utilities.StringLengthIsValid;
import com.jds.architecture.utilities.Validator;


/**
 * 
 *
 * @author r.c.delos.santos
 * @author last modified by: $Author: c.b.balajadia ${date}
 * @version $Revision: 1.6 $ $Date: 2005/03/17 08:04:49 $
 * 
 */
public class EmployeeSearchForm extends AbstractEmployeeSearchFrom {

    private List employees;
    private boolean searchMode;
    private String messageKey;
        
    /* (non-Javadoc)
     * @see accenture.manila.architecture.abstraction.AbstractForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    public ActionErrors validate(ActionMapping mapping, 
            HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        
//      TODO Implement validation
        
        return errors;
     }

    /**
     * @return Returns the employees.
     */
    public List getEmployees() {
        return employees;
    }
    
    /**
     * @param employees The employees to set.
     */
    public void setEmployees(List employees) {
        this.employees = employees;
    }

    /**
     * @return Returns the hasResult.
     */
    public int getListSize() {
        if(employees == null){
            return -1;
        }
        
        return employees.size();
    }

    /**
     * @return Returns the hasResult.
     */
    public String getRecordCount() {
        return Integer.toString(getListSize());
    }

    /**
     * @return Returns the searchMode.
     */
    public boolean isSearchMode() {
        return searchMode;
    }
    
    /**
     * @param searchMode The searchMode to set.
     */
    public void setSearchMode(boolean searchMode) {
        this.searchMode = searchMode;
    }
    
    /**
     * @return Returns the messageKey.
     */
    public String getMessageKey() {
        
        if(0 == getListSize()){
            return "search.zeroresult";
        } else {
            return "search.resultcount";
        }
    }
        
}
