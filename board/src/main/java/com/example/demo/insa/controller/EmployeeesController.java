package com.example.demo.insa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.common.Paging;
import com.example.demo.insa.dto.EmployeesDTO;
import com.example.demo.insa.dto.EmployeesSearchDTO;
import com.example.demo.insa.service.EmployeesService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/emp/*")
@AllArgsConstructor
public class EmployeeesController {
	
	private final EmployeesService eService;
	
	//사원 전체조회
	@GetMapping("list")	
	public void list(Model model, 
			 EmployeesSearchDTO searchDTO,
			 Paging paging) {
		
		//페이징처리
		paging.setTotalRecord(eService.getCount(searchDTO));
		  
		//목록 조회
		searchDTO.setStart(paging.getFirst());
		searchDTO.setEnd(paging.getLast());
		
		model.addAttribute("list", eService.getList(searchDTO));
	}
	
	//사원 등록	
	@GetMapping("/register")
	public void register(EmployeesDTO employee, Model model) {
		model.addAttribute("emp", employee);
		
		model.addAttribute("jobList", eService.getListByJob());
	}
	
	//사원 등록처리
	@PostMapping("/register")
	public String register(@Validated EmployeesDTO employee,
						   BindingResult bindingResult,
						   RedirectAttributes rttr) {
		
		if(bindingResult.hasErrors()) {
			return "emp/register";
		}
		  
		eService.register(employee);
	  
	  rttr.addFlashAttribute("result", true);
	  return "redirect:/emp/list"; //redirect라고 적어줘야 list함수 데이터 조회해서 값 뿌림
	}
	
	//사원 수정	
	@GetMapping({"/modify", "/get"})
	public void modify(@RequestParam(name="employeeId") Long employeeId, Model model) {
		EmployeesDTO employee = eService.get(employeeId);		
		model.addAttribute("emp", employee);
	}
	
	//사원 삭제처리
	@GetMapping("/remove")
	public String remove(@RequestParam(name="employeeId") Long employeeId, RedirectAttributes rttr) {
		 
	  eService.remove(employeeId);
	  
	  rttr.addFlashAttribute("remove", true);
	  return "redirect:/emp/list";
	}
}
