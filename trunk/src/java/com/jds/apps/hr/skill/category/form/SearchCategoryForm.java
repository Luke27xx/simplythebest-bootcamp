/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 3, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.skill.category.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.jds.apps.Constants;
import com.jds.apps.hr.employee.form.ext.AbstractEmployeeForm;
import com.jds.apps.hr.skill.category.form.ext.AbstractCategorySearchForm;
import com.jds.architecture.exceptions.HRSLogicalException;
import com.jds.architecture.exceptions.HRSSystemException;
import com.jds.architecture.utilities.CalendarIsValid;
import com.jds.architecture.utilities.CalendarToIntArray;
import com.jds.architecture.utilities.EmailIsValid;
import com.jds.architecture.utilities.ObjectIsNull;
import com.jds.architecture.utilities.StringIsAlphaNumeric;
import com.jds.architecture.utilities.StringIsEmpty;
import com.jds.architecture.utilities.StringIsNumeric;
import com.jds.architecture.utilities.StringIsValid;
import com.jds.architecture.utilities.StringLengthIsValid;
import com.jds.architecture.utilities.Transformer;
import com.jds.architecture.utilities.VOCollectionToMap;
import com.jds.architecture.utilities.Validator;
import com.jds.businesscomponent.stub.HRManager;



/**
 * 
 *
 * @author ma.j.a.valiente
 * @author last modified by: $Author: c.b.balajadia ${date}
 * @version $Revision: 1.4 $ $Date: 2005/03/17 08:08:18 $
 * 
 */
public class SearchCategoryForm extends AbstractCategorySearchForm {
	
	    
		private List categories = null;
		private boolean searchMode;
	    /* (non-Javadoc)
	     * @see accenture.manila.architecture.abstraction.AbstractForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	     */
	    public ActionErrors validate(ActionMapping mapping, 
	            HttpServletRequest request) {
	
	        ActionErrors errors = new ActionErrors();
	    	
	        Validator objectIsNull        =  new Validator( new ObjectIsNull() );
	        Validator stringIsEmpty       =  new Validator ( new StringIsEmpty() );
	        Validator calendarIsValid     =  new Validator( new CalendarIsValid() );
        
	        //TODO Implement validation
	        /*
	         * Input validation criteria:
	         * D: letters, numbers, underscores (_), dashes (-), spaces ( ), and dots (.) only
	         */  
	        Validator stringIsValidC = new Validator( new StringIsAlphaNumeric() );
	        Validator stringIsValidD = new Validator( new StringIsValid("_- .") );
	        
	        String allowedCharactersC = "letters & numbers";
	        String allowedCharactersD = allowedCharactersC + ", underscores, dashes, spaces, dots ";
	        
	        Validator stringLengthIsValidFifty = new Validator( new StringLengthIsValid(50) ); 
	        
	        // Category Name: if it's empty, has a special character, or exceeds it's maximum length
	        if( objectIsNull.validate(this.getCategories() ) ||
	                stringIsEmpty.validate( this.getCategories() ) ){
	        	errors.add("categoryName", new ActionError("field.null","Category Name"));
	        }
	        else if( !stringIsValidD.validate( this.getCategories() ) ){
				errors.add("categoryName", new ActionError("field.invalid.specialcharacter", "Category Name", allowedCharactersD));
	        }
	        else if( !stringLengthIsValidFifty.validate( this.getCategories() ) ){
				errors.add("categoryName", new ActionError("field.invalid.length", "Category Name", "50"));        	
	        }    
	        return errors;
	     }
	
	    /**
	     * @return Returns the categories.
	     */
	    public List getCategories() {
	        return categories;
	    }
	    
	    /**
	     * @param categories The categories to set.
	     */
	    public void setCategories(List categories) {
	        this.categories = categories;
	    }

		/**
		 * @return Returns the search results size.
		 */
		public int getListSize() {
			if(categories == null) {
				return -1;
			}
			return  categories.size();
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

