package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.Pagination;

public class FindPostListByFoodOfCafeAndDessertController implements Controller {
		@Override
		public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String pageNo = request.getParameter("pageNo");
			String articleFoodCategory="카페/디저트";
			Pagination pagination = null;
			if (pageNo == null) {
				pagination = new Pagination(BoardDAO.getInstance().getTotalPostCountByFood(articleFoodCategory));
			} else {
				pagination = new Pagination(BoardDAO.getInstance().getTotalPostCountByFood(articleFoodCategory), Integer.parseInt(pageNo));
			} 
			request.setAttribute("postList", BoardDAO.getInstance().findPostListByFood(articleFoodCategory, pagination));
			request.setAttribute("url", "carrotmatcat_board/carrotmatcat_findPostListByFoodOfCafeAndDessert.jsp");
			request.setAttribute("pagination", pagination);
			
			return "carrotmatcat_layout.jsp";
			}
		}

	 
