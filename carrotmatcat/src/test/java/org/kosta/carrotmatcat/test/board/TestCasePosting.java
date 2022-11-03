package org.kosta.carrotmatcat.test.board;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.MemberVO;
import org.kosta.carrotmatcat.model.PostVO;

public class TestCasePosting {
	public static void main(String[] args) {
		String articleTitle="깨돌이 어떠세요";
		String articleContent = "나쁘지않더라고요";
		String articleFoodCategory = "한식";
		String articleStoreName = "깨돌이김밥";
		MemberVO memberVO = new MemberVO("javaking");
		
		try {
			BoardDAO.getInstance().posting(new PostVO(articleTitle, articleStoreName, articleFoodCategory, articleContent, memberVO));
			System.out.println("등록완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
