/**
 * 
 */
package com.jds.architecture.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import com.jds.apps.beans.AccentureDetails;
import com.jds.apps.beans.EmployeeInfo;
import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.logging.LoggerService;
import com.jds.architecture.service.dao.assembler.AccentureDetailsAssembler;
import com.jds.architecture.service.dao.assembler.EmployeeAssembler;
import com.jds.architecture.service.dao.stmtgenerator.StatementGenerator;
import com.jds.architecture.service.dao.stmtgenerator.StatementGeneratorFactory;
import com.jds.architecture.service.dbaccess.DBAccess;
import com.jds.architecture.service.dbaccess.DBAccessException;
import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;
import com.sun.rowset.CachedRowSetImpl;

/**
 * <p>
 * EmpAccentureDetailsDAO is data access object class for Employee table
 * </p>
 * 
 * 
 * @author Dmitrijs.Sadovskis
 * 
 */

public class EmpAccentureDetailsDAO implements DataAccessObjectInterface {

	private DBAccess dbAccess = null;
	private static Logger log = (Logger) ServiceFactory.getInstance()
			.getService(LoggerService.class);

	StatementGenerator stmtGen = null;

	/**
	 * Constructor initializes variables
	 * 
	 * @throws DAOException
	 * @throws DBAccessException
	 */
	protected EmpAccentureDetailsDAO() throws DAOException, DBAccessException {

		log.info("initializing EmpAccentureDetailsDAO");
		dbAccess = DBAccess.getDBAccess();
		stmtGen = StatementGeneratorFactory.getGenerator().getStmtGenerator(
				DAOConstants.GEN_EMPACC);

	}

	/**
	 * Creates or insert new record to the table
	 * 
	 * @param Connection -
	 *            database connection
	 * @param Object -
	 *            must be an instance of AccentureDetails,contains object for
	 *            insert
	 */
	public void create(Connection conn, Object object) throws DAOException {

		if (conn == null || object == null
				|| !(object instanceof AccentureDetails))
			throw new DAOException("invalid.object.accdao", null,
					DAOException.ERROR, true);

		String sqlstmt = DAOConstants.EMPACC_CREATE;
		AccentureDetails details = (AccentureDetails) object;

		if (details.getEmployeeNo() == null)
			throw new DAOException("invalid.object.accdao", null,
					DAOException.ERROR, true);

		log.debug("creating AccentureDetails entry");
		try {
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			AccentureDetailsAssembler.getPreparedStatement(details, stmt);
			stmt.executeUpdate();

			log.debug("created AccentureDetails entry");
		} catch (SQLException e) {
			throw new DAOException("sql.create.exception.accdao", e,
					DAOException.ERROR, true);
		} catch (Exception e) {
			throw new DAOException("create.exception.accdao", e.getCause(),
					DAOException.ERROR, true);

		}
	}

	/**
	 * Removes a record from the table
	 * 
	 * @param Connection -
	 *            database connection
	 * @param Object -
	 *            must be an instance of String , primary key of the object
	 */
	public boolean remove(Connection conn, Object object) throws DAOException {
		String sqlStmt = DAOConstants.EMPACC_DELETE;

		if (!(object instanceof String))
			throw new DAOException("invalid.object.accdao", null,
					DAOException.ERROR, true);

		String pk = (String) object;

		try {
			if (conn == null || conn.isClosed())
				conn = dbAccess.getConnection();
			log.debug("removing AccentureDetails entry by pk");

			PreparedStatement stmt = conn.prepareStatement(sqlStmt);
			stmt.setString(1, pk);
			ResultSet rs = stmt.executeQuery();

			rs.close();
			log.debug("removed AccentureDetails entry by pk");
			return true;
		} catch (SQLException e) {
			System.err.println("aaaa : " + e.getMessage());
			throw new DAOException("sql.findpk.exception.accdao", e,
					DAOException.ERROR, true);
		}

		catch (Exception ex) {
			System.err.println("error4: " + ex.getMessage());
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {
			}
		}

		return false;
	}

	/**
	 * Finds a record from the table
	 * 
	 * @return Object - String
	 * @param Object -
	 *            String instance, primary key of the record
	 */
	public Object findByPK(Object object) throws DAOException {
		String sqlStmt = DAOConstants.EMPACC_FIND_BYPK;
		AccentureDetails detailsReturn = null;

		if (!(object instanceof String))
			throw new DAOException("invalid.object.accdao", null,
					DAOException.ERROR, true);

		String pk = (String) object;
		Connection conn = null;

		try {
			log.debug("finding AccentureDetails entry by pk");
			conn = dbAccess.getConnection();

			PreparedStatement stmt = conn.prepareStatement(sqlStmt);
			stmt.setString(1, pk);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				detailsReturn = AccentureDetailsAssembler.getInfo(rs);
			}

			rs.close();
			log.debug("found AccentureDetails entry by pk");
		} catch (DBAccessException e) {
			throw new DAOException(e.getMessageKey(), e, DAOException.ERROR,
					true);
		} catch (SQLException e) {
			throw new DAOException("sql.findpk.exception.accdao", e,
					DAOException.ERROR, true);
		}

