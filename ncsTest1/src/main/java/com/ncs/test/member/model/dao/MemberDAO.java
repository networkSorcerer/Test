package com.ncs.test.member.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ncs.test.member.model.vo.Member;

@Mapper
public interface MemberDAO {
	public Member loginMember (Member member); 
	//어디서 값을 가져오면 또 다른데 담는게 특징 그때마다 이름이 달라질수도 같을 수도 있음
	//처음에는 loginMember로 시작해서 다시 signUp에 담음 
}
