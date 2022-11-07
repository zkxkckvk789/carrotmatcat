package org.kosta.carrotmatcat.test.member.board;

import java.sql.SQLException;
import java.util.ArrayList;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.Pagination;
import org.kosta.carrotmatcat.model.PostVO;

public class TestCaseFindPostListByLikes {
	public static void main(String[] args) {
		try {
			String memberId="yerin0110";
			int totalPostCount=BoardDAO.getInstance().getTotalPostCountByLikes(memberId);
			System.out.println(totalPostCount);
			Pagination pagination=new Pagination(totalPostCount,1);
			ArrayList<PostVO> list=BoardDAO.getInstance().findLikesListPostByMemberId(memberId,pagination);
			for(PostVO postVo:list) {
				System.out.println(postVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}