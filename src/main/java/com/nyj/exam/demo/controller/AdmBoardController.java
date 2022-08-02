package com.nyj.exam.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nyj.exam.demo.service.BoardService;
import com.nyj.exam.demo.vo.Board;

@Controller
public class AdmBoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/adm/board/list")
	public String showList(@RequestParam(defaultValue = "1") int page, 
			@RequestParam(defaultValue = "5") int itemsCountInAPage,
			@RequestParam(defaultValue = "name,code") String searchKeywordType,
			@RequestParam(defaultValue = "") String searchKeyword,
			Model model
			) {
		
		int boardsCount = boardService.getBoardCount(searchKeywordType, searchKeyword);
		model.addAttribute("boardsCount", boardsCount);
		
		int pagesCount = (int) Math.ceil((double)boardsCount / itemsCountInAPage);
		model.addAttribute("pagesCount", pagesCount);
		model.addAttribute("page", page);
		
		List<Board> boards = boardService.getForPrintBoards(searchKeywordType, searchKeyword, page, itemsCountInAPage);
		model.addAttribute("boards", boards);
		
		
		return "/adm/board/list";
	}
	
}
