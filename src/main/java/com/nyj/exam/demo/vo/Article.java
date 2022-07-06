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

	private int extra__sumReactionPoint;
	private int extra__goodReactionPoint;
	private int extra__badReactionPoint;
	
	public String getForPrintType1RegDate() {
		return regDate.substring(2,10);
	}
	
	public String getForPrintType1UpdateDate() {
		return updateDate.substring(2,10);
	}
	
	public String getForPrintType2RegDate() {
		return regDate.substring(2,16);
	}
	
	public String getForPrintType2UpdateDate() {
		return updateDate.substring(2,16);
	}
}
