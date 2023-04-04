package com.smhrd.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class memberDAO {

	private SqlSessionFactory factory = SqlSessionManager.getFactory();

	public int signup(memberDTO dto) {
		
		int cnt = 0;

		SqlSession session = factory.openSession(true);

		try {
			cnt = session.insert("signup", dto);

		} catch (Exception e) {

		} finally {
			session.close();

		}

		return cnt;
	}

	public memberDTO login(memberDTO dto) {
		
		// 1.sql session 불러오기
		SqlSession session = factory.openSession(true);
		memberDTO result = null;
		
		try {
			// 2. session 활용해서 sql구문 실행 (로그인기능)
			result = session.selectOne("Login", dto);
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return result;
	}
	
	public ArrayList<memberDTO> selectAll(){
		SqlSession session = factory.openSession(true);
		ArrayList<memberDTO> result = null;
		try {
			// 2. session 활용해서 sql구문 실행 (로그인기능)
			result = (ArrayList)session.selectList("selectAll");		
		} finally {
			session.close();
		}
		return result;
	}

}
