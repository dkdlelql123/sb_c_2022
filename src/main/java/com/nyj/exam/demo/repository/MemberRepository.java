package com.nyj.exam.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nyj.exam.demo.vo.Member;

@Mapper
public interface MemberRepository {

	void join(@Param("loginId") String loginId, @Param("loginPw") String loginPw, @Param("email") String email, @Param("name") String name,@Param("nickname") String nickname, @Param("phoneNumber")String phoneNumber);

	int getLastInsertId();

	Member getMemberByLoginId(@Param("loginId") String loginId);
	
	Member getMemberById(@Param("id") int id);

	Member getMemberNameAndEmail(@Param("name") String name, @Param("email") String email);

	void modify(int memberId,String loginPw, String email,String nickname, String phoneNumber);
}
