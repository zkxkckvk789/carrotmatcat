package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.PostVO;

public class UpdatePostFormController implements Controller {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession(false);
		/*
		if(session==null||session.getAttribute("postVO")==null||
				request.getMethod().equals("POST")==false){
			return "redirect:index.jsp";
		}
		*/
		Long articleNo=Long.parseLong(request.getParameter("articleNo"));
		PostVO postVO=BoardDAO.getInstance().viewPostDetailByNo(articleNo);
		request.setAttribute("postVO", postVO);
		
		request.setAttribute("url","carrotmatcat_board/carrotmatcat_update_post_form.jsp");
	      return "carrotmatcat_layout.jsp";
	}

}
