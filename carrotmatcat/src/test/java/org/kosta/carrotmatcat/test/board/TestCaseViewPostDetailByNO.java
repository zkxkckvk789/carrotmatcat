package org.kosta.carrotmatcat.test.board;

import org.kosta.carrotmatcat.model.BoardDAO;

public class TestCaseViewPostDetailByNO {
	public static void main(String[] args) {
		long articleNo = 1;
		try {
			System.out.println(BoardDAO.getInstance().viewPostDetailByNo(articleNo));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
