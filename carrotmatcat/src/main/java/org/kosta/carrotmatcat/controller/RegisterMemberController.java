	package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.MemberDAO;
import org.kosta.carrotmatcat.model.MemberVO;

public class RegisterMemberController implements Controller{
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String memberId=request.getParameter("memberId");
		String memberPassword=request.getParameter("memberPassword");
		String memberNickname=request.getParameter("memberNickname");
		MemberDAO.getInstance().registerMember(new MemberVO(memberId, memberPassword, memberNickname));
		//request.setAttribute("url", "carrotmatcat_member/carrotmatcat_login_form.jsp");
		return "carrotmatcat_member/carrotmatcat_login_form.jsp";
	}
}
