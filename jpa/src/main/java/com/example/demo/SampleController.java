package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
	
	@GetMapping("/hello")
	@ResponseBody // 그냥 "hello" 출력 (비선언 시 hello 경로를 찾음)
	public String main() {
		return "hello";		
	}
}
