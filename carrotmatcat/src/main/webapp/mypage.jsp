<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당근맛캣 Carrot Mat Cat</title>
<link rel="icon" href="carrotmatcat.jpg" type="image/x-icon" sizes="16x16">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="carrotmatat_images/carrotmatat_logo.png" />
        <!-- Bootstrap Icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
        <!-- SimpleLightbox plugin CSS-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="carrotmatcat_css/styles.css" rel="stylesheet" />
        <style type="text/css">
			.list{
			margin-left:5%;
			margin-top:5%;
			text-align: center;
			}
			.logo{
			padding: 10%;
			}
        </style>
</head>
<body>
<header>
<c:import url="carrotmatcat_header.jsp"></c:import>
</header>
<div class="list">
	<a href="UpdateMemberFormController.do">
		<img class="logo" src="carrotmatcat_images/carrotmatcatUpdate.png">
	</a>
	<a href="FindPostListByLikesController.do">
		<img class="logo" src="carrotmatcat_images/carrotmatcatLikes.png">
	</a>
</div>
<c:import url="carrotmatcat_footer.jsp"></c:import>
</body>
</html>