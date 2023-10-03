<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> <c:out value="${ exception.getMessage()}"></c:out> </h2>
	
	<ul>
		<c:forEach item="${exception.getStackTrace()}" var="stack">
		<li><c:out value="${stack}"></c:out></li>
		</c:forEach>
	</ul>


</body>
</html>