package org.kosta.carrotmatcat.test.member.comment.likes;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.CommentDAO;
import org.kosta.carrotmatcat.model.CommentVO;

public class TestCaseUpdateComment {
	public static void main(String[] args) {
		CommentVO commentVO=new CommentVO(1,"좋습니다요!");
		try {
			CommentDAO.getInstance().updateComment(commentVO);
			System.out.println("댓글수정 완료!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
