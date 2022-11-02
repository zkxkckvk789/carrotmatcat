package org.kosta.carrotmatcat.test.member.comment.likes;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.CommentDAO;

public class TestCaseDeleteComment {
	public static void main(String[] args) {
		long commentNo=1;
		try {
			CommentDAO.getInstance().deleteComment(commentNo);
			System.out.println("댓삭완료!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
