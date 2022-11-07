package org.kosta.carrotmatcat.test.board;

import java.sql.SQLException;
import java.util.ArrayList;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.Pagination;
import org.kosta.carrotmatcat.model.PostVO;

public class TestCaseFindPostListByFood {
	public static void main(String[] args) {
		String articleFoodCategory="양식";
		try {
			Pagination pagination=new Pagination(BoardDAO.getInstance().getTotalPostCount(), 2);
			ArrayList<PostVO>list = BoardDAO.getInstance().findPostListByFood(articleFoodCategory, pagination);
			for(PostVO postVO:list) {
				System.out.println(postVO);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

