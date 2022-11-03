package org.kosta.carrotmatcat.test.member.comment.likes;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.LikesDAO;

public class TestCaseLikeCount {
	public static void main(String[] args) {
		long articleNo=1;
		try {
			System.out.println(LikesDAO.getInstance().likeCount(articleNo));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
