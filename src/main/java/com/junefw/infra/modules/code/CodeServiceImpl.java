package com.junefw.infra.modules.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 이건 무슨의미?
public class CodeServiceImpl implements CodeService{ // 서비스에 상속받으면 상속받은 내용을 꼭 구현해줘야지 에러가 사라짐

	@Autowired
	CodeDao dao;

	@Override
	public List<Code> selectList() throws Exception {
			return dao.selecList();
	}
	
	
}