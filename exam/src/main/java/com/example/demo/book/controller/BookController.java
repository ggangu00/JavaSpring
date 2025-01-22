package com.example.demo.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.book.dto.BookDTO;
import com.example.demo.book.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/book/*")
@AllArgsConstructor
public class BookController {
	
	private BookService service;
	
	//전체조회
	@GetMapping("/")
	public void index() {	}	

	//전체조회
	@GetMapping("/list")
	public void list(Model model) {	  
	  model.addAttribute("list", service.getList());
	  
	}	
	
	//도서별 대여매출현황
	@GetMapping("/rent_list")
	public void rentList(Model model) {	  
	  model.addAttribute("rent_list", service.getRentList());
	  
	}	
	
	//등록	
	@GetMapping("/register")
	public void register(BookDTO book) {}
	
	//등록처리
	@PostMapping("/register")
	public String register(@Validated BookDTO book,
						   BindingResult bindingResult,
						   RedirectAttributes rttr) {
		
		if(bindingResult.hasErrors()) {
			return "book/register";
		}
		
	  log.info("register: " + book);	  
	  service.register(book);
	  
	  rttr.addFlashAttribute("result", true);
	  return "redirect:/book/list"; //redirect라고 적어줘야 list함수 데이터 조회해서 값 뿌림
	}
	
	
	//게시글 수정	
	@GetMapping({"/get"})
	public void modify(@RequestParam(name="bookNo") Long bookNo, Model model) {
		BookDTO book = service.get(bookNo);		
		model.addAttribute("book", book);		
	}
	
	//삭제처리
	@GetMapping("/remove")
	public String remove(@RequestParam(name="bookNo") Long bookNo, RedirectAttributes rttr) {
		
	  log.info("remove: " + bookNo);	  
	  service.remove(bookNo);
	  
	  rttr.addFlashAttribute("remove", true);
	  return "redirect:/book/list"; //redirect라고 적어줘야 list함수 데이터 조회해서 값 뿌림
	}
}
