<html>

<%
java.lang.Object status_code  = request.getAttribute("javax.servlet.error.status_code");
java.lang.Object message      = request.getAttribute("javax.servlet.error.message");
java.lang.Object error_type   = request.getAttribute("javax.servlet.error.exception_type");
java.lang.Object request_uri  = request.getAttribute("javax.servlet.error.request_uri");
java.lang.Exception exception = (java.lang.Exception) request.getAttribute("javax.servlet.error.exception");
%>

<?xml version="1.0" encoding="Shift_JIS"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN" lang="EN">
<head>
  <meta http-equiv="Pragma"              content="no-cache"                     />
  <meta http-equiv="Cache-Control"       content="private"                      />
  <meta http-equiv="Content-Type"        content="text/html; charset=Shift_JIS" />
  <meta http-equiv="Content-Script-Type" content="text/javascript"              />
  <meta http-equiv="Content-Style-Type"  content="text/css"                     />
  <title>HTTP 404 Error: Resource Not Fount</title>
</head>


<%
//out.println("<B>Status code:</B> " + status_code.toString());
//out.println("<BR><B>Message</B>: " + message.toString());
//out.println("<BR><B>Error type</B>: " + error_type.toString());
//out.println("<BR><B>Request URI</B>: " + request_uri.toString());
//out.println("<BR><b>Stack Trace</b>: ");
//if (exception != null) {
//	java.io.PrintWriter a = new java.io.PrintWriter(out);
//	exception.printStackTrace(a);
//}
%>

<body>
<h3>Error 404: Resource Not Found.</h3>
<br><b><%=request_uri.toString()%></b> not found. Please make sure you have entered the correct URL.
<br>
<br>


</body>

</html>
