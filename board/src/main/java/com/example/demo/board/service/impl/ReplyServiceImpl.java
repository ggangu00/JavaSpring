package com.example.demo.board.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.board.dto.ReplyDTO;
import com.example.demo.board.dto.ReplyPageDTO;
import com.example.demo.board.dto.ReplySearchDTO;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyService;

import lombok.RequiredArgsConstructor;

@Service //서비스가 들어오면 무조건 선언해주기
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{
	
	private final ReplyMapper replyMapper;

	@Override
	public boolean register(ReplyDTO vo) {
		return replyMapper.insert(vo) == 1? true : false;
		
	}

	@Override
	public boolean modify(ReplyDTO reply) {
		return replyMapper.update(reply) == 1 ? true : false;
	}

	@Override
	public boolean remove(Long rno) {
		return replyMapper.delete(rno) == 1 ? true : false;
	}

	@Override
	public ReplyDTO get(Long rno) {
		return replyMapper.read(rno);
	}
	
	@Override
	public ReplyPageDTO getList(ReplySearchDTO replySearch, Long bno) {
		return new ReplyPageDTO(
			replyMapper.getCountByBno(bno),
			replyMapper.getList(replySearch, bno)
		);
	}

}
