package com.example.demo.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardServiceTest {
	
	@Autowired BoardService boardService;
	
	@Test
	@DisplayName("게시글 수정")
	public void update() {
		//given
		String title = "서비스 수정";		
		
		//빌더로 쓰기
		BoardDTO board = BoardDTO.builder()
								 .title(title)
								 .content("내용 수정")
								 .writer("작성자 수정")
								 .bno(5L)
								 .build();
		
		
		//when
		boolean result = boardService.modify(board); //결과 int로 반환
		
		//then
		assertThat(result).isEqualTo(true); //결과값 나왔는지 확인
	}
		
		
}
