package com.nyj.exam.demo.vo;

import lombok.Getter;

public class ResultData {
	@Getter
	String resultCode;
	
	@Getter
	String msg;
	
	@Getter
	Object data1;

	private ResultData() {
	}
	
	public static ResultData form(String resultCode, String msg) {
		return form(resultCode, msg, null);
	}
	
	public static ResultData form(String resultCode, String msg,Object article) {
		ResultData rd = new ResultData();
		
		rd.resultCode = resultCode;
		rd.msg = msg;
		rd.data1 = article;
		
		return rd; 
	}
	
	public boolean isSuccess() {
		return resultCode.startsWith("S-");
	}
	
	public boolean isFail() {
		return isSuccess() == false;
	}
	
	public static ResultData newData(ResultData rd, Object obj) {
		ResultData newRd = new ResultData();
		
		newRd.resultCode = rd.getMsg();
		newRd.msg = rd.getMsg();
		newRd.data1 = obj;
		
		return newRd;
	}
	
}
