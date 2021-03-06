package com.nyj.exam.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.nyj.exam.demo.vo.Rq;

@Component
public class NeedLogoutInterceptor implements HandlerInterceptor {

	private Rq rq;
	
	public NeedLogoutInterceptor(Rq rq) {
		this.rq = rq;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		if(rq.isLogined()) {
			String afterLogoutUri = rq.getAfterLogoutUri();  
			rq.printReplaceJs("로그아웃 이후 이용할 수 있습니다.", "/usr/member/doLogout?afterLogoutUri="+afterLogoutUri);
			return false;
		}

		return HandlerInterceptor.super.preHandle(req, resp, handler);
	}
}
