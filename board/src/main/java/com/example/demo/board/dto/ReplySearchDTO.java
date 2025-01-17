package com.example.demo.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplySearchDTO {
	int page = 1;
	int amount = 3;
	
	public int getStart() {
		return (page-1)*amount +1;
	}
	public int getEnd() {
		return page*amount;
	}
	
}
