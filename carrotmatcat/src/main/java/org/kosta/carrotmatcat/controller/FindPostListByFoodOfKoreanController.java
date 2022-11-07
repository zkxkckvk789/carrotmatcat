package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.Pagination;

public class FindPostListByFoodOfKoreanController implements Controller {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNo = request.getParameter("pageNo");
		int totalPostCount = 0;
		Pagination pagination = null;
		System.out.println(pageNo + "haha");
		totalPostCount = BoardDAO.getInstance().getTotalPostCountListByFindFoodOfKorean("한식");
		if (pageNo == null) {
			pagination = new Pagination(totalPostCount);
		} else {
			pagination = new Pagination(totalPostCount, Integer.parseInt(pageNo));
		} 
		request.setAttribute("postList", BoardDAO.getInstance().findPostListByFood("한식", pagination));
		request.setAttribute("url", "carrotmatcat_board/carrotmatcat_postList.jsp");
		request.setAttribute("pagination", pagination);
		
		return "carrotmatcat_layout.jsp";
		}
	}

