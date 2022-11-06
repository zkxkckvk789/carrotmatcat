package org.kosta.carrotmatcat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecommandStoreByLikesUsingRandomFormController implements Controller {
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("url", "carrotmatcat_random/carrotmatcat_recommand_store_by_likes_using_random_form.jsp");
		return "carrotmatcat_layout.jsp";
	}

}
