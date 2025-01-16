package com.example.demo.insa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.DeptService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RestController
@RequestMapping("/dept/*")
@AllArgsConstructor
public class DeptController {
	private final DeptService deptService;
	
	//게시글 전체조회
	@GetMapping("list")
	public List<DeptDTO> list() {

		return deptService.getList(null);
	}
	
	@GetMapping("get")
	public DeptDTO get(@RequestParam(name="deptId") Long deptId) {

		return deptService.read(deptId);
	}
	
}
