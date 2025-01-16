package com.example.demo.board.mapper;

import java.util.List;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.dto.BoardSearchDTO;

public interface BoardMapper {
	
	int insert(BoardDTO boardDTO);
	int update(BoardDTO boardDTO);
	int delete(Long bno);
	BoardDTO read(Long bno);
	List<BoardDTO> getList(BoardSearchDTO searchDTO);
	int getCount(BoardSearchDTO searchDTO);
}
