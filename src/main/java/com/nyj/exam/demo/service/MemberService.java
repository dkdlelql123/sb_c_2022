package com.nyj.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyj.exam.demo.repository.MemberRepository;
import com.nyj.exam.demo.vo.Member;

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;
	
	public int join(String loginId, String loginPw, String email, String name, String nickname, String phoneNumber) {
		Member oldMember = getMemberLoginId(loginId);
		if(oldMember != null) {
			return -1;
		}
		memberRepository.join(loginId, loginPw, email, name, nickname, phoneNumber);
		return 1;
	}

	public int getLastInsertId() {
		return memberRepository.getLastInsertId();
	}
	
	public Member getMemberLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}

	public Member getMemberId(int id) {
		return memberRepository.getMemberById(id);
	}
	
}
