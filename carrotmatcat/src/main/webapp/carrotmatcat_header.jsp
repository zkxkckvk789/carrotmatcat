<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navigation-container">
 	<a href="/" class="logo w-inline-block">
		<img src="images/n_2.png" width="73" alt="">
	</a>
	 <nav role="navigation" class="nav-menu w-nav-menu">
		<a href="FindPostListController.do" class="nav-link w-nav-link">맛집 게시판</a> 
		<a href="/premium" class="nav-link w-nav-link">오늘 뭐 먹지?</a>
		<div class="bullet"></div>
<c:choose>
	<c:when test="${sessionScope.memberVO==null}">
		 <a href="carrotmatcat_login_form.jsp" class="nav-link w-nav-link">로그인</a> 
		 <a href="carrotmatcat_register_form.jsp" class="navigation-button w-button">회원가입</a>
	</c:when>
	<c:otherwise>
		<a href="#">마이페이지</a>
		<a href="#">로그아웃</a>
	</c:otherwise>
</c:choose>
	 </nav>
 	<div class="menu-button w-nav-button"> 
 		<div class="icon-2 w-icon-nav-menu"></div>
	</div> 
</div>