<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-hover boardlist">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>가게 이름</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.postList}" var="post">
			<tr>
				<td>${post.articleNo}</td>
				<td>
					<c:choose>	
						<c:when test="${sessionSope.member!=null}">
							<a href="${pageContext.request.contextPath}/ViewPostDetailByNoController.do?articleNo=${post.articleNo}">${post.articleTitle}</a>
						</c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath}/LoginFormController.do">${post.articleTitle}</a>
						</c:otherwise>
					</c:choose>				
				</td>
				<td>${post.articleStoreName}</td>
				<td>${post.memberVO.memberNickname}</td>
				<td>${post.articleTimePosted}</td>
				<td>${post.articleHits}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<ul class="pagination justify-content-center" style="margin:20px 0">	
	<c:if test="${requestScope.pagination.previousPageGroup}">	
	<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/FindPostListController.do?pageNo=${requestScope.pagination.startPageOfPageGroup-1}">Previous</a></li>
	</c:if>
	<c:forEach begin="${requestScope.pagination.startPageOfPageGroup}" end="${requestScope.pagination.endPageOfPageGroup}" var="page">
		<c:choose>
			<c:when test="${requestScope.pagination.nowPage==page}">
				<li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/FindPostListController.do?pageNo=${page}">${page}</a></li>		
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/FindPostListController.do?pageNo=${page}">${page}</a></li>		
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${requestScope.pagination.nextPageGroup}">	
  	<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/FindPostListController.do?pageNo=${requestScope.pagination.endPageOfPageGroup+1}">Next</a></li>     
	</c:if>
</ul>