package org.kosta.carrotmatcat.test.member.comment.likes;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.CommentDAO;
import org.kosta.carrotmatcat.model.CommentVO;
import org.kosta.carrotmatcat.model.MemberVO;
import org.kosta.carrotmatcat.model.PostVO;

public class TestCaseWriteComment {
	public static void main(String[] args) {
		MemberVO memberVO=new MemberVO("javaking",null,"코스타정우성");
		PostVO postVO=new PostVO(1);
		CommentVO commentVO=new CommentVO("좋아요!",memberVO,postVO);
		try {
			CommentDAO.getInstance().writeComment(commentVO);
			System.out.println("댓글 등록!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
