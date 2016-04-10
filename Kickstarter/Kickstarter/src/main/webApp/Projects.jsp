<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Projects</title>
    </head>
    <body>
        
        <h2>${category.name}</h2>
        <div>
            <ul>
        <c:forEach var="project" items="${projects}">
            <li><a href="project?projectId=${project.id}">${project.name}</a></li>
        </c:forEach>
    </ul>
        </div>
    </body>
</html>