package org.kosta.carrotmatcat.test.member.comment.likes;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.LikesDAO;

public class TestCaseAddLike {
	public static void main(String[] args) {
		long articleNo=1;
		String memberId="javaking";
		try {
			LikesDAO.getInstance().addLike(articleNo, memberId);
			System.out.println("좋아요 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
