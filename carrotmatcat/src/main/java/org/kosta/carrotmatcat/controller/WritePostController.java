package org.kosta.carrotmatcat.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.MemberVO;
import org.kosta.carrotmatcat.model.PostVO;

public class WritePostController implements Controller {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("POST")==false) {
			throw new ServletException("WritePostController는 POST방식만 가능합니다.");
		}
		HttpSession session=request.getSession(false);
		MemberVO memberVO=(MemberVO) session.getAttribute("memberVO");
		PostVO postVO=new PostVO();
		postVO.setArticleTitle(request.getParameter("articleTitle"));
		postVO.setArticleStoreName(request.getParameter("articleStoreName"));
		postVO.setArticleFoodCategory(request.getParameter("articleFoodCategory"));
		postVO.setArticleContent(request.getParameter("articleContent"));
		System.out.println(postVO);
		postVO.setMemberVO(memberVO);
		BoardDAO.getInstance().posting(postVO);
		return "redirect:FindPostListController.do";
	}
}
