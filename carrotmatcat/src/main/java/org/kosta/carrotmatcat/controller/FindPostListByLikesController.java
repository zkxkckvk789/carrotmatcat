package org.kosta.carrotmatcat.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.MemberVO;
import org.kosta.carrotmatcat.model.Pagination;
import org.kosta.carrotmatcat.model.PostVO;

public class FindPostListByLikesController implements Controller {
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		String pageNo=request.getParameter("pageNo");
		MemberVO memberVO=(MemberVO) session.getAttribute("memberVO");
		String memberId=memberVO.getMemberId();
		Pagination pagination=null;
		int totalPostCount=BoardDAO.getInstance().getTotalPostCountByLikes(memberId);
		if(pageNo==null) {
			pagination=new Pagination(totalPostCount);
		} else {
			pagination=new Pagination(totalPostCount,Integer.parseInt(pageNo));
		}
		ArrayList<PostVO> postList=BoardDAO.getInstance().findLikesListPostByMemberId(memberId, pagination);
		request.setAttribute("postList", postList);
		request.setAttribute("pagination", pagination);
		request.setAttribute("url", "carrotmatcat_board/carrotmatcat_postListByLikes.jsp");
		return "carrotmatcat_layout.jsp";
	}

}
