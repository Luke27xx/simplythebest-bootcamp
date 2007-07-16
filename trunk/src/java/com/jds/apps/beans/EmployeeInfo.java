/*
 * Created on Nov 22, 2004
 *
 * r.c.delos.santos
 * 
 */
package com.jds.apps.beans;

import java.util.Date;
import java.util.List;

/**
 * @author r.c.delos.santos
 * 
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class EmployeeInfo {

    /**
     * 
     * @uml.property name="firstName" multiplicity="(0 1)"
     */
    private String firstName;

    /**
     *  
     * @uml.property name="firstName"
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *  
     * @uml.property name="firstName"
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @uml.property name="lastName" multiplicity="(0 1)"
     */
    private String lastName;

    /**
     *  
     * @uml.property name="lastName"
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *  
     * @uml.property name="lastName"
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @uml.property name="middleName" multiplicity="(0 1)"
     */
    private String middleName;

    /**
     *  
     * @uml.property name="middleName"
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     *  
     * @uml.property name="middleName"
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * 
     * @uml.property name="dob" multiplicity="(0 1)"
     */
    private Date dob;

    /**
     *  
     * @uml.property name="dob"
     */
    public Date getDob() {
        return dob;
    }

    /**
     *  
     * @uml.property name="dob"
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * 
     * @uml.property name="age" multiplicity="(0 1)"
     */
    private int age;

    /**
     *  
     * @uml.property name="age"
     */
    public int getAge() {
        return age;
    }

    /**
     *  
     * @uml.property name="age"
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 
     * @uml.property name="gender" multiplicity="(0 1)"
     */
    private char gender;

    /**
     *  
     * @uml.property name="gender"
     */
    public char getGender() {
        return gender;
    }

    /**
     *  
     * @uml.property name="gender"
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * 
     * @uml.property name="civilStatus" multiplicity="(0 1)"
     */
    private String status;

    /**
     *  
     * @uml.property name="civilStatus"
     */
    public String getCivilStatus() {
        return status;
    }

    /**
     *  
     * @uml.property name="civilStatus"
     */
    public void setCivilStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @uml.property name="citizenship" multiplicity="(0 1)"
     */
    private String citizenship;

    /**
     *  
     * @uml.property name="citizenship"
     */
    public String getCitizenship() {
        return citizenship;
    }

    /**
     *  
     * @uml.property name="citizenship"
     */
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    /**
     * 
     * @uml.property name="religion" multiplicity="(0 1)"
     */
    private String religion;

    /**
     *  
     * @uml.property name="religion"
     */
    public String getReligion() {
        return religion;
    }

    /**
     *  
     * @uml.property name="religion"
     */
    public void setReligion(String religion) {
        this.religion = religion;
    }

    /**
     * 
     * @uml.property name="sssNo" multiplicity="(0 1)"
     */
    private String no;

    /**
     *  
     * @uml.property name="sssNo"
     */
    public String getSssNo() {
        return no;
    }

    /**
     *  
     * @uml.property name="sssNo"
     */
    public void setSssNo(String no) {
        this.no = no;
    }

    /**
     * 
     * @uml.property name="tinNo" multiplicity="(0 1)"
     */
    private String tinNo;

    /**
     *  
     * @uml.property name="tinNo"
     */
    public String getTinNo() {
        return tinNo;
    }

    /**
     *  
     * @uml.property name="tinNo"
     */
    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    /**
     * 
     * @uml.property name="email" multiplicity="(0 1)"
     */
    private String email;

    /**
     *  
     * @uml.property name="email"
     */
    public String getEmail() {
        return email;
    }

    /**
     *  
     * @uml.property name="email"
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @uml.property name="mobilePhoneNo" multiplicity="(0 1)"
     */
    private String phoneNo;

    /**
     *  
     * @uml.property name="mobilePhoneNo"
     */
    public String getMobilePhoneNo() {
        return phoneNo;
    }

    /**
     *  
     * @uml.property name="mobilePhoneNo"
     */
    public void setMobilePhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * 
     * @uml.property name="homePhoneNo" multiplicity="(0 1)"
     */
    private String homePhoneNo;

    /**
     *  
     * @uml.property name="homePhoneNo"
     */
    public String getHomePhoneNo() {
        return homePhoneNo;
    }

    /**
     *  
     * @uml.property name="homePhoneNo"
     */
    public void setHomePhoneNo(String homePhoneNo) {
        this.homePhoneNo = homePhoneNo;
    }

    /**
     * 
     * @uml.property name="street1" multiplicity="(0 1)"
     */
    private String street1;

    /**
     *  
     * @uml.property name="street1"
     */
    public String getStreet1() {
        return street1;
    }

    /**
     *  
     * @uml.property name="street1"
     */
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    /**
     * 
     * @uml.property name="street2" multiplicity="(0 1)"
     */
    private String street2;

    /**
     *  
     * @uml.property name="street2"
     */
    public String getStreet2() {
        return street2;
    }

    /**
     *  
     * @uml.property name="street2"
     */
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    /**
     * 
     * @uml.property name="city" multiplicity="(0 1)"
     */
    private String city;

    /**
     *  
     * @uml.property name="city"
     */
    public String getCity() {
        return city;
    }

    /**
     *  
     * @uml.property name="city"
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @uml.property name="state" multiplicity="(0 1)"
     */
    private String state;

    /**
     *  
     * @uml.property name="state"
     */
    public String getState() {
        return state;
    }

    /**
     *  
     * @uml.property name="state"
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @uml.property name="zipcode" multiplicity="(0 1)"
     */
    private String zipcode;

    /**
     *  
     * @uml.property name="zipcode"
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     *  
     * @uml.property name="zipcode"
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * 
     * @uml.property name="country" multiplicity="(0 1)"
     */
    private String country;

    /**
     *  
     * @uml.property name="country"
     */
    public String getCountry() {
        return country;
    }

    /**
     *  
     * @uml.property name="country"
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @uml.property name="accentureDetails"
     * @uml.associationEnd inverse=":accenture.manila.hr.apps.AccentureDetailsForm" multiplicity=
     * "(0 1)"
     */
    private AccentureDetails details;

    /**
     *  
     * @uml.property name="accentureDetails"
     */
    public AccentureDetails getAccentureDetails() {
        return details;
    }

    /**
     *  
     * @uml.property name="accentureDetails"
     */
    public void setAccentureDetails(AccentureDetails details) {
        this.details = details;
    }

    /**
     *  
     * @uml.property name="employeeProjectProfile"
     * @uml.associationEnd inverse="employeeInfo:accenture.manila.hr.apps.EmployeeProjectProfile" multiplicity="(0 -1)" ordering="ordered"
     */
    private List projectProfile;

    /**
     * 
     * @uml.property name="employeeProjectProfile"
     */
    public java.util.List getEmployeeProjectProfile() {
        return projectProfile;
    }

    /**
     * 
     * @uml.property name="employeeProjectProfile"
     */
    public void setEmployeeProjectProfile(java.util.List value) {
        projectProfile = value;
    }

    /**
     *  
     * @uml.property name="employeeSkillProfile"
     * @uml.associationEnd inverse="employeeInfo:accenture.manila.hr.apps.EmployeeSkillProfile" multiplicity="(0 -1)" ordering="ordered"
     */
    private List skillProfile;

    /**
     * 
     * @uml.property name="employeeSkillProfile"
     */
    public java.util.List getEmployeeSkillProfile() {
        return skillProfile;
    }

    /**
     * 
     * @uml.property name="employeeSkillProfile"
     */
    public void setEmployeeSkillProfile(java.util.List value) {
        skillProfile = value;
    }

    /**
     *  
     * @uml.property name="educationalAttainment" multiplicity="(0 1)"
     */
    private String attainment;

    /**
     *  
     * @uml.property name="educationalAttainment"
     */
    public String getEducationalAttainment() {
        return attainment;
    }

    /**
     *  
     * @uml.property name="educationalAttainment"
     */
    public void setEducationalAttainment(String attainment) {
        this.attainment = attainment;
    }

    /**
     *  
     * @uml.property name="recognitions" multiplicity="(0 1)"
     */
    private String recognitions;

    /**
     *  
     * @uml.property name="recognitions"
     */
    public String getRecognitions() {
        return recognitions;
    }

    /**
     *  
     * @uml.property name="recognitions"
     */
    public void setRecognitions(String recognitions) {
        this.recognitions = recognitions;
    }

    /**
     *  
     * @uml.property name="empNo" multiplicity="(0 1)"
     */
    private String empNo;

    /**
     *  
     * @uml.property name="empNo"
     */
    public String getEmpNo() {
        return empNo;
    }

    /**
     *  
     * @uml.property name="empNo"
     */
    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String toString() {
        return "\nlastname = " + this.lastName + "\nfirstname = " + this.firstName;
    }
    
}