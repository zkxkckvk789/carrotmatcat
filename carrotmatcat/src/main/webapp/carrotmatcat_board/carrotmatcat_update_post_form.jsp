<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form method="post" action="UpdatePostController.do">

	<input type="hidden" name="articleNo" value="${requestScope.postVO.articleNo}">
	<table class="table">
		<tr>
			<td>
			<input type="text" value="${requestScope.postVO.articleTitle}" name="articleTitle"
				placeholder="글제목" required="required">
			<input type="text" value="${requestScope.postVO.articleStoreName }" name="articleStoreName"
				placeholder="가게이름" required="required">
			<input type="text" value="${requestScope.postVO.articleFoodCategory }" name="articleFoodCategory"
				placeholder="종류" required="required">
			</td>

		</tr>
		<tr>
			<td><textarea rows="10" class="form-control" name="articleContent"
					placeholder="본문내용" required="required">${requestScope.postVO.articleContent}</textarea></td>
		</tr>
	</table>
	<div class="text-center">
		<button type="submit" class="btn btn-success">확인</button>
		<button type="reset" class="btn btn-success">취소</button>
	</div>
</form>