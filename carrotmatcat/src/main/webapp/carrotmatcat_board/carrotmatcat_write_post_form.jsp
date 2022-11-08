<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="${pageContext.request.contextPath}/WritePostController.do" method="post">
<br>	
<div  style="padding-left:150px; padding-right:150px;">
	<table class="table">
		<tr>
			<td><select class="selectpicker" style="display: inline; border-radius:3px; " name="articleFoodCategory">
					<option value="한식">한식</option>
					<option value="일식">일식</option>
					<option value="양식">양식</option>
					<option value="중식">중식</option>
					<option value="카페/디저트">카페/디저트</option>
			</select></td>
		</tr>
		<tr>
			<td><input type="text" name="articleStoreName" placeholder="맛집 이름 (상호명)" required="required" style="border:none; background-color: #FFFFFF; border-radius: 3px"></td>
		</tr>
		<tr>
			<td><input type="text" name="articleTitle" placeholder="제목" required="required" style="border:none; background-color: #FFFFFF; border-radius: 3px;"></td>
		</tr>
		<tr>
			<td><textarea rows="10" class="form-control" name="articleContent" placeholder="맛집을 소개해주세요" required="required" style="border:none"></textarea></td>
		</tr>
	</table>
<div class="text-center">
	<button type="submit" class="btn btn-success" style="background-color: #ef7b35; border:none">확인</button>
	<button type="reset" class="btn btn-success" style="background-color: #ef7b35; border:none">취소</button>
	<br><br><br>
</div>
</div>
</form>