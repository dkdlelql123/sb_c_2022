package com.nyj.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyj.exam.demo.repository.MemberRepository;
import com.nyj.exam.demo.util.Ut;
import com.nyj.exam.demo.vo.Member;
import com.nyj.exam.demo.vo.ResultData;

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository; 

	public ResultData doCheckLoginId(String loginId) {
		Member oldMember = getMemberLoginId(loginId);
		if(oldMember != null) {
			return ResultData.form("F-1", Ut.f("이미 사용중인 아이디(%s)입니다", loginId));
		}
		return ResultData.form("S-1", Ut.f("사용 가능한 아이디입니다.", loginId));
	}
	
	public ResultData join(String loginId, String loginPw, String email, String name, String nickname, String phoneNumber) {
		Member oldMember = getMemberLoginId(loginId);
		if(oldMember != null) {
			return ResultData.form("F-1", Ut.f("이미 사용중인 아이디(%s)입니다", loginId));
		}
		
		oldMember = getMemberNameAndEmail(name, email);
		if(oldMember != null) {
			return ResultData.form("F-2", Ut.f("이미 사용중인 이름(%s)와 이메일(%s) 입니다", name, email));
		}
		
		memberRepository.join(loginId, loginPw, email, name, nickname, phoneNumber);
		return ResultData.form("S-1", "회원가입이 완료되었습니다.");
	}
	
	public int getLastInsertId() {
		return memberRepository.getLastInsertId();
	}
	
	public Member getMemberLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}
	
	public Member getMemberNameAndEmail(String name, String email) {
		return memberRepository.getMemberNameAndEmail(name, email);
	}

	
}
