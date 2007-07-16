<%@ include file="../includes/header.jspf" %>         
<script language="javascript">
	function confirmCancel() {
		if(confirm("Do you really want to cancel?")){
			EmployeeInfoForm.action="javascript:history.back()";
			EmployeeInfoForm.submit();
		}
		
	}
</script>

<bean:define id="month" name="EmployeeInfoForm" property="month" type="java.util.List" />
<bean:define id="empGender" name="EmployeeInfoForm" property="empGender" type="java.util.List" />
<bean:define id="empCivilStatus" name="EmployeeInfoForm" property="empCivilStatus" type="java.util.List" />
<bean:define id="empLevel" name="EmployeeInfoForm" property="empLevel" type="java.util.List" />
<bean:define id="skills" name="EmployeeInfoForm" property="skills" type="java.util.List" />
<html:form action="/employeeupdate" focus="OK" method="POST">

<title>Update Employee Information</title>
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
  <tr align="left">
    <th colspan="3" align="left" style="background-color:darkorange">
    <font face="Arial, Helvetica, sans-serif" size="3">Employee Number: 
    <bean:write name="EmployeeInfoForm" property="empNo"/></font>
    <html:hidden name="EmployeeInfoForm" property="empNo"/>
    </th>
  </tr>
  <tr align="center">
  	<td colspan="3">&nbsp;</td>
  </tr>
  <tr><td colspan="3"><font color="red">
    <html:errors property="BCerror"/>
    <html:errors property="ASerror"/>
    <html:errors property="updateError"/></font>
  </td></tr>
  <tr align="left">
    <td colspan="3" align="center" style="background-color:darkorange">
    <font face="Arial, Helvetica, sans-serif" size="4" color="#FFFFFF">Personal Information</font></td>
  </tr>
  <tr align="left">
    <td colspan="3">
  	<table border="0"  width="100%">
  	   <tr>
  	     <th colspan="1" align="left"></th>
  	     <td colspan="1" style="color:red" align="left"><html:errors property="lastName"/></td>
  	     <th colspan="1" align="left"></th>
  	     <td colspan="1" style="color:red" align="left"><html:errors property="firstName"/></td>
  	     <th colspan="1" align="left"></th>
  	     <td colspan="1" style="color:red" align="left"><html:errors property="middleName"/></td>
  	   </tr>
  	   <tr>
  	     <th align="left" colspan="1">Last Name
  	     </th>
  	     <td align="left" colspan="1"><html:text name="EmployeeInfoForm" property="lastName"/><sup><font color=red>*</font></sup>
  	     </td>
  	     <th align="left" colspan="1">First Name
  	     </th>
  	     <td align="left" colspan="1"><html:text name="EmployeeInfoForm" property="firstName"/><sup><font color=red>*</font></sup>
  	     </td>
  	     <th align="left" colspan="1">Middle Name
  	     </th>
  	     <td align="left" colspan="1"><html:text name="EmployeeInfoForm" property="middleName"/><sup><font color=red>*</font></sup>
  	     </td>
  	   </tr>
       <tr>
  	     <th colspan="1" align="left"></th>
  	     <td colspan="1" style="color:red" align="left"><html:errors property="dob"/></td>
  	     <th colspan="1" align="left"></th>
  	     <td colspan="1" align="left"></td>
  	     <th colspan="1" align="left"></th>
  	     <td colspan="1" style="color:red" align="left"><html:errors property="gender"/></td>
  	   </tr>
  	   <tr>
  	     <th align="left" colspan="1">Birth Date
  	     </th>
  	     <td colspan="1" align="left">
  	       <html:select name="EmployeeInfoForm" property="birthMonth">
             <html:options collection="month" property="value" labelProperty="label" />
  	       </html:select>&nbsp;
  	       <html:text name="EmployeeInfoForm" maxlength="2" size="3" property="birthDate"/>&nbsp;
  	       <html:text name="EmployeeInfoForm" maxlength="4" size="5" property="birthYear"/><sup><font color=red>*</font></sup>
  	     </td>
  	     <th align="left" colspan="1">Age
  	     </th>
  	     <td align="left" colspan="1"><html:text name="EmployeeInfoForm" property="age"/>
  	     </td>
  	     <th align="left" colspan="1">Gender
  	     </th>
  	     <td align="left" colspan="1"><html:select name="EmployeeInfoForm" property="gender">
             <html:options collection="empGender" property="value" labelProperty="label" />
  	       </html:select><sup><font color=red>*</font></sup>&nbsp;
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
    <td colspan="3" align="center" style="background-color:darkorange">
    <font face="Arial, Helvetica, sans-serif" size="4" color="#FFFFFF">Civil Information</font></td>
  </tr>
  <tr align="left">
    <td colspan="3">
  	<table border="0" width="100%">
  	   <tr>
  	     <th align="left" colspan="1"></th>
  	     <td align="left" colspan="3">
  	     <th align="left" colspan="1"></th>
  	     <td align="left" colspan="3" style="color:red"><html:errors property="citizenship"/></td>
  	   </tr>	  	
  	   <tr>
  	     <th align="left" colspan="1">Status
  	     </th>
  	     <td align="left" colspan="3"><html:select name="EmployeeInfoForm" property="civilStatus">
             <html:options collection="empCivilStatus" property="value" labelProperty="label" />
  	       </html:select>&nbsp;
  	     </td>
  	     <th align="left" colspan="1">Citizenship
  	     </th>
  	     <td align="left" colspan="3"><html:text name="EmployeeInfoForm" property="citizenship"/>
  	     </td>
  	   </tr>
   	   <tr>
  	     <th colspan="1" align="left"></th>
  	     <td colspan="3" style="color:red" align="left"><html:errors property="sssNo"/></td>
  	     <th colspan="1" align="left"></th>
  	     <td colspan="3" style="color:red" align="left"><html:errors property="tinNo"/></td>
  	   </tr>
  	   <tr>
  	     <th align="left" colspan="1">SSS Number
  	     </th>
  	     <td align="left" colspan="3"><html:text name="EmployeeInfoForm" property="sssNo"/><sup><font color=red>*</font></sup>
  	     </td>
  	     <th align="left" colspan="1">TIN Number
  	     </th>
  	     <td align="left" colspan="3"><html:text name="EmployeeInfoForm" property="tinNo"/><sup><font color=red>*</font></sup>
  	     </td>
  	   </tr>
  	</table>
  	</td>
  </tr>
  <tr align="center">
  	<td colspan="3">&nbsp;</td>
  </tr>
  <tr align="left">
    <td width="50%" align="center" style="background-color:darkorange">
    <font face="Arial, Helvetica, sans-serif" size="4" color="#FFFFFF">Home Address</font></td>
    <td width="50%" align="center" style="background-color:darkorange">
    <font face="Arial, Helvetica, sans-serif" size="4" color="#FFFFFF">Contact Information</font></td>
  </tr>
  <tr align="left">
    <td width="50%" align="left">
      <table border="0"  width="100%">
        <tr>
          <th align="left"></th>
          <td style="color:red" align="left"><html:errors property="street1"/></td>
        </tr>
        <tr>
          <th align="left" >Street
          </th>
          <td align="left" ><html:text name="EmployeeInfoForm" property="street1"/><sup><font color=red>*</font></sup>
          </td>
        </tr>
        <tr>
          <th align="left"></th>
          <td style="color:red" align="left"><html:errors property="street2"/></td>
        </tr>
        <tr>
          <th>&nbsp;
          </th>
          <td align="left" ><html:text name="EmployeeInfoForm" property="street2"/>
          </td>
        </tr>
        <tr>
          <th align="left"></th>
          <td style="color:red" align="left"><html:errors property="city"/></td>
        </tr>
        <tr>
          <th align="left" >City
          </th>
          <td align="left" ><html:text name="EmployeeInfoForm" property="city"/><sup><font color=red>*</font></sup>
          </td>
        </tr>
        <tr>
          <th align="left"></th>
          <td style="color:red" align="left"><html:errors property="state"/></td>
        </tr>
        <tr>
          <th align="left" >State
          </th>
          <td align="left" ><html:text name="EmployeeInfoForm" property="state"/><sup><font color=red>*</font></sup>
          </td>
        </tr>
        <tr>
          <th align="left"></th>
          <td style="color:red" align="left"><html:errors property="country"/></td>
        </tr>
        <tr>
          <th align="left" >Country
          </th>
          <td align="left" ><html:text name="EmployeeInfoForm" property="country"/><sup><font color=red>*</font></sup>
          </td>
        </tr>
      </table>
    </td>
    <td width="50%" align="left">
      <table border="0"  width="100%">
        <tr>
          <th align="left" ></th>
          <td style="color:red" align="left"><html:errors property="mobilePhoneNo"/></td>
        </tr>      
        <tr>
          <th align="left" >Mobile Phone
          </th>
          <td align="left" ><html:text name="EmployeeInfoForm" property="mobilePhoneNo"/>
          </td>
        </tr>
        <tr>
          <th align="left" ></th>
          <td style="color:red" align="left"><html:errors property="homePhoneNo"/></td>
        </tr>                
        <tr>
          <th align="left" >Home Phone
          </th>
          <td align="left" ><html:text name="EmployeeInfoForm" property="homePhoneNo"/>
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
    <td colspan="3" align="center" style="background-color:darkorange">
    <font face="Arial, Helvetica, sans-serif" size="4" color="#FFFFFF">Accenture Information</font></td>
  </tr>
  <tr align="left">
    <td width="50%" align="left">
      <table border="0" width="100%">
        <tr>
          <th></th>
          <td style="color:red"><html:errors property="enterpriseAddress"/></td>
        </tr>
        <tr>
          <th align="left" >Email Address
          </th>
          <td align="left" ><html:text name="EmployeeInfoForm" property="enterpriseAddress"/><sup><font color=red>*</font></sup>
          </td>
        </tr>
        <tr>
          <th></th>
          <td style="color:red"><html:errors property="gmu"/></td>
        </tr>
        <tr>
          <th align="left" >GMU
          </th>
          <td align="left" ><html:text name="EmployeeInfoForm" property="GMU"/><sup><font color=red>*</font></sup>
          </td>
        </tr>
        <tr>
          <th></th>
          <td style="color:red"><html:errors property="hireDate"/></td>
        </tr>
        <tr>
          <th align="left" >Date Hired
          </th>
          <td colspan="4">
  	       <html:select name="EmployeeInfoForm" property="hireMonth">
             <html:options collection="month" property="value" labelProperty="label" />
  	       </html:select>&nbsp;
  	       <html:text name="EmployeeInfoForm" maxlength="2" size="2" property="hireDate"/>&nbsp;
  	       <html:text name="EmployeeInfoForm" maxlength="4" size="5" property="hireYear"/><sup><font color=red>*</font></sup>
          </td>
        </tr>
        <tr>
          <th></th>
          <td style="color:red"><html:errors property="workGroup"/></td>
        </tr>
        <tr>
          <th align="left" >Work Group
          </th>
          <td align="left" ><html:text name="EmployeeInfoForm" property="workGroup"/>
          </td>
        </tr>
        <tr>
          <th align="left" >Specialty
          </th>
          <td align="left" ><html:select name="EmployeeInfoForm" property="specialty">
             <html:options collection="skills" property="value" labelProperty="label" />
  	       </html:select>&nbsp;
          </td>
        </tr>
      </table>
    </td>
    <td width="50%" align="left">
      <table border="0">
        <tr>
        <tr>
          <th></th>
          <td style="color:red" color="red"><html:errors property="enterpriseId"/></td>
        </tr>
          <th align="left" >Enterprise ID
          </th>
          <td align="left" ><html:text name="EmployeeInfoForm" property="enterpriseId"/><sup><font color=red>*</font></sup>
          </td>
        </tr>
        <tr>
          <th align="left" >Level
          </th>
          <td align="left" ><html:select name="EmployeeInfoForm" property="level">
             <html:options collection="empLevel" property="value" labelProperty="label" />
  	       </html:select>&nbsp;
          </td>
        </tr>
        <tr>
          <th></th>
          <td style="color:red"><html:errors property="lmu"/></td>
        </tr>
        <tr>
          <th align="left" >LMU
          </th>
          <td align="left" ><html:text name="EmployeeInfoForm" property="LMU"/><sup><font color=red>*</font></sup>
          </td>
        </tr>
        <tr>
          <th align="left" ></th>
          <td style="color:red"><html:errors property="status"/></td>
        </tr>               
        <tr>
          <th align="left" >Status
          </th>
          <td align="left" ><html:text name="EmployeeInfoForm" property="status"/>
          </td>
        </tr>
        <tr>
          <th align="left" ></th>
          <td style="color:red"><html:errors property="serviceLine"/></td>
        </tr>                
        <tr>
          <th align="left" >Service Line
          </th>
          <td align="left" ><html:text name="EmployeeInfoForm" property="serviceLine"/>
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
    <td colspan="3" align="left" style="background-color:darkorange">
    <font face="Arial, Helvetica, sans-serif" size="4" color="#FFFFFF">Education Background</font><font color="red">
     <html:errors property="educationalAttainment"/></font></td>
  </tr>
  <tr>
    <td colspan="3" ><html:textarea rows="4" name="EmployeeInfoForm" property="educationalAttainment"/><sup><font color=red>*</font></sup></td>
  </tr>
  <tr align="center">
    <td colspan="3">&nbsp;
    </td>
  </tr>
  <tr>
    <td colspan="3" align="left" style="background-color:darkorange">
    <font face="Arial, Helvetica, sans-serif" size="4" color="#FFFFFF">Certification/Award</font>
     <html:errors property="recognitions"/></font></td>
  </tr>
  <tr>
    <td colspan="3" align="left" ><html:textarea name="EmployeeInfoForm" property="recognitions"/></td>
  </tr>
  <tr align="center">
    <td colspan="3">
      <html:submit property="doProcess" value="Update"/>&nbsp;
      <html:button property="doProcess" value="Cancel" onclick="confirmCancel();"/>
    </td>
  </tr>
</table>
</body>
</html:form>
<%@ include file="../includes/footer.jspf" %>         
