package com.junefw.infra.modules.code;

import java.util.List;

/*import com.junefw.infra.modules.member.Member;
*/
public interface CodeService {
	
//	infrCodeGroup	public은 생략가능 abstract가 생략되어있음
	public int selectOneCount(CodeVo vo) throws Exception;
	public List<Code> selectList(CodeVo vo) throws Exception; 
	public int insert(Code dto) throws Exception;
	public Code selectOne(CodeVo vo) throws Exception;
	public int update(Code dto) throws Exception;
	public int delete(CodeVo vo) throws Exception;
	public int updateDelete(CodeVo vo) throws Exception;


	// infrCodeGroup  
	public List<Code> selecListCode(CodeVo vo) throws Exception;   
	public int insertCode(Code dto) throws Exception;
	public Code selectOneCode(CodeVo vo) throws Exception;
	public int updateCode(Code dto) throws Exception;
}