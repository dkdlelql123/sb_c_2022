package com.nyj.exam.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nyj.exam.demo.service.MemberService;
import com.nyj.exam.demo.util.Ut;
import com.nyj.exam.demo.vo.Member;
import com.nyj.exam.demo.vo.ResultData;
import com.nyj.exam.demo.vo.Rq;

@Controller
public class UsrMemberController {

	@Autowired
	MemberService memberService;

	private Rq rq;

	public UsrMemberController(Rq rq) {
		this.rq = rq;
	}

	@RequestMapping("/usr/member/join")
	public String showJoin() {
		System.out.println("회원가입 페이지");
		return "/usr/member/join";
	}
	
	@RequestMapping("usr/member/doCheckLoginId")
	@ResponseBody
	public ResultData doCheckLoginId(String loginId) {
		ResultData doCheckLoginIdRd = memberService.doCheckLoginId(loginId);
		return doCheckLoginIdRd;
	}
	
	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public String doJoin(String loginId, String loginPw, String email, String name, String nickname, String phoneNumber) {

		ResultData joinRd = memberService.join(loginId, loginPw, email, name, nickname, phoneNumber);
		if (joinRd.isFail()) {
			return Ut.jsHistoryBack(joinRd.getMsg());
		}

		int id = memberService.getLastInsertId(); 

		return Ut.jsReplace(joinRd.getMsg(), "/usr/member/login");
	}

	@RequestMapping("/usr/member/login")
	public String showLogin() {
		System.out.println("로그인 페이지");
		return "/usr/member/login";
	}

	@RequestMapping("/usr/member/doLogin")
	@ResponseBody
	public String doLogin(String loginId, String loginPw) {
		if (rq.isLogined() == true) {
			return Ut.jsHistoryBack("이미 로그인 상태입니다");
		}

		if (Ut.empty(loginId)) {
			return Ut.jsHistoryBack("아이디를 입력해주세요.");
		}

		if (Ut.empty(loginPw)) {
			return Ut.jsHistoryBack("비밀번호를 입력해주세요.");
		}

		Member member = memberService.getMemberLoginId(loginId);

		if (member == null) {
			return Ut.jsHistoryBack("회원정보가 없습니다.");
		}

		if (member.getLoginPw().equals(loginPw) == false) {
			return Ut.jsHistoryBack("비밀번호가 일치하지 않습니다.");
		}

		rq.login(member);
		// Ut.f("'%s'님 반갑습니다.", member.getNickname()
		return Ut.jsReplace("반갑습니다", "/");
	}

	@RequestMapping("/usr/member/doLogout")
	@ResponseBody
	public String doLogout() {
		 if (!rq.isLogined()) {
			return Ut.jsHistoryBack("이미 로그아웃 상태입니다");
		}

		rq.logout();

		return Ut.jsReplace("로그아웃 되었습니다", "/");
	}
	
	
	@RequestMapping("/usr/member/mypage")
	public String showMyPage() {
		return "/usr/member/mypage";
	}
	
}
