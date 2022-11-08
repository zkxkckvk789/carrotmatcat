<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="HomeController.do"><img src="carrotmatcat_images/carrotmatat_logo.png" style="width:50%"></a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="navbar" id="navbarResponsive" style="">
                    <ul class="navbar-nav ms-auto my-2 my-lg-0">
                        <li class="nav-item">
                        	<a class="nav-link" href="${pageContext.request.contextPath}/FindPostListController.do">맛집게시판</a>
		                        <ul class="nav-item" style="text-align: center;">
			                        	<li class="nav-item" style="float:left; list-style: none;"><a class="nav-link" href="${pageContext.request.contextPath}/FindPostListByFoodOfKoreanController.do" >한식</a></li>
			                        	<li class="nav-item" style="float:left; list-style: none"><a class="nav-link" href="FindPostListByFoodOfJapaneseController.do">일식</a></li>
			                        	<li class="nav-item" style="float:left; list-style: none"><a class="nav-link" href="FindPostListByFoodOfChineseController.do">중식</a></li>
			                        	<li class="nav-item" style="float:left; list-style: none"><a class="nav-link" href="FindPostListByFoodOfWesternController.do">양식</a></li>
			                        	<li class="nav-item" style="float:left; list-style: none"><a class="nav-link" href="FindPostListByFoodOfCafeAndDessertController.do">카페/디저트</a></li>
		                        </ul>   
                        </li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/RecommandStoreByLikesUsingRandomFormController.do">오늘 뭐 먹지?</a></li>
                        <c:choose>
                        	<c:when test="${sessionScope.memberVO==null}">
                       			<li class="nav-item"><a class="nav-link" href="carrotmatcat_member/carrotmatcat_login_form.jsp" >로그인</a></li>
                      			<li class="nav-item"><a class="nav-link" href="carrotmatcat_member/carrotmatcat_register_form.jsp">회원가입</a></li>
                        	</c:when>
                        	<c:otherwise>
                        		<li class="nav-item">
                        			<a class="nav-link" href="mypage.jsp">마이페이지</a>
                        		</li>
                      			<li class="nav-item"><a class="nav-link" href="javascript:logout()">로그아웃</a></li>
                      			<form id="logoutForm" action="${pageContext.request.contextPath}/LogoutController.do" method="post"></form>
                      			<script>
                      				function logout(){
                      					let result=confirm("로그아웃 하시겠습니까?");
                      					if(result){
                      						document.getElementById("logoutForm").submit();
                      					}
                      				}
                      			</script>
							</c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </nav>
