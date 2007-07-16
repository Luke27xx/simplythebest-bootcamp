/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 15, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.beans;

/**
 * 
 *
 * @author r.c.delos.santos
 * @author last modified by: $Author: r.c.delos.santos $
 * @version $Revision: 1.1 $ $Date: 2005/02/24 05:30:38 $
 * 
 */
public class ApproversSearchBean extends AbstractReferenceData {

    private String type;
    private AbstractReferenceData aData;
    
    public ApproversSearchBean () {
    	
    }
    
	public ApproversSearchBean (AbstractReferenceData aData) {
		this.aData = aData;
    	this.setId(this.aData.getId());
    	this.setName(this.aData.getName());
    	this.setStatus(this.aData.getStatus());
    	this.setDescription(this.aData.getDescription());
  
	}
		
	public void setAbstractReferenceData(AbstractReferenceData aData){
		this.aData = aData;
	}
	
    /**
     * @return Returns the type.
     */
    public String getType() {
        return type;
    }
    
    /**
     * @param type The type to set.
     */
    public void setType(String type) {
        this.type = type;
    }
    public SkillCategory convertToSkillCategory(AbstractReferenceData data) {
		this.aData = data;
		SkillCategory catData = null;
		if (this.aData != null) {
			catData = new SkillCategory();
			catData.setId(this.aData.getId());
			catData.setName(this.aData.getName());
			catData.setDescription(this.aData.getDescription());
			catData.setStatus(this.aData.getStatus());
		}
		return catData;
    }
    
	public SkillCategory convertToSkillCategory() {
		SkillCategory catData = new SkillCategory();
		catData.setId(this.getId());
		catData.setName(this.getName());
		catData.setDescription(this.getDescription());
		catData.setStatus(this.getStatus());
		return catData;
	}
	
	public SkillsInformation convertToSkills(AbstractReferenceData data) {
		this.aData = data;
		SkillsInformation skillData = null;
		if (this.aData != null) {
			skillData = new SkillsInformation();
			skillData.setId(this.aData.getId());
			skillData.setName(this.aData.getName());
			skillData.setDescription(this.aData.getDescription());
			skillData.setStatus(this.aData.getStatus());
		}
		
		return skillData;
	}
    
	public SkillsInformation convertToSkills() {
		SkillsInformation skillData = new SkillsInformation();
		skillData.setId(this.getId());
		skillData.setName(this.getName());
		skillData.setDescription(this.getDescription());
		skillData.setStatus(this.getStatus());
		return skillData;
	}
	
	public ProjectInfo convertToProject(AbstractReferenceData data) {
		this.aData = data;
		ProjectInfo projData = null;
		if (this.aData != null) {
			projData = new ProjectInfo();
			projData.setId(this.aData.getId());
			projData.setName(this.aData.getName());
			projData.setDescription(this.aData.getDescription());
			projData.setStatus(this.aData.getStatus());
		}
		return projData;
	}
    
	public ProjectInfo convertToProject() {
		ProjectInfo projData = new ProjectInfo();
		projData.setId(this.getId());
		projData.setName(this.getName());
		projData.setDescription(this.getDescription());
		projData.setStatus(this.getStatus());
		return projData;
	}
}
