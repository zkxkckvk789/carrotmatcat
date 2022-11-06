<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="carrotmatcat.jpg" type="image/x-icon" sizes="16x16">
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
<style type="text/css">
.container{
height: 100vh;
}

.matcat{
 position: absolute;
  width: 80%;
}

body{
background-color: #eb6421;
}
</style>
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${sessionScope.memberVO==null}">
				<a href="carrotmatcat_member/carrotmatcat_login_form.jsp"> 
				<img src="carrotmatcat_images/indexVer2.png" class="matcat">
				</a>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/HomeController.do"> 
					<img src="carrotmatcat_images/indexVer2.png" class="matcat">
				</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>