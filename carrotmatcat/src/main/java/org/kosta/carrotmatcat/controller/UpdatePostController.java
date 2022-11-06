package org.kosta.carrotmatcat.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.PostVO;

public class UpdatePostController implements Controller {

   @Override
   public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
         if(request.getMethod().equalsIgnoreCase("POST")==false)
            throw new ServletException(getClass().getName()+" post 방식만 서비스 가능");
         
         HttpSession session=request.getSession(false);
         
         String articleTitle=request.getParameter("articleTitle");
         String articlestoreName=request.getParameter("articlestoreName");
         String articleFoodCategory=request.getParameter("articleFoodCategory");
         String aticleContent=request.getParameter("ArticleContent");
         String aticleNo=request.getParameter("ArticleNo");
 
         PostVO postVO=new PostVO();
         postVO.setArticleTitle(articleTitle);
         postVO.setArticleStoreName(articlestoreName);
         postVO.setArticleFoodCategory(articleFoodCategory);
         postVO.setArticleContent(aticleContent);
         postVO.setArticleNo(Long.parseLong(aticleNo));
         
         request.setAttribute("postVO", postVO);
         BoardDAO.getInstance().updatePost(postVO);
         request.setAttribute("url", "carrotmatcat_board/carrotmatcat_viewPostDetailByNo.jsp");
         return "redirect:carrotmatcat_layout";
      }
   }