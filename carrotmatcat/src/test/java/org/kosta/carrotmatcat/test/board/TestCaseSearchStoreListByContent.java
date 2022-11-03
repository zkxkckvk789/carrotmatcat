package org.kosta.carrotmatcat.test.board;

import java.sql.SQLException;
import java.util.ArrayList;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.Pagination;
import org.kosta.carrotmatcat.model.PostVO;

public class TestCaseSearchStoreListByContent {
	public static void main(String[] args) {
		String articleContent="입니다";
		try {
			Pagination pagination= new Pagination(BoardDAO.getInstance().getTotalPostCount(),1);
			ArrayList<PostVO> list=BoardDAO.getInstance().searchStoreListByContent(articleContent, pagination);
			for(PostVO postVO:list) {
				System.out.println(postVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
