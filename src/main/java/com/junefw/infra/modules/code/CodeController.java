package com.junefw.infra.modules.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {

	@Autowired // 객체만들때 new 의역할을 한다고 보면된다.
	CodeServiceImpl service; // 서비스와 서비스임플과 혼동하지말자 이름만 서비스라고 부른다.
	
	@RequestMapping(value = "/code/codeGroupList") // 리퀘스트매핑은 브라우저 창에뜨는 주소를 말함
	public String codeGroupList(Model model) throws Exception {
		
		List<Code> list = service.selectList();
		
		model.addAttribute("list", list); // codeGroupList에 있는 list를 말함 왼쪽의 이름으로 오른쪽 데이터를 보내라.
 		
		return "code/codeGroupList";
	}
	
	@RequestMapping(value = "/code/codeGroupForm") // 리퀘스트매핑은 브라우저 창에뜨는 주소를 말함
	public String codeGroupForm() throws Exception {
		
		return "code/codeGroupForm";
	}
	
	@RequestMapping(value = "/code/codeGroupInst") // 리퀘스트매핑은 브라우저 창에뜨는 주소를 말함
	public String codeGroupInst(Code dto) throws Exception {
		
		//입력실행
		service.insert(dto);
		
		return "";
	}
		@RequestMapping(value = "/code/codeGroupView") // 리퀘스트매핑은 브라우저 창에뜨는 주소를 말함
		public String codeaGroupView(CodeVo vo, Model model) throws Exception {
			
			System.out.println("vo.getIfcgSeq():" + vo.getIfcgSeq());
			//디비까지 가서 한 건의 데이터 값을 가지고 온다 , vo
			Code rt = service.selectOne(vo);
			// 가지고 온 값을 jsp로 넘겨준다
			model.addAttribute("item", rt);
			return "";
		
		
	}
}