package com.smhrd.model;

import java.util.ArrayList;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

//컨텐츠 테이블 데이터를 관리하는 DAO
public class contentDAO {
	private SqlSessionFactory factory = SqlSessionManager.getFactory();
	
	//--------------------------------------------------------컨텐츠 전체 조회 메소드--------------------------------------------------------------//
	public ArrayList<contentDTO> search() {
		ArrayList<contentDTO> content_list= null;
		// 1. SqlSession 빌려오기
		SqlSession session = factory.openSession(true);
		try {
			// 2. session을 활용해서 검색 기능 실시
			content_list = (ArrayList)session.selectList("Search");
		} finally {
			// 3. session 결과값 반납
			session.close();
		}
		// 4. 결과값 반환
		return content_list;
	}

}
