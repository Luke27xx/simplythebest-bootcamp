/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 10, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.project.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.jds.apps.hr.project.form.ext.AbstractProjectSearchForm;
import com.jds.architecture.utilities.ObjectIsNull;
import com.jds.architecture.utilities.StringIsEmpty;
import com.jds.architecture.utilities.StringIsValid;
import com.jds.architecture.utilities.StringLengthIsValid;
import com.jds.architecture.utilities.Validator;


/**
 * 
 *
 * @author ma.j.a.valiente
 * @author last modified by: $Author: c.b.balajadia ${date}
 * @version $Revision: 1.4 $ $Date: 2005/03/17 08:08:18 $
 * 
 */
public class SearchProjectForm extends AbstractProjectSearchForm {
	
	    
		private List projects;
		public boolean searchMode;
		
	    /* (non-Javadoc)
	     * @see accenture.manila.architecture.abstraction.AbstractForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	     */
	    public ActionErrors validate(ActionMapping mapping, 
	            HttpServletRequest request) {
	
	        ActionErrors errors = new ActionErrors();
	     
            //TODO Implement validation
	        
	        return errors;
	     }
	
	    /**
	     * @return Returns the projects.
	     */
	    public List getProjects() {
	        return projects;
	    }
	    
	    /**
	     * @param projects The projects to set.
	     */
	    public void setProjects(List projects) {
	        this.projects = projects;
	    }

		/**
		 * @return Returns the search results size.
		 */
		public int getListSize() {
			if(projects==null){
				return -1;
			}
			return  projects.size();
		}
		   /**
	     * @return Returns the hasResult.
	     */
	    public String getRecordCount() {
	        return Integer.toString(getListSize());
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
	}

