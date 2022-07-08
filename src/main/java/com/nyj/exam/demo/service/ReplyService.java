package com.nyj.exam.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyj.exam.demo.repository.ReplyRepository;
import com.nyj.exam.demo.vo.Reply;
import com.nyj.exam.demo.vo.ResultData;

@Service
public class ReplyService {
	
	@Autowired
	ReplyRepository replyRepository;

	public List<Reply> getForPrintReplies(int memberId, int id, String relTypeCode) {
		return replyRepository.getForPrintReplies(id, relTypeCode);
	}

	public ResultData doWriteReply(int memberId, String relTypeCode, int relId, String body) {
		replyRepository.doWriteReply(memberId,relTypeCode,relId,body);
		return ResultData.form("S-1", "댓글을 남겼습니다.");
	}
	
}
