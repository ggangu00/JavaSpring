package com.example.demo.dept;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j //로그 필요할 경우
@Controller //컨트롤러 페이지에 필수선언
@RequestMapping("/dept") //dept로 시작하고싶은 경우
public class DeptController {
	
	
	//목록페이지
	@GetMapping("/list")
	public void list(Model model) {
		ArrayList<DepartmentsDTO> list = new ArrayList<>();
		list.add(DepartmentsDTO.builder().departmentId("10").departmentName("기획").build());
		list.add(DepartmentsDTO.builder().departmentId("20").departmentName("개발").build());
		model.addAttribute("list", list);
	}
	
	
	//등록페이지
	@GetMapping("/insert")
	public String insert() {
		return "dept/insert"; //경로 같은 경우 생략 (list()처럼)
	}
	
	
	//등록처리
	@PostMapping("/insert")
	public String insertProc(DepartmentsDTO dto) {
		log.debug("DTO : " + dto.toString());
		return "redirect:/dept/list"; //경로 같은 경우 생략 (list()처럼)
	}
	
	
	//수정페이지
	@GetMapping("/update")
	public void update() {}
	
	
	//상세페이지
	@GetMapping("/info")
	public void info() {}
	
	
		
	
	
	//수정처리	
	//삭제처리
}
