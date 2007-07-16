/*
 * Created on Nov 22, 2004
 *
 * r.c.delos.santos
 * 
 */
package com.jds.apps.beans;

/**
 * @author r.c.delos.santos
 * 
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class SkillsInformation extends AbstractReferenceData {
	
	public String getSkillId() {
		return getId();
	}

	public void setSkillId(String id) {
		setId(id);
	}

    public String getSkillName() {
        return getName();
    }

    public void setSkillName(String name) {
        setName(name);
    }

    public String getSkillDescription() {
        return getDescription();
    }

    public void setSkillDescription(String desc) {
        setDescription(desc);
    }

    private String categoryId;
    private String categoryName;

	/**
	 * @return Returns the categoryId.
	 */
	public String getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId The categoryId to set.
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return Returns the categoryName.
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName The categoryName to set.
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
