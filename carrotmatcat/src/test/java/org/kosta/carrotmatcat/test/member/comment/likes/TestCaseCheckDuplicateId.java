package org.kosta.carrotmatcat.test.member.comment.likes;

import java.sql.SQLException;

import org.kosta.carrotmatcat.model.MemberDAO;

public class TestCaseCheckDuplicateId {
	public static void main(String[] args) {
		String memberId="javaking"; //true
		memberId="javaking2"; //false
		try {
			System.out.println("존재유무: "+MemberDAO.getInstance().checkDuplicateId(memberId));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
