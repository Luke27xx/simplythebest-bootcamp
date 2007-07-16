<%@ include file="../includes/header.jspf" %>         
<html:form action="/projectupdate" focus="project" method="POST">
	<bean:define id="month" name="ProjectForm" property="month" type="java.util.List" />
<title>Update Project</title>
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
              <!-- fwtable fwsrc="bar-4.png" fwbase="bar-4.gif" fwstyle="Dreamweaver" fwdocid = "742308039" fwnested="0" -->
              <tr> 
                <td><img src="images/spacer.gif" width="8" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="147" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="16" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="148" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="17" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="147" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="16" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="149" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="8" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="1" height="1" border="0" name="undefined_2"></td>
              </tr>
              <tr> 
                <td><img name="bar4_r1_c1" src="images/bar-4_r1_c1.gif" width="8" height="28" border="0"></td>
                <td><a href="navigate.do?target=employee" onMouseOut="MM_swapImgRestore()"  onMouseOver="MM_swapImage('bar4_r1_c2','','images/bar-4_r1_c2_f2.gif',1);" ><img name="bar4_r1_c2" src="images/bar-4_r1_c2.gif" width="147" height="28" border="0"></a></td>
                <td><img name="bar4_r1_c3" src="images/bar-4_r1_c3.gif" width="16" height="28" border="0"></td>
                <td><a href="navigate.do?target=category" onMouseOut="MM_swapImgRestore()"  onMouseOver="MM_swapImage('bar4_r1_c4','','images/bar-4_r1_c4_f2.gif',1);" ><img name="bar4_r1_c4" src="images/bar-4_r1_c4.gif" width="148" height="28" border="0"></a></td>
                <td><img name="bar4_r1_c5" src="images/bar-4_r1_c5.gif" width="17" height="28" border="0"></td>
                <td><a href="navigate.do?target=skills" onMouseOut="MM_swapImgRestore()"  onMouseOver="MM_swapImage('bar4_r1_c6','','images/bar-4_r1_c6_f2.gif',1);" ><img name="bar4_r1_c6" src="images/bar-4_r1_c6.gif" width="147" height="28" border="0"></a></td>
                <td><img name="bar4_r1_c7" src="images/bar-4_r1_c7.gif" width="16" height="28" border="0"></td>
                <td><a href="navigate.do?target=projects" onMouseOut="MM_swapImgRestore()"  onMouseOver="MM_swapImage('bar4_r1_c8','','images/bar-4_r1_c8_f2.gif',1);" ><img name="bar4_r1_c8" src="images/bar-4_r1_c8.gif" width="149" height="28" border="0"></a></td>
                <td><img name="bar4_r1_c9" src="images/bar-4_r1_c9.gif" width="8" height="28" border="0"></td>
                <td><img src="images/spacer.gif" width="1" height="28" border="0" name="undefined_2"></td>
              </tr>
            </table>
           </td>
        </tr>
      </table>
    </td>
  </tr>
	  <tr>
	    <td style="background-color:darkorange" colspan="3" align="center">
	    <font size="4" color="#FFFFFF"><b>Update Project</b></font></td>
	  </tr>

	  <tr>
	    <td align="left" colspan="2">
	        <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse; border-width: 0" bordercolor="#111111" width="100%">
			      <tr><br><td style="border-style: none; border-width: medium" style="color:red" width="100%" align="center" colspan="4">
			       	<html:errors property="BCerror"/>
			       	<html:errors property="ASerror"/>			       	
			      </td>
			      </tr>
			      <tr>
		            <td width="65%" style="border-style: none; border-width: medium" colspan="3"></td>
		            <td width="35%" style="color:red" style="border-style: none; border-width: medium">
                    <html:errors property="project"/></td>
				  </tr>
			  	  <tr>
		            <td width="17%" style="border-style: none; border-width: medium"></td>
		            <td width="17%" style="border-style: none; border-width: medium"></td>
		            <td width="16%" style="border-style: none; border-width: medium" valign="bottom"><b>Project</b></td>
		            <td width="69%" style="border-style: none; border-width: medium" valign="bottom">
			            <html:text property="project" name="ProjectForm" size="16" maxlength="50"/>
			            <html:hidden property="projectId" name="ProjectForm"/></td>
			  	  </tr>
			      <tr>
		            <td width="65%" style="border-style: none; border-width: medium" colspan="3"></td>
		            <td width="35%" style="color:red" style="border-style: none; border-width: medium">
                    <html:errors property="startDate"/></td>
				  </tr>
			      <tr>
		            <td width="65%" style="border-style: none; border-width: medium" colspan="3"></td>
		            <td width="35%" style="color:red" style="border-style: none; border-width: medium">
                    <html:errors property="startMonth"/><html:errors property="startDay"/>
                    <html:errors property="startYear"/></td>
				  </tr>
				<tr>
		            <td width="17%" style="border-style: none; border-width: medium"></td>
		            <td width="17%" style="border-style: none; border-width: medium"></td>
		            <td width="16%" style="border-style: none; border-width: medium" valign="bottom"><b>Start Date</b></td>
		            <td width="69%" style="border-style: none; border-width: medium" valign="bottom">
		            <html:select name="ProjectForm" property="startMonth">
			      	<html:options collection="month" property="value" labelProperty="label" /></html:select> 
				      <html:text property="startDay" name="ProjectForm" size="2" maxlength="2"/>
				      <html:text property="startYear" name="ProjectForm" size="4" maxlength="4"/> (ex. 1999) 
	      			</td>
	          	</tr>
			      <tr>
		            <td width="65%" style="border-style: none; border-width: medium" colspan="3"></td>
		            <td width="35%" style="color:red" style="border-style: none; border-width: medium">
                    <html:errors property="endDate"/></td>
				  </tr>
			      <tr>
		            <td width="65%" style="border-style: none; border-width: medium" colspan="3"></td>
		            <td width="35%" style="color:red" style="border-style: none; border-width: medium">
                    <html:errors property="endMonth"/><html:errors property="endDay"/>
                    <html:errors property="endYear"/></td>
				  </tr>
				<tr>
		            <td width="17%" style="border-style: none; border-width: medium"></td>
		            <td width="17%" style="border-style: none; border-width: medium"></td>
		            <td width="16%" style="border-style: none; border-width: medium" valign="bottom"><b>End Date</b></td>
		            <td width="69%" style="border-style: none; border-width: medium" valign="bottom">
		            <html:select name="ProjectForm" property="endMonth">
			      	<html:options collection="month" property="value" labelProperty="label" /></html:select> 
				      <html:text property="endDay" name="ProjectForm" size="2" maxlength="2"/>
				      <html:text property="endYear" name="ProjectForm" size="4" maxlength="4"/> (ex. 1999) 
	      			</td>
	          	</tr>
			      <tr>
		            <td width="65%" style="border-style: none; border-width: medium" colspan="3"></td>
		            <td width="35%" style="color:red" style="border-style: none; border-width: medium">
                    <html:errors property="client"/></td>
				  </tr>
	          	<tr>
		            <td width="17%" style="border-style: none; border-width: medium"></td>
		            <td width="17%" style="border-style: none; border-width: medium"></td>
		            <td width="16%" style="border-style: none; border-width: medium"><b>Client</b></td>
		            <td width="69%" style="border-style: none; border-width: medium">
		            <html:text property="client" name="ProjectForm" size="47" maxlength="50"/></td>
	          	</tr>
			      <tr>
		            <td width="65%" style="border-style: none; border-width: medium" colspan="3"></td>
		            <td width="35%" style="color:red" style="border-style: none; border-width: medium">
                    <html:errors property="description"/></td>
				  </tr>
	          	<tr>
		            <td width="17%" style="border-style: none; border-width: medium"></td>
		            <td width="17%" style="border-style: none; border-width: medium"></td>
		            <td width="16%" style="border-style: none; border-width: medium"><b>Description</b></td>
		            <td width="69%" style="border-style: none; border-width: medium">
		            <html:textarea property="description" name="ProjectForm" rows="2" cols="26"/></td>
	          	</tr>
			</table>
	  	</td>	
	  </tr>
 	  <tr>
 	  	<td width="50%" align="right"><br><html:submit value="Update"/></td>
		<td width="50%" align="left"><br><input type="button" value="Cancel" name="Cancel" onClick="javascript:history.back()">
	  	</td>
      </tr>
</table>
</body>
</html:form>
<%@ include file="../includes/footer.jspf" %>         
