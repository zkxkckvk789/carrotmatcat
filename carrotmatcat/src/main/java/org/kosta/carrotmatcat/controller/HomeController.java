package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.MemberVO;

public class HomeController implements Controller {
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberVO memberVO=(MemberVO) request.getSession().getAttribute("memberVO");
		if(memberVO==null) {
			return "carrotmatcat_member/carrotmatcat_login_form.jsp";
		}
		request.setAttribute("url","carrotmatcat_member/carrotmatcat_login_success.jsp");
		return "carrotmatcat_layout.jsp";
	}
}
