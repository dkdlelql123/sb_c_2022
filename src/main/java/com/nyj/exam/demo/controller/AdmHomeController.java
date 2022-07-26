package com.nyj.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmHomeController {
	
	@RequestMapping("/adm")
	public String main() {
		return "redirect:/adm/home";
	}
	
	@RequestMapping("/adm/home")
	public String showMain() {
		return "/adm/home/index";
	}
	
}
