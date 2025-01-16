package com.example.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j //로그 필요한 경우 요고 선언하면 됨
@Controller //빈등록, 서블릿 커맨드
@RequestMapping("/sample")
public class SampleController {
	
	//Logger log = LoggerFactory.getLogger(getClass());
	@ModelAttribute("dept")
	public List<String> deptList(){		
		return Arrays.asList("기획", "개발", "인사");
	}
	
	@GetMapping("/ex03")
	public ModelAndView ex03(@ModelAttribute(name = "todo") TodoDTO dto, Model model) {
		ModelAndView mv = new ModelAndView("sample");
		mv.addObject("serverTime", new Date());
		log.debug("todoDTO : " + dto);
		return mv; //포워드 : request 전달
	}
	
	@PostMapping("ex02Bean")
	public String ex02Bean(SampleDtoList dtoList) {
		log.debug("dtoList : " + dtoList);
		return "sample";
	}
	
	@GetMapping("/ex02List")
	public String ex02List( @RequestParam List<String> hobby ) {
		log.debug("hobby : " + hobby);
		return "sample";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam(name="username") String name, 
					   @RequestParam(required = false, defaultValue = "5") int age) {
		
		//String name = request.getParameter("username")
		//if null ==> 초기값
		log.info("name:" + name);
		log.info("age:" + age);
		return "sample";
	}
	
	@GetMapping("/ex01")
	//@RequestMapping(value = "a", method = {RequestMethod.GET }) // localhost:81/sample/a
	public String ex01(SampleDto Dto) {
		log.debug(Dto.toString()); //sysout 대신 log.info로 출력
		return "sample";
	}
	
	@GetMapping("b") // localhost:81/sample/b
	public String basicb() {
		log.info("sample b"); //sysout 대신 log.info로 출력
		return "sample";
	}
}
