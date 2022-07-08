package com.nyj.exam.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyj.exam.demo.repository.ReplyRepository;
import com.nyj.exam.demo.vo.Reply;

@Service
public class ReplyService {
	
	@Autowired
	ReplyRepository replyRepository;

	public List<Reply> getForPrintReplies(int memberId, int id, String relTypeCode) {
		return replyRepository.getForPrintReplies(id, relTypeCode);
	}
	
}
