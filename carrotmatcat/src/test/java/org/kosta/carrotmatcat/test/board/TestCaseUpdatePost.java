package org.kosta.carrotmatcat.test.board;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.PostVO;

public class TestCaseUpdatePost {
	public static void main(String[] args) {
		PostVO postVO=new PostVO(2,"조온마아앗","교쿠텐","중식","실험중");
		try {
			BoardDAO.getInstance().updatePost(postVO);
			System.out.println("수정 완");
			System.out.println(BoardDAO.getInstance().viewPostDetailByNo(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
