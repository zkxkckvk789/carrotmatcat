package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.CommentDAO;
import org.kosta.carrotmatcat.model.CommentVO;
import org.kosta.carrotmatcat.model.MemberVO;
import org.kosta.carrotmatcat.model.PostVO;

public class WriteCommentController implements Controller{
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String commentContent = request.getParameter("commentContent");
		long articleNo = Long.parseLong(request.getParameter("articleNo"));
		String memberId = request.getParameter("memberId");
		CommentVO commentVO = new CommentVO();
		commentVO.setCommentContent(commentContent);
		commentVO.setMemberVO(new MemberVO(memberId));
		commentVO.setPostVO(new PostVO(articleNo));
			
		CommentDAO commentDAO = CommentDAO.getInstance();
		commentDAO.writeComment(commentVO);
		request.setAttribute("responsebody", "ok");
		//request.setAttribute("url", "ViewPostDetailByNoController.do?articleNo="+articleNo);
		//return "carrotmatcat_board/carrotmatcat_layout.jsp";
		return "AjaxView";
	}
}
