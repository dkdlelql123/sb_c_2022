package com.nyj.exam.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		return "/usr/member/join";
	}

	@RequestMapping("/usr/member/doCheckLoginId")
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
		return "/usr/member/login";
	}

	@RequestMapping("/usr/member/doLogin")
	@ResponseBody
	public String doLogin(String loginId, String loginPw, @RequestParam(defaultValue = "/") String afterLoginUri) {
		if (rq.isLogined() == true) {
			return Ut.jsHistoryBack("이미 로그인 상태입니다");
		}

		if (Ut.empty(loginId)) {
			return Ut.jsHistoryBack("아이디를 입력해주세요.");
		}

		if (Ut.empty(loginPw)) {
			return Ut.jsHistoryBack("비밀번호를 입력해주세요.");
		}

		System.out.println(loginId);
		System.out.println(loginPw);
		Member member = memberService.getMemberLoginId(loginId);

		if (member == null) {
			return Ut.jsHistoryBack("회원정보가 없습니다.");
		}

		if (member.getLoginPw().equals(loginPw) == false) {
			return Ut.jsHistoryBack("회원정보가 일치하지 않습니다.");
		}

		rq.login(member);

		if (member.isAdmin()) {
			return Ut.jsReplace("관리자님 반갑습니다.", "/adm");
		}

		return Ut.jsReplace(Ut.f("%s님 반갑습니다.", member.getNickname()), afterLoginUri);
	}

	@RequestMapping("/usr/member/doLogout")
	@ResponseBody
	public String doLogout(@RequestParam(defaultValue = "/") String afterLogoutUri) {
		if (!rq.isLogined()) {
			return Ut.jsHistoryBack("이미 로그아웃 상태입니다");
		}

		rq.logout();

		return Ut.jsReplace("로그아웃 되었습니다", afterLogoutUri);
	}

	@RequestMapping("/usr/member/mypage")
	public String showMyPage(Model model) {
		model.addAttribute("member", rq.getMember());
		return "/usr/member/mypage";
	}

	@RequestMapping("/usr/member/checkPassword")
	public String showCheckPassword() {
		return "/usr/member/checkPassword";
	}

	@RequestMapping("/usr/member/doCheckPassword")
	@ResponseBody
	public String doCheckPassword(String loginPw, String replaceUri) {

		System.out.println(loginPw);
		System.out.println(rq.getMember().getLoginPw());

		if (rq.getMember().getLoginPw().equals(loginPw) == false) {
			return Ut.jsHistoryBack("비밀번호가 일치하지 않습니다");
		}

		if (replaceUri.equals("../member/modify")) {
			String memberModifyAuthKey = memberService.genMemberModifyAuthKey(rq.getLoginedMemberId());
			replaceUri += "?memberModifyAuthKey=" + memberModifyAuthKey;
		}

		return Ut.jsReplace("", replaceUri);
	}

	@RequestMapping("/usr/member/modify")
	public String showModify(Model model, String memberModifyAuthKey) {
		if (Ut.empty(memberModifyAuthKey)) {
			return rq.historyBackJsOnView("유효키가 없습니다. 올바른 방법으로 이용바랍니다.");
		}

		ResultData checkMemberModifyAuthKeyRd = memberService.checkMemberModifyAuthKey(rq.getLoginedMemberId(),
				memberModifyAuthKey);

		if (checkMemberModifyAuthKeyRd.isFail()) {
			return rq.historyBackJsOnView(checkMemberModifyAuthKeyRd.getMsg());
		}

		model.addAttribute("member", rq.getMember());

		return "/usr/member/modify";
	}

	@RequestMapping("/usr/member/doModify")
	@ResponseBody
	public String doModify(String loginPw, String loginPw2, String email, String nickname, String phoneNumber,
			String memberModifyAuthKey) {
		if (Ut.empty(memberModifyAuthKey)) {
			return rq.historyBackJsOnView("유효키가 없습니다. 올바른 방법으로 이용바랍니다.");
		}

		ResultData checkMemberModifyAuthKeyRd = memberService.checkMemberModifyAuthKey(rq.getLoginedMemberId(),
				memberModifyAuthKey);

		if (checkMemberModifyAuthKeyRd.isFail()) {
			return rq.historyBackJsOnView(checkMemberModifyAuthKeyRd.getMsg());
		}

		if (loginPw.trim().length() <= 0) {
			loginPw = null;
		} else {
			if (loginPw.equals(loginPw2) == false) {
				return Ut.jsHistoryBack("새 비밀번호가 일치하지 않습니다.");
			}
		}

		ResultData doModifyRd = memberService.doModify(rq.getLoginedMemberId(), loginPw, email, nickname, phoneNumber);
		if (doModifyRd.isFail()) {
			return Ut.jsHistoryBack(doModifyRd.getMsg());
		}

		return Ut.jsReplace("회원정보수정이 완료되었습니다.", "/usr/member/mypage");
	}

}
