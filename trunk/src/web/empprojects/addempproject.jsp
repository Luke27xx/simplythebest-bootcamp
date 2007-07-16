<%@ include file="/includes/header.jspf" %>
<html:form action="/saveempproject" focus="project" method="POST">
<bean:define id="month" name="EmpProjectForm" property="month" type="java.util.List" />
<bean:define id="projects" name="EmpProjectForm" property="projects" type="java.util.List" />
	<table border="0" width="1024">
	<%@ include file="/includes/staffMenu.jspf" %>         
	  <br>
	    <tr>
	      <td style="border-style: none; border-width: medium" colspan="12" align="center" bgcolor="#000080">
	      <b><font color="#FFFFFF">Add Project</font></b></td>
	    </tr>
		<tr><br><td colspan="4"></td><td colspan="8"><br><font color="red"><html:errors property="projectId"/></font>
		</td></tr>
	    <tr>
	      <td colspan="3">&nbsp;</td>	  
	      <td style="border-style: none; border-width: medium" colspan="1"><b>Project Name</b></td>
	      <td style="border-style: none; border-width: medium" colspan="8" align="left">
	        <html:select name="EmpProjectForm" property="projectId">
	      	<html:options collection="projects" property="value" labelProperty="label" />
	        </html:select> 
		  </td>
	    </tr>
		<tr><td colspan="4"></td><td colspan="8">
			<font color="red"><html:errors property="startMonth"/></font>
			<font color="red"><html:errors property="startDay"/></font>
			<font color="red"><html:errors property="startYear"/></font>
		</td></tr>
	    <tr>
          <td colspan="3">&nbsp;</td>	  
	      <td style="border-style: none; border-width: medium" colspan="1"><b>Roll-in Date</b></td>
	      <td style="border-style: none; border-width: medium" colspan="8" align="left">
	      <html:select name="EmpProjectForm" property="startMonth">
	      	<html:options collection="month" property="value" labelProperty="label" />
	      </html:select> 
	      <html:text property="startDay" name="EmpProjectForm" size="2" maxlength="2"/>
	      <html:text property="startYear" name="EmpProjectForm" size="4" maxlength="4"/> (ex. 1999) </td>
	    </tr>
		<tr><td colspan="4"></td><td colspan="8">
			<font color="red"><html:errors property="endMonth"/></font>
			<font color="red"><html:errors property="endDay"/></font>
			<font color="red"><html:errors property="endYear"/></font>
		</td></tr>
	    <tr>
		  <td colspan="3">&nbsp;</td>	  
	      <td style="border-style: none; border-width: medium" colspan="1"><b>Roll-off Date</b></td>
	      <td style="border-style: none; border-width: medium" colspan="8" align="left">
	      <html:select name="EmpProjectForm" property="endMonth">
	      	<html:options collection="month" property="value" labelProperty="label" />
	      </html:select> 
	      <html:text property="endDay" name="EmpProjectForm" size="2" maxlength="2"/>
	      <html:text property="endYear" name="EmpProjectForm" size="4" maxlength="4"/> (ex. 1999) 
		  </td>
	    </tr>
			<tr><td colspan="4"></td><td colspan="8"><font color="red"><html:errors property="role"/></font>
		</td></tr>
	    <tr>
 	      <td colspan="3">&nbsp;</td>	  
	      <td style="border-style: none; border-width: medium" colspan="1"><b>Role</b></td>
	      <td style="border-style: none; border-width: medium" colspan="8" align="left">
		      <html:text property="role" name="EmpProjectForm" size="47" maxlength="18"/></td>
	    </tr>
			<tr><td colspan="4"></td><td colspan="8"><font color="red"><html:errors property="description"/></font>
		</td></tr>
	    <tr>
	      <td colspan="3">&nbsp;</td>	  
	      <td style="border-style: none; border-width: medium" colspan="1"><b>Description</b></td>
	      <td style="border-style: none; border-width: medium" colspan="8" align="left">
	         <html:textarea property="description" name="EmpProjectForm" rows="4" cols="40"/></td>
	    </tr>
 	  <tr>
 	  	<td colspan="6" align="right"><html:submit value="Save"/></td></html:form>
		<td colspan="6" align="left"><form action="./empprojects.do?" method="POST"><br><html:submit value="Cancel" /></form>
	  	</td>
      </tr>
	</table>
<%@ include file="/includes/footer.jspf" %>         
