package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.BookMapper;
import com.example.demo.service.BookDTO;
import com.example.demo.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookMapper mapper;
	
	@Override
	public List<BookDTO> getList() {
		return mapper.getList();
	}

	@Override
	public void insert(BookDTO bookDTO) {
		mapper.insert(bookDTO);
	}

	@Override
	public List<BookDTO> getListde() {
		return mapper.getListde();
	}

}
