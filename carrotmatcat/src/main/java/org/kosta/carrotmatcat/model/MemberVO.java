package org.kosta.carrotmatcat.model;

import java.io.Serializable;

public class MemberVO implements Serializable {

	private static final long serialVersionUID = 8294525643547029860L;
	private String memberId;
	private String memberPassword;
	private String memberNickname;

	public MemberVO() {
		super();

	}
	 // 회원가입시 사용
	public MemberVO(String memberId, String memberPassword, String memberNickname) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberNickname = memberNickname;
	}

	// 로그인시 사용
	public MemberVO(String memberId, String memberPassword) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
	} 

	public MemberVO(String memberId) {
		super();
		this.memberId = memberId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberPassword=" + memberPassword + ", memberNickname="
				+ memberNickname + "]";
	}

}
