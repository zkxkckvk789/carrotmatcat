package org.kosta.carrotmatcat.test.board;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.BoardDAO;

public class TestCaseUpdateHits {
	public static void main(String[] args) {
		long articleNo=3;
		try {
			BoardDAO.getInstance().updateHits(articleNo);
			System.out.println(BoardDAO.getInstance().viewPostDetailByNo(articleNo));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
