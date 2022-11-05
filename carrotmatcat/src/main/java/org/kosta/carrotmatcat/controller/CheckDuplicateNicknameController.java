package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.carrotmatcat.model.MemberDAO;

public class CheckDuplicateNicknameController implements Controller{
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String memberNickname = request.getParameter("memberNickname");
		System.out.println("hi hello");
		boolean result=MemberDAO.getInstance().checkDuplicateNickname(memberNickname);
		String message = null;
		if(result) // id가 중복된다는 의미 
			message="fail";
		else // id가 중복되지 않아 사용할 수 있다는 의미 
			message="ok";
		request.setAttribute("responsebody", message);
		return "AjaxView";
			
	}
}
