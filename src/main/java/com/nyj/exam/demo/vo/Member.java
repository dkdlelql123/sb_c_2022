package com.nyj.exam.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private int id;
	private String loginId;
	private String loginPw;
	private String email;
	private String name;
	private String nickname;
	private String phoneNumber;

	private String regDate;
	private String updateDate;

	private int authLevel;
	
	private int delStatus;
	private String delDate;
	
	private int extra__totalWrittenArticles;
	private int extra__totalWrittenReplies;

	public String getForPrintType1RegDate() {
		return regDate.substring(0,10);
	}
	public String getForPrintType1UpdateDate() {
		return updateDate.substring(0,10);
	}
	public boolean isAdmin() {
		return authLevel == 10;
	}
}
