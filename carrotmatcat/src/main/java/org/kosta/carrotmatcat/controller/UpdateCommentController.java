package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.CommentDAO;
import org.kosta.carrotmatcat.model.CommentVO;

public class UpdateCommentController implements Controller{
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long commentNo = Long.parseLong(request.getParameter("comment_No"));
		String commentContent = request.getParameter("comment_update_content");
		CommentVO commentVO=new CommentVO(commentNo,commentContent);
		CommentDAO commentDAO = CommentDAO.getInstance();
		commentDAO.updateComment(commentVO);
		request.setAttribute("responsebody", "ok");
		return "AjaxView";
	}	
}
