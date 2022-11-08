package org.kosta.carrotmatcat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class BoardDAO {
   private static BoardDAO instance=new BoardDAO();
   private DataSource dataSource;
   private BoardDAO() {
      dataSource=DataSourceManager.getInstance().getDataSource();
   }
   public static BoardDAO getInstance() {
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
   
   public void posting(PostVO postVO) throws SQLException {
      Connection con=null;
      PreparedStatement pstmt=null;
      try {
         con=getConnection();
         StringBuilder sql=new StringBuilder();
         sql.append("INSERT INTO carrotmatcat_board(article_no, article_title, article_content,article_food_category,article_store_name,article_time_posted,member_id) ");
         sql.append("VALUES(carrotmatcat_board_seq.nextval,?,?,?,?, SYSDATE,?)");
         pstmt=con.prepareStatement(sql.toString());
         pstmt.setString(1,postVO.getArticleTitle());
         pstmt.setString(2,postVO.getArticleContent());
         pstmt.setString(3,postVO.getArticleFoodCategory());
         pstmt.setString(4,postVO.getArticleStoreName());
         pstmt.setString(5,postVO.getMemberVO().getMemberId());
         pstmt.executeUpdate();
         
      }finally {
         closeAll(pstmt, con);
      }
   }

   public PostVO viewPostDetailByNo(long articleNo) throws SQLException {
      Connection con=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      PostVO postVO=null;
      try {
         con=getConnection();
         StringBuilder sql=new StringBuilder();
         sql.append("SELECT cb.article_no, cb.article_title,cb.article_food_category, cm.member_nickname, TO_CHAR(cb.article_time_posted,'YYYY.MM.DD HH:MI:SS')");
         sql.append(" AS article_time_posted, cb.article_store_name, cb.article_content, cb.article_hits");
         sql.append(" FROM carrotmatcat_board cb");
         sql.append(" INNER JOIN carrotmatcat_member cm ON cb.member_id=cm.member_id");
         sql.append(" WHERE cb.article_no=?");
         pstmt=con.prepareStatement(sql.toString());
         pstmt.setLong(1,articleNo);
         rs=pstmt.executeQuery();
         if(rs.next()) {
            MemberVO memberVO=new MemberVO(null,null,rs.getString("member_nickname"));
            postVO = new PostVO(rs.getLong("article_no"),rs.getString("article_title"),
                  rs.getString("article_store_name"), rs.getString("article_food_category"),  
                  rs.getString("article_content"), rs.getLong("article_hits"),
                  rs.getString("article_time_posted"), memberVO);
         }
      }finally {
         closeAll(rs, pstmt, con);
      }
      
      return postVO;
}

   public ArrayList<PostVO> findPostList(Pagination pagination) throws SQLException{
      ArrayList<PostVO> postList=new ArrayList<>();
      Connection con=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      try {
         con=getConnection();
         StringBuilder sql=new StringBuilder();
         sql.append("SELECT cb.rnum,cb.article_no, cb.article_title,cb.article_store_name, cm.member_nickname, cb.article_time_posted, cb.article_hits");
         sql.append(" FROM(");
         sql.append(" SELECT ROW_NUMBER() OVER(ORDER BY article_no DESC) AS rnum,article_no,article_title,member_id,article_store_name,TO_CHAR(article_time_posted,'YYYY.MM.DD HH:MI:SS')");
         sql.append(" AS article_time_posted,article_hits FROM carrotmatcat_board");
         sql.append(" ) cb");
         sql.append(" INNER JOIN carrotmatcat_member cm ON cb.member_id = cm.member_id");
         sql.append(" WHERE rnum BETWEEN ? AND ?");
         sql.append(" ORDER BY cb.article_no DESC");
         pstmt=con.prepareStatement(sql.toString());
         pstmt.setLong(1, pagination.getStartRowNumber());
         pstmt.setLong(2, pagination.getEndRowNumber());
         rs=pstmt.executeQuery();
         while(rs.next()) {
            postList.add(new PostVO(rs.getLong("article_no"),rs.getString("article_title"),rs.getString("article_store_name"),rs.getLong("article_hits"),rs.getString("article_time_posted"),new MemberVO(null,null,rs.getString("member_nickname"))));
         }
      } finally {
         closeAll(rs,pstmt,con);
      }
      return postList;
   }
   
   public ArrayList<PostVO> findPostList() throws SQLException{
	      ArrayList<PostVO> postList=new ArrayList<>();
	      Connection con=null;
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      try {
	         con=getConnection();
	         StringBuilder sql=new StringBuilder();
	         sql.append("SELECT cb.rnum,cb.article_no, cb.article_title,cb.article_store_name, cm.member_nickname, cb.article_time_posted, cb.article_hits");
	         sql.append(" FROM(");
	         sql.append(" SELECT ROW_NUMBER() OVER(ORDER BY article_no DESC) AS rnum,article_no,article_title,member_id,article_store_name,TO_CHAR(article_time_posted,'YYYY.MM.DD HH:MI:SS')");
	         sql.append(" AS article_time_posted,article_hits FROM carrotmatcat_board");
	         sql.append(" ) cb");
	         sql.append(" INNER JOIN carrotmatcat_member cm ON cb.member_id = cm.member_id");
	         sql.append(" ORDER BY cb.article_no DESC");
	         pstmt=con.prepareStatement(sql.toString());
	         rs=pstmt.executeQuery();
	         while(rs.next()) {
	            postList.add(new PostVO(rs.getLong("article_no"),rs.getString("article_title"),rs.getString("article_store_name"),rs.getLong("article_hits"),rs.getString("article_time_posted"),new MemberVO(null,null,rs.getString("member_nickname"))));
	         }
	      } finally {
	         closeAll(rs,pstmt,con);
	      }
	      return postList;
	   }
   
   
   public int getTotalPostCount() throws SQLException {
      Connection con=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      int totalPostCount=0;
      try {
         con=getConnection();
         String sql="SELECT COUNT(*) AS totalPostCount FROM carrotmatcat_board";
         pstmt=con.prepareStatement(sql);
         rs=pstmt.executeQuery();
         if(rs.next()) {
            totalPostCount=rs.getInt("totalPostCount");
         }
      } finally {
         closeAll(rs,pstmt,con);
      }
      return totalPostCount;
   }
    
   //제목조회 게시글용 리스트
   public int getTotalPostCountBySearchTitle(String articleTitle) throws SQLException {
      Connection con=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      int totalPostCount=0;
      try {
         con=getConnection();
         StringBuilder sql=new StringBuilder();
         sql.append("SELECT COUNT(*) AS totalPostCount FROM");
         sql.append(" (SELECT ROW_NUMBER() OVER(ORDER BY cb.article_no DESC) AS rnum,cb.article_no, cb.article_title,cb.article_store_name, cm.member_nickname, cb.article_time_posted, cb.article_hits, cb.article_food_category,cb.article_content");
         sql.append(" FROM(");
         sql.append(" SELECT article_no,article_title,member_id,article_store_name,TO_CHAR(article_time_posted,'YYYY.MM.DD HH:MI:SS')");
         sql.append(" AS article_time_posted,article_hits, article_food_category,article_content FROM carrotmatcat_board");
         sql.append("  ) cb");
         sql.append("  INNER JOIN carrotmatcat_member cm ON cb.member_id = cm.member_id");
         sql.append("  WHERE cb.article_title LIKE '%'||?||'%') cb");
         pstmt=con.prepareStatement(sql.toString());
         pstmt.setString(1, articleTitle);
         rs=pstmt.executeQuery();
         if(rs.next()) {
            totalPostCount=rs.getInt("totalPostCount");
         }
      } finally {
         closeAll(rs,pstmt,con);
      }
      return totalPostCount;
   }
      
   //내용조회 게시글용 리스트
    public int getTotalPostCountBySearchContent(String articleContent) throws SQLException {
         Connection con=null;
         PreparedStatement pstmt=null;
         ResultSet rs=null;
         int totalPostCount=0;
         try {
            con=getConnection();
            StringBuilder sql=new StringBuilder();
            sql.append("SELECT COUNT(*) AS totalPostCount FROM");
            sql.append(" (SELECT ROW_NUMBER() OVER(ORDER BY cb.article_no DESC) AS rnum,cb.article_no, cb.article_title,cb.article_store_name, cm.member_nickname, cb.article_time_posted, cb.article_hits, cb.article_food_category,cb.article_content");
            sql.append(" FROM(");
            sql.append(" SELECT article_no,article_title,member_id,article_store_name,TO_CHAR(article_time_posted,'YYYY.MM.DD HH:MI:SS')");
            sql.append(" AS article_time_posted,article_hits, article_food_category,article_content FROM carrotmatcat_board");
            sql.append("  ) cb");
            sql.append("  INNER JOIN carrotmatcat_member cm ON cb.member_id = cm.member_id");
            sql.append("  WHERE cb.article_content LIKE '%'||?||'%') cb");
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setString(1, articleContent);
            rs=pstmt.executeQuery();
            if(rs.next()) {
               totalPostCount=rs.getInt("totalPostCount");
            }
         } finally {
            closeAll(rs,pstmt,con);
         }
         return totalPostCount;
      }
    
    
   
    public int getTotalPostCountByLikes(String memberId) throws SQLException {
    	 Connection con=null;
         PreparedStatement pstmt=null;
         ResultSet rs=null;
         int totalPostCount=0;
         try {
        	 con=getConnection();
        	 StringBuilder sql=new StringBuilder();
        	 sql.append("SELECT COUNT(*) FROM(");
        	 sql.append(" SELECT cl.rnum, cl.article_no, cm.member_nickname, cb.article_title, cb.member_id, cb.article_store_name,  cb.article_time_posted, cb.article_hits, cb.article_food_category");
        	 sql.append(" FROM carrotmatcat_board cb");
        	 sql.append(" INNER JOIN (SELECT ROW_NUMBER() OVER(ORDER BY article_no DESC) AS rnum,article_no,member_id FROM carrotmatcat_likes) cl ON cl.article_no=cb.article_no");
        	 sql.append(" INNER JOIN carrotmatcat_member cm ON cm.member_id=cb.member_id");
        	 sql.append(" WHERE cl.member_id=?");
        	 sql.append(" ORDER BY cb.article_no DESC)");
        	 pstmt=con.prepareStatement(sql.toString());
        	 pstmt.setString(1, memberId);
        	 rs=pstmt.executeQuery();
        	 if(rs.next()) {
        		 totalPostCount=rs.getInt(1);
        	 }
         } finally{
        	 closeAll(rs, pstmt, con);
         }
         return totalPostCount;
    }
    
    public int getTotalPostCountByFood(String articleFoodCategory) throws SQLException {
    	Connection con=null;
    	PreparedStatement pstmt=null;
    	ResultSet rs=null;
    	int totalPostCount=0;
    	try {
    		con=getConnection();
    		StringBuilder sql=new StringBuilder();
    		sql.append("SELECT COUNT(*) FROM(");
    		sql.append(" SELECT cb.rnum,cb.article_no, cb.article_title,cb.article_store_name, cm.member_nickname, cb.article_time_posted, cb.article_hits, cb.article_food_category");
    		sql.append(" FROM(");
    		sql.append(" SELECT ROW_NUMBER() OVER(ORDER BY article_no DESC) AS rnum,article_no,article_title,member_id,article_store_name,TO_CHAR(article_time_posted,'YYYY.MM.DD HH:MI:SS')");
    		sql.append(" AS article_time_posted,article_hits, article_food_category FROM carrotmatcat_board WHERE article_food_category=?) cb");
    		sql.append(" INNER JOIN carrotmatcat_member cm ON cb.member_id = cm.member_id");
    		sql.append(" ORDER BY cb.article_no DESC)");
    		pstmt=con.prepareStatement(sql.toString());
    		pstmt.setString(1, articleFoodCategory);
    		rs=pstmt.executeQuery();
    		if(rs.next()) {
    			totalPostCount=rs.getInt(1);
    		}
    	} finally{
    		closeAll(rs, pstmt, con);
    	}
    	return totalPostCount;
    }
    
    
   public void updatePost(PostVO postVO) throws SQLException {
      Connection con=null;
      PreparedStatement pstmt=null;
      try {
         con=getConnection();
         String sql="UPDATE carrotmatcat_board SET article_title=?, article_store_name=?,article_food_category=?,article_content=? WHERE article_no=?";
         pstmt=con.prepareStatement(sql);
         pstmt.setString(1, postVO.getArticleTitle());
         pstmt.setString(2, postVO.getArticleStoreName());
         pstmt.setString(3, postVO.getArticleFoodCategory());
         pstmt.setString(4, postVO.getArticleContent());
         pstmt.setLong(5, postVO.getArticleNo());
         pstmt.executeUpdate();
      } finally {
         closeAll(pstmt,con);
      }
   }
   
   public void deletePostByNo(long articleNo) throws SQLException {
      Connection con=null;
      PreparedStatement pstmt=null;
      try {
         con=getConnection();
         String sql="DELETE FROM carrotmatcat_board WHERE article_no=?";
         pstmt=con.prepareStatement(sql);
         pstmt.setLong(1, articleNo);
         pstmt.executeUpdate();
      } finally {
         closeAll(pstmt,con);
      }
   }
   
   public ArrayList<PostVO> findPostListByFood(String articleFoodCategory, Pagination pagination) throws SQLException{
      ArrayList<PostVO> articleFoodCategoryList=new ArrayList<>();
      Connection con=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      try {
         con=getConnection();
         StringBuilder sql=new StringBuilder();
         sql.append("SELECT cb.rnum,cb.article_no, cb.article_title,cb.article_store_name, cm.member_nickname, cb.article_time_posted, cb.article_hits, cb.article_food_category");
         sql.append(" FROM(");
         sql.append(" SELECT ROW_NUMBER() OVER(ORDER BY article_no DESC) AS rnum,article_no,article_title,member_id,article_store_name,TO_CHAR(article_time_posted,'YYYY.MM.DD HH:MI:SS')");
         sql.append(" AS article_time_posted,article_hits, article_food_category FROM carrotmatcat_board WHERE article_food_category=?");
         sql.append(" ) cb");
         sql.append(" INNER JOIN carrotmatcat_member cm ON cb.member_id = cm.member_id");
         sql.append(" WHERE rnum BETWEEN ? AND ?");
         sql.append(" ORDER BY cb.article_no DESC");
         pstmt=con.prepareStatement(sql.toString());
         pstmt.setString(1, articleFoodCategory);
         pstmt.setLong(2, pagination.getStartRowNumber());
         pstmt.setLong(3, pagination.getEndRowNumber());
         rs=pstmt.executeQuery();
         while(rs.next()) {
            PostVO postVO=new PostVO(rs.getLong("article_no"),rs.getString("article_title"),rs.getString("article_store_name"),rs.getLong("article_hits"),rs.getString("article_time_posted"),new MemberVO(null,null,rs.getString("member_nickname")));
            articleFoodCategoryList.add(postVO);
         }
      } finally {
         closeAll(rs,pstmt,con);
      }
      return articleFoodCategoryList;
   }
   
   public ArrayList<PostVO> searchStoreListByTitle(String articleTitle, Pagination pagination) throws SQLException{
      ArrayList<PostVO> articleTitleList=new ArrayList<>();
      Connection con=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      try {
         con=getConnection();
         StringBuilder sql=new StringBuilder();
         sql.append("SELECT*FROM");
         sql.append(" (SELECT ROW_NUMBER() OVER(ORDER BY cb.article_no DESC) AS rnum,cb.article_no, cb.article_title,cb.article_store_name, cm.member_nickname, cb.article_time_posted, cb.article_hits, cb.article_food_category,cb.article_content");
         sql.append(" FROM(");
         sql.append(" SELECT article_no,article_title,member_id,article_store_name,TO_CHAR(article_time_posted,'YYYY.MM.DD HH:MI:SS')");
         sql.append(" AS article_time_posted,article_hits, article_food_category,article_content FROM carrotmatcat_board");
         sql.append(" ) cb");
         sql.append(" INNER JOIN carrotmatcat_member cm ON cb.member_id = cm.member_id");
         sql.append(" WHERE cb.article_title LIKE '%'||?||'%') cb");
         sql.append(" WHERE cb.rnum BETWEEN ? AND ?");
         sql.append(" ORDER BY cb.article_no DESC");
         pstmt=con.prepareStatement(sql.toString());
         pstmt.setString(1, articleTitle);
         pstmt.setLong(2, pagination.getStartRowNumber());
         pstmt.setLong(3, pagination.getEndRowNumber());
         rs=pstmt.executeQuery();
         while(rs.next()) {
            PostVO postVO=new PostVO(rs.getLong("article_no"),rs.getString("article_title"),rs.getString("article_store_name"),rs.getLong("article_hits"),rs.getString("article_time_posted"),new MemberVO(null,null,rs.getString("member_nickname")));
            articleTitleList.add(postVO);
         }
      } finally {
         closeAll(rs,pstmt,con);
      }
      return articleTitleList;
   }
   
   public ArrayList<PostVO> searchStoreListByContent(String articleContent, Pagination pagination) throws SQLException{
         ArrayList<PostVO> articleContentList = new ArrayList<>();
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try {
            con = getConnection();
            StringBuilder sql=new StringBuilder();
            sql.append("SELECT*FROM");
            sql.append(" (SELECT ROW_NUMBER() OVER(ORDER BY cb.article_no DESC) AS rnum,cb.article_no, cb.article_title,cb.article_store_name, cm.member_nickname, cb.article_time_posted, cb.article_hits, cb.article_food_category,cb.article_content");
            sql.append(" FROM(");
            sql.append(" SELECT article_no,article_title,member_id,article_store_name,TO_CHAR(article_time_posted,'YYYY.MM.DD HH:MI:SS')");
            sql.append(" AS article_time_posted,article_hits, article_food_category,article_content FROM carrotmatcat_board");
            sql.append(" ) cb");
            sql.append(" INNER JOIN carrotmatcat_member cm ON cb.member_id = cm.member_id");
            sql.append(" WHERE cb.article_content LIKE '%'||?||'%') cb");
            sql.append(" WHERE cb.rnum BETWEEN ? AND ?");
            sql.append(" ORDER BY cb.article_no DESC");
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setString(1, articleContent);
            pstmt.setLong(2, pagination.getStartRowNumber());
            pstmt.setLong(3, pagination.getEndRowNumber());
            rs =pstmt.executeQuery();
            while(rs.next()) {
               PostVO postVO=new PostVO(rs.getLong("article_no"),rs.getString("article_title"),rs.getString("article_store_name"),rs.getLong("article_hits"),rs.getString("article_time_posted"),new MemberVO(null,null,rs.getString("member_nickname")));
               articleContentList.add(postVO);
            }
         } finally {
            closeAll(rs,pstmt,con);
         }
         return articleContentList;
      }
   
   public ArrayList<PostVO> findLikesListPostByMemberId(String memberId,Pagination pagination) throws SQLException{
      ArrayList<PostVO> articleMemberIdList = new  ArrayList<PostVO>();       
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         con = getConnection();
         StringBuilder sql=new StringBuilder();
         sql.append("SELECT cl.rnum, cl.article_no, cm.member_nickname, cb.article_title, cb.member_id, cb.article_store_name,  cb.article_time_posted, cb.article_hits, cb.article_food_category");
         sql.append(" FROM carrotmatcat_board cb");
         sql.append(" INNER JOIN (SELECT ROW_NUMBER() OVER(ORDER BY article_no DESC) AS rnum,article_no,member_id FROM carrotmatcat_likes WHERE member_id=?) cl");
         sql.append(" ON cl.article_no=cb.article_no");
         sql.append(" INNER JOIN carrotmatcat_member cm ON cm.member_id=cb.member_id");
         sql.append(" WHERE rnum BETWEEN ? AND ?");
         sql.append(" ORDER BY cb.article_no DESC");
         pstmt=con.prepareStatement(sql.toString());
         pstmt.setString(1, memberId);
         pstmt.setLong(2, pagination.getStartRowNumber());
         pstmt.setLong(3, pagination.getEndRowNumber());
         rs=pstmt.executeQuery();
         while(rs.next()) {
            PostVO postVO=new PostVO(rs.getLong("article_no"),rs.getString("article_title"),rs.getString("article_store_name"),rs.getLong("article_hits"),rs.getString("article_time_posted"),new MemberVO(null,null,rs.getString("member_nickname")));
            articleMemberIdList.add(postVO);
         }
      }finally {
         closeAll(rs,pstmt,con);
      } 
      return articleMemberIdList;   
   }
   
   public ArrayList<PostVO> findLikesListPostByMemberId(String memberId) throws SQLException{
	      ArrayList<PostVO> articleMemberIdList = new  ArrayList<PostVO>();       
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	         con = getConnection();
	         StringBuilder sql=new StringBuilder();
	         sql.append("SELECT cl.rnum, cl.article_no, cm.member_nickname, cb.article_title, cb.member_id, cb.article_store_name,  cb.article_time_posted, cb.article_hits, cb.article_food_category");
	         sql.append(" FROM carrotmatcat_board cb");
	         sql.append(" INNER JOIN (SELECT ROW_NUMBER() OVER(ORDER BY article_no DESC) AS rnum,article_no,member_id FROM carrotmatcat_likes) cl");
	         sql.append(" ON cl.article_no=cb.article_no");
	         sql.append(" INNER JOIN carrotmatcat_member cm ON cm.member_id=cb.member_id");
	         sql.append(" WHERE cl.member_id=?");
	         sql.append(" ORDER BY cb.article_no DESC");
	         pstmt=con.prepareStatement(sql.toString());
	         pstmt.setString(1, memberId);
	         rs=pstmt.executeQuery();
	         while(rs.next()) {
	            PostVO postVO=new PostVO(rs.getLong("article_no"),rs.getString("article_title"),rs.getString("article_store_name"),rs.getLong("article_hits"),rs.getString("article_time_posted"),new MemberVO(null,null,rs.getString("member_nickname")));
	            articleMemberIdList.add(postVO);
	         }
	      }finally {
	         closeAll(rs,pstmt,con);
	      } 
	      return articleMemberIdList;   
	   }
   
   public void updateHits(long articleNo) throws SQLException {
      Connection con=null;
      PreparedStatement pstmt=null;
      try {
         con=getConnection();
         String sql="UPDATE carrotmatcat_board SET article_hits=article_hits+1 WHERE article_no=?";
         pstmt=con.prepareStatement(sql);
         pstmt.setLong(1, articleNo);
         pstmt.executeUpdate();
      } finally {
         closeAll(pstmt,con);
      }
   }
   
   public int getTotalPostCountListByFindFoodOfKorean(String articleFoodCategory) throws SQLException {
       Connection con=null;
       PreparedStatement pstmt=null;
       ResultSet rs=null;
       int totalPostCount=0;
       try {
          con=getConnection();
          StringBuilder sql=new StringBuilder();
          sql.append("SELECT COUNT(*) AS totalPostCount FROM");
          sql.append(" (SELECT ROW_NUMBER() OVER(ORDER BY cb.article_no DESC) AS rnum,cb.article_no, cb.article_title,cb.article_store_name, cm.member_nickname, cb.article_time_posted, cb.article_hits, cb.article_food_category,cb.article_content");
          sql.append(" FROM(");
          sql.append(" SELECT article_no,article_title,member_id,article_store_name,TO_CHAR(article_time_posted,'YYYY.MM.DD HH:MI:SS')");
          sql.append(" AS article_time_posted,article_hits, article_food_category,article_content FROM carrotmatcat_board");
          sql.append("  ) cb");
          sql.append("  INNER JOIN carrotmatcat_member cm ON cb.member_id = cm.member_id");
          sql.append("  WHERE cb.article_food_category = ?) cb");
          pstmt=con.prepareStatement(sql.toString());
          pstmt.setString(1, articleFoodCategory);
          rs=pstmt.executeQuery();
          if(rs.next()) {
             totalPostCount=rs.getInt("totalPostCount");
          }
       } finally {
          closeAll(rs,pstmt,con);
       }
       return totalPostCount;
    }
 
   
   
   
   
}










