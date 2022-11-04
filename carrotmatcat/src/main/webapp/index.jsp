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

</head>
<body>
<div class="container pt-3">
<h3>당신 근처의 맛집을 캣치</h3>
<h1>당근맛캣</h1>
<a href="carrotmatcat_layout.jsp">
	<img src="carrotmatcat_images/matcat.png"> 
</a>
<a href="${pageContext.request.contextPath}/FindPostListController.do">확인</a>
<a href="carrotmatcat_member/carrotmatcat_login_form.jsp">로그인확인</a>
</div>
</body>
</html>