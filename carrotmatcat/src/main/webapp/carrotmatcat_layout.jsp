<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당근맛캣 Carrot Mat Cat</title>
<link rel="icon" href="carrotmatcat_images/carrotmatat_logo.png" type="image/x-icon" sizes="16x16">
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
</head>
<body>

	<%-- header/nav 영역 --%>
	<c:import url="carrotmatcat_header.jsp"></c:import>
	<%-- header/nav 영역끝 --%>
<%-- main 영역 --%>
<br><br><br><br><br><br>
<c:import url="${requestScope.url}"></c:import>
<%-- main 영역끝 --%>
<div>
<%-- footer 영역 --%>
 <c:import url="carrotmatcat_footer.jsp"></c:import>
<%-- footer 영역끝 --%>
</div>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- SimpleLightbox plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
        <!-- Core theme JS-->
        <script src="carrotmatcat_js/scripts.js"></script>
</body>
</html>