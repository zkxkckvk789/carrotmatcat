package org.kosta.carrotmatcat.test.board;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.BoardDAO;

public class TestCaseDeletePostByNo {
	public static void main(String[] args) {
		long articleNo=2;
		try {
			BoardDAO.getInstance().deletePostByNo(articleNo);
			System.out.println(BoardDAO.getInstance().viewPostDetailByNo(articleNo));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
