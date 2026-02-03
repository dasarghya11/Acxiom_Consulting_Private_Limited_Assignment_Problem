<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="AddMemberServlet" method="post">
Name: <input type="text" name="name"><br><br>
<input type="radio" name="months" value="6" checked>6 Months
<input type="radio" name="months" value="12">1 Year
<input type="radio" name="months" value="24">2 Years<br><br>
<input type="submit" value="Add Member">
</form>
<span style="color:red">${error}</span>
			
</body>
</html>