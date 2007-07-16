/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 7, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.skill.category.form.ext;

import com.jds.architecture.abstraction.AbstractForm;

/**
 * 
 *
 * @author ma.j.a.valiente
 * @author last modified by: $Author: r.c.delos.santos ${date}
 * @version $Revision: 1.1 $ $Date: 2005/02/24 05:30:35 $
 * 
 */
public abstract class AbstractCategoryForm extends AbstractForm {

	private String category;

	/**
	 * @return Returns the category.
	 */
	public String getCategory() {
		return category;
	}
    
	/**
	 * @param category The category to set.
	 */
	public void setCategory(String category) {
	    if( category != null ){
	        category = category.trim();
	    }
		this.category = category;
	}
    
	private String description;

	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}
    
	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
	    if( description != null ){
	        description = description.trim();
	    }
		this.description = description;
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
