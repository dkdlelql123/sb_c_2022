package com.nyj.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyj.exam.demo.repository.ReactionPointRepository;
import com.nyj.exam.demo.util.Ut;
import com.nyj.exam.demo.vo.ResultData;

@Service
public class ReactionPointService {
	@Autowired
	ReactionPointRepository reactionPointRepository;
	@Autowired
	ArticleService articleService;
	@Autowired
	ReplyService replyService;

	public ResultData actorCanMakeReactionPoint(int memberId, String relTypeCode, int relId) {
		if (memberId == 0) {
			return ResultData.form("F-1", "로그인 이후 이용해주세요.");
		}

		int actorCanMakeReactionPoint = reactionPointRepository.actorCanMakeReactionPoint(memberId, relTypeCode, relId);
		if (actorCanMakeReactionPoint != 0) {
			return ResultData.form("F-2", "이미 리액션이 처리되었습니다.", "actorCanMakeReactionPoint", actorCanMakeReactionPoint);
		}

		return ResultData.form("S-1", "리액션이 가능합니다.", "actorCanMakeReactionPoint", actorCanMakeReactionPoint);
	}

	public ResultData addIncreaseGoodReactionPoint(int memberId, String relTypeCode, int relId) {
		reactionPointRepository.increaseGoodReactionPoint(memberId, relTypeCode, relId);

		switch (relTypeCode) {
			case "article":
				articleService.increaseGoodReactionPoint(relId);
				break;
			case "reply":
				replyService.increaseGoodReactionPoint(relId);
				break;
		}

		return ResultData.form("S-1", "좋아요 처리되었습니다.");
	}

	public ResultData addIncreaseBadReactionPoint(int memberId, String relTypeCode, int relId) {
		reactionPointRepository.increaseBadReactionPoint(memberId, relTypeCode, relId);

		switch (relTypeCode) {
			case "article":
				articleService.increaseBadReactionPoint(relId);
				break;
			case "reply":
				replyService.increaseBadReactionPoint(relId);
				break;
		}

		return ResultData.form("S-1", "싫어요 처리되었습니다.");
	}

	public ResultData addDecreaseReactionPoint(int memberId, String relTypeCode, int relId, String cancleReaction) {
		reactionPointRepository.decreaseReactionPoint(memberId, relTypeCode, relId);

		switch (relTypeCode) {
			case "article":
				articleService.decreaseReactionPoint(relId, cancleReaction);
				break;
			case "reply":
				replyService.decreaseReactionPoint(relId, cancleReaction);
				break;
		}

		return ResultData.form("S-1", "리액션 해제 처리되었습니다.");
	}

	public void doDelete(int relId, String relTypeCode) {
		System.out.println(Ut.f("%d번 %s 삭제", relId, relTypeCode));

		reactionPointRepository.doDelete(relId, relTypeCode);
	}

}
