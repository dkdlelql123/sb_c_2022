package com.nyj.exam.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.nyj.exam.demo.vo.Rq;

@Component
public class NeedAdminInterceptor implements HandlerInterceptor {

	private Rq rq;
	
	public NeedAdminInterceptor(Rq rq) {
		this.rq = rq;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		if(!rq.isAdmin()) {
			rq.printReplaceJs("관리자 계정으로 로그인해주세요", "/");
			return false;
		}  

		return HandlerInterceptor.super.preHandle(req, resp, handler);
	}
}
