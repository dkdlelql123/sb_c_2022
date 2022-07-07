package com.nyj.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyj.exam.demo.repository.ReactionPointRepository;
import com.nyj.exam.demo.vo.ResultData;
import com.sun.net.httpserver.Authenticator.Result;

@Service
public class ReactionPointService {
	@Autowired
	ReactionPointRepository reactionPointRepository;
	@Autowired
	ArticleService articleService;
	
	public ResultData actorCanMakeReactionPoint(int memberId, String relCodeType, int articleId) {
		if(memberId == 0) {
			return ResultData.form("F-1", "로그인 이후 이용해주세요.");
		}
		
		int actorCanMakeReactionPoint = reactionPointRepository.actorCanMakeReactionPoint(memberId, relCodeType, articleId);
		if(actorCanMakeReactionPoint != 0) {
			return ResultData.form("F-2", "이미 리액션이 처리되었습니다.", "actorCanMakeReactionPoint", actorCanMakeReactionPoint );
		}
		
		return ResultData.form("S-1", "리액션이 가능합니다.","actorCanMakeReactionPoint", actorCanMakeReactionPoint);
	}

	public ResultData addIncreaseGoodReactionPoint(int memberId, String relCodeType, int relId) {
		reactionPointRepository.addIncreaseGoodReactionPoint(memberId, relCodeType, relId);
		
		switch (relCodeType) {
		case "article": 
			articleService.increaseGoodReactionPoint(relId);
			break; 
		}
		
		return ResultData.form("S-1", "게시물 좋아요 처리되었습니다.");
	}

	public ResultData addIncreaseBadReactionPoint(int memberId, String relCodeType, int relId) {
		reactionPointRepository.addIncreaseBadReactionPoint(memberId, relCodeType, relId);	
		
		switch (relCodeType) {
		case "article": 
			articleService.increaseBadReactionPoint(relId);
			break; 
		}
		
		return ResultData.form("S-1", "게시물 싫어요 처리되었습니다.");
	}
	
}
