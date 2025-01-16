package com.example.demo.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.dto.BoardSearchDTO;
import com.example.demo.board.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardMapperTest {
	
	@Autowired BoardMapper boardMapper; 
	
	//@Test
	@DisplayName("게시글 등록")
	public void resister() {
		//given
		String title = "등록";		
		
		//빌더로 쓰기
		BoardDTO board = BoardDTO.builder()
								 .title(title)
								 .content("내용")
								 .writer("작성자")
								 .build();
		
		
		//when
		int cnt = boardMapper.insert(board); //결과 int로 반환
		
		//then
		assertThat(cnt).isEqualTo(cnt); //결과값 나왔는지 확인
		
	}
	
	//@Test
	@DisplayName("게시글 수정")
	public void update() {
		//given
		String title = "제목수정";		
		
		//빌더로 쓰기
		BoardDTO board = BoardDTO.builder()
								 .title(title)
								 .content("내용 수정")
								 .writer("작성자 수정")
								 .bno(6L)
								 .build();
		
		
		//when
		int cnt = boardMapper.update(board); //결과 int로 반환
		
		//then
		assertThat(cnt).isEqualTo(cnt); //결과값 나왔는지 확인
		
	}
	
	//@Test
	@DisplayName("게시글 삭제")
	public void delete() {
		//given	
		
		//빌더로 쓰기
		Long bno = 6L;
		
		
		//when
		int cnt = boardMapper.delete(bno); //결과 int로 반환
		
		//then
		log.info("DELETE CNT : "+cnt);
		//assertThat(cnt).isEqualTo(cnt); //결과값 나왔는지 확인
		
	}
	
	//@Test
	@DisplayName("게시글 단건조회")
	public void search() {
		//given
		
		//빌더로 쓰기
		Long bno = 5L;
		
		
		//when
		BoardDTO board = boardMapper.read(bno);
		
		//then
		log.info(board.toString());
		//assertThat(board.getBno(), bno); 
		//assertThat(bno).isEqualTo(board.getBno()); //결과값 나왔는지 확인
		assertThat(board).isNotNull();
		
	}
	
	@Test
	@DisplayName("게시글 전체조회")
	public void testGetList() {
		//given
		BoardSearchDTO search = new BoardSearchDTO();
		search.setStart(1);
		search.setEnd(10);
		
		//빌더로 쓰기
		
		//when
		List<BoardDTO> list = boardMapper.getList(search); //결과 int로 반환
		
		//then
		list.forEach(board -> log.info(board.toString()));
		
		assertThat(list).isNotNull();
		
	}
	//Junit으로 확인
}
