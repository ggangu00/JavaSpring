package com.example.demo.book.service;

import java.util.List;

import com.example.demo.book.dto.BookDTO;

public interface BookService {
	
	public void register(BookDTO book);

	public boolean modify(BookDTO book);

	public boolean remove(Long bookNo);

	public BookDTO get(Long bookNo);

	public List<BookDTO> getList();
	public List<BookDTO> getRentList();
	
}
