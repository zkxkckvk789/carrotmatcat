<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
ul{
   list-style:none;
   }
   
 .CommentBox{
 	border: 1px solid grey;
 	border-radius: 2em;
 	padding:10px;
 }  
 .comment_inbox{
 	padding-left: 30px;
 }
.container{
	padding-left:80px;
	padding-right:80px;
}
</style>
<script>
	let likeFlag;
	function like(flag){
		likeFlag=flag;
		let articleNo=document.getElementById("articleNo").value;
		let memberId = document.getElementById("memberId").value;
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange=callback; 
		xhr.open("POST","LikeController.do",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send("articleNo="+articleNo+"&memberId="+memberId);
	}
	function callback(){
		if(xhr.readyState==4 && xhr.status==200){
			if(likeFlag==false){
				document.getElementById("likeView").innerHTML="<input type='image' id='yes' src='carrotmatcat_images/yes.png' onclick='like(true)'>";
			}else{
				document.getElementById("likeView").innerHTML="<input type='image' id='no' src='carrotmatcat_images/no.png' onclick='like(false)'>";
			}
			document.getElementById("like_result").innerHTML=xhr.responseText;
			
		}//if
	}//callback
</script>
	<div class="container pt-3">
			<form>
				<input type="hidden" id="articleNo" name="articleNo" value="${postDetailView.articleNo}">
			</form>
		<table class="table table " style="border-collapse; border-radius:8px;" >
		<thead>
		<tr style="text-align: left; color: white; border-bottom:dashed;  font-size: 2em; ">
			<th class="no">${postDetailView.articleFoodCategory}</th>
		</tr>
		<tr style="font-size: 1.1em; color: #aac414; background-color: white;">
			<th style="width: 40%">${postDetailView.articleTitle}</th>
			<th style="width: 30%">${postDetailView.articleStoreName}</th>
			<th style="width: 10%">${postDetailView.memberVO.memberNickname}</th>
			<th>${postDetailView.articleTimePosted}</th>
			<th>조회수 ${postDetailView.articleHits}</th>
			<th>좋아요
			<c:choose>
				<c:when test="${sessionScope.memberVO!=null}">
					<input type="hidden" id="articleNo" value="${requestScope.postVO.articleNo }">
					<span id="likeView">
					<c:choose>
						<c:when test="${requestScope.postVO==null}">
							<!--  <a><img onclick="like(false)" src="carrotmatcat_imgaes/no.png"  ></a>-->
							<input type="image" id="no" src="carrotmatcat_images/no.png" onclick="like(false)">
							<!-- <input type="button" value="좋아요!" onclick="return like()"> -->
						</c:when>
						<c:otherwise>
							<!-- <a><img onclick="like(true)" src="carrotmatcat_imgaes/yes.png"  ></a> -->
							<input type="image" id="yes" src="carrotmatcat_images/yes.png" onclick="like(true)">
						</c:otherwise>
					</c:choose>
					</span>
					<span id="like_result">${requestScope.articleLikesCount }</span>
				</c:when>
				<c:otherwise>
					<img alt="좋아요" src="carrotmatcat_images/no.png">
					<span>${requestScope.articleLikesCount }</span>
				</c:otherwise> 			
			</c:choose>
			
			
			
			</th>
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
						<form id="modifyForm" action="UpdatePostFormController.do"
							method="post">
							<input type="hidden" name="articleNo"
								value="${postDetailView.articleNo}">
						</form>
						<form id="deleteForm" action="DeletePostController.do"
							method="post">
							<input type="hidden" name="articleNo"
								value="${postDetailView.articleNo}">
						</form>
						<div>
						<button type="button" onclick="updatePostByNo()" style="color: gray; background-color: white; border: 2px solid white; border-radius: 50px;">수정</button>
						<button type="button" onclick="deletePostByNo()" style="color: gray; background-color: white; border: 2px solid white; border-radius: 50px;">삭제</button> 
						<script>
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
		<div class="CommentBox">
	<div class="comment_option">
		<h3 class="comment_title">댓글</h3>
	</div>
	<ul class="comment_list">
		<c:forEach items="${commentList}" var="clist">
			<li class="CommentItem CommentItem--mine">
				<div class="comment_area"></div>
				<div class="comment_box">
					<div class="comment_nick_info">
						<a href="#" role="button" class="comment_nickname"
							id="comment_nickname"> ${clist.memberVO.getMemberNickname() }
						</a>
					</div>
					<div class="comment_text_box">
						<p class="comment_text_view">
							<span class="text_comment"></span>
							<c:choose>
								<c:when
									test="${sessionScope.memberVO.getMemberNickname()==clist.memberVO.getMemberNickname()}">

									<form id="modifyCommentForm"
										action="UpdateCommentController.do" method="post">
										<input type="hidden" name="commentNo" id="commentNo"
											value="${clist.commentNo}">
									</form>
									<form id="deleteCommentForm"
										action="DeleteCommentController.do" method="post">
										<input type="hidden" name="commentNo"
											value="${clist.commentNo}">
									</form>
									<a href="carrotmatcat_member/carrotmatcat_login_form.jsp" id="commentContent">${clist.commentContent}</a><br>
									<button type="button" onclick="updateComment()"
										style="color: gray; background-color: white; border: 1px solid white; border-radius: 20px;">댓글
										수정</button>
									<button type="button" onclick="deleteComment()"
										style="color: gray; background-color: white; border: 2px solid white; border-radius: 20px;">댓글
										삭제</button>
									
								</c:when>
								<c:otherwise>
									<a href="carrotmatcat_member/carrotmatcat_login_form.jsp" id="commentContent">${clist.commentContent}</a>
								</c:otherwise>
							</c:choose>
							<br> <span class="comment_info_date">${clist.commentTimePosted }</span>
						</p>
					</div>
					<hr>
				</div>
			</li>
		</c:forEach>
	</ul>
	<div class="CommentWriter">
		<div class="comment_inbox">
			<em class="comment_inbox_name" id="comment_inbox_name">${memberVO.getMemberNickname()}</em>

			<input type="text" id="commentContent"
				name="${sessionScope.memberVO.getMemberNickname() }"
				placeholder="댓글을 남겨보세요" class="comment_inbox_text"
				style="overflow: hidden; overflow-wrap: break-word;" />
			<button name="commentbtn" id="commentbtn" onclick="insertComment()" class="btn btn-warning">등록</button>
			<input name="memberId" id="memberId" type="hidden" value="${sessionScope.memberVO.getMemberId()}" />
		</div>
	</div>
	<%--<a href="${pageContext.request.contextPath}/FindPostListController.do?pageNo=${requestScope.pageNo}">목록</a> --%>
	<a href="javascript:history.back();">목록</a>
	
</div>
	</div>


</body>
</html>

<script type="text/javascript">
	function insertComment() {
		let articleNo = document.getElementById("articleNo").value;
		let memberNickname = document.getElementById("comment_inbox_name").innerHTML;
		let commentContent = document.getElementById("commentContent").value;
		console.log(articleNo, memberNickname,commentContent);
		let memberId = document.getElementById("member_id").value;
		
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() { //->  xhr의 변경을 감지할 때
			if (xhr.readyState == 4 && xhr.status == 200) {
				if(xhr.responseText=="ok") {
					window.location.reload();
				}
			}
		}
			xhr.open("post","${pageContext.request.contextPath}/WriteCommentController.do", true);
			xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=euc-kr');
			xhr.send("articleNo="+articleNo+ "&memberNickname="+memberNickname+"&commentContent="+commentContent+"&memberId="+memberId);
	}
			function deleteComment() {
				let result = confirm("삭제 하시겠습니까?");
				if (result) {
					deleteCommentByResult();
				}
			}
			
			function deleteCommentByResult(){
				let commentNo = document.getElementById("commentNo").value;
				console.log(commentNo);				
				let xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function() { //->  xhr의 변경을 감지할 때
					if (xhr.readyState == 4 && xhr.status == 200) {
						if(xhr.responseText=="ok") {
							window.location.reload();
						}
					}
			}
				xhr.open("post","${pageContext.request.contextPath}/DeleteCommentController.do", true);
				xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=euc-kr');
				xhr.send("commentNo="+commentNo);
		}
			function updateComment() {
				let result = confirm("수정 하시겠습니까?");
				if (result) {
					updateCommentByResult();
				}
			}
		
			function updateCommentByResult(){
				let commentNo = document.getElementById("commentNo").value;
				let commentContent = document.getElementById("commentContent").innerHTML;

				let xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function() { //->  xhr의 변경을 감지할 때
					if (xhr.readyState == 4 && xhr.status == 200) {
							window.location.reload();
					}
			}
				xhr.open("post","${pageContext.request.contextPath}/UpdateCommentFormController.do", true);
				xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=euc-kr');
				xhr.send("commentNo="+commentNo+"&commentContent="+commentContent);
		}
</script>
</body>
</html>
