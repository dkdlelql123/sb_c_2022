package com.nyj.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
	
	private int count;
	
	public UsrHomeController() {
		count = -1;
	}
	
	@RequestMapping("/usr/home/main")
	@ResponseBody
	public String showHome() {
		count++;
		return count+"안녕하세요";
	}
	
	@RequestMapping("/usr/home/main1")
	@ResponseBody
	public String showHome1() {
		count++;
		return count+"반가워요";
	}
}
