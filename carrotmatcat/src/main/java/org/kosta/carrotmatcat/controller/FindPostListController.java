package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.Pagination;

public class FindPostListController implements Controller {
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO boardDAO=BoardDAO.getInstance();
		String pageNo=request.getParameter("pageNo");
		Pagination pagination=null;
		int totalPostCount=boardDAO.getTotalPostCount();
		if(pageNo==null) {
			pagination=new Pagination(totalPostCount);
		} else {
			pagination=new Pagination(totalPostCount,Integer.parseInt(pageNo));			
		}
		request.setAttribute("postList", boardDAO.findPostList(pagination));
		request.setAttribute("pagination", pagination);
		request.setAttribute("url", "carrotmatcat_board/carrotmatcat_postList.jsp");
		return "carrotmatcat_layout.jsp";
	}
}
