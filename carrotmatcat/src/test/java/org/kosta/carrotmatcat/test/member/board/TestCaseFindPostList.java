package org.kosta.carrotmatcat.test.member.board;

import java.sql.SQLException;
import java.util.ArrayList;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.Pagination;
import org.kosta.carrotmatcat.model.PostVO;

public class TestCaseFindPostList {
	public static void main(String[] args) {
		try {
			int totalPostCount = BoardDAO.getInstance().getTotalPostCount();
			Pagination pagination=new Pagination(totalPostCount,1);
			ArrayList<PostVO> list=BoardDAO.getInstance().findPostList(pagination);
			for(PostVO postVO:list) {
				System.out.println(postVO);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
