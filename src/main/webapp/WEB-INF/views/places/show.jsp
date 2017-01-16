<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Fan</title>
    </head>
    <body>
        <h1>${place.name}</h1>
        <a href="<c:url value="/places/${place.id}/edit"/>">Edit place</a>
        <a href="<c:url value="/places/${place.id}/follow"/>">Follow</a>
    </body>
</html>
