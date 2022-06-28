package com.nyj.exam.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyj.exam.demo.repository.ArticleRepository;
import com.nyj.exam.demo.util.Ut;
import com.nyj.exam.demo.vo.Article;
import com.nyj.exam.demo.vo.ResultData;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	public ArticleService( ) {
		
	}

	public ResultData writeArticle(int memberId, String title, String body) {
		articleRepository.writeArticle(memberId, title, body);
		int id = articleRepository.getLastInsertId(); 
		return ResultData.form("S-1", Ut.f("%d번 게시물 생성 되었습니다", id), id); 
	}

	public List<Article> getArticles() { 
		return articleRepository.getArticles();
	}

	public Article getArticle(int id) {
		return articleRepository.getArticle(id);
	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}

	public void modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id,title,body);		
		
	}
	
	
}
