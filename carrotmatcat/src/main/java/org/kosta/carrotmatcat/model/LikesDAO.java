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
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
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

}
