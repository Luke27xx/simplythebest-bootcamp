<%@ include file="../includes/header.jspf" %>         
<form focus="OK" method="POST">
<title>Skill Information</title>
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
              <!-- fwtable fwsrc="bar-3.png" fwbase="bar-3.gif" fwstyle="Dreamweaver" fwdocid = "742308039" fwnested="0" -->
              <tr> 
                <td><img src="images/spacer.gif" width="8" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="147" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="17" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="148" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="15" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="149" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="16" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="148" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="8" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="1" height="1" border="0" name="undefined_2"></td>
              </tr>
              <tr> 
                <td><img name="bar3_r1_c1" src="images/bar-3_r1_c1.gif" width="8" height="28" border="0"></td>
                <td><a href="navigate.do?target=employee" onMouseOut="MM_swapImgRestore()"  onMouseOver="MM_swapImage('bar3_r1_c2','','images/bar-3_r1_c2_f2.gif',1);" ><img name="bar3_r1_c2" src="images/bar-3_r1_c2.gif" width="147" height="28" border="0"></a></td>
                <td><img name="bar3_r1_c3" src="images/bar-3_r1_c3.gif" width="17" height="28" border="0"></td>
                <td><a href="navigate.do?target=category" onMouseOut="MM_swapImgRestore()"  onMouseOver="MM_swapImage('bar3_r1_c4','','images/bar-3_r1_c4_f2.gif',1);" ><img name="bar3_r1_c4" src="images/bar-3_r1_c4.gif" width="148" height="28" border="0"></a></td>
                <td><img name="bar3_r1_c5" src="images/bar-3_r1_c5.gif" width="15" height="28" border="0"></td>
                <td><a href="navigate.do?target=skills" onMouseOut="MM_swapImgRestore()"  onMouseOver="MM_swapImage('bar3_r1_c6','','images/bar-3_r1_c6_f2.gif',1);" ><img name="bar3_r1_c6" src="images/bar-3_r1_c6.gif" width="149" height="28" border="0"></a></td>
                <td><img name="bar3_r1_c7" src="images/bar-3_r1_c7.gif" width="16" height="28" border="0"></td>
                <td><a href="navigate.do?target=projects" onMouseOut="MM_swapImgRestore()"  onMouseOver="MM_swapImage('bar3_r1_c8','','images/bar-3_r1_c8_f2.gif',1);" ><img name="bar3_r1_c8" src="images/bar-3_r1_c8.gif" width="148" height="28" border="0"></a></td>
                <td><img name="bar3_r1_c9" src="images/bar-3_r1_c9.gif" width="8" height="28" border="0"></td>
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
	    <font face="Arial, Helvetica, sans-serif" size="4" color="#FFFFFF"><b>Skill Information</b></font></td>
	  </tr>
	  <tr>
	    <td align="left">
	        <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse; border-width: 0" bordercolor="#111111" width="100%">
			<tr>
	            <td width="17%" style="border-style: none; border-width: medium"><br>&nbsp;</td>
	            <td width="17%" style="border-style: none; border-width: medium" colspan="2"></td>
	            <td width="16%" style="border-style: none; border-width: medium" valign="bottom"><b>Category</b></td>
	            <td width="50%" style="border-style: none; border-width: medium" valign="bottom"><bean:write name="SkillForm" property="category"/></td>
          	</tr>
			<tr>
	            <td width="17%" style="border-style: none; border-width: medium"></td>
	            <td width="17%" style="border-style: none; border-width: medium" colspan="2"></td>
	            <td width="16%" style="border-style: none; border-width: medium" valign="bottom"><b>Skill</b></td>
	            <td width="50%" style="border-style: none; border-width: medium" valign="bottom"><bean:write name="SkillForm" property="skill"/></td>
          	</tr>
          	<tr>
	            <td width="17%" style="border-style: none; border-width: medium"></td>
	            <td width="17%" style="border-style: none; border-width: medium" colspan="2"></td>
	            <td width="16%" style="border-style: none; border-width: medium"><b>Description</b></td>
	            <td width="50%" style="border-style: none; border-width: medium"><bean:write name="SkillForm" property="description"/></td>
          	</tr>
			</table>
	  	</td>	
	  </tr>
	  </tr>
	  	<tr><td colspan="3" align="center"><br><input type="button" value="OK" name="B1" onClick="javascript:history.back()"></td>
	  </tr>	  
</table>
</body>
</form>
<%@ include file="../includes/footer.jspf" %>         
