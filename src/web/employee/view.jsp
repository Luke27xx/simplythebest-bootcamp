<%@ include file="../includes/header.jspf" %>         
<form focus="OK" method="POST">
<title>Employee Information</title>
<body bgcolor="#FFFFFF" text="#000000" onLoad="MM_preloadImages('images/bar-1_r1_c2_f2.gif','images/bar-1_r1_c4_f2.gif','images/bar-1_r1_c6_f2.gif','images/bar-1_r1_c8_f2.gif')">
<table width="793" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td valign="top" height="98" colspan="3"><html:img src="images/banner-1.jpg" width="792" height="98"/></td>
  </tr>
  <tr> 
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
  <font color="red"><html:errors /></font>
  <tr align="left">
    <th colspan="3" align="left" style="background-color:darkorange">
    <font face="Arial, Helvetica, sans-serif" size="3">Employee Number: 
    <bean:write name="EmployeeInfoForm" property="empNo"/></font>
    </th>
  </tr>
  <tr align="center">
  	<td colspan="3">&nbsp;</td>
  </tr>
  <tr align="left">
    <th colspan="3" align="center" style="background-color:darkorange">
    <font face="Arial, Helvetica, sans-serif" size="4" color="#FFFFFF">Personal Information</font></th>
  </tr>
  <tr align="left">
    <td colspan="3">
  	<table border="0"  width="100%">
  	   <tr>
  	     <th align="left" colspan="1">Last Name
  	     </th>
  	     <td align="left" colspan="2"><bean:write name="EmployeeInfoForm" property="lastName"/>
  	     </td>
  	     <th align="left" colspan="1">First Name
  	     </th>
  	     <td align="left" colspan="2"><bean:write name="EmployeeInfoForm" property="firstName"/>
  	     </td>
  	     <th align="left" colspan="1">Middle Name
  	     </th>
  	     <td align="left" colspan="2"><bean:write name="EmployeeInfoForm" property="middleName"/>
  	     </td>
  	   </tr>
  	   <tr>
  	     <th align="left" colspan="1">Birth Date
  	     </th>
  	     <td align="left" colspan="2"><bean:write name="EmployeeInfoForm" property="dob"/>
  	     </td>
  	     <th align="left" colspan="1">Age
  	     </th>
  	     <td align="left" colspan="2"><bean:write name="EmployeeInfoForm" property="age"/>
  	     </td>
  	     <th align="left" colspan="1">Gender
  	     </th>
  	     <td align="left" colspan="2"><bean:write name="EmployeeInfoForm" property="gender"/>
  	     </td>
  	   </tr>
  	</table>
  	</td>
  </tr>
  <tr align="center">
    <td colspan="3">&nbsp;
    </td>
  </tr>
  <tr align="left">
    <th colspan="3" align="center" style="background-color:darkorange">
    <font face="Arial, Helvetica, sans-serif" size="4" color="#FFFFFF">Civil Information</font></th>
  </tr>
  <tr align="left">
    <td colspan="3">
  	<table border="0" width="100%">
  	   <tr>
  	     <th align="left" colspan="1">Status
  	     </th>
  	     <td align="left" colspan="3"><bean:write name="EmployeeInfoForm" property="civilStatus"/>
  	     </td>
  	     <th align="left" colspan="1">Citizenship
  	     </th>
  	     <td align="left" colspan="3"><bean:write name="EmployeeInfoForm" property="citizenship"/>
  	     </td>
  	   </tr>
  	   <tr>
  	     <th align="left" colspan="1">SSS Number
  	     </th>
  	     <td align="left" colspan="3"><bean:write name="EmployeeInfoForm" property="sssNo"/>
  	     </td>
  	     <th align="left" colspan="1">TIN Number
  	     </th>
  	     <td align="left" colspan="3"><bean:write name="EmployeeInfoForm" property="tinNo"/>
  	     </td>
  	   </tr>
  	</table>
  	</td>
  </tr>
  <tr align="center">
  	<td colspan="3">&nbsp;</td>
  </tr>
  <tr align="left">
    <th width="50%" align="center" style="background-color:darkorange">
    <font face="Arial, Helvetica, sans-serif" size="4" color="#FFFFFF">Home Address</font></th>
    <th width="50%" align="center" style="background-color:darkorange">
    <font face="Arial, Helvetica, sans-serif" size="4" color="#FFFFFF">Contact Information</font></th>
  </tr>
  <tr align="left">
    <td width="50%" align="left">
      <table border="0"  width="100%">
        <tr>
          <th align="left" >Street
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="street1"/>
          </td>
        </tr>
        <tr>
          <th>&nbsp;
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="street2"/>
          </td>
        </tr>
        <tr>
          <th align="left" >City
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="city"/>
          </td>
        </tr>
        <tr>
          <th align="left" >State
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="state"/>
          </td>
        </tr>
        <tr>
          <th align="left" >Country
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="country"/>
          </td>
        </tr>
      </table>
    </td>
    <td width="50%" align="left">
      <table border="0"  width="100%">
        <tr>
          <th align="left" >Mobile Phone
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="mobilePhoneNo"/>
          </td>
        </tr>
        <tr>
          <th align="left" >Home Phone
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="homePhoneNo"/>
          </td>
        </tr>
        <tr>
          <th>&nbsp;
          </th>
          <td>&nbsp;
          </td>
        </tr>
        <tr>
          <th>&nbsp;
          </th>
          <td>&nbsp;
          </td>
        </tr>
        <tr>
          <th>&nbsp;
          </th>
          <td>&nbsp;
          </td>
        </tr>
        <tr>
          <th>&nbsp;
          </th>
          <td>&nbsp;
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr align="center">
    <td colspan="3">&nbsp;
    </td>
  </tr>
  <tr align="left">
    <th colspan="3" align="center" style="background-color:darkorange">
    <font face="Arial, Helvetica, sans-serif" size="4" color="#FFFFFF">Accenture Information</font></th>
  </tr>
  <tr align="left">
    <td width="50%" align="left">
      <table border="0" width="100%">
        <tr>
          <th align="left" >Email Address
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="enterpriseAddress"/>
          </td>
        </tr>
        <tr>
          <th align="left" >GMU
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="GMU"/>
          </td>
        </tr>
        <tr>
          <th align="left" >Date Hired
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="dateHired"/>
          </td>
        </tr>
        <tr>
          <th align="left" >Work Group
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="workGroup"/>
          </td>
        </tr>
        <tr>
          <th align="left" >Specialty
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="specialty"/>
          </td>
        </tr>
      </table>
    </td>
    <td width="50%" align="left">
      <table border="0">
        <tr>
          <th align="left" >Enterprise ID
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="enterpriseId"/>
          </td>
        </tr>
        <tr>
          <th align="left" >Level
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="level"/>
          </td>
        </tr>
        <tr>
          <th align="left" >LMU
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="LMU"/>
          </td>
        </tr>
        <tr>
          <th align="left" >Status
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="status"/>
          </td>
        </tr>
        <tr>
          <th align="left" >Service Line
          </th>
          <td align="left" ><bean:write name="EmployeeInfoForm" property="serviceLine"/>
          </td>
        </tr>
        <tr>
          <th>&nbsp;
          </th>
          <td>&nbsp;
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr align="center">
  	<td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <th colspan="3" align="left" style="background-color:darkorange">
    <font face="Arial, Helvetica, sans-serif" size="4" color="#FFFFFF">Education Background</font></th>
  </tr>
  <tr>
    <td colspan="3" align="left" ><bean:write name="EmployeeInfoForm" property="educationalAttainment"/></td>
  </tr>
  <tr align="center">
    <td colspan="3">&nbsp;
    </td>
  </tr>
  <tr>
    <th colspan="3" align="left" style="background-color:darkorange">
    <font face="Arial, Helvetica, sans-serif" size="4" color="#FFFFFF">Certification/Award</font></th>
  </tr>
  <tr>
    <td colspan="3" align="left" ><bean:write name="EmployeeInfoForm" property="recognitions"/></td>
  </tr>
  <tr align="center">
	  	<tr><td colspan="3" align="center"><br><input type="button" value="OK" name="B1" onClick="javascript:history.back()"></td>
  </tr>
</table>
</body>
</form>
<%@ include file="../includes/footer.jspf" %>         
