package com.junefw.infra.modules.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {

	@Autowired
	CodeServiceImpl service; // 서비스와 서비스임플과 혼동하지말자 이름만 서비스라고 부른다.
	
	@RequestMapping(value = "/code/codeGroupList") // 리퀘스트매핑은 브라우저 창에뜨는 주소를 말ㄹ함
	public String codeGroupList(Model model) throws Exception {
		
		List<Code> list = service.selectList();
		model.addAttribute("list", list);
		
		return "code/codeGroupList";
	}
}