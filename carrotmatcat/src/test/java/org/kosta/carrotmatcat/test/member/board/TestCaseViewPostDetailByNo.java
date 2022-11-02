package org.kosta.carrotmatcat.test.member.board;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.BoardDAO;

public class TestCaseViewPostDetailByNo {
	public static void main(String[] args) {
		long articleNo=1;
		try {
			System.out.println(BoardDAO.getInstance().viewPostDetailByNo(articleNo));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
