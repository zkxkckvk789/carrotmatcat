package org.kosta.carrotmatcat.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.Pagination;
import org.kosta.carrotmatcat.model.PostVO;

public class FindPostListByFoodController implements Controller {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNo = request.getParameter("pageNo");
		String koreanFood = request.getParameter("koreanFood");
		String japaneseFood = request.getParameter("japaneseFood");
		String chineseFood = request.getParameter("chineseFood");
		String westernFood = request.getParameter("westernFood");
		String cafeAndDessert = request.getParameter("cafeAndDessert");
		Pagination pagination = null;
		int totalPostCount = 0;
		
		if (request.getParameter("koreanFood").equals("한식")) {
		totalPostCount = BoardDAO.getInstance().findPostListByFood("koreanFood", pagination);
		if(pageNo==null) {
			pagination=new Pagination(totalPostCount);
		} else {
			pagination=new Pagination(totalPostCount,Integer.parseInt(pageNo));			
		}
	 {
			
		} 
		
		return null;
	}

}
