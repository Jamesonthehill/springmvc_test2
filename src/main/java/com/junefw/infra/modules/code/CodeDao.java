package com.junefw.infra.modules.code;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CodeDao {
	
	@Inject
	@Resource(name = "sqlSession")
	private SqlSession sqlSession; // sqlSession의 사용을 정의 SQL에서 db를 받기위한 논리적연결상태를 말함.
	
	private static String namespace = "com.junefw.infra.modules.code.CodeMpp";
	
	public List<Code> selecList() { return sqlSession.selectList(namespace + ".selectList", "");} // List는 배열임 배열에다가 객체를 쭉 받는다 의미
		
}