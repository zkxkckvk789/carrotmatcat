package org.kosta.carrotmatcat.test.board;

import java.util.ArrayList;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.Pagination;
import org.kosta.carrotmatcat.model.PostVO;

public class TestCasefindPostList {
	public static void main(String[] args) {
		ArrayList<PostVO> list;
		try {
			Pagination pagination = new Pagination(BoardDAO.getInstance().getTotalPostCount(), 1);
			System.out.println(BoardDAO.getInstance().getTotalPostCount());
			list = BoardDAO.getInstance().findPostList(); 			
			for(PostVO post:list) {
				System.out.println(post); 			
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
