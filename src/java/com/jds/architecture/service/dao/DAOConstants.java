
package com.jds.architecture.service.dao;

/**
 * <p>
 * DAOConstants is a class that contains contants relevant to data access objects.
 * This includes sql statements and column name constants.
 * </p> 
 * 
 *  							
 * @author c.b.balajadia 
 * @version  11/2004 initial draft c.b.balajadia
 * @version  12/2004 changed column constants to array - c.b.balajadia
 * @version  01/2005 added constant for sql statement generator - c.b.balajadia
 * @version  02/2005 added id generator - c.b.balajadia 
 * @since 1.1
 */
public class DAOConstants {

	// constants for employee sql create, update, delete, queries
	public static String EMPSQL_CREATE = 
		"INSERT INTO employee (" +
			" empno, firstname, lastname, middlename, dateofbirth,"+
			" age, gender, civilstatus, citizenship, sssno, tinno,"+
			" mobileno, homeno, stadd1, stadd2, city, province,"+
			" country, educattainment, recognition )" +
			"VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
			" ?, ? ,?,?) ";
	protected static String EMPSQL_UPDATE = "UPDATE employee SET @ WHERE @ ";
	protected static String EMPSQL_DELETE = "DELETE employee WHERE empno = ? ";
	protected static String EMPSQL_FIND_MAIN = "SELECT * FROM employee WHERE @ ";
	protected static String EMPSQL_FIND_BYPK = "SELECT * FROM employee WHERE empno = ?";
	protected static String EMPSQL_FIND_ALL = "SELECT * FROM employee";
	
	// constants for employee skill sql create, update, delete, queries
	protected static String EMPSKILLSQL_CREATE = 
			"INSERT INTO empskills (empno, skillid, proficiency, details," +
			"YRSOFEXPERIENCE, LEVELOFINTEREST, YEARLASTUSED)" +
			" VALUES (?,?,?,?,?,?,?)";
	protected static String EMPSKILLSQL_UPDATE_MAIN = "UPDATE empskills SET @ WHERE @ ";
	protected static String EMPSKILLSQL_DELETE = "DELETE empskills WHERE empno = ? AND skillid = ?";
	protected static String EMPSKILLSQL_FIND_MAIN = "SELECT * FROM empskills WHERE @";
	protected static String EMPSKILLSQL_FIND_BYPK = "SELECT * FROM empskills WHERE empno = ? AND skillid = ?";
	protected static String EMPSKILLSQL_FIND_ALL = "SELECT * FROM empskills";
		
	// constants for employee project sql create, update, delete, queries
	protected static String EMPPROJ_CREATE = 
			"INSERT INTO empprojects (projid, empno, role, rollindate, rolloffdate, taskdescription)" +
			" VALUES (?,?,?,?,?,?)";
	protected static String EMPPROJ_UPDATE_MAIN = "UPDATE empprojects SET @ WHERE @ ";
	protected static String EMPPROJ_DELETE = "DELETE empprojects WHERE empno = ? AND projid = ?";
	protected static String EMPPROJ_FIND_MAIN = "SELECT * FROM empprojects WHERE @ ";
	protected static String EMPPROJ_FIND_BYPK = "SELECT * FROM empprojects WHERE empno = ? AND projid = ?";
	protected static String EMPPROJ_FIND_ALL = "SELECT * FROM empprojects";
		
	// constants for employee accenture details create, update, delete, queries
	protected static String EMPACC_CREATE = 
		"INSERT INTO empaccenturedetail(empno, enterpriseid, " +
		"emailadd, emplevel, lmu, status, datehired, gmu, workgroup, specialty, serviceline )" +
		" VALUES ( ? , ? , ? , ? , ? , ?, ? , ?, ? ,? ,? )";
	protected static String EMPACC_UPDATE = "UPDATE empaccenturedetail SET @@ WHERE @@ ";
	protected static String EMPACC_DELETE = "DELETE empaccenturedetail WHERE empno =  ? ";
	protected static String EMPACC_FIND_MAIN = "SELECT * FROM empaccenturedetail WHERE @@";
	protected static String EMPACC_FIND_BYPK = "SELECT * FROM empaccenturedetail WHERE empno =  ? ";
	protected static String EMPACC_FIND_ALL = "SELECT * FROM empaccenturedetail";

