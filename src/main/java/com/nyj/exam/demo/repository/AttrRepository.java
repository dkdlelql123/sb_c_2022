package com.nyj.exam.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.nyj.exam.demo.vo.attr;

@Mapper
public interface AttrRepository {

	void setValue(String relTypeCode, int relId, String typeCode, String type2Code, String value, String expireDate);

	attr get(String relTypeCode, int relId, String typeCode, String type2Code);

}
