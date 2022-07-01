package com.nyj.exam.demo.vo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.Getter;

public class Rq {
	@Getter
	public boolean isLogined;
	@Getter
	public int loginedMemberId;
	@Getter
	public HttpSession session;
	
	public Rq(HttpServletRequest req) {
		this.session = req.getSession();
		boolean isLogined = false;
		int loginedMemberId = 0;
		
		if(session.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId= (int) session.getAttribute("loginedMemberId");
		}
		
		this.isLogined = isLogined;
		this.loginedMemberId = loginedMemberId;
	}

	public void login(Member member) {
		session.setAttribute("loginedMemberId", member.getId());
	}

	public void logout() {
		session.removeAttribute("loginedMemberId");
	}
	
}
