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
	padding-left:100px;
	padding-right:100px;
}	
/* .preTag{
	-ms-overflow-style: none; /* IE and Edge */
    scrollbar-width: none; /* Firefox */
    width: 80vw; 
    overflow:scroll; 
    white-space: pre-wrap;
} */

.preTag::-webkit-scrollbar {
    display: none; /* Chrome, Safari, Opera*/
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
				document.getElementById("likeView").innerHTML="<input type='image' id='yes' src='carrotmatcat_images/yes.png' onclick='like(true)' style='width:30px;'>";
			}else{
				document.getElementById("likeView").innerHTML="<input type='image' id='no' src='carrotmatcat_images/no.png' onclick='like(false)' style='width:30px;'>";
			}
			document.getElementById("like_result").innerHTML=xhr.responseText;
			
		}//if
	}//callback
</script>
	<div class="container pt-3" style="">
			<form>
				<input type="hidden" id="articleNo" name="articleNo" value="${postDetailView.articleNo}">
			</form>
		<table class="table table " style="border-collapse:collapse; border-radius:8px; ">
		<thead>
		<tr style="text-align: left; color: white; border-bottom:dashed;  font-size: 2em; ">
			<th class="no">${postDetailView.articleFoodCategory}</th>
		</tr>
		<tr style="font-size: 1.1em; color: #aac414; background-color: white;">
			<th style="width: 40%">${postDetailView.articleTitle}</th>
			<th style="width: 20%">${postDetailView.articleStoreName}</th>
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
							<input type="image" id="no" src="carrotmatcat_images/no.png" onclick="like(false)" style="width:30px;">
						</c:when>
						<c:otherwise>
							<input type="image" id="yes" src="carrotmatcat_images/yes.png" onclick="like(true)" style="width:30px;">
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
					<pre class="preTag" style="white-space: pre-wrap; "><font size="4">${postDetailView.articleContent}</font></pre>
				</td>
			</tr>
			<c:if test="${postDetailView.memberVO.getMemberNickname()==memberVO.getMemberNickname()}">
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
	<div class="comment_option">
		<h3 class="comment_title" style=" width:80vw; color:white;">댓글</h3>
	</div>
	 <section class="mb-5">
                        <div class="card bg-light">
                            <div class="card-body" style="background-color: white;">
                                <c:forEach items="${commentList}" var="clist">
                                		<div class="d-flex">
                                    		<div class="flex-shrink-0"><img src="carrotmatcat_images/carrotmatat_logo.png" alt="..." style="width:30px"/></div>
                                    		<div class="ms-3">
                                        			<div class="fw-bold">
                                       				 <a href="#" role="button" class="comment_nickname" id="comment_nickname"> ${clist.memberVO.getMemberNickname() }</a>
                                        			</div>
                                        <c:choose>
											<c:when test="${sessionScope.memberVO.getMemberNickname()==clist.memberVO.getMemberNickname()}">
												<form id="modifyCommentForm" action="UpdateCommentController.do" method="post">
													<input type="hidden" name="commentNo" id="commentNo" value="${clist.commentNo}">
												</form>
												<form id="deleteCommentForm" action="DeleteCommentController.do" method="post">
													<input type="hidden" name="commentNo" value="${clist.commentNo}">
												</form>
														${clist.commentContent}<br>
														<span class="comment_info_date">${clist.commentTimePosted }</span>
													<button type="button" onclick="updateCommentForm(${clist.commentNo})" style="color: gray; background-color: white; border: 1px solid white; border-radius: 20px;">댓글 수정</button>
													<button type="button" onclick="deleteComment()" style="color: gray; background-color: white; border: 2px solid white; border-radius: 20px;">댓글 삭제</button>
														<div id="commentUpdateZone${clist.commentNo}" style="display: none;">
															<input type="hidden" id="comment_No${clist.commentNo}" value="${clist.commentNo}">
															<textarea class="" id="comment_update_content${clist.commentNo}" rows="3" style="width:60vw">${clist.commentContent}</textarea><br>
															<button name="commentupdatebtn" id="commentupdatebtn" class="btn btn-warning" onclick="updateComment(${clist.commentNo})" style=" color: white; margin-left:52vw; background-color: #ef7b35; border-color: #ef7b35; ">수정</button>
															<button name="commentupdatebtn_no" id="commentupdatebtn_no" class="btn btn-warning" onclick="commentUpdateZoneHide(${clist.commentNo})" style=" color: white; background-color: #ef7b35; border-color: #ef7b35;">취소</button>
														</div>
															<%--<hr align="center" style="border: solid 1px gray; width: 50%;"> --%>
										</c:when>
										<c:otherwise>
											${clist.commentContent}
                                    			<br><span class="comment_info_date">${clist.commentTimePosted }</span>
                                   	 	</c:otherwise>
                                    	</c:choose>
                                    		<hr style="width:65vw"></div>
                                		</div>   
                               	</c:forEach>
                               	<hr>
                               	 <!-- Comment form-->
                                		<em class="comment_inbox_name" id="comment_inbox_name">${memberVO.getMemberNickname()}</em>
                                		<textarea class="form-control" id="commentContent" rows="3" placeholder="댓글을 등록하세요!"></textarea><br>
                                		<button name="commentbtn" id="commentbtn" onclick="insertComment()" class="btn btn-warning" style=" color: white; margin-left:90%; background-color: #ef7b35; border-color: #ef7b35; ">등록</button>
									<input name="memberId" id="memberId" type="hidden" value="${sessionScope.memberVO.getMemberId()}" />
                            </div>
                        </div>
                    </section><br><br>
                    <a href="javascript:history.back();" style="margin-left:45%; font-size: 1.2rem; text-decoration: none;">목록으로 돌아가기</a><br><br><br><br>
                    </div>
<script type="text/javascript">
function updateCommentForm(commentNum) {
	document.getElementById("commentUpdateZone"+commentNum).style.display="";
}

function commentUpdateZoneHide(commentNum){
	document.getElementById("commentUpdateZone"+commentNum).style.display="none";
}

function updateComment(commentNum) {
	let result = confirm("수정 하시겠습니까?");
	if (result) {
		let commentNo = document.getElementById("comment_No"+commentNum).value;
		let commentContent = document.getElementById("comment_update_content"+commentNum).value;
		console.log(commentNo,commentContent);
		if(commentContent.trim()<1){
			alert("공백 등록은 불가능합니다");
			event.preventDefault();
		} else{
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() { //->  xhr의 변경을 감지할 때	
			if (xhr.readyState == 4 && xhr.status == 200) {
				if(xhr.responseText=="ok"){
					document.getElementById("commentUpdateZone"+commentNo).style.display="none";
					window.location.reload();
				}
			}
	}
		xhr.open("post","${pageContext.request.contextPath}/UpdateCommentController.do", true);
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=euc-kr');
		xhr.send("comment_No="+commentNo+"&comment_update_content="+commentContent);
	}
		}
}

	function insertComment() {
		let articleNo = document.getElementById("articleNo").value;
		let memberNickname = document.getElementById("comment_inbox_name").innerHTML;
		let commentContent = document.getElementById("commentContent").value;
		console.log(articleNo, memberNickname,commentContent);
		let memberId = document.getElementById("memberId").value;
		if(commentContent.trim()<1){
			alert("공백 등록은 불가능합니다");
			event.preventDefault();
		} else{
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
</script>
