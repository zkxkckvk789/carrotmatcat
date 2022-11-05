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
<form action="${pageContext.request.contextPath}/RegisterMemberController.do" method="post" onsubmit="checkRegisterForm(event)">
	<input type="text" name="memberId" id="memberId" placeholder="아이디" required="required">
	<button type="button" onclick="checkMemberId()">아이디 중복확인</button>
	<span id="checkMemberIdResult"></span><br>
	
	<input type="password" name="memberPassword" id="memberPasswordOne" placeholder="패스워드" required="required"><br>
	<input type="password" name="memberPassword" id="memberPasswordTwo" placeholder="패스워드" required="required" onkeyup="checkPassword()"><br>
	<span id="checkMemberPasswordResult"></span><br>
	
	<input type="text" name="memberNickname" id="memberNickname" placeholder="닉네임" required="required">
	<button type="button" onclick="checkMemberNickname()">닉네임 중복확인</button>
	<span id="checkMemberNicknameResult"></span><br>
	
	<button type="submit">회원가입</button>
</form>
<script type="text/javascript">
	let checkMemberIdFlag=false;
	let checkMemberNicknameFlag = false;
	
	function checkRegisterForm(event){
		if(checkMemberIdFlag==false){
			alert("아이디 인증을 받으세요.");
			event.preventDefault();
		}
		else if(checkMemberPasswordResult.innerHTML!=""){
			console.log(checkMemberPasswordResult.innerHTML);
			alert("비밀번호 인증을 받으세요.");
			event.preventDefault();
		}
		else if(checkMemberNicknameFlag==false){
			alert("닉네임 인증을 받으세요.");
			event.preventDefault();
		}
	}
	
	function checkMemberId() {
		checkMemberIdFlag=false;
     	let memberId=document.getElementById("memberId").value;
		let checkMemberIdResult=document.getElementById("checkMemberIdResult");
		if(memberId.length<4){
			checkResultSpan.innerHTML="<font color=pink>아이디는 4자 이상</font>";
		}else{
			let xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4&&xhr.status==200){
					if(xhr.responseText=="ok"){
						checkMemberIdResult.innerHTML="<font color=blue>사용가능한 아이디 입니다.</font>";
						checkMemberIdFlag=true;
					}else{
						checkMemberIdResult.innerHTML="<font color=red>존재하는 아이디 입니다. </font>";
					}
				}//if
			}//function
			xhr.open("get","${pageContext.request.contextPath}/CheckDuplicateIdController.do?memberId="+memberId);
			xhr.send();
		}//else
	}//checkId
	
	function checkPassword(event){
		let memberPasswordOne=document.getElementById("memberPasswordOne").value;
		let memberPasswordTwo=document.getElementById("memberPasswordTwo").value;
		if(memberPasswordOne!=memberPasswordTwo){
			checkMemberPasswordResult.innerHTML="<font color=red>비밀번호가 일치하지않습니다. </font>";
		}
		else{
			checkMemberPasswordResult.innerHTML="";
		}
	}
	
	function checkMemberNickname() {
     	let memberNickname=document.getElementById("memberNickname").value;
		let checkMemberNicknameResult=document.getElementById("checkMemberNicknameResult");
		let xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				if(xhr.responseText=="ok"){
					checkMemberNicknameResult.innerHTML="<font color=blue>사용가능한 닉네임 입니다.</font>";
					checkMemberNicknameFlag=true;
				}else{
					checkMemberNicknameResult.innerHTML="<font color=red>존재하는 닉네임 입니다. </font>";
				}
			}//if
		}//function
		xhr.open("get","${pageContext.request.contextPath}/CheckDuplicateNicknameController.do?memberNickname="+memberNickname);
		xhr.send();
	}
</script>
</div>
</body>
</html>