		catch (Exception ex) {
			System.err.println("error3: " + ex.getMessage());
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {
			}
		}

		return detailsReturn;

	}

	/**
	 * Finds all records that matches the criteria
	 * 
	 * @param Object -
	 *            instance of AccentureDetails used as search criteria
	 * @return RowSet - rowset of found records
	 */
	public RowSet find(Object object) throws DAOException {
		String sqlStmt = DAOConstants.EMPACC_FIND_MAIN;

		if (!(object instanceof AccentureDetails))
			throw new DAOException("invalid.object.accdao", null,
					DAOException.ERROR, true);

		AccentureDetails detailsFind = (AccentureDetails) object;
		Connection conn = null;
		RowSet returnRowSet = null;

		try {
			log.debug("finding AccentureDetails entry");
			conn = dbAccess.getConnection();
			String sqlExtStmt = AccentureDetailsAssembler
					.getExtendedStatement(detailsFind);

			PreparedStatement stmt = conn.prepareStatement(sqlStmt.replaceAll(
					"@@", sqlExtStmt));
			AccentureDetailsAssembler.getPreparedExtendedStatement(detailsFind,
					stmt);

			ResultSet rs = stmt.executeQuery();

			CachedRowSet crs = new CachedRowSetImpl();
			crs.populate(rs);
			returnRowSet = (RowSet) crs;
			rs.close();
			
			log.debug("found AccentureDetails entry");
		} catch (DBAccessException e) {
			throw new DAOException(e.getMessageKey(), e, DAOException.ERROR,
					true);
		} catch (SQLException e) {
			System.err.println("error_sql: " + e.getMessage());
			throw new DAOException("sql.findmain.exception.accdao",
					e, DAOException.ERROR, true);
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {

			}
		}

		return returnRowSet;

	}

	/**
	 * @param Connection -
	 *            database connection
	 * @param objSet -
	 *            instance of AccentureDetails, set the new values of a
	 *            particular record
	 * @param objWhere-
	 *            instance of AccentureDetails, used as update criteria
	 * @return boolean - true if record is updated
	 */
	public boolean update(Connection conn, Object objSet, Object objWhere)
			throws DAOException {

		String sqlStmt = DAOConstants.EMPACC_UPDATE;

		if (!(objSet instanceof AccentureDetails)
				|| !(objWhere instanceof AccentureDetails))
			throw new DAOException("invalid.object.accdao", null,
					DAOException.ERROR, true);

		try {
			log.debug("updating AccentureDetails entry");

			if (conn == null || conn.isClosed())
				conn = dbAccess.getConnection();

			RowSet rset = find(objWhere);
			if (!rset.next())
				return false;
			else {

				String sqlWhere = "(empno = ?)";
				String sqlExt = AccentureDetailsAssembler
						.getExtendedUpdateStatement((AccentureDetails) objSet);

				if (sqlExt.equals(""))
					return true;

				sqlStmt = sqlStmt.replaceFirst("@@", sqlExt).replaceFirst("@@",
						sqlWhere);

				PreparedStatement stmt = conn.prepareStatement(sqlStmt);

				int lastIndex = AccentureDetailsAssembler
						.getPreparedExtendedUpdateStatement(
								(AccentureDetails) objSet, stmt);

				do {
					stmt.setString(lastIndex, rset.getString("empno"));

					ResultSet rs = stmt.executeQuery();
					rs.close();
				} while (rset.next());
			}
			log.debug("updated AccentureDetails entry");
			return true;
		} catch (DBAccessException dbaex) {
			throw new DAOException(dbaex.getMessageKey(), dbaex,
					DAOException.ERROR, true);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOException("sql.update.exception.accdao",
					e, DAOException.ERROR, true);
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {
			}
		}

	}

	public RowSet findByAll() throws DAOException {
		String sqlStmt = DAOConstants.EMPACC_FIND_ALL;

		Connection conn = null;
		RowSet returnRowSet = null;

		try {
			log.debug("finding all AccentureDetails entries");
			conn = dbAccess.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlStmt);

			ResultSet rs = stmt.executeQuery();

			CachedRowSet crs = new CachedRowSetImpl();
			crs.populate(rs);
			returnRowSet = (RowSet) crs;
			rs.close();

			log.debug("found all AccentureDetails entries");
		} catch (DBAccessException e) {
			throw new DAOException(e.getMessageKey(), e, DAOException.ERROR,
					true);
		} catch (SQLException e) {
			throw new DAOException("sql.findall.exception.accdao",
					e, DAOException.ERROR, true);
		} catch (Exception x) {
			System.err.println("error2: " + x.getMessage());
		} finally {
			try {
				dbAccess.closeConnection(conn);
			} catch (DBAccessException e1) {

			} catch (Exception ex) {

			}
		}

		return returnRowSet;
	}

}
