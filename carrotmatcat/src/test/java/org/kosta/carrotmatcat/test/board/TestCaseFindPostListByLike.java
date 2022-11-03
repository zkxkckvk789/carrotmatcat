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
			ArrayList<Long>list1 = BoardDAO.getInstance().getLikedPostByMemberId(memberId);
			ArrayList<PostVO>list2=BoardDAO.getInstance().findLikesListPostByMemberId(memberId,list1);
			int size=list2.size();
			System.out.println(size);
			Pagination p=new Pagination(size);
			System.out.println(BoardDAO.getInstance().findPostList(list2,p));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
