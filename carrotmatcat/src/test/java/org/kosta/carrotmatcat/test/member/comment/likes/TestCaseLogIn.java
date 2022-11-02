package org.kosta.carrotmatcat.test.member.comment.likes;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.MemberDAO;
import org.kosta.carrotmatcat.model.MemberVO;

public class TestCaseLogIn {
	public static void main(String[] args) {
		String memberId="hasense9410";
		String memberPassword="babbab";
		try {
			MemberVO memberVO=MemberDAO.getInstance().login(memberId, memberPassword);
			System.out.println("로그인 가능?"+memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
