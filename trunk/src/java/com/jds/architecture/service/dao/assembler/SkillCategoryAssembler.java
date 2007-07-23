package com.jds.architecture.service.dao.assembler;

/**
 * @authors Liga Jeca & Gita Balode
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.RowSet;

import com.jds.apps.beans.SkillCategory;
import com.jds.architecture.service.dao.DAOConstants;

public class SkillCategoryAssembler {

	public static void  getPreparedStatement(SkillCategory skill, 
			PreparedStatement stmt) throws SQLException {
		stmt.setString(1, skill.getCategoryId());
		stmt.setString(2, skill.getCategoryName());
		stmt.setString(3, skill.getCategoryDescription());
}

	
	public static SkillCategory getInfo(ResultSet rs) throws SQLException   {
		SkillCategory skillReturn  = new SkillCategory();
		skillReturn.setCategoryId(rs.getString("catid"));
		skillReturn.setCategoryName(rs.getString("catname"));
		skillReturn.setCategoryDescription(rs.getString("catdesc"));
		return skillReturn;
	}
	
	public static SkillCategory getInfo(RowSet rs) throws SQLException{
		SkillCategory skillReturn  = new SkillCategory();
		skillReturn.setCategoryId(rs.getString("catid"));
		skillReturn.setCategoryName(rs.getString("catname"));
		skillReturn.setCategoryDescription(rs.getString("catdesc"));
		return skillReturn;
		
	}
	public static void toEmptyStringAllNull(SkillCategory obj) {
		if(obj.getCategoryName() == null) obj.setCategoryName(DAOConstants.STR_SPACE);
		if(obj.getCategoryDescription() == null) obj.setCategoryDescription(DAOConstants.STR_SPACE);
	}
}