package com.example.demo.board.service;

import java.util.List;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.dto.BoardSearchDTO;

public interface BoardService {
	
	public void register(BoardDTO board);

	public boolean modify(BoardDTO board);

	public boolean remove(Long bno);

	public BoardDTO get(Long bno);

	public List<BoardDTO> getList(BoardSearchDTO searchDTO);
	
	public int getCount(BoardSearchDTO searchDTO);
	
}
