/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 10, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.project.form;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.jds.apps.hr.project.form.ext.AbstractSearchListItemForm;


/**
 * 
 *
 * @author ma.j.a.valiente
 * @author last modified by: $Author: r.c.delos.santos ${date}
 * @version $Revision: 1.1 $ $Date: 2005/02/24 05:30:48 $
 * 
 */
public class SearchListItemForm extends AbstractSearchListItemForm {
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		return errors;
	}
	
	java.util.Map projectMap;
	
	public java.util.Map getProjectMap(){
		projectMap = new HashMap();
		projectMap.put("id", super.getProjectId());
		return this.projectMap; 
	}
}
