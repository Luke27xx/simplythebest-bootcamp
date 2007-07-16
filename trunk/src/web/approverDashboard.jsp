<%@ include file="/includes/header.jspf" %>         


<bean:define id="typeLabel" name="ApproversSearchForm" property="typeLabel" type="java.util.List" />
<html:form action="/approverssearch" method="post">
         
<html:errors/>
<table border="0" width="1024" cols="12">

  <tr>
    <td align="left" colspan="1">&nbsp;</td>
    <th align="left" colspan="2">Status</th>
    <th align="left" colspan="2">Type</th>
    <th align="left" colspan="3">Details</th>
    <td align="left" colspan="4">&nbsp;</td>
  </tr>
  <tr>
    <td align="left" colspan="1">&nbsp;</td>
    <td align="left" colspan="2"><html:text name="ApproversSearchForm" property="status"/></td>
    <td align="left" colspan="2">
      <html:select name="ApproversSearchForm" property="type">
        <html:options collection="typeLabel" property="value" labelProperty="label" />
  	  </html:select>&nbsp;
	</td>
    <td align="left" colspan="3"><html:text name="ApproversSearchForm" property="details"/></td>
    <td align="left" colspan="1">&nbsp;</td>
    <td align="left" colspan="1"><html:submit property="doProcess" value="Search"/></td>
    <td align="left" colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="12">&nbsp;
    </td>
  </tr>
  <logic:greaterThan name="ApproversSearchForm" property="listSize" value="0">
    <tr align="left">
      <th align="left" colspan="1" style="background-color:lightgreen">Select</th>
      <th align="left" colspan="2" style="background-color:lightgreen">Status</th>
      <th align="left" colspan="2" style="background-color:lightgreen">Type</th>
      <th align="left" colspan="3" style="background-color:lightgreen">Details</th>
      <td align="left" colspan="4">&nbsp;</td>
    </tr>
  <logic:iterate name="ApproversSearchForm" indexId="index" id="ApproversSearchListItemForm" 
                 property="searchResult" type="accenture.manila.apps.hr.approver.form.ApproversSearchListItemForm">
    <tr>
      <td align="right" colspan="1">
  	    <html:checkbox name="ApproversSearchListItemForm" indexed="true" property="selected" value="true" />
      </td>
      <td align="left" colspan="2">
        <bean:write name="ApproversSearchListItemForm" property="status"/>
      </td>
      <td align="left" colspan="2">
        <bean:write name="ApproversSearchListItemForm" property="type"/>
      </td>
      <td align="left" colspan="3">
        <logic:equal name="ApproversSearchListItemForm" property="type" value="Skill">
  	      <html:link page="/skillview.do" name="ApproversSearchListItemForm" property="linkDataMap">
            <bean:write name="ApproversSearchListItemForm" property="details"/>
          </html:link>
  	    </logic:equal>
        <logic:equal name="ApproversSearchListItemForm" property="type" value="Project">
  	      <html:link page="/projectview.do" name="ApproversSearchListItemForm" property="linkDataMap">
            <bean:write name="ApproversSearchListItemForm" property="details"/>
          </html:link>
  	    </logic:equal>
        <logic:equal name="ApproversSearchListItemForm" property="type" value="SkillCategory">
  	      <html:link page="/categoryview.do" name="ApproversSearchListItemForm" property="linkDataMap">
            <bean:write name="ApproversSearchListItemForm" property="details"/>
          </html:link>
  	    </logic:equal>
      </td>
      <td align="left" colspan="4">
        <html:hidden name="ApproversSearchListItemForm" indexed="true" property="status" />
        <html:hidden name="ApproversSearchListItemForm" indexed="true" property="type" />
        <html:hidden name="ApproversSearchListItemForm" indexed="true" property="details" />
        <html:hidden name="ApproversSearchListItemForm" indexed="true" property="id" />
        <html:hidden name="ApproversSearchListItemForm" indexed="true" property="tableName" />
      </td>
    </tr>
  </logic:iterate>
  <tr>
    <td colspan="12">
      &nbsp;
    </td>
  </tr>
  <tr>
    <td colspan="12" align="center">
      <html:submit property="doProcess" value="Approve"/>&nbsp;
      <html:submit property="doProcess" value="Reject"/>
    </td>
  </tr>
  </logic:greaterThan>
  <tr>
    <td colspan="12">
        <html:hidden property="tableNameKoTo" value="2 big" />
    </td>
  </tr>
</table>

</html:form>

<%@ include file="/includes/footer.jspf" %>         
