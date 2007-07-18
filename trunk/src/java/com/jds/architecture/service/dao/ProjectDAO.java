package com.jds.architecture.service.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.RowSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jds.apps.beans.ProjectInfo;
import com.jds.architecture.service.dao.assembler.ProjectAssembler;

public class ProjectDAO  implements DataAccessObjectInterface {

	protected String dbDriver;

	protected String dbUrl;

	protected String dbUser;

	protected String dbPassword;

	protected Connection conn;

	private Log log = LogFactory.getLog(ProjectDAO.class);

	/**
	 * In a more realistic example connections are obtained from a connection
	 * pool
	 */
	public ProjectDAO(String dbDriver, String dbUrl, String dbUser,
			String dbPassword) {
		this.dbDriver = dbDriver;
		this.dbUrl = dbUrl;
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
	}

	/**
	 * Make sure that connection is open for this DAO object
	 * @throws DAOException 
	 */
	public void reconnect() throws DAOException {
		try {
			if (conn == null || conn.isClosed()) {
				Class.forName(dbDriver);
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			}
		} catch (Exception e) {
			log.error("Could not initialize UrlDAO", e);
			throw new DAOException("Could not initialize UrlDAO", e);
		}

	}

	/**
	 * Free any resources
	 * @throws DAOException 
	 */
	public void close() throws DAOException {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				log.error("Could not close connection", e);
				throw new DAOException("Could not close connection", e);
			}
			conn = null;
		}
	}

	public Connection getConnection() {
		return conn;
	}

	/**
	 * Creates or insert new record to the table
	 *@param Connection - database connection
	 *@param Object  - must be an instance of EmployeeInfo,contains object for insert
	 */
	public void create(Connection conn, Object object) 
		throws DAOException {

		if (!(object instanceof ProjectInfo))
			throw new DAOException ("invalid.object.projdao",
					null, DAOException.ERROR, true);
			
		
		String sqlstmt = DAOConstants.PROJ_CREATE;
		ProjectInfo project = (ProjectInfo) object;

		if(project.getProjectId() == null)
			throw new DAOException ("invalid.object.projdao",
					null, DAOException.ERROR, true);
			
			
		log.debug("creating EmployeeInfo entry");
		try{
			PreparedStatement stmt = conn.prepareStatement(sqlstmt);
			ProjectAssembler.getPreparedStatement(project, stmt);
			stmt.executeUpdate();
			log.debug("created EmployeeInfo entry");
		} catch (SQLException e) {
			throw new DAOException ("sql.create.exception.projdao",
			e, DAOException.ERROR, true);
		} catch (Exception e) {
			throw new DAOException ("create.exception.projdao",
			e.getCause(),  DAOException.ERROR, true);
 
		} 
	}
	
	
	/**
	 * Removes a record from the table
	 * @param Connection -  database connection
	 * @param Object - must be an instance of String ,  primary key of the object
	 */
	public boolean remove(Connection conn, Object object) throws DAOException {

	    return true;
    }

	/**
	 * Finds a record from the table
	 * @return Object -  String
	 * @param Object  -  String instance, primary key of the record
	 */
	public Object findByPK(Object object) throws DAOException {
		String sqlStmt = DAOConstants.PROJ_FIND_BYPK;
		ProjectInfo projectReturn = null;

		if (!(object instanceof String))
			throw new DAOException ("invalid.object.projdao",
					null, DAOException.ERROR, true);
					
		String pk = (String) object;				
		Connection conn = null;

			try{
				log.debug("finding pk EmployeeInfo entry");
				conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlStmt);
				stmt.setString(1, pk);
				ResultSet rs = stmt.executeQuery();
				
				if (rs.next()) {
					projectReturn = ProjectAssembler.getInfo(rs);
				}
				
				rs.close();
				log.debug("found by pk EmployeeInfo entry");
			} catch (SQLException e) {
				throw new DAOException ("sql.findpk.exception.empdao",
				e, DAOException.ERROR, true);
			} finally {
				
					close();
				

				}
			

		return projectReturn;
	
	}


	/**
	 * Finds all records that matches the criteria
	 * @param Object -  instance of EmployeeInfo used as search criteria
	 * @return RowSet - rowset of found records
	 */
	public RowSet find(Object object) throws DAOException {

        return null;
	}



	/**
	 * @param Connectin - database connection
	 * @param ObjectSet - instance of EmployeeInfo, set the new values of a particular record
	 * @param objWher- instance of EmployeeInfo, used as update criteria
	 * @return boolean - true if record is updated
	 */
	public boolean update(Connection conn, Object objSet, Object objWhere) 
		throws DAOException{
	
	    
        return false;
		
	}

    public RowSet findByAll() throws DAOException {
        
        
        return null;
    }
	
	
/*	public void create(Connection conn, Object obj) throws DAOException {
		try {
			ProjectInfo item = (ProjectInfo) obj;
			PreparedStatement pstmt = conn
					.prepareStatement("INSERT INTO project VALUES (?,?,?,?,?,?)");
			pstmt.setString(1, item.getProjectId());
			pstmt.setString(2, item.getProjectName());
			pstmt.setString(3, item.getClient());
			pstmt.setString(4, item.getDescription());
			pstmt.setDate(5, (Date)item.getStartDate());
			pstmt.setDate(6, (Date)item.getEndDate());
			pstmt.executeUpdate();
		} catch (Exception e) {
			log.error("Could not initialize ProjectDAO", e);
			throw new DAOException("Could not initialize ProjectDAO", e);
		}
	}

	
	

	public List<Bookmark> findByAll() throws DAOException {
		List<Bookmark> result = new ArrayList<Bookmark>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM bookmark");
			while (rset.next()) {
				Bookmark item = getItemFromCursor(rset);
				result.add(item);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			log.error("Could not select all", e);
			throw new DAOException("Could not select all", e);
		}
		return result;
	}

	public boolean remove(Connection conn, Object obj) throws DAOException {
		Bookmark item = (Bookmark) obj;
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("DELETE FROM bookmark WHERE bookmark_id = ?");
			pstmt.setLong(1, item.getId());
			int rows = pstmt.executeUpdate();
			pstmt.close();
			// returns true, if any rows were deleted
			return rows > 0;
		} catch (SQLException e) {
			log.error("Could not remove item", e);
			throw new DAOException("Could not remove item", e);
		}
	}

	public Object findByPK(int id) throws DAOException {
		try {
			Bookmark result;
			PreparedStatement pstmt = conn
					.prepareStatement("SELECT * FROM bookmark WHERE bookmark_id = ?");
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				result = getItemFromCursor(rset);
			} else {
				result = null;
			}
			rset.close();
			pstmt.close();
			return result;
		} catch (SQLException e) {
			log.error("Could not find item", e);
			throw new DAOException("Could not find item", e);
		}
	}

	public boolean update(Connection conn, Object obj) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	private Bookmark getItemFromCursor(ResultSet rset) {
		Bookmark item = new Bookmark();
		try {
			item.setId(rset.getLong("bookmark_id"));
			item.setUrl(rset.getString("url"));
			item.setTitle(rset.getString("title"));
			item.setLastModified(rset.getDate("last_modified"));
			item.setContent(rset.getString("content"));
			item.setChecksum(rset.getLong("checksum"));
			item.setDescription(rset.getString("description"));
		} catch (SQLException e) {
			log.error("Could not initialize bookmark from resultset", e);
			throw new DAOException(
					"Could not initialize bookmark from resultset", e);
		}
		return item;
	}*/
}
