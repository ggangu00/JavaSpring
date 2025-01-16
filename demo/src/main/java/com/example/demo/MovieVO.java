package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieVO {
	private String rnum;
	private String rank;
	private String movieCd;
	private String movieNm;
	@JsonFormat(pattern = "yyyy-MM-dd") //날짜포맷
	private String openDt;
}
