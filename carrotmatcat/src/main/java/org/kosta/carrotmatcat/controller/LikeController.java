package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.carrotmatcat.model.LikesDAO;
import org.kosta.carrotmatcat.model.MemberVO;
import org.kosta.carrotmatcat.model.PostVO;

public class LikeController implements Controller {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(false);
		if(session==null||request.getMethod().equalsIgnoreCase("POST")==false) {
			System.out.println("세션 없음");
			return "redirect:index.jsp";
		}
		
		MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
		String memberId = memberVO.getMemberId();
		memberId=request.getParameter("memberId");
		long articleNo=Long.parseLong(request.getParameter("articleNo"));
		
		PostVO postVO=LikesDAO.getInstance().check(memberId, articleNo);
		if(postVO==null) {
			LikesDAO.getInstance().addLike(articleNo,memberId);
		}else {
			LikesDAO.getInstance().deleteLike(articleNo,memberId);
		}
		long likeCount = LikesDAO.getInstance().likeCount(articleNo);
		System.out.println(postVO);
		System.out.println("총 좋아요 수"+likeCount);
		
		request.setAttribute("responsebody", likeCount);
		return "AjaxView";
	}

}
