package com.nyj.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.nyj.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {  
	
	//@Insert("INSERT INTO article SET regDate = NOW(), updateDate = NOW(), title =  #{title},`body` =  #{body}")
	public Article writeArticle(@Param("title") String title, @Param("body") String body);  

	@Select("SELECT * FROM article WHERE id = #{id}")
	public Article getArticle(@Param("id") int id); 
	
	@Select("SELECT * FROM article")
	public List<Article> getArticles();  
	
	@Delete("DELETE FROM article WHERE id = #{id}")
	public void deleteArticle(@Param("id") int id); 
	 
	public void modifyArticle(int id, String title, String body);  
	
}
