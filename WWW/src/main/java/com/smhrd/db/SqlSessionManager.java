package com.smhrd.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	// mybatis-config 파일을 읽어서 sqlsession을 생성하도록 도와주는 도구
	
	public static SqlSessionFactory sqlSessionFactory;
	// 인스턴스 생성자
	// ex) Class.forName("driver명칭")
	// ---> 제일 먼저 실행되는 구간, 서로 다른 객체끼리 꼭 공유해야하는 고정값
	static {
		// 프로젝트 시 resource 경로만 잘 확인하기!
		String resource = "com/smhrd/db/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// sqlSessionFactory를 리턴해주는 메소드 정의
	
	public static SqlSessionFactory getFactory() {
		return sqlSessionFactory;
	}
	
}
	