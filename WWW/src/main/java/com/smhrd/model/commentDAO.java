package com.smhrd.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

// 댓글 테이블에 데이터를 관리하는 DAO
public class commentDAO {
	private SqlSessionFactory factory = SqlSessionManager.getFactory();

	//--------------------------------------------------------커뮤니티 테이블 삽입 메소드--------------------------------------------------------------//
	public int addComment(commentDTO dto) {
		//1. 세션 빌려오기
		SqlSession session = factory.openSession(true);
		int row = 0;
		try {
			// 2. commentMapper 파일에 addComment라는 id를 가진 insert문 실행
			//    매개 변수로는 commentDTO를 넘겨준다.
			row = session.insert("addComment", dto);
		} finally {
			session.close();
		}
		return row;
	}
	//--------------------------------------------------------커뮤니티 테이블 전체 조회 메소드--------------------------------------------------------------//
	public ArrayList<commentDTO> selectAll(){
	
		// 1. 세션 빌려오기
		SqlSession session = factory.openSession(true);
	
		// 2. commentDTO를 담을 ArrayList 선언
		ArrayList<commentDTO> cmt_list = new ArrayList<commentDTO>();
		try {
			// 3. commentMapper 파일에 commentAllSearch라는 id를 가진 select문 실행
			//    반환 타입은 list<E> 이므로 ArrayList로 형변환하여 넣어준다  
			cmt_list = (ArrayList) session.selectList("commentAllSearch");
		} finally {
			session.close();
		}
		return cmt_list;
	}
	
	//--------------------------------------------------------커뮤니티 테이블 삭제 메소드--------------------------------------------------------------//
	public int deleteComment(commentDTO dto) {
		
		// 1. 세션 빌려오기
		SqlSession session = factory.openSession(true);
		int row = 0;
		try {
			// 2. commentMapper 파일에 delteComment라는 id를 가진 delete문 실행
			//    매개 변수로는 commentDTO를 넘겨준다.
			row = session.delete("deleteComment", dto);
		} finally {
			session.close();
		}
		return row;
	}
}
