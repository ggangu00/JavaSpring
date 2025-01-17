package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.board.dto.ReplyDTO;
import com.example.demo.board.dto.ReplySearchDTO;

public interface ReplyMapper {
	public int insert(ReplyDTO reply);
	public int update(ReplyDTO reply);
	public int delete(Long rno);
	public int deleteByBno(Long bno);
	public ReplyDTO read(Long rno);
	public List<ReplyDTO> getList(@Param("cri") ReplySearchDTO cri,
								  @Param("bno") Long bno);

	public int getCountByBno(Long bno);
}