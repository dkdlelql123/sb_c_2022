package com.nyj.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nyj.exam.demo.vo.Reply;

@Mapper
public interface ReplyRepository {

	List<Integer> getReplyIds(int id);

	List<Reply> getForPrintReplies(int id, String relTypeCode);

	Reply getForPrintReply(int id);

	void doWriteReply(int memberId, String relTypeCode, int relId, String body);

	void doDelete(int id);

	void doModify(int id, String body);

	int increaseGoodReactionPoint(int id);

	int increaseBadReactionPoint(int id);

	int decreaseReactionPoint(int relId, String cancelReaction);

	void doCascadingDeleteFromParent(int relId, String relTypeCode);
}
