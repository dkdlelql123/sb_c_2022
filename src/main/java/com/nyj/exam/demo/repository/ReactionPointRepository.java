package com.nyj.exam.demo.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReactionPointRepository {

	public int actorCanMakeReactionPoint(int memberId, String relTypeCode, int articleId);

	public void addIncreaseGoodReactionPoint(int memberId, String relTypeCode, int relId);

	public void addIncreaseBadReactionPoint(int memberId, String relTypeCode, int relId);
	
}
