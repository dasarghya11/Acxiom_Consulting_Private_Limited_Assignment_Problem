<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="UpdateMemberServlet" method="post">
Member ID: <input type="text" name="memberId"><br><br>
<input type="radio" name="months" value="6" checked>6 Months
<input type="radio" name="months" value="12">1 Year<br><br>
<input type="submit" value="Update Membership">
</form>
		
</body>
</html>