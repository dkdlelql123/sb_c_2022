package com.nyj.exam.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nyj.exam.demo.service.ArticleService;
import com.nyj.exam.demo.util.Ut;
import com.nyj.exam.demo.vo.Article;
import com.nyj.exam.demo.vo.Member;
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

		Article article = articleService.getArticle(id);

		return ResultData.newData(writeArticleRd, article);
	}

	@RequestMapping("/usr/article/showList")
	@ResponseBody
	public ResultData showList() {
		List<Article> articles = articleService.getArticles();
		return ResultData.form("S-1", "게스트 리스트입니다", articles);
	}

	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public ResultData getArticleAction(int id) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return ResultData.form("F-1", Ut.f("%d번 게시물이 존재하지 않습니다.", id));
		}

		return ResultData.form("S-1", Ut.f("%d번 게시물입니다.", id), article);
	}

	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public ResultData doDelete(int id) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return ResultData.form("F-1", Ut.f("%d번 게시물이 존재하지 않습니다.", id));
		}

		articleService.deleteArticle(id);

		return ResultData.form("S-1", Ut.f("%d번 게시물이 삭제되었습니다.", id));
	}

	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public ResultData doModify(int id, String title, String body) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return ResultData.form("F-1", Ut.f("%d번 게시물이 존재하지 않습니다.", id));
		}

		articleService.modifyArticle(id, title, body);
		article = articleService.getArticle(id);
		
		return ResultData.form("S-1", Ut.f("%d번 게시물이 수정되었습니다.", id), article);
	}

}
