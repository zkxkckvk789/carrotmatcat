package org.kosta.carrotmatcat.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.MemberVO;
import org.kosta.carrotmatcat.model.PostVO;

public class RecommandStoreByLikesUsingRandomController implements Controller {
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		MemberVO memberVO=(MemberVO) session.getAttribute("memberVO");
		if(memberVO==null) {
			return "carrotmatcat_member/carrotmatcat_login_form.jsp";
		}
		String memberId=memberVO.getMemberId();
		ArrayList<PostVO> postList=BoardDAO.getInstance().findLikesListPostByMemberId(memberId);
		int no=0;
		String articleStoreName=null;
		Long articleNo=0L;
		System.out.println(postList.size());
		if(postList.size()>=1) {
			no=(int) (Math.random()*(postList.size()));
			articleStoreName=postList.get(no).getArticleStoreName();
			articleNo=postList.get(no).getArticleNo();
			request.setAttribute("articleNo", articleNo);
			request.setAttribute("articleStoreName", articleStoreName);			
		} else if(postList.size()==0) {
			postList=BoardDAO.getInstance().findPostList();
			no=(int) (Math.random()*(postList.size()));
			articleStoreName=postList.get(no).getArticleStoreName();
			articleNo=postList.get(no).getArticleNo();
			request.setAttribute("articleNo", articleNo);
			request.setAttribute("articleStoreName", articleStoreName);			
		} 
		request.setAttribute("url", "carrotmatcat_random/carrotmatcat_recommand_store_by_likes_using_random_result.jsp");
		return "carrotmatcat_layout.jsp";
	}
}
