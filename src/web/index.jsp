<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld"    prefix="logic"    %>
<logic:redirect forward="login"/>

<%--

Redirect default requests to Login global ActionForward.
By using a redirect, the user-agent will change address to match the path of our Login ActionForward. 

--%>