<%@ include file="../includes/header.jspf" %>         

<bean:define id="month" name="EmployeeInfoForm" property="month" type="java.util.List" />
<html:form action="/employeeupdate" focus="OK" method="POST">

<table border="0" width="1024" cols="15">
<%@ include file="/includes/hrMenu.jspf" %>         
  <font color="red"><html:errors /></font>
  <tr align="left">
    <th colspan="12" align="left" style="background-color:lightblue">Employee Number: <bean:write name="EmployeeInfoForm" property="empNo"/>
    </th>
  </tr>
  <tr align="center">
    <td>&nbsp;</td>
  </tr>
  <tr align="center">
    <th colspan="12" style="background-color:lightblue">Personal Information</th>
  </tr>
  <tr align="left">
    <td colspan="12">
  	   <tr>
  	     <th colspan="1" align="left">Last Name
  	     </th>
  	     <td colspan="3" align="left"><html:text name="EmployeeInfoForm" property="lastName"/>
  	     </td>
  	     <th colspan="1" align="left">First Name
  	     </th>
  	     <td colspan="3" align="left"><html:text name="EmployeeInfoForm" property="firstName"/>
  	     </td>
  	     <th colspan="1" align="left">Middle Name
  	     </th>
  	     <td colspan="3" align="left"><html:text name="EmployeeInfoForm" property="middleName"/>
  	     </td>
  	   </tr>
       <tr>
  	     <th colspan="1" align="left">Birth Date
  	     </th>
  	     <td colspan="3" align="left">
  	       <html:select name="EmployeeInfoForm" property="birthMonth">
             <html:options collection="month" property="value" labelProperty="label" />
  	       </html:select>&nbsp;
  	       <html:text name="EmployeeInfoForm" maxlength="2" size="3" property="birthDate"/>&nbsp;
  	       <html:text name="EmployeeInfoForm" maxlength="4" size="5" property="birthYear"/>
  	     </td>
  	     <th colspan="1" align="left">Age
  	     </th>
  	     <td colspan="3" align="left"><html:text name="EmployeeInfoForm" property="age"/>
  	     </td>
  	     <th colspan="1" align="left">Gender
  	     </th>
  	     <td colspan="3" align="left"><html:text name="EmployeeInfoForm" property="gender"/>
  	     </td>
  	   </tr>
  	</td>
  </tr>
  <tr align="center">
    <td>&nbsp;</td>
  </tr>
  <tr align="center">
    <th colspan="12" style="background-color:lightblue">Civil Information</th>
  </tr>
  <tr align="left">
    <td colspan="12">
  	   <tr>
  	     <th colspan="2" align="left">Status
  	     </th>
  	     <td colspan="4" align="left"><html:text name="EmployeeInfoForm" property="civilStatus"/>
  	     </td>
  	     <th colspan="2" align="left">Citizenship
  	     </th>
  	     <td colspan="4" align="left"><html:text name="EmployeeInfoForm" property="citizenship"/>
  	     </td>
  	   </tr>
  	   <tr>
  	     <th colspan="2" align="left">SSS Number
  	     </th>
  	     <td colspan="4" align="left"><html:text name="EmployeeInfoForm" property="sssNo"/>
  	     </td>
  	     <th colspan="2" align="left">TIN Number
  	     </th>
  	     <td colspan="4" align="left"><html:text name="EmployeeInfoForm" property="tinNo"/>
  	     </td>
  	   </tr>
  	</td>
  </tr>
  <tr align="center">
    <td>&nbsp;</td>
  </tr>
  <tr align="center">
    <th colspan="6" style="background-color:lightblue">Home Address</th>
    <th colspan="6" style="background-color:lightblue">Contact Information</th>
  </tr>
  <tr align="left">
    <td colspan="6">
        <tr>
          <th colspan="2" align="left">Street
          </th>
          <td  colspan="4" align="left"><html:text name="EmployeeInfoForm" property="street1"/>
          </td>
          <th colspan="2" align="left">Mobile Phone
          </th>
          <td colspan="4" align="left"><html:text name="EmployeeInfoForm" property="mobilePhoneNo"/>
          </td>
        </tr>
        <tr>
          <th colspan="2" align="left">&nbsp;
          </th>
          <td  colspan="4" align="left"><html:text name="EmployeeInfoForm" property="street2"/>
          </td>
          <th colspan="2" align="left">Home Phone
          </th>
          <td colspan="4" align="left"><html:text name="EmployeeInfoForm" property="homePhoneNo"/>
          </td>
        </tr>
        <tr>
          <th colspan="2" align="left">City
          </th>
          <td  colspan="4" align="left"><html:text name="EmployeeInfoForm" property="city"/>
          </td>
          <td colspan="6" align="left">&nbsp;
          </td>
        </tr>
        <tr>
          <th colspan="2" align="left">State
          </th>
          <td  colspan="4" align="left"><html:text name="EmployeeInfoForm" property="state"/>
          </td>
          <td colspan="6" align="left">&nbsp;
          </td>
        </tr>
        <tr>
          <th colspan="2" align="left">Country
          </th>
          <td  colspan="4" align="left"><html:text name="EmployeeInfoForm" property="country"/>
          </td>
          <td colspan="6" align="left">&nbsp;
          </td>
        </tr>
        <tr>
          <th colspan="2" align="left">Zip Code
          </th>
          <td  colspan="4" align="left"><html:text name="EmployeeInfoForm" property="zipcode"/>
          </td>
          <td colspan="6" align="left">&nbsp;
          </td>
        </tr>
    </td>
  </tr>
  <tr align="center">
    <td>&nbsp;</td>
  </tr>
  <tr align="center">
    <td>&nbsp;</td>
  </tr>
  <tr align="left">
    <th colspan="12" align="center" style="background-color:lightblue">Accenture Information</th>
  </tr>
  <tr align="left">
    <td colspan="6" align="left">
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
    <td colspan="6" align="left">
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
    <td>&nbsp;</td>
  </tr>
  <tr>
    <th colspan="12" align="left" style="background-color:lightblue">Education Background</th>
  </tr>
  <tr>
    <td width="80%" ><html:textarea rows="4" name="EmployeeInfoForm" property="educationalAttainment"/></td>
  </tr>
  <tr align="center">
    <td>&nbsp;</td>
  </tr>
  <tr>
    <th colspan="12" align="left" style="background-color:lightblue">Certification/Award</th>
  </tr>
  <tr>
    <td width="80%" ><html:textarea rows="4" name="EmployeeInfoForm" property="recognitions"/></td>
  </tr>
  <tr align="center">
    <td colspan="12">
      <html:submit property="doProcess" value="Update"/>
    </td>
  </tr>
</table>
</html:form>

<%@ include file="../includes/footer.jspf" %>         
