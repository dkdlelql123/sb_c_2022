package com.nyj.exam.demo.vo;

import lombok.Getter;
import lombok.ToString;

@ToString
public class ResultData {
	@Getter
	String resultCode;
	
	@Getter
	String data1msg;
	
	@Getter
	Object data1;
	
	@Getter
	String data2msg;
	
	@Getter
	Object data2;

	private ResultData() {
	}
	
	public static ResultData form(String resultCode, String msg) {
		return form(resultCode, msg, null);
	}
	
	public static ResultData form(String resultCode, String msg,Object article) {
		ResultData rd = new ResultData();
		
		rd.resultCode = resultCode;
		rd.data1msg = msg;
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
		
		newRd.resultCode = rd.getResultCode();
		newRd.data1msg = rd.getData1msg();
		newRd.data1 = obj;
		
		return newRd;
	}

	public void setData2(String msg, Object obj) {
		this.data2msg = msg;
		this.data2 = obj;
	}
	
}
