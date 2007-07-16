/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 4, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps;

import java.util.Map;

/**
 * 
 *
 * @author r.c.delos.santos
 * @author last modified by: $Author: r.c.delos.santos $
 * @version $Revision: 1.1 $ $Date: 2005/02/24 05:30:50 $
 * 
 */
public class Constants {

    /**/
    private int ctr;
    private java.util.Iterator iterate;

    public static String TABLE_PROJ = "Project";
	public static String TABLE_SKILL = "Skill";
	public static String TABLE_SKILLCATEGORY = "SkillCategory";
	

	private java.util.List gender      = new java.util.ArrayList();
    private java.util.List state       = new java.util.ArrayList();
    private java.util.List serviceLine = new java.util.ArrayList();
    private java.util.List LMU         = new java.util.ArrayList();
    private java.util.List month       = new java.util.ArrayList();
    private java.util.List approval    = new java.util.ArrayList();
    private java.util.List level       = new java.util.ArrayList();
    private java.util.List type        = new java.util.ArrayList();
    private java.util.List civilStatus        = new java.util.ArrayList();

    private String[] monthLabel = new String[] {"", "January", "February",
            "March", "April", "May", "June", "July", "August", "September", 
            "October", "November", "December"};

    private String[] genderLabel = new String[] {"", "M", "F"};

    private String[] civilStatusLabel = new String[] {"", "Married", "Single",
            "Divorced", "Widowed"};

    private String[] levelLabel = new String[] {"", "Junior Software Engr",
            "Software Engr", "Senior Software Engr", "Team Lead", 
            "Senior Team Lead", "Manger", "Senior Manager", "Associate Partner",
            "Partner", "Country Manager"};
    
	private String[] approvalLabel = new String[] {"", "FOR APPROVAL", "REJECTED", 
			"APPROVED", "All"};

	private String[] typeLabel = new String[] {"", "Project", "Skill", 
	        "SkillCategory"};
	/**
	 * 
	 *
	 */
	public Constants() {
        /**/
        for(ctr = 0; ctr < civilStatusLabel.length; ctr++) {
            Map map = new java.util.HashMap();
            map.put("label", civilStatusLabel[ctr]);
            map.put("value", civilStatusLabel[ctr]);
            civilStatus.add(map);
        }
        /* gender constants */
        for(ctr = 0; ctr < genderLabel.length; ctr++) {
            Map map = new java.util.HashMap();
            map.put("label", genderLabel[ctr]);
            map.put("value", genderLabel[ctr]);
            gender.add(map);
        }
        
        /* months */
        for(ctr = 0; ctr < monthLabel.length; ctr++) {
            Map map = new java.util.HashMap();
            map.put("label", monthLabel[ctr]);
            map.put("value", Integer.toString(ctr));
            month.add(map);
        }
    
        /**/
        for(ctr = 0; ctr < approvalLabel.length; ctr++) {
            Map map = new java.util.HashMap();
            map.put("label", approvalLabel[ctr]);
            map.put("value", approvalLabel[ctr]);
            approval.add(map);
        }

        /**/
        for(ctr = 0; ctr < levelLabel.length; ctr++) {
            Map map = new java.util.HashMap();
            map.put("label", levelLabel[ctr]);
            map.put("value", levelLabel[ctr]);
            level.add(map);
        }

        /**/
        for(ctr = 0; ctr < typeLabel.length; ctr++) {
            Map map = new java.util.HashMap();
            map.put("label", typeLabel[ctr]);
            map.put("value", typeLabel[ctr]);
            type.add(map);
        }


	
	}


    /**
     * @return Returns the civil status.
     */
    public java.util.List getCivilStatus() {
        return civilStatus;
    }

    /**
     * @return Returns the gender.
     */
    public java.util.List getGender() {
        return gender;
    }
    /**
     * @return Returns the lMU.
     */
    public java.util.List getLMU() {
        return LMU;
    }
    /**
     * @return Returns the month.
     */
    public java.util.List getMonth() {
        return month;
    }
    /**
     * @return Returns the serviceLine.
     */
    public java.util.List getServiceLine() {
        return serviceLine;
    }
    /**
     * @return Returns the state.
     */
    public java.util.List getState() {
        return state;
    }

    /**
     * @return Returns the approval.
     */
    public java.util.List getApproval() {
        return approval;
    }

    /**
     * @return Returns the level.
     */
    public java.util.List getLevel() {
        return level;
    }

    /**
     * @return Returns the gender.
     */
    public String getGender(String value) {

        iterate = gender.iterator();
        while(iterate.hasNext()){
            Map map = (Map) iterate.next();
            if(value.equalsIgnoreCase(map.get("label").toString())){
                return map.get("value").toString();
            }
        }

        return null;
    }
    /**
     * @return Returns the civil status.
     */
    public String getCivilStatus(String value) {

        iterate = civilStatus.iterator();
        while(iterate.hasNext()){
            Map map = (Map) iterate.next();
            if(value.equalsIgnoreCase(map.get("label").toString())){
                return map.get("value").toString();
            }
        }

        return null;
    }

    /**
     * @return Returns the lMU.
     */
    public String getLMU(String value) {

        iterate = LMU.iterator();
        while(iterate.hasNext()){
            Map map = (Map) iterate.next();
            if(value.equalsIgnoreCase(map.get("label").toString())){
                return map.get("value").toString();
            }
        }

        return null;
    }
    /**
     * @return Returns the month.
     */
    public String getMonth(String value) {

        iterate = month.iterator();
        while(iterate.hasNext()){
            Map map = (Map) iterate.next();
            if(value.equalsIgnoreCase(map.get("label").toString())){
                return map.get("value").toString();
            }
        }

        return null;
    }
    /**
     * @return Returns the serviceLine.
     */
    public String getServiceLine(String value) {

        iterate = serviceLine.iterator();
        while(iterate.hasNext()){
            Map map = (Map) iterate.next();
            if(value.equalsIgnoreCase(map.get("label").toString())){
                return map.get("value").toString();
            }
        }

        return null;
    }
    /**
     * @return Returns the state.
     */
    public String getState(String value) {

        iterate = state.iterator();
        while(iterate.hasNext()){
            Map map = (Map) iterate.next();
            if(value.equalsIgnoreCase(map.get("label").toString())){
                return map.get("value").toString();
            }
        }

        return null;
    }

    /**
     * @return Returns the approval.
     */
    public String getApproval(String value) {

        iterate = approval.iterator();
        while(iterate.hasNext()){
            Map map = (Map) iterate.next();
            if(value.equalsIgnoreCase(map.get("label").toString())){
                return map.get("value").toString();
            }
        }

        return null;
    }

    /**
     * @return Returns the level.
     */
    public String getLevel(String value) {

        iterate = level.iterator();
        while(iterate.hasNext()){
            Map map = (Map) iterate.next();
            if(value.equalsIgnoreCase(map.get("label").toString())){
                return map.get("value").toString();
            }
        }

        return null;
    }

    /**
     * @return Returns the type.
     */
    public java.util.List getType() {
        return type;
    }

    /**
     * @return Returns the level.
     */
    public String getType(String value) {

        iterate = type.iterator();
        while(iterate.hasNext()){
            Map map = (Map) iterate.next();
            if(value.equalsIgnoreCase(map.get("label").toString())){
                return map.get("value").toString();
            }
        }

        return null;
    }
}
