package org.kosta.carrotmatcat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class CommentDAO {
	private static CommentDAO instance=new CommentDAO();
	private DataSource dataSource;
	private CommentDAO() {
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static CommentDAO getInstance() {
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
	
	public void writeComment(CommentVO commentVO) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("INSERT INTO carrotmatcat_comment(comment_no, comment_content, comment_time_posted, article_no, member_id)");
			sql.append(" VALUES(carrotmatcat_comment_seq.nextval, ?, SYSDATE, ?, ?)");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, commentVO.getCommentContent());
			pstmt.setLong(2, commentVO.getPostVO().getArticleNo());
			String memberId=commentVO.getMemberVO().getMemberId();
			pstmt.setString(3, memberId);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt,con);
		}
	}
	
	public ArrayList<CommentVO> viewCommentDetail(long articleNo) throws SQLException {
		ArrayList<CommentVO> commentList=new ArrayList<CommentVO>();
		MemberVO memberVO=null;
		PostVO postVO=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT cc.comment_no,cm.member_nickname, cc.comment_content, TO_CHAR(cc.comment_time_posted,'YYYY.MM.DD HH:MM') AS comment_time_posted");
			sql.append(" FROM carrotmatcat_comment  cc");
			sql.append(" INNER JOIN carrotmatcat_member cm ON cc.member_id = cm.member_id");
			sql.append(" INNER JOIN carrotmatcat_board cb ON cb.article_no = cc.article_no");
			sql.append(" WHERE cc.article_no=? ORDER BY cc.comment_no");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setLong(1, articleNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				memberVO=new MemberVO(null,null,rs.getString("member_nickname"));
				postVO=new PostVO(articleNo);
				commentList.add(new CommentVO(rs.getLong("comment_no"),rs.getString("comment_time_posted"),rs.getString("comment_content"),memberVO,postVO));
			}
		} finally {
			closeAll(rs,pstmt,con);
		}
		return commentList;
	}
	
	public void updateComment(CommentVO commentVO) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="UPDATE carrotmatcat_comment SET comment_content=? WHERE comment_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, commentVO.getCommentContent());
			pstmt.setLong(2, commentVO.getCommentNo());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt,con);
		}
	}
	
	public void deleteComment(long commentNO) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="DELETE FROM carrotmatcat_comment WHERE comment_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, commentNO);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt,con);
		}
	}
}
