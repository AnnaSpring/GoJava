<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Projects</title>
    </head>
    <body>
        
        <h2>${project.name}</h2>
        <div>
	        <p>Description: ${project.description}</p>
	        <p>Required budget: ${project.requiredBudget}</p>
	        <p>Gathered budget: ${project.gatheredBudget}</p>
	        <p>Days left: ${project.days}</p>
	        <p>History: ${project.history}</p>
	        <p>Video URL: ${project.url}</p>
        </div>
        <div>
            <input type="button" onclick="location.href='payment?projectId=${project.id}';" value="Invest into this project">
        </div>
    </body>
</html>