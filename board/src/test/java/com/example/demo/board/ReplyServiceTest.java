package com.example.demo.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.dto.ReplyDTO;
import com.example.demo.board.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class ReplyServiceTest {

	@Autowired ReplyService replyService;
	
	@Test
	@DisplayName("댓글 수정")
	public void update() {	
		
		//빌더로 쓰기
		ReplyDTO reply = ReplyDTO.builder()
								 .rno(321L)
								 .reply("내용 수정")
								 .replyer("작성자 수정")
								 .build();
		
		
		//when
		boolean result = replyService.modify(reply); //결과 int로 반환
		
		//then
		assertThat(result).isEqualTo(true); //결과값 나왔는지 확인
	}

}