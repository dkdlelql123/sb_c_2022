package com.nyj.exam.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nyj.exam.demo.service.MemberService;
import com.nyj.exam.demo.util.Ut;
import com.nyj.exam.demo.vo.Member;
import com.nyj.exam.demo.vo.ResultData;

@Controller
public class UsrMemberController {
	
	@Autowired
	MemberService memberService;
	
	
	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public ResultData doJoin(String loginId, String loginPw, String email, String name, String nickname, String phoneNumber) {
		
		if(Ut.empty(loginId)){
			return ResultData.form("F-3", "아이디(을)를 입력해주세요.");
		}
		if(Ut.empty(loginPw)){
			return ResultData.form("F-4", "비밀번호(을)를 입력해주세요.");
		}
		if(Ut.empty(email)){
			return ResultData.form("F-5", "이메일(을)를 입력해주세요.");
		}
		if(Ut.empty(name)){
			return ResultData.form("F-6", "이름(을)를 입력해주세요.");
		}
		if(Ut.empty(nickname)){
			return ResultData.form("F-7", "별명(을)를 입력해주세요.");
		}
		if(Ut.empty(phoneNumber)){
			return ResultData.form("F-8", "핸드폰번호(을)를 입력해주세요.");
		}
		
		ResultData joinRd = memberService.join(loginId, loginPw, email, name, nickname, phoneNumber);
		if(joinRd.isFail()) {
			return joinRd;
		}
			
		int id = memberService.getLastInsertId();	
		Member member = memberService.getMemberId(id);
		
		return ResultData.form(joinRd.getResultCode(),joinRd.getMsg(), member) ;
	}

}