	// constants for skill sql create, update, delete, queries
	protected static String SKILL_CREATE = 
			"INSERT INTO skill (id, catid, name, description)" +
			" VALUES ( ? , ? , ? , ?)";
	protected static String SKILL_UPDATE_MAIN = "UPDATE skill SET @ WHERE @ ";
	protected static String SKILL_DELETE = "DELETE skill WHERE  id =  ? ";
	protected static String SKILL_FIND_MAIN = "SELECT * FROM skill WHERE @ ";
	protected static String SKILL_FIND_BYPK = "SELECT * FROM skill WHERE  id =  ? ";
	protected static String SKILL_FIND_ALL = "SELECT * FROM skill";
	
	// constants for category sql create, update, delete, queries
	protected static String SKILLCAT_CREATE = 
			"INSERT INTO skillcategory(id, name, description)" +
				" VALUES ( ? , ? , ?)";
	protected static String SKILLCAT_UPDATE_MAIN = "UPDATE skillcategory SET @ WHERE @ ";
	protected static String SKILLCAT_DELETE = "DELETE skillcategory WHERE id =  ? ";
	protected static String SKILLCAT_FIND_MAIN = "SELECT * FROM skillcategory WHERE @";
	protected static String SKILLCAT_FIND_BYPK =  "SELECT * FROM skillcategory WHERE id =  ? ";
	protected static String SKILLCAT_FIND_ALL = "SELECT * FROM skillcategory";
	
	// constants for project sql create, update, delete, queries
	protected static String PROJ_CREATE = 
		"INSERT INTO project (id, name, description," +
		" startdate, enddate, clientname)" +
		" VALUES ( ? , ? , ? ,  ? ,  ? , ? )";
	protected static String PROJ_UPDATE_MAIN =  "UPDATE project SET @ WHERE @ ";
	protected static String PROJ_DELETE = "DELETE project WHERE id =  ? ";
	protected static String PROJ_FIND_MAIN = "SELECT * FROM project WHERE @ ";
	protected static String PROJ_FIND_BYPK = "SELECT * FROM project WHERE id =  ? ";
	protected static String PROJ_FIND_ALL = "SELECT * FROM project";
	
