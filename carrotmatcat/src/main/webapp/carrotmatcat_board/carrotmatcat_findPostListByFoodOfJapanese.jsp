<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3></h3> <%-- 선택한 카테고리 이름 자리--%>
<br>
<style>
	.table{
		padding-left:80px;
		padding-right:80px;
		
	}
</style>
<div class="search">
	<form action="${pageContext.request.contextPath}/SearchController.do" method="get">
		<select name="searchCategory" style="color: white; background-color: orange; border: 4px solid orange; border-radius: 50px;">
			<option value="제목">제목</option>
			<option value="내용">내용</option>
		</select>
		<input type="text" name="searchContent" required="required" style="color: gray; background-color: white; border: 2px solid white; border-radius: 50px;">
		<button type="submit" style="color: gray; background-color: white; border: 2px solid white; border-radius: 50px;">검색</button>
	</form>
</div>
<br><br>
<div class="col-sm-10 offset-sm-1">
<table class="table table-hover boardlist">
	<thead style="text-align:center">
		<tr style="background-color: white">
			<th>글번호</th>
			<th>제목</th>
			<th>가게 이름</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody style="background-color: white; text-align:center">
		<c:forEach items="${requestScope.postList}" var="post">
			<tr>
				<td>${post.articleNo}</td>
				<td>
					<c:choose>	
						<c:when test="${sessionScope.memberVO!=null}">
							<a href="${pageContext.request.contextPath}/ViewPostDetailByNoController.do?articleNo=${post.articleNo}">${post.articleTitle}</a>
						</c:when>  
						<c:otherwise>
							<a href="carrotmatcat_member/carrotmatcat_login_form.jsp">${post.articleTitle}</a>
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
</div>
<c:if test="${sessionScope.memberVO!=null}">
<span class="write">
	<a href="${pageContext.request.contextPath}/WritePostFormController.do" style="background-color: white; color: orange; padding:5px; text-decoration: none;">글쓰기</a>
</span>
<br>
</c:if>
<ul class="pagination justify-content-center" style="margin:20px 0">	
	<c:if test="${requestScope.pagination.previousPageGroup}">	
	<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/FindPostListByFoodOfJapaneseController.do?pageNo=${requestScope.pagination.startPageOfPageGroup-1}">Previous</a></li>
	</c:if>
	<c:forEach begin="${requestScope.pagination.startPageOfPageGroup}" end="${requestScope.pagination.endPageOfPageGroup}" var="page">
		<c:choose>
			<c:when test="${requestScope.pagination.nowPage==page}">
				<li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/FindPostListByFoodOfJapaneseController.do?pageNo=${page}">${page}</a></li>		
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/FindPostListByFoodOfJapaneseController.do?pageNo=${page}">${page}</a></li>		
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${requestScope.pagination.nextPageGroup}">	
  	<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/FindPostListByFoodOfJapaneseController.do?pageNo=${requestScope.pagination.endPageOfPageGroup+1}">Next</a></li>     
	</c:if>
</ul>
