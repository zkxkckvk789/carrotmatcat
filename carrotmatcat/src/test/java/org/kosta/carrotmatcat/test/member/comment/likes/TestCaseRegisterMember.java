package org.kosta.carrotmatcat.test.member.comment.likes;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.MemberDAO;
import org.kosta.carrotmatcat.model.MemberVO;

public class TestCaseRegisterMember {
	public static void main(String[] args) {
		String memberId="javaking";
		String memberPassword="1357";
		String memberNickname="코스타정우성";
		MemberVO memberVO=new MemberVO(memberId,memberPassword,memberNickname);
		try {
			MemberDAO memberDAO=MemberDAO.getInstance();
			memberDAO.registerMember(memberVO);
			memberVO=memberDAO.login(memberId, memberPassword);
			System.out.println("회원가입 성공?"+memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