	//column names
	protected static String   COL_ID_LIKE = " LOWER(id) = LOWER('@')";
	public static String[]    COL_ID = {" id = '@'", COL_ID_LIKE}; 
	protected static String   COL_NAME_LIKE = " LOWER(name) LIKE LOWER('%@%')";
	public static String[]    COL_NAME = {" name = '@'", COL_NAME_LIKE};
	protected static String   COL_PROFICIENCY_LIKE  = " proficiency = @ ";
	public static String[]    COL_PROFICIENCY  = {" proficiency = @ ", COL_PROFICIENCY_LIKE};
	protected static String   COL_DETAILS_LIKE  = " LOWER(details) LIKE LOWER('@')";
	public static String[]    COL_DETAILS  = {" details = '@'" , COL_DETAILS_LIKE};
	protected static String   COL_DESCRIPTION_LIKE  = " LOWER(description) LIKE LOWER('@')";
	public static String[]    COL_DESCRIPTION  = {" description = '@'", COL_DESCRIPTION_LIKE};
	protected static String   COL_STATUS_LIKE  = " LOWER(status) = LOWER('@')";
	public static String[]    COL_STATUS  = {" status = '@'", COL_STATUS_LIKE};
	protected static String   COL_SKILLID_LIKE  = " LOWER(skillid) = LOWER('@')";
	public static String[]    COL_SKILLID  = {" skillid = '@'" , COL_SKILLID_LIKE};
	protected static String   COL_CATID_LIKE  = " LOWER(catid) = LOWER('@')";
	public static String[]    COL_CATID  = {" catid = '@'", COL_CATID_LIKE};
	protected static String   COL_PROJID_LIKE  = " LOWER(projid) = LOWER('@')";
	public static String[]    COL_PROJID  = {" projid = '@'", COL_PROJID_LIKE};
	protected static String   COL_EMPNO_LIKE  = " LOWER(empno) = LOWER('@')";
	public static String[]    COL_EMPNO  = {" empno = '@'", COL_EMPNO_LIKE};
	protected static String   COL_ROLE_LIKE  = " LOWER(role) = LOWER('@')";
	public static String[]    COL_ROLE  = {" role = '@'", COL_ROLE_LIKE} ;
	protected static String   COL_ROLLINDATE_LIKE  = " rollindate = '@'";
	public static String[]    COL_ROLLINDATE  = {" rollindate = '@'", COL_ROLLINDATE_LIKE};
	protected static String   COL_ROLLOFFDATE_LIKE = " rolloffdate = '@'";
	public static String[]    COL_ROLLOFFDATE = {" rolloffdate = '@'" ,COL_ROLLOFFDATE_LIKE};
	protected static String   COL_TASKDESCRIPTION_LIKE = " LOWER(taskdescription) LIKE LOWER('@')";
	public static String[]    COL_TASKDESCRIPTION = {" taskdescription = '@'" ,COL_TASKDESCRIPTION_LIKE};
	protected static String   COL_STARTDATE_LIKE = " startdate = '@'";
	public static String[]    COL_STARTDATE = {" startdate = '@'" , COL_STARTDATE_LIKE};
	protected static String   COL_ENDDATE_LIKE = " enddate = '@'";
	public static String[]    COL_ENDDATE = {" enddate = '@'", COL_ENDDATE_LIKE};
	protected static String   COL_CLIENTNAME_LIKE = " LOWER(clientname) LIKE LOWER('@')";
	public static String[]    COL_CLIENTNAME = {" clientname = '@'", COL_CLIENTNAME_LIKE};
	protected static String   COL_ENTID_LIKE = " LOWER(enterpriseid) = LOWER('@')";
	public static String[]    COL_ENTID = {" enterpriseid = '@'", COL_ENTID_LIKE};
	protected static String   COL_EMAIL_LIKE = " LOWER(emailadd) LIKE LOWER('@')";
	public static String[]    COL_EMAIL = {" emailadd = '@'" ,COL_EMAIL_LIKE};
	protected static String   COL_EMPLEVEL_LIKE = " LOWER(emplevel) = LOWER('@')";
	public static String[]    COL_EMPLEVEL = {" emplevel = '@'" ,COL_EMPLEVEL_LIKE};
	protected static String   COL_LMU_LIKE = " LOWER(lmu) = LOWER('@')";
	public static String[]    COL_LMU = {" lmu = '@'" , COL_LMU_LIKE};
	protected static String   COL_FNAME_LIKE = " LOWER(firstname) LIKE LOWER('%@%')";
	public static String[]    COL_FNAME = {" firstname = '@'" ,COL_FNAME_LIKE};
	protected static String   COL_LNAME_LIKE = " LOWER(lastname) LIKE LOWER('%@%')";
	public static String[]    COL_LNAME = {" lastname = '@'", COL_LNAME_LIKE};
	protected static String   COL_MNAME_LIKE = " LOWER(middlename) LIKE LOWER('@')";
	public static String[]    COL_MNAME = {" middlename = '@'", COL_MNAME_LIKE};
	protected static String   COL_DOB_LIKE = " dateofbirth = '@'";
	public static String[]    COL_DOB = {" dateofbirth = '@'", COL_DOB_LIKE};
	protected static String   COL_AGE_LIKE = " age = @";
	public static String[]    COL_AGE = {" age = @", COL_AGE_LIKE};
	protected static String   COL_GENDER_LIKE = " LOWER(gender) = LOWER('@')";
	public static String[]    COL_GENDER = {" gender = '@'" ,COL_GENDER_LIKE};
	protected static String   COL_CSTATUS_LIKE = " LOWER(civilstatus) = LOWER('@')";
	public static String[]    COL_CSTATUS = {" civilstatus = '@'", COL_CSTATUS_LIKE};
	protected static String   COL_CITIZEN_LIKE = " LOWER(citizenship) = LOWER('@')";
	public static String[]    COL_CITIZEN = {" citizenship = '@'" ,COL_CITIZEN_LIKE};
	protected static String   COL_SSSNO_LIKE = " LOWER(sssno) = LOWER('@')";
	public static String[]    COL_SSSNO = {" sssno = '@'", COL_SSSNO_LIKE};
	protected static String   COL_TINNO_LIKE = " LOWER(tinno) = LOWER('@')";
	public static String[]    COL_TINNO = {" tinno = '@'", COL_TINNO_LIKE};
	protected static String   COL_MOBILENO_LIKE = " LOWER(mobileno) = LOWER('@')";
	public static String[]    COL_MOBILENO = {" mobileno = '@'", COL_MOBILENO_LIKE};
	protected static String   COL_HOMENO_LIKE = " LOWER(homeno) = LOWER('@')";
	public static String[]    COL_HOMENO = {" homeno = '@'", COL_HOMENO_LIKE};
	protected static String   COL_STADD1_LIKE = " LOWER(stadd1) LIKE LOWER('@')";
	public static String[]    COL_STADD1 = {" stadd1 = '@'", COL_STADD1_LIKE};
	protected static String   COL_STADD2_LIKE = " LOWER(stadd2) LIKE LOWER('@')";
	public static String[]    COL_STADD2 = {" stadd2 = '@'" ,COL_STADD2_LIKE};
	protected static String   COL_CITY_LIKE = " LOWER(city) LIKE LOWER('@')";
	public static String[]    COL_CITY = {" city = '@'", COL_CITY_LIKE};
	protected static String   COL_PROVINCE_LIKE = " LOWER(province) LIKE LOWER('@')";
	public static String[]    COL_PROVINCE = {" province = '@'", COL_PROVINCE_LIKE};
	protected static String   COL_COUNTRY_LIKE = " LOWER(country) = LOWER('@')";
	public static String[]    COL_COUNTRY = {" country = '@'",COL_COUNTRY_LIKE} ;
	protected static String   COL_EDUC_LIKE = " LOWER(educattainment) LIKE LOWER('@')";
	public static String[]    COL_EDUC = {" educattainment = '@'", COL_EDUC_LIKE};
	protected static String   COL_RECOG_LIKE = " LOWER(recognition) LIKE LOWER('@')";
	public static String[]    COL_RECOG = {" recognition = '@'" ,COL_RECOG_LIKE};
	protected static String   COL_DATEHIRED_LIKE = " datehired = '@'";
	public static String[]    COL_DATEHIRED = {" datehired = '@'",COL_DATEHIRED_LIKE};
	protected static String   COL_GMU_LIKE = " LOWER(gmu) = LOWER('@')";
	public static String[]    COL_GMU = {" gmu = '@'", COL_GMU_LIKE};
	protected static String   COL_WORKGROUP_LIKE = " LOWER(workgroup) = LOWER('@')";
	public static String[]    COL_WORKGROUP = {" workgroup = '@'", COL_WORKGROUP_LIKE};
	protected static String   COL_SERVICELINE_LIKE = " LOWER(serviceline) = LOWER('@')";
	public static String[]    COL_SERVICELINE = {" serviceline = '@'", COL_SERVICELINE_LIKE};
	protected static String   COL_SPECIALTY_LIKE = " LOWER(specialty) = LOWER('@')";
	public static String[]    COL_SPECIALTY = {" specialty = '@'", COL_SPECIALTY_LIKE};
	protected static String   COL_YRSOFEXP_LIKE = " LOWER(YRSOFEXPERIENCE) = LOWER('@')";
	public static String[]    COL_YRSOFEXP = {" YRSOFEXPERIENCE = '@'", COL_YRSOFEXP_LIKE};
	protected static String   COL_LEVELOFINT_LIKE = " LOWER(LEVELOFINTEREST) = LOWER('@')";
	public static String[]    COL_LEVELOFINT = {" LEVELOFINTEREST = '@'", COL_LEVELOFINT_LIKE};
	protected static String   COL_YRLASTUSED_LIKE = " LOWER(YEARLASTUSED) = LOWER('@')";
	public static String[]    COL_YRLASTUSED = {" YEARLASTUSED = '@'",COL_YRLASTUSED_LIKE};
	protected static String[] COL_ZIPCODE = {" ZIPCODE = '@'", " LOWER(ZIPCODE) = LOWER('@')"};

