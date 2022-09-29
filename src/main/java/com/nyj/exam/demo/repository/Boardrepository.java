package com.nyj.exam.demo.repository;

import com.nyj.exam.demo.vo.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardRepository {

	@Select("""
			SELECT *
			FROM board  
				""")
	List<Board> getBoards();

	@Select("""
			SELECT *
			FROM board AS B
			WHERE B.id = #{id}
			AND B.delStatus = 0
				""")
	Board getBoardById(@Param("id") int id);

}
