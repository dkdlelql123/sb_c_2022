package com.nyj.exam.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nyj.exam.demo.service.ReplyService;
import com.nyj.exam.demo.util.Ut;
import com.nyj.exam.demo.vo.ResultData;
import com.nyj.exam.demo.vo.Rq;

@Controller
public class usrReplyController {
	
	@Autowired
	ReplyService replyService;
	
	private Rq rq;
	
	public usrReplyController(Rq rq) {
		this.rq = rq;
	}
	
	@RequestMapping("/usr/reply/doWrite")
	@ResponseBody
	public String doWrite(String replaceUri, String body, int id) {
		ResultData rd = replyService.doWriteReply(rq.getLoginedMemberId(), "article", id, body);
	
		return Ut.jsReplace("", replaceUri);
	}
	
	@RequestMapping("/usr/reply/doModify")
	@ResponseBody
	public String doModify(String replaceUri, int id, String body) {
		replyService.doModify(id, body);
		return Ut.jsReplace("", replaceUri);
	}
	
	@RequestMapping("/usr/reply/doDelete")
	@ResponseBody
	public String doDelete(String replaceUri, int id) {
		replyService.doDelete(id);
		return Ut.jsReplace("", replaceUri);
	}
}
