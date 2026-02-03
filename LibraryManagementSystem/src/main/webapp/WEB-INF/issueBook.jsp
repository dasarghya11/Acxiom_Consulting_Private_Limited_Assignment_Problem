<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="IssueBookServlet" method="post">
Book ID: <input type="text" name="bookId"><br><br>
Member ID: <input type="text" name="memberId"><br><br>
Return Date: <input type="date" name="returnDate"><br><br>
<input type="submit" value="Issue Book">
</form>
<span style="color:red">${error}</span>
		
</body>
</html>