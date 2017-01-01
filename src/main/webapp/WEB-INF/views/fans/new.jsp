<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>New</title>
    </head>
    <body>
        <form action="<c:url value="/fans"/>" method="post">
            <input name="name" type="text" placeholder="Name"><br/>
            <input name="password" type="text" placeholder="Password"><br/>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
