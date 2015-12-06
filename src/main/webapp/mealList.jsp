<%@ page import="java.time.LocalDateTime" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>


    <style>
        .datepicker{

        }
    </style>

    <script>
        $(function() {
            $( ".datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });
        });
    </script>

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
<hr>
<c:set var="date" value="<%=LocalDateTime.now()%>" />
<form method="post">
    <input type="date" name="datetime" class="datepicker" placeholder="select date" value="${date.toLocalDate()}">
    Hour:
    <select title="Hours" name="hour">
        <c:forEach begin="0" end="23" var="i">
            <option value="${i}">${i}</option>
        </c:forEach>
    </select>
    <input type="text" name="description" id="description" placeholder="Description">
    <input type="number" name="calories" id="calories" placeholder="Calories" step="10">
    <INPUT TYPE="SUBMIT" NAME="submit" VALUE="ADD">
    <INPUT TYPE="SUBMIT" NAME="submit" VALUE="READ">
    <INPUT TYPE="SUBMIT" NAME="submit" VALUE="EDIT">
    <INPUT TYPE="SUBMIT" NAME="submit" VALUE="DELETE">
</form>
</body>
</html>
