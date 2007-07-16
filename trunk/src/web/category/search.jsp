<%@ include file="../includes/header.jspf" %>         


<html:form action="/categorysearch" focus="categoryCriteria" method="POST">
<bean:define id="recordCount" name="SearchCategoryForm" property="recordCount" type="java.lang.String" />

<title>Category Search</title>
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
              <!-- fwtable fwsrc="bar-2.png" fwbase="bar-2.gif" fwstyle="Dreamweaver" fwdocid = "742308039" fwnested="0" -->
              <tr> 
                <td><img src="images/spacer.gif" width="8" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="147" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="16" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="149" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="16" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="149" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="15" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="148" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="8" height="1" border="0" name="undefined_2"></td>
                <td><img src="images/spacer.gif" width="1" height="1" border="0" name="undefined_2"></td>
              </tr>
              <tr> 
                <td><img name="bar2_r1_c1" src="images/bar-2_r1_c1.gif" width="8" height="28" border="0"></td>
                <td><a href="navigate.do?target=employee" onMouseOut="MM_swapImgRestore()"  onMouseOver="MM_swapImage('bar2_r1_c2','','images/bar-2_r1_c2_f2.gif',1);" ><img name="bar2_r1_c2" src="images/bar-2_r1_c2.gif" width="147" height="28" border="0"></a></td>
                <td><img name="bar2_r1_c3" src="images/bar-2_r1_c3.gif" width="16" height="28" border="0"></td>
                <td><a href="navigate.do?target=category" onMouseOut="MM_swapImgRestore()"  onMouseOver="MM_swapImage('bar2_r1_c4','','images/bar-2_r1_c4_f2.gif',1);" ><img name="bar2_r1_c4" src="images/bar-2_r1_c4.gif" width="149" height="28" border="0"></a></td>
                <td><img name="bar2_r1_c5" src="images/bar-2_r1_c5.gif" width="16" height="28" border="0"></td>
                <td><a href="navigate.do?target=skills" onMouseOut="MM_swapImgRestore()"  onMouseOver="MM_swapImage('bar2_r1_c6','','images/bar-2_r1_c6_f2.gif',1);" ><img name="bar2_r1_c6" src="images/bar-2_r1_c6.gif" width="149" height="28" border="0"></a></td>
                <td><img name="bar2_r1_c7" src="images/bar-2_r1_c7.gif" width="15" height="28" border="0"></td>
                <td><a href="navigate.do?target=projects" onMouseOut="MM_swapImgRestore()"  onMouseOver="MM_swapImage('bar2_r1_c8','','images/bar-2_r1_c8_f2.gif',1);" ><img name="bar2_r1_c8" src="images/bar-2_r1_c8.gif" width="148" height="28" border="0"></a></td>
                <td><img name="bar2_r1_c9" src="images/bar-2_r1_c9.gif" width="8" height="28" border="0"></td>
                <td><img src="images/spacer.gif" width="1" height="28" border="0" name="undefined_2"></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr> 
    <td valign="top" rowspan="100"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0"  bgcolor="#FF9900">
        <tr> 
          <td width="3" height="5"></td>
          <td width="133"></td>
        </tr>
        <tr> 
          <td colspan="2" height="19" valign="top"><font face="Arial, Helvetica, sans-serif" size="2"><b>Category 
            Search</b></font></td>
        </tr>
        <tr> 
          <td height="5"></td>
          <td></td>
        </tr>
        <tr> 
          <td height="203"></td>
          <td valign="top"> 
              <p>
                <font color="red"><html:errors property="BCerror"/></font>
                <font color="red"><html:errors property="ASerror"/></font>                
                <font color="red"><html:errors property="invalidAll"/></font>
                <font color="red"><html:errors property="category"/></font>
              </p>
              <p>
                <html:text name="SearchCategoryForm" property="categoryCriteria" size="15" maxlength="50"/><br>
              </p>
              <p>
                <html:submit value="Search"/>
              </p>
              <p>
				<html:link page="/categoryadd.do">Add Category</html:link>
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
		<tr align="left" >
		    <td width="5%"><br>&nbsp;</td>
		    <td colspan="2"><logic:equal name="SearchCategoryForm" property="searchMode" value="true">
			    <bean:message name="SearchCategoryForm" property="messageKey" arg0="<%=recordCount%>"/>
			  </logic:equal>
		     </td>
		</tr>
		<logic:greaterThan name="SearchCategoryForm" property="listSize" value="0">
			<tr align="left">
				<td width="5%">&nbsp;</th>
				<th width="30%" style="background-color:darkorange"><font face="Arial, Helvetica, sans-serif" size="3" color="#FFFFFF">Category</font></th>
			    <th width="30%" style="background-color:darkorange">&nbsp;</th>
			</tr>
			<logic:iterate name="SearchCategoryForm" indexId="index" id="SearchListItemForm" property="categories" type="com.jds.apps.hr.skill.category.form.SearchListItemForm">
				<tr align="left">
					<td width="5%"></td>
					<td align="left" width="30%">
					<html:link page="/categoryview.do?viewtype=view" name="SearchListItemForm" property="categoryMap"><bean:write name="SearchListItemForm" property="category"/></html:link>
				    </td>
				    <td align="left" width="30%">
				    <html:link page="/categoryview.do?viewtype=editCategory" name="SearchListItemForm" property="categoryMap">edit</html:link>
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
