package org.kosta.carrotmatcat.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.CommentDAO;
import org.kosta.carrotmatcat.model.CommentVO;

public class ViewPostDetailByNoController implements Controller{
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long articleNo = Long.parseLong(request.getParameter("articleNo"));
		CommentDAO commentDAO = CommentDAO.getInstance();
		ArrayList<CommentVO> commentList= commentDAO.viewCommentDetail(articleNo);
		
		request.setAttribute("commentList", commentList);
		request.setAttribute("postDetailView", BoardDAO.getInstance().viewPostDetailByNo(articleNo));
		request.setAttribute("url", "carrotmatcat_board/carrotmatcat_viewPostDetailByNo.jsp");
		return "carrotmatcat_layout.jsp";
	}
}
