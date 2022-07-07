package com.nyj.exam.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nyj.exam.demo.service.ReactionPointService;
import com.nyj.exam.demo.util.Ut;
import com.nyj.exam.demo.vo.Rq;

@Controller
public class UsrReactionPointController {

	private Rq rq;
	
	@Autowired
	ReactionPointService reactionPointService;

	public UsrReactionPointController(Rq rq) {
		this.rq = rq;
	}
	
	@RequestMapping("/usr/reactionPoint/doGoodReaction")
	@ResponseBody
	public String doGoodReaction(int relId, String relTypeCode, String replaceUri) {
		reactionPointService.addIncreaseGoodReactionPoint(rq.getLoginedMemberId(), relTypeCode, relId);
		
		return Ut.jsReplace("❤️", replaceUri);
	}
	
	
	@RequestMapping("/usr/reactionPoint/doBadReaction")
	@ResponseBody
	public String doBadReaction(int relId, String relTypeCode, String replaceUri) {
		reactionPointService.addIncreaseBadReactionPoint(rq.getLoginedMemberId(), relTypeCode, relId);

		return Ut.jsReplace("싫어요👎", replaceUri);
	}
}
