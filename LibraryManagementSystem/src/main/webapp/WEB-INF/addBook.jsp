<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="AddBookServlet" method="post">
<input type="radio" name="type" value="BOOK" checked>Book
<input type="radio" name="type" value="MOVIE">Movie<br><br>
Book Name: <input type="text" name="name"><br><br>
Author: <input type="text" name="author"><br><br>
<input type="submit" value="Add Book">
</form>
<span style="color:red">${error}</span>
		
</body>
</html>