	//special characters
	public static String STR_AND = " AND ";
	public static String STR_SPACE = "";
	public static String STR_NULL = "NULL";
	public static String CHAR_COMMA = ",";
	public static String CHAR_AT = "@";
	public static String CHAR_$ = "@@";
			
	//constant for sql generator
	public static int STMT_TYPE_SET = 1;
	public static int STMT_TYPE_WHERE = 2;
	
	//constant for database access type
	public static String CONN_JNDI = "JNDIDBAccess";
	protected static String CONN_ORACLEDB = "OracleDBAccess";
	protected static String CONN_ORACLEOCIDB = "OracleOCIDBAccess";
	
	//constants for getting instance of data acces objects
	public static String DAO_SKILL = "SkillDAO";
	public static String DAO_SKILLCAT = "SkillCategoryDAO";
	public static String DAO_PROJ = "ProjectDAO";
	public static String DAO_EMP = "EmployeeDAO";
	public static String DAO_EMPACC = "EmpAccentureDetailsDAO";
	public static String DAO_EMPSKILL = "EmpSkillsDAO";
	public static String DAO_EMPPROJ = "EmpProjectDAO";
	
	protected static String GEN_SKILL = "StatementGenSkill";
	protected static String GEN_SKILLCAT = "StatementGenCategory";
	protected static String GEN_PROJ = "StatementGenProject";
	protected static String GEN_EMP = "StatementGenEmployee";
	protected static String GEN_EMPACC = "StatementGenAccDetails";
	protected static String GEN_EMPSKILL = "StatementGenEmpSkill";
	protected static String GEN_EMPPROJ = "StatementGenEmpProject";
	
	

}
