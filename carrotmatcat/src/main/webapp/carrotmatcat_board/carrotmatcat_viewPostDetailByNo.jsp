<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="container pt-3">
			<form>
				<input type="hidden" name="articleNo" value="${postDetailView.articleNo}">
			</form>
		<table class="table table ">
		<thead>
		<tr style="text-align: left; color: white; border-bottom:dashed;  font-size: 2em;">
			<th class="no">${postDetailView.articleFoodCategory}</th>
		</tr>
		<tr style="font-size: 1.1em; color: #aac414; background-color: white;">
			<th style="width: 70%">${postDetailView.articleTitle}</th>
			<th style="width: 10%">${postDetailView.memberVO.memberNickname}</th>
			<th>${postDetailView.articleTimePosted}</th>
			<th>조회수 ${postDetailView.articleHits}</th>
		</tr>
	</thead>
		<tbody>
			<tr style="background-color: white">
				<td colspan="6" style="height: 30vh;">
					<font size="4"><pre>${postDetailView.articleContent}</pre></font>
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
						<div>
						<button type="button" onclick="updatePostByNo()" style="color: gray; background-color: white; border: 2px solid white; border-radius: 50px;">수정</button>
						<button type="button" onclick="deletePostByNo()" style="color: gray; background-color: white; border: 2px solid white; border-radius: 50px;">삭제</button> <script>
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
						</div>
					</td>
				</tr>
			</c:if>
			</tbody>
		</table>
	</div>