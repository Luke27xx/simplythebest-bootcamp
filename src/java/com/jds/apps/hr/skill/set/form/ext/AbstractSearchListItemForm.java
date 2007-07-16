/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 10, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.skill.set.form.ext;

import com.jds.architecture.abstraction.AbstractForm;
/**
 * 
 *
 * @author ma.j.a.valiente
 * @author last modified by: $Author: r.c.delos.santos ${date}
 * @version $Revision: 1.1 $ $Date: 2005/02/24 05:30:25 $
 * 
 */
public abstract class AbstractSearchListItemForm extends AbstractForm {

	private String skill;

	/**
	 * @return Returns the skill.
	 */
	public String getSkill() {
		return skill;
	}
    
	/**
	 * @param skill The skill to set.
	 */
	public void setSkill(String skill) {
		this.skill = skill;
	}
    
	private String skillId;

	/**
	 * @return Returns the description.
	 */
	public String getSkillId() {
		return skillId;
	}
    
	/**
	 * @param description The description to set.
	 */
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	private String category;

	/**
	 * @return Returns the description.
	 */
	public String getCategory() {
		return category;
	}
    
	/**
	 * @param description The description to set.
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	private String categoryId;
	/**
	 * @return Returns the description.
	 */
	public String getCategoryId() {
		return categoryId;
	}
    
	/**
	 * @param description The description to set.
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
}
