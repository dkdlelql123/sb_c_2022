package com.nyj.exam.demo.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReactionPointRepository {

	public int actorCanMakeReactionPoint(int memberId, String relTypeCode, int articleId);

	public void increaseGoodReactionPoint(int memberId, String relTypeCode, int relId);

	public void increaseBadReactionPoint(int memberId, String relTypeCode, int relId);

	public void decreaseReactionPoint(int memberId, String relTypeCode, int relId);
	
}
