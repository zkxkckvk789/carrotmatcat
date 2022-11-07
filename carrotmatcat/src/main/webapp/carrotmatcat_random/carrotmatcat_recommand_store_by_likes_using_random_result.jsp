<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="width:50%; display: block; margin-left: auto; margin-right: auto; width: 50%;">
<h1 style="text-align: center; padding-top:100px;">오늘은</h1>
<h3 style="text-align: center">" ${articleStoreName} "</h3>
<c:choose>
	<c:when test="${sessionScope.memberVO!=null}">
		<a href="${pageContext.request.contextPath}/ViewPostDetailByNoController.do?articleNo=${requestScope.articleNo}" style="width:50%; display: block; margin-left: auto; margin-right: auto; width: 50%;">게시글 보러가기</a>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
</div>