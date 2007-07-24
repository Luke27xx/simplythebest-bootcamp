package com.jds.architecture.service.dao.assembler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.RowSet;

import com.jds.apps.beans.SkillsInformation;
import com.jds.architecture.service.dao.DAOConstants;

/**
 * SkillsAssembler is a class used for populating prepared statement and for
 * retrieving skill from result set.
 * 
 * @author Ivars Lacis
 */
public class SkillsAssembler {
	/**
	 * Populates prepared statement using details of value object
	 * 
	 * @param employee
	 *            skill value object
	 * @param stmt
	 *            prepared statement from data access object
	 * @throws SQLException
	 */
	public static void getPreparedStatement(SkillsInformation skill,
			PreparedStatement stmt) throws SQLException {
		stmt.setString(1, skill.getSkillId());
		stmt.setString(2, skill.getCategoryId());
		stmt.setString(3, skill.getSkillName());
		stmt.setString(4, skill.getSkillDescription());
	}

	/**
	 * Creates populated SkillSInformation from the Row set
	 * 
	 * @param ResultSet
	 * @return EmployeeInfo
	 * @throws SQLException
	 */
	public static SkillsInformation getInfo(ResultSet rs) throws SQLException {
		SkillsInformation skillReturn = new SkillsInformation();

		skillReturn.setSkillId(rs.getString("id"));
		skillReturn.setCategoryId(rs.getString("catid"));
		skillReturn.setSkillName(rs.getString("name"));
		skillReturn.setSkillDescription(rs.getString("description"));
		skillReturn.setStatus(rs.getString("status"));

		return skillReturn;
	}

	/**
	 * Creates populated SkillSInformation from the Result set
	 * 
	 * @param RowSet
	 * @return EmployeeInfo
	 * @throws SQLException
	 */
	public static SkillsInformation getInfo(RowSet rs) throws SQLException {
		SkillsInformation skillReturn = new SkillsInformation();

		skillReturn.setSkillId(rs.getString("id"));
		skillReturn.setCategoryId(rs.getString("categoryId"));
		skillReturn.setSkillName(rs.getString("skill"));
		skillReturn.setSkillDescription(rs.getString("description"));
		skillReturn.setStatus(rs.getString("status"));

		return skillReturn;
	}

	/**
	 * 
	 * 
	 * @param SkillsInformation
	 */
	public static void toEmptyStringAllNull(SkillsInformation obj) {
		if (obj.getSkillDescription() == null)
			obj.setSkillDescription(DAOConstants.STR_SPACE);
	}
}
