/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 10, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.skill.set.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.jds.apps.hr.skill.set.form.ext.AbstractSkillForm;
import com.jds.architecture.exceptions.HRSLogicalException;
import com.jds.architecture.exceptions.HRSSystemException;
import com.jds.architecture.utilities.ObjectIsNull;
import com.jds.architecture.utilities.StringIsEmpty;
import com.jds.architecture.utilities.StringIsValid;
import com.jds.architecture.utilities.StringLengthIsValid;
import com.jds.architecture.utilities.Transformer;
import com.jds.architecture.utilities.VOCollectionToMap;
import com.jds.architecture.utilities.Validator;
//import com.jds.businesscomponent.HRManager;
import com.jds.businesscomponent.stub.HRManager;

/**
 * 
 *
 * @author ma.j.a.valiente
 * @author last modified by: $Author: c.b.balajadia ${date}
 * @version $Revision: 1.6 $ $Date: 2005/03/18 10:03:10 $
 * 
 */
public class SkillForm extends AbstractSkillForm {

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
	   
		   // checking on empty string
		   Validator stringIsEmpty   =  new Validator ( new StringIsEmpty() );
	     
		   // defining valid symbols in string
	       Validator stringIsValidE = new Validator( new StringIsValid("_- .\n\r,/\\+#()") );
	
           String allowedCharactersD = "letters & numbers, underscores, dashes, spaces, dots ";
           String allowedCharactersE = allowedCharactersD + ", line carriage, commas, slashes, pluses, pounds, and parenthesis";        
           
           // defining max lenth of fields
           Validator stringLengthIsValidFifty       = new Validator( new StringLengthIsValid(50) );        
           Validator stringLenghtIsValidHundred 	= new Validator(new StringLengthIsValid(100));
           
           
    // defining errors 
           // Skill fields if its empty , contains illegal characters 
           // or more than max lenght
           if( stringIsEmpty.validate( this.getSkill() ) ) {
        	   errors.add("skill", new ActionError("field.null" ,"skill field is empty"));
           }
           else if( !stringIsValidE.validate(this.getSkill() )  ) {
   			errors.add("skill", new ActionError("field.invalid.specialcharacter", "skill allowed characters are ", allowedCharactersD));
           }
           else if( !stringLengthIsValidFifty.validate( this.getSkill() ) ) {
   			errors.add("skill", new ActionError("field.invalid.length", "skill max length is ", "50"));        	
           }  
           
           // Description field if its empty , contains illegal characters 
           // or more than max lenght
           if( stringIsEmpty.validate( this.getDescription() ) ) {
        	   errors.add("description", new ActionError("field.null" ,"description field is empty"));
           }
           else if( !stringIsValidE.validate(this.getDescription() )  ) {
   			errors.add("description", new ActionError("field.invalid.specialcharacter", "description allowed characters are ", allowedCharactersD));
           }
           else if( !stringLenghtIsValidHundred.validate( this.getDescription() ) ) {
   			errors.add("description", new ActionError("field.invalid.length", "description max length is ", "100"));        	
           }  
    
           return errors;
	}
	
	public List getCategories() {
	    Transformer list = new Transformer( new VOCollectionToMap() );
	    
	    List tempList = new ArrayList();
		try {
		    HRManager hr = HRManager.getInstance();
		    tempList = (List)list.transform( hr.searchApprovedCategories(null) );		    
		} catch (HRSLogicalException logicalException) {
            // create error 
            ActionErrors errors = new ActionErrors();
            errors.add("skillFormError", new ActionError(
                    logicalException.getMessage()));
		} catch (HRSSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  tempList;
	}
}
