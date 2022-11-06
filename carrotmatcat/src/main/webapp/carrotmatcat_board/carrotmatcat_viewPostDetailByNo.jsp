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

		<div class="article_content">
			<table class="table">
				<td>제목 ${postDetailView.articleTitle}</td>
				<tr>
					<td>글번호 ${postDetailView.articleNo}</td>

					<td>작성자 ${postDetailView.memberVO.memberNickname}</td>
					<td>조회수 ${postDetailView.articleHits}</td>
					<td>${postDetailView.articleTimePosted}</td>
				</tr>
				<tr>
					<td colspan="5">
						<%-- html pre tag : db에 저장된 글형식 그대로 표현,
								tip:pre tag 라인은 행변경 없이 한라인으로 표현해야한다.
						 --%> <font size="4"><pre>${postDetailView.articleContent}</pre></font>


					</td>
				</tr>

			</c:if>
			</tbody>
		</table>
	</div>


				<c:if
					test="${postDetailView.memberVO.getMemberNickname()==memberVO.getMemberNickname()}">
					<tr>
						<td colspan="5" class="text-center">
							<form id="modifyForm" action="UpdatePostFormController.do"
								method="post">
								<input type="hidden" name="no"
									value="${postDetailView.articleNo}">
							</form>
							<form id="deleteForm" action="DeletePostController.do"
								method="post">
								<input type="hidden" name="no"
									value="${postDetailView.articleNo}">
							</form>
							<button type="button" onclick="updatePostByNo()">수정</button>
							<button type="button" onclick="deletePostByNo()">삭제</button> <script>
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
						</td>
					</tr>
				</c:if>
			</table>
		</div>
		<div class="CommentBox">
			<div class="comment_option">
				<h3 class="comment_title">댓글</h3>
			</div>
			<ul class="comment_list">
				<c:forEach items="${commentList}" var="clist">
					<li  class="CommentItem CommentItem--mine"><div class="comment_area"></div>
							<div class="comment_box">
									<div class="comment_nick_info">
										<a href="#" role="button" class="comment_nickname"> ${clist.memberVO.getMemberNickname() } </a>
									</div>
								<div class="comment_text_box">
									<p class="comment_text_view">
										<span class="text_comment"></span>
										<c:choose>
											<c:when test="${sessionScope.memberVO==clist.memberVO.getMemberNickname()}">
												<a href="#">댓글 삭제</a>
												<a href="#">댓글 수정</a>
											</c:when>
											<c:otherwise>
												<a href="carrotmatcat_member/carrotmatcat_login_form.jsp">${clist.commentContent}</a>
											</c:otherwise>
										</c:choose>
										<br><span class="comment_info_date">${clist.commentTimePosted }</span>
									</p>
									</div>
						</div></li>
				</c:forEach>
			</ul>
			<div class="CommentWriter">
				<div  class="comment_inbox">
					<form  method="post" onsubmit="insertCommentForm()">
						<em class="comment_inbox_name">${memberVO.getMemberNickname()}</em>
					<textarea id="commentContent" name="commentContent" placeholder="댓글을 남겨보세요" rows="1" class="comment_inbox_text" style="overflow: hidden; overflow-wrap: break-word; height: 14px;"></textarea>
					<button name="commentbtn" id="commentbtn">등록</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		
		console.log(commentContent);
		function insertCommentForm(){
			let commentContent=document.getElementById("commentContent").innerHTML;
			let xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4&&xhr.status==200){
					
				
				}
		}
			action="${pageContext.request.contextPath}/WriteCommentController.do"
			xhr.open("get","${pageContext.request.contextPath}/WriteCommentController.do?memberNickname="+memberVO.getMemberNickname()+"&");
			xhr.send();
	</script>
</body>
</html>
>>>>>>> refs/heads/controller-board-RegisterMember2-kyr1105
