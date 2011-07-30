<%@page contentType="text/html;charset=utf-8"%>
<%@include file="taglibs.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<tags:head title="New Customer"/>
<body>
    <h1>New Customer</h1>
    <form:form>
        <form:label path="name">Name</form:label>
        <form:input path="name"/>
        <input type="submit" value="Create Customer"/>
    </form:form>
    <p><a href="<c:url value="/"/>">Home</a></p>
</body>
</html>
