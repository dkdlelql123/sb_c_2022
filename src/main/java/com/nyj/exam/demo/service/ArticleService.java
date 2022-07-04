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

	public ResultData writeArticle(int memberId, int boardId, String title, String body) {
		articleRepository.writeArticle(memberId, boardId, title, body);
		int id = articleRepository.getLastInsertId(); 
		return ResultData.form("S-1", Ut.f("%d번 게시물 생성 되었습니다", id), id); 
	}

	public List<Article> getArticles(int boardId,int page, int itemsCountInAPage) { 
		int limitStart = (page - 1) * itemsCountInAPage;
		int limitTake = itemsCountInAPage;
		
		return articleRepository.getArticles(boardId, limitStart, limitTake); 
	} 

	public List<Article> getForPrintArticles(int memberId, int boardId) {
		List<Article> articles = articleRepository.getForPrintArticles(boardId);
		for(Article article : articles) {
			actorCanEdit(memberId, article);
		}
		return articles;
	}
	
	public Article getArticle(int id) { 		
		return articleRepository.getArticle(id); 
	}

	public Article getForPrintArticle(int LoginedMemberId,int id) {
		Article article = articleRepository.getForPrintArticle(id);
		
		ResultData actorCanEditRd = actorCanEdit(LoginedMemberId, article); 
		
		article.setExtra__actorCanEdit(actorCanEditRd.isSuccess());
		
		return article;
	} 

	public ResultData actorCanEdit(int loginedMemberId, Article article) {
		if(article == null) {
			return ResultData.form("F-1", "게시물이 존재하지 않습니다.");
		}
		
		if(article.getMemberId() != loginedMemberId) {
			return ResultData.form("F-2", "권한이 없습니다.");
		}
		
		return ResultData.form("S-1", Ut.f("%d번 게시물 수정이 완료되었습니다", article.getId()), article); 
	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}

	public void modifyArticle(int id, int boardId, String title, String body) {
		articleRepository.modifyArticle(id,boardId,title,body);		
	}

	public int getArticlesCount(int boardId, String keywordType, String keyword) {
		return articleRepository.getArticlesCount(boardId, keywordType, keyword);
	}
	
	
}
