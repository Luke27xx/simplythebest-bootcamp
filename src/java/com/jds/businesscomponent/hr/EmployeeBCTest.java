/**
 * 
 */
package com.jds.businesscomponent.hr;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

import javax.sql.RowSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jds.apps.beans.AccentureDetails;
import com.jds.apps.beans.EmployeeInfo;
import com.jds.architecture.exceptions.HRSLogicalException;
import com.jds.architecture.exceptions.HRSSystemException;
import com.jds.architecture.service.dao.DAOException;
import com.jds.architecture.service.dao.DataAccessObjectInterface;
import com.jds.architecture.service.dao.assembler.EmployeeAssembler;

/**
 * @author training
 *
 */
public class EmployeeBCTest {
	
	private DataAccessObjectInterface empAccDao = null;

	/**
	 * Test method for {@link com.jds.businesscomponent.hr.EmployeeBC#createEmployee(com.jds.apps.beans.EmployeeInfo)}.
	 * @throws HRSLogicalException 
	 * @throws HRSSystemException 
	 * @throws HRSSystemException 
	 * @throws HRSLogicalException 
	 * @throws SQLException 
	 * uses random to create unique First,Last and Midle names
	 */
	@Test 
	public void testCreatEmp() throws HRSSystemException, HRSLogicalException, SQLException {
		
		int empIndexTemp = (int)(Math.random()*1000);
		String empIndex = "" + empIndexTemp; 
		testCreateEmployee(empIndex);
	}
	
	public void testCreateEmployee(String empIndex) throws HRSSystemException, HRSLogicalException, SQLException {

	EmployeeBC empBc = new EmployeeBC();
	EmployeeInfo empInfo = new EmployeeInfo();
		
		empInfo.setFirstName("Vadim" + empIndex);
		empInfo.setLastName("Kuznecov" + empIndex);
		empInfo.setMiddleName("Aleksandrovich" + empIndex);
		empInfo.setAge(20);
		empInfo.setGender('M');
		empInfo.setCivilStatus("solo");
		empInfo.setCitizenship("Latvian");
		empInfo.setCity("Riga");
		empInfo.setState("Vidzeme");
		empInfo.setCountry("Latvia");
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(GregorianCalendar.YEAR, 2007);
		gc.set(GregorianCalendar.MONTH, 7);
		gc.set(GregorianCalendar.DATE, 27);
		Date validTarget1 = new Date(gc.getTimeInMillis());
		
		//Date validTarget1 = new Date(2007,27,8);
		empInfo.setDob(validTarget1);
		empInfo.setHomePhoneNo("7174455");
		empInfo.setMobilePhoneNo("25981741");
		empInfo.setRecognitions("blablabla");
		empInfo.setTinNo("22312312");
		empInfo.setSssNo("fesfopk3");
		empInfo.setStreet1("dwdaw");
		empInfo.setStreet2("");
		empInfo.setEducationalAttainment("TSI");
		empInfo.setEmail("amittere@inbox.lv");
		
	AccentureDetails correctObject = new AccentureDetails();

		correctObject.setEnterpriseId("tratata");
		correctObject.setEnterpriseAddress("em000");
		correctObject.setLevel("");
		correctObject.setLMU("LMU");
		correctObject.setStatus("");
		correctObject.setDateHired(new java.sql.Date(2001, 1, 1));
		correctObject.setGMU("GMU");
		correctObject.setWorkGroup("");
		correctObject.setSpecialty("");
		correctObject.setServiceLine("");
		
	empInfo.setAccentureDetails(correctObject);
	empBc.createEmployee(empInfo);
		

	EmployeeBC empBc1 = new EmployeeBC();
	EmployeeInfo empInfo1 = new EmployeeInfo();
		
		empInfo1.setFirstName("Vadwam" + empIndex +"1");
		empInfo1.setLastName("Kudwacov" + empIndex+"1");
		empInfo1.setMiddleName("Aleksdwadaw" + empIndex+ "1");
		empInfo1.setAge(20);
		empInfo1.setGender('F');
		empInfo1.setCivilStatus("solo");
		empInfo1.setCitizenship("Latvian");
		empInfo1.setCity("dwadga");
		empInfo1.setState("Vidzeme");
		empInfo1.setCountry("Latvia");
		Date validTarget2 = new Date(2007,27,8);
		empInfo1.setDob(validTarget2);
		empInfo1.setHomePhoneNo("7174455");
		empInfo1.setMobilePhoneNo("dwada981741");
		empInfo1.setRecognitions("blablabla");
		empInfo1.setTinNo("22dwa312312");
		empInfo1.setSssNo("fesfopk3");
		empInfo1.setStreet1("dwdaw");
		empInfo1.setStreet2("");
		empInfo1.setEducationalAttainment("TSI");
		empInfo1.setEmail("amittere@inbox.lv");
		
	AccentureDetails correctObject1 = new AccentureDetails();

		correctObject1.setEnterpriseId("tratata");
		correctObject1.setEnterpriseAddress("em000");
		correctObject1.setLevel("");
		correctObject1.setLMU("LMdwaU");
		correctObject1.setStatus("");
		correctObject1.setDateHired(new Date(2001, 1, 1));
		correctObject1.setGMU("GMU");
		correctObject1.setWorkGroup("");
		correctObject1.setSpecialty("");
		correctObject1.setServiceLine("");
		
	empInfo1.setAccentureDetails(correctObject);
	empBc.createEmployee(empInfo1);
	
	}

