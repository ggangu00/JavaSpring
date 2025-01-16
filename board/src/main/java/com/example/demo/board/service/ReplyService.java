package com.example.demo.board.service;

import com.example.demo.board.dto.ReplyDTO;
import com.example.demo.board.dto.ReplyPageDTO;
import com.example.demo.board.dto.ReplySearchDTO;

public interface ReplyService {
	public boolean register(ReplyDTO vo);

	public boolean modify(ReplyDTO vo);

	public boolean remove(Long rno);

	public ReplyDTO get(Long rno);
	
	public ReplyPageDTO getList(ReplySearchDTO replySearch, Long bno);
}
