package org.kosta.carrotmatcat.test.member.comment.likes;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.MemberDAO;
import org.kosta.carrotmatcat.model.MemberVO;

public class TestCaseUpdateMember {
	public static void main(String[] args) {
		String memberId="hasense9410";
		String memberPassword="babbab";
		String memberNickname="하세엔세";
		MemberVO memberVO=new MemberVO(memberId,memberPassword,memberNickname);
		try {
			MemberDAO.getInstance().updateMember(memberVO);
			System.out.println("수정완료!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
