<%@ include file="/includes/headerLogin.jspf" %>

<html:form action="/login" focus="username" method="POST">
         
<table border="0" width="100%">

  <tr>
    <th align="right">Username
     <font color="red"><br><html:errors property="username"/></font>
    </th>
    <td align="left">
      <html:text property="username" size="16" maxlength="18"/>
    </td>
  </tr>

  <tr>
    <th align="right">password</th>
    <td align="left">
      <html:password property="password" size="16" maxlength="18" redisplay="false"/>
    </td>
  </tr>

  <tr>
    <td align="right">
      <html:submit value="Submit"/>
    </td>
    <td align="left">
      <html:reset/>
    </td>
  </tr>

</table>

</html:form>

<%@ include file="/includes/footer.jspf" %>
