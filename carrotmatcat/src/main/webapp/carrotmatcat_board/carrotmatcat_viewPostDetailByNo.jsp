<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container pt-3">
		<table class="table">
			<td>제목 ${postDetailView.articleTitle}</td>
			<tr>
				<td>글번호 ${postDetailView.articleNo}</td>

				<td>작성자 ${postDetailView.memberVO.memberNickname}</td>
				<td>조회수 ${postDetailView.articleHits}</td>
				<td>${postDetailView.articleTimePosted}</td>
			</tr>
			<tr>
				<td colspan="5">
					<%-- html pre tag : db에 저장된 글형식 그대로 표현,
								tip:pre tag 라인은 행변경 없이 한라인으로 표현해야한다.
						 --%> <font size="4"><pre>${postDetailView.articleContent}</pre></font>

				</td>
			</tr>

			<c:if
				test="${postDetailView.memberVO.getMemberNickname()==memberVO.getMemberNickname()}">
				<tr>
					<td colspan="5" class="text-center">
						<form id="modifyForm" action="UpdatePostController.do"
							method="post">
							<input type="hidden" name="no"
								value="${postDetailView.articleNo}">
						</form>
						<form id="deleteForm" action="DeletePostController.do"
							method="post">
							<input type="hidden" name="no"
								value="${postDetailView.articleNo}">
						</form>
						<button type="button" onclick="updatePostByNo()">수정</button>
						<button type="button" onclick="deletePostByNo()">삭제</button> <script>
							function deletePostByNo() {
								let result = confirm("삭제 하시겠습니까?");
								if (result) {
									document.getElementById("deleteForm")
											.submit();
								}
							}
							function updatePostByNo() {
								let result = confirm("수정 하시겠습니까?");
								if (result) {
									document.getElementById("modifyForm")
											.submit();
								}
							}
						</script>
					</td>
				</tr>
			</c:if>
		</table>

	</div>
</body>
</html>