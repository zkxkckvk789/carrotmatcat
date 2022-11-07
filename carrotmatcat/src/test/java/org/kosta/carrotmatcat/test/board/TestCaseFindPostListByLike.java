package org.kosta.carrotmatcat.test.board;

import java.sql.SQLException;
import java.util.ArrayList;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.Pagination;
import org.kosta.carrotmatcat.model.PostVO;

public class TestCaseFindPostListByLike {
	public static void main(String[] args) {
		String memberId="yerin0110";
		try {
			Pagination p=new Pagination(BoardDAO.getInstance().getTotalPostCountByLikes(memberId),1);
			ArrayList<PostVO>list=BoardDAO.getInstance().findLikesListPostByMemberId(memberId,p);
			for(PostVO postVO:list) {
				System.out.println(postVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
