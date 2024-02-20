package edu.kh.project.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	// 등록된 Bean 중에서 필드와 타입이 일치하는 Bean 주입
	@Autowired
	private MemberService service;
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest req) {
		String inputEmail = req.getParameter("inputEmail");
		
		System.out.println(inputEmail);
		
		return "redirect:/";
	}
	
	
//	@PostMapping("/login")
	public String login(/*@RequestParam("inputEmail")*/ String inputEmail,
						@RequestParam("inputPw") String inputPw) {
		
		// @RequestParam(value="name", required="fasle", defaultValue="1")
		// [속성]
		// value : 전달 받은 input 태그의 name 속성값
		  
		// required : 입력된 name 속성값 파라미터 필수 여부 지정(기본값 true)
		// -> required = true인 파라미터가 존재하지 않는다면 400 Bad Request 에러 발생
		// -> required = true인 파라미터가 null인 경우에도 400 Bad Request
		
		// defaultValue : 파라미터 중 일치하는 name 속성 값이 없을 경우에 대입할 값 지정.
		// -> required = false인 경우 사용
		
		return "redirect:/";
	}
	
	
	@PostMapping("/login")
	public String login(/*@ModelAttribute*/ Member inputMember) {
		
		// 파라미터 전달 방법 3 : @ModelAttribute를 이용한 방법
		
		// - DTO(또는 VO)와 같이 사용하는 어노테이션
		
		// - 전달 받은 파라미터의 name 속성 값이 
		// 같이 사용되는 DTO의 필드명과 같다면
		// 자동으로 setter를 호출해서 필드에 값을 세팅
		
		// *** @ModelAttribute 사용 시 주의사항 ***
		// - DTO에 기본 생성자가 필수로 존재해야 함
		// - DTO에 setter가 필수로 존재해야 한다.
		
		// *** @ModelAttribute 어노테이션은 생략이 가능함
		
		// *** @ModelAttribute를 이용해 값이 필드에 세팅된 객체를
		//     "커맨드 객체"라고 한다 ****
		
		return "redirect:/";
	}
	
	
	/** 로그인 요청 처리 (찐)
	 * @return 메인페이지 redirect 주소
	 */
	
	@PostMapping("/login")
	public String login(Member inputMember, Model model) {
		
		// Member inputMember : 커맨드 객체(필드에 파라미터 담겨있음)
		
		// 로그인 서비스 호출
		Member loginMember = service.login(inputMember);
		
		return null;
	}
}


