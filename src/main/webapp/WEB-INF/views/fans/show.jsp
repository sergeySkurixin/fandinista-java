<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fan</title>
</head>
<body>
<h1>${fan.name}</h1><br>
<h2>${fan.email}</h2>
<%--<img src="img/drunk_bear.jpg"/>        --%>

<c:choose>
    <c:when test="${not empty fan.avatar}">
        <img src="/img/${fan.avatar}" alt="${fan.name}">
    </c:when>
    <c:otherwise>
        <img src="/img/deactivated_200.gif" alt="${fan.name}">
    </c:otherwise>
</c:choose>
<form action="/fans/${fan.id}/change-img" method="post" enctype="multipart/form-data">
    <input type="file" name="avatar" aria-describedby="fileHelp"><br/>
    <button type="submit">Send</button>
</form>
<br>
<%--<a href="<c:url value="/fans/${fan.id}/edit"/>">Edit fan</a>--%>
</body>
</html>

