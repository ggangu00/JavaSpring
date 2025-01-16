package com.example.demo.board.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor //Builder, All, No 세투세투
public class BoardDTO {
	private Long bno;
	
	@NotBlank(message = "제목을 입력해주세요")
	private String title;
	
	@NotBlank(message = "내용을 입력해주세요")
	private String content;
	
	@NotBlank(message = "작성자를 입력해주세요")
	private String writer;
	
	private String regdate;
	
}
