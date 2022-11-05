package org.kosta.carrotmatcat.controller;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.carrotmatcat.model.MemberDAO;
import org.kosta.carrotmatcat.model.MemberVO;

public class LoginController implements Controller {
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("POST")==false) {
			throw new ServletException("LoginController는 POST방식만 가능합니다.");
		}
		String path=null;
		String memberId=request.getParameter("memberId");
		String memberPassword=request.getParameter("memberPassword");
		MemberVO memberVO=MemberDAO.getInstance().login(memberId,memberPassword);
		if(memberVO!=null) {
			ArrayList<Long> viewPost=new ArrayList<>();
			HttpSession session=request.getSession();
			session.setAttribute("memberVO", memberVO);
			session.setAttribute("viewPost",viewPost);
			path="redirect:HomeController.do";
		} else {
			System.out.println("로그인 실패");
			path="redirect:carrotmatcat_member/carrotmatcat_login_fail.jsp";
		}
		return path;
	}
}
