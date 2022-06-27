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

	private Article getArticle(int id) {
		for(Article article : articles) {
			if( article.getId() == id) {
				return article; 
			}
		}
		return null;
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
	
	@RequestMapping("/usr/article/delete")
	@ResponseBody
	public String deleteArticle(int id) {
		Article article = getArticle(id);
		
		if(article == null) {
			return id+"번 게시물이 존재하지 않습니다.";
		}
		
		articles.remove(article);
		return id+"번 게시물이 삭제되었습니다.";
	}
}
