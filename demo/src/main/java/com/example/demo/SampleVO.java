package com.example.demo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleVO {
	@JsonIgnore //@JsonIgnore붙은건 결과에서 제외
	private int mno;
	//@JsonProperty("fname") //@JsonProperty붙은건 fname으로 치환
	private String firstName;
	private String lastName;
	@JsonFormat(pattern = "yyyy-MM-dd") //날짜포맷
	private Date regdate;
}