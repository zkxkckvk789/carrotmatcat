package org.kosta.carrotmatcat.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.CommentDAO;
import org.kosta.carrotmatcat.model.CommentVO;

public class ViewPostDetailByNoController implements Controller{
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long articleNo = Long.parseLong(request.getParameter("articleNo"));
		
		//System.out.println("12345");
		CommentDAO commentDAO = CommentDAO.getInstance();
		ArrayList<CommentVO> commentList= commentDAO.viewCommentDetail(articleNo);
		
		HttpSession session = request.getSession(false);
		@SuppressWarnings("unchecked")
		ArrayList<Long> viewPost=(ArrayList<Long>)session.getAttribute("viewPost");
		if(!viewPost.contains(articleNo)) {
			BoardDAO.getInstance().updateHits(articleNo);
			viewPost.add(articleNo);
		}
		
		request.setAttribute("commentList", commentList);
		request.setAttribute("postDetailView", BoardDAO.getInstance().viewPostDetailByNo(articleNo));
		
		request.setAttribute("url", "carrotmatcat_board/carrotmatcat_viewPostDetailByNo.jsp");
		return "carrotmatcat_layout.jsp";
	}
}
