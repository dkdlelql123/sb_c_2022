package com.nyj.exam.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyj.exam.demo.service.ArticleService;
import com.nyj.exam.demo.vo.Article;

@Controller
public class UsrHomeController {
	
	@Autowired
	ArticleService articleService;
	
	
	@RequestMapping("/")
	public String main() {
		return "redirect:/usr/home";  
	}
	
	@RequestMapping("/usr/home") 
	public String showHome(Model model) {
		
		List<Article> bestArticles = articleService.getBestArticles();
		model.addAttribute("bestArticles", bestArticles);

		List<Article> newArticles = articleService.getNewArticles();
		model.addAttribute("newArticles", newArticles);
		
		return "usr/home/index";
	}
}
