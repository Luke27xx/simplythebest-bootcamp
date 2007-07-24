/*
 * Copyright Accenture 2004 All Rights Reserved.
 * Feb 16, 2005
 * 
 * This software is the proprietary information of Accenture.
 * Use is subject to license terms.
 * 
 */
package com.jds.businesscomponent.stub;

import java.sql.SQLException;
import java.util.Collection;

import com.jds.apps.beans.EmployeeInfo;
import com.jds.apps.beans.ProjectInfo;
import com.jds.apps.beans.SkillCategory;
import com.jds.apps.beans.SkillsInformation;
import com.jds.architecture.exceptions.HRSLogicalException;
import com.jds.architecture.exceptions.HRSSystemException;
import com.jds.architecture.service.dao.DAOException;
import com.jds.businesscomponent.hr.EmployeeBC;
import com.jds.businesscomponent.hr.ProjectBC;
import com.jds.businesscomponent.hr.SkillBC;
import com.jds.businesscomponent.hr.SkillCategoryBC;

/**
 * 
 * @author r.c.delos.santos Feb 16, 2005
 * @author last modified by: $Author: c.b.balajadia $
 * @version $Revision: 1.2 $ $Date: 2005/05/05 04:28:32 $
 * 
 */
public class HRManager {

	private static HRManager thisInstance;

	public static HRManager getInstance() throws HRSSystemException {
		if (thisInstance == null) {
			thisInstance = new HRManager();
		}

		return thisInstance;
	}

	/** **************************employee ************************* */

	/**
	 * createEmployee create Employee information by HR
	 * 
	 * @param info
	 *            EmployeeInfo
	 * @throws HRSLogicalException
	 *             throws error when empno is null and when accenture details is
	 *             null
	 * @throws HRSSystemException
	 *             throws exception when system errors occured
	 * @throws SQLException
	 * @throws
	 */

	public void createEmployee(EmployeeInfo info) throws HRSSystemException,
			HRSLogicalException, SQLException {

		EmployeeBC empBc = new EmployeeBC();

		empBc.createEmployee(info);

	}

	/**
	 * updateEmployee update employee accenture information by HR
	 * 
	 * @param info
	 *            EmployeeInfo
	 * @throws HRSLogicalException
	 *             throws error when empno is null and when accenture details is
	 *             null
	 * @throws HRSSystemException
	 *             throws exception when system errors occured
	 * @throws DAOException
	 * @throws SQLException
	 */
	public void updateEmployee(EmployeeInfo info) throws HRSSystemException,
			HRSLogicalException, SQLException, DAOException {

		EmployeeBC empBc = new EmployeeBC();

		empBc.updateEmployee(info);

	}

	/**
	 * searchEmployees retrieves all the employees by HR
	 * 
	 * @param info
	 *            EmployeeInfo, if null returns list of all employees
	 * @return list of EmployeeInfo object with AccentureDetails object
	 * @throws HRSLogicalException
	 * @throws HRSSystemException
	 *             throws exception when system errors occured
	 * @throws SQLException
	 * @throws DAOException
	 */
	public Collection searchEmployees(EmployeeInfo info)
			throws HRSSystemException, HRSLogicalException, DAOException,
			SQLException {

		EmployeeBC empBc = new EmployeeBC();

		return empBc.searchEmployees(info);

	}

	/**
	 * searchEmployee sarches employee by primary key by HR
	 * 
	 * @param info
	 *            EmployeeInfo
	 * @param boolean
	 *            all returns all types of information related to the employee
	 * @return EmployeeInfo object of searched Employee with Accenture Details
	 *         as a default and with all the employee related objects as an
	 *         option
	 * @throws HRSLogicalException
	 *             throws exception when at least info does not contain employee
	 *             id
	 * @throws HRSSystemException
	 *             throws exception when system errors occured
	 */
	public EmployeeInfo searchEmployee(String empNo) throws HRSSystemException,
			HRSLogicalException {

		EmployeeBC empBc = new EmployeeBC();

		return empBc.searchEmployee(empNo);
	}

	/** **************************skill category ************************** */

	/**
	 * createCategory creates a category by HR
	 * 
	 * @param info
	 *            SkillCategory
	 * @throws HRSLogicalException
	 *             throws exception when SkillCategory does not contain category
	 *             id
	 * @throws HRSSystemException
	 *             throws exception when system errors occured
	 */
	public void createCategory(SkillCategory info) throws HRSSystemException,
			HRSLogicalException {

		SkillCategoryBC catBc = new SkillCategoryBC();

		catBc.createCategory(info);
	}

	/**
	 * updateCategory updates category information by HR
	 * 
	 * @param info
	 *            SkillCategory
	 * @throws HRSLogicalException
	 *             throws exception when info does not contain category id
	 * @throws HRSSystemException
	 *             throws exception when system errors occured
	 */
	public void updateCategory(SkillCategory info) throws HRSSystemException,
			HRSLogicalException {

		SkillCategoryBC catBc = new SkillCategoryBC();

		catBc.updateCategory(info);

		return;
	}

	/**
	 * searchApprovedCategories specific method for category search that calls
	 * general method searchReferenceData for all reference data
	 * 
	 * @param dataFind
	 *            SkillCategory
	 * @return list of SkillCategory objects
	 * @throws HRSLogicalException
	 *             throws exception when dataFind does not contain at least
	 *             category id
	 * @throws HRSSystemException
	 *             throws exception when system errors occured
	 */
	public Collection searchApprovedCategories(SkillCategory dataFind)
			throws HRSSystemException, HRSLogicalException {
		
		SkillCategoryBC catBc = new SkillCategoryBC();
		
		return catBc.searchApprovedCategories(dataFind);
	}

