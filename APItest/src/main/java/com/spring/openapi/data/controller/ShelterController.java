package com.spring.openapi.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.spring.openapi.data.service.ShelterService;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping(value="/data/*")
@Slf4j
public class ShelterController {
	
	@Setter(onMethod_=@Autowired)
	private ShelterService dataService;
	
	@GetMapping("/shelterView")
	public String shelterView() {
		log.info("지진/해일 대피소 조회 화면 - 리스트");
		
		return "data/shelterView";
	}
	
	@ResponseBody
	@GetMapping(value="/shelterList", produces = "application/json; charset=UTF-8")
	public String shelterList() throws Exception {
		log.info("지진/해일 대피소 조회 ");
		
		StringBuffer sb =  dataService.shelterList();//s 소문자인지 대문자인지 확인 
		return sb.toString();
	}
}
