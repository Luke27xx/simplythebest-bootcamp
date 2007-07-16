/*
 * Created on Dec 7, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.apps.hr.skill.category.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.jds.apps.hr.skill.category.form.ext.AbstractCategoryForm;
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
public class CategoryForm extends AbstractCategoryForm {

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();
  
       //TODO: Implement validation
        
		return errors;
	}
	
}
