package com.nyj.exam.demo.service;

import com.nyj.exam.demo.repository.BoardRepository;
import com.nyj.exam.demo.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository boardrepository;
	
	public Board getBoardById(int id) {
		return boardrepository.getBoardById(id);
	}

	public List<Board> getBoards() {
		return boardrepository.getBoards();
	}

	public List<Board> getForPrintBoards(String searchKeywordType, String searchKeyword, int page,int itemsCountInAPage) {
		int limitStart = (page - 1) * itemsCountInAPage;
		int limitTake = itemsCountInAPage;
		return boardrepository.getForPrintBoards(searchKeywordType,searchKeyword,limitStart, limitTake);
	}

	public int getBoardCount(String searchKeywordType, String searchKeyword) {
		return boardrepository.getBoardCount(searchKeywordType,searchKeyword);
	}
	
}
