package com.junefw.infra.modules.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 이건 무슨의미?
public class CodeServiceImpl implements CodeService{ // 서비스에 상속받으면 상속받은 내용을 꼭 구현해줘야지 에러가 사라짐

		// infrCodeGroup

	@Autowired
	CodeDao dao;

	@Override
	public List<Code> selectList() throws Exception {
	
	return dao.selecList();
	}
	
	@Override
	public int insert(Code dto) throws Exception {
		
		return dao.insert(dto);
	}
	
	@Override
	public Code selectOne(CodeVo vo) throws Exception {
		
		return dao.selectOne(vo);
	}
	
	@Override
	public int update(Code dto) throws Exception {
		
		return dao.update(dto);
	}
	// infrCode
	@Override
	public List<Code> selecListCode() throws Exception {
		return dao.selecListCode();
	}

	@Override
	public int insertCode(Code dto) throws Exception {
		return dao.insertCode(dto);
	}

	@Override
	public Code selectOneCode(CodeVo vo) throws Exception {
		return dao.selectOneCode(vo);
	}

	@Override
	public int updateCode(Code dto) throws Exception {
		return dao.updateCode(dto);
	}
}