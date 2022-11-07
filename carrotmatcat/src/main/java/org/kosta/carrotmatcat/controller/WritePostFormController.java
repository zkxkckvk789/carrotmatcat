package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WritePostFormController implements Controller {
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("url","carrotmatcat_board/carrotmatcat_write_post_form.jsp");
		return "carrotmatcat_layout.jsp";
	}
}
