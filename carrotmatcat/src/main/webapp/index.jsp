<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="carrotmacat_images/carrotmatcat_logo.png" type="image/x-icon" sizes="16x16">
<meta charset="UTF-8">
<title>당근맛캣 Carrot Mat Cat</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
.container{
height: 100vh;
}

.matcat{
 position: absolute;
  width: 100%;
}

body{
background-color: #eb6421;
}
</style>
</head>
<body>
	<div class="container">
				<a href="${pageContext.request.contextPath}/HomeController.do"> 
					<img src="carrotmatcat_images/indexVer2.png" class="matcat">
				</a>
	</div>
</body>
</html>