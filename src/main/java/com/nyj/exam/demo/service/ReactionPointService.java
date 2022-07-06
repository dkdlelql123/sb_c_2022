package com.nyj.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyj.exam.demo.repository.ReactionPointRepository;
import com.nyj.exam.demo.vo.ResultData;

@Service
public class ReactionPointService {
	@Autowired
	ReactionPointRepository reactionPointRepository;

	public boolean actorCanMakeReactionPoint(int memberId, String relCodeType, int articleId) {
		if(memberId == 0) {
			return false;
		}
		
		return reactionPointRepository.actorCanMakeReactionPoint(memberId, relCodeType, articleId) == 0; 
	}
	
}
