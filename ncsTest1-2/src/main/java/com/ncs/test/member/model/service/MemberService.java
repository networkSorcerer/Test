package com.ncs.test.member.model.service;

import com.ncs.test.member.model.vo.Member;

public interface MemberService {
	/* public int signUp(Member member); */
	public int idDupCheck(String memberId);

	
}
