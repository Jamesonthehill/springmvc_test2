package com.junefw.infra.modules.member;

import java.util.List;

public interface MemberService {
	
	public int selectOneCount(MemberVo vo) throws Exception;
	public List<Member> selecList(MemberVo vo) throws Exception; 
	public int insert(Member dto) throws Exception; 
	public Member selectOne(MemberVo vo) throws Exception;
	public int update(Member dto) throws Exception;
	public int delete(MemberVo vo) throws Exception;
	public int updateDelete(MemberVo vo) throws Exception;
	
}