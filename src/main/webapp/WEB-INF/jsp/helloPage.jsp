<%@page contentType="text/html;charset=utf-8"%>
<%@include file="taglibs.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<tags:head title="Server Name" />
<body id="server-name">
  <h1>Hello from <span id="serverName">${pageContext.request.serverName}</span></h1>
  <p>
    <a href="<c:url value="/"/>" class="home-link">Home</a>
  </p>
</body>
</html>