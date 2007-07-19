package com.jds.architecture.service.dao.assembler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.RowSet;

import com.jds.apps.beans.AccentureDetails;
import com.jds.apps.beans.EmployeeInfo;
import com.jds.architecture.service.dao.DAOConstants;

/**
 * @author Dmitrijs.Sadovskis
 * 
 */
public class AccentureDetailsAssembler {

	public static String getExtendedUpdateStatement(AccentureDetails objSet) {

		// DO NOT DO IT THIS WAY !!!!!!!!!
		String sqlStatement = "";

		if (objSet.getEmployeeNo() != null
				&& !objSet.getEmployeeNo().equals("")) {
			sqlStatement = sqlStatement.concat(", empNo = ?");
		}
		if (objSet.getEnterpriseId() != null
				&& !objSet.getEnterpriseId().equals("")) {
			sqlStatement = sqlStatement.concat(", enterpriseid = ?");
		}
		if (objSet.getEnterpriseAddress() != null
				&& !objSet.getEnterpriseAddress().equals("")) {
			sqlStatement = sqlStatement.concat(", emailadd = ?");
		}
		if (objSet.getLevel() != null && !objSet.getLevel().equals("")) {
			sqlStatement = sqlStatement.concat(", emplevel = ?");
		}
		if (objSet.getLMU() != null && !objSet.getLMU().equals("")) {
			sqlStatement = sqlStatement.concat(", lmu = ?");
		}
		if (objSet.getStatus() != null && !objSet.getStatus().equals("")) {
			sqlStatement = sqlStatement.concat(", status = ?");
		}
		if (objSet.getDateHired() != null && !objSet.getDateHired().equals("")) {
			sqlStatement = sqlStatement.concat(", datehired = ?");
		}
		if (objSet.getGMU() != null && !objSet.getGMU().equals("")) {
			sqlStatement = sqlStatement.concat(", gmu = ?");
		}
		if (objSet.getWorkGroup() != null && !objSet.getWorkGroup().equals("")) {
			sqlStatement = sqlStatement.concat(", workgroup = ?");
		}
		if (objSet.getSpecialty() != null && !objSet.getSpecialty().equals("")) {
			sqlStatement = sqlStatement.concat(", specialty = ?");
		}
		if (objSet.getServiceLine() != null
				&& !objSet.getServiceLine().equals("")) {
			sqlStatement = sqlStatement.concat(", serviceline = ?");
		}
		// DO NOT DO IT THIS WAY !!!!!!!!!
		sqlStatement = sqlStatement.replaceFirst(", ", "");

		return sqlStatement;
	}

	public static int getPreparedExtendedUpdateStatement(
			AccentureDetails objSet, PreparedStatement stmt)
			throws SQLException {
		int index = 1;

		if (objSet.getEmployeeNo() != null
				&& !objSet.getEmployeeNo().equals("")) {
			stmt.setString(index, objSet.getEmployeeNo());
			index++;
		}
		if (objSet.getEnterpriseId() != null
				&& !objSet.getEnterpriseId().equals("")) {
			stmt.setString(index, objSet.getEnterpriseId());
			index++;
		}
		if (objSet.getEnterpriseAddress() != null
				&& !objSet.getEnterpriseAddress().equals("")) {
			stmt.setString(index, objSet.getEnterpriseAddress());
			index++;
		}
		if (objSet.getLevel() != null && !objSet.getLevel().equals("")) {
			stmt.setString(index, objSet.getLevel());
			index++;
		}
		if (objSet.getLMU() != null && !objSet.getLMU().equals("")) {
			stmt.setString(index, objSet.getLMU());
			index++;
		}
		if (objSet.getStatus() != null && !objSet.getStatus().equals("")) {
			stmt.setString(index, objSet.getStatus());
			index++;
		}
		if (objSet.getDateHired() != null
				&& !objSet.getDateHired().equals("")) {
			stmt.setDate(index, (java.sql.Date) objSet.getDateHired());
			index++;
		}
		if (objSet.getGMU() != null && !objSet.getGMU().equals("")) {
			stmt.setString(index, objSet.getGMU());
			index++;
		}
		if (objSet.getWorkGroup() != null
				&& !objSet.getWorkGroup().equals("")) {
			stmt.setString(index, objSet.getWorkGroup());
			index++;
		}
		if (objSet.getSpecialty() != null
				&& !objSet.getSpecialty().equals("")) {
			stmt.setString(index, objSet.getSpecialty());
			index++;
		}
		if (objSet.getServiceLine() != null
				&& !objSet.getServiceLine().equals("")) {
			stmt.setString(index, objSet.getServiceLine());
			index++;
		}

		return index;
	}

