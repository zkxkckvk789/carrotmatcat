<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <div class="navigation-container">
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
</div> --%>

  <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="HomeController.do"><img src="carrotmatcat_images/carrotmatcat_logo.png"></a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto my-2 my-lg-0">
                        <ul class="nav-item"><a class="nav-link" href="FindPostListController.do">맛집 게시판</a>
                        	<li class="nav-item"><a class="nav-link" href="#services">한식</a></li>
                        	<li class="nav-item"><a class="nav-link" href="#services">일식</a></li>
                        	<li class="nav-item"><a class="nav-link" href="#services">중식</a></li>
                        	<li class="nav-item"><a class="nav-link" href="#services">양식</a></li>
                        	<li class="nav-item"><a class="nav-link" href="#services">카페/디저트</a></li>
                        </ul>
                        <li class="nav-item"><a class="nav-link" href="#services">오늘 뭐 먹지?</a></li>
                        <c:choose>
                        	<c:when test="${sessionScope.memberVO==null}">
                       			<li class="nav-item"><a class="nav-link" href="carrotmatcat_member/carrotmatcat_login_form.jsp" >로그인</a></li>
                      			<li class="nav-item"><a class="nav-link" href="carrotmatcat_member/carrotmatcat_register_form.jsp">회원가입</a></li>
                        	</c:when>
                        	<c:otherwise>
                        		<li class="nav-item"><a class="nav-link" href="#contact">마이페이지</a></li>
                      			<li class="nav-item"><a class="nav-link" href="#contact">로그아웃</a></li>
							</c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </nav>
      