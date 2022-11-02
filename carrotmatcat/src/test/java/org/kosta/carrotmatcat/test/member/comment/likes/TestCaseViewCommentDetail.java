package org.kosta.carrotmatcat.test.member.comment.likes;

import java.sql.SQLException;
import java.util.ArrayList;

import org.kosta.carrotmatcat.model.CommentDAO;
import org.kosta.carrotmatcat.model.CommentVO;

public class TestCaseViewCommentDetail {
	public static void main(String[] args) {
		long articleNo=1;
		try {
			ArrayList<CommentVO> commentList=CommentDAO.getInstance().viewCommentDetail(articleNo);
			for(CommentVO commentVO:commentList) {
				System.out.println(commentVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
