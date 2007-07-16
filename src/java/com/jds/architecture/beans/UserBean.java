/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 3, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.architecture.beans;

/**
 * 
 *
 * @author r.c.delos.santos
 * @author last modified by: $Autohr: rds ${date}
 * @version $Revision $ $Date: 2005/02/24 05:30:48 $
 * 
 */
public class UserBean {

    private String empNo;
    /**
     * @param empNo The empNo to set.
     */
    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }
    /**
     * @return Returns the empNo.
     */
    public String getEmpNo() {
        return empNo;
    }
    private String lastName;
    /**
     * @param lastName The lastName to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * @return Returns the lastName.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param firstName The firstName to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    private String firstName;
    /**
     * @return Returns the firstName.
     */
    public String getFirstName() {
        return firstName;
    }
    private String middleName;
    
    /**
     * @return Returns the middleName.
     */
    public String getMiddleName() {
        return middleName;
    }
    /**
     * @param middleName The middleName to set.
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    private String userType;
    /**
     * @return Returns the userType.
     */
    public String getUserType() {
        return userType;
    }
    /**
     * @param userType The userType to set.
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    private java.util.Map linkDataMap;
    
    /**
     * @return Returns the linkDataMap.
     */
    public java.util.Map getLinkDataMap() {
        return linkDataMap;
    }
    
    /**
     * @param linkDataMap The linkDataMap to set.
     */
    public void setLinkDataMap(java.util.Map linkDataMap) {
        this.linkDataMap = linkDataMap;
    }
}
