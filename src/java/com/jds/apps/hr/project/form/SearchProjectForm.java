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
import com.jds.architecture.utilities.StringIsAlphaNumeric;
import com.jds.architecture.utilities.StringIsEmpty;
import com.jds.architecture.utilities.StringIsNumeric;
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
	        //Validator objectIsNull        =  new Validator( new ObjectIsNull() );
	        //Validator stringIsEmpty       =  new Validator ( new StringIsEmpty() );
	        
	        //Validator stringIsValidA = new Validator( new StringIsNumeric() );
	        //Validator stringIsValidB = new Validator( new StringIsNumeric(" -") );
	        //Validator stringIsValidC = new Validator( new StringIsAlphaNumeric() );
	        Validator stringIsValidD = new Validator( new StringIsValid("_- .") );
	        //Validator stringIsValidE = new Validator( new StringIsValid("_- .\n\r,/\\+#()") );
	        
	        //String allowedCharactersA = "numbers";
	        //String allowedCharactersB = "numbers, spaces, and dashes ";        
	        String allowedCharactersC = "letters & numbers";
	        String allowedCharactersD = allowedCharactersC + ", underscores, dashes, spaces, dots ";
	        //String allowedCharactersE = allowedCharactersD + ", line carriage, commas, slashes, pluses, pounds, and parenthesis";        
	        
	       // Validator stringLengthIsValidFive        = new Validator( new StringLengthIsValid(5) );
	      //  Validator stringLengthIsValidFifteen     = new Validator( new StringLengthIsValid(15) );        
	        //Validator stringLengthIsValidThirty      = new Validator( new StringLengthIsValid(30) );        
	          Validator stringLengthIsValidFifty       = new Validator( new StringLengthIsValid(50) );        
	       // Validator stringLengthIsValidHundred     = new Validator( new StringLengthIsValid(100) );
	       // Validator stringLengthIsValidFiveHundred = new Validator( new StringLengthIsValid(500) );
	        
	        if( !stringIsValidD.validate( this.getProjectCriteria() ) ){
				errors.add("projName", new ActionError("field.invalid.specialcharacter", "Project Name", allowedCharactersD));
	        }        
	        else if( !stringLengthIsValidFifty.validate( this.getProjectCriteria() ) ){
				errors.add("projName", new ActionError("field.invalid.length", "Project Name", "50"));        	
	        } 
	        
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

