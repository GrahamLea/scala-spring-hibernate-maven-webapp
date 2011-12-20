<%@page contentType="text/html;charset=utf-8"%>
<%@include file="taglibs.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<tags:head title="Customer \#${customer.id}: ${customer.name}" />
<body>
  <h1>
    Customer #<c:out value="${customer.id}" />: <c:out value="${customer.name}" />
  </h1>
  <p>Might I suggest enhancing the system to support more than just a customer's name?</p>
  <p>
    <a href="<c:url value="/customers/${customer.id}.html?edit"/>">Edit the customer</a>
  </p>
  <p>
    <a href="<c:url value="/customers/${customer.id}.html"/>">Delete the customer</a>
  </p>
  <p>
    <a href="<c:url value="/"/>">Home</a>
  </p>
</body>
</html>
