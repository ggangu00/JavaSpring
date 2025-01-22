package com.example.demo.book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.book.dto.BookDTO;
import com.example.demo.book.mapper.BookMapper;
import com.example.demo.book.service.BookService;

import lombok.RequiredArgsConstructor;

@Service //서비스가 들어오면 무조건 선언해주기
@RequiredArgsConstructor //final 붙은것만 초기화
public class BookServiceImpl implements BookService{

	private final BookMapper bookMapper;
	
	@Override
	public void register(BookDTO book) {
		bookMapper.insert(book);		
	}

	@Override
	public boolean modify(BookDTO book) {
		return bookMapper.update(book) == 1 ? true : false;
	}

	@Override
	public boolean remove(Long bookNo) {
		return bookMapper.delete(bookNo) == 1 ? true : false;
	}

	@Override
	public BookDTO get(Long bookNo) {
		return bookMapper.read(bookNo);
	}

	@Override
	public List<BookDTO> getList() {
		return bookMapper.getList();
	}

	@Override
	public List<BookDTO> getRentList() {
		return bookMapper.getRentList();
	}

}
