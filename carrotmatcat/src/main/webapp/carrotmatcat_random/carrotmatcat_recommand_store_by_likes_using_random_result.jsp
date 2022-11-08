<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="width:50%; display: block; width: 50%;">
<h1 style="text-align: center; padding-top:20%; padding-left:100%; color:white">오늘은</h1>
<img src="carrotmatcat_images/randomResult.png" style="width:200%;"><br><br>
<h3 style="text-align: center; color:white; margin-left:20%; padding-left:50%">" ${articleStoreName} "</h3><br><br><br>
	<c:if test="${sessionScope.memberVO!=null}">
		<a href="${pageContext.request.contextPath}/ViewPostDetailByNoController.do?articleNo=${requestScope.articleNo}" style="text-decoration:none; font-size:1.2rem; display: block; margin-left: 45vw; width: 50%;">게시글 보러가기</a>
	</c:if>
	<br><br><br><br>
</div>