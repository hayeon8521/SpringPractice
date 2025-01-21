package com.example.demo.mapper;

import java.util.List;

import com.example.demo.service.BookDTO;

public interface BookMapper {
	public List<BookDTO> getList();
	
	public void insert(BookDTO bookDTO);
	
	public List<BookDTO> getListde(); 
}
