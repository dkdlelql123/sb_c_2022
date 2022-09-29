package com.nyj.exam.demo.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReactionPointRepository {

	 int actorCanMakeReactionPoint(int memberId, String relTypeCode, int relId);

	 void increaseGoodReactionPoint(int memberId, String relTypeCode, int relId);

	 void increaseBadReactionPoint(int memberId, String relTypeCode, int relId);

	 void decreaseReactionPoint(int memberId, String relTypeCode, int relId);
	
}
