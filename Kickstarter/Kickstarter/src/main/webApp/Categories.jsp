<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Categories</title>
    </head>
    <body>
        
        <div>
            <ul>
        <c:forEach var="category" items="${categories}">
            <li><a href="projects?categoryId=${category.id}">${category.name}</a></li>
        </c:forEach>
    </ul>
        </div>
    </body>
</html>