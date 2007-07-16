<%@ include file="/includes/header.jspf" %>
<html:form action="/projectclose" method="POST">
	<table border="0" width="1024">
	<%@ include file="/includes/staffMenu.jspf" %>         
	    <tr>
	      <td style="border-style: none; border-width: medium" colspan="12" align="center" bgcolor="#000080">
	      <b><font color="#FFFFFF">Project Information</font></b></td>
	    </tr>
	    <tr>
			<td colspan="5">&nbsp;</td>	  
	      <td style="border-style: none; border-width: medium" colspan="1" align="left"><b><BR>
			Project Name</b></td>
	      <td style="border-style: none; border-width: medium" colspan="6" align="left">
	      <BR>
			<bean:write name="ProjectViewForm" property="project"/></td>
	    </tr>
	    <tr>
			<td colspan="5">&nbsp;</td>	  
	      <td style="border-style: none; border-width: medium" colspan="1" align="left"><b>Start Date</b></td>
	      <td style="border-style: none; border-width: medium" colspan="6" align="left">
			<bean:write name="ProjectViewForm" property="startDate"/></td>
	    </tr>
	    <tr>
			<td colspan="5">&nbsp;</td>	  
	      <td style="border-style: none; border-width: medium" colspan="1" align="left"><b>End Date</b></td>
	      <td style="border-style: none; border-width: medium" colspan="6" align="left">
			<bean:write name="ProjectViewForm" property="endDate"/></td>
	    </tr>
	    <tr>
			<td colspan="5">&nbsp;</td>	  
	      <td style="border-style: none; border-width: medium" colspan="1" align="left"><b>Client</b></td>
	      <td style="border-style: none; border-width: medium" colspan="6" align="left">
			<bean:write name="ProjectViewForm" property="client"/></td>
	    </tr>
	    <tr>
			<td colspan="5">&nbsp;</td>	  
	      <td style="border-style: none; border-width: medium" colspan="1" align="left"><b>Description</b></td>
	      <td style="border-style: none; border-width: medium" colspan="6" align="left">
			<bean:write name="ProjectViewForm" property="description"/></td>
	    </tr>
	  <tr><td colspan="12" align="center">	
	<BR>
    <html:submit value="Close"/>
</html:form>
	</td></tr>
	</table>
<%@ include file="/includes/footer.jspf" %>         
