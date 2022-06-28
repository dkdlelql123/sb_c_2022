package com.nyj.exam.demo.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
	
	@RequestMapping("/")
	public String main() {
		return "redirect:/usr/home";  
	}
	
	@RequestMapping("/usr/home") 
	public String showHome() {
		return "usr/home/index";
	}
}
