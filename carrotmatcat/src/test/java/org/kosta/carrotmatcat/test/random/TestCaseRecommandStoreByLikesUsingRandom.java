package org.kosta.carrotmatcat.test.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.kosta.carrotmatcat.model.BoardDAO;
import org.kosta.carrotmatcat.model.PostVO;

public class TestCaseRecommandStoreByLikesUsingRandom {

	public static void main(String[] args) {
		//방법 1 Collections 의 shuffle기능 이용해서 리스트 섞고 첫번째 게시글 가져오기
		String memberId="yerin0110";
		try {
		ArrayList<PostVO> postList=BoardDAO.getInstance().findLikesListPostByMemberId(memberId);
		int no=(int) (Math.random()*(postList.size()));	
		
		
		Collections.shuffle(postList); // 어레이리스트 자체를 랜덤으로 섞고
		System.out.println(postList.get(0).getArticleStoreName()); //첫번째 항목 가져오기
					
					
		//방법 2 Math.random()기능 사용해서 리스트 사이즈 중 하나를 선택, 결과에 해당하는 index 넘버를 가진 게시글 가져오기
		no=(int) (Math.random()*(postList.size()));		
		System.out.println(postList.get(no).getArticleStoreName());
					
		//방법 3 Random객체사용하기(방법 2와 비슷)			
		Random random=new Random();
		no=random.nextInt(postList.size());
		System.out.println(postList.get(no).getArticleStoreName());
		} catch(Exception e) {
			e.setStackTrace(null);
		}
	}

}
