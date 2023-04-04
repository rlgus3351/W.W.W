package com.smhrd.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;
//리뷰 테이블 데이터를 관리하는 DAO
public class reviewDAO {
	
	private SqlSessionFactory factory = SqlSessionManager.getFactory();
	
	//--------------------------------------------------------리뷰 조회 메소드--------------------------------------------------------------//
	public ArrayList<reviewDTO> search() {
		ArrayList<reviewDTO> review_list= null;
		// 1. SqlSession 빌려오기
		SqlSession session = factory.openSession(true);
		try {
			// 2. session을 활용해서 검색 기능 실시
			review_list = (ArrayList)session.selectList("reviewAll");
		} finally {
			// 3. session 결과값 반납
			session.close();
		}
		// 4. 결과값 반환
		return review_list;
	}
	
	//--------------------------------------------------------리뷰 작성 메소드--------------------------------------------------------------//
	public int write(reviewDTO dto) {
		int cnt = 0;

		// 1. sqlsession 빌려오기
		SqlSession session = factory.openSession(true);
		try {
			// 2. reviewMapper 파일에 InsertReview id를 가진 insert문 실행
			cnt = session.insert("InsertReview", dto);
		} finally {
			// 3. sqlsession 반납
			session.close();
		}
		return cnt;
	}
	
	
	//--------------------------------------------------------리뷰 삭제 메소드--------------------------------------------------------------//
	public int delete(reviewDTO dto) {
		int cnt = 0;

		// 글 삭제

		// 1. sqlsession 빌려오기
		SqlSession session = factory.openSession(true);
		try {
			// 2. reviewMapper 파일에 InsertReview id를 가진 delete문 실행
			cnt = session.delete("reviewDelete", dto);
		} finally {
			// 3. sqlsession 반납
			session.close();
		}
		return cnt;
	}

	



}
