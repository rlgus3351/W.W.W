package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

// 회원 별 플레이리스트 글에 대한 좋아요 테이블
public class boardDAO {
	
	// SQL세션 관리자 불러오기
	private SqlSessionFactory factory = SqlSessionManager.getFactory();
	
	//--------------------------------------------------------좋아요 체크 메소드--------------------------------------------------------------//
	public int checkLike(boardDTO dto) {
		int row = 0;
		// 1. sqlsession 빌려오기
		SqlSession session = factory.openSession(true);
		try {
			// 2. checkLike라는 boardMapper파일의 select문 아이디와 boardDTO dto(회원 아이디, 커뮤니티 글 번호) 매개변수로 넘겨주고
			// 반환 값이 int형이라(mapper파일 반환 타입 -> int 형으로 설정) int row 에 저장한다.
			row = session.selectOne("checkLike",dto);
		} finally {
			// 3. sqlsession 반납
			session.close();
		}
		return row;
	}
	//--------------------------------------------------------좋아요 테이블 삽입 메소드--------------------------------------------------------------//
	public int likeUp(boardDTO dto) {
		
		int row = 0;
		// 1. sqlsession 빌려오기
		SqlSession session = factory.openSession(true);
		try {
			//2. likeUp라는 boardMapper파일의 select문 아이디와 boardDTO dto(회원 아이디, 커뮤니티 글 번호) 매개변수로 넘겨주고
			//	 board 테이블에 데이터를 삽입한다.
			row = session.insert("likeUp",dto);
		} finally {
			// 3. sqlsession 반납
			session.close();
		}
		return row;
	}
	
	//--------------------------------------------------------좋아요 테이블 삭제 메소드--------------------------------------------------------------//
	public int likeDown(boardDTO dto) {
		
		int row = 0;
		// 1. sqlsession 빌려오기
		SqlSession session = factory.openSession(true);
		try {
			// 2. likeDown라는 boardMapper파일의 select문 아이디와 boardDTO dto(회원 아이디, 커뮤니티 글 번호) 매개변수로 넘겨주고
			//	 board 테이블에 속하는 데이터를 삭제한다.
			row = session.delete("likeDown",dto);
		} finally {
			// 3. sqlsession 반납
			session.close();
		}
		return row;
	}

}
