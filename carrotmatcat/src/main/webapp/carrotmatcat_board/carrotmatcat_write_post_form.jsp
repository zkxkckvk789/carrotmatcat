<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="${pageContext.request.contextPath}/WritePostController.do" method="post">
<br>
	<table class="table">
		<tr>
			<td><input type="text" name="articleStoreName" placeholder="맛집 이름 (상호명)" required="required"></td>
		</tr>
		<tr>
			<td><input type="text" name="articleTitle" placeholder="제목" required="required"></td>
		</tr>
		<tr>
<<<<<<< HEAD
			<td><select class="selectpicker" onchange="window.open(value,'_self');"
                            style="display: inline; name="articleFoodCategory">
					<option value="한식">한식</option>
					<option value="일식">일식</option>
					<option value="양식">양식</option>
					<option value="중식">중식</option>
					<option value="카페/디저트">카페/디저트</option>
			</select></td>
=======
			<td>
			<select name="articleFoodCategory"  id="articleFoodCategory">
			<option value="한식">한식</option>
			<option value="일식">일식</option>
			<option value="양식">양식</option>
			<option value="중식">중식</option>
			<option value="카페/디저트">카페/디저트</option>
			</select>
			</td>
>>>>>>> branch 'main' of https://github.com/zkxkckvk789/carrotmatcat.git
		</tr>
		<tr>
			<td><textarea rows="10" class="form-control" name="articleContent" placeholder="맛집을 소개해주세요" required="required"></textarea></td>
		</tr>
	</table>
<div class="text-center">
	<button type="submit" class="btn btn-success">확인</button>
	<button type="reset" class="btn btn-success">취소</button>
</div>
</form>