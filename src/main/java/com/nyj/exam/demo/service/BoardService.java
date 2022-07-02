package com.nyj.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyj.exam.demo.repository.Boardrepository;
import com.nyj.exam.demo.vo.Board;

@Service
public class BoardService {
	
	@Autowired
	Boardrepository boardrepository;
	
	public Board getBoardById(int id) {
		return boardrepository.getBoardById(id);
	}
	
}
