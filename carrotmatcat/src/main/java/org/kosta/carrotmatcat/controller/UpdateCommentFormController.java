package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.CommentVO;

public class UpdateCommentFormController implements Controller {
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long commentNo = Long.parseLong(request.getParameter("commentNo"));
		String commentContent = request.getParameter("commentContent");
		System.out.println(commentNo + commentContent);
		CommentVO commentVO = new CommentVO(commentNo, commentContent);
		// CommentDAO commentDAO = CommentDAO.getInstance();
		// commentDAO.updateComment(commentVO);
		request.setAttribute("responsebody", commentVO);
		return "AjaxView";
	}

}