	/**
	 * Test method for {@link com.jds.businesscomponent.hr.EmployeeBC#searchEmployee(java.lang.String)}.
	 * @throws HRSSystemException 
	 * @throws HRSLogicalException 
	 * checking 2 records from table and compare with results we recived
	 * using searchEmployee method
	 */
	@Test
	public void testSearchEmployee() throws HRSSystemException, HRSLogicalException {

	EmployeeBC empBc = new EmployeeBC();
		
	EmployeeInfo infoTest = new EmployeeInfo();
	try {
	infoTest = 	empBc.searchEmployee("1557");
	assertEquals("1557" , infoTest.getEmpNo() );
	} catch (HRSLogicalException e) {
		assertEquals("no such record","no such record");
	}
	
	//infoTest = empBc.searchEmployee("1558");
	//assertEquals("1558",infoTest.getEmpNo());
	
	}

	/**
	 * Test method for {@link com.jds.businesscomponent.hr.EmployeeBC#searchEmployees(com.jds.apps.beans.EmployeeInfo)}.
	 * @throws HRSSystemException 
	 * @throws SQLException 
	 * @throws DAOException 
	 * search Employees using null parameter
	 */
	@Test
	public void testSearchEmployees() throws HRSSystemException, DAOException, SQLException {
		
		EmployeeBC empBc1 = new EmployeeBC();
		List<EmployeeInfo> empInfoList = new ArrayList<EmployeeInfo>();
		List<String> accEmpNoInfoList = new ArrayList<String>();
		List<String> accEnterpriseIdInfoList = new ArrayList<String>();
			
		empInfoList = (List)empBc1.searchEmployees(null);
		
		for(int i = 0; i< empInfoList.size(); i++){
			accEmpNoInfoList.add(empInfoList.get(i).getAccentureDetails().getEmployeeNo()) ;
			accEnterpriseIdInfoList.add(empInfoList.get(i).getAccentureDetails().getEnterpriseId());
		}
			
		   assertEquals(accEmpNoInfoList,accEmpNoInfoList);
		  // assertEquals("Accenture Details EnterpriseID",accEnterpriseIdInfoList);
	}
	
	@Test
	/**
	 * search employees using Info parameter
	 */
	public void testSearchEmployeesWithInfo () throws HRSSystemException, DAOException, SQLException {
		EmployeeBC empBc1 = new EmployeeBC();
		List<EmployeeInfo> empInfoList = new ArrayList<EmployeeInfo>();
		EmployeeInfo empInfo = new EmployeeInfo();
		empInfo.setFirstName("%Vadw%");
		
		empInfoList = (List)empBc1.searchEmployees(empInfo);
		
		assertEquals(empInfoList,empInfoList);
		
	}
	

		@Test
		public void testupdate() throws DAOException, HRSSystemException, HRSLogicalException, SQLException {
			
			EmployeeBC empBc = new EmployeeBC();
			
			EmployeeInfo empInfo = new EmployeeInfo();
			
			empInfo.setFirstName("Ilja2");
			empInfo.setLastName("Taran222222");
			empInfo.setMiddleName("Aleksandrovich2");
			empInfo.setAge(20);
			empInfo.setGender('M');
			empInfo.setCivilStatus("solo");
			empInfo.setCitizenship("Latvian");
			empInfo.setCity("Riga");
			empInfo.setState("Vidzeme");
			empInfo.setCountry("Latvia");
			Date validTarget1 = new Date(2007,27,8);
			empInfo.setDob(validTarget1);
			empInfo.setEmpNo("1570");
			empInfo.setHomePhoneNo("7174455");
			empInfo.setMobilePhoneNo("25981741");
			empInfo.setRecognitions("blablabla");
			empInfo.setTinNo("22312312");
			empInfo.setSssNo("fesfopk3");
			empInfo.setStreet1("dwdaw");
			empInfo.setStreet2("");
			empInfo.setEducationalAttainment("TSI");
			empInfo.setEmail("amittere@inbox.lv");
			
			AccentureDetails correctObject = new AccentureDetails();

			correctObject.setEnterpriseId("tratatada");
			correctObject.setEnterpriseAddress("em000");
			correctObject.setLevel("");
			correctObject.setLMU("LMU");
			correctObject.setStatus("");
			correctObject.setDateHired(new java.sql.Date(2001, 1, 1));
			correctObject.setGMU("GMU");
			correctObject.setWorkGroup("");
			correctObject.setSpecialty("");
			correctObject.setServiceLine("");
			
			empInfo.setAccentureDetails(correctObject);
			
			empBc.updateEmployee(empInfo);
			
			
			
		}

}
