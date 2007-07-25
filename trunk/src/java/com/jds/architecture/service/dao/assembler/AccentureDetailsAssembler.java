package com.jds.architecture.service.dao.assembler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.RowSet;

import com.jds.apps.beans.AccentureDetails;
import com.jds.apps.beans.EmployeeInfo;
import com.jds.architecture.service.dao.DAOConstants;
import com.jds.architecture.service.dao.stmtgenerator.StatementGenAccDetails;

/**
 * @author Dmitrijs.Sadovskis
 * 
 */
public class AccentureDetailsAssembler {

	/**
	 * Populates prepared statement using details of value object
	 * 
	 * @param details
	 *            Details value object
	 * @param stmt
	 *            prepared statement from data access object
	 * @throws SQLException
	 */
	public static void getPreparedStatement(AccentureDetails details,
			PreparedStatement stmt) throws SQLException {

		stmt.setString(1, details.getEmployeeNo());
		stmt.setString(2, details.getEnterpriseId());
		stmt.setString(3, details.getEnterpriseAddress());
		stmt.setString(4, details.getLevel());
		stmt.setString(5, details.getLMU());
		stmt.setString(6, details.getStatus());
		stmt.setDate(7, new java.sql.Date(details.getDateHired().getTime()));
		stmt.setString(8, details.getGMU());
		stmt.setString(9, details.getWorkGroup());
		stmt.setString(10, details.getSpecialty());
		stmt.setString(11, details.getServiceLine());

	}

	/**
	 * Creates populated EmployeeInfo vo from the Row set
	 * 
	 * @param rs
	 *            Row Set
	 * @return EmployeeInfo
	 * @throws SQLException
	 */
	public static AccentureDetails getInfo(ResultSet rs)
			throws SQLException {
		AccentureDetails detailsReturn = new AccentureDetails();

		detailsReturn.setEmployeeNo(rs.getString("empNo"));
		detailsReturn.setEnterpriseId(rs.getString("enterpriseId"));
		detailsReturn.setEnterpriseAddress(rs.getString("emailAdd"));
		detailsReturn.setLevel(rs.getString("empLevel"));
		detailsReturn.setLMU(rs.getString("LMU"));
		detailsReturn.setStatus(rs.getString("status"));
		detailsReturn.setDateHired(
				new java.sql.Date(
					(
						(java.sql.Timestamp) rs.getObject("datehired")
					).getTime()
				)
				);
		detailsReturn.setGMU(rs.getString("GMU"));
		detailsReturn.setWorkGroup(rs.getString("WORKGROUP"));
		detailsReturn.setSpecialty(rs.getString("SPECIALTY"));
		detailsReturn.setServiceLine(rs.getString("SERVICELINE"));

		return detailsReturn;
	}

	/**
	 * Creates populated EmployeeInfo vo from the Result set
	 * 
	 * @param rs
	 *            Result Set
	 * @return AccentureDetails
	 * @throws SQLException
	 */
	public static AccentureDetails getInfo(RowSet rs) throws SQLException {
		AccentureDetails detailsReturn = new AccentureDetails();
		detailsReturn.setEmployeeNo(rs.getString("empNo"));
		detailsReturn.setEnterpriseId(rs.getString("enterpriseId"));
		detailsReturn.setEnterpriseAddress(rs.getString("emailAdd"));
		detailsReturn.setLevel(rs.getString("empLevel"));
		detailsReturn.setLMU(rs.getString("LMU"));
		detailsReturn.setStatus(rs.getString("status"));
		detailsReturn.setDateHired(new java.util.Date(((java.sql.Timestamp) rs
				.getObject("datehired")).getTime()));
		detailsReturn.setGMU(rs.getString("GMU"));
		detailsReturn.setWorkGroup(rs.getString("WORKGROUP"));
		detailsReturn.setSpecialty(rs.getString("SPECIALTY"));
		detailsReturn.setServiceLine(rs.getString("SERVICELINE"));
		return detailsReturn;
	}

	public static void toEmptyStringAllNull(AccentureDetails obj) {
		if (obj.getEmployeeNo() == null)
			obj.setEmployeeNo(DAOConstants.STR_SPACE);
		if (obj.getEnterpriseId() == null)
			obj.setEnterpriseId(DAOConstants.STR_SPACE);
		if (obj.getEnterpriseAddress() == null)
			obj.setEnterpriseAddress(DAOConstants.STR_SPACE);
		if (obj.getLevel() == null)
			obj.setLevel(DAOConstants.STR_SPACE);
		if (obj.getLMU() == null)
			obj.setLMU(DAOConstants.STR_SPACE);
		if (obj.getStatus() == null)
			obj.setStatus(DAOConstants.STR_SPACE);
		// if(obj.getDateHired() == null) obj.setDateHired(...);
		if (obj.getGMU() == null)
			obj.setGMU(DAOConstants.STR_SPACE);
		if (obj.getWorkGroup() == null)
			obj.setWorkGroup(DAOConstants.STR_SPACE);
		if (obj.getSpecialty() == null)
			obj.setSpecialty(DAOConstants.STR_SPACE);
		if (obj.getServiceLine() == null)
			obj.setServiceLine(DAOConstants.STR_SPACE);
	}
}
