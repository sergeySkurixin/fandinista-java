<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Edit</title>
    </head>
    <body>
        <form action="<c:url value="/places"/>" method="post">
            <input name="name" type="text" placeholder="Name" value="${place.name}"><br/>
            <input name="password" type="text" placeholder="Password"><br/>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
