package com.example.demo.book.mapper;

import java.util.List;

import com.example.demo.book.dto.BookDTO;

public interface BookMapper {
	
	int insert(BookDTO bookDTO);
	int update(BookDTO bookDTO);
	int delete(Long bookNo);
	BookDTO read(Long bookNo);
	List<BookDTO> getList();
	List<BookDTO> getRentList();
}
