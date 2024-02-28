package com.ncs.test.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.test.member.model.dao.MemberDAO;
import com.ncs.test.member.model.vo.Member;

import lombok.Setter;

@Service
public class MemberServiceImpl implements MemberService{
	@Setter(onMethod_=@Autowired)
	private MemberDAO memberDAO;
	
	@Override
	public int signUp(Member member) {
		int signUp = memberDAO.signUp(member);
		return signUp;
	}
}
