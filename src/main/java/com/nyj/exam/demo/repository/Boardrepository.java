package com.nyj.exam.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nyj.exam.demo.vo.Board;

@Mapper
public interface Boardrepository {

	Board getBoardById(@Param("id") int id);

}
