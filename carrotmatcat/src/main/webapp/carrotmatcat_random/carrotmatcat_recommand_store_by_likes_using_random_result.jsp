<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>오늘은</h1>
<h3>" ${articleStoreName} "</h3>
<c:choose>
	<c:when test="${sessionScope.memberVO!=null}">
		<a href="${pageContext.request.contextPath}/ViewPostDetailByNoController.do?articleNo=${requestScope.articleNo}">게시글 보러가기</a>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>