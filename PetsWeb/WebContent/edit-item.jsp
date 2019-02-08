<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pet list edit</title>
</head>
<body>
<!-- Create a form to allow the user to edit the values of the current pet. -->
<form action = "editPetServlet" method="post">
Type: <input type ="text" name = "type" value="${itemToEdit.type}">
Owner: <input type = "text" name = "owner" value= "${itemToEdit.owner}">
Name: <input type = "text" name = "name" value= "${itemToEdit.name}">
<input type = "hidden" name = "petID" value="${itemToEdit.petID}">
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>