	/**
	 * search for a specific SkillCategory based on the primary key
	 * 
	 * @param id
	 *            primary key of the SkillCategory
	 * @return Skill Category with the corresponding primary key
	 * @throws HRSLogicalException
	 *             throws exception when findByPK does not produce any results
	 * @throws HRSSystemException
	 *             throws exception when system errors occured
	 */
	public SkillCategory searchCategory(String id) throws HRSSystemException,
			HRSLogicalException {

			SkillCategoryBC catBc = new SkillCategoryBC();
		
		return catBc.searchCategory(id);
	}

	/** **************************skill ************************** */

	/**
	 * createSkill creates skill by HR
	 * 
	 * @param info
	 *            SkillsInformation
	 * @throws HRSLogicalException
	 *             throws exception when info does not contain at least skill id
	 *             and category id
	 * @throws HRSSystemException
	 *             throws exception when system errors occured
	 */
	public void createSkill(SkillsInformation info) throws HRSSystemException,
			HRSLogicalException {

		SkillBC skillBc = new SkillBC();
		
		skillBc.createSkill(info);
	}

	/**
	 * updateSkill updates skill information by HR
	 * 
	 * @param info
	 *            SkillsInformation
	 * @throws HRSLogicalException
	 *             throws exception when info does not contain at least skill id
	 *             and category id
	 * @throws HRSSystemException
	 *             throws exception when system errors occured
	 */
	public void updateSkill(SkillsInformation info) throws HRSSystemException,
			HRSLogicalException {

		SkillBC skillBc = new SkillBC();
		
		skillBc.updateSkill(info);
	}

	/**
	 * searchApprovedSkills specific method for skills search that calls general
	 * method searchReferenceData for all reference data
	 * 
	 * @param dataFind
	 *            SkillsInformation
	 * @return list of SkillsInformation objects
	 * @throws HRSLogicalException
	 *             throws exception when dataFind does not contain at least
	 *             category id
	 * @throws HRSSystemException
	 *             throws exception when system errors occured
	 */
	public Collection searchApprovedSkills(SkillsInformation dataFind)
			throws HRSSystemException, HRSLogicalException {

		SkillBC skillBc = new SkillBC();
		
		return skillBc.searchApprovedSkills(dataFind);
	}

	/**
	 * search for a specific SkillsInformation based on the primary key
	 * 
	 * @param id
	 *            primary key of the SkillsInformation
	 * @return SkillsInformation with the corresponding primary key
	 * @throws HRSSystemException
	 * @throws HRSLogicalException
	 *             throws exception when findByPK does not produce any results
	 * @throws HRSSystemException
	 *             throws exception when system errors occured
	 * @throws HRSLogicalException
	 */
	public SkillsInformation searchSkill(String id) throws HRSSystemException,
			HRSLogicalException {
		
		SkillBC skillBc = new SkillBC();
		
		return skillBc.searchSkill(id);
	}

	/** ************************** project ************************** */

	/**
	 * createProject creates project by HR
	 * 
	 * @param info
	 *            ProjectInfo
	 * @throws HRSLogicalException
	 *             throw exception when info does not contain at least project
	 *             id
	 * @throws HRSSystemException
	 *             throws exception when system errors occured
	 */
	public void createProject(ProjectInfo info) throws HRSSystemException,
			HRSLogicalException {

		ProjectBC projBC = new ProjectBC();
		projBC.createProject(info);

		return;
	}

	/**
	 * updateProject updates project information by HR
	 * 
	 * @param info
	 *            ProjectInfo contains update information
	 * @throws HRSLogicalException
	 *             throws exception when info does not contain at least project
	 *             id
	 * @throws HRSSystemException
	 *             throws exception when system errors occured
	 */
	public void updateProject(ProjectInfo info) throws HRSSystemException,
			HRSLogicalException {

		ProjectBC projBC = new ProjectBC();
		projBC.updateProject(info);
		return;
	}

	/**
	 * searchApprovedProjects specific method for projects search that calls
	 * general method searchReferenceData for all reference data
	 * 
	 * @param dataFind
	 *            ProjectInfo
	 * @return list of ProjectInfo objects
	 * @throws HRSLogicalException
	 *             throws exception when dataFind does not contain at least
	 *             category id
	 * @throws HRSSystemException
	 *             throws exception when system errors occured
	 */
	public Collection searchApprovedProjects(ProjectInfo dataFind)
			throws HRSSystemException, HRSLogicalException {

		ProjectBC projBC = new ProjectBC();

		return projBC.searchApprovedProjects(dataFind);
	}

	/**
	 * search for a specific ProjectInfo based on the primary key
	 * 
	 * @param id
	 *            primary key of the ProjectInfo
	 * @return ProjectInfo with the corresponding primary key
	 * @throws HRSLogicalException
	 *             throws exception when findByPK does not produce any results
	 * @throws HRSSystemException
	 *             throws exception when system errors occured
	 */
	public ProjectInfo searchProject(String id) throws HRSSystemException,
			HRSLogicalException {

		ProjectBC projBC = new ProjectBC();

		return projBC.searchProject(id);

	}

}
