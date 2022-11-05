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
		<h2>회원가입</h2>
		<form action="RegisterMemberController.do" method="post" onsubmit="checkRegisterForm(event)">
			<input type="text" name="memberId" id="memberId" placeholder="아이디" required="required">
			<span id="checkResult"></span><br>
			<button type="button" onkeyup="checkDuplicateMemberId()">아이디 중복확인</button>
			
			
			<span id="checkResult"></span><br> <input type="text" name="name" placeholder="닉네임" required="required">
			<button>닉네임 중복확인</button>
			<br>
			 <input type="password" name="password" placeholder="비밀번호" required="required"><br> <input type="password" name="password" placeholder="비밀번호확인" required="required"><br>
			<button type="submit">회원가입</button>
		</form>
		<script type="text/javascript">
	let checkFlag=false;
	function checkRegisterForm(event){
		if(checkFlag==false){
			alert("아이디 인증을 받으세요");
			event.preventDefault();
		}
	}
	function checkDuplicateMemberId() {
		checkFlag=false;
     	let memberId=document.getElementById("memberId").value;
		let checkResultSpan=document.getElementById("checkResult");
		if(memberId.length<4){
			checkResultSpan.innerHTML="<font color=pink>아이디는 4자 이상</font>";
		}else{
			let xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4&&xhr.status==200){
					if(xhr.responseText=="ok"){
						checkResultSpan.innerHTML="<font color=blue>사용가능</font>";
						checkFlag=true;
					}else{
						checkResultSpan.innerHTML="<font color=red>사용불가</font>";
					}
				}//if
			}//function
			xhr.open("get","CheckDuplicateIdController.do?id="+memberId);
			xhr.send();
		}//else
	}//checkId
</script>
	</div>
</body>
</html>
