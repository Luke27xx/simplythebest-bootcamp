/**
 * 
 */
package com.jds.architecture.service.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.List;

import javax.sql.RowSet;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jds.apps.beans.EmployeeInfo;
import com.jds.apps.beans.ProjectInfo;
import com.jds.architecture.service.dao.*;
import com.jds.architecture.service.dbaccess.DBAccessException;
import com.jds.architecture.service.dao.assembler.EmployeeAssembler;

public class EmployeeDAOTest {
	
	private static DataAccessObjectInterface dao;

	@Before
	public void setUp() throws Exception {
		
		//try {
			dao = (EmployeeDAO) DAOFactory.getFactory()
					.getDAOInstance(DAOConstants.DAO_EMP);

//		} catch (Exception x) {
//			System.err.println("error1: " + x.getMessage());
//		}
	}
	
	

	@Test
	public void testCreate() throws DAOException, SQLException {
		
		EmployeeInfo empInfo = new EmployeeInfo();
		
		empInfo.setFirstName("Vilnieks");
		empInfo.setLastName("Strel");
		empInfo.setMiddleName("blablabla");
		empInfo.setAge(20);
		empInfo.setGender('F');
		empInfo.setCivilStatus("solo");
		empInfo.setCitizenship("Latvian");
		empInfo.setCity("Riga");
		empInfo.setState("Vidzeme");
		empInfo.setCountry("Latvia");
		Date validTarget1 = new Date(2007,27,8);
		empInfo.setDob(validTarget1);
		empInfo.setEmpNo("1");
		empInfo.setHomePhoneNo("7174455");
		empInfo.setMobilePhoneNo("25981741");
		empInfo.setRecognitions("blablabla");
		empInfo.setTinNo("22312312");
		empInfo.setSssNo("fesfopk3");
		empInfo.setStreet1("dwdaw");
		empInfo.setStreet2("");
		empInfo.setEducationalAttainment("TSI");
		empInfo.setEmail("amittere@inbox.lv");

		dao.create(null, empInfo);
		
		
		EmployeeInfo empInfo1 = new EmployeeInfo();
			
		empInfo1.setFirstName("Aleksej");
		empInfo1.setLastName("Kuznecov1");
		empInfo1.setMiddleName("Aleksandrovich1");
		empInfo1.setAge(21);
		empInfo1.setGender('F');
		empInfo1.setCivilStatus("solo");
		empInfo1.setCitizenship("Latvian");
		empInfo1.setCity("Riga");
		empInfo1.setState("Vidzeme");
		empInfo1.setCountry("Latvia");
		Date validTarget2 = new Date(2007,26,8);
		empInfo1.setDob(validTarget2);
		empInfo1.setEmpNo("2");
		empInfo1.setHomePhoneNo("7174342455");
		empInfo1.setMobilePhoneNo("253281741");
		empInfo1.setRecognitions("blaesfseblabla");
		empInfo1.setTinNo("22313422312");
		empInfo1.setSssNo("fesfsfseopk3");
		empInfo1.setStreet1("dw34fddaw");
		empInfo1.setStreet2("fesf3");
		empInfo1.setEducationalAttainment("TSI");
		empInfo1.setEmail("amittere1@inbox.lv");

		dao.create(null, empInfo1);
		
		}
		
	
	
	
	@Test
	public void testfindbyPK() throws DAOException, SQLException {
	
		EmployeeInfo t1 = (EmployeeInfo)dao.findByPK("2");
		if (!t1.equals(null)) {
		assertEquals("Aleksej",t1.getFirstName());
		assertEquals("Kuznecov1",t1.getLastName());
		assertEquals("2",t1.getEmpNo());
		}
	}
	
	@Test
	public void testfind() throws DAOException, SQLException {
		
		EmployeeInfo empInfo = new EmployeeInfo();
		
		empInfo.setFirstName("Vilnieks");
		empInfo.setLastName("Strel");
		
		
		RowSet t1 = dao.find(empInfo) ;
		if (t1.next()){
	
		assertEquals("Vilnieks",EmployeeAssembler.getInfo(t1).getFirstName());
		assertEquals("Strel",EmployeeAssembler.getInfo(t1).getLastName());
		assertEquals("1",EmployeeAssembler.getInfo(t1).getEmpNo());
		}
		
	}
	@Test
	public void testremove() throws DAOException {
	
		assertEquals(true,dao.remove(null,"2") );	
		assertEquals(null,dao.findByPK("2"));
		
	}
	
	@Test
	public void testupdate() throws DAOException {

		
		EmployeeInfo objSet = new EmployeeInfo();
		objSet.setFirstName("Vad");
		objSet.setLastName("Kuzn");
		objSet.setMiddleName("Aleksandrovich");
		objSet.setAge(20);
		objSet.setGender('F');
		objSet.setCivilStatus("solo");
		objSet.setCitizenship("Latvian");
		objSet.setCity("Tokyo");
		objSet.setState("Vidzeme");
		objSet.setCountry("Latvia");
		Date validTarget1 = new Date(2007,27,8);
		objSet.setDob(validTarget1);
		//objSet.setEmpNo("1");
		objSet.setHomePhoneNo("7174455");
		objSet.setMobilePhoneNo("25981741");
		objSet.setRecognitions("blablabla");
		objSet.setTinNo("22312312");
		objSet.setSssNo("fesfopk3");
		objSet.setStreet1("dwdaw");
		objSet.setStreet2("");
		objSet.setEducationalAttainment("TSI");
		objSet.setEmail("amittere@inbox.lv");

		EmployeeInfo objWhere = new EmployeeInfo();
		objWhere.setFirstName("Vadim");
		objWhere.setEmpNo("1");
		
		
		assertEquals(true,dao.update(null, objSet, objWhere)); 
	
		dao.remove(null, "1");
	}
	}

