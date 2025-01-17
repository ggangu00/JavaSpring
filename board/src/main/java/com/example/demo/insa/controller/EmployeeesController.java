package com.example.demo.insa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.common.Paging;
import com.example.demo.insa.dto.EmployeesSearchDTO;
import com.example.demo.insa.service.EmployeesService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/emp/*")
@AllArgsConstructor
public class EmployeeesController {
	
	private final EmployeesService employeesService;
	
	@GetMapping("list")	
	public void list(Model model, 
			 EmployeesSearchDTO searchDTO) {
		
		model.addAttribute("list", employeesService.getList(searchDTO));
	}
	
	@GetMapping("register")
	public void register(Model model) {
		model.addAttribute("jobList", employeesService.getListByJob());
	}

}
