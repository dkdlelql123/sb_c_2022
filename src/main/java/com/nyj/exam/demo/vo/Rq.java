package com.nyj.exam.demo.vo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.Getter;

public class Rq {
	
	@Getter
	public boolean isLogind;
	@Getter
	public int loginedMemberId;
	
	public Rq(HttpServletRequest req) {
		HttpSession httpSession = req.getSession();
		
		if(httpSession.getAttribute("loginedMemberId") != null) {
			isLogind = true;
			loginedMemberId= (int) httpSession.getAttribute("LoginedMemberId");
		}
	}

	public void logout(HttpServletRequest req) { 		
		HttpSession httpSession = req.getSession();
		isLogind = false;
		httpSession.removeAttribute("loginedMemberId");
		loginedMemberId=0;
	}
	
	
}
