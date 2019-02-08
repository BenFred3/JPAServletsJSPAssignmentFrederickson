<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pet list actions</title>
</head>
<body>
<!-- Create a form and table to allow the user to edit the information in the database. -->
<form method = "post" action = "navigationServlet">
<table>
<!-- List out the database for the user and allow them to select an item. -->
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
 <td><input type="radio" name="petID" value="${currentitem.petID}"></td>
 <td>${currentitem.type} -</td>
 <td>${currentitem.owner} -</td>
 <td>${currentitem.name}</td>
 </tr>
</c:forEach>
<!-- Create buttons to allow the user to edit, delete, or go back and add. -->
</table>
<input type = "submit" value = "edit" name = "doThisToItem">
<input type = "submit" value = "delete" name = "doThisToItem">
<input type = "submit" value = "add" name = "doThisToItem">
</form>
</body>
</html>