package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.carrotmatcat.model.BoardDAO;

public class ViewPostDetailByNoController implements Controller{
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long articleNo = Long.parseLong(request.getParameter("articleNo"));
		HttpSession session = request.getSession(false);
		
		request.setAttribute("postDetailView", BoardDAO.getInstance().viewPostDetailByNo(articleNo));
		request.setAttribute("url", "carrotmatcat_board/carrotmatcat_viewPostDetailByNo.jsp");
		return "carrotmatcat_layout.jsp";
	}
}
