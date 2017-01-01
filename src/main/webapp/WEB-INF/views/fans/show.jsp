<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Fan</title>
    </head>
    <body>
        <h1>${fan.name}</h1>
        <a href="<c:url value="/fans/${fan.id}/edit"/>">Edit fan</a>
    </body>
</html>
