CREATE TABLE project (
  id varchar2(30) default '',
  name varchar2(50) default '' NOT NULL,
  description varchar2(100) default '',
  startDate date default '01-JAN-04' NOT NULL,
  endDate date default '01-JAN-04',
  clientName varchar2(50) default '',
  status varchar2(50) default 'APPROVED' NOT NULL,
  CONSTRAINT proj_pk PRIMARY KEY  (Id), 
  CONSTRAINT project_uk UNIQUE (name)
) ; 



CREATE TABLE skillcategory (
  id varchar2(30) default '',
  name varchar2(50) default '' NOT NULL,
  description varchar2(100) default '',
  status varchar2(20) default 'APPROVED',
  CONSTRAINT skillcategory_pk PRIMARY KEY  (Id),
  CONSTRAINT skillcategork_uk UNIQUE (name)
) ; 



CREATE TABLE skill (
  id varchar2(30) default '',
  catId varchar2(30) default '',
  name varchar2(50) default '' NOT NULL,
  description varchar2(100) default '',
  status varchar2(20) default 'APPROVED' NOT NULL,
  CONSTRAINT skill_pk PRIMARY KEY  (id),
  CONSTRAINT skill_uk UNIQUE (name,catid),
  CONSTRAINT skill_fk FOREIGN KEY  (catId)  REFERENCES skillcategory(Id)
  ON DELETE CASCADE
) ; 


CREATE TABLE employee (
  empNo varchar2(30) default '',
  firstName varchar2(50) default '' NOT NULL,
  lastName varchar2(50)  default '' NOT NULL,
  middleName varchar2(50) default '' NOT NULL,
  dateOfBirth date default '01-JAN-04' NOT NULL,
  age number(11) default '0',
  gender char(1) default '0' NOT NULL,
  civilStatus varchar2(15) default '0',
  citizenship varchar2(30) default '',
  SSSNo varchar2(15) default '',
  TINNo varchar2(15) default '',
  mobileNo varchar2(15) default '',
  homeNo varchar2(15) default '',
  stAdd1 varchar2(100) default '' NOT NULL,
  stAdd2 varchar2(100) default '',
  city varchar2(100) default '',
  province varchar2(100) default '',
  country varchar2(100) default '',
  educAttainment varchar2(500) default '' NOT NULL,  /*educational attainment*/
  recognition varchar2(500) default '', /* recognition */
  CONSTRAINT emp_pk PRIMARY KEY (empNo),
  CONSTRAINT emp_uk UNIQUE (firstName ,lastName, middleName)
) ; 

 

CREATE TABLE empaccenturedetail (
  empNo varchar2(30) default '',
  enterpriseId varchar2(50) default '' NOT NULL,
  emailAdd varchar2(50) default '',
  empLevel varchar2(20) default '',
  LMU varchar2(5) default '' NOT NULL,
  status varchar2(20) default '',
  datehired date default '01-JAN-04' NOT NULL,
  GMU varchar2(5) default '' NOT NULL,
  WORKGROUP varchar2(50) default '',
  SPECIALTY varchar2(50) default '',
  SERVICELINE varchar2(50) default '',
  CONSTRAINT empaccenturedetail_pk PRIMARY KEY  (empNo),
  CONSTRAINT empaccenturedetail_fk FOREIGN KEY  (empNo)
  REFERENCES employee (empNo)
);


CREATE TABLE empprojects (
  projId varchar2(30) default '',
  empNo varchar2(30) default '',
  role varchar2(100) default '',
  rollinDate date default '01-JAN-04' NOT NULL,
  rollOffDate date default '01-JAN-04',
  taskDescription varchar2(100) default '',
  CONSTRAINT empproj_uk UNIQUE (empno,projId ),
  CONSTRAINT empproj_fk FOREIGN KEY  (projId)  REFERENCES project(Id)
  ON DELETE CASCADE
);



CREATE TABLE empskills (
  empNo varchar2(30) default '',
  skillId varchar2(30) default '',
  proficiency number(11) default '0' NOT NULL,
  details varchar2(100) default '',
  YRSOFEXPERIENCE number(3) default '0',
  LEVELOFINTEREST number(1) default '0',
  YEARLASTUSED number(4) default '0',
  CONSTRAINT empskills_uk UNIQUE (empno,skillid),
  CONSTRAINT empskills_fk FOREIGN KEY  (skillId)  REFERENCES skill (Id)
  ON DELETE CASCADE
) ; 






