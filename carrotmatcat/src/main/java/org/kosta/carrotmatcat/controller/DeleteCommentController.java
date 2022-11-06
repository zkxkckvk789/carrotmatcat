package org.kosta.carrotmatcat.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.CommentDAO;

public class DeleteCommentController implements Controller{
	
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equalsIgnoreCase("POST") == false) {
			throw new ServletException(getClass().getName() + " post 방식만 서비스 가능합니다.");
		}
		String articleNo = request.getParameter("articleNo");
		String commentNo = request.getParameter("commentNo");
		CommentDAO commentDAO = CommentDAO.getInstance();
		commentDAO.deleteComment(Long.parseLong(commentNo));
		return "ViewPostDetailByNoController.do?articleNo="+articleNo;
	}
}
