<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container pt-3">
<form action="UpdateMemberController.do" method="post">
			<input type="text" name="memberId" required="required"  value="${sessionScope.memberVO.memberId}"  readonly="readonly"><br>
			<input type="password" name="memberPassword" required="required"	 value="${sessionScope.memberVO.memberPassword}"><br>
			<input type="text" name="memberNickname" required="required"	 value="${sessionScope.memberVO.memberNickname}"><br>
			
			<button type="submit">회원정보수정</button>
		</form>
</div>
</body>
</html>