/*
 * Created on Nov 22, 2004
 *
 * r.c.delos.santos
 * 
 */
package com.jds.apps.beans;



import java.util.Date;

/**
 * @author r.c.delos.santos
 * 
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class AccentureDetails   {

    private String enterpriseId;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String id) {
        this.enterpriseId = id;
    }

    private String enterpriseAddress;

    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    public void setEnterpriseAddress(String address) {
        this.enterpriseAddress = address;
    }

    private String employeeNo;

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String no) {
        this.employeeNo = no;
    }

    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    private String LMU;

    public String getLMU() {
        return LMU;
    }

    public void setLMU(String lmu) {
        this.LMU = lmu;
    }

    private Date dateHired;

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date hired) {
        this.dateHired = hired;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String hireMonth;

    public String getHireMonth() {
        return hireMonth;
    }

    public void setHireMonth(String hireMonth) {
        this.hireMonth = hireMonth;
    }

    private String hireDate;

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getHireDate() {
        return hireDate;
    }

    private String hireYear;

    public String getHireYear() {
        return hireYear;
    }

    public void setHireYear(String hireYear) {
        this.hireYear = hireYear;
    }

    private String GMU;

    /**
     * @param gmu The gMU to set.
     */
    public void setGMU(String gmu) {
        GMU = gmu;
    }

    /**
     * @return Returns the gMU.
     */
    public String getGMU() {
        return GMU;
    }

    private String workGroup;

    /**
     * @param workGroup The workGroup to set.
     */
    public void setWorkGroup(String workGroup) {
        this.workGroup = workGroup;
    }

    /**
     * @return Returns the workGroup.
     */
    public String getWorkGroup() {
        return workGroup;
    }

    private String specialty;

    /**
     * @param specialty The specialty to set.
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * @return Returns the specialty.
     */
    public String getSpecialty() {
        return specialty;
    }

    private String membershipLevel;

    /**
     * @param membershipLevel The membershipLevel to set.
     */
    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    /**
     * @return Returns the membershipLevel.
     */
    public String getMembershipLevel() {
        return membershipLevel;
    }

    private String serviceLine;

    /**
     * @return Returns the serviceLine.
     */
    public String getServiceLine() {
        return serviceLine;
    }

    /**
     * @param serviceLine The serviceLine to set.
     */
    public void setServiceLine(String serviceLine) {
        this.serviceLine = serviceLine;
    }

}
