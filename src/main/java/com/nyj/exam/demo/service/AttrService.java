package com.nyj.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyj.exam.demo.repository.AttrRepository;
import com.nyj.exam.demo.vo.Attr;
import com.nyj.exam.demo.vo.ResultData; 

@Service
public class AttrService {
	@Autowired
	AttrRepository attrRepository;

	public int setValue(String relTypeCode, int relId, String typeCode, String type2Code, String value, String expireDate) {
		attrRepository.setValue(relTypeCode, relId, typeCode, type2Code, value, expireDate);
		Attr attr = get(relTypeCode, relId, typeCode, type2Code);
		
		if (attr != null) {
			return attr.getId();
		}

		return 1; 
	}
	
	public Attr get(String relTypeCode, int relId, String typeCode, String type2Code) {
		return attrRepository.get(relTypeCode, relId, typeCode, type2Code);
	}
	
	public String getValue(String relTypeCode, int relId, String typeCode, String type2Code) {
		return attrRepository.getValue(relTypeCode, relId, typeCode, type2Code);
	}
	
}
