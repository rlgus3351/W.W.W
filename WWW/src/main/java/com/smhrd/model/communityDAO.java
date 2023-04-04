package com.smhrd.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

//커뮤니티 테이블 데이터를 관리하는 DAO
public class communityDAO {
	private SqlSessionFactory factory = SqlSessionManager.getFactory();

	// --------------------------------------------------------커뮤니티 게시글 전체 조회
	// 메소드--------------------------------------------------------------//
	public ArrayList<communityDTO> selectAll() {
		// communityDTO를 담을 ArrayList를 선언
		ArrayList<communityDTO> list = null;

		// 1. sqlsession 빌려오기
		SqlSession session = factory.openSession(true);
		try {
			// 2. communityMapper 파일에 mapper id가 communityAllSearch 이름을 가진 select문 실행
			list = (ArrayList) session.selectList("CommunityAllSearch");

		} finally {
			// 3. sqlsession 반납
			session.close();
		}
		return list;
	}

	public int sendCommunity(communityDTO dto) {
		int row = 0;
		SqlSession session = factory.openSession(true);

		try {
			row = session.insert("communityInsert", dto);
		} finally {
			session.close();
		}

		return row;
	}

	// --------------------------------------------------------좋아요 시 커뮤니티 게시글
	// 업데이트--------------------------------------------------------------//
	public int Uplike(communityDTO dto) {

		int row = 0;
		// 1. 세션 빌려오기
		SqlSession session = factory.openSession(true);
		try {
			// 2. communityMapper에 Uplike라는 id를 가진 update문을 실행
			// 매개변수로는 communityDTO를 넘겨준다.
			row = session.update("UpLike", dto);
		} finally {
			session.close();
		}
		return row;
	}

	// --------------------------------------------------------좋아요 취소 시 커뮤니티 게시글
	// 업데이트--------------------------------------------------------------//
	public int Downlike(communityDTO dto) {

		int row = 0;
		// 1. 세션 빌려오기
		SqlSession session = factory.openSession(true);
		try {
			// 2. communityMapper에 Downlike라는 id를 가진 update문을 실행
			// 매개변수로는 communityDTO를 넘겨준다.

			row = session.update("DownLike", dto);

		} finally {
			session.close();
		}
		return row;
	}

	public int deleteComm(communityDTO dto) {

		int row = 0;
		// 1. 세션 빌려오기
		SqlSession session = factory.openSession(true);
		try {
			row = session.delete("deleteCommunity", dto);

		} finally {
			session.close();
		}
		return row;
	}

}
