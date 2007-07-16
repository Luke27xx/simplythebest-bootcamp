<%@ include file="../includes/header.jspf" %>         


<html:form action="/employeesearch" focus="firstName" method="POST">
<bean:define id="recordCount" name="EmployeeSearchForm" property="recordCount" type="java.lang.String" />

<title>Employee Search</title>
<body bgcolor="#FFFFFF" text="#000000" onLoad="MM_preloadImages('images/bar-1_r1_c2_f2.gif','images/bar-1_r1_c4_f2.gif','images/bar-1_r1_c6_f2.gif','images/bar-1_r1_c8_f2.gif')">
<table width="793" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td valign="top" height="98" colspan="3"><html:img src="images/banner-1.jpg" width="792" height="98"/></td>
  </tr>
  <tr> 
    <td width="136" height="34"></td>
    <td colspan="2" valign="top"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td width="657" height="34" valign="top"> 
            <table border="0" cellpadding="0" cellspacing="0" width="656">
              <tr>
                <td><img src="images/spacer.gif" width="8" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="147" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="17" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="148" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="16" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="148" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="16" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="148" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="8" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="1" height="1" border="0" name="undefined_2"></td>
              </tr>
              <tr> 
                <td><img name="bar1_r1_c1" src="images/bar-1_r1_c1.gif" width="8" height="28" border="0"></td>
                <td><a href="navigate.do?target=employee" onMouseOut="MM_swapImgRestore()"  onMouseOver="MM_swapImage('bar1_r1_c2','','images/bar-1_r1_c2_f2.gif',1);" ><img name="bar1_r1_c2" src="images/bar-1_r1_c2.gif" width="147" height="28" border="0"></a></td>
                <td><img name="bar1_r1_c3" src="images/bar-1_r1_c3.gif" width="17" height="28" border="0"></td>
                <td><a href="navigate.do?target=category" onMouseOut="MM_swapImgRestore()"  onMouseOver="MM_swapImage('bar1_r1_c4','','images/bar-1_r1_c4_f2.gif',1);" ><img name="bar1_r1_c4" src="images/bar-1_r1_c4.gif" width="148" height="28" border="0"></a></td>
                <td><img name="bar1_r1_c5" src="images/bar-1_r1_c5.gif" width="16" height="28" border="0"></td>
                <td><a href="navigate.do?target=skills" onMouseOut="MM_swapImgRestore()"  onMouseOver="MM_swapImage('bar1_r1_c6','','images/bar-1_r1_c6_f2.gif',1);" ><img name="bar1_r1_c6" src="images/bar-1_r1_c6.gif" width="148" height="28" border="0"></a></td>
                <td><img name="bar1_r1_c7" src="images/bar-1_r1_c7.gif" width="16" height="28" border="0"></td>
                <td><a href="navigate.do?target=projects" onMouseOut="MM_swapImgRestore()"  onMouseOver="MM_swapImage('bar1_r1_c8','','images/bar-1_r1_c8_f2.gif',1);" ><img name="bar1_r1_c8" src="images/bar-1_r1_c8.gif" width="148" height="28" border="0"></a></td>
                <td><img name="bar1_r1_c9" src="images/bar-1_r1_c9.gif" width="8" height="28" border="0"></td>
                <td><img src="images/spacer.gif" width="1" height="28" border="0" name="undefined_2"></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr> 
    <td valign="top" rowspan="50">  
      <table width="100%" border="0" cellpadding="0" cellspacing="0"  bgcolor="#FF9900">
        <tr> 
          <td width="3" height="5"></td>
          <td width="133"></td>
        </tr>
        <tr> 
          <td colspan="2" height="19" valign="top"><font face="Arial, Helvetica, sans-serif" size="2"><b>Employee 
            Search</b></font></td>
        </tr>
        <tr> 
          <td height="5"></td>
          <td></td>
        </tr>
        <tr> 
          <td height="400"></td>
          <td valign="top" height="400"> 
              <p>
                <font color="red"><html:errors property="BCerror"/></font>
                <font color="red"><html:errors property="ASerror"/></font>                              
                <font color="red"><html:errors property="invalidAll"/></font>
                <font color="red"><html:errors property="recordNoFound"/></font>
              </p>
              <p>
                <font color="red"><html:errors property="firstName"/><br></font>
                <font face="Arial, Helvetica, sans-serif" size="2"><b>First Name</b></font><br>
                <html:text name="EmployeeSearchForm" property="firstName" size="15" maxlength="50"/><br>
              </p>
              <p>
                <font color="red"><html:errors property="lastName"/><br></font>
                <font size="2" face="Arial, Helvetica, sans-serif"><b>Last Name</b></font><br>
                <html:text name="EmployeeSearchForm" property="lastName" size="15" maxlength="50"/><br>
              </p>
              <p>
                <html:submit value="Search"/>
              </p>
              <p>
                <html:link page="/employeeloadadd.do">Add Employee</html:link>
              </p>
          </td>
        </tr>
      </table>
    </td>
    <td width="20" height="15"></td>
    <td width="637"></td>
  </tr>
  <tr>
    <td valign="top" width="100%"> 
      <table width="656" border="0" cellpadding="0" cellspacing="0">
	  <tr align="center">
	    <td width="5%"><br>&nbsp;</td>
	    <td width="50%" align="left"><logic:equal name="EmployeeSearchForm" property="searchMode" value="true">
	    <bean:message name="EmployeeSearchForm" property="messageKey" arg0="<%=recordCount%>"/>
	  </logic:equal></td>
	  </ tr>
	<logic:greaterThan name="EmployeeSearchForm" property="listSize" value="0">
	
	  <tr align="left">
	    <td width="5%">&nbsp;</td>
	    <th width="30%" style="background-color:darkorange"><font face="Arial, Helvetica, sans-serif" size="3" color="#FFFFFF">Fullname</font></th>
	    <th width="30%" style="background-color:darkorange"><font face="Arial, Helvetica, sans-serif" size="3" color="#FFFFFF">Level</font></th>
	    <td width="25%" style="background-color:darkorange"><font face="Arial, Helvetica, sans-serif" size="3" color="#FFFFFF">&nbsp;</font></td>
	  </ tr>
	  <logic:iterate name="EmployeeSearchForm" indexId="index" id="EmployeeSearchListItemForm" property="employees" type="com.jds.apps.hr.employee.form.EmployeeSearchListItemForm">
	  <tr align="left">
	    <td></td>
	    <td>
		  <html:link page="/employeeview.do?viewtype=view" name="EmployeeSearchListItemForm" property="linkDataMap">
	        <bean:write name="EmployeeSearchListItemForm" property="fullName"/>
	      </html:link>
	    </td>
	    <td>
	      <bean:write name="EmployeeSearchListItemForm" property="level"/>
	    </td>
	    <td>
		  <html:link page="/employeeview.do?viewtype=edithr" name="EmployeeSearchListItemForm" property="linkDataMap">Edit
	      </html:link>
	    </td>
	  </tr>
	  </logic:iterate>
	</logic:greaterThan>

      </table>
    </td>
  </tr>
</table>
</body>
</html:form>
<%@ include file="../includes/footer.jspf" %>         