	public static void getPreparedExtendedStatement(
			AccentureDetails detailsFind, PreparedStatement stmt)
			throws SQLException {

		int index = 1;
		if (detailsFind.getEmployeeNo() != null
				&& !detailsFind.getEmployeeNo().equals("")) {
			stmt.setString(index, detailsFind.getEmployeeNo());
			index++;
		}
		if (detailsFind.getEnterpriseId() != null
				&& !detailsFind.getEnterpriseId().equals("")) {
			stmt.setString(index, detailsFind.getEnterpriseId());
			index++;
		}
		if (detailsFind.getEnterpriseAddress() != null
				&& !detailsFind.getEnterpriseAddress().equals("")) {
			stmt.setString(index, detailsFind.getEnterpriseAddress());
			index++;
		}
		if (detailsFind.getLevel() != null
				&& !detailsFind.getLevel().equals("")) {
			stmt.setString(index, detailsFind.getLevel());
			index++;
		}
		if (detailsFind.getLMU() != null && !detailsFind.getLMU().equals("")) {
			stmt.setString(index, detailsFind.getLMU());
			index++;
		}

		if (detailsFind.getStatus() != null
				&& !detailsFind.getStatus().equals("")) {
			stmt.setString(index, detailsFind.getStatus());
			index++;
		}

		if (detailsFind.getDateHired() != null
				&& !detailsFind.getDateHired().equals("")) {
			stmt.setDate(index, (java.sql.Date) detailsFind.getDateHired());
			index++;
		}
		if (detailsFind.getGMU() != null && !detailsFind.getGMU().equals("")) {
			stmt.setString(index, detailsFind.getGMU());
			index++;
		}
		if (detailsFind.getWorkGroup() != null
				&& !detailsFind.getWorkGroup().equals("")) {
			stmt.setString(index, detailsFind.getWorkGroup());
			index++;
		}
		if (detailsFind.getSpecialty() != null
				&& !detailsFind.getSpecialty().equals("")) {
			stmt.setString(index, detailsFind.getSpecialty());
			index++;
		}
		if (detailsFind.getServiceLine() != null
				&& !detailsFind.getServiceLine().equals("")) {
			stmt.setString(index, detailsFind.getServiceLine());
		}
	}

	public static String getExtendedStatement(AccentureDetails detailsFind) {
		String sqlStatement = "";

		// DO NOT DO IT THIS WAY !!!!!!!!!
		if (detailsFind.getEmployeeNo() != null
				&& !detailsFind.getEmployeeNo().equals("")) {
			sqlStatement = sqlStatement.concat("(empNo = ?) AND ");
		}
		if (detailsFind.getEnterpriseId() != null
				&& !detailsFind.getEnterpriseId().equals("")) {
			sqlStatement = sqlStatement.concat("(enterpriseid = ?) AND ");
		}
		if (detailsFind.getEnterpriseAddress() != null
				&& !detailsFind.getEnterpriseAddress().equals("")) {
			sqlStatement = sqlStatement.concat("(emailadd = ?) AND ");
		}
		if (detailsFind.getLevel() != null
				&& !detailsFind.getLevel().equals("")) {
			sqlStatement = sqlStatement.concat("(emplevel = ?) AND ");
		}
		if (detailsFind.getLMU() != null && !detailsFind.getLMU().equals("")) {
			sqlStatement = sqlStatement.concat("(lmu = ?) AND ");
		}
		if (detailsFind.getStatus() != null
				&& !detailsFind.getStatus().equals("")) {
			sqlStatement = sqlStatement.concat("(status = ?) AND ");
		}
		if (detailsFind.getDateHired() != null
				&& !detailsFind.getDateHired().equals("")) {
			sqlStatement = sqlStatement.concat("(datehired = ?) AND ");
		}
		if (detailsFind.getGMU() != null && !detailsFind.getGMU().equals("")) {
			sqlStatement = sqlStatement.concat("(gmu = ?) AND ");
		}
		if (detailsFind.getWorkGroup() != null
				&& !detailsFind.getWorkGroup().equals("")) {
			sqlStatement = sqlStatement.concat("(workgroup = ?) AND ");
		}
		if (detailsFind.getSpecialty() != null
				&& !detailsFind.getSpecialty().equals("")) {
			sqlStatement = sqlStatement.concat("(specialty = ?) AND ");
		}
		if (detailsFind.getServiceLine() != null
				&& !detailsFind.getServiceLine().equals("")) {
			sqlStatement = sqlStatement.concat("(serviceline = ?) AND ");
		}

		if (sqlStatement.equals(""))
			sqlStatement = "(1 = 2)";
		else
			sqlStatement = sqlStatement.concat("(1 = 1)");
		// DO NOT DO IT THIS WAY !!!!!!!!!

		return sqlStatement;
	}

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
						(java.sql.Date) rs.getObject("datehired")
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
