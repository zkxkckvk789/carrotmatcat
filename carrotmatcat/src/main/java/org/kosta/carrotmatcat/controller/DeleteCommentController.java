package org.kosta.carrotmatcat.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.CommentDAO;

public class DeleteCommentController implements Controller{
	
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long commentNo = Long.parseLong(request.getParameter("commentNo"));
		CommentDAO commentDAO = CommentDAO.getInstance();
		commentDAO.deleteComment(commentNo);
		request.setAttribute("responsebody", "ok");
		return "AjaxView";
	}
}
