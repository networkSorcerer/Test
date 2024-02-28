package com.ncs.test.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/*@SessionAttributes("msg")
@Controller
public class MemberController {
//	
//	@Setter(onMethod_=@Autowired)
//	private MemberService memberService;
//	
//	@GetMapping("/")
//	public String signUpForm() {
//		return "index";
//	}
//	@PostMapping("/login")
//	public String memberLogin(Member member, Model model) {
//		String message= null;
//		try {
//			int result = memberService.signUp(member);
//			
//			if(result >0 ) {
//				message ="회원 가입 성공";
//			} else {
//				message ="회원 가입 실패";
//			}
//			model.addAttribute("msg", message);
//			}catch (Exception e) {
//				model.addAttribute("msg", "회원기입 과정에서 오류 발생");
//			}
//			return "redirect:/";
//	}
}
*/

@Controller
public class MemberController {
@Setter(onMethod_ = @Autowired)
private MemberService memberService;

@GetMapping("/")
public String memberLoginForm() {
	return "index";
}

@ResponseBody
@PostMapping("idDupCheck")
public String idDupCheck(String memberId) {
	return String.valueOf(memberService.idDupCheck(memberId) == 0 ? true : false);
}
}