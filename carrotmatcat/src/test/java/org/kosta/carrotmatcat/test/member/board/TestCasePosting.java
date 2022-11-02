package org.kosta.carrotmatcat.test.member.board;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.MemberVO;
import org.kosta.carrotmatcat.model.PostVO;

public class TestCasePosting {
	public static void main(String[] args) {
		MemberVO memberVO=new MemberVO("javaking",null,"코스타정우성");
		PostVO postVO=new PostVO("깨돌이 어떠세요","깨돌이김밥","한식","존맛",memberVO);
		try {
			BoardDAO.getInstance().posting(postVO);
			System.out.println("게시글등록성공"+postVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
