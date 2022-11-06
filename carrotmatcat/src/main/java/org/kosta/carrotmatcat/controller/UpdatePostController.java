package org.kosta.carrotmatcat.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.MemberVO;
import org.kosta.carrotmatcat.model.PostVO;

public class UpdatePostController implements Controller {

   @Override
   public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   HttpSession session=request.getSession(false);
         
	   if(request.getMethod().equalsIgnoreCase("POST")==false)
            throw new ServletException(getClass().getName()+" post 방식만 서비스 가능");
         
         //PostVO postVO=(PostVO) session.getAttribute("postVO");
         
	   String articleNo=request.getParameter("articleNo");
         String articleTitle=request.getParameter("articleTitle");
         String articleStoreName=request.getParameter("articleStoreName");
         String articleFoodCategory=request.getParameter("articleFoodCategory");
         String articleContent=request.getParameter("articleContent");
 
         PostVO postVO=new PostVO();
         postVO.setArticleTitle(articleTitle);
         postVO.setArticleStoreName(articleStoreName);
         postVO.setArticleFoodCategory(articleFoodCategory);
         postVO.setArticleContent(articleContent);
         postVO.setArticleNo(Long.parseLong(articleNo));
         
         
         System.out.println(postVO);
         BoardDAO.getInstance().updatePost(postVO);
         request.setAttribute("postVO", postVO);
         
       
         //request.setAttribute("url","ViewPostDetailByNoController.do?articleNo=40");
         //return "redirect:carrotmatcat_layout.jsp";
         String path="redirect:ViewPostDetailByNoController.do?articleNo="+postVO.getArticleNo();
         
         return path;
      }
   }