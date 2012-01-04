<%@page contentType="text/html;charset=utf-8"%>
<%@include file="taglibs.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<tags:head title="Scala/Spring/Hibernate/Maven Webapp">
  <meta name="description" content="A webapp built with Scala, Spring, Hibernate and Maven that can get your own web project kickstarted.">
  <meta name="keywords" content="scala, spring, hibernate, maven">
</tags:head>
<body>
  <p>
    <a href="<c:url value="/hello.html"/>">Server Name</a>
  </p>
  <p>
    <a href="<c:url value="/static.htm"/>">Static File</a>
  </p>
  <h2>Customers</h2>
  <ul>
    <c:forEach items="${customers}" var="customer">
      <li><a href="<c:url value="/customers/${customer.id}.html"/>">#<c:out value="${customer.id}" />: <c:out value="${customer.name}" />
      </a>
      </li>
    </c:forEach>
  </ul>
  <p>
    <a href="<c:url value="/customers/new.html"/>">Add a Customer</a>
  </p>
</body>
</html>
