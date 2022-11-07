package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.Pagination;

public class SearchController implements Controller {
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNo=request.getParameter("pageNo");
		String searchCategory=request.getParameter("searchCategory");
		String searchContent = request.getParameter("searchContent");
		int totalPostCount=0;	
		Pagination pagination=null;
		
		if(request.getParameter("searchCategory").equals("제목")){
			totalPostCount=BoardDAO.getInstance().getTotalPostCountBySearchTitle(request.getParameter("searchContent"));
			if(pageNo==null) {
				pagination=new Pagination(totalPostCount);	
			} else {
				pagination=new Pagination(totalPostCount,Integer.parseInt(pageNo));	
			}
			request.setAttribute("postList", BoardDAO.getInstance().searchStoreListByTitle(request.getParameter("searchContent"),pagination));
		} else if(request.getParameter("searchCategory").equals("내용")) {
			totalPostCount=BoardDAO.getInstance().getTotalPostCountBySearchContent(request.getParameter("searchContent"));
			System.out.println(totalPostCount);
			if(pageNo==null) {
				pagination=new Pagination(totalPostCount);	
			} else {
				pagination=new Pagination(totalPostCount,Integer.parseInt(pageNo));	
			}
			request.setAttribute("postList", BoardDAO.getInstance().searchStoreListByContent(request.getParameter("searchContent"),pagination));
		}
		
		request.setAttribute("pagination", pagination);
		request.setAttribute("searchCategory", searchCategory);
		request.setAttribute("searchContent", searchContent);
		request.setAttribute("url", "carrotmatcat_board/carrotmatcat_searchPostList.jsp");
		return "carrotmatcat_layout.jsp";
	}
}
