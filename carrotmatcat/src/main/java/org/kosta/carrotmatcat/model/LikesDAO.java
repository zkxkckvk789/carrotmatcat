package org.kosta.carrotmatcat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class LikesDAO {
	private static LikesDAO instance=new LikesDAO();
	private DataSource dataSource;
	private LikesDAO() {
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static LikesDAO getInstance() {
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
	
	public void closeAll(Connection con, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		if(rs!=null) {
			rs.close();
		}
		closeAll(pstmt, con);
	}
	
	public void addLike(long articleNo, String memberId) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="INSERT INTO carrotmatcat_likes VALUES(?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, articleNo);
			pstmt.setString(2, memberId);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt,con);
		}
	}
	
	public void deleteLike(long articleNo,String memberId) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="DELETE FROM carrotmatcat_likes WHERE article_no=? AND member_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, articleNo);
			pstmt.setString(2, memberId);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt,con);
		}
	}

	public long likeCount(long articleNo) throws SQLException {
		long totalLikeCount=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="SELECT COUNT(*) FROM carrotmatcat_likes WHERE article_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, articleNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				totalLikeCount=rs.getLong(1);
			}
		}finally {
			closeAll(con, pstmt, rs);
		}
		return totalLikeCount;
	}
	
	public PostVO check(String memberId, long articleNo) throws SQLException {
		PostVO postVO=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT article_no FROM carrotmatcat_likes ");
			sql.append("WHERE member_id=? AND article_no=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, memberId);
			pstmt.setLong(2, articleNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				postVO = new PostVO();
				postVO.setArticleNo(Long.parseLong(rs.getString(1)));
			}
		}finally {
			closeAll(con, pstmt, rs);
		}
		return postVO;
	}
	
}
