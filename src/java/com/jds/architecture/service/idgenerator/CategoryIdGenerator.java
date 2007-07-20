package com.jds.architecture.service.idgenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jds.architecture.Logger;
import com.jds.architecture.ServiceFactory;
import com.jds.architecture.service.dbaccess.DBAccess;
import com.jds.architecture.service.dbaccess.DBAccessException;
import com.jds.architecture.service.transaction.TransactionException;

public class CategoryIdGenerator implements IdGeneratorInterface {

	private static CategoryIdGenerator  idGen = null;
	private String genID = "select seq_skillcategory.nextval from dual";
	private Statement stmt = null;
	private Connection conn = null;
	private ResultSet rs = null;
	private Logger logger = (Logger) ServiceFactory.getInstance()
	.getService(CategoryIdGenerator.class);
	
	private CategoryIdGenerator() {}
	
	/**
	 * Gets the instance of this class
	 * @return CategoryIdGenerator
	 */
	public static CategoryIdGenerator getInstance(){
		if (idGen == null) {
			idGen = new CategoryIdGenerator();
		}
		return idGen;
	}
	
//	@Override
	public long getNextId() throws IdGeneratorException {
		// TODO Auto-generated method stub
		long id = 0;
		try {
			conn =  DBAccess.getDBAccess().getConnection();
		} catch (DBAccessException ex) {
			logger.error("database connection error in id generator");
			throw new IdGeneratorException
			("connection.acquire.exception",ex.getCause(),
			TransactionException.ERROR, true);
		}
		try {
			stmt = conn.createStatement();
		      rs = stmt.executeQuery(genID);
		      rs.next();
		      id = rs.getLong(1);
		      rs.close();
		      stmt.close();
		} catch (SQLException ex) {
			throw new IdGeneratorException
			("id.generation.exception",ex.getCause(),
					TransactionException.ERROR, true);
		} finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	    return id;
		
	}

}
