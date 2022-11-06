package org.kosta.carrotmatcat.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.BoardDAO;

public class DeletePostController implements Controller {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("POST")==false)
			throw new ServletException(getClass().getName()+" post방식만 서비스 가능합니다.");

		Long articleNo = Long.parseLong(request.getParameter("articleNo"));
		BoardDAO.getInstance().deletePostByNo(articleNo);
		
		//request.setAttribute("url", "FindPostListController.do");
		return "redirect:FindPostListController.do";
	}

}
