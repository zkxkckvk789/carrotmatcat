<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Roboto:300);
.update-page {
  width: 360px;
  padding: 8% 0 0;
  margin: auto;
}
.form {
  position: relative;
  z-index: 1;
  background: #FFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  border-radius:20px;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: "Merriweather Sans", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: "Merriweather Sans", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
  text-transform: uppercase;
  outline: 0;
  background: #ef7b35;
  width: 100%;
  border-color:#FFFFFF;
  border-style:solid;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form button:hover,.form button:active,.form button:focus {
  background: #eb6421;
  color: #FFFFFF;
}
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: #4CAF50;
  text-decoration: none;
}

.container {
  position: relative;
  z-index: 1;
  max-width: 300px;
  margin: 0 auto;
}
.container:before, .container:after {
  content: "";
  display: block;
  clear: both;
}
.container .info {
  margin: 50px auto;
  text-align: center;
}
.container .info h1 {
  margin: 0 0 15px;
  padding: 0;
  font-size: 36px;
  font-weight: 300;
  color: #1a1a1a;
}
.container .info span {
  color: #4d4d4d;
  font-size: 12px;
}
.container .info span a {
  color: #000000;
  text-decoration: none;
}
.container .info span .fa {
  color: #EF3B3A;
}
.matcat{
	width:200px; 
	position:relative;
	left:20%;
	top:25%;
}
body {
  background-color: white; 
  background: white;
  background: #eb6421;
  font-family: "Merriweather Sans", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;      
}
</style>
</head>
<body>
<div class="update-page">
<img src="${pageContext.request.contextPath}/carrotmatcat_images/login.png" class="matcat">
<div class="form">
<form action="UpdateMemberController.do" method="post" onsubmit="checkRegisterForm(event)">
			<input type="text" name="memberId" required="required"  value="${sessionScope.memberVO.memberId}"  readonly="readonly"	><br>
			<input type="password" name="memberPassword" id="memberPasswordOne" required="required" placeholder = "패스워드"><br>
			<input type="password" name="memberPassword" id="memberPasswordTwo" required="required" placeholder = "패스워드" onkeyup="checkPassword()"><br>
			<span id="checkMemberPasswordResult"></span>
			<input type="text" name="memberNickname"  id="memberNickname" required="required"  value="${sessionScope.memberVO.memberNickname}"><br>
			<button type="button" onclick="checkMemberNickname()">닉네임 중복확인</button>
			<span id="checkMemberNicknameResult"></span>
			<br><br><br>
			<button type="submit" onclick="trimCheck()">회원정보수정</button>
		</form>
		<form id="home" action="HomeController.do" method="post">
		</form>
			<button type="button" onclick="goback()">홈화면으로 돌아가기</button>		
</div>
<script>
let checkMemberNicknameFlag = false;
function checkRegisterForm(event){
	if(checkMemberPasswordResult.innerHTML!=""){
		console.log(checkMemberPasswordResult.innerHTML);
		alert("비밀번호 인증을 받으세요.");
		event.preventDefault();
	}
	else if(checkMemberNicknameFlag==false){
		alert("닉네임 인증을 받으세요.");
		event.preventDefault();
	}
}

function checkPassword(event){
	let memberPasswordOne=document.getElementById("memberPasswordOne").value;
	let memberPasswordTwo=document.getElementById("memberPasswordTwo").value;
	if(memberPasswordOne!=memberPasswordTwo){
		checkMemberPasswordResult.innerHTML="<font color=orange>비밀번호가 일치하지않습니다. </font>";
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

function goback(){
	let result=confirm("회원정보 수정을 취소하시겠습니까?");
	if(result){
		document.getElementById("home").submit();
	}
}

function trimCheck() {
	let password=document.getElementById("memberPasswordOne").value;
	let nickname=document.getElementById("memberNickname").value;
	if(password.trim()<1 || nickname.trim()<1){
		alert("공백 등록은 불가능합니다");
		event.preventDefault();
	} 
}
</script>
</div>
</body>
</html>