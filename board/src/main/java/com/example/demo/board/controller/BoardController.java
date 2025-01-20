package com.example.demo.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.dto.BoardSearchDTO;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.ReplyService;
import com.example.demo.common.Paging;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	private ReplyService replyService;

	//게시글 전체조회
	@GetMapping("/list")
	public void list(Model model, 
					 BoardSearchDTO searchDTO,
					 Paging paging) {
	  
	  //페이징처리
	  paging.setTotalRecord(service.getCount(searchDTO));
	  
	  //목록 조회
	  searchDTO.setStart(paging.getFirst());
	  searchDTO.setEnd(paging.getLast());
	  
	  model.addAttribute("list", service.getList(searchDTO));
	  
	}
	
	
	//게시글 등록	
	@GetMapping("/register")
	public void register(BoardDTO board) {}
	
	//게시글 등록처리
	@PostMapping("/register")
	public String register(@Validated BoardDTO board,
						   BindingResult bindingResult,
						   RedirectAttributes rttr) {
		
		if(bindingResult.hasErrors()) {
			return "board/register";
		}
		
	  log.info("register: " + board);	  
	  service.register(board);
	  
	  rttr.addFlashAttribute("result", true);
	  return "redirect:/board/list"; //redirect라고 적어줘야 list함수 데이터 조회해서 값 뿌림
	}
	
	
	//게시글 수정	
	@GetMapping({"/modify", "/get"})
	public void modify(@RequestParam(name="bno") Long bno, Model model) {
		BoardDTO board = service.get(bno);		
		model.addAttribute("board", board);
			
		//model.addAttribute("replyList", replyService.getList(new ReplySearchDTO(), bno).getList());
		
	}
	
	//게시글 수정처리
	@PostMapping("/modify")
	public String modify(BoardDTO board, RedirectAttributes rttr) {
		
	  log.info("modify: " + board);	  
	  service.modify(board);
	  
	  rttr.addFlashAttribute("modify", true);
	  return "redirect:/board/list"; //redirect라고 적어줘야 list함수 데이터 조회해서 값 뿌림
	}
	
	//게시글 삭제처리
	@GetMapping("/remove")
	public String remove(@RequestParam(name="bno") Long bno, RedirectAttributes rttr) {
		
	  log.info("remove: " + bno);	  
	  service.remove(bno);
	  
	  rttr.addFlashAttribute("remove", true);
	  return "redirect:/board/list"; //redirect라고 적어줘야 list함수 데이터 조회해서 값 뿌림
	}
}
