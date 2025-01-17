package com.example.demo.board.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.dto.ReplyDTO;
import com.example.demo.board.dto.ReplyPageDTO;
import com.example.demo.board.dto.ReplySearchDTO;
import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyService;
import com.example.demo.common.Paging;

import lombok.RequiredArgsConstructor;

@Service //서비스가 들어오면 무조건 선언해주기
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{
	
	private final BoardMapper boardMapper;
	private final ReplyMapper replyMapper;

	@Override
	@Transactional
	public boolean register(ReplyDTO vo) {
		boardMapper.updateReplyCnt(vo.getBno(),  1);
		return replyMapper.insert(vo) == 1? true : false;
		
	}

	@Override
	public boolean modify(ReplyDTO reply) {
		return replyMapper.update(reply) == 1 ? true : false;
	}

	@Override
	@Transactional
	public boolean remove(Long rno) {
		ReplyDTO vo = replyMapper.read(rno);
		boardMapper.updateReplyCnt(vo.getBno(),  -1);
		return replyMapper.delete(rno) == 1 ? true : false;
	}

	@Override
	public ReplyDTO get(Long rno) {
		return replyMapper.read(rno);
	}
	
	@Override
    public ReplyPageDTO getList(ReplySearchDTO replySearch, Long bno) {
        Paging paging = new Paging();
        int cnt = replyMapper.getCountByBno(bno);

        //paging - 전체건수, pageUnit, page
        paging.setPage(replySearch.getPage());
        paging.setPageUnit(replySearch.getAmount());
        paging.setTotalRecord(cnt);

        return new ReplyPageDTO(cnt, paging, replyMapper.getList(replySearch, bno));
    }
}
