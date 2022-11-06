package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.carrotmatcat.model.MemberDAO;
import org.kosta.carrotmatcat.model.MemberVO;

public class UpdateMemberController implements Controller {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
		
		
		String memberId=request.getParameter("memberId");
		String memberPassword=request.getParameter("memberPassword");
		String memberNickname=request.getParameter("memberNickname");
		
		memberVO.setMemberId(memberId);
		memberVO.setMemberPassword(memberPassword);
		memberVO.setMemberNickname(memberNickname);
		
		MemberDAO.getInstance().updateMember(memberVO);	
		
		//session.setAttribute("memberVO", memberVO);
		request.setAttribute("url", "mypage.jsp");
		return "carrotmatcat_layout.jsp";
	}

}




