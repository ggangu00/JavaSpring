package com.example.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController //컨트롤러의 모든 리턴값은 Json 형식으로 바뀜
//@RestController -> @controller로 사용하는 경우 함수마다 @ResponseBody 넣어주기
public class SampleController {

	@GetMapping(value="/getText", produces="text/plain;charset:UTF-8")
	public String getText() {
		return "안녕";
	}
	
	@GetMapping("/getTextEntity")
	public ResponseEntity<String> getTextEntity() {
		String msg = "안녕";
		return new ResponseEntity<>(msg, HttpStatus.BAD_GATEWAY);
	}
	
	@GetMapping("/getSample")
	public SampleVO getSample() {
		return new SampleVO(100, "길동", "홍", new Date());
	}

	@GetMapping("/getSampleEntity")
	public ResponseEntity<SampleVO> getSampleEntity() {
		SampleVO sample = new SampleVO(100, "길동", "홍", new Date());
		return new ResponseEntity<>(sample, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getMap")
	public Map<String, Object> getMap(){
		Map<String, Object> map = new HashMap<>();
		map.put("sample", new SampleVO(100, "길동", "홍", new Date()));
		map.put("total", 20);
		map.put("success", true);
		return map;
	}
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable String cat,
							@PathVariable(name="pid") Integer prdid) {
		return new String[] {cat, ""+prdid};	
	}
	
	@PostMapping("/ticket")
	public List<Ticket> convert(
			@RequestBody List<Ticket> ticket) {
		log.info("ticket"+ticket);
		return ticket;
	}
	
	@PostMapping("/comp")
	public CompVO comp(@RequestBody CompVO comp) {
		log.info("owner : " + comp.getList().get(0).getOwner());
		return comp;
	}
	
	@PostMapping("/compMap")
	public JsonNode compMap(@RequestBody JsonNode node) {
		//첫번째 티켓의 owner명
		log.info("owner1 : " + node.get("list").get(0).get("owner").asText());
		return node;
	}
		
	
	@GetMapping("/movie")
	public String movie(@RequestParam(defaultValue="20250115", required=false) String date) {
		RestTemplate restTemplate = new RestTemplate();
		
		String uri = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=12664b24453335d2c3eca0fdc4b3b013&targetDt="+date;
		JsonNode node = restTemplate.getForObject(uri, JsonNode.class);
		
		//첫번째 영화 제목
		String name = node.get("boxOfficeResult").get("dailyBoxOfficeList").get(0).get("movieNm").asText();
		return name;
	}
	
	@GetMapping("/movieList")
	public Map<String, Object> movie(){
		Map<String, Object> map = new HashMap<>();
		map.put("boxofficeType", "일별 박스오피스");
		map.put("showRange", "20250115~20250115");
		map.put("dailyBoxOfficeList", new MovieVO("1", "1", "20228796", "하얼빈", "2025-01-16"));
		
		return map;
	}
}
