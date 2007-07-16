/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 15, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.beans.valueutil;

import com.jds.apps.beans.SkillsInformation;
import com.jds.apps.hr.skill.set.form.SearchListItemForm;
import com.jds.apps.hr.skill.set.form.SkillForm;



/**
 * 
 *
 * @author ma.j.a.valiente
 * @author last modified by: $Author: r.c.delos.santos $
 * @version $Revision: 1.1 $ $Date: 2005/02/24 05:30:44 $
 * 
 */
public class SkillInformationValueUtil {

    public static void formToValue(SkillForm form, 
    		SkillsInformation value) {
        
    	value.setSkillId(form.getSkillId());
    	System.out.println("A"+form.getSkillId());
    	value.setSkillName(form.getSkill());
    	System.out.println("B"+form.getSkill());
    	value.setSkillDescription(form.getDescription());
    	System.out.println("C"+form.getDescription());
    	value.setCategoryId(form.getCategoryId());
    	System.out.println("D"+form.getCategory());
    	value.setCategoryName(form.getCategoryId());
    	System.out.println("E"+form.getCategory());
    }

    public static void valueToForm(SkillsInformation value, 
    		SkillForm form) {
        
        form.setSkillId(value.getId());
        form.setSkill(value.getSkillName());
        form.setDescription(value.getSkillDescription());
        form.setCategoryId(value.getCategoryId());
        form.setCategory(value.getCategoryName());
    }

	public static void valueToListForm(SkillsInformation value, SearchListItemForm	form) {
	    
	    form.setSkillId(value.getSkillId());
	    System.out.println(form.getSkillId());
	    form.setSkill(value.getSkillName());
	    System.out.println(form.getSkill());
	    form.setCategory(value.getCategoryName());
	    System.out.println(form.getCategory());
	    form.setCategoryId(value.getCategoryId());
	    System.out.println(form.getCategoryId());
	}

}
