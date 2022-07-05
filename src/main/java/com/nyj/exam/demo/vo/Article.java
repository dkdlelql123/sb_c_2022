package com.nyj.exam.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	private int id;
	private String regDate;
	private String updateDate;
	private int memberId;
	private String title;
	private String body;
	
	private int hit;
	
	private int boardId;
	private String extra__boardName;
	
	private String extra__writerName;
	private boolean extra__actorCanEdit;
	
}
