package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.dto.BoardSearchDTO;
import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service //서비스가 들어오면 무조건 선언해주기
@RequiredArgsConstructor //final 붙은것만 초기화
public class BoardServiceImpl implements BoardService{

	private final BoardMapper boardMapper;
	private final ReplyMapper replyMapper;
	
	@Override
	public void register(BoardDTO board) {
		boardMapper.insert(board);
		
	}

	@Override
	public boolean modify(BoardDTO board) {
		return boardMapper.update(board) == 1 ? true : false;
	}

	@Override
	@Transactional
	public boolean remove(Long bno) {
		
		//댓글 삭제
		replyMapper.deleteByBno(bno);
		
		//게시글 삭제
		return boardMapper.delete(bno) == 1 ? true : false;
		
		//정상적으로 삭제 시 commit, 오류 시 둘다 rollback
	}

	@Override
	public BoardDTO get(Long bno) {
		return boardMapper.read(bno);
	}

	@Override
	public List<BoardDTO> getList(BoardSearchDTO searchDTO) {
		return boardMapper.getList(searchDTO);
	}

	@Override
	public int getCount(BoardSearchDTO searchDTO) {
		return boardMapper.getCount(searchDTO);
	}

}
