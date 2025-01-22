package com.example.demo.book.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor //Builder, All, No 세투세투
public class BookDTO {
	private Long bookNo;
	
	@NotBlank(message = "도서명이 입력되지 않았습니다.")
	private String bookName;
	
	private String bookCoverimg;
	private String bookDate;
	private String bookPrice;
	private String bookPublisher;
	private String bookInfo;
	
	private String rentPrice;
	private String rentCnt;
	
}
