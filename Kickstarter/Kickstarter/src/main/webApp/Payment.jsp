<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Payment</title>
    </head>
    <body>
        <div>
            <form method="POST">
	            <input type="hidden" name="project_id" value="${projectId}" />
                <input required type="text" name="cardholder_name" placeholder="Your name">
                <input required type="text" name="card_number" placeholder="Your card number">
                <input required type="text" name="amount" placeholder="Enter amount to invest">
                <button type="submit">OK</button>
            </form>
        </div>
    </body>
</html>