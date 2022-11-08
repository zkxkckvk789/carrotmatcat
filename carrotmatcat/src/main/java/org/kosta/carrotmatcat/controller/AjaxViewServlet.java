package org.kosta.carrotmatcat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxView")
public class AjaxViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(getServletName());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		// Ajax 응답이므로 필요한 데이터만 클라이언트로 전송하면 된다 
		out.print(request.getAttribute("responsebody"));
		out.close();
	}
}







