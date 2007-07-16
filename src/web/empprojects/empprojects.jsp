<%@ include file="/includes/header.jspf" %>
<html:form action="/addempproject" focus="project" method="POST">
	<table border="0" width="1024">
	<%@ include file="/includes/staffMenu.jspf" %>         
  <br>
	<logic:greaterThan name="EmpProjectListContainForm" property="listSize" value="0">
	  <tr>
	    <td colspan="1">&nbsp;</td>
	    <td colspan="1"><b><font color="#000080">Project Name</font></b></td>
	    <td colspan="1"><b><font color="#000080">Roll-in Date</font></b></td>
	    <td colspan="1"><b><font color="#000080">Roll-off Date</font></b></td>
	    <td colspan="1"><b><font color="#000080">Role</font></b></td>
	    <td colspan="1"><b><font color="#000080">Task Description</font></b></td>
	    <td colspan="1"><b><font color="#000080">&nbsp;</font></b></td>
	  </tr>
  	  <logic:iterate name="EmpProjectListContainForm" indexId="index" id="EmpProjectListForm" property="projects" type="accenture.manila.apps.employee.project.form.EmpProjectListForm">
		  <tr>
		    <td colspan="1" align="right">
		    <html:checkbox name="EmpProjectListForm" indexed="true" property="selected" value="true" /></td>
		    <td align="left" colspan="1">
		      <html:link page="/viewempproject.do" name="EmpProjectListForm" property="projectMap"><bean:write name="EmpProjectListForm" property="project"/></html:link>
	          <html:hidden name="EmpProjectListForm" indexed="true" property="projectMap" />
		    </td>
		    <td align="left" colspan="2">
		      <bean:write name="EmpProjectListForm" property="startDate"/>
		    </td>
		    <td align="left" colspan="2">
		      <bean:write name="EmpProjectListForm" property="endDate"/>
		    </td>
		    <td align="left" colspan="2">
		      <bean:write name="EmpProjectListForm" property="role"/>
		    </td>
		    <td align="left" colspan="2">
		      <bean:write name="EmpProjectListForm" property="description"/>
		    </td>
		    <td colspan="1">
		      <html:link page="/editempproject.do" name="EmpProjectListForm" property="projectMap">edit</html:link>
		    </td>
		  </tr>
  		</logic:iterate>
	</logic:greaterThan>
	  <tr>
	    <td colspan="12"><br>
		<html:submit property="doProcess" value="Add"/>
		<html:submit property="doProcess" value="Delete"/></td>
	  </tr>
	</table>
</html:form>
<%@ include file="/includes/footer.jspf" %>         
