package org.kosta.carrotmatcat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDAO {
	private static MemberDAO instance=new MemberDAO();
	private DataSource dataSource;
	private MemberDAO() {
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static MemberDAO getInstance() {
		return instance;
	}
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if(pstmt!=null) {
			pstmt.close();
		}
		if(con!=null) {
			con.close();
		}
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs!=null) {
			rs.close();
		}
		closeAll(pstmt, con);
	}
	
	public MemberVO login(String memberId, String memberPassword) throws SQLException {
		MemberVO memberVO=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="SELECT member_id,member_nickname FROM carrotmatcat_member WHERE member_id=? AND member_password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPassword);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				memberVO=new MemberVO(memberId,null,rs.getString("member_nickname"));
			}
		} finally {
			closeAll(rs,pstmt,con);
		}
		return memberVO;
	}
	
	public void registerMember(MemberVO memberVO) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="INSERT INTO carrotmatcat_member(member_id,member_password,member_nickname) VALUES(?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, memberVO.getMemberId());
			pstmt.setString(2, memberVO.getMemberPassword());
			pstmt.setString(3, memberVO.getMemberNickname());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt,con);
		}
	}
	
	public void updateMember(MemberVO memberVO) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="UPDATE carrotmatcat_member SET member_nickname=?, member_password=? WHERE member_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, memberVO.getMemberNickname());
			pstmt.setString(2, memberVO.getMemberPassword());
			pstmt.setString(3, memberVO.getMemberId());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt,con);
		}
	}
	
	public boolean checkDuplicateId(String memberId) throws SQLException {
		boolean result=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="SELECT COUNT(*) FROM carrotmatcat_member WHERE member_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)>0) {
					result=true;
				}
			}
		} finally {
			closeAll(rs,pstmt,con);
		}
		return result;
	}
	
	public boolean checkDuplicateNickname(String memberNickname) throws SQLException {
		
		boolean result=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="SELECT COUNT(*) FROM carrotmatcat_member WHERE member_nickname=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, memberNickname);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)>0) {
					result=true;
				}
			}
		} finally {
			closeAll(rs,pstmt,con);
		}
		return result;
	}	
}






