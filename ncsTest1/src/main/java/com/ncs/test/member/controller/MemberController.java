package com.ncs.test.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;



@SessionAttributes("signUp")
@Slf4j
@Controller
public class MemberController {
	@Setter(onMethod_=@Autowired)
	private MemberService memberService;
	
	@GetMapping("/")
	public String loginForm() {
		log.info("admin 로그인 화면 호출");
		
		return "index";
	}
	@PostMapping("/login")
	public String memberLogin(Member member, Model model, RedirectAttributes ras) {
		log.info("member: " + member);
		Member signUp = memberService.loginMember(member);
		if(signUp != null) {
			model.addAttribute("signUp", signUp);
		}else {
			ras.addFlashAttribute("errorMsg","로그인 실패");
		}
		return "redirect:/";
			
	}
	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/";
	}
}
