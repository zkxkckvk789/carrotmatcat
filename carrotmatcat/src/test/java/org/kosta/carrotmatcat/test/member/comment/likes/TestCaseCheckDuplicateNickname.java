package org.kosta.carrotmatcat.test.member.comment.likes;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.MemberDAO;

public class TestCaseCheckDuplicateNickname {
	public static void main(String[] args) {
		String memberNickname="코스타정우성"; //true
		memberNickname="코스타서정우"; //false
		try {
			System.out.println("존재유무: "+MemberDAO.getInstance().checkDuplicateId(memberNickname));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
