package com.nyj.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.nyj.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {   
	public void writeArticle(@Param("memberId") int memberId, @Param("title") String title, @Param("body") String body);  
 
	public Article getArticle(@Param("id") int id); 
	
	public Article getForPrintArticle(@Param("id") int id); 
	 
	public List<Article> getArticles(@Param("boardId") int boardId);  
	
	public List<Article> getForPrintArticles(@Param("boardId") int boardId);  

	public int getArticlesCount(@Param("boardId")int boardId);
	 
	public void deleteArticle(@Param("id") int id); 
	  
	public void modifyArticle(@Param("id") int id, @Param("title") String title, @Param("body") String body);
 
	public int getLastInsertId();

	
}
