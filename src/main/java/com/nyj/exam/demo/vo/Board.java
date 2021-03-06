package com.nyj.exam.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	int id;
	String regDate;
	String updateDate;
	String code;
	String name;
	int delStatus;
	String delDate;
}
