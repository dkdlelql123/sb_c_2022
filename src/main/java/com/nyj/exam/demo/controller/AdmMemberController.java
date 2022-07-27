package com.nyj.exam.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nyj.exam.demo.service.MemberService;
import com.nyj.exam.demo.vo.Member;

@Controller
public class AdmMemberController {
	
	@Autowired
	MemberService memberService; 
	
	@RequestMapping("/adm/member/list")
	public String showMemberList(Model model,
			@RequestParam(defaultValue = "1") int searchAuthLevel, 
			@RequestParam(defaultValue = "1") int page, 
			@RequestParam(defaultValue = "5") int itemsCountInAPage, 
			@RequestParam(defaultValue = "title,body") String searchKeywordType,
			@RequestParam(defaultValue = "") String searchKeyword) {
		
		model.addAttribute("authLevel", searchAuthLevel);
		
		int membersCount =  memberService.getMembersCount(searchKeywordType, searchKeyword, searchAuthLevel);
		model.addAttribute("membersCount", membersCount);
		
		int pagesCount = (int) Math.ceil((double)membersCount / itemsCountInAPage);
		model.addAttribute("pagesCount", pagesCount);
		model.addAttribute("page", page);
	
		List<Member> list = memberService.getForPrintMembers(searchKeywordType, searchKeyword, searchAuthLevel, page, itemsCountInAPage);
		model.addAttribute("members", list);
		
		return "adm/member/list";
	}
	
	@RequestMapping("/adm/member/detail")
	public String showMemberDetail() {
		return "adm/member/detail";
	}
	
	@RequestMapping("/adm/member/modify")
	public String showMemberModify() {
		return "adm/member/modify";
	}
	
}
