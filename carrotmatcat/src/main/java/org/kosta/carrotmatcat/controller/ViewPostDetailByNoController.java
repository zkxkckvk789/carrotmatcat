package org.kosta.carrotmatcat.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.CommentDAO;
import org.kosta.carrotmatcat.model.CommentVO;
import org.kosta.carrotmatcat.model.LikesDAO;
import org.kosta.carrotmatcat.model.MemberVO;
import org.kosta.carrotmatcat.model.PostVO;

public class ViewPostDetailByNoController implements Controller{
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return "redirect:index.jsp";
		}
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		
		long articleNo = Long.parseLong(request.getParameter("articleNo"));
		CommentDAO commentDAO = CommentDAO.getInstance();
		ArrayList<CommentVO> commentList= commentDAO.viewCommentDetail(articleNo);
		
		LikesDAO likesDAO = LikesDAO.getInstance();
		long articleLikesCount = likesDAO.likeCount(articleNo);
		
		@SuppressWarnings("unchecked")
		ArrayList<Long> viewPost=(ArrayList<Long>)session.getAttribute("viewPost");
		if(!viewPost.contains(articleNo)) {
			BoardDAO.getInstance().updateHits(articleNo);
			viewPost.add(articleNo);
		}
		
		long likeCount = LikesDAO.getInstance().likeCount(articleNo);
		PostVO postVO= LikesDAO.getInstance().check(memberVO.getMemberId(),articleNo);
		
		request.setAttribute("postVO", postVO);
		request.setAttribute("commentList", commentList);
		request.setAttribute("postDetailView", BoardDAO.getInstance().viewPostDetailByNo(articleNo));
		request.setAttribute("articleLikesCount", articleLikesCount);
		request.setAttribute("url", "carrotmatcat_board/carrotmatcat_viewPostDetailByNo.jsp");
		return "carrotmatcat_layout.jsp";
	}
}
