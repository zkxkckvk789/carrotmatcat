package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.Pagination;

public class FindPostListByFoodController implements Controller {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO boardDAO = BoardDAO.getInstance(); 
		String koreanFood = request.getParameter("koreanFood");
		String japaneseFood = request.getParameter("japaneseFood");
		String chineseFood = request.getParameter("chineseFood");
		String westernFood = request.getParameter("westernFood");
		String cafeAndDessert = request.getParameter("cafeAndDessert");
		Pagination pagination = null;
		
		if (request.getParameter("koreanFood").equals("한식")) {
			
		} 
		
		return null;
	}

}
