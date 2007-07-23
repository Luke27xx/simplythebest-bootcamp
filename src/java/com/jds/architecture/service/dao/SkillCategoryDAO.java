package com.jds.architecture.service.dao;

/**
 * @authors Liga Jeca & Gita Balode
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.RowSet;

import com.jds.apps.beans.SkillCategory;

import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.logging.LoggerService;
import com.jds.architecture.service.dao.assembler.SkillCategoryAssembler;
import com.jds.architecture.service.dao.stmtgenerator.StatementGenerator;
import com.jds.architecture.service.dao.stmtgenerator.StatementGeneratorFactory;
import com.jds.architecture.service.dbaccess.DBAccess;
import com.jds.architecture.service.dbaccess.DBAccessException;

public class SkillCategoryDAO implements DataAccessObjectInterface {

	protected String dbDriver;

	protected String dbUrl;

	protected String dbUser;

	protected String dbPassword;

	protected Connection conn;

	private DBAccess dbAccess = null;
	private static Logger log = (Logger) ServiceFactory.getInstance()
			.getService(LoggerService.class);

	StatementGenerator stmtGen = null;

	protected SkillCategoryDAO() throws DAOException, DBAccessException {
		log.info("initializing SkillCategoryDAO");
		dbAccess = DBAccess.getDBAccess();
		stmtGen = StatementGeneratorFactory.getGenerator().getStmtGenerator(
				DAOConstants.GEN_SKILLCAT);

	}

	/**
	 * This method will insert a record in the SkillCategory table.
	 */
	public void create(Connection conn, Object obj) throws DAOException {
		// TODO Auto-generated method stub

		if (!(obj instanceof SkillCategory))
			throw new DAOException("invalid.object.catdao", null,
					DAOException.ERROR, true);

		String sqlstmt = DAOConstants.SKILLCAT_CREATE;
		SkillCategory skill = (SkillCategory) obj;

		if (skill.getCategoryId() == null)
			throw new DAOException("invalid.object.catdao", null,
					DAOException.ERROR, true);

		log.debug("creating SkillCategory entry");
		try {
			if (conn == null || conn.isClosed())
				conn = dbAccess.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			SkillCategoryAssembler.getPreparedStatement(skill, stmt);
			stmt.executeUpdate();
			log.debug("created SkillCategory entry");
		} catch (SQLException e) {
			throw new DAOException("sql.create.exception.catdao", e,
					DAOException.ERROR, true);
		} catch (Exception e) {
			throw new DAOException("create.exception.catdao", e.getCause(),
					DAOException.ERROR, true);

		}
	}

	/**
	 * This method will find the corresponding record in the Employee table
	 * given the search criteria in the passed parameter.
	 */
	public RowSet find(Object obj) throws DAOException {

		// TODO Auto-generated method stub
		String sqlStmt = DAOConstants.SKILLCAT_FIND_MAIN;
		SkillCategory skillReturn = null;

		if (!(obj instanceof SkillCategory))
			throw new DAOException("invalid.object.catdao", null,
					DAOException.ERROR, true);

		String checkedFields = (String) obj;
		Connection conn = null;

		try {
			log.debug("finding SkillCategory entry by specified fields");
			conn = dbAccess.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);

			stmt.setString(1, checkedFields);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				skillReturn = SkillCategoryAssembler.getInfo(rs);
			}

			rs.close();
			log.debug("found SkillCategory entry by specified fields");
		} catch (DBAccessException e) {
			throw new DAOException(e.getMessageKey(), e, DAOException.ERROR,
					true);
		} catch (SQLException e) {
			throw new DAOException("sql.findpk.exception.catdao", e,
					DAOException.ERROR, true);
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {

			}
		}

		return (RowSet) skillReturn;
	}

	/**
	 * This method will find all the records in the SkillCategory table.
	 */
	public RowSet findByAll() throws DAOException {
		String sqlStmt = DAOConstants.SKILLCAT_FIND_ALL;
		SkillCategory skillReturn = null;

		Connection conn = null;

		try {
			log.debug("finding SkillCategory entry by specified fields");
			conn = dbAccess.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				skillReturn = SkillCategoryAssembler.getInfo(rs);
			}

			rs.close();
			log.debug("found SkillCategory entry by specified fields");
		} catch (DBAccessException e) {
			throw new DAOException(e.getMessageKey(), e, DAOException.ERROR,
					true);
		} catch (SQLException e) {
			throw new DAOException("sql.findpk.exception.catdao", e,
					DAOException.ERROR, true);
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {

			}
		}
		return (RowSet) skillReturn;

	}

	/**
	 * Finds a record from the table by the primary key
	 * 
	 * @return Object - String
	 * @param Object -
	 *            String instance, primary key of the record
	 */
	public Object findByPK(Object obj) throws DAOException {
		// TODO Auto-generated method stub

		String sqlStmt = DAOConstants.SKILLCAT_FIND_BYPK;
		SkillCategory skillReturn = null;

		if (!(obj instanceof String))
			throw new DAOException("invalid.object.catdao", null,
					DAOException.ERROR, true);

		String pk = (String) obj;
		Connection conn = null;

		try {
			log.debug("finding pk SkillCategory entry");
			conn = dbAccess.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);
			stmt.setString(1, pk);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				skillReturn = SkillCategoryAssembler.getInfo(rs);
			}

			rs.close();
			log.debug("found by pk SkillCategory entry");
		} catch (DBAccessException e) {
			throw new DAOException(e.getMessageKey(), e, DAOException.ERROR,
					true);
		} catch (SQLException e) {
			throw new DAOException("sql.findpk.exception.catdao", e,
					DAOException.ERROR, true);
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {

			}
		}

		return skillReturn;

	}

	/**
	 * This method will remove the corresponding record in the SkillCategory
	 * table.
	 */
	public boolean remove(Connection conn, Object obj) throws DAOException {
		// TODO Auto-generated method stub

		if (!(obj instanceof String))
			throw new DAOException("invalid.object.catdao", null,
					DAOException.ERROR, true);

		String sqlstmt = DAOConstants.SKILLCAT_DELETE;
		SkillCategory skill = (SkillCategory) obj;

		if (skill.equals(null))
			throw new DAOException("invalid.object.catdao", null,
					DAOException.ERROR, true);

		log.debug("removing SkillCategory entry");
		try {
			if (conn == null || conn.isClosed())
				conn = dbAccess.getConnection();

			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			SkillCategoryAssembler.getPreparedStatement(skill, stmt);
			stmt.executeUpdate();
			log.debug("removing SkillCategory entry");
		} catch (SQLException e) {
			throw new DAOException("sql.create.exception.catdao", e,
					DAOException.ERROR, true);
		} catch (Exception e) {
			throw new DAOException("create.exception.catdao", e.getCause(),
					DAOException.ERROR, true);

		}
		return true;
	}

	/**
	 * This method will update the corresponding record in the SkillCategory
	 * table.
	 */
	public boolean update(Connection conn, Object objSet, Object objWhere)
			throws DAOException {

		if (!(objSet instanceof SkillCategory && objWhere instanceof SkillCategory))
			throw new DAOException("invalid.object.catdao", null,
					DAOException.ERROR, true);

		String sqlstmt = DAOConstants.SKILLCAT_UPDATE_MAIN;
		SkillCategory skill = (SkillCategory) objWhere;
		SkillCategory skillChanges = (SkillCategory) objSet;

		if (skill.equals(null))
			throw new DAOException("invalid.object.catdao", null,
					DAOException.ERROR, true);

		log.debug("updating SkillCategory entry");
		try {
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);

			SkillCategoryAssembler.getPreparedStatement(skill, stmt);
			stmt.executeUpdate();
			SkillCategoryAssembler.getPreparedStatement(skillChanges, stmt);
			stmt.executeUpdate();

			log.debug("created SkillCategory entry");
		} catch (SQLException e) {
			throw new DAOException("sql.create.exception.catdao", e,
					DAOException.ERROR, true);
		} catch (Exception e) {
			throw new DAOException("create.exception.catdao", e.getCause(),
					DAOException.ERROR, true);

		}
		return false;

	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

}
