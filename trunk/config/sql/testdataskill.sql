insert into project (name, description, startdate, enddate, clientname, status) VALUES ('JDS','Java Development School', '01-NOV-04', '01-NOV-05', 'Accenture', 'APPROVED');
insert into project (name, description, startdate, enddate, clientname, status) VALUES ('Walgreens','Failed Project', '01-JAN-04', '01-OCT-04', 'Accenture', 'APPROVED');
insert into project (name, description, startdate, enddate, clientname, status) VALUES ('eSales','Failed Project', '01-JAN-04', '01-OCT-04', 'Accenture', 'APPROVED');

insert into skillcategory (name, description, status) VALUES ('Programming Language','Use for Application', 'APPROVED');
insert into skillcategory (name, description, status) VALUES ('Operating Systems','Window, Unix, etc', 'APPROVED');
insert into skillcategory (name, description, status) VALUES ('Multimedia','Pangdrawing', 'APPROVED');

insert into skill (catid, name, description, status) VALUES ('1001','JAVA','J2SDK1.5','APPROVED');
insert into skill (catid, name, description, status) VALUES ('1001','C++','VER 6','APPROVED');
insert into skill (catid, name, description, status) VALUES ('1001','Adobe Photoshop','VER 8','APPROVED');

INSERT INTO employee ( firstname, lastname, middlename, dateofbirth, age, gender, civilstatus, citizenship, sssno, tinno,
			mobileno, homeno, stadd1, stadd2, city, province, country, educattainment, recognition )
			VALUES ( 'employeefirst', 'employeelast' , 'employeemiddle', '01-JAN-04', 12,'M','MARRIED',
			'Filipino', '123456789', '123456789', '555-5555', '666-6666', 'Street1', 'Street2',
			'Manila', 'NCR', 'Mexico', 'College Graduate', 'none') 


INSERT INTO employee ( firstname, lastname, middlename, dateofbirth, age, gender, civilstatus, citizenship, sssno, tinno,
			mobileno, homeno, stadd1, stadd2, city, province, country, educattainment, recognition )
			VALUES ( 'employeefirst2', 'employeelast2' , 'employeemiddle2', '02-JAN-04', 12,'F','MARRIED',
			'Filipino', '223456789', '223456789', '255-5555', '266-6666', 'Street1', 'Street2',
			'Manila', 'NCR', 'Mexico', 'College Graduate', 'none') 

INSERT INTO employee ( firstname, lastname, middlename, dateofbirth, age, gender, civilstatus, citizenship, sssno, tinno,
			mobileno, homeno, stadd1, stadd2, city, province, country, educattainment, recognition )
			VALUES ( 'employeefirst3', 'employeelast3' , 'employeemiddle3', '02-JAN-03', 12,'F','MARRIED',
			'Filipino', '223456789', '323456789', '355-5555', '366-6666', 'Street1', 'Street2',
			'Manila', 'NCR', 'Mexico', 'College Graduate', 'none') 


INSERT INTO empskills (empno, skillid, proficiency, details) VALUES ('1001','1001','12','java');
INSERT INTO empskills (empno, skillid, proficiency, details) VALUES ('1001','1002','22','c++');
INSERT INTO empskills (empno, skillid, proficiency, details) VALUES ('1001','1003','22','adobe');

INSERT INTO empprojects (projid, empno, role, rollindate, rolloffdate, taskdescription) 
			VALUES ('1001','1001','Team Lead','02-JAN-04','02-FEB-04','Wala lang');
INSERT INTO empprojects (projid, empno, role, rollindate, rolloffdate, taskdescription) 
			VALUES ('1002','1001','Lead Programmer','12-JAN-04','02-FEB-04','Wala lang');
INSERT INTO empprojects (projid, empno, role, rollindate, rolloffdate, taskdescription) 
			VALUES ('1003','1001','Programmer','12-FEB-04','20-FEB-04','Wala lang');

INSERT INTO empaccenturedetail(empno, enterpriseid, emailadd, emplevel, lmu, status ) 
			VALUES ( '1001' , '1001' , '1001@yahoo.com' , 'Team Lead' , 'LMU' , 'PERMANENT' );
INSERT INTO empaccenturedetail(empno, enterpriseid, emailadd, emplevel, lmu, status ) 
			VALUES ( '1002' , '1002' , '1002@yahoo.com' , 'Team Lead' , 'LMU' , 'PERMANENT' );
INSERT INTO empaccenturedetail(empno, enterpriseid, emailadd, emplevel, lmu, status ) 
			VALUES ( '1003' , '1003' , '1003@yahoo.com' , 'Team Lead' , 'LMU' , 'PERMANENT' );