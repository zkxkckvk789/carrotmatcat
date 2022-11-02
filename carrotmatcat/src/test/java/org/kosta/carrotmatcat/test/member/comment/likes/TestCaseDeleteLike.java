package org.kosta.carrotmatcat.test.member.comment.likes;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.LikesDAO;

public class TestCaseDeleteLike {

	public static void main(String[] args) {
		long articleNo=1;
		String memberId="javaking";
		try {
			LikesDAO.getInstance().deleteLike(articleNo, memberId);
			System.out.println("좋아요 삭제 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
