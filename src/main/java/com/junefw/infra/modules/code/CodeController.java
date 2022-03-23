package com.junefw.infra.modules.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {


	@Autowired
	CodeServiceImpl service;

//	infrCodeGroup
	@RequestMapping(value = "/code/codeGroupList")

	public String codeGroupList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
								//@ModelAttribute는 jsp로 보내는 vo 옆에 CodeVo오는 여기 코드그룹리스트에 사용하는 vo
		// count 가져올 것
		int count = service.selectOneCount(vo);
		
		vo.setParamsPaging(count);

		// count가 0이 아니면 list 가져오는 부분 수행후 model 개체에 담기
		if (count != 0) {
			List<Code> list = service.selectList(vo);

			model.addAttribute("list", list);
		} else {
			// by pass
		}

		//@ModelAttribute("vo", vo); 	위에 @ModelAttribute("vo") 안적고 밑에 빼서 적어도 결과값은 동일함 개발자성향차이임 
		
		return "code/codeGroupList";
	}

	@RequestMapping(value = "/code/codeGroupForm")

	public String codeGroupForm(@ModelAttribute("vo") CodeVo vo) throws Exception {

		return "code/codeGroupForm";
	}

	@RequestMapping(value = "/code/codeGroupInst")

	public String codeGroupInst(Code dto, CodeVo vo , RedirectAttributes redirectAttributes) throws Exception {

		System.out.println("dto.getIfcgSeq(): " + dto.getIfcgSeq());  //null

//		입력 실행
		service.insert(dto);

		System.out.println("dto.getIfcgSeq(): " + dto.getIfcgSeq());  // 추가된 갯수나옴
		
		redirectAttributes.addAttribute("ifcgSeq", dto.getIfcgSeq());
		redirectAttributes.addAttribute("ThisPage", vo.getThisPage());
		redirectAttributes.addAttribute("ShOption", vo.getShOption());
		redirectAttributes.addAttribute("ShValue", vo.getShValue());
		
//		return "redirect:/code/codeGroupList";
//		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq();
		return "redirect:/code/codeGroupList?ifcgSeq=" + dto.getIfcgSeq() + makeQueryString(vo);
	}
	public String makeQueryString(CodeVo vo) {
		String tmp = 
				"&thisPage=" + vo.getThisPage() + 
				"&shOption=" + vo.getShOption() + 
				"&shValue=" + vo.getShValue();
		
		return tmp;
	}
	

	@RequestMapping(value = "/code/codeGroupView")

	public String codeGroupView(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		System.out.println("vo.getShOption(): " +vo.getShOption());
		System.out.println("vo.getShValue(): " + vo.getShValue());
		System.out.println("vo.getThisPage(): " + vo.getThisPage());
		System.out.println("vo.getIfcgSeq(): " + vo.getIfcgSeq());

		// 디비까지 가서 한 건의 데이터 값을 가지고 온다, VO
		Code rt = service.selectOne(vo);

		// 가지고 온값을 jsp로 넘겨준다
		model.addAttribute("item", rt);

		return "code/codeGroupView";
	}
 
	// 수정폼이 보여지는 주소

	@RequestMapping(value = "/code/codeGroupForm2")
	public String codeGroupForm2(CodeVo vo, Model model) throws Exception {

		// 한건의 데이터 가져오기
		Code rt = service.selectOne(vo);

		model.addAttribute("rt", rt);

		return "/code/codeGroupForm2";
	}

	// 실제 수정을 하는 주소

	@RequestMapping(value = "/code/codeGroupUpdt")
	public String codeGroupUpdt(Code dto) throws Exception {

		// 수정 프로세스 실행
		service.update(dto);

		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq();
	}
	
	@RequestMapping(value = "/code/codeGroupDele")
	public String codeGroupDele(CodeVo vo, RedirectAttributes redirectAttributes) throws Exception {

		service.delete(vo); // vo나 dto 사용하려면 위에다가 넣어줘야된다.
		
		redirectAttributes.addAttribute("thisPage", vo.getThisPage());
		redirectAttributes.addAttribute("ShOption", vo.getShOption());
		redirectAttributes.addAttribute("ShValue", vo.getShValue());
		
		
		return "redirect:/code/codeGroupList?shifcgSeq=" + vo.getIfcgSeq();
	}
		
	@RequestMapping(value = "/code/codeGroupNele")
	public String codeGroupNele(CodeVo vo, RedirectAttributes redirectAttributes) throws Exception {
		
		service.updateDelete(vo);
		
		redirectAttributes.addAttribute("ThisPage" , vo.getThisPage());
		redirectAttributes.addAttribute("ShOption" , vo.getShOption());
		redirectAttributes.addAttribute("ShValue" , vo.getShValue());
		
		/*return "redirect:/code/codeGroupList";}*/
		 return "redirect:/code/codeGroupList?shifcgSeq=" + vo.getIfcgSeq();
	}
			
		// infrCode	
		@RequestMapping(value = "/code/codeList") // 리퀘스트매핑은 브라우저 창에뜨는 주소를 말함
		public String codeList(CodeVo vo,Model model) throws Exception {
			
			List<Code> list = service.selecListCode(vo);
			model.addAttribute("list", list); // codeGroupList에 있는 list를 말함 왼쪽의 이름으로 오른쪽 데이터를 보내라.

			List<Code> listCodeGroup = service.selectList(vo);
			model.addAttribute("listCodeGroup", listCodeGroup); // codeGroupList에 있는 list를 말함 왼쪽의 이름으로 오른쪽 데이터를 보내라.
	 		
			
			return "code/codeList";
		}
		
		@RequestMapping(value = "/code/codeForm") // 리퀘스트매핑은 브라우저 창에뜨는 주소를 말함
		public String codeForm(Model model) throws Exception {
			
//			List <Code> list = service.selecListCode();
//			
//			model.addAttribute("list", list);
			
			return "code/codeForm";
		}
		
		@RequestMapping(value = "/code/codeInst") // 인서트 삽입
		public String codeInst(Code dto) throws Exception {
			
			//입력실행
			service.insertCode(dto);
			
			return "redirect:/code/codeList?ifcdSeq="+dto.getIfcdSeq();
		}
			@RequestMapping(value = "/code/codeView") // 뷰.jsp에 대한 화면나옴
			public String codeView(CodeVo vo, Model model) throws Exception {
				
				System.out.println("vo.getIfcdSeq():" + vo.getIfcdSeq());
				//디비까지 가서 한 건의 데이터 값을 가지고 온다 , vo
				Code rt = service.selectOneCode(vo);
				// 가지고 온 값을 jsp로 넘겨준다
				model.addAttribute("item", rt);
				
				return "code/codeView";
			
			
		}
			@RequestMapping(value = "/code/codeForm2") // 수정모드
			public String codeForm2(CodeVo vo, Model model) throws Exception {

				Code rt = service.selectOneCode(vo); // vo 에서 데이터 가져오기 
			
				
				model.addAttribute("item", rt); // jsp 들어가보면 list, item, rt 등등있는데 거기에 이름과 동일한 곳에 데이터를 넣겠다.
				
				return "code/codeForm2";
			}
			
			@RequestMapping(value = "/code/codeUpdt")
			public String codeUpdt(Code dto) throws Exception {
				
				service.updateCode(dto);

				return "redirect:/code/codeView?ifcdSeq="+dto.getIfcdSeq();  // 데이터가 넘어가면 404 파일로뜸
				
				
			}
	}
		
