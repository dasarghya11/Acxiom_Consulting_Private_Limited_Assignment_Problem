<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="FinePayServlet" method="post">
Fine Amount: ${fine}<br><br>
Fine Paid: <input type="checkbox" name="paid"><br><br>
<input type="hidden" name="transId" value="${transId}">
<input type="submit" value="Confirm">
</form>
		
</body>
</html>