<%@tag body-content="tagdependent" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="title" required="true" rtexprvalue="true" type="java.lang.String" %>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" >
    <link rel="stylesheet" href="<c:url value="/style/style.css"/>">
    <title>${title}</title>
    <jsp:doBody/>
</head>
