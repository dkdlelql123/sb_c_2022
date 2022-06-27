package com.nyj.exam.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nyj.exam.demo.vo.Article;

@Component
public class ArticleRepository {

	private int articleLastId;
	private List<Article> articles;
	
	public ArticleRepository() {
		articleLastId = 0;
		articles = new ArrayList<Article>();
	}
	
	public Article writeArticle(String title, String body) {
		articleLastId++;
		Article article = new Article(articleLastId, title, body);
		articles.add(article);
		return article;
	}

	public Article getArticle(int id) {
		for(Article article : articles) {
			if( article.getId() == id) {
				return article; 
			}
		}
		return null;
	}
	
	public List<Article> getArticles() { 
		return articles;
	}
	
	public void deleteArticle(int id) {
		Article article = getArticle(id);
		articles.remove(article);
	}
	 
	public void modifyArticle(int id, String title, String body) {
		Article article = getArticle(id);
		article.setTitle(title);
		article.setBody(body); 
	}
	
	

}
