/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Dec 3, 2004
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.apps.hr.employee.form.ext;

import com.jds.architecture.abstraction.AbstractForm;

/**
 * 
 *
 * @author r.c.delos.santos
 * @author last modified by: $Author: eugene.p.lozada ${date}
 * @version $Revision $ $Date: 2005/03/07 09:11:53 $
 * 
 */
public abstract class AbstractEmployeeForm extends AbstractForm {

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if( firstName != null ){
            firstName = firstName.trim();
        }
        this.firstName = firstName;
    }

    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if( lastName != null ){
            lastName = lastName.trim();
        }
        this.lastName = lastName;
    }

    private String middleName;

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        if( middleName != null ){
            middleName = middleName.trim();
        }
        this.middleName = middleName;
    }
    
    private String dob;

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private char gender;

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    private String civilStatus;

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    private String citizenship;

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        if( citizenship != null ) {
            citizenship = citizenship.trim();
        }
        this.citizenship = citizenship;
    }

    private String religion;

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        if( religion != null ){
            religion = religion.trim();
        }
        this.religion = religion;
    }

    private String sssNo;

    public String getSssNo() {
        return sssNo;
    }

    public void setSssNo(String sssNo) {
        if( sssNo != null ){
            sssNo = sssNo.trim();
        }
        this.sssNo = sssNo;
    }

    private String tinNo;

    public String getTinNo() {
        return tinNo;
    }

    public void setTinNo(String tinNo) {
        if( tinNo != null ){
            tinNo = tinNo.trim();
        }
        this.tinNo = tinNo;
    }

    private String mobilePhoneNo;

    public String getMobilePhoneNo() {
        return mobilePhoneNo;
    }

    public void setMobilePhoneNo(String mobilePhoneNo) {
        if( mobilePhoneNo != null ){
            mobilePhoneNo = mobilePhoneNo.trim();
        }
        this.mobilePhoneNo = mobilePhoneNo;
    }

    private String homePhoneNo;

    public String getHomePhoneNo() {
        return homePhoneNo;
    }

    public void setHomePhoneNo(String homePhoneNo) {
        if( homePhoneNo != null ){
            homePhoneNo = homePhoneNo.trim();
        }
        this.homePhoneNo = homePhoneNo;
    }

    private String street1;

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        if( street1 != null ){
            street1 = street1.trim();
        }
        this.street1 = street1;
    }

    private String street2;

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        if( street2 != null ){
            street2 = street2.trim();
        }
        this.street2 = street2;
    }

    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if( city != null ){
            city = city.trim();
        }
        this.city = city;
    }

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if( state != null ){
            state = state.trim();
        }
        this.state = state;
    }

    private String zipcode;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        if( zipcode != null ){
            zipcode = zipcode.trim();
        }        
        this.zipcode = zipcode;
    }

    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if( country != null ){
            country = country.trim();
        }               
        this.country = country;
    }

    private String educationalAttainment;

    public String getEducationalAttainment() {
        return educationalAttainment;
    }

    public void setEducationalAttainment(String educationalAttainment) {
        if( educationalAttainment != null ){
            educationalAttainment = educationalAttainment.trim();
        }             
        this.educationalAttainment = educationalAttainment;
    }

    private String recognitions;

    public String getRecognitions() {
        return recognitions;
    }

    public void setRecognitions(String recognitions) {
        if( recognitions != null ){
            recognitions = recognitions.trim();
        }              
        this.recognitions = recognitions;
    }

    private String empNo;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        if( empNo != null ){
            empNo = empNo.trim();
        }           
        this.empNo = empNo;
    }

    private String birthMonth;

    /**
     * @param birthMonth The birthMonth to set.
     */
    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    /**
     * @return Returns the birthMonth.
     */
    public String getBirthMonth() {
        return birthMonth;
    }

    private String birthDate;

    /**
     * @param birthDate The birthDate to set.
     */
    public void setBirthDate(String birthDate) {
        if( birthDate != null ){
            birthDate = birthDate.trim();
        }                
        this.birthDate = birthDate;
    }

    /**
     * @return Returns the birthDate.
     */
    public String getBirthDate() {
        return birthDate;
    }

    private String birthYear;

    /**
     * @return Returns the birthYear.
     */
    public String getBirthYear() {
        return birthYear;
    }
    /**
     * @param birthYear The birthYear to set.
     */
    public void setBirthYear(String birthYear) {
        if( birthYear != null ){
            birthYear = birthYear.trim();
        }               
        this.birthYear = birthYear;
    }


    private String enterpriseId;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        if( enterpriseId != null ){
            enterpriseId = enterpriseId.trim();
        }              
        this.enterpriseId = enterpriseId;
    }

    private String enterpriseAddress;

    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    public void setEnterpriseAddress(String enterpriseAddress) {
        if( enterpriseAddress != null ){
            enterpriseAddress = enterpriseAddress.trim();
        }                
        this.enterpriseAddress = enterpriseAddress;
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

    public void setLMU(String LMU) {
        if( LMU != null ){
            LMU = LMU.trim();
        }            
        this.LMU = LMU;
    }

    private String dateHired;

    public String getDateHired() {
    	//dateHired = toDate(getHireDate(), getHireMonth(), getHireYear());
        return dateHired;
    }

    public void setDateHired(String dateHired) {
        if( dateHired != null ){
        	dateHired = dateHired.trim();
        }                	
        this.dateHired = dateHired;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if( status != null ){
            status = status.trim();
        }            
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

    public String getHireDate() {
        return hireDate;
    }
    public void setHireDate(String hireDate) {
        if( hireDate != null ){
            hireDate = hireDate.trim();
        }                    
        this.hireDate = hireDate;
    }

    private String hireYear;

    public String getHireYear() {
        return hireYear;
    }

    public void setHireYear(String hireYear) {
        if( hireYear != null ){
        	hireYear = hireYear.trim();
        }                    
    	this.hireYear = hireYear;
    }

    private String GMU;

    /**
     * @param GMU The gMU to set.
     */
    public void setGMU(String GMU) {
        if( GMU != null ){
            GMU = GMU.trim();
        }                    
        this.GMU = GMU;
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
        if( workGroup != null ){
            workGroup = workGroup.trim();
        }                    
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
        if( membershipLevel != null ){
            membershipLevel = membershipLevel.trim();
        }                    
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
        if( serviceLine != null ){
            serviceLine = serviceLine.trim();
        }                    
        this.serviceLine = serviceLine;
    }
}
