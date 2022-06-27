package com.nyj.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyj.exam.demo.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;
	
	public void join(String loginId, String loginPw, String email, String name, String nickname, String phoneNumber) {
		memberRepository.join(loginId, loginPw, email, name, nickname, phoneNumber);
	}

	public int getLastInsertId() {
		return memberRepository.getLastInsertId();
	}
	
	
	
}
