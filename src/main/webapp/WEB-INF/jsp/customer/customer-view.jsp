<%@page contentType="text/html;charset=utf-8"%>
<%@include file="../taglibs.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<tags:head title="Customer \#${customerId}: ${customerData.name}" />
<body>
  <h1>
    Customer #<c:out value="${customerId}" />: <c:out value="${customerData.name}" />
  </h1>
  <p>Might I suggest enhancing the system to support more than just a customer's name?</p>
  <p>
    <a href="<c:url value="/customers/${customerId}.html?edit"/>">Edit the customer</a>
  </p>
  <p>
    <form id="deleteCustomerForm" style="height:0;" action="<c:url value="/customers/${customerId}.html"/>" method="POST">
      <input type="hidden" name="_method" value="delete"/>
    </form>
    <a href="#" onclick="document.getElementById('deleteCustomerForm').submit(); return false;">Delete the customer</a>
  </p>
  <p>
    <a href="<c:url value="/"/>">Home</a>
  </p>
</body>
</html>
