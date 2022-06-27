package com.nyj.exam.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nyj.exam.demo.vo.Article;

@Controller
public class UsrArticleController {
	
	private int articleLastId;
	private List<Article> articles;
	
	public UsrArticleController() {
		articleLastId = 0;
		articles = new ArrayList<Article>() ;
	}
	
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		articleLastId++;
		Article article = new Article(articleLastId, title, body);
		articles.add(article);
		
		return article;
	}
	
	@RequestMapping("/usr/article/showList")
	@ResponseBody
	public List<Article> showList() {	
		return articles;
	}
}
