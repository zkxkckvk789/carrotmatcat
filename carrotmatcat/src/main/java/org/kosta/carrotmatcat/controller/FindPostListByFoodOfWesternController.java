package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.Pagination;

public class FindPostListByFoodOfWesternController implements Controller {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNo = request.getParameter("pageNo");
		Pagination pagination = null;
		if (pageNo == null) {
			pagination = new Pagination(BoardDAO.getInstance().getTotalPostCount());
		} else {
			pagination = new Pagination(BoardDAO.getInstance().getTotalPostCount(), Integer.parseInt(request.getParameter(pageNo)));
		} 
		request.setAttribute("postList", BoardDAO.getInstance().findPostListByFood("양식", pagination));
		request.setAttribute("url", "carrotmatcat_board/carrotmatcat_postList.jsp");
		request.setAttribute("pagination", pagination);
		
		return "carrotmatcat_layout.jsp";
		}
	}

