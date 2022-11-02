package org.kosta.carrotmatcat.model;

public class CommentVO {
	private long commentNo;
	private String commentTimePosted;
	private String commentContent;
	private MemberVO memberVO;
	private PostVO postVO;

	public CommentVO() {
		super();

	}

	// 댓글 등록시 사용할 생성자
	public CommentVO(String commentContent, MemberVO memberVO, PostVO postVO) {
		super();
		this.commentContent = commentContent;
		this.memberVO = memberVO;
		this.postVO = postVO;
	}

	// 댓글 조회시 사용할 생성자
	public CommentVO(long commentNo, String commentTimePosted, String commentContent, MemberVO memberVO,
			PostVO postVO) {
		super();
		this.commentNo = commentNo;
		this.commentTimePosted = commentTimePosted;
		this.commentContent = commentContent;
		this.memberVO = memberVO;
		this.postVO = postVO;
	}
	
	//댓글 수정시 사용할 생성자
	public CommentVO(long commentNo, String commentContent) {
		super();
		this.commentNo = commentNo;
		this.commentContent = commentContent;
	}
	
	public String getCommentTimePosted() {
		return commentTimePosted;
	}

	public void setCommentTimePosted(String commentTimePosted) {
		this.commentTimePosted = commentTimePosted;
	}

	public long getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(long commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public PostVO getPostVO() {
		return postVO;
	}

	public void setPostVO(PostVO postVO) {
		this.postVO = postVO;
	}

	@Override
	public String toString() {
		return "CommentVO [commentTimePosted=" + commentTimePosted + ", commentNo=" + commentNo + ", commentContent="
				+ commentContent + ", memberVO=" + memberVO + ", postVO=" + postVO + "]";
	}

}
