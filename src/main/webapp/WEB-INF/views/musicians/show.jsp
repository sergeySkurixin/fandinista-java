<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Musician</title>
    </head>
    <body>
        <h1>${musician.name}</h1>
        <a href="<c:url value="/musicians/${musician.id}/edit"/>">Edit musician</a>
    </body>
</html>
