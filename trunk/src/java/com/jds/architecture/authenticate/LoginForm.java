/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 3, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.architecture.authenticate;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.jds.architecture.authenticate.ext.AbstractLoginForm;


/**
 * 
 *
 * @author r.c.delos.santos
 * @author last modified by: $Autohr: rds ${date}
 * @version $Revision $ $Date: 2005/02/24 05:30:47 $
 * 
 */
public class LoginForm extends AbstractLoginForm {

	/**
	 * 
	 */
    public ActionErrors validate(ActionMapping mapping, 
            HttpServletRequest request) {

		boolean bValidUsername = true;
		ActionErrors errors = new ActionErrors();
        
        if(super.getUsername().equals(null) || super.getUsername().equals("")) {
            errors.add("username", new ActionError("username.null"));
			bValidUsername = false;
        }
        
		if(super.getPassword().equals(null) || super.getPassword().equals("")) {
			errors.add("password", new ActionError("password.null"));
		}
        
		if(!super.getPassword().equalsIgnoreCase("HR") && 
				!super.getPassword().equalsIgnoreCase("STAFF") &&
				!super.getPassword().equalsIgnoreCase("APPROVER") &&
				bValidUsername) {
			errors.add("username", new ActionError("username.notexist", 
					super.getUsername()));
		}
		
        return errors;
    }

}
