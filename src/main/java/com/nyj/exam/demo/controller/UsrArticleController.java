package com.nyj.exam.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nyj.exam.demo.service.ArticleService;
import com.nyj.exam.demo.util.Ut;
import com.nyj.exam.demo.vo.Article;
import com.nyj.exam.demo.vo.ResultData;

@Controller
public class UsrArticleController {

	@Autowired
	ArticleService articleService;

	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public ResultData doAdd(String title, String body, HttpSession httpSession) {
		boolean isLogind = false;
		int loginMemberId = 0;
		
		if(httpSession.getAttribute("LoginedMemberId") != null) {
			isLogind = true;
			loginMemberId = (int) httpSession.getAttribute("LoginedMemberId");
		}
		
		if (isLogind == false) {
			return ResultData.form("F-0", "로그인 이후에 사용가능합니다.");
		}

		if (Ut.empty(title)) {
			return ResultData.form("F-2", Ut.f("제목을 입력해주세요"));
		}

		if (Ut.empty(body)) {
			return ResultData.form("F-3", Ut.f("내용을 입력해주세요"));
		}

		ResultData writeArticleRd = articleService.writeArticle(loginMemberId, title, body);
		int id = (int) writeArticleRd.getData1();

		Article article = articleService.getArticle(loginMemberId,id);

		return ResultData.newData(writeArticleRd, article);
	}

	@RequestMapping("/usr/article/list")
	public String showList(Model model) {
		List<Article> articles = articleService.getArticles();
		
		model.addAttribute("articles", articles);
		
		return "usr/article/list";
	}
	
	@RequestMapping("/usr/article/detail")
	public String showDetail(HttpSession httpSession, Model model, int id) {
		boolean isLogind = false;
		int LoginedMemberId = 0;
		
		if(httpSession.getAttribute("LoginedMemberId") != null) {
			isLogind = true;
			LoginedMemberId = (int) httpSession.getAttribute("LoginedMemberId");
		}
		
		Article article = articleService.getArticle(LoginedMemberId, id);
		model.addAttribute("article", article);
		
		return "usr/article/detail";
	}

	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public ResultData getArticleAction(HttpSession httpSession,int id) {
		boolean isLogind = false;
		int LoginedMemberId = 0;
		
		if(httpSession.getAttribute("LoginedMemberId") != null) {
			isLogind = true;
			LoginedMemberId = (int) httpSession.getAttribute("LoginedMemberId");
		}
		
		Article article = articleService.getArticle(LoginedMemberId, id);

		if (article == null) {
			return ResultData.form("F-1", Ut.f("%d번 게시물이 존재하지 않습니다.", id));
		}

		return ResultData.form("S-1", Ut.f("%d번 게시물입니다.", id), article);
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(HttpSession httpSession, int id) {
		boolean isLogind = false;
		int memberId = 0;
		
		if(httpSession.getAttribute("LoginedMemberId") != null) {
			isLogind = true;
			memberId = (int) httpSession.getAttribute("LoginedMemberId");
		}
		
		if (isLogind == false) {
			return Ut.jsHistoryBack("로그인 이후에 사용가능합니다."); 
		}
		
		Article article = articleService.getArticle(memberId, id);
		if (article == null) {
			return Ut.jsHistoryBack("해당 게시물이 없습니다.");
		}
		
		if(article.getMemberId() != memberId) {
			return Ut.jsHistoryBack("권한이 없습니다.");  
		}
		articleService.deleteArticle(id);

		return Ut.jsReplace("게시물이 삭제되었습니다..", "/usr/article/list"); 
	}

	@RequestMapping("/usr/article/modify")
	public String showModify(HttpSession httpSession, int id, Model model) {
		boolean isLogind = false;
		int memberId = 0;
		
		if(httpSession.getAttribute("LoginedMemberId") != null) {
			isLogind = true;
			memberId = (int) httpSession.getAttribute("LoginedMemberId");
		}
		
		if (isLogind == false) {
			return  "로그인 이후에 사용가능합니다.";
		}
		
		Article article = articleService.getArticle(memberId, id); 
		
		model.addAttribute("article", article);
		
		return "/usr/article/modify";
	}

	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public String doModify(HttpSession httpSession, int id, String title, String body) {
		boolean isLogind = false;
		int loginMemberId = 0;
		
		if(httpSession.getAttribute("loginMemberId") != null) {
			isLogind = true;
			loginMemberId = (int) httpSession.getAttribute("loginMemberId");
		} 
		
		Article article = articleService.getArticle(loginMemberId, id);

		if (article == null) {
			return Ut.jsHistoryBack("해당 게시물이 없습니다.");
		}

		articleService.modifyArticle(id, title, body);
		article = articleService.getArticle(loginMemberId,id);
		
		return "게시물이 수정되었습니다";
	}

}
