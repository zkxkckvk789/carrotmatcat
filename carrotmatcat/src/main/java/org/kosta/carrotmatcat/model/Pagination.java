package org.kosta.carrotmatcat.model;
/**
 * 게시판 페이징 처리 로직을 정의한 객체
 *
 */
public class Pagination {
	private int nowPage = 1; //현재 페이지
	private int postCountPerPage=5;//페이지당 게시물수
	private int pageCountPerPageGroup=4;//페이지 그룹당 페이지수
	private int totalPostCount; //총 게시물 수
	
	public Pagination(int totalPostCount) {
		this.totalPostCount = totalPostCount;
	}

	public Pagination(int nowPage, int totalPostCount) {
		super();
		this.nowPage = nowPage;
		this.totalPostCount = totalPostCount;
	}
	
	public int getNowPage() {
		return nowPage;
	}
	
	public int getStartRowNumber() {
		return (this.nowPage-1)*this.postCountPerPage+1;
	}
	
	public int getEndRowNumber() {
		int endRowNumber = this.nowPage*this.postCountPerPage;
		if(this.totalPostCount<endRowNumber)
			endRowNumber=this.totalPostCount;
		return endRowNumber;
	}
	
	public int getTotalPage() {
		int totalPage = totalPostCount/postCountPerPage;
		if(totalPostCount%postCountPerPage!=0)
			totalPage += 1;
		return totalPage;
	}
	
	public int getTotalPageGroup() {
		int totalPageGroup = this.getTotalPage()/pageCountPerPageGroup;
		if(this.getTotalPage()%pageCountPerPageGroup!=0)
			totalPageGroup=this.getTotalPage()/pageCountPerPageGroup+1;
		return totalPageGroup;
	}
	
	public int getNowPageGroup() {
		int nowPageGroup=this.nowPage/this.pageCountPerPageGroup;
		if(nowPage%pageCountPerPageGroup!=0)
			nowPageGroup+=1;
		return nowPageGroup;
	}
	
	public int getStartPageOfPageGroup() {
		return (this.getNowPageGroup() -1)* this.pageCountPerPageGroup +1;
	}
	
	public int getEndPageOfPageGroup() {
		int endPage=this.getNowPageGroup() * this.pageCountPerPageGroup;
		if(this.getTotalPage() < endPage) // 곱한 값이 총 페이지수보다 크면
			endPage = this.getTotalPage();
		return endPage;
	}
	
	public boolean isPreviousPageGroup() {
		boolean flag=false;
		if(this.getNowPageGroup()>1)
			flag=true;
		return flag;
	}
	
	public boolean isNextPageGroup() {
		boolean flag=false;
		if(this.getTotalPageGroup()> this.getNowPageGroup())
			flag=true;
		return flag;
	}
}
