package org.kosta.carrotmatcat.test.board;

import java.sql.SQLException;
import java.util.ArrayList;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.Pagination;
import org.kosta.carrotmatcat.model.PostVO;

public class TestCaseSearchStoreListByTitle {
	public static void main(String[] args) {
		String articleTitle="먹었어요";
		try {
			Pagination pagination=new Pagination(BoardDAO.getInstance().getTotalPostCount(),1);
			ArrayList<PostVO> list=BoardDAO.getInstance().searchStoreListByTitle(articleTitle, pagination);
			for(PostVO postVO:list) {
				System.out.println(postVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
