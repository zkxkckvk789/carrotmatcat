<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당근맛캣 Carrot Mat Cat</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="carrotmatcat_css/carrotmatcat_layout.css">
</head>
<body>

	<%-- header/nav 영역 --%>
	<c:import url="carrotmatcat_header.jsp"></c:import>
	<%-- header/nav 영역끝 --%>

	<div class="container pt-3">
		<%-- main 영역 --%>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<c:import url="${requestScope.url}"></c:import>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<%-- main 영역끝 --%>
	</div>
	<div>
		<%-- footer 영역 --%>
		<c:import url="carrotmatcat_footer.jsp"></c:import>
		<%-- footer 영역끝 --%>
	</div>
</body>
</html>