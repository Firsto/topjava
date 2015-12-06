<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meal list</title>
</head>
<body>
<h2>Meal list</h2>
<table align="center" border="2" cellspacing="3" cellpadding="3">
    <tr>
        <th>DateTime</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    <jsp:useBean id="meals" scope="request" type="java.util.List"/>
    <c:forEach var="meal" items="${meals}">
        <tr>
            <td>${meal.getDateTime()}</td>
            <td>${meal.getDescription()}</td>
            <td style="color: ${meal.isExceed() ? 'red' : 'green'}">${meal.getCalories()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
