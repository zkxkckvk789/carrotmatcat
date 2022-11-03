package org.kosta.carrotmatcat.model;

public class PostVO {
	private long articleNo;
	private String articleTitle;
	private String articleStoreName;
	private String articleFoodCategory;
	private String articleContent;
	private long articleHits;
	private String articleTimePosted;
	private MemberVO memberVO;

	public PostVO() {
		super();

	}

	// 게시글 등록시 사용할 생성자
	public PostVO(String articleTitle, String articleStoreName, String articleFoodCategory, String articleContent,
			MemberVO memberVO) {
		super();
		this.articleTitle = articleTitle;
		this.articleStoreName = articleStoreName;
		this.articleFoodCategory = articleFoodCategory;
		this.articleContent = articleContent;
		this.memberVO = memberVO;
	}
	
	//게시글 수정시 사용할 생성자
	public PostVO(long articleNo, String articleTitle, String articleStoreName, String articleFoodCategory,
			String articleContent) {
		super();
		this.articleNo = articleNo;
		this.articleTitle = articleTitle;
		this.articleStoreName = articleStoreName;
		this.articleFoodCategory = articleFoodCategory;
		this.articleContent = articleContent;
	}
	

	//댓글등록시 사용할 생성자
	public PostVO(long articleNo) {
		super();
		this.articleNo = articleNo;
	}



	// 게시글 리스트 조회시 사용할 생성자
	public PostVO(long articleNo, String articleTitle, String articleStoreName, long articleHits,
			String articleTimePosted, MemberVO memberVO) {
		super();
		this.articleNo = articleNo;
		this.articleTitle = articleTitle;
		this.articleStoreName = articleStoreName;
		this.articleHits = articleHits;
		this.articleTimePosted = articleTimePosted;
		this.memberVO = memberVO;
	}

	// 상세글보기
	public PostVO(long articleNo, String articleTitle, String articleStoreName, String articleFoodCategory,
			String articleContent, long articleHits, String articleTimePosted, MemberVO memberVO) {
		super();
		this.articleNo = articleNo;
		this.articleTitle = articleTitle;
		this.articleStoreName = articleStoreName;
		this.articleFoodCategory = articleFoodCategory;
		this.articleContent = articleContent;
		this.articleHits = articleHits;
		this.articleTimePosted = articleTimePosted;
		this.memberVO = memberVO;
	}

	// 랜덤 맛집 추천시 가게 이름 출력
	public PostVO(String articleStoreName) {
		super();
		this.articleStoreName = articleStoreName;
	}

	public long getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(long articleNo) {
		this.articleNo = articleNo;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleStoreName() {
		return articleStoreName;
	}

	public void setArticleStoreName(String articleStoreName) {
		this.articleStoreName = articleStoreName;
	}

	public String getArticleFoodCategory() {
		return articleFoodCategory;
	}

	public void setArticleFoodCategory(String articleFoodCategory) {
		this.articleFoodCategory = articleFoodCategory;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public long getArticleHits() {
		return articleHits;
	}

	public void setArticleHits(long articleHits) {
		this.articleHits = articleHits;
	}

	public String getArticleTimePosted() {
		return articleTimePosted;
	}

	public void setArticleTimePosted(String articleTimePosted) {
		this.articleTimePosted = articleTimePosted;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	@Override
	public String toString() {
		return "PostVO [articleNo=" + articleNo + ", articleTitle=" + articleTitle + ", articleStoreName="
				+ articleStoreName + ", articleFoodCategory=" + articleFoodCategory + ", articleContent="
				+ articleContent + ", articleHits=" + articleHits + ", articleTimePosted=" + articleTimePosted
				+ ", memberVO=" + memberVO + "]";
	}

}
