package com.nyj.exam.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nyj.exam.demo.service.BoardService;

@Controller
public class UsrBoardController {

	@Autowired
	BoardService boardService; 
	
	
	
}
