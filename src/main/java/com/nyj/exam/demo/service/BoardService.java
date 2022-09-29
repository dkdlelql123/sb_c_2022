package com.nyj.exam.demo.service;

import com.nyj.exam.demo.repository.BoardRepository;
import com.nyj.exam.demo.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
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
	
}
