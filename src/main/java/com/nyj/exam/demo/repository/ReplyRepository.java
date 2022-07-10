package com.nyj.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nyj.exam.demo.vo.Reply;
import com.nyj.exam.demo.vo.ResultData;

@Mapper
public interface ReplyRepository {

	List<Reply> getForPrintReplies(int id, String relTypeCode);

	void doWriteReply(int memberId, String relTypeCode, int relId, String body);

	void doDelete(int id);
	
}
