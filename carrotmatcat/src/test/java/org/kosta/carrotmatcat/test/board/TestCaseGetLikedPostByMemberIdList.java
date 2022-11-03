package org.kosta.carrotmatcat.test.board;

import java.sql.SQLException;
import java.util.ArrayList;

import org.kosta.carrotmatcat.model.BoardDAO;

public class TestCaseGetLikedPostByMemberIdList {
	public static void main(String[] args) {
		String memberId="yerin0110";
		try {
			ArrayList<Long> list=BoardDAO.getInstance().getLikedPostByMemberId(memberId);
			for(Long articleNo:list) {
				System.out.println(articleNo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
