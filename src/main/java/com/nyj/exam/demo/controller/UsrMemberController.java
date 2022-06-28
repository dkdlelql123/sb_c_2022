package com.nyj.exam.demo.controller;

import javax.servlet.http.HttpSession;

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

	@RequestMapping("/usr/member/doLogin")
	@ResponseBody
	public ResultData doLogin(String loginId, String loginPw, HttpSession httpSession) {
		boolean isLogind = false;
		
		if(httpSession.getAttribute("LoginedMemberId") != null) {
			isLogind = true;
		}
		
		if(isLogind) {
			return ResultData.form("F-0", "이미 로그인 상태입니다");
		}
		
		if(Ut.empty(loginId)) {
			return ResultData.form("F-1", "아이디를 입력해주세요.");
		}
		
		if(Ut.empty(loginPw)) {
			return ResultData.form("F-2", "비밀번호를 입력해주세요.");
		}
		
		Member member = memberService.getMemberLoginId(loginId);
		
		if(member==null) {
			return ResultData.form("F-3", "회원정보가 없습니다.");			
		}
		
		if(loginPw != member.getLoginPw()) {
			return ResultData.form("F-4", "비밀번호가 일치하지 않습니다.");
		}
		
		httpSession.setAttribute("LoginedMemberId", member.getLoginId());
		
		return ResultData.form("S-1", Ut.f("%s님 반갑습니다.", loginId));
	}
	
	@RequestMapping("/usr/member/doLogout")
	@ResponseBody
	public ResultData doLogout(HttpSession httpSession) {
		boolean isLogind = false;
		
		if(httpSession.getAttribute("LoginedMemberId") == null) {
			isLogind = true;
		}
		
		if(isLogind) {
			return ResultData.form("F-0", "이미 로그아웃 상태입니다");
		}
		
		httpSession.removeAttribute("LoginedMemberId");
		return ResultData.form("S-1", "로그아웃 성공");
	}
}
