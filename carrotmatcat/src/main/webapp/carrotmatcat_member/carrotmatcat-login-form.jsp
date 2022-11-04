<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="${pageContext.request.contextPath }/LoginController.do">
	<input type="text" name="memberId" placeholder="아이디" required="required"><br><br>
	<input type="passord" name="memberPassword" placeholder="패스워드" required="required"><br><br>
	<button type="submit">로그인</button>
</form>
<br><br>
<a href="carrotmatcat-register-from.jsp">회원가입</a>