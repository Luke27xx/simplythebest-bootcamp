/*
 * Created on Dec 9, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.jds.apps.hr.skill.category.form;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.jds.apps.hr.skill.category.form.ext.AbstractSearchListItemForm;


/**
 * @author ma.j.a.valiente
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SearchListItemForm extends AbstractSearchListItemForm {
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		return errors;
	}
	
	java.util.Map categoryMap;
	
	public java.util.Map getCategoryMap(){
		categoryMap = new HashMap();
		categoryMap.put("id", super.getCategoryId());
		return this.categoryMap; 
	}

	
}
