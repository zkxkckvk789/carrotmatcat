package org.kosta.carrotmatcat.test.board;

import java.sql.SQLException;
import java.util.ArrayList;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.PostVO;

public class TestCaseGet {
	public static void main(String[] args) {
		String memberId="yerin0110";
		try {
			ArrayList<Long>list1 = BoardDAO.getInstance().getLikedPostByMemberId(memberId);
			ArrayList<PostVO>list2=BoardDAO.getInstance().findLikesListPostByMemberId(memberId,list1);
			for(PostVO postVO:list2) {
				System.out.println(postVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
