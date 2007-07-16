/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 15, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.beans.valueutil;

import com.jds.apps.beans.SkillCategory;
import com.jds.apps.hr.skill.category.form.CategoryForm;
import com.jds.apps.hr.skill.category.form.SearchListItemForm;


/**
 * 
 *
 * @author ma.j.a.valiente
 * @author last modified by: $Author: r.c.delos.santos $
 * @version $Revision: 1.1 $ $Date: 2005/02/24 05:30:44 $
 * 
 */
public class SkillCategoryValueUtil {

    public static void formToValue(CategoryForm form, 
    		SkillCategory value) {
        
    	value.setCategoryId(form.getCategoryId());
    	value.setCategoryName(form.getCategory());
    	value.setCategoryDescription(form.getDescription());
    }

    public static void valueToListForm(SkillCategory value, 
    		SearchListItemForm form) {
        
        form.setCategoryId(value.getCategoryId());
        form.setCategory(value.getCategoryName());
    }

	public static void valueToForm(SkillCategory value, 
			CategoryForm form) {
	    
	    form.setCategoryId(value.getId());
	    form.setCategory(value.getCategoryName());
	    form.setDescription(value.getCategoryDescription());
	}

}
