package com.example.demo.board.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.dto.ReplyDTO;
import com.example.demo.board.dto.ReplyPageDTO;
import com.example.demo.board.dto.ReplySearchDTO;
import com.example.demo.board.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/replies/")
@AllArgsConstructor
public class ReplyController {
	private final ReplyService service;
	
	//등록처리
	@PostMapping("/new")
	public ReplyDTO register(@RequestBody ReplyDTO dto) {
		service.register(dto);
		return dto;
	}
	
	//수정처리
	//localhost:81/replies/5
	@PutMapping("/{rno}")
	public String modify(
						@RequestBody ReplyDTO replyDTO,
						@PathVariable(name="rno") Long rno){
		replyDTO.setRno(rno);
		service.modify(replyDTO);
		return "success";
		
		/*
		return타입 ResponseEntity<String>
		return service.modify(replyDTO) == true
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				*/
	}
	
	//삭제처리
	@DeleteMapping("/{rno}")
	public String remove(@PathVariable(name="rno") Long rno){
		service.remove(rno);
		return "success";
		
		/*
		return service.remove(rno) == true
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				*/
		
	}
	
	//단건조회
	@GetMapping("/{rno}")
	public ReplyDTO get(@PathVariable(name="rno") Long rno) {
		return service.get(rno);
	}
	
	//댓글목록조회 localhost:81/replies/pages/321/1
	@GetMapping("/pages/{bno}/{page}")
	public ReplyPageDTO get(@PathVariable(name="page") int page,
							@PathVariable(name="bno") Long bno) {
		
		ReplySearchDTO replySearchDTO = new ReplySearchDTO(page, 10);
		
		return service.getList(replySearchDTO, bno);
	}

}
