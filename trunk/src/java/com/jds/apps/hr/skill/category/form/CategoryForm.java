/*
 * Created on Dec 7, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.apps.hr.skill.category.form;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.jds.apps.Constants;
import com.jds.apps.hr.skill.category.form.ext.AbstractCategoryForm;
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
import com.jds.architecture.utilities.Validator;



/**
 * 
 *
 * @author ma.j.a.valiente
 * @author last modified by: $Author: c.b.balajadia ${date}
 * @version $Revision: 1.4 $ $Date: 2005/03/17 08:08:18 $
 * 
 */
public class CategoryForm extends AbstractCategoryForm {

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();
  
        Validator objectIsNull        =  new Validator( new ObjectIsNull() );
        Validator stringIsEmpty       =  new Validator ( new StringIsEmpty() );

        /*
         	Input validation criteria:

        	D: letters, numbers, underscores (_), dashes (-), spaces ( ), and dots (.) only
        */
        
        Validator stringIsValidD = new Validator( new StringIsValid("_- .") );

        String allowedCharactersD = "letters & numbers, underscores, dashes, spaces, dots ";

        Validator stringLengthIsValidFifty       = new Validator( new StringLengthIsValid(50) );        
        Validator stringLengthIsValidHundred     = new Validator( new StringLengthIsValid(100) );

         String category = this.getCategory();
         String description = this.getDescription();
        
        // Category Name: D validation, max 50 symbols, required
         if ( objectIsNull.validate(category) ||
         stringIsEmpty.validate(category) ) {
        	 errors.add("category", new ActionError("field.null","Category"));
         }
         else if( !stringIsValidD.validate( category ) ){
 			errors.add("category", new ActionError("field.invalid.specialcharacter", "Category", allowedCharactersD));
         }
         else if( !stringLengthIsValidFifty.validate( category ) ){
 			errors.add("category", new ActionError("field.invalid.length", "Category", "50"));        	
         }
         
         // Description: D validation, max 100 symbols, required
         if ( objectIsNull.validate(description) ||
         stringIsEmpty.validate(description) ) {
        	 errors.add("description", new ActionError("field.null","Description"));
         }
         else if( !stringIsValidD.validate( description ) ){
 			errors.add("description", new ActionError("field.invalid.specialcharacter", "Description", allowedCharactersD));
         }
         else if( !stringLengthIsValidHundred.validate( description ) ){
 			errors.add("description", new ActionError("field.invalid.length", "Description", "100"));        	
         }
               
        return errors;
	}
	
}
