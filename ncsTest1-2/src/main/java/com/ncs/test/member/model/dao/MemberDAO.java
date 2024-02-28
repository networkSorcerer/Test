package com.ncs.test.member.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ncs.test.member.model.vo.Member;


@Mapper
public interface MemberDAO {
	public int signUp (Member member);
}
