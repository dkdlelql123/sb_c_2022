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
		List<Reply> replies = replyRepository.getForPrintReplies(id, relTypeCode);

		for (Reply reply : replies) {
			ResultData rd = actorCanEdit(reply, memberId);
			reply.setExtra__actorCanEdit(rd.isSuccess());
		}

		return replies;
	}

	private ResultData actorCanEdit(Reply reply, int memberId) {
		if (reply == null) {
			return ResultData.form("F-1", "해당 댓글이 없습니다");
		}
		if (reply.getMemberId() != memberId) {
			return ResultData.form("F-2", "권한이 없습니다");
		}
		return ResultData.form("S-1", "게시물 변경이 가능합니다.", reply);
	}

	public ResultData doWriteReply(int memberId, String relTypeCode, int relId, String body) {
		replyRepository.doWriteReply(memberId, relTypeCode, relId, body);
		return ResultData.form("S-1", "댓글을 남겼습니다.");
	}

	public void doDelete(int id) {
		replyRepository.doDelete(id);
	}

	public void doModify(int id, String body) {
		replyRepository.doModify(id, body);
	}

	public Reply getForPrintReply(int id) {
		return replyRepository.getForPrintReply(id);
	}

}
